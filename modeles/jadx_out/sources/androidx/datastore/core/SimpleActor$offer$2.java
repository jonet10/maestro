package androidx.datastore.core;

import d7.p;
import o7.a0;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {121, 121}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SimpleActor$offer$2 extends i implements p {
    Object L$0;
    int label;
    final /* synthetic */ SimpleActor<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleActor$offer$2(SimpleActor<T> simpleActor, c cVar) {
        super(2, cVar);
        this.this$0 = simpleActor;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new SimpleActor$offer$2(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((SimpleActor$offer$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005b, code lost:
    
        if (r0.invoke(r6, r5) == r3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005d, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004f, code lost:
    
        if (r6 != r3) goto L16;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x005b -> B:6:0x005e). Please report as a decompilation issue!!! */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = r5.label
            r1 = 2
            r2 = 1
            u6.a r3 = u6.a.f10762a
            if (r0 == 0) goto L1f
            if (r0 == r2) goto L17
            if (r0 != r1) goto L10
            p6.a.e(r6)
            goto L5e
        L10:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
        L15:
            r6 = 0
            return r6
        L17:
            java.lang.Object r0 = r5.L$0
            d7.p r0 = (d7.p) r0
            p6.a.e(r6)
            goto L52
        L1f:
            p6.a.e(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            androidx.datastore.core.AtomicInt r6 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r6)
            int r6 = r6.get()
            if (r6 <= 0) goto L6d
        L2e:
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            o7.a0 r6 = androidx.datastore.core.SimpleActor.access$getScope$p(r6)
            t6.h r6 = r6.getCoroutineContext()
            o7.c0.k(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            d7.p r0 = androidx.datastore.core.SimpleActor.access$getConsumeMessage$p(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            q7.i r6 = androidx.datastore.core.SimpleActor.access$getMessageQueue$p(r6)
            r5.L$0 = r0
            r5.label = r2
            java.lang.Object r6 = r6.l(r5)
            if (r6 != r3) goto L52
            goto L5d
        L52:
            r4 = 0
            r5.L$0 = r4
            r5.label = r1
            java.lang.Object r6 = r0.invoke(r6, r5)
            if (r6 != r3) goto L5e
        L5d:
            return r3
        L5e:
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            androidx.datastore.core.AtomicInt r6 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r6)
            int r6 = r6.decrementAndGet()
            if (r6 != 0) goto L2e
            p6.x r6 = p6.x.f8463a
            return r6
        L6d:
            java.lang.String r6 = "Check failed."
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
