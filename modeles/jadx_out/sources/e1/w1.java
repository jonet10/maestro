package e1;

import android.os.Bundle;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4347a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4348b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f4349l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f4350m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f4351n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f4352o;

    public w1(m3 m3Var, Bundle bundle, j3 j3Var, j3 j3Var2, long j) {
        this.f4347a = 2;
        this.f4348b = bundle;
        this.f4349l = j3Var;
        this.f4351n = j3Var2;
        this.f4350m = j;
        Objects.requireNonNull(m3Var);
        this.f4352o = m3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4347a) {
            case 0:
                String str = (String) this.f4349l;
                c2 c2Var = (c2) this.f4352o;
                String str2 = (String) this.f4348b;
                if (str2 != null) {
                    j3 j3Var = new j3(this.f4350m, (String) this.f4351n, str2);
                    u4 u4Var = c2Var.i;
                    u4Var.b().g();
                    String str3 = u4Var.P;
                    if (str3 != null) {
                        str3.equals(str);
                    }
                    u4Var.P = str;
                    u4Var.O = j3Var;
                    break;
                } else {
                    u4 u4Var2 = c2Var.i;
                    u4Var2.b().g();
                    String str4 = u4Var2.P;
                    if (str4 == null || str4.equals(str)) {
                        u4Var2.P = str;
                        u4Var2.O = null;
                        break;
                    }
                }
                break;
            case 1:
                b3 b3Var = (b3) this.f4352o;
                String str5 = (String) this.f4348b;
                String str6 = (String) this.f4349l;
                b3Var.r(this.f4350m, this.f4351n, str5, str6);
                break;
            default:
                m3 m3Var = (m3) this.f4352o;
                Bundle bundle = (Bundle) this.f4348b;
                j3 j3Var2 = (j3) this.f4349l;
                j3 j3Var3 = (j3) this.f4351n;
                m3Var.getClass();
                bundle.remove("screen_name");
                bundle.remove("screen_class");
                a5 a5Var = m3Var.f3875a.f4267r;
                t1.k(a5Var);
                m3Var.q(j3Var2, j3Var3, this.f4350m, true, a5Var.o("screen_view", bundle, null, false));
                break;
        }
    }

    public /* synthetic */ w1(Object obj, String str, String str2, Object obj2, long j, int i) {
        this.f4347a = i;
        this.f4348b = str;
        this.f4349l = str2;
        this.f4351n = obj2;
        this.f4350m = j;
        this.f4352o = obj;
    }
}
