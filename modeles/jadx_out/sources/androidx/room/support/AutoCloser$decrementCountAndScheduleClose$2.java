package androidx.room.support;

import d7.p;
import o7.a0;
import o7.c0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.support.AutoCloser$decrementCountAndScheduleClose$2", f = "AutoCloser.android.kt", l = {167}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AutoCloser$decrementCountAndScheduleClose$2 extends v6.i implements p {
    int label;
    final /* synthetic */ AutoCloser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoCloser$decrementCountAndScheduleClose$2(AutoCloser autoCloser, t6.c cVar) {
        super(2, cVar);
        this.this$0 = autoCloser;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new AutoCloser$decrementCountAndScheduleClose$2(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((AutoCloser$decrementCountAndScheduleClose$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        long j;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            j = this.this$0.autoCloseTimeoutInMs;
            this.label = 1;
            Object j6 = c0.j(j, this);
            u6.a aVar = u6.a.f10762a;
            if (j6 == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        this.this$0.autoCloseDatabase();
        return x.f8463a;
    }
}
