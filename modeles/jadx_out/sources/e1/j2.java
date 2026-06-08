package e1;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j2 {

    /* renamed from: c, reason: collision with root package name */
    public static final j2 f4054c = new j2(100);

    /* renamed from: a, reason: collision with root package name */
    public final EnumMap f4055a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4056b;

    public j2(int i) {
        EnumMap enumMap = new EnumMap(i2.class);
        this.f4055a = enumMap;
        i2 i2Var = i2.AD_STORAGE;
        g2 g2Var = g2.UNINITIALIZED;
        enumMap.put((EnumMap) i2Var, (i2) g2Var);
        enumMap.put((EnumMap) i2.ANALYTICS_STORAGE, (i2) g2Var);
        this.f4056b = i;
    }

    public static String a(int i) {
        return i != -30 ? i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static j2 b(int i, Bundle bundle) {
        if (bundle == null) {
            return new j2(i);
        }
        EnumMap enumMap = new EnumMap(i2.class);
        for (i2 i2Var : h2.STORAGE.f4020a) {
            enumMap.put((EnumMap) i2Var, (i2) d(bundle.getString(i2Var.f4038a)));
        }
        return new j2(enumMap, i);
    }

    public static j2 c(int i, String str) {
        EnumMap enumMap = new EnumMap(i2.class);
        i2[] i2VarArr = h2.STORAGE.f4020a;
        for (int i6 = 0; i6 < i2VarArr.length; i6++) {
            String str2 = str == null ? "" : str;
            i2 i2Var = i2VarArr[i6];
            int i10 = i6 + 2;
            if (i10 < str2.length()) {
                enumMap.put((EnumMap) i2Var, (i2) e(str2.charAt(i10)));
            } else {
                enumMap.put((EnumMap) i2Var, (i2) g2.UNINITIALIZED);
            }
        }
        return new j2(enumMap, i);
    }

    public static g2 d(String str) {
        g2 g2Var = g2.UNINITIALIZED;
        return str == null ? g2Var : str.equals("granted") ? g2.GRANTED : str.equals("denied") ? g2.DENIED : g2Var;
    }

    public static g2 e(char c9) {
        return c9 != '+' ? c9 != '0' ? c9 != '1' ? g2.UNINITIALIZED : g2.GRANTED : g2.DENIED : g2.POLICY;
    }

    public static char h(g2 g2Var) {
        if (g2Var == null) {
            return '-';
        }
        int ordinal = g2Var.ordinal();
        if (ordinal == 1) {
            return '+';
        }
        if (ordinal != 2) {
            return ordinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static boolean l(int i, int i6) {
        int i10 = -30;
        if (i == -20) {
            if (i6 == -30) {
                return true;
            }
            i = -20;
        }
        if (i != -30) {
            i10 = i;
        } else if (i6 == -20) {
            return true;
        }
        return i10 == i6 || i < i6;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j2) {
            j2 j2Var = (j2) obj;
            i2[] i2VarArr = h2.STORAGE.f4020a;
            int length = i2VarArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    i2 i2Var = i2VarArr[i];
                    if (this.f4055a.get(i2Var) != j2Var.f4055a.get(i2Var)) {
                        break;
                    }
                    i++;
                } else if (this.f4056b == j2Var.f4056b) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String f() {
        int ordinal;
        StringBuilder sb = new StringBuilder("G1");
        for (i2 i2Var : h2.STORAGE.f4020a) {
            g2 g2Var = (g2) this.f4055a.get(i2Var);
            char c9 = '-';
            if (g2Var != null && (ordinal = g2Var.ordinal()) != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        c9 = '0';
                    } else if (ordinal != 3) {
                    }
                }
                c9 = '1';
            }
            sb.append(c9);
        }
        return sb.toString();
    }

    public final String g() {
        StringBuilder sb = new StringBuilder("G1");
        for (i2 i2Var : h2.STORAGE.f4020a) {
            sb.append(h((g2) this.f4055a.get(i2Var)));
        }
        return sb.toString();
    }

    public final int hashCode() {
        Iterator it = this.f4055a.values().iterator();
        int i = this.f4056b * 17;
        while (it.hasNext()) {
            i = (i * 31) + ((g2) it.next()).hashCode();
        }
        return i;
    }

    public final boolean i(i2 i2Var) {
        return ((g2) this.f4055a.get(i2Var)) != g2.DENIED;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0045 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e1.j2 j(e1.j2 r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<e1.i2> r1 = e1.i2.class
            r0.<init>(r1)
            e1.h2 r1 = e1.h2.STORAGE
            e1.i2[] r1 = r1.f4020a
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L48
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.f4055a
            java.lang.Object r5 = r5.get(r4)
            e1.g2 r5 = (e1.g2) r5
            java.util.EnumMap r6 = r9.f4055a
            java.lang.Object r6 = r6.get(r4)
            e1.g2 r6 = (e1.g2) r6
            if (r5 != 0) goto L24
            goto L31
        L24:
            if (r6 == 0) goto L40
            e1.g2 r7 = e1.g2.UNINITIALIZED
            if (r5 != r7) goto L2b
            goto L31
        L2b:
            if (r6 == r7) goto L40
            e1.g2 r7 = e1.g2.POLICY
            if (r5 != r7) goto L33
        L31:
            r5 = r6
            goto L40
        L33:
            if (r6 == r7) goto L40
            e1.g2 r7 = e1.g2.DENIED
            if (r5 == r7) goto L3f
            if (r6 != r7) goto L3c
            goto L3f
        L3c:
            e1.g2 r5 = e1.g2.GRANTED
            goto L40
        L3f:
            r5 = r7
        L40:
            if (r5 == 0) goto L45
            r0.put(r4, r5)
        L45:
            int r3 = r3 + 1
            goto Ld
        L48:
            e1.j2 r9 = new e1.j2
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.j2.j(e1.j2):e1.j2");
    }

    public final j2 k(j2 j2Var) {
        EnumMap enumMap = new EnumMap(i2.class);
        for (i2 i2Var : h2.STORAGE.f4020a) {
            g2 g2Var = (g2) this.f4055a.get(i2Var);
            if (g2Var == g2.UNINITIALIZED) {
                g2Var = (g2) j2Var.f4055a.get(i2Var);
            }
            if (g2Var != null) {
                enumMap.put((EnumMap) i2Var, (i2) g2Var);
            }
        }
        return new j2(enumMap, this.f4056b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(a(this.f4056b));
        for (i2 i2Var : h2.STORAGE.f4020a) {
            sb.append(",");
            sb.append(i2Var.f4038a);
            sb.append("=");
            g2 g2Var = (g2) this.f4055a.get(i2Var);
            if (g2Var == null) {
                g2Var = g2.UNINITIALIZED;
            }
            sb.append(g2Var);
        }
        return sb.toString();
    }

    public j2(EnumMap enumMap, int i) {
        EnumMap enumMap2 = new EnumMap(i2.class);
        this.f4055a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f4056b = i;
    }
}
