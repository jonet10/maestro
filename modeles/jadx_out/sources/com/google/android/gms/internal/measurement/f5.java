package com.google.android.gms.internal.measurement;

import j$.util.DesugarCollections;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f5 {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2576c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final o6 f2577a = new o6();

    /* renamed from: b, reason: collision with root package name */
    public boolean f2578b;

    static {
        new f5(0);
    }

    public f5(int i) {
        a();
        a();
    }

    public static void b(b5 b5Var, z6 z6Var, int i, Object obj) {
        if (z6Var == z6.f2936m) {
            Charset charset = r5.f2778a;
            b5Var.c(i, 3);
            ((l5) ((s4) obj)).d(b5Var);
            b5Var.c(i, 4);
            return;
        }
        b5Var.c(i, z6Var.f2939b);
        a7 a7Var = a7.f2494a;
        switch (z6Var.ordinal()) {
            case 0:
                b5Var.p(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                b5Var.n(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                b5Var.o(((Long) obj).longValue());
                break;
            case 3:
                b5Var.o(((Long) obj).longValue());
                break;
            case 4:
                b5Var.l(((Integer) obj).intValue());
                break;
            case 5:
                b5Var.p(((Long) obj).longValue());
                break;
            case 6:
                b5Var.n(((Integer) obj).intValue());
                break;
            case 7:
                b5Var.k(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof a5)) {
                    b5Var.r((String) obj);
                    break;
                } else {
                    b5Var.j((a5) obj);
                    break;
                }
            case 9:
                ((l5) ((s4) obj)).d(b5Var);
                break;
            case 10:
                l5 l5Var = (l5) ((s4) obj);
                b5Var.m(l5Var.j());
                l5Var.d(b5Var);
                break;
            case 11:
                if (!(obj instanceof a5)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    b5Var.m(length);
                    b5Var.q(length, bArr);
                    break;
                } else {
                    b5Var.j((a5) obj);
                    break;
                }
            case 12:
                b5Var.m(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof n5)) {
                    b5Var.l(((Integer) obj).intValue());
                    break;
                } else {
                    b5Var.l(((n5) obj).a());
                    break;
                }
            case 14:
                b5Var.n(((Integer) obj).intValue());
                break;
            case 15:
                b5Var.p(((Long) obj).longValue());
                break;
            case 16:
                int intValue = ((Integer) obj).intValue();
                b5Var.m((intValue >> 31) ^ (intValue + intValue));
                break;
            case 17:
                long longValue = ((Long) obj).longValue();
                b5Var.o((longValue >> 63) ^ (longValue + longValue));
                break;
        }
    }

    public final void a() {
        if (this.f2578b) {
            return;
        }
        o6 o6Var = this.f2577a;
        int i = o6Var.f2735b;
        for (int i6 = 0; i6 < i; i6++) {
            Object obj = o6Var.a(i6).f2747b;
            if (obj instanceof l5) {
                l5 l5Var = (l5) obj;
                j6.f2671c.a(l5Var.getClass()).g(l5Var);
                l5Var.f();
            }
        }
        Iterator it = o6Var.c().iterator();
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            if (value instanceof l5) {
                l5 l5Var2 = (l5) value;
                j6.f2671c.a(l5Var2.getClass()).g(l5Var2);
                l5Var2.f();
            }
        }
        if (!o6Var.f2737m) {
            if (o6Var.f2735b > 0) {
                o6Var.a(0).f2746a.getClass();
                com.google.gson.internal.a.o();
                return;
            } else {
                Iterator it2 = o6Var.c().iterator();
                if (it2.hasNext()) {
                    ((Map.Entry) it2.next()).getKey().getClass();
                    com.google.gson.internal.a.o();
                    return;
                }
            }
        }
        if (!o6Var.f2737m) {
            o6Var.f2736l = o6Var.f2736l.isEmpty() ? Collections.EMPTY_MAP : DesugarCollections.unmodifiableMap(o6Var.f2736l);
            o6Var.f2739o = o6Var.f2739o.isEmpty() ? Collections.EMPTY_MAP : DesugarCollections.unmodifiableMap(o6Var.f2739o);
            o6Var.f2737m = true;
        }
        this.f2578b = true;
    }

    public final Object clone() {
        f5 f5Var = new f5();
        o6 o6Var = this.f2577a;
        if (o6Var.f2735b > 0) {
            o6Var.a(0).f2746a.getClass();
            com.google.gson.internal.a.o();
            return null;
        }
        Iterator it = o6Var.c().iterator();
        if (!it.hasNext()) {
            return f5Var;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (entry.getKey() != null) {
            com.google.gson.internal.a.o();
            return null;
        }
        entry.getValue();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f5) {
            return this.f2577a.equals(((f5) obj).f2577a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2577a.hashCode();
    }

    public f5() {
    }
}
