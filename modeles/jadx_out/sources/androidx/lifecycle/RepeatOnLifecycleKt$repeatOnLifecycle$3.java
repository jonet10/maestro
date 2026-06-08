package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d7.p;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.x;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {83}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends v6.i implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @v6.e(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {161}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    public static final class AnonymousClass1 extends v6.i implements p {
        final /* synthetic */ a0 $$this$coroutineScope;
        final /* synthetic */ p $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, a0 a0Var, p pVar, t6.c cVar) {
            super(2, cVar);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$$this$coroutineScope = a0Var;
            this.$block = pVar;
        }

        @Override // v6.a
        public final t6.c create(Object obj, t6.c cVar) {
            return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, cVar);
        }

        @Override // d7.p
        public final Object invoke(a0 a0Var, t6.c cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:25:? A[SYNTHETIC] */
        @Override // v6.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                int r0 = r13.label
                r1 = 0
                p6.x r2 = p6.x.f8463a
                r3 = 1
                if (r0 == 0) goto L33
                if (r0 != r3) goto L2c
                java.lang.Object r0 = r13.L$5
                d7.p r0 = (d7.p) r0
                java.lang.Object r0 = r13.L$4
                o7.a0 r0 = (o7.a0) r0
                java.lang.Object r0 = r13.L$3
                androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
                java.lang.Object r0 = r13.L$2
                androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                java.lang.Object r0 = r13.L$1
                r3 = r0
                kotlin.jvm.internal.x r3 = (kotlin.jvm.internal.x) r3
                java.lang.Object r0 = r13.L$0
                r4 = r0
                kotlin.jvm.internal.x r4 = (kotlin.jvm.internal.x) r4
                p6.a.e(r14)     // Catch: java.lang.Throwable -> L28
                goto L90
            L28:
                r0 = move-exception
                r14 = r0
                goto La9
            L2c:
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                androidx.privacysandbox.ads.adservices.customaudience.a.i(r14)
                r14 = 0
                return r14
            L33:
                p6.a.e(r14)
                androidx.lifecycle.Lifecycle r14 = r13.$this_repeatOnLifecycle
                androidx.lifecycle.Lifecycle$State r14 = r14.getCurrentState()
                androidx.lifecycle.Lifecycle$State r0 = androidx.lifecycle.Lifecycle.State.DESTROYED
                if (r14 != r0) goto L41
                goto La4
            L41:
                kotlin.jvm.internal.x r6 = new kotlin.jvm.internal.x
                r6.<init>()
                kotlin.jvm.internal.x r14 = new kotlin.jvm.internal.x
                r14.<init>()
                androidx.lifecycle.Lifecycle$State r0 = r13.$state     // Catch: java.lang.Throwable -> La5
                androidx.lifecycle.Lifecycle r12 = r13.$this_repeatOnLifecycle     // Catch: java.lang.Throwable -> La5
                o7.a0 r7 = r13.$$this$coroutineScope     // Catch: java.lang.Throwable -> La5
                d7.p r11 = r13.$block     // Catch: java.lang.Throwable -> La5
                r13.L$0 = r6     // Catch: java.lang.Throwable -> La5
                r13.L$1 = r14     // Catch: java.lang.Throwable -> La5
                r13.L$2 = r0     // Catch: java.lang.Throwable -> La5
                r13.L$3 = r12     // Catch: java.lang.Throwable -> La5
                r13.L$4 = r7     // Catch: java.lang.Throwable -> La5
                r13.L$5 = r11     // Catch: java.lang.Throwable -> La5
                r13.label = r3     // Catch: java.lang.Throwable -> La5
                o7.l r9 = new o7.l     // Catch: java.lang.Throwable -> La5
                t6.c r4 = d0.b.I(r13)     // Catch: java.lang.Throwable -> La5
                r9.<init>(r3, r4)     // Catch: java.lang.Throwable -> La5
                r9.s()     // Catch: java.lang.Throwable -> La5
                androidx.lifecycle.Lifecycle$Event$Companion r3 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch: java.lang.Throwable -> La5
                androidx.lifecycle.Lifecycle$Event r5 = r3.upTo(r0)     // Catch: java.lang.Throwable -> La5
                androidx.lifecycle.Lifecycle$Event r8 = r3.downFrom(r0)     // Catch: java.lang.Throwable -> La5
                x7.g r10 = x7.h.a()     // Catch: java.lang.Throwable -> La5
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r4 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch: java.lang.Throwable -> La5
                r4.<init>()     // Catch: java.lang.Throwable -> La5
                r14.f7024a = r4     // Catch: java.lang.Throwable -> La5
                r12.addObserver(r4)     // Catch: java.lang.Throwable -> La5
                java.lang.Object r0 = r9.r()     // Catch: java.lang.Throwable -> La5
                u6.a r3 = u6.a.f10762a
                if (r0 != r3) goto L8e
                return r3
            L8e:
                r3 = r14
                r4 = r6
            L90:
                java.lang.Object r14 = r4.f7024a
                o7.e1 r14 = (o7.e1) r14
                if (r14 == 0) goto L99
                r14.c(r1)
            L99:
                java.lang.Object r14 = r3.f7024a
                androidx.lifecycle.LifecycleEventObserver r14 = (androidx.lifecycle.LifecycleEventObserver) r14
                if (r14 == 0) goto La4
                androidx.lifecycle.Lifecycle r0 = r13.$this_repeatOnLifecycle
                r0.removeObserver(r14)
            La4:
                return r2
            La5:
                r0 = move-exception
                r3 = r14
                r14 = r0
                r4 = r6
            La9:
                java.lang.Object r0 = r4.f7024a
                o7.e1 r0 = (o7.e1) r0
                if (r0 == 0) goto Lb2
                r0.c(r1)
            Lb2:
                java.lang.Object r0 = r3.f7024a
                androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
                if (r0 == 0) goto Lbd
                androidx.lifecycle.Lifecycle r1 = r13.$this_repeatOnLifecycle
                r1.removeObserver(r0)
            Lbd:
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, p pVar, t6.c cVar) {
        super(2, cVar);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = pVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, cVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            a0 a0Var = (a0) this.L$0;
            v7.e eVar = m0.f8288a;
            p7.c cVar = n.f10348a.f8468l;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, a0Var, this.$block, null);
            this.label = 1;
            Object C = c0.C(anonymousClass1, cVar, this);
            u6.a aVar = u6.a.f10762a;
            if (C == aVar) {
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
