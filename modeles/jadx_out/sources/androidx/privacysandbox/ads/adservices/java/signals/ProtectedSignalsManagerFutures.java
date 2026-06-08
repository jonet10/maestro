package androidx.privacysandbox.ads.adservices.java.signals;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager;
import androidx.privacysandbox.ads.adservices.signals.UpdateSignalsRequest;
import kotlin.jvm.internal.g;
import m1.b;
import o7.c0;
import o7.m0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class ProtectedSignalsManagerFutures {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class JavaImpl extends ProtectedSignalsManagerFutures {
        private final ProtectedSignalsManager mProtectedSignalsManager;

        public JavaImpl(ProtectedSignalsManager protectedSignalsManager) {
            this.mProtectedSignalsManager = protectedSignalsManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.signals.ProtectedSignalsManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
        @DoNotInline
        public b updateSignalsAsync(UpdateSignalsRequest updateSignalsRequest) {
            updateSignalsRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(c0.e(c0.b(m0.f8288a), new ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1(this, updateSignalsRequest, null)), null, 1, null);
        }
    }

    public static final ProtectedSignalsManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    public abstract b updateSignalsAsync(UpdateSignalsRequest updateSignalsRequest);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final ProtectedSignalsManagerFutures from(Context context) {
            context.getClass();
            ProtectedSignalsManager obtain = ProtectedSignalsManager.Companion.obtain(context);
            if (obtain != null) {
                return new JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }
}
