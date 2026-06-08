package j$.time.chrono;

import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class h implements Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f5772e = 0;
    private static final long serialVersionUID = 57387258289L;

    /* renamed from: a, reason: collision with root package name */
    public final l f5773a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5774b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5775c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5776d;

    static {
        Object[] objArr = {j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS};
        ArrayList arrayList = new ArrayList(3);
        for (int i = 0; i < 3; i++) {
            arrayList.add(Objects.requireNonNull(objArr[i]));
        }
        Collections.unmodifiableList(arrayList);
    }

    public h(l lVar, int i, int i6, int i10) {
        Objects.requireNonNull(lVar, "chrono");
        this.f5773a = lVar;
        this.f5774b = i;
        this.f5775c = i6;
        this.f5776d = i10;
    }

    public final String toString() {
        if (this.f5774b == 0 && this.f5775c == 0 && this.f5776d == 0) {
            return this.f5773a.toString() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5773a.toString());
        sb.append(" P");
        int i = this.f5774b;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i6 = this.f5775c;
        if (i6 != 0) {
            sb.append(i6);
            sb.append('M');
        }
        int i10 = this.f5776d;
        if (i10 != 0) {
            sb.append(i10);
            sb.append('D');
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f5774b == hVar.f5774b && this.f5775c == hVar.f5775c && this.f5776d == hVar.f5776d && this.f5773a.equals(hVar.f5773a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Integer.rotateLeft(this.f5776d, 16) + (Integer.rotateLeft(this.f5775c, 8) + this.f5774b)) ^ this.f5773a.hashCode();
    }

    public Object writeReplace() {
        return new e0((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
