package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e1 extends g1 {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f2550n = 1;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f2551o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f2552p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ boolean f2553q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ k1 f2554r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Object f2555s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(k1 k1Var, String str, String str2, Bundle bundle, boolean z9) {
        super(k1Var, true);
        this.f2551o = str;
        this.f2552p = str2;
        this.f2555s = bundle;
        this.f2553q = z9;
        this.f2554r = k1Var;
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        switch (this.f2550n) {
            case 0:
                k0 k0Var = this.f2554r.f;
                k0.y.g(k0Var);
                k0Var.getUserProperties(this.f2551o, this.f2552p, this.f2553q, (h0) this.f2555s);
                break;
            default:
                long j = this.f2592a;
                k0 k0Var2 = this.f2554r.f;
                k0.y.g(k0Var2);
                k0Var2.logEvent(this.f2551o, this.f2552p, (Bundle) this.f2555s, this.f2553q, true, j);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public void b() {
        switch (this.f2550n) {
            case 0:
                ((h0) this.f2555s).t(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(k1 k1Var, String str, String str2, boolean z9, h0 h0Var) {
        super(k1Var, true);
        this.f2551o = str;
        this.f2552p = str2;
        this.f2553q = z9;
        this.f2555s = h0Var;
        this.f2554r = k1Var;
    }
}
