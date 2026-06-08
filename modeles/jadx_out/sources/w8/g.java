package w8;

import java.io.OutputStream;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10958a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f10959b;

    public /* synthetic */ g(i iVar, int i) {
        this.f10958a = i;
        this.f10959b = iVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f10958a) {
            case 0:
                break;
            default:
                ((z) this.f10959b).close();
                break;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        switch (this.f10958a) {
            case 0:
                break;
            default:
                z zVar = (z) this.f10959b;
                if (!zVar.f11008l) {
                    zVar.flush();
                    break;
                }
                break;
        }
    }

    public final String toString() {
        switch (this.f10958a) {
            case 0:
                return ((h) this.f10959b) + ".outputStream()";
            default:
                return ((z) this.f10959b) + ".outputStream()";
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i6) {
        int i10 = this.f10958a;
        bArr.getClass();
        switch (i10) {
            case 0:
                ((h) this.f10959b).write(bArr, i, i6);
                break;
            default:
                z zVar = (z) this.f10959b;
                if (!zVar.f11008l) {
                    zVar.f11007b.write(bArr, i, i6);
                    zVar.b();
                    break;
                } else {
                    com.google.gson.internal.a.n("closed");
                    break;
                }
        }
    }

    private final void b() {
    }

    private final void c() {
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        switch (this.f10958a) {
            case 0:
                ((h) this.f10959b).A(i);
                break;
            default:
                z zVar = (z) this.f10959b;
                if (!zVar.f11008l) {
                    zVar.f11007b.A((byte) i);
                    zVar.b();
                    break;
                } else {
                    com.google.gson.internal.a.n("closed");
                    break;
                }
        }
    }
}
