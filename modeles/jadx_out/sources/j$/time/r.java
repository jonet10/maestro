package j$.time;

import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class r implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final r f5888d = new r(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;

    /* renamed from: a, reason: collision with root package name */
    public final int f5889a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5890b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5891c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        Object[] objArr = {j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS};
        ArrayList arrayList = new ArrayList(3);
        for (int i = 0; i < 3; i++) {
            arrayList.add(Objects.requireNonNull(objArr[i]));
        }
        Collections.unmodifiableList(arrayList);
    }

    public r(int i, int i6, int i10) {
        this.f5889a = i;
        this.f5890b = i6;
        this.f5891c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f5889a == rVar.f5889a && this.f5890b == rVar.f5890b && this.f5891c == rVar.f5891c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.f5891c, 16) + Integer.rotateLeft(this.f5890b, 8) + this.f5889a;
    }

    public final String toString() {
        if (this == f5888d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
        int i = this.f5889a;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i6 = this.f5890b;
        if (i6 != 0) {
            sb.append(i6);
            sb.append('M');
        }
        int i10 = this.f5891c;
        if (i10 != 0) {
            sb.append(i10);
            sb.append('D');
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 14, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
