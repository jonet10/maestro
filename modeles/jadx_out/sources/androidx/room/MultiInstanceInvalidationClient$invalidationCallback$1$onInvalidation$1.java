package androidx.room;

import d7.p;
import java.util.Arrays;
import java.util.Set;
import o7.a0;
import p6.x;
import q6.j;
import r7.b0;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1", f = "MultiInstanceInvalidationClient.android.kt", l = {87}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1 extends i implements p {
    final /* synthetic */ String[] $tables;
    Object L$0;
    int label;
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(String[] strArr, MultiInstanceInvalidationClient multiInstanceInvalidationClient, t6.c cVar) {
        super(2, cVar);
        this.$tables = strArr;
        this.this$0 = multiInstanceInvalidationClient;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(this.$tables, this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Set<String> n0;
        b0 b0Var;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            String[] strArr = this.$tables;
            n0 = j.n0(Arrays.copyOf(strArr, strArr.length));
            b0Var = this.this$0.invalidatedTables;
            this.L$0 = n0;
            this.label = 1;
            Object emit = b0Var.emit(n0, this);
            u6.a aVar = u6.a.f10762a;
            if (emit == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n0 = (Set) this.L$0;
            p6.a.e(obj);
        }
        this.this$0.getInvalidationTracker().notifyObserversByTableNames$room_runtime_release(n0);
        return x.f8463a;
    }
}
