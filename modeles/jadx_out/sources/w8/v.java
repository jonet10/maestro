package w8;

import com.google.android.gms.internal.measurement.i5;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class v extends o {
    @Override // w8.o
    public void a(y yVar, y yVar2) {
        yVar2.getClass();
        if (yVar.toFile().renameTo(yVar2.toFile())) {
            return;
        }
        throw new IOException("failed to move " + yVar + " to " + yVar2);
    }

    @Override // w8.o
    public final void b(y yVar) {
        if (yVar.toFile().mkdir()) {
            return;
        }
        n e10 = e(yVar);
        if (e10 == null || !e10.f10981b) {
            s1.o.k(yVar, "failed to create directory: ");
        }
    }

    @Override // w8.o
    public final void c(y yVar) {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = yVar.toFile();
        if (file.delete() || !file.exists()) {
            return;
        }
        s1.o.k(yVar, "failed to delete ");
    }

    @Override // w8.o
    public n e(y yVar) {
        yVar.getClass();
        File file = yVar.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (isFile || isDirectory || lastModified != 0 || length != 0 || file.exists()) {
            return new n(isFile, isDirectory, Long.valueOf(length), null, Long.valueOf(lastModified), null);
        }
        return null;
    }

    @Override // w8.o
    public final u f(y yVar) {
        return new u(false, new RandomAccessFile(yVar.toFile(), "r"));
    }

    @Override // w8.o
    public final u g(y yVar) {
        return new u(true, new RandomAccessFile(yVar.toFile(), "rw"));
    }

    @Override // w8.o
    public final g0 h(y yVar) {
        yVar.getClass();
        return i5.L(yVar.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
