package t7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import o7.c0;
import o7.k0;
import o7.r0;
import o7.v1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends k0 implements v6.d, t6.c {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10325q = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* renamed from: m, reason: collision with root package name */
    public final o7.w f10326m;

    /* renamed from: n, reason: collision with root package name */
    public final t6.c f10327n;

    /* renamed from: o, reason: collision with root package name */
    public Object f10328o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f10329p;

    public f(o7.w wVar, t6.c cVar) {
        super(-1);
        this.f10326m = wVar;
        this.f10327n = cVar;
        this.f10328o = a.f10316b;
        this.f10329p = a.k(cVar.getContext());
    }

    @Override // v6.d
    public final v6.d getCallerFrame() {
        t6.c cVar = this.f10327n;
        if (cVar instanceof v6.d) {
            return (v6.d) cVar;
        }
        return null;
    }

    @Override // t6.c
    public final t6.h getContext() {
        return this.f10327n.getContext();
    }

    @Override // o7.k0
    public final Object h() {
        Object obj = this.f10328o;
        this.f10328o = a.f10316b;
        return obj;
    }

    @Override // t6.c
    public final void resumeWith(Object obj) {
        Throwable a8 = p6.k.a(obj);
        Object uVar = a8 == null ? obj : new o7.u(false, a8);
        t6.c cVar = this.f10327n;
        t6.h context = cVar.getContext();
        o7.w wVar = this.f10326m;
        if (wVar.isDispatchNeeded(context)) {
            this.f10328o = uVar;
            this.f8272l = 0;
            wVar.dispatch(cVar.getContext(), this);
            return;
        }
        r0 a10 = v1.a();
        if (a10.f8302a >= 4294967296L) {
            this.f10328o = uVar;
            this.f8272l = 0;
            a10.z(this);
            return;
        }
        a10.A(true);
        try {
            t6.h context2 = cVar.getContext();
            Object l10 = a.l(context2, this.f10329p);
            try {
                cVar.resumeWith(obj);
                while (a10.C()) {
                }
            } finally {
                a.g(context2, l10);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f10326m + ", " + c0.z(this.f10327n) + ']';
    }

    @Override // o7.k0
    public final t6.c c() {
        return this;
    }
}
