package androidx.privacysandbox.ads.adservices.java.adselection;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures;
import d7.p;
import o7.a0;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1", f = "AdSelectionManagerFutures.kt", l = {373}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1 extends i implements p {
    final /* synthetic */ PersistAdSelectionResultRequest $persistAdSelectionResultRequest;
    int label;
    final /* synthetic */ AdSelectionManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(AdSelectionManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, PersistAdSelectionResultRequest persistAdSelectionResultRequest, c cVar) {
        super(2, cVar);
        this.this$0 = api33Ext4JavaImpl;
        this.$persistAdSelectionResultRequest = persistAdSelectionResultRequest;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(this.this$0, this.$persistAdSelectionResultRequest, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        AdSelectionManager adSelectionManager;
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                a.e(obj);
                return obj;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        a.e(obj);
        adSelectionManager = this.this$0.mAdSelectionManager;
        adSelectionManager.getClass();
        PersistAdSelectionResultRequest persistAdSelectionResultRequest = this.$persistAdSelectionResultRequest;
        this.label = 1;
        Object persistAdSelectionResult = adSelectionManager.persistAdSelectionResult(persistAdSelectionResultRequest, this);
        u6.a aVar = u6.a.f10762a;
        return persistAdSelectionResult == aVar ? aVar : persistAdSelectionResult;
    }
}
