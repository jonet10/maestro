package com.google.android.gms.internal.measurement;

import j$.util.Objects;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q6 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f2764a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2765b;

    /* renamed from: l, reason: collision with root package name */
    public Iterator f2766l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ o6 f2767m;

    public /* synthetic */ q6(o6 o6Var) {
        Objects.requireNonNull(o6Var);
        this.f2767m = o6Var;
        this.f2764a = -1;
    }

    public final Iterator a() {
        if (this.f2766l == null) {
            this.f2766l = this.f2767m.f2736l.entrySet().iterator();
        }
        return this.f2766l;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f2764a + 1;
        o6 o6Var = this.f2767m;
        if (i >= o6Var.f2735b) {
            return !o6Var.f2736l.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f2765b = true;
        int i = this.f2764a + 1;
        this.f2764a = i;
        o6 o6Var = this.f2767m;
        return i < o6Var.f2735b ? (p6) o6Var.f2734a[i] : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f2765b) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("remove() was called before next()");
            return;
        }
        this.f2765b = false;
        o6 o6Var = this.f2767m;
        o6Var.g();
        int i = this.f2764a;
        if (i >= o6Var.f2735b) {
            a().remove();
        } else {
            this.f2764a = i - 1;
            o6Var.e(i);
        }
    }
}
