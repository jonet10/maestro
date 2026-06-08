package o5;

import com.uptodown.workers.AppUpdatedWorker;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8172a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppUpdatedWorker f8173b;

    /* renamed from: l, reason: collision with root package name */
    public int f8174l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(AppUpdatedWorker appUpdatedWorker, t6.c cVar) {
        super(cVar);
        this.f8173b = appUpdatedWorker;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f8172a = obj;
        this.f8174l |= Integer.MIN_VALUE;
        return this.f8173b.doWork(this);
    }
}
