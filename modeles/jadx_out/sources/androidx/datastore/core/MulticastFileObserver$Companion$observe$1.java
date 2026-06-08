package androidx.datastore.core;

import androidx.datastore.core.MulticastFileObserver;
import d0.b;
import d7.p;
import java.io.File;
import kotlin.jvm.internal.m;
import o7.o0;
import p6.x;
import q7.r;
import q7.s;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.MulticastFileObserver$Companion$observe$1", f = "MulticastFileObserver.android.kt", l = {84, 85}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MulticastFileObserver$Companion$observe$1 extends i implements p {
    final /* synthetic */ File $file;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MulticastFileObserver$Companion$observe$1(File file, c cVar) {
        super(2, cVar);
        this.$file = file;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        MulticastFileObserver$Companion$observe$1 multicastFileObserver$Companion$observe$1 = new MulticastFileObserver$Companion$observe$1(this.$file, cVar);
        multicastFileObserver$Companion$observe$1.L$0 = obj;
        return multicastFileObserver$Companion$observe$1;
    }

    @Override // d7.p
    public final Object invoke(s sVar, c cVar) {
        return ((MulticastFileObserver$Companion$observe$1) create(sVar, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        o0 observe;
        s sVar;
        int i = this.label;
        x xVar = x.f8463a;
        u6.a aVar = u6.a.f10762a;
        if (i == 0) {
            p6.a.e(obj);
            s sVar2 = (s) this.L$0;
            MulticastFileObserver$Companion$observe$1$flowObserver$1 multicastFileObserver$Companion$observe$1$flowObserver$1 = new MulticastFileObserver$Companion$observe$1$flowObserver$1(this.$file, sVar2);
            MulticastFileObserver.Companion companion = MulticastFileObserver.Companion;
            File parentFile = this.$file.getParentFile();
            parentFile.getClass();
            observe = companion.observe(parentFile, multicastFileObserver$Companion$observe$1$flowObserver$1);
            this.L$0 = sVar2;
            this.L$1 = observe;
            this.label = 1;
            if (((r) sVar2).f8779m.e(xVar, this) != aVar) {
                sVar = sVar2;
            }
        }
        if (i != 1) {
            if (i == 2) {
                p6.a.e(obj);
                return xVar;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        observe = (o0) this.L$1;
        sVar = (s) this.L$0;
        p6.a.e(obj);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(observe);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        return b.o(sVar, anonymousClass1, this) == aVar ? aVar : xVar;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.datastore.core.MulticastFileObserver$Companion$observe$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements d7.a {
        final /* synthetic */ o0 $disposeListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(o0 o0Var) {
            super(0);
            this.$disposeListener = o0Var;
        }

        @Override // d7.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m41invoke();
            return x.f8463a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m41invoke() {
            this.$disposeListener.dispose();
        }
    }
}
