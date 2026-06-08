package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f2657a;

    public i(Iterator it) {
        this.f2657a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2657a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return new q((String) this.f2657a.next());
    }
}
