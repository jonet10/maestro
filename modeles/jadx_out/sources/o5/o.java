package o5;

import com.uptodown.workers.TrackingWorker;
import j5.v;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public x4.p f8203a;

    /* renamed from: b, reason: collision with root package name */
    public v f8204b;

    /* renamed from: l, reason: collision with root package name */
    public int f8205l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8206m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f8207n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ TrackingWorker f8208o;

    /* renamed from: p, reason: collision with root package name */
    public int f8209p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(TrackingWorker trackingWorker, v6.c cVar) {
        super(cVar);
        this.f8208o = trackingWorker;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f8207n = obj;
        this.f8209p |= Integer.MIN_VALUE;
        return this.f8208o.d(this);
    }
}
