package a4;

import android.os.Process;
import b2.t1;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r0 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f176a = 0;

    public /* synthetic */ r0(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ReentrantLock reentrantLock;
        switch (this.f176a) {
            case 0:
                Process.setThreadPriority(10);
                super.run();
                return;
            case 1:
                Process.setThreadPriority(19);
                synchronized (this) {
                    while (true) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
        }
        while (true) {
            try {
                reentrantLock = w8.d.h;
                reentrantLock.lock();
            } catch (InterruptedException unused2) {
            }
            try {
                w8.d l10 = t1.l();
                if (l10 == w8.d.f10951l) {
                    w8.d.f10951l = null;
                    reentrantLock.unlock();
                    return;
                } else {
                    reentrantLock.unlock();
                    if (l10 != null) {
                        l10.j();
                    }
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public /* synthetic */ r0(String str) {
        super(str);
    }

    public /* synthetic */ r0(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
