package j$.time;

import j$.util.Objects;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class w extends ZoneId {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f5930d = 0;
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: b, reason: collision with root package name */
    public final String f5931b;

    /* renamed from: c, reason: collision with root package name */
    public final transient j$.time.zone.f f5932c;

    public static w A(String str, boolean z9) {
        j$.time.zone.f fVar;
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length >= 2) {
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i == 0) && ((charAt < '0' || charAt > '9' || i == 0) && ((charAt != '~' || i == 0) && ((charAt != '.' || i == 0) && ((charAt != '_' || i == 0) && ((charAt != '+' || i == 0) && (charAt != '-' || i == 0))))))))) {
                    throw new b("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                }
            }
            try {
                fVar = j$.time.zone.i.a(str);
            } catch (j$.time.zone.g e10) {
                if (z9) {
                    throw e10;
                }
                fVar = null;
            }
            return new w(str, fVar);
        }
        throw new b("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
    }

    public w(String str, j$.time.zone.f fVar) {
        this.f5931b = str;
        this.f5932c = fVar;
    }

    @Override // j$.time.ZoneId
    public final String d() {
        return this.f5931b;
    }

    @Override // j$.time.ZoneId
    public final j$.time.zone.f v() {
        j$.time.zone.f fVar = this.f5932c;
        return fVar != null ? fVar : j$.time.zone.i.a(this.f5931b);
    }

    private Object writeReplace() {
        return new s((byte) 7, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.ZoneId
    public final void z(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.f5931b);
    }
}
