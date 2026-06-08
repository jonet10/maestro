package w8;

import java.io.InputStream;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10955a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f10956b;

    public /* synthetic */ f(j jVar, int i) {
        this.f10955a = i;
        this.f10956b = jVar;
    }

    @Override // java.io.InputStream
    public final int available() {
        switch (this.f10955a) {
            case 0:
                return (int) Math.min(((h) this.f10956b).f10961b, Integer.MAX_VALUE);
            default:
                a0 a0Var = (a0) this.f10956b;
                if (!a0Var.f10935l) {
                    return (int) Math.min(a0Var.f10934b.f10961b, Integer.MAX_VALUE);
                }
                com.google.gson.internal.a.n("closed");
                return 0;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f10955a) {
            case 0:
                break;
            default:
                ((a0) this.f10956b).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        switch (this.f10955a) {
            case 0:
                h hVar = (h) this.f10956b;
                if (hVar.f10961b > 0) {
                    return hVar.readByte() & 255;
                }
                return -1;
            default:
                a0 a0Var = (a0) this.f10956b;
                h hVar2 = a0Var.f10934b;
                if (a0Var.f10935l) {
                    com.google.gson.internal.a.n("closed");
                    return 0;
                }
                if (hVar2.f10961b == 0 && a0Var.f10933a.p(hVar2, 8192L) == -1) {
                    return -1;
                }
                return hVar2.readByte() & 255;
        }
    }

    public final String toString() {
        switch (this.f10955a) {
            case 0:
                return ((h) this.f10956b) + ".inputStream()";
            default:
                return ((a0) this.f10956b) + ".inputStream()";
        }
    }

    private final void b() {
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) {
        int i10 = this.f10955a;
        bArr.getClass();
        switch (i10) {
            case 0:
                return ((h) this.f10956b).read(bArr, i, i6);
            default:
                a0 a0Var = (a0) this.f10956b;
                h hVar = a0Var.f10934b;
                if (!a0Var.f10935l) {
                    a.a.o(bArr.length, i, i6);
                    if (hVar.f10961b == 0 && a0Var.f10933a.p(hVar, 8192L) == -1) {
                        return -1;
                    }
                    return hVar.read(bArr, i, i6);
                }
                com.google.gson.internal.a.n("closed");
                return 0;
        }
    }
}
