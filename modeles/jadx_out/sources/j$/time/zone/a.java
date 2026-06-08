package j$.time.zone;

import j$.time.ZoneOffset;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.TimeZone;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class a implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;

    /* renamed from: a, reason: collision with root package name */
    public byte f5934a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5935b;

    public a() {
    }

    public a(byte b7, Object obj) {
        this.f5934a = b7;
        this.f5935b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b7 = this.f5934a;
        Object obj = this.f5935b;
        objectOutput.writeByte(b7);
        if (b7 != 1) {
            if (b7 == 2) {
                b bVar = (b) obj;
                c(bVar.f5937a, objectOutput);
                d(bVar.f5939c, objectOutput);
                d(bVar.f5940d, objectOutput);
                return;
            }
            if (b7 == 3) {
                ((e) obj).b(objectOutput);
                return;
            } else {
                if (b7 != 100) {
                    throw new InvalidClassException("Unknown serialized type");
                }
                objectOutput.writeUTF(((f) obj).g.getID());
                return;
            }
        }
        f fVar = (f) obj;
        objectOutput.writeInt(fVar.f5950a.length);
        for (long j : fVar.f5950a) {
            c(j, objectOutput);
        }
        for (ZoneOffset zoneOffset : fVar.f5951b) {
            d(zoneOffset, objectOutput);
        }
        objectOutput.writeInt(fVar.f5952c.length);
        for (long j6 : fVar.f5952c) {
            c(j6, objectOutput);
        }
        for (ZoneOffset zoneOffset2 : fVar.f5954e) {
            d(zoneOffset2, objectOutput);
        }
        objectOutput.writeByte(fVar.f.length);
        for (e eVar : fVar.f) {
            eVar.b(objectOutput);
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        Object fVar;
        byte readByte = objectInput.readByte();
        this.f5934a = readByte;
        if (readByte == 1) {
            long[] jArr = f.i;
            int readInt = objectInput.readInt();
            long[] jArr2 = readInt == 0 ? jArr : new long[readInt];
            for (int i = 0; i < readInt; i++) {
                jArr2[i] = a(objectInput);
            }
            int i6 = readInt + 1;
            ZoneOffset[] zoneOffsetArr = new ZoneOffset[i6];
            for (int i10 = 0; i10 < i6; i10++) {
                zoneOffsetArr[i10] = b(objectInput);
            }
            int readInt2 = objectInput.readInt();
            if (readInt2 != 0) {
                jArr = new long[readInt2];
            }
            long[] jArr3 = jArr;
            for (int i11 = 0; i11 < readInt2; i11++) {
                jArr3[i11] = a(objectInput);
            }
            int i12 = readInt2 + 1;
            ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i12];
            for (int i13 = 0; i13 < i12; i13++) {
                zoneOffsetArr2[i13] = b(objectInput);
            }
            int readByte2 = objectInput.readByte();
            e[] eVarArr = readByte2 == 0 ? f.j : new e[readByte2];
            for (int i14 = 0; i14 < readByte2; i14++) {
                eVarArr[i14] = e.a(objectInput);
            }
            fVar = new f(jArr2, zoneOffsetArr, jArr3, zoneOffsetArr2, eVarArr);
        } else if (readByte == 2) {
            int i15 = b.f5936e;
            long a8 = a(objectInput);
            ZoneOffset b7 = b(objectInput);
            ZoneOffset b10 = b(objectInput);
            if (b7.equals(b10)) {
                j$.time.g.c("Offsets must not be equal");
                return;
            }
            fVar = new b(a8, b7, b10);
        } else if (readByte == 3) {
            fVar = e.a(objectInput);
        } else {
            if (readByte != 100) {
                throw new StreamCorruptedException("Unknown serialized type");
            }
            fVar = new f(TimeZone.getTimeZone(objectInput.readUTF()));
        }
        this.f5935b = fVar;
    }

    private Object readResolve() {
        return this.f5935b;
    }

    public static ZoneOffset b(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ZoneOffset.C(dataInput.readInt()) : ZoneOffset.C(readByte * 900);
    }

    public static void c(long j, DataOutput dataOutput) {
        if (j >= -4575744000L && j < 10413792000L && j % 900 == 0) {
            int i = (int) ((j + 4575744000L) / 900);
            dataOutput.writeByte((i >>> 16) & 255);
            dataOutput.writeByte((i >>> 8) & 255);
            dataOutput.writeByte(i & 255);
            return;
        }
        dataOutput.writeByte(255);
        dataOutput.writeLong(j);
    }

    public static long a(DataInput dataInput) {
        if ((dataInput.readByte() & 255) == 255) {
            return dataInput.readLong();
        }
        return ((((r0 << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255)) * 900) - 4575744000L;
    }

    public static void d(ZoneOffset zoneOffset, DataOutput dataOutput) {
        int i = zoneOffset.f5751b;
        int i6 = i % 900 == 0 ? i / 900 : 127;
        dataOutput.writeByte(i6);
        if (i6 == 127) {
            dataOutput.writeInt(i);
        }
    }
}
