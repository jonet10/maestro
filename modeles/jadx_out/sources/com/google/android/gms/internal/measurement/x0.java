package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x0 extends g1 {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f2894n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ k1 f2895o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f2896p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(k1 k1Var, Boolean bool) {
        super(k1Var, true);
        this.f2894n = 2;
        this.f2896p = bool;
        Objects.requireNonNull(k1Var);
        this.f2895o = k1Var;
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        switch (this.f2894n) {
            case 0:
                k0 k0Var = this.f2895o.f;
                k0.y.g(k0Var);
                k0Var.setUserProperty("fcm", "_ln", new s0.b(this.f2896p), true, this.f2592a);
                break;
            case 1:
                k0 k0Var2 = this.f2895o.f;
                k0.y.g(k0Var2);
                k0Var2.setConditionalUserProperty((Bundle) this.f2896p, this.f2592a);
                break;
            case 2:
                k0 k0Var3 = this.f2895o.f;
                k0.y.g(k0Var3);
                k0Var3.setMeasurementEnabled(((Boolean) this.f2896p).booleanValue(), this.f2592a);
                break;
            case 3:
                k0 k0Var4 = this.f2895o.f;
                k0.y.g(k0Var4);
                k0Var4.retrieveAndUploadBatches(new b1(this, (m1.a) this.f2896p));
                break;
            case 4:
                k0 k0Var5 = this.f2895o.f;
                k0.y.g(k0Var5);
                k0Var5.logHealthData(5, "Error with data collection. Data lost.", new s0.b((Exception) this.f2896p), new s0.b(null), new s0.b(null));
                break;
            default:
                k0 k0Var6 = this.f2895o.f;
                k0.y.g(k0Var6);
                k0Var6.registerOnMeasurementEventListener((h1) this.f2896p);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x0(k1 k1Var, Object obj, int i) {
        super(k1Var, true);
        this.f2894n = i;
        this.f2896p = obj;
        this.f2895o = k1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(k1 k1Var, Exception exc) {
        super(k1Var, false);
        this.f2894n = 4;
        this.f2896p = exc;
        this.f2895o = k1Var;
    }
}
