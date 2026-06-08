package androidx.privacysandbox.ads.adservices.appsetid;

import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.arch.core.executor.a;
import androidx.core.os.OutcomeReceiverKt;
import d0.b;
import o7.l;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
@SuppressLint({"ClassVerificationFailure", "NewApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class AppSetIdManagerImplCommon extends AppSetIdManager {
    private final android.adservices.appsetid.AppSetIdManager mAppSetIdManager;

    public AppSetIdManagerImplCommon(android.adservices.appsetid.AppSetIdManager appSetIdManager) {
        appSetIdManager.getClass();
        this.mAppSetIdManager = appSetIdManager;
    }

    private final AppSetId convertResponse(android.adservices.appsetid.AppSetId appSetId) {
        if (appSetId.getScope() == 1) {
            String id = appSetId.getId();
            id.getClass();
            return new AppSetId(id, 1);
        }
        String id2 = appSetId.getId();
        id2.getClass();
        return new AppSetId(id2, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    @androidx.annotation.DoNotInline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object getAppSetId$suspendImpl(androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon r4, t6.c r5) {
        /*
            boolean r0 = r5 instanceof androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1 r0 = (androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1 r0 = new androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            java.lang.Object r4 = r0.L$0
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon r4 = (androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon) r4
            p6.a.e(r5)
            goto L40
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            r4 = 0
            return r4
        L30:
            p6.a.e(r5)
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r5 = r4.getAppSetIdAsyncInternal(r0)
            u6.a r0 = u6.a.f10762a
            if (r5 != r0) goto L40
            return r0
        L40:
            android.adservices.appsetid.AppSetId r5 = (android.adservices.appsetid.AppSetId) r5
            androidx.privacysandbox.ads.adservices.appsetid.AppSetId r4 = r4.convertResponse(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon.getAppSetId$suspendImpl(androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon, t6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAppSetIdAsyncInternal(c cVar) {
        l lVar = new l(1, b.I(cVar));
        lVar.s();
        this.mAppSetIdManager.getAppSetId(new a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
        return lVar.r();
    }

    @Override // androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager
    @DoNotInline
    public Object getAppSetId(c cVar) {
        return getAppSetId$suspendImpl(this, cVar);
    }
}
