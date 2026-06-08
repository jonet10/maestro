package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class StringVector extends BaseVector {
    private Utf8 utf8 = Utf8.getDefault();

    public StringVector __assign(int i, int i6, ByteBuffer byteBuffer) {
        __reset(i, i6, byteBuffer);
        return this;
    }

    public String get(int i) {
        return Table.__string(__element(i), this.bb, this.utf8);
    }
}
