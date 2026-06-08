package androidx.privacysandbox.ads.adservices.java.appsetid;

import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures;
import d7.p;
import o7.a0;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1", f = "AppSetIdManagerFutures.kt", l = {49}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1 extends i implements p {
    int label;
    final /* synthetic */ AppSetIdManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(AppSetIdManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, c cVar) {
        super(2, cVar);
        this.this$0 = api33Ext4JavaImpl;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        AppSetIdManager appSetIdManager;
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
        appSetIdManager = this.this$0.mAppSetIdManager;
        this.label = 1;
        Object appSetId = appSetIdManager.getAppSetId(this);
        u6.a aVar = u6.a.f10762a;
        return appSetId == aVar ? aVar : appSetId;
    }
}
