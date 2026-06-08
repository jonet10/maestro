package w6;

import java.io.Serializable;
import q6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends e implements a, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Enum[] f10931a;

    public b(Enum[] enumArr) {
        enumArr.getClass();
        this.f10931a = enumArr;
    }

    @Override // q6.a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r42 = (Enum) obj;
        int ordinal = r42.ordinal();
        Enum[] enumArr = this.f10931a;
        enumArr.getClass();
        return ((ordinal < 0 || ordinal >= enumArr.length) ? null : enumArr[ordinal]) == r42;
    }

    @Override // java.util.List
    public final Object get(int i) {
        q6.b bVar = e.Companion;
        Enum[] enumArr = this.f10931a;
        int length = enumArr.length;
        bVar.getClass();
        q6.b.b(i, length);
        return enumArr[i];
    }

    @Override // q6.a
    public final int getSize() {
        return this.f10931a.length;
    }

    @Override // q6.e, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r52 = (Enum) obj;
        int ordinal = r52.ordinal();
        Enum[] enumArr = this.f10931a;
        enumArr.getClass();
        if (((ordinal < 0 || ordinal >= enumArr.length) ? null : enumArr[ordinal]) == r52) {
            return ordinal;
        }
        return -1;
    }

    @Override // q6.e, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r52 = (Enum) obj;
        int ordinal = r52.ordinal();
        Enum[] enumArr = this.f10931a;
        enumArr.getClass();
        if (((ordinal < 0 || ordinal >= enumArr.length) ? null : enumArr[ordinal]) == r52) {
            return ordinal;
        }
        return -1;
    }
}
