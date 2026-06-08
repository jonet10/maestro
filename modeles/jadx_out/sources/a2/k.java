package a2;

import java.io.InputStream;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public int f27a;

    /* renamed from: b, reason: collision with root package name */
    public int f28b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ m f29l;

    public k(m mVar, j jVar) {
        this.f29l = mVar;
        this.f27a = mVar.u(jVar.f25a + 4);
        this.f28b = jVar.f26b;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) {
        if (bArr == null) {
            com.google.gson.internal.a.i("buffer");
            return 0;
        }
        if ((i | i6) < 0 || i6 > bArr.length - i) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i10 = this.f28b;
        if (i10 <= 0) {
            return -1;
        }
        if (i6 > i10) {
            i6 = i10;
        }
        int i11 = this.f27a;
        m mVar = this.f29l;
        mVar.n(i11, bArr, i, i6);
        this.f27a = mVar.u(this.f27a + i6);
        this.f28b -= i6;
        return i6;
    }

    @Override // java.io.InputStream
    public final int read() {
        m mVar = this.f29l;
        RandomAccessFile randomAccessFile = mVar.f31a;
        if (this.f28b == 0) {
            return -1;
        }
        randomAccessFile.seek(this.f27a);
        int read = randomAccessFile.read();
        this.f27a = mVar.u(this.f27a + 1);
        this.f28b--;
        return read;
    }
}
