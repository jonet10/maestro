package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x5 extends h {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f2899l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x5(String str, int i) {
        super(str);
        this.f2899l = i;
    }

    @Override // com.google.android.gms.internal.measurement.h
    public final n a(y2.s sVar, List list) {
        switch (this.f2899l) {
            case 0:
                return n.f2717c;
            case 1:
            case 2:
                return this;
            case 3:
                return new g(Double.valueOf(0.0d));
            default:
                return n.f2717c;
        }
    }
}
