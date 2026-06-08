package androidx.datastore.preferences.protobuf;

import androidx.lifecycle.l;
import com.google.gson.internal.a;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@CheckReturnValue
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
abstract class AllocatedBuffer {
    public static AllocatedBuffer wrap(byte[] bArr, int i, int i6) {
        if (i < 0 || i6 < 0 || i + i6 > bArr.length) {
            throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i6)));
        }
        return wrapNoCheck(bArr, i, i6);
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] bArr, final int i, final int i6) {
        return new AllocatedBuffer() { // from class: androidx.datastore.preferences.protobuf.AllocatedBuffer.2
            private int position;

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public byte[] array() {
                return bArr;
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public int arrayOffset() {
                return i;
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public boolean hasArray() {
                return true;
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public boolean hasNioBuffer() {
                return false;
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public int limit() {
                return i6;
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                throw new UnsupportedOperationException();
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public AllocatedBuffer position(int i10) {
                if (i10 < 0 || i10 > i6) {
                    a.p(l.u(i10, "Invalid position: "));
                    return null;
                }
                this.position = i10;
                return this;
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public int remaining() {
                return i6 - this.position;
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public int position() {
                return this.position;
            }
        };
    }

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    @CanIgnoreReturnValue
    public abstract AllocatedBuffer position(int i);

    public abstract int remaining();

    public static AllocatedBuffer wrap(byte[] bArr) {
        return wrapNoCheck(bArr, 0, bArr.length);
    }

    public static AllocatedBuffer wrap(final ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() { // from class: androidx.datastore.preferences.protobuf.AllocatedBuffer.1
            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public byte[] array() {
                return byteBuffer.array();
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public int arrayOffset() {
                return byteBuffer.arrayOffset();
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public boolean hasArray() {
                return byteBuffer.hasArray();
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public boolean hasNioBuffer() {
                return true;
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public int limit() {
                return byteBuffer.limit();
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                return byteBuffer;
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public int position() {
                return byteBuffer.position();
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public int remaining() {
                return byteBuffer.remaining();
            }

            @Override // androidx.datastore.preferences.protobuf.AllocatedBuffer
            public AllocatedBuffer position(int i) {
                Java8Compatibility.position(byteBuffer, i);
                return this;
            }
        };
    }
}
