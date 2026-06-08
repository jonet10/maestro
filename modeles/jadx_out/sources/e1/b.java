package e1;

import com.google.android.gms.internal.measurement.l5;
import j$.util.DesugarCollections;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f3779a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3780b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f3781c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f3782d;

    /* renamed from: e, reason: collision with root package name */
    public Long f3783e;
    public Long f;
    public final /* synthetic */ int g;
    public final /* synthetic */ c h;
    public final l5 i;

    public b(c cVar, String str, int i, l5 l5Var, int i6) {
        this.g = i6;
        this.h = cVar;
        this.f3779a = str;
        this.f3780b = i;
        this.i = l5Var;
    }

    public static Boolean c(Boolean bool, boolean z9) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z9);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Boolean d(String str, com.google.android.gms.internal.measurement.w1 w1Var, w0 w0Var) {
        List t9;
        k0.y.g(w1Var);
        if (str != null && w1Var.o() && w1Var.w() != 1 && (w1Var.w() != 7 ? w1Var.p() : w1Var.u() != 0)) {
            int w2 = w1Var.w();
            boolean s6 = w1Var.s();
            String q9 = (s6 || w2 == 2 || w2 == 7) ? w1Var.q() : w1Var.q().toUpperCase(Locale.ENGLISH);
            if (w1Var.u() == 0) {
                t9 = null;
            } else {
                t9 = w1Var.t();
                if (!s6) {
                    ArrayList arrayList = new ArrayList(t9.size());
                    Iterator it = t9.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                    }
                    t9 = DesugarCollections.unmodifiableList(arrayList);
                }
            }
            String str2 = w2 == 2 ? q9 : null;
            if (w2 != 7 ? q9 != null : t9 != null && !t9.isEmpty()) {
                if (!s6 && w2 != 2) {
                    str = str.toUpperCase(Locale.ENGLISH);
                }
                switch (w2 - 1) {
                    case 1:
                        if (str2 != null) {
                            try {
                                return Boolean.valueOf(Pattern.compile(str2, true != s6 ? 66 : 0).matcher(str).matches());
                            } catch (PatternSyntaxException unused) {
                                if (w0Var != null) {
                                    w0Var.f4342r.c(str2, "Invalid regular expression in REGEXP audience filter. expression");
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        return Boolean.valueOf(str.startsWith(q9));
                    case 3:
                        return Boolean.valueOf(str.endsWith(q9));
                    case 4:
                        return Boolean.valueOf(str.contains(q9));
                    case 5:
                        return Boolean.valueOf(str.equals(q9));
                    case 6:
                        if (t9 != null) {
                            return Boolean.valueOf(t9.contains(str));
                        }
                        break;
                }
            }
        }
        return null;
    }

    public static Boolean e(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.t1 t1Var, double d10) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        k0.y.g(t1Var);
        if (t1Var.o()) {
            if (t1Var.y() != 1 && (t1Var.y() != 5 ? t1Var.r() : t1Var.t() && t1Var.v())) {
                int y9 = t1Var.y();
                try {
                    if (t1Var.y() == 5) {
                        if (a1.M(t1Var.u()) && a1.M(t1Var.w())) {
                            BigDecimal bigDecimal5 = new BigDecimal(t1Var.u());
                            bigDecimal4 = new BigDecimal(t1Var.w());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        }
                    } else if (a1.M(t1Var.s())) {
                        bigDecimal2 = new BigDecimal(t1Var.s());
                        bigDecimal3 = null;
                        bigDecimal4 = null;
                    }
                    if (y9 != 5 ? bigDecimal2 != null : bigDecimal3 != null) {
                        int i = y9 - 1;
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (i == 4 && bigDecimal3 != null) {
                                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0);
                                    }
                                } else if (bigDecimal2 != null) {
                                    if (d10 != 0.0d) {
                                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d10).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d10).multiply(new BigDecimal(2)))) < 0);
                                    }
                                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                                }
                            } else if (bigDecimal2 != null) {
                                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                            }
                        } else if (bigDecimal2 != null) {
                            return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:153:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03c4 A[EDGE_INSN: B:160:0x03c4->B:52:0x03c4 BREAK  A[LOOP:3: B:132:0x0241->B:157:0x0241], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x03d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.Long r22, java.lang.Long r23, com.google.android.gms.internal.measurement.b3 r24, long r25, e1.r r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 1080
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.b.a(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.b3, long, e1.r, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0177 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(java.lang.Long r15, java.lang.Long r16, com.google.android.gms.internal.measurement.s3 r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.b.b(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.s3, boolean):boolean");
    }
}
