package c4;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n3 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1892a;

    /* renamed from: b, reason: collision with root package name */
    public int f1893b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1894l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f1895m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n3(MainActivity mainActivity, long j, t6.c cVar, int i) {
        super(2, cVar);
        this.f1892a = i;
        this.f1894l = mainActivity;
        this.f1895m = j;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1892a) {
            case 0:
                return new n3(this.f1894l, this.f1895m, cVar, 0);
            default:
                return new n3(this.f1894l, this.f1895m, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1892a) {
        }
        return ((n3) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object a8;
        int i = this.f1892a;
        p6.x xVar = p6.x.f8463a;
        long j = this.f1895m;
        Object obj3 = u6.a.f10762a;
        MainActivity mainActivity = this.f1894l;
        PackageInfo packageInfo = null;
        switch (i) {
            case 0:
                int i6 = this.f1893b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var = new e1.s0(mainActivity, j);
                    this.f1893b = 1;
                    Object a10 = s0Var.a(this);
                    obj2 = a10;
                    if (a10 == obj3) {
                        break;
                    }
                } else if (i6 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    obj2 = ((p6.k) obj).f8444a;
                }
                if (!(obj2 instanceof p6.j)) {
                    mainActivity.x0((x4.g) obj2);
                    mainActivity.f3320s0 = -1L;
                }
                Throwable a11 = p6.k.a(obj2);
                if (a11 != null) {
                    mainActivity.f3320s0 = -1L;
                    int i10 = s4.y0.f9323l;
                    if (!d0.b.J(a11)) {
                        String message = a11.getMessage();
                        if (message != null && message.length() != 0) {
                            String message2 = a11.getMessage();
                            message2.getClass();
                            mainActivity.A(message2);
                            break;
                        }
                    } else {
                        mainActivity.J();
                        break;
                    }
                }
                break;
            default:
                int i11 = this.f1893b;
                if (i11 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var2 = new e1.s0(mainActivity, j);
                    this.f1893b = 1;
                    a8 = s0Var2.a(this);
                    if (a8 == obj3) {
                        break;
                    }
                } else if (i11 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    a8 = ((p6.k) obj).f8444a;
                }
                if (!(a8 instanceof p6.j)) {
                    x4.g gVar = (x4.g) a8;
                    String str = gVar.F;
                    if (str != null) {
                        try {
                            PackageManager packageManager = mainActivity.getPackageManager();
                            if (packageManager != null) {
                                packageInfo = n4.i.e(packageManager, str, 0);
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                    }
                    if (packageInfo != null) {
                        MainActivity.N0(mainActivity);
                    } else {
                        MainActivity.M0(mainActivity, gVar);
                    }
                }
                Throwable a12 = p6.k.a(a8);
                if (a12 != null) {
                    int i12 = s4.y0.f9323l;
                    if (!d0.b.J(a12)) {
                        MainActivity.N0(mainActivity);
                        break;
                    } else {
                        mainActivity.J();
                        break;
                    }
                }
                break;
        }
        return xVar;
    }
}
