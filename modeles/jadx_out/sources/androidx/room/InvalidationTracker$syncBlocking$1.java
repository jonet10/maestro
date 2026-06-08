package androidx.room;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import d7.p;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.InvalidationTracker$syncBlocking$1", f = "InvalidationTracker.android.kt", l = {ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class InvalidationTracker$syncBlocking$1 extends i implements p {
    int label;
    final /* synthetic */ InvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidationTracker$syncBlocking$1(InvalidationTracker invalidationTracker, t6.c cVar) {
        super(2, cVar);
        this.this$0 = invalidationTracker;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new InvalidationTracker$syncBlocking$1(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((InvalidationTracker$syncBlocking$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            InvalidationTracker invalidationTracker = this.this$0;
            this.label = 1;
            Object sync$room_runtime_release = invalidationTracker.sync$room_runtime_release(this);
            u6.a aVar = u6.a.f10762a;
            if (sync$room_runtime_release == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return x.f8463a;
    }
}
