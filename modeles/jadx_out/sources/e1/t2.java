package e1;

import android.os.Bundle;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4275a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4276b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f4277l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Bundle f4278m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f4279n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f4280o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ boolean f4281p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ b3 f4282q;

    public t2(b3 b3Var, String str, String str2, long j, Bundle bundle, boolean z9, boolean z10, boolean z11) {
        this.f4275a = str;
        this.f4276b = str2;
        this.f4277l = j;
        this.f4278m = bundle;
        this.f4279n = z9;
        this.f4280o = z10;
        this.f4281p = z11;
        this.f4282q = b3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4282q.p(this.f4275a, this.f4276b, this.f4277l, this.f4278m, this.f4279n, this.f4280o, this.f4281p);
    }
}
