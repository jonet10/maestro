package androidx.room.concurrent;

import a1.b;
import d7.a;
import d7.l;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ExclusiveLock {
    public static final Companion Companion = new Companion(null);
    private static final Map<String, ReentrantLock> threadLocksMap = new LinkedHashMap();
    private final FileLock fileLock;
    private final ReentrantLock threadLock;

    public ExclusiveLock(String str, boolean z9) {
        str.getClass();
        Companion companion = Companion;
        this.threadLock = companion.getThreadLock(str);
        this.fileLock = z9 ? companion.getFileLock(str) : null;
    }

    public final <T> T withLock(a aVar, l lVar) {
        aVar.getClass();
        lVar.getClass();
        this.threadLock.lock();
        boolean z9 = false;
        try {
            FileLock fileLock = this.fileLock;
            if (fileLock != null) {
                fileLock.lock();
            }
            z9 = true;
            try {
                T t9 = (T) aVar.invoke();
                this.threadLock.unlock();
                return t9;
            } finally {
                FileLock fileLock2 = this.fileLock;
                if (fileLock2 != null) {
                    fileLock2.unlock();
                }
            }
        } catch (Throwable th) {
            try {
                if (z9) {
                    throw th;
                }
                lVar.invoke(th);
                throw new b();
            } catch (Throwable th2) {
                this.threadLock.unlock();
                throw th2;
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FileLock getFileLock(String str) {
            return new FileLock(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ReentrantLock getThreadLock(String str) {
            ReentrantLock reentrantLock;
            synchronized (this) {
                try {
                    Map map = ExclusiveLock.threadLocksMap;
                    Object obj = map.get(str);
                    if (obj == null) {
                        obj = new ReentrantLock();
                        map.put(str, obj);
                    }
                    reentrantLock = (ReentrantLock) obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return reentrantLock;
        }

        private Companion() {
        }
    }
}
