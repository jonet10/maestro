package androidx.privacysandbox.ads.adservices.java.measurement;

import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import d7.p;
import o7.a0;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1", f = "MeasurementManagerFutures.kt", l = {143}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1 extends i implements p {
    final /* synthetic */ Uri $attributionSource;
    final /* synthetic */ InputEvent $inputEvent;
    int label;
    final /* synthetic */ MeasurementManagerFutures.Api33Ext5JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(MeasurementManagerFutures.Api33Ext5JavaImpl api33Ext5JavaImpl, Uri uri, InputEvent inputEvent, c cVar) {
        super(2, cVar);
        this.this$0 = api33Ext5JavaImpl;
        this.$attributionSource = uri;
        this.$inputEvent = inputEvent;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this.this$0, this.$attributionSource, this.$inputEvent, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        MeasurementManager measurementManager;
        int i = this.label;
        if (i == 0) {
            a.e(obj);
            measurementManager = this.this$0.mMeasurementManager;
            Uri uri = this.$attributionSource;
            InputEvent inputEvent = this.$inputEvent;
            this.label = 1;
            Object registerSource = measurementManager.registerSource(uri, inputEvent, this);
            u6.a aVar = u6.a.f10762a;
            if (registerSource == aVar) {
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
