package com.google.android.gms.internal.measurement;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class l5 extends s4 {
    private static final Map zzd = new ConcurrentHashMap();
    private int zzb;
    protected r6 zzc;

    public l5() {
        this.zza = 0;
        this.zzb = -1;
        this.zzc = r6.f;
    }

    public static l5 k(Class cls) {
        Map map = zzd;
        l5 l5Var = (l5) map.get(cls);
        if (l5Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                l5Var = (l5) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (l5Var != null) {
            return l5Var;
        }
        l5 l5Var2 = (l5) ((l5) w6.e(cls)).n(6);
        if (l5Var2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, l5Var2);
        return l5Var2;
    }

    public static void l(Class cls, l5 l5Var) {
        l5Var.f();
        zzd.put(cls, l5Var);
    }

    public static Object m(Method method, l5 l5Var, Object... objArr) {
        try {
            return method.invoke(l5Var, objArr);
        } catch (IllegalAccessException e10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("Couldn't use Java reflection to implement protocol message reflection.", e10);
            return null;
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.m("Unexpected exception thrown by generated accessor method.", cause);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.s4
    public final int b(m6 m6Var) {
        if (e()) {
            int c9 = m6Var.c(this);
            if (c9 >= 0) {
                return c9;
            }
            c2.a.e(String.valueOf(c9).length() + 42, c9);
            return 0;
        }
        int i = this.zzb & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int c10 = m6Var.c(this);
        if (c10 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | c10;
            return c10;
        }
        c2.a.e(String.valueOf(c10).length() + 42, c10);
        return 0;
    }

    public final void d(b5 b5Var) {
        m6 a8 = j6.f2671c.a(getClass());
        z5 z5Var = b5Var.f2512a;
        if (z5Var == null) {
            z5Var = new z5(b5Var);
        }
        a8.d(this, z5Var);
    }

    public final boolean e() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return j6.f2671c.a(getClass()).f(this, (l5) obj);
    }

    public final void f() {
        this.zzb &= Integer.MAX_VALUE;
    }

    public final k5 g() {
        return (k5) n(5);
    }

    public final k5 h() {
        k5 k5Var = (k5) n(5);
        k5Var.e(this);
        return k5Var;
    }

    public final int hashCode() {
        if (e()) {
            return j6.f2671c.a(getClass()).i(this);
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int i6 = j6.f2671c.a(getClass()).i(this);
        this.zza = i6;
        return i6;
    }

    public final void i() {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final int j() {
        if (e()) {
            int c9 = j6.f2671c.a(getClass()).c(this);
            if (c9 >= 0) {
                return c9;
            }
            c2.a.e(String.valueOf(c9).length() + 42, c9);
            return 0;
        }
        int i = this.zzb & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int c10 = j6.f2671c.a(getClass()).c(this);
        if (c10 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | c10;
            return c10;
        }
        c2.a.e(String.valueOf(c10).length() + 42, c10);
        return 0;
    }

    public abstract Object n(int i);

    public final String toString() {
        String obj = super.toString();
        char[] cArr = e6.f2560a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        e6.b(this, sb, 0);
        return sb.toString();
    }
}
