package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class e0 implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;

    /* renamed from: a, reason: collision with root package name */
    public byte f5765a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5766b;

    public e0() {
    }

    public e0(byte b7, Object obj) {
        this.f5765a = b7;
        this.f5766b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b7 = this.f5765a;
        Object obj = this.f5766b;
        objectOutput.writeByte(b7);
        switch (b7) {
            case 1:
                objectOutput.writeUTF(((a) obj).d());
                return;
            case 2:
                g gVar = (g) obj;
                objectOutput.writeObject(gVar.f5769a);
                objectOutput.writeObject(gVar.f5770b);
                return;
            case 3:
                k kVar = (k) obj;
                objectOutput.writeObject(kVar.f5782a);
                objectOutput.writeObject(kVar.f5783b);
                objectOutput.writeObject(kVar.f5784c);
                return;
            case 4:
                x xVar = (x) obj;
                xVar.getClass();
                objectOutput.writeInt(j$.time.temporal.r.a(xVar, j$.time.temporal.a.YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(xVar, j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(xVar, j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 5:
                objectOutput.writeByte(((y) obj).f5808a);
                return;
            case 6:
                q qVar = (q) obj;
                objectOutput.writeObject(qVar.f5792a);
                objectOutput.writeInt(j$.time.temporal.r.a(qVar, j$.time.temporal.a.YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(qVar, j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(qVar, j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 7:
                c0 c0Var = (c0) obj;
                c0Var.getClass();
                objectOutput.writeInt(j$.time.temporal.r.a(c0Var, j$.time.temporal.a.YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(c0Var, j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(c0Var, j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 8:
                i0 i0Var = (i0) obj;
                i0Var.getClass();
                objectOutput.writeInt(j$.time.temporal.r.a(i0Var, j$.time.temporal.a.YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(i0Var, j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(i0Var, j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 9:
                h hVar = (h) obj;
                objectOutput.writeUTF(hVar.f5773a.d());
                objectOutput.writeInt(hVar.f5774b);
                objectOutput.writeInt(hVar.f5775c);
                objectOutput.writeInt(hVar.f5776d);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        Object E;
        byte readByte = objectInput.readByte();
        this.f5765a = readByte;
        switch (readByte) {
            case 1:
                ConcurrentHashMap concurrentHashMap = a.f5758a;
                E = j$.com.android.tools.r8.a.E(objectInput.readUTF());
                break;
            case 2:
                E = ((b) objectInput.readObject()).s((j$.time.k) objectInput.readObject());
                break;
            case 3:
                E = ((e) objectInput.readObject()).h((ZoneOffset) objectInput.readObject()).m((ZoneId) objectInput.readObject());
                break;
            case 4:
                j$.time.h hVar = x.f5802d;
                int readInt = objectInput.readInt();
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                v.f5800c.getClass();
                E = new x(j$.time.h.D(readInt, readByte2, readByte3));
                break;
            case 5:
                y yVar = y.f5806d;
                E = y.l(objectInput.readByte());
                break;
            case 6:
                o oVar = (o) objectInput.readObject();
                int readInt2 = objectInput.readInt();
                byte readByte4 = objectInput.readByte();
                byte readByte5 = objectInput.readByte();
                oVar.getClass();
                E = new q(oVar, readInt2, readByte4, readByte5);
                break;
            case 7:
                int readInt3 = objectInput.readInt();
                byte readByte6 = objectInput.readByte();
                byte readByte7 = objectInput.readByte();
                a0.f5760c.getClass();
                E = new c0(j$.time.h.D(readInt3 + 1911, readByte6, readByte7));
                break;
            case 8:
                int readInt4 = objectInput.readInt();
                byte readByte8 = objectInput.readByte();
                byte readByte9 = objectInput.readByte();
                g0.f5771c.getClass();
                E = new i0(j$.time.h.D(readInt4 - 543, readByte8, readByte9));
                break;
            case 9:
                int i = h.f5772e;
                E = new h(j$.com.android.tools.r8.a.E(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f5766b = E;
    }

    private Object readResolve() {
        return this.f5766b;
    }
}
