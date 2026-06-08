package l7;

import a4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f {

    /* renamed from: d, reason: collision with root package name */
    public static final f f7162d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7163a;

    /* renamed from: b, reason: collision with root package name */
    public final d f7164b;

    /* renamed from: c, reason: collision with root package name */
    public final e f7165c;

    static {
        d dVar = d.f7159a;
        e eVar = e.f7160b;
        f7162d = new f(false, dVar, eVar);
        new f(true, dVar, eVar);
    }

    public f(boolean z9, d dVar, e eVar) {
        dVar.getClass();
        eVar.getClass();
        this.f7163a = z9;
        this.f7164b = dVar;
        this.f7165c = eVar;
    }

    public final String toString() {
        StringBuilder t9 = x.t("HexFormat(\n    upperCase = ");
        t9.append(this.f7163a);
        t9.append(",\n    bytes = BytesHexFormat(\n");
        this.f7164b.a("        ", t9);
        t9.append('\n');
        t9.append("    ),");
        t9.append('\n');
        t9.append("    number = NumberHexFormat(");
        t9.append('\n');
        this.f7165c.a("        ", t9);
        t9.append('\n');
        t9.append("    )");
        t9.append('\n');
        t9.append(")");
        return t9.toString();
    }
}
