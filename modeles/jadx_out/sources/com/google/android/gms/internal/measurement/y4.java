package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y4 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f2912a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f2913b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ a5 f2914l;

    public y4(a5 a5Var) {
        this.f2914l = a5Var;
        this.f2913b = a5Var.d();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2912a < this.f2913b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f2912a;
        if (i < this.f2913b) {
            this.f2912a = i + 1;
            return Byte.valueOf(this.f2914l.c(i));
        }
        com.google.gson.internal.a.l();
        return null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
