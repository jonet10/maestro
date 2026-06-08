package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y0 extends g1 {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f2904n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f2905o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f2906p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ k1 f2907q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f2908r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(k1 k1Var, w0 w0Var, String str, String str2) {
        super(k1Var, true);
        this.f2904n = 2;
        this.f2908r = w0Var;
        this.f2905o = str;
        this.f2906p = str2;
        Objects.requireNonNull(k1Var);
        this.f2907q = k1Var;
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        switch (this.f2904n) {
            case 0:
                k0 k0Var = this.f2907q.f;
                k0.y.g(k0Var);
                k0Var.clearConditionalUserProperty(this.f2905o, this.f2906p, (Bundle) this.f2908r);
                break;
            case 1:
                k0 k0Var2 = this.f2907q.f;
                k0.y.g(k0Var2);
                k0Var2.getConditionalUserProperties(this.f2905o, this.f2906p, (h0) this.f2908r);
                break;
            default:
                k0 k0Var3 = this.f2907q.f;
                k0.y.g(k0Var3);
                k0Var3.setCurrentScreenByScionActivityInfo((w0) this.f2908r, this.f2905o, this.f2906p, this.f2592a);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public void b() {
        switch (this.f2904n) {
            case 1:
                ((h0) this.f2908r).t(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y0(k1 k1Var, String str, String str2, Object obj, int i) {
        super(k1Var, true);
        this.f2904n = i;
        this.f2905o = str;
        this.f2906p = str2;
        this.f2908r = obj;
        this.f2907q = k1Var;
    }
}
