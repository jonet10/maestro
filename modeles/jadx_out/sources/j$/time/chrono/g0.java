package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class g0 extends a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final g0 f5771c = new g0();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap.put("en", new String[]{"BB", "BE"});
        hashMap.put("th", new String[]{"BB", "BE"});
        hashMap2.put("en", new String[]{"B.B.", "B.E."});
        hashMap2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        hashMap3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        hashMap3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    @Override // j$.time.chrono.l
    public final m l(int i) {
        if (i == 0) {
            return j0.BEFORE_BE;
        }
        if (i == 1) {
            return j0.BE;
        }
        j$.time.g.d("Invalid era: ", i);
        return null;
    }

    @Override // j$.time.chrono.l
    public final String d() {
        return "ThaiBuddhist";
    }

    @Override // j$.time.chrono.l
    public final String i() {
        return "buddhist";
    }

    @Override // j$.time.chrono.l
    public final b o(j$.time.temporal.n nVar) {
        if (nVar instanceof i0) {
            return (i0) nVar;
        }
        return new i0(j$.time.h.x(nVar));
    }

    private g0() {
    }

    public final j$.time.temporal.u f(j$.time.temporal.a aVar) {
        int i = f0.f5768a[aVar.ordinal()];
        if (i == 1) {
            j$.time.temporal.u uVar = j$.time.temporal.a.PROLEPTIC_MONTH.f5898b;
            return j$.time.temporal.u.e(uVar.f5921a + 6516, uVar.f5924d + 6516);
        }
        if (i == 2) {
            j$.time.temporal.u uVar2 = j$.time.temporal.a.YEAR.f5898b;
            return j$.time.temporal.u.f((-(uVar2.f5921a + 543)) + 1, uVar2.f5924d + 543);
        }
        if (i != 3) {
            return aVar.f5898b;
        }
        j$.time.temporal.u uVar3 = j$.time.temporal.a.YEAR.f5898b;
        return j$.time.temporal.u.e(uVar3.f5921a + 543, uVar3.f5924d + 543);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }
}
