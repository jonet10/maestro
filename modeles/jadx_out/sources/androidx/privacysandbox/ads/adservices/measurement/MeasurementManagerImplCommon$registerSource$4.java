package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import d7.p;
import java.util.Iterator;
import java.util.List;
import o7.a0;
import o7.c0;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerImplCommon$registerSource$4", f = "MeasurementManagerImplCommon.kt", l = {}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MeasurementManagerImplCommon$registerSource$4 extends i implements p {
    final /* synthetic */ SourceRegistrationRequest $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MeasurementManagerImplCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeasurementManagerImplCommon$registerSource$4(SourceRegistrationRequest sourceRegistrationRequest, MeasurementManagerImplCommon measurementManagerImplCommon, c cVar) {
        super(2, cVar);
        this.$request = sourceRegistrationRequest;
        this.this$0 = measurementManagerImplCommon;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        MeasurementManagerImplCommon$registerSource$4 measurementManagerImplCommon$registerSource$4 = new MeasurementManagerImplCommon$registerSource$4(this.$request, this.this$0, cVar);
        measurementManagerImplCommon$registerSource$4.L$0 = obj;
        return measurementManagerImplCommon$registerSource$4;
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((MeasurementManagerImplCommon$registerSource$4) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        if (this.label != 0) {
            a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        a0 a0Var = (a0) this.L$0;
        List<Uri> registrationUris = this.$request.getRegistrationUris();
        MeasurementManagerImplCommon measurementManagerImplCommon = this.this$0;
        SourceRegistrationRequest sourceRegistrationRequest = this.$request;
        Iterator<T> it = registrationUris.iterator();
        while (it.hasNext()) {
            c0.s(a0Var, null, null, new MeasurementManagerImplCommon$registerSource$4$1$1(measurementManagerImplCommon, (Uri) it.next(), sourceRegistrationRequest, null), 3);
        }
        return x.f8463a;
    }
}
