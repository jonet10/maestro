package o5;

import com.uptodown.workers.GetRemoteInstallWorker;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8177a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GetRemoteInstallWorker f8178b;

    /* renamed from: l, reason: collision with root package name */
    public int f8179l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(GetRemoteInstallWorker getRemoteInstallWorker, t6.c cVar) {
        super(cVar);
        this.f8178b = getRemoteInstallWorker;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f8177a = obj;
        this.f8179l |= Integer.MIN_VALUE;
        return this.f8178b.doWork(this);
    }
}
