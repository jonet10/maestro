package androidx.privacysandbox.ads.adservices.signals;

import android.adservices.signals.UpdateSignalsRequest;
import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.arch.core.executor.a;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import d0.b;
import o7.l;
import p6.x;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@ExperimentalFeatures.Ext12OptIn
@RequiresExtension(extension = 1000000, version = 12)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ProtectedSignalsManagerImpl extends ProtectedSignalsManager {
    private final android.adservices.signals.ProtectedSignalsManager protectedSignalsManager;

    public ProtectedSignalsManagerImpl(android.adservices.signals.ProtectedSignalsManager protectedSignalsManager) {
        protectedSignalsManager.getClass();
        this.protectedSignalsManager = protectedSignalsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.adservices.signals.UpdateSignalsRequest convertUpdateRequest(UpdateSignalsRequest updateSignalsRequest) {
        android.adservices.signals.UpdateSignalsRequest build = new UpdateSignalsRequest.Builder(updateSignalsRequest.getUpdateUri()).build();
        build.getClass();
        return build;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @DoNotInline
    public static Object updateSignals$suspendImpl(ProtectedSignalsManagerImpl protectedSignalsManagerImpl, UpdateSignalsRequest updateSignalsRequest, c cVar) {
        l lVar = new l(1, b.I(cVar));
        lVar.s();
        protectedSignalsManagerImpl.protectedSignalsManager.updateSignals(protectedSignalsManagerImpl.convertUpdateRequest(updateSignalsRequest), new a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
        Object r9 = lVar.r();
        return r9 == u6.a.f10762a ? r9 : x.f8463a;
    }

    @Override // androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @DoNotInline
    public Object updateSignals(UpdateSignalsRequest updateSignalsRequest, c cVar) {
        return updateSignals$suspendImpl(this, updateSignalsRequest, cVar);
    }
}
