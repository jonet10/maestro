package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.Storage;
import androidx.datastore.core.StorageConnection;
import d7.a;
import d7.p;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import p6.f;
import w8.o;
import w8.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class OkioStorage<T> implements Storage<T> {
    public static final Companion Companion = new Companion(null);
    private static final Set<String> activeFiles = new LinkedHashSet();
    private static final Synchronizer activeFilesLock = new Synchronizer();
    private final f canonicalPath$delegate;
    private final p coordinatorProducer;
    private final o fileSystem;
    private final a producePath;
    private final OkioSerializer<T> serializer;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.datastore.core.okio.OkioStorage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements p {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // d7.p
        public final InterProcessCoordinator invoke(y yVar, o oVar) {
            yVar.getClass();
            oVar.getClass();
            return OkioStorageKt.createSingleProcessCoordinator(yVar);
        }
    }

    public OkioStorage(o oVar, OkioSerializer<T> okioSerializer, p pVar, a aVar) {
        oVar.getClass();
        okioSerializer.getClass();
        pVar.getClass();
        aVar.getClass();
        this.fileSystem = oVar;
        this.serializer = okioSerializer;
        this.coordinatorProducer = pVar;
        this.producePath = aVar;
        this.canonicalPath$delegate = new p6.m(new OkioStorage$canonicalPath$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final y getCanonicalPath() {
        return (y) this.canonicalPath$delegate.getValue();
    }

    @Override // androidx.datastore.core.Storage
    public StorageConnection<T> createConnection() {
        String t9 = getCanonicalPath().f11005a.t();
        synchronized (activeFilesLock) {
            Set<String> set = activeFiles;
            if (set.contains(t9)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + t9 + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            set.add(t9);
        }
        return new OkioStorageConnection(this.fileSystem, getCanonicalPath(), this.serializer, (InterProcessCoordinator) this.coordinatorProducer.invoke(getCanonicalPath(), this.fileSystem), new OkioStorage$createConnection$2(this));
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Set<String> getActiveFiles$datastore_core_okio() {
            return OkioStorage.activeFiles;
        }

        public final Synchronizer getActiveFilesLock() {
            return OkioStorage.activeFilesLock;
        }

        private Companion() {
        }
    }

    public /* synthetic */ OkioStorage(o oVar, OkioSerializer okioSerializer, p pVar, a aVar, int i, g gVar) {
        this(oVar, okioSerializer, (i & 4) != 0 ? AnonymousClass1.INSTANCE : pVar, aVar);
    }
}
