package androidx.datastore.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import d7.l;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataStoreImpl$doWithWriteFileLock$3", f = "DataStoreImpl.kt", l = {TypedValues.CycleType.TYPE_PATH_ROTATE}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$doWithWriteFileLock$3 extends i implements l {
    final /* synthetic */ l $block;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$doWithWriteFileLock$3(l lVar, c cVar) {
        super(1, cVar);
        this.$block = lVar;
    }

    @Override // v6.a
    public final c create(c cVar) {
        return new DataStoreImpl$doWithWriteFileLock$3(this.$block, cVar);
    }

    @Override // d7.l
    public final Object invoke(c cVar) {
        return ((DataStoreImpl$doWithWriteFileLock$3) create(cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                p6.a.e(obj);
                return obj;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        l lVar = this.$block;
        this.label = 1;
        Object invoke = lVar.invoke(this);
        u6.a aVar = u6.a.f10762a;
        return invoke == aVar ? aVar : invoke;
    }
}
