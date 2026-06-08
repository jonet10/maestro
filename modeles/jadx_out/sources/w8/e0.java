package w8;

import java.io.Closeable;
import java.io.Flushable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface e0 extends Closeable, Flushable {
    i0 a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    void l(h hVar, long j);
}
