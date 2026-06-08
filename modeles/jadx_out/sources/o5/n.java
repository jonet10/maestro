package o5;

import com.uptodown.workers.TrackingWorker;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8200a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TrackingWorker f8201b;

    /* renamed from: l, reason: collision with root package name */
    public int f8202l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(TrackingWorker trackingWorker, t6.c cVar) {
        super(cVar);
        this.f8201b = trackingWorker;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f8200a = obj;
        this.f8202l |= Integer.MIN_VALUE;
        return this.f8201b.doWork(this);
    }
}
