package q8;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import m8.c0;
import m8.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f8785a = 0;

    static {
        Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    public static long a(c0 c0Var) {
        String a8 = c0Var.f7697o.a("Content-Length");
        if (a8 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(a8);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean b(c0 c0Var) {
        if (c0Var.f7692a.f7674b.equals("HEAD")) {
            return false;
        }
        int i = c0Var.f7694l;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && a(c0Var) == -1 && !"chunked".equalsIgnoreCase(c0Var.c("Transfer-Encoding"))) ? false : true;
    }

    public static int c(int i, String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0186, code lost:
    
        r17 = r2;
        r34 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x018c, code lost:
    
        if (r20 != Long.MIN_VALUE) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x018e, code lost:
    
        r19 = Long.MIN_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01b5, code lost:
    
        r0 = r36.f7795d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01b9, code lost:
    
        if (r15 != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01bb, code lost:
    
        r15 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01f1, code lost:
    
        if (r0.length() == r15.length()) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01f3, code lost:
    
        r3 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.h;
        r3.getClass();
        r6 = java.net.IDN.toUnicode(r15).split("\\.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0208, code lost:
    
        if (r3.f8386a.get() != false) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0212, code lost:
    
        if (r3.f8386a.compareAndSet(false, true) == false) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0214, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0325, code lost:
    
        if (r0 != null) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0327, code lost:
    
        r9 = 0;
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0381, code lost:
    
        r0 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x022d, code lost:
    
        if (r9 == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x023c, code lost:
    
        r3.f8387b.await();
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0337, code lost:
    
        if (r13 == null) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x033f, code lost:
    
        if (r13.startsWith("/") != false) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0342, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0374, code lost:
    
        r16 = new m8.p(r5, r17, r19, r15, r13, r14, r24, r25, r26);
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0346, code lost:
    
        r0 = r36.i;
        r2 = r0.indexOf(47, r36.f7792a.length() + 3);
        r0 = r0.substring(r2, n8.c.g(r2, r0.length(), r0, "?#"));
        r2 = r0.lastIndexOf(47);
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0369, code lost:
    
        if (r2 == 0) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x036b, code lost:
    
        r0 = r0.substring(0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x036f, code lost:
    
        r13 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0371, code lost:
    
        r0 = "/";
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x01c1, code lost:
    
        if (r0.equals(r15) == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x01c8, code lost:
    
        if (r0.endsWith(r15) == false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x01db, code lost:
    
        if (r0.charAt((r0.length() - r15.length()) - 1) != '.') goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x01e7, code lost:
    
        if (n8.c.g.matcher(r0).matches() != false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0193, code lost:
    
        if (r20 == (-1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x019c, code lost:
    
        if (r20 > 9223372036854775L) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x019e, code lost:
    
        r29 = r20 * 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x01a2, code lost:
    
        r29 = r10 + r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x01a6, code lost:
    
        if (r29 < r10) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x01aa, code lost:
    
        if (r29 <= 253402300799999L) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x01ad, code lost:
    
        r19 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x01b0, code lost:
    
        r19 = 253402300799999L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x01b3, code lost:
    
        r19 = r27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(m8.b r35, m8.u r36, m8.s r37) {
        /*
            Method dump skipped, instructions count: 943
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.c.d(m8.b, m8.u, m8.s):void");
    }

    public static int e(int i, String str, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static Set f(s sVar) {
        Set set = Collections.EMPTY_SET;
        int d10 = sVar.d();
        for (int i = 0; i < d10; i++) {
            if ("Vary".equalsIgnoreCase(sVar.b(i))) {
                String e10 = sVar.e(i);
                if (set.isEmpty()) {
                    set = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : e10.split(",")) {
                    set.add(str.trim());
                }
            }
        }
        return set;
    }
}
