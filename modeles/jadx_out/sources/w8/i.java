package w8;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface i extends e0, WritableByteChannel {
    @Override // w8.e0, java.io.Flushable
    void flush();

    i m(String str);

    i o(long j);

    OutputStream v();

    i write(byte[] bArr);

    i writeByte(int i);

    i writeInt(int i);

    i writeShort(int i);
}
