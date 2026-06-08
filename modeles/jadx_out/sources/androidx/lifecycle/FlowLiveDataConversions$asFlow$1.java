package androidx.lifecycle;

import androidx.appcompat.app.AppCompatDelegate;
import d7.p;
import o7.a0;
import o7.c0;
import o7.m0;
import o7.p1;
import p6.x;
import q7.r;
import q7.s;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {105, 106, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FlowLiveDataConversions$asFlow$1 extends v6.i implements p {
    final /* synthetic */ LiveData<T> $this_asFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @v6.e(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends v6.i implements p {
        final /* synthetic */ Observer<T> $observer;
        final /* synthetic */ LiveData<T> $this_asFlow;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LiveData<T> liveData, Observer<T> observer, t6.c cVar) {
            super(2, cVar);
            this.$this_asFlow = liveData;
            this.$observer = observer;
        }

        @Override // v6.a
        public final t6.c create(Object obj, t6.c cVar) {
            return new AnonymousClass1(this.$this_asFlow, this.$observer, cVar);
        }

        @Override // d7.p
        public final Object invoke(a0 a0Var, t6.c cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
        }

        @Override // v6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
            this.$this_asFlow.observeForever(this.$observer);
            return x.f8463a;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @v6.e(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends v6.i implements p {
        final /* synthetic */ Observer<T> $observer;
        final /* synthetic */ LiveData<T> $this_asFlow;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(LiveData<T> liveData, Observer<T> observer, t6.c cVar) {
            super(2, cVar);
            this.$this_asFlow = liveData;
            this.$observer = observer;
        }

        @Override // v6.a
        public final t6.c create(Object obj, t6.c cVar) {
            return new AnonymousClass2(this.$this_asFlow, this.$observer, cVar);
        }

        @Override // d7.p
        public final Object invoke(a0 a0Var, t6.c cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
        }

        @Override // v6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
            this.$this_asFlow.removeObserver(this.$observer);
            return x.f8463a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asFlow$1(LiveData<T> liveData, t6.c cVar) {
        super(2, cVar);
        this.$this_asFlow = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(s sVar, Object obj) {
        ((r) sVar).p(obj);
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.$this_asFlow, cVar);
        flowLiveDataConversions$asFlow$1.L$0 = obj;
        return flowLiveDataConversions$asFlow$1;
    }

    @Override // d7.p
    public final Object invoke(s sVar, t6.c cVar) {
        return ((FlowLiveDataConversions$asFlow$1) create(sVar, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.lifecycle.Observer, int] */
    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Observer observer;
        ?? r02 = this.label;
        u6.a aVar = u6.a.f10762a;
        try {
        } catch (Throwable th) {
            v7.e eVar = m0.f8288a;
            t6.h plus = n.f10348a.f8468l.plus(p1.f8298a);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_asFlow, r02, null);
            this.L$0 = th;
            this.label = 3;
            if (c0.C(anonymousClass2, plus, this) != aVar) {
                throw th;
            }
        }
        if (r02 == 0) {
            p6.a.e(obj);
            final s sVar = (s) this.L$0;
            observer = new Observer() { // from class: androidx.lifecycle.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    FlowLiveDataConversions$asFlow$1.invokeSuspend$lambda$0(s.this, obj2);
                }
            };
            v7.e eVar2 = m0.f8288a;
            p7.c cVar = n.f10348a.f8468l;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, observer, null);
            this.L$0 = observer;
            this.label = 1;
            if (c0.C(anonymousClass1, cVar, this) == aVar) {
                return aVar;
            }
        } else {
            if (r02 != 1) {
                if (r02 == 2) {
                    p6.a.e(obj);
                    throw new a1.b();
                }
                if (r02 != 3) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                Throwable th2 = (Throwable) this.L$0;
                p6.a.e(obj);
                throw th2;
            }
            observer = (Observer) this.L$0;
            p6.a.e(obj);
        }
        this.L$0 = observer;
        this.label = 2;
        c0.g(this);
        return aVar;
    }
}
