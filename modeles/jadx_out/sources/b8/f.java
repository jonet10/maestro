package b8;

import c4.w6;
import com.google.android.gms.internal.measurement.z3;
import d8.k;
import d8.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p6.m;
import q6.a0;
import q6.l;
import q6.n;
import q6.t;
import q6.w;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements e, k {

    /* renamed from: a, reason: collision with root package name */
    public final String f1112a;

    /* renamed from: b, reason: collision with root package name */
    public final z3 f1113b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1114c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f1115d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f1116e;
    public final e[] f;
    public final List[] g;
    public final boolean[] h;
    public final Map i;
    public final e[] j;

    /* renamed from: k, reason: collision with root package name */
    public final m f1117k;

    public f(String str, z3 z3Var, int i, List list, a aVar) {
        this.f1112a = str;
        this.f1113b = z3Var;
        this.f1114c = i;
        ArrayList arrayList = aVar.f1099b;
        arrayList.getClass();
        HashSet hashSet = new HashSet(a0.h0(n.i0(arrayList, 12)));
        l.E0(arrayList, hashSet);
        this.f1115d = hashSet;
        int i6 = 0;
        this.f1116e = (String[]) arrayList.toArray(new String[0]);
        this.f = o0.c(aVar.f1101d);
        this.g = (List[]) aVar.f1102e.toArray(new List[0]);
        ArrayList arrayList2 = aVar.f;
        arrayList2.getClass();
        boolean[] zArr = new boolean[arrayList2.size()];
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            zArr[i6] = ((Boolean) obj).booleanValue();
            i6++;
        }
        this.h = zArr;
        String[] strArr = this.f1116e;
        strArr.getClass();
        k7.k kVar = new k7.k(new w6(strArr, 22), 2);
        ArrayList arrayList3 = new ArrayList(n.i0(kVar, 10));
        Iterator it = kVar.iterator();
        while (true) {
            kotlin.jvm.internal.b bVar = (kotlin.jvm.internal.b) it;
            if (!((Iterator) bVar.f7015l).hasNext()) {
                this.i = a0.k0(arrayList3);
                this.j = o0.c(list);
                this.f1117k = new m(new androidx.room.g(this, 7));
                return;
            }
            w wVar = (w) bVar.next();
            arrayList3.add(new p6.i(wVar.f8728b, Integer.valueOf(wVar.f8727a)));
        }
    }

    @Override // b8.e
    public final String a() {
        return this.f1112a;
    }

    @Override // d8.k
    public final Set b() {
        return this.f1115d;
    }

    @Override // b8.e
    public final boolean c() {
        return false;
    }

    @Override // b8.e
    public final int d(String str) {
        str.getClass();
        Integer num = (Integer) this.i.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // b8.e
    public final int e() {
        return this.f1114c;
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            e eVar = (e) obj;
            if (this.f1112a.equals(eVar.a()) && Arrays.equals(this.j, ((f) obj).j)) {
                int e10 = eVar.e();
                int i6 = this.f1114c;
                if (i6 == e10) {
                    for (0; i < i6; i + 1) {
                        e[] eVarArr = this.f;
                        i = (kotlin.jvm.internal.l.a(eVarArr[i].a(), eVar.h(i).a()) && kotlin.jvm.internal.l.a(eVarArr[i].getKind(), eVar.h(i).getKind())) ? i + 1 : 0;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // b8.e
    public final String f(int i) {
        return this.f1116e[i];
    }

    @Override // b8.e
    public final List g(int i) {
        return this.g[i];
    }

    @Override // b8.e
    public final List getAnnotations() {
        return t.f8724a;
    }

    @Override // b8.e
    public final z3 getKind() {
        return this.f1113b;
    }

    @Override // b8.e
    public final e h(int i) {
        return this.f[i];
    }

    public final int hashCode() {
        return ((Number) this.f1117k.getValue()).intValue();
    }

    @Override // b8.e
    public final boolean i(int i) {
        return this.h[i];
    }

    @Override // b8.e
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return l.x0(t0.f.K(0, this.f1114c), ", ", this.f1112a.concat("("), ")", new androidx.room.b(this, 10), 24);
    }
}
