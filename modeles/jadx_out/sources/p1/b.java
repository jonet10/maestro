package p1;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.e1;
import com.google.android.gms.internal.measurement.k1;
import e1.c0;
import f0.i;
import g5.g;
import j$.util.concurrent.ConcurrentHashMap;
import k0.y;
import m8.q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b implements a {

    /* renamed from: c, reason: collision with root package name */
    public static volatile b f8416c;

    /* renamed from: a, reason: collision with root package name */
    public final i f8417a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f8418b;

    public b(i iVar) {
        y.g(iVar);
        this.f8417a = iVar;
        this.f8418b = new ConcurrentHashMap();
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (q1.b.f8638c.contains(str) || q1.b.f8637b.contains(str2)) {
            return;
        }
        l1.i iVar = q1.b.f8639d;
        int i = iVar.f7066m;
        int i6 = 0;
        int i10 = 0;
        while (i10 < i) {
            boolean containsKey = bundle.containsKey((String) iVar.get(i10));
            i10++;
            if (containsKey) {
                return;
            }
        }
        if ("_cmp".equals(str2)) {
            if (q1.b.f8638c.contains(str)) {
                return;
            }
            l1.i iVar2 = q1.b.f8639d;
            int i11 = iVar2.f7066m;
            while (i6 < i11) {
                boolean containsKey2 = bundle.containsKey((String) iVar2.get(i6));
                i6++;
                if (containsKey2) {
                    return;
                }
            }
            int hashCode = str.hashCode();
            if (hashCode != 101200) {
                if (hashCode != 101230) {
                    if (hashCode != 3142703 || !str.equals("fiam")) {
                        return;
                    } else {
                        bundle.putString("_cis", "fiam_integration");
                    }
                } else if (!str.equals("fdl")) {
                    return;
                } else {
                    bundle.putString("_cis", "fdl_integration");
                }
            } else if (!str.equals("fcm")) {
                return;
            } else {
                bundle.putString("_cis", "fcm_integration");
            }
        }
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
        k1 k1Var = (k1) this.f8417a.f4811b;
        k1Var.a(new e1(k1Var, str, str2, bundle, true));
    }

    public final c0 b(String str, q qVar) {
        if (!q1.b.f8638c.contains(str)) {
            boolean isEmpty = str.isEmpty();
            ConcurrentHashMap concurrentHashMap = this.f8418b;
            if (isEmpty || !concurrentHashMap.containsKey(str) || concurrentHashMap.get(str) == null) {
                boolean equals = "fiam".equals(str);
                i iVar = this.f8417a;
                a4.i qVar2 = equals ? new q(iVar, qVar) : "clx".equals(str) ? new g(iVar, qVar) : null;
                if (qVar2 != null) {
                    concurrentHashMap.put(str, qVar2);
                    return new c0(27);
                }
            }
        }
        return null;
    }
}
