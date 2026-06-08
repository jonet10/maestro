package w8;

import a4.r0;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class d extends i0 {
    public static final ReentrantLock h;
    public static final Condition i;
    public static final long j;

    /* renamed from: k, reason: collision with root package name */
    public static final long f10950k;

    /* renamed from: l, reason: collision with root package name */
    public static d f10951l;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10952e;
    public d f;
    public long g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        h = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        newCondition.getClass();
        i = newCondition;
        j = 60000L;
        f10950k = 60000000000L;
    }

    public final void h() {
        d dVar;
        long j6 = this.f10965c;
        boolean z9 = this.f10963a;
        if (j6 != 0 || z9) {
            ReentrantLock reentrantLock = h;
            reentrantLock.lock();
            try {
                if (this.f10952e) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.f10952e = true;
                if (f10951l == null) {
                    f10951l = new d();
                    r0 r0Var = new r0("Okio Watchdog");
                    r0Var.setDaemon(true);
                    r0Var.start();
                }
                long nanoTime = System.nanoTime();
                if (j6 != 0 && z9) {
                    this.g = Math.min(j6, c() - nanoTime) + nanoTime;
                } else if (j6 != 0) {
                    this.g = j6 + nanoTime;
                } else {
                    if (!z9) {
                        throw new AssertionError();
                    }
                    this.g = c();
                }
                long j10 = this.g - nanoTime;
                d dVar2 = f10951l;
                dVar2.getClass();
                while (true) {
                    dVar = dVar2.f;
                    if (dVar == null || j10 < dVar.g - nanoTime) {
                        break;
                    } else {
                        dVar2 = dVar;
                    }
                }
                this.f = dVar;
                dVar2.f = this;
                if (dVar2 == f10951l) {
                    i.signal();
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean i() {
        ReentrantLock reentrantLock = h;
        reentrantLock.lock();
        try {
            if (!this.f10952e) {
                return false;
            }
            this.f10952e = false;
            d dVar = f10951l;
            while (dVar != null) {
                d dVar2 = dVar.f;
                if (dVar2 == this) {
                    dVar.f = this.f;
                    this.f = null;
                    return false;
                }
                dVar = dVar2;
            }
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void j() {
    }
}
