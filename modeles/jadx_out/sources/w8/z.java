package w8;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z implements i {

    /* renamed from: a, reason: collision with root package name */
    public final e0 f11006a;

    /* renamed from: b, reason: collision with root package name */
    public final h f11007b;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11008l;

    public z(e0 e0Var) {
        e0Var.getClass();
        this.f11006a = e0Var;
        this.f11007b = new h();
    }

    @Override // w8.e0
    public final i0 a() {
        return this.f11006a.a();
    }

    public final i b() {
        if (this.f11008l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return null;
        }
        h hVar = this.f11007b;
        long j = hVar.f10961b;
        if (j == 0) {
            j = 0;
        } else {
            b0 b0Var = hVar.f10960a;
            b0Var.getClass();
            b0 b0Var2 = b0Var.g;
            b0Var2.getClass();
            if (b0Var2.f10941c < 8192 && b0Var2.f10943e) {
                j -= r6 - b0Var2.f10940b;
            }
        }
        if (j > 0) {
            this.f11006a.l(hVar, j);
        }
        return this;
    }

    public final i c(long j) {
        if (this.f11008l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return null;
        }
        this.f11007b.B(j);
        b();
        return this;
    }

    @Override // w8.e0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        e0 e0Var = this.f11006a;
        if (this.f11008l) {
            return;
        }
        try {
            h hVar = this.f11007b;
            long j = hVar.f10961b;
            if (j > 0) {
                e0Var.l(hVar, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            e0Var.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f11008l = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // w8.i, w8.e0, java.io.Flushable
    public final void flush() {
        if (this.f11008l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return;
        }
        h hVar = this.f11007b;
        long j = hVar.f10961b;
        e0 e0Var = this.f11006a;
        if (j > 0) {
            e0Var.l(hVar, j);
        }
        e0Var.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f11008l;
    }

    @Override // w8.e0
    public final void l(h hVar, long j) {
        hVar.getClass();
        if (this.f11008l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
        } else {
            this.f11007b.l(hVar, j);
            b();
        }
    }

    @Override // w8.i
    public final i m(String str) {
        str.getClass();
        if (this.f11008l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return null;
        }
        this.f11007b.G(str);
        b();
        return this;
    }

    @Override // w8.i
    public final i o(long j) {
        if (this.f11008l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return null;
        }
        this.f11007b.C(j);
        b();
        return this;
    }

    public final String toString() {
        return "buffer(" + this.f11006a + ')';
    }

    @Override // w8.i
    public final OutputStream v() {
        return new g(this, 1);
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        if (this.f11008l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return 0;
        }
        int write = this.f11007b.write(byteBuffer);
        b();
        return write;
    }

    @Override // w8.i
    public final i writeByte(int i) {
        if (this.f11008l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return null;
        }
        this.f11007b.A(i);
        b();
        return this;
    }

    @Override // w8.i
    public final i writeInt(int i) {
        if (this.f11008l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return null;
        }
        this.f11007b.D(i);
        b();
        return this;
    }

    @Override // w8.i
    public final i writeShort(int i) {
        if (this.f11008l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return null;
        }
        this.f11007b.E(i);
        b();
        return this;
    }

    @Override // w8.i
    public final i write(byte[] bArr) {
        if (!this.f11008l) {
            this.f11007b.write(bArr, 0, bArr.length);
            b();
            return this;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
        return null;
    }
}
