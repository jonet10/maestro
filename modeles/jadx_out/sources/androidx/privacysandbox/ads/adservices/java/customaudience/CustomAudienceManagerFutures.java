package androidx.privacysandbox.ads.adservices.java.customaudience;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.JoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.LeaveCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import kotlin.jvm.internal.g;
import m1.b;
import o7.c0;
import o7.m0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class CustomAudienceManagerFutures {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Api33Ext4JavaImpl extends CustomAudienceManagerFutures {
        private final CustomAudienceManager mCustomAudienceManager;

        public Api33Ext4JavaImpl(CustomAudienceManager customAudienceManager) {
            this.mCustomAudienceManager = customAudienceManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b fetchAndJoinCustomAudienceAsync(FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest) {
            fetchAndJoinCustomAudienceRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(c0.e(c0.b(m0.f8288a), new CustomAudienceManagerFutures$Api33Ext4JavaImpl$fetchAndJoinCustomAudienceAsync$1(this, fetchAndJoinCustomAudienceRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b joinCustomAudienceAsync(JoinCustomAudienceRequest joinCustomAudienceRequest) {
            joinCustomAudienceRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(c0.e(c0.b(m0.f8288a), new CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1(this, joinCustomAudienceRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b leaveCustomAudienceAsync(LeaveCustomAudienceRequest leaveCustomAudienceRequest) {
            leaveCustomAudienceRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(c0.e(c0.b(m0.f8288a), new CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1(this, leaveCustomAudienceRequest, null)), null, 1, null);
        }
    }

    public static final CustomAudienceManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract b fetchAndJoinCustomAudienceAsync(FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract b joinCustomAudienceAsync(JoinCustomAudienceRequest joinCustomAudienceRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract b leaveCustomAudienceAsync(LeaveCustomAudienceRequest leaveCustomAudienceRequest);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final CustomAudienceManagerFutures from(Context context) {
            context.getClass();
            CustomAudienceManager obtain = CustomAudienceManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext4JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }
}
