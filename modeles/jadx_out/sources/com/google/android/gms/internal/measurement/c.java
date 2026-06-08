package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f2522a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterator f2523b;

    public c(d dVar, Iterator it, Iterator it2) {
        this.f2522a = it;
        this.f2523b = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f2522a.hasNext()) {
            return true;
        }
        return this.f2523b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Iterator it = this.f2522a;
        if (it.hasNext()) {
            return new q(((Integer) it.next()).toString());
        }
        Iterator it2 = this.f2523b;
        if (it2.hasNext()) {
            return new q((String) it2.next());
        }
        com.google.gson.internal.a.l();
        return null;
    }
}
