package androidx.room.util;

import d7.l;
import d7.p;
import o7.a0;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.room.util.DBUtil__DBUtil_androidKt$compatCoroutineExecute$2", f = "DBUtil.android.kt", l = {107}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DBUtil__DBUtil_androidKt$compatCoroutineExecute$2 extends i implements p {
    final /* synthetic */ l $block;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$compatCoroutineExecute$2(l lVar, c cVar) {
        super(2, cVar);
        this.$block = lVar;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new DBUtil__DBUtil_androidKt$compatCoroutineExecute$2(this.$block, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((DBUtil__DBUtil_androidKt$compatCoroutineExecute$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
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
        l lVar = this.$block;
        this.label = 1;
        Object invoke = lVar.invoke(this);
        u6.a aVar = u6.a.f10762a;
        return invoke == aVar ? aVar : invoke;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        return this.$block.invoke(this);
    }
}
