package androidx.room.support;

import androidx.room.RoomDatabase;
import d7.p;
import java.util.List;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.support.QueryInterceptorStatement$execute$1", f = "QueryInterceptorStatement.android.kt", l = {}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class QueryInterceptorStatement$execute$1 extends v6.i implements p {
    final /* synthetic */ List<Object> $argsCopy;
    int label;
    final /* synthetic */ QueryInterceptorStatement this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryInterceptorStatement$execute$1(QueryInterceptorStatement queryInterceptorStatement, List<? extends Object> list, t6.c cVar) {
        super(2, cVar);
        this.this$0 = queryInterceptorStatement;
        this.$argsCopy = list;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new QueryInterceptorStatement$execute$1(this.this$0, this.$argsCopy, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((QueryInterceptorStatement$execute$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        RoomDatabase.QueryCallback queryCallback;
        String str;
        if (this.label != 0) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        queryCallback = this.this$0.queryCallback;
        str = this.this$0.sqlStatement;
        queryCallback.onQuery(str, this.$argsCopy);
        return x.f8463a;
    }
}
