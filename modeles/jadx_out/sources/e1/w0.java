package e1;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w0 extends e2 {

    /* renamed from: l, reason: collision with root package name */
    public char f4336l;

    /* renamed from: m, reason: collision with root package name */
    public long f4337m;

    /* renamed from: n, reason: collision with root package name */
    public String f4338n;

    /* renamed from: o, reason: collision with root package name */
    public final u0 f4339o;

    /* renamed from: p, reason: collision with root package name */
    public final u0 f4340p;

    /* renamed from: q, reason: collision with root package name */
    public final u0 f4341q;

    /* renamed from: r, reason: collision with root package name */
    public final u0 f4342r;

    /* renamed from: s, reason: collision with root package name */
    public final u0 f4343s;

    /* renamed from: t, reason: collision with root package name */
    public final u0 f4344t;

    /* renamed from: u, reason: collision with root package name */
    public final u0 f4345u;
    public final u0 v;

    /* renamed from: w, reason: collision with root package name */
    public final u0 f4346w;

    public w0(t1 t1Var) {
        super(t1Var);
        this.f4336l = (char) 0;
        this.f4337m = -1L;
        this.f4339o = new u0(this, 6, false, false);
        this.f4340p = new u0(this, 6, true, false);
        this.f4341q = new u0(this, 6, false, true);
        this.f4342r = new u0(this, 5, false, false);
        this.f4343s = new u0(this, 5, true, false);
        this.f4344t = new u0(this, 5, false, true);
        this.f4345u = new u0(this, 4, false, false);
        this.v = new u0(this, 3, false, false);
        this.f4346w = new u0(this, 2, false, false);
    }

    public static v0 o(String str) {
        if (str == null) {
            return null;
        }
        return new v0(str);
    }

    public static String r(boolean z9, String str, Object obj, Object obj2, Object obj3) {
        String s6 = s(obj, z9);
        String s9 = s(obj2, z9);
        String s10 = s(obj3, z9);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(s6)) {
            sb.append(str2);
            sb.append(s6);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(s9)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(s9);
        }
        if (!TextUtils.isEmpty(s10)) {
            sb.append(str3);
            sb.append(s10);
        }
        return sb.toString();
    }

    public static String s(Object obj, boolean z9) {
        int lastIndexOf;
        String className;
        int lastIndexOf2;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z9) {
                return obj.toString();
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return obj.toString();
            }
            char charAt = obj.toString().charAt(0);
            String valueOf = String.valueOf(Math.abs(l10.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            int length = String.valueOf(round).length();
            String str = charAt == '-' ? "-" : "";
            StringBuilder sb = new StringBuilder(str.length() + str.length() + length + 3 + String.valueOf(round2).length());
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof v0 ? ((v0) obj).f4321a : z9 ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z9 ? th.getClass().getName() : th.toString());
        String canonicalName = t1.class.getCanonicalName();
        String substring = (TextUtils.isEmpty(canonicalName) || (lastIndexOf = canonicalName.lastIndexOf(46)) == -1) ? "" : canonicalName.substring(0, lastIndexOf);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length2 = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length2) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                if (((TextUtils.isEmpty(className) || (lastIndexOf2 = className.lastIndexOf(46)) == -1) ? "" : className.substring(0, lastIndexOf2)).equals(substring)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
            }
            i++;
        }
        return sb2.toString();
    }

    @Override // e1.e2
    public final boolean h() {
        return false;
    }

    public final u0 k() {
        return this.f4339o;
    }

    public final u0 l() {
        return this.f4342r;
    }

    public final u0 m() {
        return this.v;
    }

    public final u0 n() {
        return this.f4346w;
    }

    public final void p(int i, boolean z9, boolean z10, String str, Object obj, Object obj2, Object obj3) {
        if (!z9 && Log.isLoggable(q(), i)) {
            Log.println(i, q(), r(false, str, obj, obj2, obj3));
        }
        if (z10 || i < 5) {
            return;
        }
        k0.y.g(str);
        q1 q1Var = this.f3875a.f4265p;
        if (q1Var == null) {
            Log.println(6, q(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!q1Var.f3903b) {
                Log.println(6, q(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i >= 9) {
                i = 8;
            }
            q1Var.p(new t0(this, i, str, obj, obj2, obj3));
        }
    }

    public final String q() {
        String str;
        synchronized (this) {
            try {
                if (this.f4338n == null) {
                    this.f3875a.f4262m.f3875a.getClass();
                    this.f4338n = "FA";
                }
                k0.y.g(this.f4338n);
                str = this.f4338n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
