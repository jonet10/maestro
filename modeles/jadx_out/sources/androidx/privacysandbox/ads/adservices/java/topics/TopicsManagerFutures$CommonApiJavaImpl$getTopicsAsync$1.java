package androidx.privacysandbox.ads.adservices.java.topics;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import d7.p;
import o7.a0;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1", f = "TopicsManagerFutures.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1 extends i implements p {
    final /* synthetic */ GetTopicsRequest $request;
    int label;
    final /* synthetic */ TopicsManagerFutures.CommonApiJavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(TopicsManagerFutures.CommonApiJavaImpl commonApiJavaImpl, GetTopicsRequest getTopicsRequest, c cVar) {
        super(2, cVar);
        this.this$0 = commonApiJavaImpl;
        this.$request = getTopicsRequest;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(this.this$0, this.$request, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        TopicsManager topicsManager;
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
        topicsManager = this.this$0.mTopicsManager;
        GetTopicsRequest getTopicsRequest = this.$request;
        this.label = 1;
        Object topics = topicsManager.getTopics(getTopicsRequest, this);
        u6.a aVar = u6.a.f10762a;
        return topics == aVar ? aVar : topics;
    }
}
