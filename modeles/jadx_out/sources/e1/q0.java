package e1;

import android.os.Bundle;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q0 {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f4198b = new AtomicReference();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference f4199c = new AtomicReference();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReference f4200d = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    public final i1 f4201a;

    public q0(i1 i1Var) {
        this.f4201a = i1Var;
    }

    public static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        k0.y.g(atomicReference);
        k0.y.b(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (Objects.equals(str, strArr[i])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i];
                        if (str2 == null) {
                            str2 = strArr2[i] + "(" + strArr[i] + ")";
                            strArr3[i] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        return !this.f4201a.a() ? str : g(str, k2.f4074c, k2.f4072a, f4198b);
    }

    public final String b(String str) {
        if (str == null) {
            return null;
        }
        return !this.f4201a.a() ? str : g(str, k2.f, k2.f4076e, f4199c);
    }

    public final String c(String str) {
        if (str == null) {
            return null;
        }
        return !this.f4201a.a() ? str : str.startsWith("_exp_") ? androidx.lifecycle.l.w("experiment_id(", str, ")") : g(str, k2.j, k2.i, f4200d);
    }

    public final String d(u uVar) {
        i1 i1Var = this.f4201a;
        if (!i1Var.a()) {
            return uVar.toString();
        }
        StringBuilder sb = new StringBuilder("origin=");
        sb.append(uVar.f4291l);
        sb.append(",name=");
        sb.append(a(uVar.f4289a));
        sb.append(",params=");
        t tVar = uVar.f4290b;
        sb.append(tVar == null ? null : !i1Var.a() ? tVar.f4251a.toString() : e(tVar.g()));
        return sb.toString();
    }

    public final String e(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.f4201a.a()) {
            return bundle.toString();
        }
        StringBuilder t9 = a4.x.t("Bundle[{");
        for (String str : bundle.keySet()) {
            if (t9.length() != 8) {
                t9.append(", ");
            }
            t9.append(b(str));
            t9.append("=");
            Object obj = bundle.get(str);
            t9.append(obj instanceof Bundle ? f(new Object[]{obj}) : obj instanceof Object[] ? f((Object[]) obj) : obj instanceof ArrayList ? f(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        t9.append("}]");
        return t9.toString();
    }

    public final String f(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder t9 = a4.x.t("[");
        for (Object obj : objArr) {
            String e10 = obj instanceof Bundle ? e((Bundle) obj) : String.valueOf(obj);
            if (e10 != null) {
                if (t9.length() != 1) {
                    t9.append(", ");
                }
                t9.append(e10);
            }
        }
        t9.append("]");
        return t9.toString();
    }
}
