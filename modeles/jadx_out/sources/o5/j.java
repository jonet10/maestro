package o5;

import com.uptodown.workers.MyAppUpdatedWorker;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8187a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyAppUpdatedWorker f8188b;

    /* renamed from: l, reason: collision with root package name */
    public int f8189l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(MyAppUpdatedWorker myAppUpdatedWorker, t6.c cVar) {
        super(cVar);
        this.f8188b = myAppUpdatedWorker;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f8187a = obj;
        this.f8189l |= Integer.MIN_VALUE;
        return this.f8188b.doWork(this);
    }
}
