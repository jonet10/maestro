package com.google.gson.internal;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public k f3221a;

    /* renamed from: b, reason: collision with root package name */
    public k f3222b = null;

    /* renamed from: l, reason: collision with root package name */
    public int f3223l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ l f3224m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f3225n;

    public i(l lVar, int i) {
        this.f3225n = i;
        this.f3224m = lVar;
        this.f3221a = lVar.f3243o.f3231m;
        this.f3223l = lVar.f3242n;
    }

    public final Object a() {
        return b();
    }

    public final k b() {
        k kVar = this.f3221a;
        l lVar = this.f3224m;
        if (kVar == lVar.f3243o) {
            a.l();
            return null;
        }
        if (lVar.f3242n != this.f3223l) {
            a3.b.i();
            return null;
        }
        this.f3221a = kVar.f3231m;
        this.f3222b = kVar;
        return kVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3221a != this.f3224m.f3243o;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.f3225n) {
            case 1:
                return b().f3233o;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        k kVar = this.f3222b;
        if (kVar == null) {
            throw new IllegalStateException();
        }
        l lVar = this.f3224m;
        lVar.d(kVar, true);
        this.f3222b = null;
        this.f3223l = lVar.f3242n;
    }
}
