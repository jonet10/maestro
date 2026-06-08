package com.google.android.gms.internal.measurement;

import android.app.Activity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i1 extends g1 {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f2658n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Activity f2659o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ j1 f2660p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(j1 j1Var, Activity activity, int i) {
        super(j1Var.f2667a, true);
        this.f2658n = i;
        switch (i) {
            case 1:
                this.f2659o = activity;
                this.f2660p = j1Var;
                super(j1Var.f2667a, true);
                break;
            case 2:
                this.f2659o = activity;
                this.f2660p = j1Var;
                super(j1Var.f2667a, true);
                break;
            case 3:
                this.f2659o = activity;
                this.f2660p = j1Var;
                super(j1Var.f2667a, true);
                break;
            case 4:
                this.f2659o = activity;
                this.f2660p = j1Var;
                super(j1Var.f2667a, true);
                break;
            default:
                this.f2659o = activity;
                this.f2660p = j1Var;
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        switch (this.f2658n) {
            case 0:
                k0 k0Var = this.f2660p.f2667a.f;
                k0.y.g(k0Var);
                k0Var.onActivityStartedByScionActivityInfo(w0.c(this.f2659o), this.f2593b);
                break;
            case 1:
                k0 k0Var2 = this.f2660p.f2667a.f;
                k0.y.g(k0Var2);
                k0Var2.onActivityResumedByScionActivityInfo(w0.c(this.f2659o), this.f2593b);
                break;
            case 2:
                k0 k0Var3 = this.f2660p.f2667a.f;
                k0.y.g(k0Var3);
                k0Var3.onActivityPausedByScionActivityInfo(w0.c(this.f2659o), this.f2593b);
                break;
            case 3:
                k0 k0Var4 = this.f2660p.f2667a.f;
                k0.y.g(k0Var4);
                k0Var4.onActivityStoppedByScionActivityInfo(w0.c(this.f2659o), this.f2593b);
                break;
            default:
                k0 k0Var5 = this.f2660p.f2667a.f;
                k0.y.g(k0Var5);
                k0Var5.onActivityDestroyedByScionActivityInfo(w0.c(this.f2659o), this.f2593b);
                break;
        }
    }
}
