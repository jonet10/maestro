package androidx.privacysandbox.ads.adservices.adid;

import android.content.Context;
import d7.l;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AdIdManager$Companion$obtain$1 extends m implements l {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdIdManager$Companion$obtain$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // d7.l
    public final AdIdManagerApi31Ext9Impl invoke(Context context) {
        context.getClass();
        return new AdIdManagerApi31Ext9Impl(this.$context);
    }
}
