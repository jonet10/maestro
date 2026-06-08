package w8;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface j extends g0, ReadableByteChannel {
    k g(long j);

    String k(long j);

    String q();

    byte readByte();

    int readInt();

    short readShort();

    void skip(long j);

    void t(long j);

    long w();

    InputStream x();
}
