package d;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteOrder;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class a extends InputStream implements DataInput {

    /* renamed from: n, reason: collision with root package name */
    public static final ByteOrder f3497n = ByteOrder.LITTLE_ENDIAN;

    /* renamed from: o, reason: collision with root package name */
    public static final ByteOrder f3498o = ByteOrder.BIG_ENDIAN;

    /* renamed from: a, reason: collision with root package name */
    public final DataInputStream f3499a;

    /* renamed from: b, reason: collision with root package name */
    public ByteOrder f3500b;

    /* renamed from: l, reason: collision with root package name */
    public final int f3501l;

    /* renamed from: m, reason: collision with root package name */
    public int f3502m;

    public a(InputStream inputStream) {
        this.f3500b = ByteOrder.BIG_ENDIAN;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f3499a = dataInputStream;
        int available = dataInputStream.available();
        this.f3501l = available;
        this.f3502m = 0;
        dataInputStream.mark(available);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f3499a.available();
    }

    public final void b(long j) {
        int i = this.f3502m;
        if (i > j) {
            this.f3502m = 0;
            DataInputStream dataInputStream = this.f3499a;
            dataInputStream.reset();
            dataInputStream.mark(this.f3501l);
        } else {
            j -= i;
        }
        int i6 = (int) j;
        if (skipBytes(i6) == i6) {
            return;
        }
        com.google.gson.internal.a.n("Couldn't seek up to the byteCount");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.f3502m++;
        return this.f3499a.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.f3502m++;
        return this.f3499a.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        int i = this.f3502m + 1;
        this.f3502m = i;
        if (i > this.f3501l) {
            o.d();
            return (byte) 0;
        }
        int read = this.f3499a.read();
        if (read >= 0) {
            return (byte) read;
        }
        o.d();
        return (byte) 0;
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.f3502m += 2;
        return this.f3499a.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        int length = this.f3502m + bArr.length;
        this.f3502m = length;
        if (length > this.f3501l) {
            o.d();
            return;
        }
        if (this.f3499a.read(bArr, 0, bArr.length) == bArr.length) {
            return;
        }
        com.google.gson.internal.a.n("Couldn't read up to the length of buffer");
    }

    @Override // java.io.DataInput
    public final int readInt() {
        int i = this.f3502m + 4;
        this.f3502m = i;
        if (i > this.f3501l) {
            o.d();
            return 0;
        }
        DataInputStream dataInputStream = this.f3499a;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        if ((read | read2 | read3 | read4) < 0) {
            o.d();
            return 0;
        }
        ByteOrder byteOrder = this.f3500b;
        if (byteOrder == f3497n) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
        }
        if (byteOrder == f3498o) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
        }
        androidx.core.content.pm.a.k(this.f3500b, "Invalid byte order: ");
        return 0;
    }

    @Override // java.io.DataInput
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() {
        long j;
        long j6;
        int i = this.f3502m + 8;
        this.f3502m = i;
        if (i > this.f3501l) {
            o.d();
            return 0L;
        }
        DataInputStream dataInputStream = this.f3499a;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        int read5 = dataInputStream.read();
        int read6 = dataInputStream.read();
        int read7 = dataInputStream.read();
        int read8 = dataInputStream.read();
        if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
            o.d();
            return 0L;
        }
        ByteOrder byteOrder = this.f3500b;
        if (byteOrder == f3497n) {
            j = (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8);
            j6 = read;
        } else {
            if (byteOrder != f3498o) {
                androidx.core.content.pm.a.k(this.f3500b, "Invalid byte order: ");
                return 0L;
            }
            j = (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8);
            j6 = read8;
        }
        return j + j6;
    }

    @Override // java.io.DataInput
    public final short readShort() {
        int i = this.f3502m + 2;
        this.f3502m = i;
        if (i > this.f3501l) {
            o.d();
            return (short) 0;
        }
        DataInputStream dataInputStream = this.f3499a;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) < 0) {
            o.d();
            return (short) 0;
        }
        ByteOrder byteOrder = this.f3500b;
        if (byteOrder == f3497n) {
            return (short) ((read2 << 8) + read);
        }
        if (byteOrder == f3498o) {
            return (short) ((read << 8) + read2);
        }
        androidx.core.content.pm.a.k(this.f3500b, "Invalid byte order: ");
        return (short) 0;
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.f3502m += 2;
        return this.f3499a.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.f3502m++;
        return this.f3499a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        int i = this.f3502m + 2;
        this.f3502m = i;
        if (i > this.f3501l) {
            o.d();
            return 0;
        }
        DataInputStream dataInputStream = this.f3499a;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) < 0) {
            o.d();
            return 0;
        }
        ByteOrder byteOrder = this.f3500b;
        if (byteOrder == f3497n) {
            return (read2 << 8) + read;
        }
        if (byteOrder == f3498o) {
            return (read << 8) + read2;
        }
        androidx.core.content.pm.a.k(this.f3500b, "Invalid byte order: ");
        return 0;
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        int min = Math.min(i, this.f3501l - this.f3502m);
        int i6 = 0;
        while (i6 < min) {
            i6 += this.f3499a.skipBytes(min - i6);
        }
        this.f3502m += i6;
        return i6;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) {
        int read = this.f3499a.read(bArr, i, i6);
        this.f3502m += read;
        return read;
    }

    public a(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i6) {
        int i10 = this.f3502m + i6;
        this.f3502m = i10;
        if (i10 <= this.f3501l) {
            if (this.f3499a.read(bArr, i, i6) == i6) {
                return;
            }
            com.google.gson.internal.a.n("Couldn't read up to the length of buffer");
            return;
        }
        o.d();
    }
}
