package androidx.lifecycle;

import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class c implements d7.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f440a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f441b;

    public /* synthetic */ c(MediatorLiveData mediatorLiveData, int i) {
        this.f440a = i;
        this.f441b = mediatorLiveData;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        x invokeSuspend$lambda$0;
        x switchMap$lambda$0$0;
        x onChanged$lambda$0;
        switch (this.f440a) {
            case 0:
                invokeSuspend$lambda$0 = CoroutineLiveDataKt$addDisposableSource$2.invokeSuspend$lambda$0(this.f441b, obj);
                return invokeSuspend$lambda$0;
            case 1:
                switchMap$lambda$0$0 = Transformations.switchMap$lambda$0$0(this.f441b, obj);
                return switchMap$lambda$0$0;
            default:
                onChanged$lambda$0 = Transformations$switchMap$2.onChanged$lambda$0(this.f441b, obj);
                return onChanged$lambda$0;
        }
    }
}
