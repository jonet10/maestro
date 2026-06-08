package androidx.privacysandbox.ads.adservices.measurement;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.arch.core.executor.a;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import d0.b;
import o7.c0;
import o7.l;
import p6.x;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 5), @RequiresExtension(extension = 31, version = 9)})
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class MeasurementManagerImplCommon extends MeasurementManager {
    private final android.adservices.measurement.MeasurementManager mMeasurementManager;

    public MeasurementManagerImplCommon(android.adservices.measurement.MeasurementManager measurementManager) {
        measurementManager.getClass();
        this.mMeasurementManager = measurementManager;
    }

    @DoNotInline
    public static Object deleteRegistrations$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, DeletionRequest deletionRequest, c cVar) {
        l lVar = new l(1, b.I(cVar));
        lVar.s();
        measurementManagerImplCommon.getMMeasurementManager().deleteRegistrations(deletionRequest.convertToAdServices$ads_adservices_release(), new a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
        Object r9 = lVar.r();
        return r9 == u6.a.f10762a ? r9 : x.f8463a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public static Object getMeasurementApiStatus$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, c cVar) {
        l lVar = new l(1, b.I(cVar));
        lVar.s();
        measurementManagerImplCommon.getMMeasurementManager().getMeasurementApiStatus(new a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
        return lVar.r();
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public static Object registerSource$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, InputEvent inputEvent, c cVar) {
        l lVar = new l(1, b.I(cVar));
        lVar.s();
        measurementManagerImplCommon.getMMeasurementManager().registerSource(uri, inputEvent, new a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
        Object r9 = lVar.r();
        return r9 == u6.a.f10762a ? r9 : x.f8463a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public static Object registerTrigger$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, c cVar) {
        l lVar = new l(1, b.I(cVar));
        lVar.s();
        measurementManagerImplCommon.getMMeasurementManager().registerTrigger(uri, new a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
        Object r9 = lVar.r();
        return r9 == u6.a.f10762a ? r9 : x.f8463a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public static Object registerWebSource$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, WebSourceRegistrationRequest webSourceRegistrationRequest, c cVar) {
        l lVar = new l(1, b.I(cVar));
        lVar.s();
        measurementManagerImplCommon.getMMeasurementManager().registerWebSource(webSourceRegistrationRequest.convertToAdServices$ads_adservices_release(), new a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
        Object r9 = lVar.r();
        return r9 == u6.a.f10762a ? r9 : x.f8463a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public static Object registerWebTrigger$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, WebTriggerRegistrationRequest webTriggerRegistrationRequest, c cVar) {
        l lVar = new l(1, b.I(cVar));
        lVar.s();
        measurementManagerImplCommon.getMMeasurementManager().registerWebTrigger(webTriggerRegistrationRequest.convertToAdServices$ads_adservices_release(), new a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
        Object r9 = lVar.r();
        return r9 == u6.a.f10762a ? r9 : x.f8463a;
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @DoNotInline
    public Object deleteRegistrations(DeletionRequest deletionRequest, c cVar) {
        return deleteRegistrations$suspendImpl(this, deletionRequest, cVar);
    }

    public final android.adservices.measurement.MeasurementManager getMMeasurementManager() {
        return this.mMeasurementManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object getMeasurementApiStatus(c cVar) {
        return getMeasurementApiStatus$suspendImpl(this, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object registerSource(Uri uri, InputEvent inputEvent, c cVar) {
        return registerSource$suspendImpl(this, uri, inputEvent, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object registerTrigger(Uri uri, c cVar) {
        return registerTrigger$suspendImpl(this, uri, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object registerWebSource(WebSourceRegistrationRequest webSourceRegistrationRequest, c cVar) {
        return registerWebSource$suspendImpl(this, webSourceRegistrationRequest, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object registerWebTrigger(WebTriggerRegistrationRequest webTriggerRegistrationRequest, c cVar) {
        return registerWebTrigger$suspendImpl(this, webTriggerRegistrationRequest, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @ExperimentalFeatures.RegisterSourceOptIn
    public Object registerSource(SourceRegistrationRequest sourceRegistrationRequest, c cVar) {
        return registerSource$suspendImpl(this, sourceRegistrationRequest, cVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @ExperimentalFeatures.RegisterSourceOptIn
    public static Object registerSource$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, SourceRegistrationRequest sourceRegistrationRequest, c cVar) {
        Object i = c0.i(new MeasurementManagerImplCommon$registerSource$4(sourceRegistrationRequest, measurementManagerImplCommon, null), cVar);
        return i == u6.a.f10762a ? i : x.f8463a;
    }
}
