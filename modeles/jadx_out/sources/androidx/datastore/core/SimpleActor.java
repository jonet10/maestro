package androidx.datastore.core;

import com.google.android.gms.internal.measurement.i5;
import d7.l;
import d7.p;
import j1.b;
import kotlin.jvm.internal.m;
import o7.a0;
import o7.c0;
import o7.e1;
import o7.x;
import q7.i;
import q7.j;
import q7.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SimpleActor<T> {
    private final p consumeMessage;
    private final i messageQueue;
    private final AtomicInt remainingMessages;
    private final a0 scope;

    public SimpleActor(a0 a0Var, l lVar, p pVar, p pVar2) {
        a0Var.getClass();
        lVar.getClass();
        pVar.getClass();
        pVar2.getClass();
        this.scope = a0Var;
        this.consumeMessage = pVar2;
        this.messageQueue = i5.a(Integer.MAX_VALUE, null, 6);
        this.remainingMessages = new AtomicInt(0);
        e1 e1Var = (e1) a0Var.getCoroutineContext().get(x.f8327b);
        if (e1Var != null) {
            e1Var.h(new AnonymousClass1(lVar, this, pVar));
        }
    }

    public final void offer(T t9) {
        Object p10 = this.messageQueue.p(t9);
        if (p10 instanceof j) {
            Throwable th = ((j) p10).f8770a;
            if (th != null) {
                throw th;
            }
            throw new b("Channel was closed normally");
        }
        if (p10 instanceof k) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Check failed.");
        } else if (this.remainingMessages.getAndIncrement() == 0) {
            c0.s(this.scope, null, null, new SimpleActor$offer$2(this, null), 3);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.datastore.core.SimpleActor$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements l {
        final /* synthetic */ l $onComplete;
        final /* synthetic */ p $onUndeliveredElement;
        final /* synthetic */ SimpleActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(l lVar, SimpleActor<T> simpleActor, p pVar) {
            super(1);
            this.$onComplete = lVar;
            this.this$0 = simpleActor;
            this.$onUndeliveredElement = pVar;
        }

        public final void invoke(Throwable th) {
            p6.x xVar;
            this.$onComplete.invoke(th);
            ((SimpleActor) this.this$0).messageQueue.m(th);
            do {
                Object a8 = ((SimpleActor) this.this$0).messageQueue.a();
                xVar = null;
                if (a8 instanceof k) {
                    a8 = null;
                }
                if (a8 != null) {
                    this.$onUndeliveredElement.invoke(a8, th);
                    xVar = p6.x.f8463a;
                }
            } while (xVar != null);
        }

        @Override // d7.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return p6.x.f8463a;
        }
    }
}
