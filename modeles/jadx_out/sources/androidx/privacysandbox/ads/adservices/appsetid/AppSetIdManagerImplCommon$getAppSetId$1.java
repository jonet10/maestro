package androidx.privacysandbox.ads.adservices.appsetid;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon", f = "AppSetIdManagerImplCommon.kt", l = {38}, m = "getAppSetId$suspendImpl")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AppSetIdManagerImplCommon$getAppSetId$1 extends c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppSetIdManagerImplCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSetIdManagerImplCommon$getAppSetId$1(AppSetIdManagerImplCommon appSetIdManagerImplCommon, t6.c cVar) {
        super(cVar);
        this.this$0 = appSetIdManagerImplCommon;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AppSetIdManagerImplCommon.getAppSetId$suspendImpl(this.this$0, this);
    }
}
