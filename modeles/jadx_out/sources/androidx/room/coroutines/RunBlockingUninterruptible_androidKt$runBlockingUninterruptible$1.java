package androidx.room.coroutines;

import androidx.constraintlayout.widget.ConstraintLayout;
import d7.p;
import o7.a0;
import o7.b0;
import o7.c0;
import o7.m0;
import o7.q;
import o7.r;
import o7.s1;
import o7.u;
import p6.j;
import p6.k;
import p6.x;
import t6.c;
import t6.d;
import t6.f;
import t6.h;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1", f = "RunBlockingUninterruptible.android.kt", l = {}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 extends i implements p {
    final /* synthetic */ p $block;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @e(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1", f = "RunBlockingUninterruptible.android.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m = "invokeSuspend")
    /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ p $block;
        final /* synthetic */ q $deferred;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(q qVar, p pVar, c cVar) {
            super(2, cVar);
            this.$deferred = qVar;
            this.$block = pVar;
        }

        @Override // v6.a
        public final c create(Object obj, c cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$deferred, this.$block, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // d7.p
        public final Object invoke(a0 a0Var, c cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [int] */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        @Override // v6.a
        public final Object invokeSuspend(Object obj) {
            ?? r02 = this.label;
            try {
                if (r02 == 0) {
                    p6.a.e(obj);
                    a0 a0Var = (a0) this.L$0;
                    q qVar = this.$deferred;
                    p pVar = this.$block;
                    this.L$0 = qVar;
                    this.label = 1;
                    obj = pVar.invoke(a0Var, this);
                    u6.a aVar = u6.a.f10762a;
                    r02 = qVar;
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (r02 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    q qVar2 = (q) this.L$0;
                    p6.a.e(obj);
                    r02 = qVar2;
                }
            } catch (Throwable th) {
                obj = new j(th);
            }
            Throwable a8 = k.a(obj);
            r rVar = (r) r02;
            if (a8 == null) {
                rVar.Q(obj);
            } else {
                rVar.getClass();
                rVar.Q(new u(false, a8));
            }
            return x.f8463a;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @e(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2", f = "RunBlockingUninterruptible.android.kt", l = {58}, m = "invokeSuspend")
    /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ q $deferred;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(q qVar, c cVar) {
            super(2, cVar);
            this.$deferred = qVar;
        }

        @Override // v6.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass2(this.$deferred, cVar);
        }

        @Override // d7.p
        public final Object invoke(a0 a0Var, c cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
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
            q qVar = this.$deferred;
            this.label = 1;
            Object w2 = ((r) qVar).w(this);
            u6.a aVar = u6.a.f10762a;
            return w2 == aVar ? aVar : w2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(p pVar, c cVar) {
        super(2, cVar);
        this.$block = pVar;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 = new RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(this.$block, cVar);
        runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1.L$0 = obj;
        return runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1;
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        if (this.label != 0) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        h coroutineContext = ((a0) this.L$0).getCoroutineContext();
        d dVar = d.f10313a;
        f fVar = coroutineContext.get(dVar);
        fVar.getClass();
        t6.e eVar = (t6.e) fVar;
        r a8 = c0.a();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(a8, this.$block, null);
        h l10 = c0.l(t6.i.f10314a, eVar, true);
        v7.e eVar2 = m0.f8288a;
        if (l10 != eVar2 && l10.get(dVar) == null) {
            l10 = l10.plus(eVar2);
        }
        o7.a s1Var = new s1(l10, true);
        s1Var.f0(b0.f8236m, s1Var, anonymousClass1);
        while (!a8.O()) {
            try {
                return c0.w(eVar, new AnonymousClass2(a8, null));
            } catch (InterruptedException unused) {
            }
        }
        return a8.F();
    }
}
