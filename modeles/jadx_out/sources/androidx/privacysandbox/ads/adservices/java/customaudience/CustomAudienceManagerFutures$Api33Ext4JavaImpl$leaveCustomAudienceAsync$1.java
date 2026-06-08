package androidx.privacysandbox.ads.adservices.java.customaudience;

import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.LeaveCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures;
import d7.p;
import o7.a0;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1", f = "CustomAudienceManagerFutures.kt", l = {166}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1 extends i implements p {
    final /* synthetic */ LeaveCustomAudienceRequest $request;
    int label;
    final /* synthetic */ CustomAudienceManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1(CustomAudienceManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, LeaveCustomAudienceRequest leaveCustomAudienceRequest, c cVar) {
        super(2, cVar);
        this.this$0 = api33Ext4JavaImpl;
        this.$request = leaveCustomAudienceRequest;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1(this.this$0, this.$request, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        CustomAudienceManager customAudienceManager;
        int i = this.label;
        if (i == 0) {
            a.e(obj);
            customAudienceManager = this.this$0.mCustomAudienceManager;
            customAudienceManager.getClass();
            LeaveCustomAudienceRequest leaveCustomAudienceRequest = this.$request;
            this.label = 1;
            Object leaveCustomAudience = customAudienceManager.leaveCustomAudience(leaveCustomAudienceRequest, this);
            u6.a aVar = u6.a.f10762a;
            if (leaveCustomAudience == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a.e(obj);
        }
        return x.f8463a;
    }
}
