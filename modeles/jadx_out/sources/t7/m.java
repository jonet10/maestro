package t7;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10343e = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(m.class, "_state$volatile");
    public static final f8.w g = new f8.w("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f10344a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10345b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10346c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f10347d;

    public m(int i, boolean z9) {
        this.f10344a = i;
        this.f10345b = z9;
        int i6 = i - 1;
        this.f10346c = i6;
        this.f10347d = new AtomicReferenceArray(i);
        if (i6 > 1073741823) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Check failed.");
            throw null;
        }
        if ((i & i6) == 0) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Check failed.");
        throw null;
    }

    public final int a(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j);
            int i6 = (int) ((1152921503533105152L & j) >> 30);
            int i10 = this.f10346c;
            if (((i6 + 2) & i10) == (i & i10)) {
                return 1;
            }
            boolean z9 = this.f10345b;
            AtomicReferenceArray atomicReferenceArray = this.f10347d;
            if (z9 || atomicReferenceArray.get(i6 & i10) == null) {
                if (f.compareAndSet(this, j, ((-1152921503533105153L) & j) | (((i6 + 1) & 1073741823) << 30))) {
                    atomicReferenceArray.set(i6 & i10, obj);
                    m mVar = this;
                    while ((atomicLongFieldUpdater.get(mVar) & 1152921504606846976L) != 0) {
                        mVar = mVar.c();
                        AtomicReferenceArray atomicReferenceArray2 = mVar.f10347d;
                        int i11 = mVar.f10346c & i6;
                        Object obj2 = atomicReferenceArray2.get(i11);
                        if ((obj2 instanceof l) && ((l) obj2).f10342a == i6) {
                            atomicReferenceArray2.set(i11, obj);
                        } else {
                            mVar = null;
                        }
                        if (mVar == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
            } else {
                int i12 = this.f10344a;
                if (i12 < 1024 || ((i6 - i) & 1073741823) > (i12 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        do {
            atomicLongFieldUpdater = f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, 2305843009213693952L | j));
        return true;
    }

    public final m c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        m mVar;
        while (true) {
            atomicLongFieldUpdater = f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                mVar = this;
                break;
            }
            long j6 = 1152921504606846976L | j;
            mVar = this;
            if (atomicLongFieldUpdater.compareAndSet(mVar, j, j6)) {
                j = j6;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10343e;
            m mVar2 = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar2 != null) {
                return mVar2;
            }
            m mVar3 = new m(mVar.f10344a * 2, mVar.f10345b);
            int i = (int) (1073741823 & j);
            int i6 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i10 = mVar.f10346c;
                int i11 = i & i10;
                if (i11 == (i10 & i6)) {
                    break;
                }
                Object obj = mVar.f10347d.get(i11);
                if (obj == null) {
                    obj = new l(i);
                }
                mVar3.f10347d.set(mVar3.f10346c & i, obj);
                i++;
            }
            atomicLongFieldUpdater.set(mVar3, (-1152921504606846977L) & j);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, mVar3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object d() {
        m mVar = this;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j = atomicLongFieldUpdater.get(mVar);
            if ((j & 1152921504606846976L) != 0) {
                return g;
            }
            int i = (int) (j & 1073741823);
            int i6 = mVar.f10346c;
            int i10 = i & i6;
            if ((((int) ((1152921503533105152L & j) >> 30)) & i6) == i10) {
                break;
            }
            AtomicReferenceArray atomicReferenceArray = mVar.f10347d;
            Object obj = atomicReferenceArray.get(i10);
            boolean z9 = mVar.f10345b;
            if (obj == null) {
                if (z9) {
                    break;
                }
            } else {
                if (obj instanceof l) {
                    break;
                }
                long j6 = (i + 1) & 1073741823;
                if (f.compareAndSet(mVar, j, (j & (-1073741824)) | j6)) {
                    atomicReferenceArray.set(i10, null);
                    return obj;
                }
                mVar = this;
                if (z9) {
                    while (true) {
                        long j10 = atomicLongFieldUpdater.get(mVar);
                        int i11 = (int) (j10 & 1073741823);
                        if ((j10 & 1152921504606846976L) != 0) {
                            mVar = mVar.c();
                        } else {
                            m mVar2 = mVar;
                            if (f.compareAndSet(mVar2, j10, (j10 & (-1073741824)) | j6)) {
                                mVar2.f10347d.set(i11 & mVar2.f10346c, null);
                                mVar = null;
                            } else {
                                mVar = mVar2;
                            }
                        }
                        if (mVar == null) {
                            return obj;
                        }
                    }
                }
            }
        }
        return null;
    }
}
