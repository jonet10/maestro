package androidx.privacysandbox.ads.adservices.java.measurement;

import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest;
import d7.p;
import o7.a0;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1", f = "MeasurementManagerFutures.kt", l = {172}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1 extends i implements p {
    final /* synthetic */ WebSourceRegistrationRequest $request;
    int label;
    final /* synthetic */ MeasurementManagerFutures.Api33Ext5JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1(MeasurementManagerFutures.Api33Ext5JavaImpl api33Ext5JavaImpl, WebSourceRegistrationRequest webSourceRegistrationRequest, c cVar) {
        super(2, cVar);
        this.this$0 = api33Ext5JavaImpl;
        this.$request = webSourceRegistrationRequest;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1(this.this$0, this.$request, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        MeasurementManager measurementManager;
        int i = this.label;
        if (i == 0) {
            a.e(obj);
            measurementManager = this.this$0.mMeasurementManager;
            WebSourceRegistrationRequest webSourceRegistrationRequest = this.$request;
            this.label = 1;
            Object registerWebSource = measurementManager.registerWebSource(webSourceRegistrationRequest, this);
            u6.a aVar = u6.a.f10762a;
            if (registerWebSource == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a.e(obj);
        }
        return x.f8463a;
    }
}
