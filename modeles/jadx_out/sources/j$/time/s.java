package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.util.Objects;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class s implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* renamed from: a, reason: collision with root package name */
    public byte f5892a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5893b;

    public s() {
    }

    public s(byte b7, Object obj) {
        this.f5892a = b7;
        this.f5893b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b7 = this.f5892a;
        Object obj = this.f5893b;
        objectOutput.writeByte(b7);
        switch (b7) {
            case 1:
                Duration duration = (Duration) obj;
                objectOutput.writeLong(duration.f5734a);
                objectOutput.writeInt(duration.f5735b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.f5737a);
                objectOutput.writeInt(instant.f5738b);
                return;
            case 3:
                h hVar = (h) obj;
                objectOutput.writeInt(hVar.f5866a);
                objectOutput.writeByte(hVar.f5867b);
                objectOutput.writeByte(hVar.f5868c);
                return;
            case 4:
                ((k) obj).K(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                h hVar2 = localDateTime.f5741a;
                objectOutput.writeInt(hVar2.f5866a);
                objectOutput.writeByte(hVar2.f5867b);
                objectOutput.writeByte(hVar2.f5868c);
                localDateTime.f5742b.K(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.f5753a;
                h hVar3 = localDateTime2.f5741a;
                objectOutput.writeInt(hVar3.f5866a);
                objectOutput.writeByte(hVar3.f5867b);
                objectOutput.writeByte(hVar3.f5868c);
                localDateTime2.f5742b.K(objectOutput);
                zonedDateTime.f5754b.F(objectOutput);
                zonedDateTime.f5755c.z(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((w) obj).f5931b);
                return;
            case 8:
                ((ZoneOffset) obj).F(objectOutput);
                return;
            case 9:
                q qVar = (q) obj;
                qVar.f5886a.K(objectOutput);
                qVar.f5887b.F(objectOutput);
                return;
            case 10:
                OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                LocalDateTime localDateTime3 = offsetDateTime.f5744a;
                h hVar4 = localDateTime3.f5741a;
                objectOutput.writeInt(hVar4.f5866a);
                objectOutput.writeByte(hVar4.f5867b);
                objectOutput.writeByte(hVar4.f5868c);
                localDateTime3.f5742b.K(objectOutput);
                offsetDateTime.f5745b.F(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((Year) obj).f5747a);
                return;
            case 12:
                v vVar = (v) obj;
                objectOutput.writeInt(vVar.f5928a);
                objectOutput.writeByte(vVar.f5929b);
                return;
            case 13:
                o oVar = (o) obj;
                objectOutput.writeByte(oVar.f5882a);
                objectOutput.writeByte(oVar.f5883b);
                return;
            case 14:
                r rVar = (r) obj;
                objectOutput.writeInt(rVar.f5889a);
                objectOutput.writeInt(rVar.f5890b);
                objectOutput.writeInt(rVar.f5891c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.f5892a = readByte;
        this.f5893b = a(readByte, objectInput);
    }

    public static Object a(byte b7, ObjectInput objectInput) {
        switch (b7) {
            case 1:
                Duration duration = Duration.f5733c;
                long readLong = objectInput.readLong();
                long readInt = objectInput.readInt();
                return Duration.e(j$.com.android.tools.r8.a.x(readLong, j$.com.android.tools.r8.a.B(readInt, 1000000000L)), (int) j$.com.android.tools.r8.a.A(readInt, 1000000000L));
            case 2:
                Instant instant = Instant.f5736c;
                return Instant.w(objectInput.readLong(), objectInput.readInt());
            case 3:
                h hVar = h.f5864d;
                return h.D(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return k.F(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f5739c;
                h hVar2 = h.f5864d;
                return LocalDateTime.y(h.D(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.F(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.f5739c;
                h hVar3 = h.f5864d;
                LocalDateTime y9 = LocalDateTime.y(h.D(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.F(objectInput));
                ZoneOffset E = ZoneOffset.E(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(y9, "localDateTime");
                Objects.requireNonNull(E, TypedValues.CycleType.S_WAVE_OFFSET);
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || E.equals(zoneId)) {
                    return new ZonedDateTime(y9, zoneId, E);
                }
                g.c("ZoneId must match ZoneOffset");
                return null;
            case 7:
                int i = w.f5930d;
                return ZoneId.w(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.E(objectInput);
            case 9:
                int i6 = q.f5885c;
                return new q(k.F(objectInput), ZoneOffset.E(objectInput));
            case 10:
                int i10 = OffsetDateTime.f5743c;
                h hVar4 = h.f5864d;
                return new OffsetDateTime(LocalDateTime.y(h.D(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.F(objectInput)), ZoneOffset.E(objectInput));
            case 11:
                int i11 = Year.f5746b;
                return Year.v(objectInput.readInt());
            case 12:
                int i12 = v.f5927c;
                int readInt2 = objectInput.readInt();
                byte readByte = objectInput.readByte();
                j$.time.temporal.a.YEAR.k(readInt2);
                j$.time.temporal.a.MONTH_OF_YEAR.k(readByte);
                return new v(readInt2, readByte);
            case 13:
                int i13 = o.f5881c;
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                m y10 = m.y(readByte2);
                Objects.requireNonNull(y10, "month");
                j$.time.temporal.a.DAY_OF_MONTH.k(readByte3);
                if (readByte3 <= y10.x()) {
                    return new o(y10.getValue(), readByte3);
                }
                throw new b("Illegal value for DayOfMonth field, value " + ((int) readByte3) + " is not valid for month " + y10.name());
            case 14:
                r rVar = r.f5888d;
                int readInt3 = objectInput.readInt();
                int readInt4 = objectInput.readInt();
                int readInt5 = objectInput.readInt();
                return ((readInt3 | readInt4) | readInt5) == 0 ? r.f5888d : new r(readInt3, readInt4, readInt5);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f5893b;
    }
}
