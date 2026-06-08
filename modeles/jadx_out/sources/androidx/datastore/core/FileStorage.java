package androidx.datastore.core;

import androidx.annotation.GuardedBy;
import d7.l;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FileStorage<T> implements Storage<T> {
    public static final Companion Companion = new Companion(null);

    @GuardedBy("activeFilesLock")
    private static final Set<String> activeFiles = new LinkedHashSet();
    private static final Object activeFilesLock = new Object();
    private final l coordinatorProducer;
    private final d7.a produceFile;
    private final Serializer<T> serializer;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.datastore.core.FileStorage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // d7.l
        public final InterProcessCoordinator invoke(File file) {
            file.getClass();
            return InterProcessCoordinator_jvmKt.createSingleProcessCoordinator(file);
        }
    }

    public FileStorage(Serializer<T> serializer, l lVar, d7.a aVar) {
        serializer.getClass();
        lVar.getClass();
        aVar.getClass();
        this.serializer = serializer;
        this.coordinatorProducer = lVar;
        this.produceFile = aVar;
    }

    @Override // androidx.datastore.core.Storage
    public StorageConnection<T> createConnection() {
        File canonicalFile = ((File) this.produceFile.invoke()).getCanonicalFile();
        synchronized (activeFilesLock) {
            String absolutePath = canonicalFile.getAbsolutePath();
            Set<String> set = activeFiles;
            if (set.contains(absolutePath)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + absolutePath + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            absolutePath.getClass();
            set.add(absolutePath);
        }
        return new FileStorageConnection(canonicalFile, this.serializer, (InterProcessCoordinator) this.coordinatorProducer.invoke(canonicalFile), new FileStorage$createConnection$2(canonicalFile));
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Set<String> getActiveFiles$datastore_core_release() {
            return FileStorage.activeFiles;
        }

        public final Object getActiveFilesLock$datastore_core_release() {
            return FileStorage.activeFilesLock;
        }

        private Companion() {
        }
    }

    public /* synthetic */ FileStorage(Serializer serializer, l lVar, d7.a aVar, int i, g gVar) {
        this(serializer, (i & 2) != 0 ? AnonymousClass1.INSTANCE : lVar, aVar);
    }
}
