package androidx.datastore.core;

import androidx.core.location.LocationRequestCompat;
import d7.p;
import d7.q;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataStoreImpl$data$1", f = "DataStoreImpl.kt", l = {72, 74, 100}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$data$1 extends i implements p {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @e(c = "androidx.datastore.core.DataStoreImpl$data$1$1", f = "DataStoreImpl.kt", l = {LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.DataStoreImpl$data$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DataStoreImpl<T> dataStoreImpl, c cVar) {
            super(2, cVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // v6.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        @Override // d7.p
        public final Object invoke(r7.i iVar, c cVar) {
            return ((AnonymousClass1) create(iVar, cVar)).invokeSuspend(x.f8463a);
        }

        @Override // v6.a
        public final Object invokeSuspend(Object obj) {
            Object incrementCollector;
            int i = this.label;
            if (i == 0) {
                p6.a.e(obj);
                DataStoreImpl<T> dataStoreImpl = this.this$0;
                this.label = 1;
                incrementCollector = dataStoreImpl.incrementCollector(this);
                u6.a aVar = u6.a.f10762a;
                if (incrementCollector == aVar) {
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

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @e(c = "androidx.datastore.core.DataStoreImpl$data$1$2", f = "DataStoreImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.DataStoreImpl$data$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(c cVar) {
            super(2, cVar);
        }

        @Override // v6.a
        public final c create(Object obj, c cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // d7.p
        public final Object invoke(State<T> state, c cVar) {
            return ((AnonymousClass2) create(state, cVar)).invokeSuspend(x.f8463a);
        }

        @Override // v6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label == 0) {
                p6.a.e(obj);
                return Boolean.valueOf(!(((State) this.L$0) instanceof Final));
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @e(c = "androidx.datastore.core.DataStoreImpl$data$1$3", f = "DataStoreImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.DataStoreImpl$data$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends i implements p {
        final /* synthetic */ State<T> $startState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(State<T> state, c cVar) {
            super(2, cVar);
            this.$startState = state;
        }

        @Override // v6.a
        public final c create(Object obj, c cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$startState, cVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // d7.p
        public final Object invoke(State<T> state, c cVar) {
            return ((AnonymousClass3) create(state, cVar)).invokeSuspend(x.f8463a);
        }

        @Override // v6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
            State state = (State) this.L$0;
            return Boolean.valueOf((state instanceof Data) && state.getVersion() <= this.$startState.getVersion());
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @e(c = "androidx.datastore.core.DataStoreImpl$data$1$5", f = "DataStoreImpl.kt", l = {116}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.DataStoreImpl$data$1$5, reason: invalid class name */
    public static final class AnonymousClass5 extends i implements q {
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(DataStoreImpl<T> dataStoreImpl, c cVar) {
            super(3, cVar);
            this.this$0 = dataStoreImpl;
        }

        @Override // d7.q
        public final Object invoke(r7.i iVar, Throwable th, c cVar) {
            return new AnonymousClass5(this.this$0, cVar).invokeSuspend(x.f8463a);
        }

        @Override // v6.a
        public final Object invokeSuspend(Object obj) {
            Object decrementCollector;
            int i = this.label;
            if (i == 0) {
                p6.a.e(obj);
                DataStoreImpl<T> dataStoreImpl = this.this$0;
                this.label = 1;
                decrementCollector = dataStoreImpl.decrementCollector(this);
                u6.a aVar = u6.a.f10762a;
                if (decrementCollector == aVar) {
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
    public DataStoreImpl$data$1(DataStoreImpl<T> dataStoreImpl, c cVar) {
        super(2, cVar);
        this.this$0 = dataStoreImpl;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        DataStoreImpl$data$1 dataStoreImpl$data$1 = new DataStoreImpl$data$1(this.this$0, cVar);
        dataStoreImpl$data$1.L$0 = obj;
        return dataStoreImpl$data$1;
    }

    @Override // d7.p
    public final Object invoke(r7.i iVar, c cVar) {
        return ((DataStoreImpl$data$1) create(iVar, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0072, code lost:
    
        if ((r11 instanceof androidx.datastore.core.Final) != false) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c9  */
    /* JADX WARN: Type inference failed for: r2v11, types: [androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$data$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
