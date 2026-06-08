package o7;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l1 implements b1 {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8283b = AtomicIntegerFieldUpdater.newUpdater(l1.class, "_isCompleting$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8284l = AtomicReferenceFieldUpdater.newUpdater(l1.class, Object.class, "_rootCause$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8285m = AtomicReferenceFieldUpdater.newUpdater(l1.class, Object.class, "_exceptionsHolder$volatile");
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile = 0;
    private volatile /* synthetic */ Object _rootCause$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final o1 f8286a;

    public l1(o1 o1Var, Throwable th) {
        this.f8286a = o1Var;
        this._rootCause$volatile = th;
    }

    public final void a(Throwable th) {
        Throwable d10 = d();
        if (d10 == null) {
            f8284l.set(this, th);
            return;
        }
        if (th == d10) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8285m;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            atomicReferenceFieldUpdater.set(this, th);
            return;
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            } else {
                com.google.gson.internal.a.m(obj, "State is ");
                return;
            }
        }
        if (th == obj) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(th);
        atomicReferenceFieldUpdater.set(this, arrayList);
    }

    @Override // o7.b1
    public final boolean b() {
        return d() == null;
    }

    @Override // o7.b1
    public final o1 c() {
        return this.f8286a;
    }

    public final Throwable d() {
        return (Throwable) f8284l.get(this);
    }

    public final boolean e() {
        return d() != null;
    }

    public final ArrayList f(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8285m;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else {
            if (!(obj instanceof ArrayList)) {
                com.google.gson.internal.a.m(obj, "State is ");
                return null;
            }
            arrayList = (ArrayList) obj;
        }
        Throwable d10 = d();
        if (d10 != null) {
            arrayList.add(0, d10);
        }
        if (th != null && !th.equals(d10)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, c0.h);
        return arrayList;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Finishing[cancelling=");
        sb.append(e());
        sb.append(", completing=");
        sb.append(f8283b.get(this) != 0);
        sb.append(", rootCause=");
        sb.append(d());
        sb.append(", exceptions=");
        sb.append(f8285m.get(this));
        sb.append(", list=");
        sb.append(this.f8286a);
        sb.append(']');
        return sb.toString();
    }
}
