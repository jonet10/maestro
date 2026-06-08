package androidx.datastore.core;

import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FileWriteScope<T> extends FileReadScope<T> implements WriteScope<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriteScope(File file, Serializer<T> serializer) {
        super(file, serializer);
        file.getClass();
        serializer.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    @Override // androidx.datastore.core.WriteScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeData(T r5, t6.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.FileWriteScope$writeData$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = (androidx.datastore.core.FileWriteScope$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = new androidx.datastore.core.FileWriteScope$writeData$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2f
            java.lang.Object r5 = r0.L$1
            java.io.FileOutputStream r5 = (java.io.FileOutputStream) r5
            java.lang.Object r0 = r0.L$0
            java.io.Closeable r0 = (java.io.Closeable) r0
            p6.a.e(r6)     // Catch: java.lang.Throwable -> L2d
            goto L5f
        L2d:
            r5 = move-exception
            goto L6f
        L2f:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L36:
            p6.a.e(r6)
            r4.checkNotClosed()
            java.io.FileOutputStream r6 = new java.io.FileOutputStream
            java.io.File r1 = r4.getFile()
            r6.<init>(r1)
            androidx.datastore.core.Serializer r1 = r4.getSerializer()     // Catch: java.lang.Throwable -> L6d
            androidx.datastore.core.UncloseableOutputStream r3 = new androidx.datastore.core.UncloseableOutputStream     // Catch: java.lang.Throwable -> L6d
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L6d
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L6d
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L6d
            r0.label = r2     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r5 = r1.writeTo(r5, r3, r0)     // Catch: java.lang.Throwable -> L6d
            u6.a r0 = u6.a.f10762a
            if (r5 != r0) goto L5d
            return r0
        L5d:
            r5 = r6
            r0 = r5
        L5f:
            java.io.FileDescriptor r5 = r5.getFD()     // Catch: java.lang.Throwable -> L2d
            r5.sync()     // Catch: java.lang.Throwable -> L2d
            r5 = 0
            com.google.android.gms.internal.measurement.z3.k(r0, r5)
            p6.x r5 = p6.x.f8463a
            return r5
        L6d:
            r5 = move-exception
            r0 = r6
        L6f:
            throw r5     // Catch: java.lang.Throwable -> L70
        L70:
            r6 = move-exception
            com.google.android.gms.internal.measurement.z3.k(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileWriteScope.writeData(java.lang.Object, t6.c):java.lang.Object");
    }
}
