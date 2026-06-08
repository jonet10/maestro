package w8;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10998a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10999b;

    /* renamed from: l, reason: collision with root package name */
    public int f11000l;

    /* renamed from: m, reason: collision with root package name */
    public final ReentrantLock f11001m = new ReentrantLock();

    /* renamed from: n, reason: collision with root package name */
    public final RandomAccessFile f11002n;

    public u(boolean z9, RandomAccessFile randomAccessFile) {
        this.f10998a = z9;
        this.f11002n = randomAccessFile;
    }

    public static l b(u uVar) {
        if (!uVar.f10998a) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("file handle is read-only");
            return null;
        }
        ReentrantLock reentrantLock = uVar.f11001m;
        reentrantLock.lock();
        try {
            if (uVar.f10999b) {
                throw new IllegalStateException("closed");
            }
            uVar.f11000l++;
            reentrantLock.unlock();
            return new l(uVar);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final m c(long j) {
        ReentrantLock reentrantLock = this.f11001m;
        reentrantLock.lock();
        try {
            if (this.f10999b) {
                throw new IllegalStateException("closed");
            }
            this.f11000l++;
            reentrantLock.unlock();
            return new m(this, j);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f11001m;
        reentrantLock.lock();
        try {
            if (this.f10999b) {
                return;
            }
            this.f10999b = true;
            if (this.f11000l != 0) {
                return;
            }
            synchronized (this) {
                this.f11002n.close();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void flush() {
        if (!this.f10998a) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("file handle is read-only");
            return;
        }
        ReentrantLock reentrantLock = this.f11001m;
        reentrantLock.lock();
        try {
            if (this.f10999b) {
                throw new IllegalStateException("closed");
            }
            synchronized (this) {
                this.f11002n.getFD().sync();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long size() {
        long length;
        ReentrantLock reentrantLock = this.f11001m;
        reentrantLock.lock();
        try {
            if (this.f10999b) {
                throw new IllegalStateException("closed");
            }
            synchronized (this) {
                length = this.f11002n.length();
            }
            return length;
        } finally {
            reentrantLock.unlock();
        }
    }
}
