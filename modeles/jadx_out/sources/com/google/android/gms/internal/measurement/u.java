package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f2812a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y2.s f2813b;

    public u(h hVar, y2.s sVar) {
        this.f2812a = hVar;
        this.f2813b = sVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        n nVar = (n) obj;
        n nVar2 = (n) obj2;
        if (nVar instanceof r) {
            return !(nVar2 instanceof r) ? 1 : 0;
        }
        if (nVar2 instanceof r) {
            return -1;
        }
        h hVar = this.f2812a;
        return hVar == null ? nVar.f().compareTo(nVar2.f()) : (int) b2.t1.c0(hVar.a(this.f2813b, Arrays.asList(nVar, nVar2)).g().doubleValue());
    }
}
