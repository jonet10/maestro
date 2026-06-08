package androidx.datastore.core;

import java.io.FileOutputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class UncloseableOutputStream extends OutputStream {
    private final FileOutputStream fileOutputStream;

    public UncloseableOutputStream(FileOutputStream fileOutputStream) {
        fileOutputStream.getClass();
        this.fileOutputStream = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.fileOutputStream.flush();
    }

    public final FileOutputStream getFileOutputStream() {
        return this.fileOutputStream;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        bArr.getClass();
        this.fileOutputStream.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.fileOutputStream.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i6) {
        bArr.getClass();
        this.fileOutputStream.write(bArr, i, i6);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
