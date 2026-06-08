#!/usr/bin/env python3
"""Extract readable strings and class-like identifiers from Android DEX files."""
import re
import struct
import sys
from pathlib import Path

DEX_MAGIC = b"dex\n"


def read_uleb128(data: bytes, offset: int) -> tuple[int, int]:
    result = 0
    shift = 0
    while True:
        b = data[offset]
        offset += 1
        result |= (b & 0x7F) << shift
        if (b & 0x80) == 0:
            break
        shift += 7
    return result, offset


def parse_dex_strings(path: Path) -> list[str]:
    data = path.read_bytes()
    if not data.startswith(DEX_MAGIC):
        raise ValueError(f"Not a DEX file: {path}")

    string_ids_size = struct.unpack_from("<I", data, 0x38)[0]
    string_ids_off = struct.unpack_from("<I", data, 0x3C)[0]

    strings: list[str] = []
    for i in range(string_ids_size):
        off = struct.unpack_from("<I", data, string_ids_off + i * 4)[0]
        _, pos = read_uleb128(data, off)
        end = data.index(b"\x00", pos)
        try:
            s = data[pos:end].decode("utf-8", errors="replace")
        except Exception:
            continue
        if s:
            strings.append(s)
    return strings


def classify_strings(strings: list[str]) -> dict[str, list[str]]:
    cats = {
        "classes": [],
        "methods": [],
        "domino_keywords": [],
        "game_keywords": [],
        "packages": [],
        "other_interesting": [],
    }
    domino_re = re.compile(r"domino|tile|bone|pip|spinner|boneyard|draw|pass|score|round|match|turn|player|board|hand|double|block|fives|capot|trick|ai|bot|computer|solo|multi", re.I)
    class_re = re.compile(r"^[A-Za-z_$][\w$]*(\/[A-Za-z_$][\w$]*)+$|^[L][\w$/;]+$")

    seen = set()
    for s in strings:
        if s in seen or len(s) < 3:
            continue
        seen.add(s)

        if "/" in s and (";" in s or s.count("/") >= 2):
            cats["classes"].append(s)
        elif domino_re.search(s):
            cats["domino_keywords"].append(s)
        elif s.startswith("L") and ";" in s:
            cats["classes"].append(s)
        elif "." in s and s[0].islower() and len(s.split(".")) >= 3:
            cats["packages"].append(s)

    return cats


def main() -> int:
    dex_dir = Path(sys.argv[1]) if len(sys.argv) > 1 else Path("modeles")
    out_dir = dex_dir / "dex_analysis"
    out_dir.mkdir(exist_ok=True)

    all_strings: list[str] = []
    for dex in sorted(dex_dir.glob("classes*.dex")):
        print(f"Parsing {dex.name} ({dex.stat().st_size // 1024} KB)...")
        strings = parse_dex_strings(dex)
        all_strings.extend(strings)
        (out_dir / f"{dex.stem}_strings.txt").write_text("\n".join(sorted(set(strings))), encoding="utf-8")
        print(f"  {len(strings)} strings")

    unique = sorted(set(all_strings))
    cats = classify_strings(unique)

    report_lines = [
        "# DEX String Analysis Report",
        "",
        f"Total unique strings: {len(unique)}",
        "",
        "## Domino / Game related strings",
        "",
    ]
    for s in sorted(set(cats["domino_keywords"]))[:500]:
        report_lines.append(f"- {s}")

    report_lines += ["", "## Class descriptors (sample)", ""]
    class_samples = [s for s in unique if s.startswith("L") and ";" in s][:300]
    for s in class_samples:
        report_lines.append(f"- {s}")

    report_lines += ["", "## Package-like identifiers", ""]
    for s in sorted(set(cats["packages"]))[:200]:
        report_lines.append(f"- {s}")

    (out_dir / "STRING_REPORT.md").write_text("\n".join(report_lines), encoding="utf-8")
    print(f"Report written to {out_dir / 'STRING_REPORT.md'}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
