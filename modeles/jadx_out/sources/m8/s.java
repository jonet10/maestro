package m8;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f7786a;

    public s(g5.f fVar) {
        ArrayList arrayList = (ArrayList) fVar.f5309b;
        this.f7786a = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final String a(String str) {
        String[] strArr = this.f7786a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public final String b(int i) {
        return this.f7786a[i * 2];
    }

    public final g5.f c() {
        g5.f fVar = new g5.f(9);
        Collections.addAll((ArrayList) fVar.f5309b, this.f7786a);
        return fVar;
    }

    public final int d() {
        return this.f7786a.length / 2;
    }

    public final String e(int i) {
        return this.f7786a[(i * 2) + 1];
    }

    public final boolean equals(Object obj) {
        return (obj instanceof s) && Arrays.equals(((s) obj).f7786a, this.f7786a);
    }

    public final List f(String str) {
        int d10 = d();
        ArrayList arrayList = null;
        for (int i = 0; i < d10; i++) {
            if (str.equalsIgnoreCase(b(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(e(i));
            }
        }
        return arrayList != null ? DesugarCollections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f7786a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int d10 = d();
        for (int i = 0; i < d10; i++) {
            sb.append(b(i));
            sb.append(": ");
            sb.append(e(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
