package o3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.IntSupplier;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends a {

    /* renamed from: d, reason: collision with root package name */
    public final IntSupplier f8154d;

    public e(IntSupplier intSupplier, ArrayList arrayList) {
        super(true);
        this.f8154d = intSupplier;
        setValue(arrayList);
    }

    @Override // o3.a
    public final void a(String str) {
        try {
            this.f8150c = p3.d.a(str);
        } catch (Exception e10) {
            throw new q3.a(e10);
        }
    }

    @Override // o3.a
    public final String b() {
        try {
            return p3.d.b(this.f8154d.getAsInt(), (List) this.f8150c);
        } catch (Exception e10) {
            throw new a1.b(e10);
        }
    }

    @Override // o3.a
    public final String c(int i, String str) {
        try {
            return str.substring(i, this.f8154d.getAsInt() + i);
        } catch (Exception e10) {
            throw new g(e10);
        }
    }

    @Override // o3.a, o3.b
    public final Object getValue() {
        return new ArrayList((Collection) this.f8150c);
    }

    @Override // o3.a, o3.b
    public final void setValue(Object obj) {
        int asInt = this.f8154d.getAsInt();
        ArrayList arrayList = new ArrayList((List) obj);
        for (int size = arrayList.size(); size < asInt; size++) {
            arrayList.add(Boolean.FALSE);
        }
        int size2 = arrayList.size();
        List list = arrayList;
        if (size2 > asInt) {
            list = arrayList.subList(0, asInt);
        }
        super.setValue(list);
    }
}
