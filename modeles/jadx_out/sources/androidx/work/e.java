package androidx.work;

import androidx.work.ListenableWorker;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class e implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f548a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Worker f549b;

    public /* synthetic */ e(Worker worker, int i) {
        this.f548a = i;
        this.f549b = worker;
    }

    @Override // d7.a
    public final Object invoke() {
        ListenableWorker.Result doWork;
        ForegroundInfo foregroundInfo;
        switch (this.f548a) {
            case 0:
                doWork = this.f549b.doWork();
                return doWork;
            default:
                foregroundInfo = this.f549b.getForegroundInfo();
                return foregroundInfo;
        }
    }
}
