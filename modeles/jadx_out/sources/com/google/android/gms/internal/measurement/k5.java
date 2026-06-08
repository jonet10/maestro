package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class k5 implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final l5 f2686a;

    /* renamed from: b, reason: collision with root package name */
    public l5 f2687b;

    public k5(l5 l5Var) {
        this.f2686a = l5Var;
        if (l5Var.e()) {
            com.google.gson.internal.a.p("Default instance must be immutable.");
            throw null;
        }
        this.f2687b = (l5) l5Var.n(4);
    }

    public static void a(int i, List list) {
        int size = list.size() - i;
        StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 26);
        sb.append("Element at index ");
        sb.append(size);
        sb.append(" is null.");
        String sb2 = sb.toString();
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 < i) {
                throw new NullPointerException(sb2);
            }
            list.remove(size2);
        }
    }

    public final void b() {
        if (this.f2687b.e()) {
            return;
        }
        l5 l5Var = (l5) this.f2686a.n(4);
        j6.f2671c.a(l5Var.getClass()).b(l5Var, this.f2687b);
        this.f2687b = l5Var;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final k5 clone() {
        k5 k5Var = (k5) this.f2686a.n(5);
        boolean e10 = this.f2687b.e();
        l5 l5Var = this.f2687b;
        if (e10) {
            l5Var.getClass();
            j6.f2671c.a(l5Var.getClass()).g(l5Var);
            l5Var.f();
            l5Var = this.f2687b;
        }
        k5Var.f2687b = l5Var;
        return k5Var;
    }

    public final l5 d() {
        boolean e10 = this.f2687b.e();
        l5 l5Var = this.f2687b;
        if (e10) {
            l5Var.getClass();
            j6.f2671c.a(l5Var.getClass()).g(l5Var);
            l5Var.f();
            l5Var = this.f2687b;
        }
        l5Var.getClass();
        boolean z9 = true;
        byte byteValue = ((Byte) l5Var.n(1)).byteValue();
        if (byteValue != 1) {
            if (byteValue == 0) {
                z9 = false;
            } else {
                z9 = j6.f2671c.a(l5Var.getClass()).e(l5Var);
                l5Var.n(2);
            }
        }
        if (z9) {
            return l5Var;
        }
        throw new a1.b("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final void e(l5 l5Var) {
        l5 l5Var2 = this.f2686a;
        if (l5Var2.equals(l5Var)) {
            return;
        }
        if (!this.f2687b.e()) {
            l5 l5Var3 = (l5) l5Var2.n(4);
            j6.f2671c.a(l5Var3.getClass()).b(l5Var3, this.f2687b);
            this.f2687b = l5Var3;
        }
        l5 l5Var4 = this.f2687b;
        j6.f2671c.a(l5Var4.getClass()).b(l5Var4, l5Var);
    }

    public final void f(byte[] bArr, int i, d5 d5Var) {
        if (!this.f2687b.e()) {
            l5 l5Var = (l5) this.f2686a.n(4);
            j6.f2671c.a(l5Var.getClass()).b(l5Var, this.f2687b);
            this.f2687b = l5Var;
        }
        try {
            m6 a8 = j6.f2671c.a(this.f2687b.getClass());
            l5 l5Var2 = this.f2687b;
            v4 v4Var = new v4();
            d5Var.getClass();
            a8.h(l5Var2, bArr, 0, i, v4Var);
        } catch (t5 e10) {
            throw e10;
        } catch (IOException e11) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("Reading from byte array should not throw IOException.", e11);
        } catch (IndexOutOfBoundsException unused) {
            c2.a.i("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }
}
