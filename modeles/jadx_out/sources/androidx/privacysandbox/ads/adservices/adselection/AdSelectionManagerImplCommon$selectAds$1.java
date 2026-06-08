package androidx.privacysandbox.ads.adservices.adselection;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon", f = "AdSelectionManagerImplCommon.kt", l = {44}, m = "selectAds$suspendImpl")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AdSelectionManagerImplCommon$selectAds$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdSelectionManagerImplCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSelectionManagerImplCommon$selectAds$1(AdSelectionManagerImplCommon adSelectionManagerImplCommon, t6.c cVar) {
        super(cVar);
        this.this$0 = adSelectionManagerImplCommon;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AdSelectionManagerImplCommon.selectAds$suspendImpl(this.this$0, (AdSelectionConfig) null, this);
    }
}
