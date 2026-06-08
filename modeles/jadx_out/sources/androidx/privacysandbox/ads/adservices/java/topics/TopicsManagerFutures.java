package androidx.privacysandbox.ads.adservices.java.topics;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import kotlin.jvm.internal.g;
import m1.b;
import o7.c0;
import o7.m0;
import t7.n;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class TopicsManagerFutures {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class CommonApiJavaImpl extends TopicsManagerFutures {
        private final TopicsManager mTopicsManager;

        public CommonApiJavaImpl(TopicsManager topicsManager) {
            topicsManager.getClass();
            this.mTopicsManager = topicsManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
        @DoNotInline
        public b getTopicsAsync(GetTopicsRequest getTopicsRequest) {
            getTopicsRequest.getClass();
            e eVar = m0.f8288a;
            return CoroutineAdapterKt.asListenableFuture$default(c0.e(c0.b(n.f10348a), new TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(this, getTopicsRequest, null)), null, 1, null);
        }
    }

    public static final TopicsManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    public abstract b getTopicsAsync(GetTopicsRequest getTopicsRequest);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final TopicsManagerFutures from(Context context) {
            context.getClass();
            TopicsManager obtain = TopicsManager.Companion.obtain(context);
            if (obtain != null) {
                return new CommonApiJavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }
}
