package androidx.datastore.core;

import android.os.FileObserver;
import androidx.annotation.CheckResult;
import androidx.annotation.VisibleForTesting;
import d7.l;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.g;
import o7.o0;
import r7.d;
import r7.h;
import t6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MulticastFileObserver extends FileObserver {
    public static final Companion Companion = new Companion(null);
    private static final Object LOCK = new Object();
    private static final Map<String, MulticastFileObserver> fileObservers = new LinkedHashMap();
    private final CopyOnWriteArrayList<l> delegates;
    private final String path;

    private MulticastFileObserver(String str) {
        super(str, 128);
        this.path = str;
        this.delegates = new CopyOnWriteArrayList<>();
    }

    public final String getPath() {
        return this.path;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((l) it.next()).invoke(str);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @CheckResult
        public final o0 observe(File file, l lVar) {
            String path = file.getCanonicalFile().getPath();
            synchronized (MulticastFileObserver.LOCK) {
                try {
                    Map<String, MulticastFileObserver> fileObservers$datastore_core_release = MulticastFileObserver.Companion.getFileObservers$datastore_core_release();
                    path.getClass();
                    MulticastFileObserver multicastFileObserver = fileObservers$datastore_core_release.get(path);
                    if (multicastFileObserver == null) {
                        multicastFileObserver = new MulticastFileObserver(path, null);
                        fileObservers$datastore_core_release.put(path, multicastFileObserver);
                    }
                    MulticastFileObserver multicastFileObserver2 = multicastFileObserver;
                    multicastFileObserver2.delegates.add(lVar);
                    if (multicastFileObserver2.delegates.size() == 1) {
                        multicastFileObserver2.startWatching();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new a(0, path, lVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void observe$lambda$4(String str, l lVar) {
            lVar.getClass();
            synchronized (MulticastFileObserver.LOCK) {
                Companion companion = MulticastFileObserver.Companion;
                MulticastFileObserver multicastFileObserver = companion.getFileObservers$datastore_core_release().get(str);
                if (multicastFileObserver != null) {
                    multicastFileObserver.delegates.remove(lVar);
                    if (multicastFileObserver.delegates.isEmpty()) {
                        companion.getFileObservers$datastore_core_release().remove(str);
                        multicastFileObserver.stopWatching();
                    }
                }
            }
        }

        public final Map<String, MulticastFileObserver> getFileObservers$datastore_core_release() {
            return MulticastFileObserver.fileObservers;
        }

        @VisibleForTesting
        public final void removeAllObservers$datastore_core_release() {
            synchronized (MulticastFileObserver.LOCK) {
                try {
                    Iterator<T> it = MulticastFileObserver.Companion.getFileObservers$datastore_core_release().values().iterator();
                    while (it.hasNext()) {
                        ((MulticastFileObserver) it.next()).stopWatching();
                    }
                    MulticastFileObserver.Companion.getFileObservers$datastore_core_release().clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getFileObservers$datastore_core_release$annotations() {
        }

        @CheckResult
        public final h observe(File file) {
            file.getClass();
            return new d(new MulticastFileObserver$Companion$observe$1(file, null), i.f10314a, -2, q7.a.f8729a);
        }
    }

    public /* synthetic */ MulticastFileObserver(String str, g gVar) {
        this(str);
    }
}
