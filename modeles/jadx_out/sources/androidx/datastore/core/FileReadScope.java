package androidx.datastore.core;

import java.io.File;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class FileReadScope<T> implements ReadScope<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final File file;
    private final Serializer<T> serializer;

    public FileReadScope(File file, Serializer<T> serializer) {
        file.getClass();
        serializer.getClass();
        this.file = file;
        this.serializer = serializer;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(6:5|6|7|(1:(1:(5:11|12|13|14|15)(2:25|26))(3:27|28|29))(7:40|41|42|44|45|(1:47)|48)|30|31))|66|6|7|(0)(0)|30|31|(3:(1:21)|(0)|(1:36))) */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x006c, code lost:
    
        r7 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11, types: [androidx.datastore.core.FileReadScope] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.FileReadScope<T> r7, t6.c r8) {
        /*
            boolean r0 = r8 instanceof androidx.datastore.core.FileReadScope$readData$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.datastore.core.FileReadScope$readData$1 r0 = (androidx.datastore.core.FileReadScope$readData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.FileReadScope$readData$1 r0 = new androidx.datastore.core.FileReadScope$readData$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            r4 = 0
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L48
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L33
            java.lang.Object r7 = r0.L$0
            java.io.Closeable r7 = (java.io.Closeable) r7
            p6.a.e(r8)     // Catch: java.lang.Throwable -> L30
            goto L9a
        L30:
            r8 = move-exception
            goto La2
        L33:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            r7 = 0
            return r7
        L3a:
            java.lang.Object r7 = r0.L$1
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r1 = r0.L$0
            androidx.datastore.core.FileReadScope r1 = (androidx.datastore.core.FileReadScope) r1
            p6.a.e(r8)     // Catch: java.lang.Throwable -> L46
            goto L68
        L46:
            r8 = move-exception
            goto L73
        L48:
            p6.a.e(r8)
            r7.checkNotClosed()
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L79
            java.io.File r1 = r7.file     // Catch: java.io.FileNotFoundException -> L79
            r8.<init>(r1)     // Catch: java.io.FileNotFoundException -> L79
            androidx.datastore.core.Serializer<T> r1 = r7.serializer     // Catch: java.lang.Throwable -> L6e
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L6e
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L6e
            r0.label = r3     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r1 = r1.readFrom(r8, r0)     // Catch: java.lang.Throwable -> L6e
            if (r1 != r5) goto L64
            goto L96
        L64:
            r6 = r1
            r1 = r7
            r7 = r8
            r8 = r6
        L68:
            com.google.android.gms.internal.measurement.z3.k(r7, r4)     // Catch: java.io.FileNotFoundException -> L6c
            return r8
        L6c:
            r7 = r1
            goto L79
        L6e:
            r1 = move-exception
            r6 = r1
            r1 = r7
            r7 = r8
            r8 = r6
        L73:
            throw r8     // Catch: java.lang.Throwable -> L74
        L74:
            r3 = move-exception
            com.google.android.gms.internal.measurement.z3.k(r7, r8)     // Catch: java.io.FileNotFoundException -> L6c
            throw r3     // Catch: java.io.FileNotFoundException -> L6c
        L79:
            java.io.File r8 = r7.file
            boolean r8 = r8.exists()
            if (r8 == 0) goto La8
            java.io.FileInputStream r8 = new java.io.FileInputStream
            java.io.File r1 = r7.file
            r8.<init>(r1)
            androidx.datastore.core.Serializer<T> r7 = r7.serializer     // Catch: java.lang.Throwable -> L9e
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L9e
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L9e
            r0.label = r2     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r7 = r7.readFrom(r8, r0)     // Catch: java.lang.Throwable -> L9e
            if (r7 != r5) goto L97
        L96:
            return r5
        L97:
            r6 = r8
            r8 = r7
            r7 = r6
        L9a:
            com.google.android.gms.internal.measurement.z3.k(r7, r4)
            return r8
        L9e:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        La2:
            throw r8     // Catch: java.lang.Throwable -> La3
        La3:
            r0 = move-exception
            com.google.android.gms.internal.measurement.z3.k(r7, r8)
            throw r0
        La8:
            androidx.datastore.core.Serializer<T> r7 = r7.serializer
            java.lang.Object r7 = r7.getDefaultValue()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileReadScope.readData$suspendImpl(androidx.datastore.core.FileReadScope, t6.c):java.lang.Object");
    }

    public final void checkNotClosed() {
        if (this.closed.get()) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("This scope has already been closed.");
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    public final File getFile() {
        return this.file;
    }

    public final Serializer<T> getSerializer() {
        return this.serializer;
    }

    @Override // androidx.datastore.core.ReadScope
    public Object readData(c cVar) {
        return readData$suspendImpl(this, cVar);
    }
}
