package c4;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o5 extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final r7.o0 f1946a;

    /* renamed from: b, reason: collision with root package name */
    public final r7.o0 f1947b;

    /* renamed from: c, reason: collision with root package name */
    public final r7.o0 f1948c;

    /* renamed from: d, reason: collision with root package name */
    public final r7.o0 f1949d;

    /* renamed from: e, reason: collision with root package name */
    public String f1950e;
    public final r7.o0 f;
    public boolean g;

    public o5() {
        r7.o0 b7 = r7.k0.b(j5.p.f6705a);
        this.f1946a = b7;
        this.f1947b = b7;
        this.f1948c = r7.k0.b(new ArrayList());
        this.f1949d = r7.k0.b(new ArrayList());
        this.f = r7.k0.b(1);
    }

    public static final ArrayList a(o5 o5Var, ArrayList arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            x4.r rVar = (x4.r) obj;
            String str2 = rVar.f11366w;
            boolean z9 = true;
            if (str2 == null || str2.length() == 0) {
                String str3 = rVar.f11355b;
                if (str3 != null && str3.length() != 0) {
                    String str4 = rVar.f11355b;
                    str4.getClass();
                    z9 = l7.m.q0(str4, str != null ? str : "", true);
                }
            } else {
                String str5 = rVar.f11366w;
                str5.getClass();
                z9 = l7.m.q0(str5, str != null ? str : "", true);
            }
            if (z9) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public static final void b(o5 o5Var, ArrayList arrayList, m5 m5Var) {
        int ordinal = m5Var.ordinal();
        if (ordinal == 0) {
            if (arrayList.size() > 1) {
                q6.q.j0(arrayList, new n5(1));
            }
        } else if (ordinal == 1) {
            if (arrayList.size() > 1) {
                q6.q.j0(arrayList, new n5(0));
            }
        } else if (ordinal != 2) {
            com.google.gson.internal.a.b();
        } else if (arrayList.size() > 1) {
            q6.q.j0(arrayList, new n5(2));
        }
    }
}
