package androidx.privacysandbox.ads.adservices.customaudience;

import a3.b;
import android.adservices.common.AdData;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import j$.time.TimeConversions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import o7.l;
import p6.x;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CustomAudienceManagerImplCommon extends CustomAudienceManager {
    private final android.adservices.customaudience.CustomAudienceManager customAudienceManager;

    public CustomAudienceManagerImplCommon(android.adservices.customaudience.CustomAudienceManager customAudienceManager) {
        customAudienceManager.getClass();
        this.customAudienceManager = customAudienceManager;
    }

    private final List<AdData> convertAds(List<androidx.privacysandbox.ads.adservices.common.AdData> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<androidx.privacysandbox.ads.adservices.common.AdData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().convertToAdServices$ads_adservices_release());
        }
        return arrayList;
    }

    private final android.adservices.customaudience.CustomAudience convertCustomAudience(CustomAudience customAudience) {
        CustomAudience.Builder activationTime;
        CustomAudience.Builder expirationTime;
        activationTime = new CustomAudience.Builder().setActivationTime(TimeConversions.convert(customAudience.getActivationTime()));
        expirationTime = activationTime.setAds(convertAds(customAudience.getAds())).setBiddingLogicUri(customAudience.getBiddingLogicUri()).setBuyer(customAudience.getBuyer().convertToAdServices$ads_adservices_release()).setDailyUpdateUri(customAudience.getDailyUpdateUri()).setExpirationTime(TimeConversions.convert(customAudience.getExpirationTime()));
        CustomAudience.Builder trustedBiddingData = expirationTime.setName(customAudience.getName()).setTrustedBiddingData(convertTrustedSignals(customAudience.getTrustedBiddingSignals()));
        AdSelectionSignals userBiddingSignals = customAudience.getUserBiddingSignals();
        android.adservices.customaudience.CustomAudience build = trustedBiddingData.setUserBiddingSignals(userBiddingSignals != null ? userBiddingSignals.convertToAdServices$ads_adservices_release() : null).build();
        build.getClass();
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.adservices.customaudience.JoinCustomAudienceRequest convertJoinRequest(JoinCustomAudienceRequest joinCustomAudienceRequest) {
        android.adservices.customaudience.JoinCustomAudienceRequest build = new JoinCustomAudienceRequest.Builder().setCustomAudience(convertCustomAudience(joinCustomAudienceRequest.getCustomAudience())).build();
        build.getClass();
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.adservices.customaudience.LeaveCustomAudienceRequest convertLeaveRequest(LeaveCustomAudienceRequest leaveCustomAudienceRequest) {
        android.adservices.customaudience.LeaveCustomAudienceRequest build = new LeaveCustomAudienceRequest.Builder().setBuyer(leaveCustomAudienceRequest.getBuyer().convertToAdServices$ads_adservices_release()).setName(leaveCustomAudienceRequest.getName()).build();
        build.getClass();
        return build;
    }

    private final android.adservices.customaudience.TrustedBiddingData convertTrustedSignals(TrustedBiddingData trustedBiddingData) {
        if (trustedBiddingData == null) {
            return null;
        }
        return new TrustedBiddingData.Builder().setTrustedBiddingKeys(trustedBiddingData.getTrustedBiddingKeys()).setTrustedBiddingUri(trustedBiddingData.getTrustedBiddingUri()).build();
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public static Object fetchAndJoinCustomAudience$suspendImpl(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, c cVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) {
            Object fetchAndJoinCustomAudience = Ext10Impl.Companion.fetchAndJoinCustomAudience(customAudienceManagerImplCommon.customAudienceManager, fetchAndJoinCustomAudienceRequest, cVar);
            return fetchAndJoinCustomAudience == u6.a.f10762a ? fetchAndJoinCustomAudience : x.f8463a;
        }
        b.r("API is not available. Min version is API 31 ext 10");
        return null;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public static Object joinCustomAudience$suspendImpl(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, JoinCustomAudienceRequest joinCustomAudienceRequest, c cVar) {
        l lVar = new l(1, d0.b.I(cVar));
        lVar.s();
        customAudienceManagerImplCommon.getCustomAudienceManager().joinCustomAudience(customAudienceManagerImplCommon.convertJoinRequest(joinCustomAudienceRequest), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
        Object r9 = lVar.r();
        return r9 == u6.a.f10762a ? r9 : x.f8463a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public static Object leaveCustomAudience$suspendImpl(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, LeaveCustomAudienceRequest leaveCustomAudienceRequest, c cVar) {
        l lVar = new l(1, d0.b.I(cVar));
        lVar.s();
        customAudienceManagerImplCommon.getCustomAudienceManager().leaveCustomAudience(customAudienceManagerImplCommon.convertLeaveRequest(leaveCustomAudienceRequest), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
        Object r9 = lVar.r();
        return r9 == u6.a.f10762a ? r9 : x.f8463a;
    }

    @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object fetchAndJoinCustomAudience(FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, c cVar) {
        return fetchAndJoinCustomAudience$suspendImpl(this, fetchAndJoinCustomAudienceRequest, cVar);
    }

    public final android.adservices.customaudience.CustomAudienceManager getCustomAudienceManager() {
        return this.customAudienceManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object joinCustomAudience(JoinCustomAudienceRequest joinCustomAudienceRequest, c cVar) {
        return joinCustomAudience$suspendImpl(this, joinCustomAudienceRequest, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object leaveCustomAudience(LeaveCustomAudienceRequest leaveCustomAudienceRequest, c cVar) {
        return leaveCustomAudience$suspendImpl(this, leaveCustomAudienceRequest, cVar);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    public static final class Ext10Impl {
        public static final Companion Companion = new Companion(null);

        private Ext10Impl() {
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
            @DoNotInline
            public final Object fetchAndJoinCustomAudience(android.adservices.customaudience.CustomAudienceManager customAudienceManager, FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, c cVar) {
                l lVar = new l(1, d0.b.I(cVar));
                lVar.s();
                customAudienceManager.fetchAndJoinCustomAudience(fetchAndJoinCustomAudienceRequest.convertToAdServices$ads_adservices_release(), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
                Object r9 = lVar.r();
                return r9 == u6.a.f10762a ? r9 : x.f8463a;
            }

            private Companion() {
            }
        }
    }
}
