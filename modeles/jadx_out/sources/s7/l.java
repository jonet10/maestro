package s7;

import c4.d4;
import c4.j1;
import d7.q;
import o7.c0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends v6.c implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final r7.i f9370a;

    /* renamed from: b, reason: collision with root package name */
    public final t6.h f9371b;

    /* renamed from: l, reason: collision with root package name */
    public final int f9372l;

    /* renamed from: m, reason: collision with root package name */
    public t6.h f9373m;

    /* renamed from: n, reason: collision with root package name */
    public t6.c f9374n;

    public l(r7.i iVar, t6.h hVar) {
        super(j.f9368a, t6.i.f10314a);
        this.f9370a = iVar;
        this.f9371b = hVar;
        this.f9372l = ((Number) hVar.fold(0, new j1(12))).intValue();
    }

    public final Object a(t6.c cVar, Object obj) {
        t6.h context = cVar.getContext();
        c0.k(context);
        t6.h hVar = this.f9373m;
        if (hVar != context) {
            if (hVar instanceof h) {
                throw new IllegalStateException(l7.n.d0("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((h) hVar).f9367b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            if (((Number) context.fold(0, new d4(this, 4))).intValue() != this.f9372l) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f9371b + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.f9373m = context;
        }
        this.f9374n = cVar;
        q qVar = n.f9376a;
        r7.i iVar = this.f9370a;
        iVar.getClass();
        Object invoke = qVar.invoke(iVar, obj, this);
        if (!kotlin.jvm.internal.l.a(invoke, u6.a.f10762a)) {
            this.f9374n = null;
        }
        return invoke;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        try {
            Object a8 = a(cVar, obj);
            return a8 == u6.a.f10762a ? a8 : x.f8463a;
        } catch (Throwable th) {
            this.f9373m = new h(th, cVar.getContext());
            throw th;
        }
    }

    @Override // v6.a, v6.d
    public final v6.d getCallerFrame() {
        t6.c cVar = this.f9374n;
        if (cVar instanceof v6.d) {
            return (v6.d) cVar;
        }
        return null;
    }

    @Override // v6.c, t6.c
    public final t6.h getContext() {
        t6.h hVar = this.f9373m;
        return hVar == null ? t6.i.f10314a : hVar;
    }

    @Override // v6.a
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Throwable a8 = p6.k.a(obj);
        if (a8 != null) {
            this.f9373m = new h(a8, getContext());
        }
        t6.c cVar = this.f9374n;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        return u6.a.f10762a;
    }
}
