package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import androidx.core.os.OutcomeReceiverKt;
import d0.b;
import d7.p;
import o7.a0;
import o7.l;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerImplCommon$registerSource$4$1$1", f = "MeasurementManagerImplCommon.kt", l = {131}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MeasurementManagerImplCommon$registerSource$4$1$1 extends i implements p {
    final /* synthetic */ SourceRegistrationRequest $request;
    final /* synthetic */ Uri $uri;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MeasurementManagerImplCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeasurementManagerImplCommon$registerSource$4$1$1(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, SourceRegistrationRequest sourceRegistrationRequest, c cVar) {
        super(2, cVar);
        this.this$0 = measurementManagerImplCommon;
        this.$uri = uri;
        this.$request = sourceRegistrationRequest;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new MeasurementManagerImplCommon$registerSource$4$1$1(this.this$0, this.$uri, this.$request, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((MeasurementManagerImplCommon$registerSource$4$1$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            a.e(obj);
            MeasurementManagerImplCommon measurementManagerImplCommon = this.this$0;
            Uri uri = this.$uri;
            SourceRegistrationRequest sourceRegistrationRequest = this.$request;
            this.L$0 = measurementManagerImplCommon;
            this.L$1 = uri;
            this.L$2 = sourceRegistrationRequest;
            this.label = 1;
            l lVar = new l(1, b.I(this));
            lVar.s();
            measurementManagerImplCommon.getMMeasurementManager().registerSource(uri, sourceRegistrationRequest.getInputEvent(), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
            Object r9 = lVar.r();
            u6.a aVar = u6.a.f10762a;
            if (r9 == aVar) {
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
