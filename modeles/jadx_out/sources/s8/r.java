package s8;

import java.util.logging.Level;
import java.util.logging.Logger;
import w8.g0;
import w8.i0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final w8.j f9443a;

    /* renamed from: b, reason: collision with root package name */
    public int f9444b;

    /* renamed from: l, reason: collision with root package name */
    public byte f9445l;

    /* renamed from: m, reason: collision with root package name */
    public int f9446m;

    /* renamed from: n, reason: collision with root package name */
    public int f9447n;

    /* renamed from: o, reason: collision with root package name */
    public short f9448o;

    public r(w8.j jVar) {
        this.f9443a = jVar;
    }

    @Override // w8.g0
    public final i0 a() {
        return this.f9443a.a();
    }

    @Override // w8.g0
    public final long p(w8.h hVar, long j) {
        int i;
        int readInt;
        do {
            int i6 = this.f9447n;
            w8.j jVar = this.f9443a;
            if (i6 == 0) {
                jVar.skip(this.f9448o);
                this.f9448o = (short) 0;
                if ((this.f9445l & 4) == 0) {
                    i = this.f9446m;
                    int j6 = s.j(jVar);
                    this.f9447n = j6;
                    this.f9444b = j6;
                    byte readByte = (byte) (jVar.readByte() & 255);
                    this.f9445l = (byte) (jVar.readByte() & 255);
                    Logger logger = s.f9449n;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(e.a(true, this.f9446m, this.f9444b, readByte, this.f9445l));
                    }
                    readInt = jVar.readInt() & Integer.MAX_VALUE;
                    this.f9446m = readInt;
                    if (readByte != 9) {
                        e.c("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                        throw null;
                    }
                }
            } else {
                long p10 = jVar.p(hVar, Math.min(j, i6));
                if (p10 != -1) {
                    this.f9447n = (int) (this.f9447n - p10);
                    return p10;
                }
            }
            return -1L;
        } while (readInt == i);
        e.c("TYPE_CONTINUATION streamId changed", new Object[0]);
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
