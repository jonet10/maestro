package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d7.p;
import o7.a0;
import p6.x;
import q7.r;
import q7.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", l = {92}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FlowExtKt$flowWithLifecycle$1 extends v6.i implements p {
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ r7.h $this_flowWithLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @v6.e(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", l = {92}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends v6.i implements p {
        final /* synthetic */ s $$this$callbackFlow;
        final /* synthetic */ r7.h $this_flowWithLifecycle;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(r7.h hVar, s sVar, t6.c cVar) {
            super(2, cVar);
            this.$this_flowWithLifecycle = hVar;
            this.$$this$callbackFlow = sVar;
        }

        @Override // v6.a
        public final t6.c create(Object obj, t6.c cVar) {
            return new AnonymousClass1(this.$this_flowWithLifecycle, this.$$this$callbackFlow, cVar);
        }

        @Override // d7.p
        public final Object invoke(a0 a0Var, t6.c cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
        }

        @Override // v6.a
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i == 0) {
                p6.a.e(obj);
                r7.h hVar = this.$this_flowWithLifecycle;
                final s sVar = this.$$this$callbackFlow;
                r7.i iVar = new r7.i() { // from class: androidx.lifecycle.FlowExtKt.flowWithLifecycle.1.1.1
                    @Override // r7.i
                    public final Object emit(T t9, t6.c cVar) {
                        Object e10 = ((r) s.this).f8779m.e(t9, cVar);
                        return e10 == u6.a.f10762a ? e10 : x.f8463a;
                    }
                };
                this.label = 1;
                Object collect = hVar.collect(iVar, this);
                u6.a aVar = u6.a.f10762a;
                if (collect == aVar) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowExtKt$flowWithLifecycle$1(Lifecycle lifecycle, Lifecycle.State state, r7.h hVar, t6.c cVar) {
        super(2, cVar);
        this.$lifecycle = lifecycle;
        this.$minActiveState = state;
        this.$this_flowWithLifecycle = hVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        FlowExtKt$flowWithLifecycle$1 flowExtKt$flowWithLifecycle$1 = new FlowExtKt$flowWithLifecycle$1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, cVar);
        flowExtKt$flowWithLifecycle$1.L$0 = obj;
        return flowExtKt$flowWithLifecycle$1;
    }

    @Override // d7.p
    public final Object invoke(s sVar, t6.c cVar) {
        return ((FlowExtKt$flowWithLifecycle$1) create(sVar, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        s sVar;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            sVar = (s) this.L$0;
            Lifecycle lifecycle = this.$lifecycle;
            Lifecycle.State state = this.$minActiveState;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_flowWithLifecycle, sVar, null);
            this.L$0 = sVar;
            this.label = 1;
            Object repeatOnLifecycle = RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, anonymousClass1, this);
            u6.a aVar = u6.a.f10762a;
            if (repeatOnLifecycle == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            sVar = (s) this.L$0;
            p6.a.e(obj);
        }
        ((r) sVar).m(null);
        return x.f8463a;
    }
}
