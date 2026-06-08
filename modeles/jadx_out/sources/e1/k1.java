package e1;

import com.google.android.gms.internal.measurement.x5;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class k1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4069a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m1 f4070b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4071c;

    public /* synthetic */ k1(m1 m1Var, String str, int i) {
        this.f4069a = i;
        this.f4070b = m1Var;
        this.f4071c = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4069a) {
            case 0:
                return new com.google.android.gms.internal.measurement.k4(new k1(this.f4070b, this.f4071c, 1));
            case 1:
                m1 m1Var = this.f4070b;
                m mVar = m1Var.f4092b.f4307l;
                u4.U(mVar);
                String str = this.f4071c;
                b1 i02 = mVar.i0(str);
                HashMap hashMap = new HashMap();
                hashMap.put("platform", "android");
                hashMap.put("package_name", str);
                m1Var.f3875a.f4262m.l();
                hashMap.put("gmp_version", 133005L);
                if (i02 != null) {
                    String N = i02.N();
                    if (N != null) {
                        hashMap.put("app_version", N);
                    }
                    hashMap.put("app_version_int", Long.valueOf(i02.P()));
                    hashMap.put("dynamite_version", Long.valueOf(i02.b()));
                }
                return hashMap;
            default:
                android.support.v4.media.g gVar = new android.support.v4.media.g(this.f4070b, this.f4071c, 6, false);
                x5 x5Var = new x5("internal.remoteConfig", 0);
                x5Var.f2651b.put("getValue", new com.google.android.gms.internal.measurement.k4(x5Var, gVar));
                return x5Var;
        }
    }
}
