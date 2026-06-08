package androidx.datastore.core.okio;

import androidx.datastore.core.ReadScope;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import t6.c;
import w8.o;
import w8.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class OkioReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed;
    private final o fileSystem;
    private final y path;
    private final OkioSerializer<T> serializer;

    public OkioReadScope(o oVar, y yVar, OkioSerializer<T> okioSerializer) {
        oVar.getClass();
        yVar.getClass();
        okioSerializer.getClass();
        this.fileSystem = oVar;
        this.path = yVar;
        this.serializer = okioSerializer;
        this.closed = new AtomicBoolean(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f A[Catch: FileNotFoundException -> 0x0089, TryCatch #7 {FileNotFoundException -> 0x0089, blocks: (B:40:0x008f, B:42:0x0093, B:55:0x0085, B:52:0x0080), top: B:51:0x0080, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093 A[Catch: FileNotFoundException -> 0x0089, TRY_LEAVE, TryCatch #7 {FileNotFoundException -> 0x0089, blocks: (B:40:0x008f, B:42:0x0093, B:55:0x0085, B:52:0x0080), top: B:51:0x0080, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope<T> r7, t6.c r8) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioReadScope.readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope, t6.c):java.lang.Object");
    }

    public final void checkClose() {
        if (this.closed.get()) {
            a.i("This scope has already been closed.");
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    public final o getFileSystem() {
        return this.fileSystem;
    }

    public final y getPath() {
        return this.path;
    }

    public final OkioSerializer<T> getSerializer() {
        return this.serializer;
    }

    @Override // androidx.datastore.core.ReadScope
    public Object readData(c cVar) {
        return readData$suspendImpl(this, cVar);
    }
}
