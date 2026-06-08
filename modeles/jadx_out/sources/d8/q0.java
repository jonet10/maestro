package d8;

import com.google.android.gms.internal.measurement.z3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class q0 implements b8.e, k {

    /* renamed from: a, reason: collision with root package name */
    public final String f3694a;

    /* renamed from: b, reason: collision with root package name */
    public final x f3695b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3696c;

    /* renamed from: d, reason: collision with root package name */
    public int f3697d = -1;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f3698e;
    public final List[] f;
    public final boolean[] g;
    public Object h;
    public final Object i;
    public final Object j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f3699k;

    public q0(String str, x xVar, int i) {
        this.f3694a = str;
        this.f3695b = xVar;
        this.f3696c = i;
        String[] strArr = new String[i];
        for (int i6 = 0; i6 < i; i6++) {
            strArr[i6] = "[UNINITIALIZED]";
        }
        this.f3698e = strArr;
        int i10 = this.f3696c;
        this.f = new List[i10];
        this.g = new boolean[i10];
        this.h = q6.u.f8725a;
        final int i11 = 0;
        d7.a aVar = new d7.a(this) { // from class: d8.p0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ q0 f3690b;

            {
                this.f3690b = this;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, p6.f] */
            @Override // d7.a
            public final Object invoke() {
                z7.b[] childSerializers;
                ArrayList arrayList;
                z7.b[] typeParametersSerializers;
                switch (i11) {
                    case 0:
                        x xVar2 = this.f3690b.f3695b;
                        return (xVar2 == null || (childSerializers = xVar2.childSerializers()) == null) ? o0.f3684b : childSerializers;
                    case 1:
                        x xVar3 = this.f3690b.f3695b;
                        if (xVar3 == null || (typeParametersSerializers = xVar3.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(typeParametersSerializers.length);
                            for (z7.b bVar : typeParametersSerializers) {
                                arrayList.add(bVar.getDescriptor());
                            }
                        }
                        return o0.c(arrayList);
                    default:
                        q0 q0Var = this.f3690b;
                        return Integer.valueOf(o0.d(q0Var, (b8.e[]) q0Var.j.getValue()));
                }
            }
        };
        p6.g gVar = p6.g.f8438a;
        this.i = p6.a.c(gVar, aVar);
        final int i12 = 1;
        this.j = p6.a.c(gVar, new d7.a(this) { // from class: d8.p0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ q0 f3690b;

            {
                this.f3690b = this;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, p6.f] */
            @Override // d7.a
            public final Object invoke() {
                z7.b[] childSerializers;
                ArrayList arrayList;
                z7.b[] typeParametersSerializers;
                switch (i12) {
                    case 0:
                        x xVar2 = this.f3690b.f3695b;
                        return (xVar2 == null || (childSerializers = xVar2.childSerializers()) == null) ? o0.f3684b : childSerializers;
                    case 1:
                        x xVar3 = this.f3690b.f3695b;
                        if (xVar3 == null || (typeParametersSerializers = xVar3.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(typeParametersSerializers.length);
                            for (z7.b bVar : typeParametersSerializers) {
                                arrayList.add(bVar.getDescriptor());
                            }
                        }
                        return o0.c(arrayList);
                    default:
                        q0 q0Var = this.f3690b;
                        return Integer.valueOf(o0.d(q0Var, (b8.e[]) q0Var.j.getValue()));
                }
            }
        });
        final int i13 = 2;
        this.f3699k = p6.a.c(gVar, new d7.a(this) { // from class: d8.p0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ q0 f3690b;

            {
                this.f3690b = this;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, p6.f] */
            @Override // d7.a
            public final Object invoke() {
                z7.b[] childSerializers;
                ArrayList arrayList;
                z7.b[] typeParametersSerializers;
                switch (i13) {
                    case 0:
                        x xVar2 = this.f3690b.f3695b;
                        return (xVar2 == null || (childSerializers = xVar2.childSerializers()) == null) ? o0.f3684b : childSerializers;
                    case 1:
                        x xVar3 = this.f3690b.f3695b;
                        if (xVar3 == null || (typeParametersSerializers = xVar3.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(typeParametersSerializers.length);
                            for (z7.b bVar : typeParametersSerializers) {
                                arrayList.add(bVar.getDescriptor());
                            }
                        }
                        return o0.c(arrayList);
                    default:
                        q0 q0Var = this.f3690b;
                        return Integer.valueOf(o0.d(q0Var, (b8.e[]) q0Var.j.getValue()));
                }
            }
        });
    }

    @Override // b8.e
    public final String a() {
        return this.f3694a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    @Override // d8.k
    public final Set b() {
        return this.h.keySet();
    }

    @Override // b8.e
    public final boolean c() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    @Override // b8.e
    public final int d(String str) {
        str.getClass();
        Integer num = (Integer) this.h.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // b8.e
    public final int e() {
        return this.f3696c;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, p6.f] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, p6.f] */
    public boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj instanceof q0) {
            b8.e eVar = (b8.e) obj;
            if (this.f3694a.equals(eVar.a()) && Arrays.equals((b8.e[]) this.j.getValue(), (b8.e[]) ((q0) obj).j.getValue())) {
                int e10 = eVar.e();
                int i6 = this.f3696c;
                if (i6 == e10) {
                    for (0; i < i6; i + 1) {
                        i = (kotlin.jvm.internal.l.a(h(i).a(), eVar.h(i).a()) && kotlin.jvm.internal.l.a(h(i).getKind(), eVar.h(i).getKind())) ? i + 1 : 0;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // b8.e
    public final String f(int i) {
        return this.f3698e[i];
    }

    @Override // b8.e
    public final List g(int i) {
        List list = this.f[i];
        return list == null ? q6.t.f8724a : list;
    }

    @Override // b8.e
    public final List getAnnotations() {
        return q6.t.f8724a;
    }

    @Override // b8.e
    public z3 getKind() {
        return b8.i.h;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, p6.f] */
    @Override // b8.e
    public b8.e h(int i) {
        return ((z7.b[]) this.i.getValue())[i].getDescriptor();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, p6.f] */
    public int hashCode() {
        return ((Number) this.f3699k.getValue()).intValue();
    }

    @Override // b8.e
    public final boolean i(int i) {
        return this.g[i];
    }

    @Override // b8.e
    public boolean isInline() {
        return false;
    }

    public final void j(String str, boolean z9) {
        str.getClass();
        int i = this.f3697d + 1;
        this.f3697d = i;
        String[] strArr = this.f3698e;
        strArr[i] = str;
        this.g[i] = z9;
        this.f[i] = null;
        if (i == this.f3696c - 1) {
            HashMap hashMap = new HashMap();
            int length = strArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                hashMap.put(strArr[i6], Integer.valueOf(i6));
            }
            this.h = hashMap;
        }
    }

    public String toString() {
        return q6.l.x0(t0.f.K(0, this.f3696c), ", ", this.f3694a.concat("("), ")", new androidx.room.b(this, 15), 24);
    }
}
