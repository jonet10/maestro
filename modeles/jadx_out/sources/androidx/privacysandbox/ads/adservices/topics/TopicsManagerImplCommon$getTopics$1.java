package androidx.privacysandbox.ads.adservices.topics;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon", f = "TopicsManagerImplCommon.kt", l = {40}, m = "getTopics$suspendImpl")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TopicsManagerImplCommon$getTopics$1 extends c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TopicsManagerImplCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicsManagerImplCommon$getTopics$1(TopicsManagerImplCommon topicsManagerImplCommon, t6.c cVar) {
        super(cVar);
        this.this$0 = topicsManagerImplCommon;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TopicsManagerImplCommon.getTopics$suspendImpl(this.this$0, null, this);
    }
}
