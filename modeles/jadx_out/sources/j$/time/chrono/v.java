package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class v extends a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final v f5800c = new v();
    private static final long serialVersionUID = 459996390165777884L;

    @Override // j$.time.chrono.l
    public final String d() {
        return "Japanese";
    }

    @Override // j$.time.chrono.l
    public final String i() {
        return "japanese";
    }

    @Override // j$.time.chrono.l
    public final b o(j$.time.temporal.n nVar) {
        if (nVar instanceof x) {
            return (x) nVar;
        }
        return new x(j$.time.h.x(nVar));
    }

    private v() {
    }

    @Override // j$.time.chrono.l
    public final m l(int i) {
        return y.l(i);
    }

    public final j$.time.temporal.u f(j$.time.temporal.a aVar) {
        switch (u.f5799a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                j$.time.g.b(aVar, "Unsupported field: ");
                return null;
            case 5:
                y[] yVarArr = y.f5807e;
                int i = yVarArr[yVarArr.length - 1].f5809b.f5866a;
                int i6 = 1000000000 - yVarArr[yVarArr.length - 1].f5809b.f5866a;
                int i10 = yVarArr[0].f5809b.f5866a;
                int i11 = 1;
                while (true) {
                    y[] yVarArr2 = y.f5807e;
                    if (i11 >= yVarArr2.length) {
                        return j$.time.temporal.u.f(i6, 999999999 - i);
                    }
                    y yVar = yVarArr2[i11];
                    i6 = Math.min(i6, (yVar.f5809b.f5866a - i10) + 1);
                    i10 = yVar.f5809b.f5866a;
                    i11++;
                }
            case 6:
                y yVar2 = y.f5806d;
                long j = j$.time.temporal.a.DAY_OF_YEAR.f5898b.f5923c;
                for (y yVar3 : y.f5807e) {
                    j = Math.min(j, ((yVar3.f5809b.B() ? 366 : 365) - yVar3.f5809b.A()) + 1);
                    if (yVar3.i() != null) {
                        j = Math.min(j, yVar3.i().f5809b.A() - 1);
                    }
                }
                return j$.time.temporal.u.f(j, j$.time.temporal.a.DAY_OF_YEAR.f5898b.f5924d);
            case 7:
                return j$.time.temporal.u.e(x.f5802d.f5866a, 999999999L);
            case 8:
                long j6 = y.f5806d.f5808a;
                y[] yVarArr3 = y.f5807e;
                return j$.time.temporal.u.e(j6, yVarArr3[yVarArr3.length - 1].f5808a);
            default:
                return aVar.f5898b;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }
}
