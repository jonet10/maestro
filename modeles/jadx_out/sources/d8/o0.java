package d8;

import com.google.android.gms.internal.measurement.z3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b8.e[] f3683a = new b8.e[0];

    /* renamed from: b, reason: collision with root package name */
    public static final z7.b[] f3684b = new z7.b[0];

    public static final y a(String str, z7.b bVar) {
        return new y(str, new z(bVar));
    }

    public static final Set b(b8.e eVar) {
        eVar.getClass();
        if (eVar instanceof k) {
            return ((k) eVar).b();
        }
        HashSet hashSet = new HashSet(eVar.e());
        int e10 = eVar.e();
        for (int i = 0; i < e10; i++) {
            hashSet.add(eVar.f(i));
        }
        return hashSet;
    }

    public static final b8.e[] c(List list) {
        b8.e[] eVarArr;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            list = null;
        }
        return (list == null || (eVarArr = (b8.e[]) list.toArray(new b8.e[0])) == null) ? f3683a : eVarArr;
    }

    public static final int d(b8.e eVar, b8.e[] eVarArr) {
        eVarArr.getClass();
        int hashCode = (eVar.a().hashCode() * 31) + Arrays.hashCode(eVarArr);
        int e10 = eVar.e();
        int i = 1;
        while (true) {
            int i6 = 0;
            if (!(e10 > 0)) {
                break;
            }
            int i10 = e10 - 1;
            int i11 = i * 31;
            String a8 = eVar.h(eVar.e() - e10).a();
            if (a8 != null) {
                i6 = a8.hashCode();
            }
            i = i11 + i6;
            e10 = i10;
        }
        int e11 = eVar.e();
        int i12 = 1;
        while (true) {
            if (!(e11 > 0)) {
                return (((hashCode * 31) + i) * 31) + i12;
            }
            int i13 = e11 - 1;
            int i14 = i12 * 31;
            z3 kind = eVar.h(eVar.e() - e11).getKind();
            i12 = i14 + (kind != null ? kind.hashCode() : 0);
            e11 = i13;
        }
    }

    public static final void e(b8.e eVar, int i, int i6) {
        eVar.getClass();
        ArrayList arrayList = new ArrayList();
        int i10 = (~i) & i6;
        for (int i11 = 0; i11 < 32; i11++) {
            if ((i10 & 1) != 0) {
                arrayList.add(eVar.f(i11));
            }
            i10 >>>= 1;
        }
        throw new z7.c(eVar.a(), arrayList);
    }

    public static final void f(String str, j7.c cVar) {
        String sb;
        cVar.getClass();
        StringBuilder sb2 = new StringBuilder("in the polymorphic scope of '");
        kotlin.jvm.internal.f fVar = (kotlin.jvm.internal.f) cVar;
        sb2.append(fVar.c());
        sb2.append('\'');
        String sb3 = sb2.toString();
        if (str == null) {
            sb = "Class discriminator was missing and no default serializers were registered " + sb3 + '.';
        } else {
            StringBuilder sb4 = new StringBuilder("Serializer for subclass '");
            sb4.append(str);
            sb4.append("' is not found ");
            sb4.append(sb3);
            sb4.append(".\nCheck if class with serial name '");
            a4.x.B(sb4, str, "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '", str, "' has to be '@Serializable', and the base class '");
            sb4.append(fVar.c());
            sb4.append("' has to be sealed and '@Serializable'.");
            sb = sb4.toString();
        }
        throw new z7.g(sb);
    }
}
