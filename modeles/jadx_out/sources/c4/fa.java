package c4;

import android.content.Intent;
import com.uptodown.UptodownApp;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.VirusTotalReport;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class fa extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1604a;

    /* renamed from: b, reason: collision with root package name */
    public int f1605b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ SecurityActivity f1606l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ x4.e f1607m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fa(SecurityActivity securityActivity, x4.e eVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f1604a = i;
        this.f1606l = securityActivity;
        this.f1607m = eVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1604a) {
            case 0:
                return new fa(this.f1606l, this.f1607m, cVar, 0);
            default:
                return new fa(this.f1606l, this.f1607m, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1604a) {
        }
        return ((fa) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object a8;
        Object D;
        int i = this.f1604a;
        p6.x xVar = p6.x.f8463a;
        u6.a aVar = u6.a.f10762a;
        SecurityActivity securityActivity = this.f1606l;
        x4.e eVar = this.f1607m;
        switch (i) {
            case 0:
                int i6 = this.f1605b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var = new e1.s0(securityActivity, eVar.F);
                    this.f1605b = 1;
                    a8 = s0Var.a(this);
                    if (a8 == aVar) {
                        break;
                    }
                } else if (i6 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    a8 = ((p6.k) obj).f8444a;
                }
                if (!(a8 instanceof p6.j)) {
                    x4.g gVar = (x4.g) a8;
                    if (gVar.b()) {
                        Intent intent = new Intent(securityActivity.getApplicationContext(), (Class<?>) OldVersionsActivity.class);
                        intent.putExtra("app", eVar);
                        intent.putExtra("appInfo", gVar);
                        float f = UptodownApp.I;
                        securityActivity.startActivity(intent, b4.d.a(securityActivity));
                    } else {
                        String string = securityActivity.getString(2131952550, gVar.f11159b);
                        string.getClass();
                        securityActivity.A(string);
                    }
                }
                Throwable a10 = p6.k.a(a8);
                if (a10 != null) {
                    int i10 = s4.y0.f9323l;
                    if (!d0.b.J(a10)) {
                        String string2 = securityActivity.getString(2131952550, eVar.f11122b);
                        string2.getClass();
                        securityActivity.A(string2);
                        break;
                    } else {
                        securityActivity.J();
                        break;
                    }
                }
                break;
            default:
                int i11 = this.f1605b;
                if (i11 == 0) {
                    p6.a.e(obj);
                    b5.m mVar = new b5.m(securityActivity, (Object) null, eVar.B, 22);
                    this.f1605b = 1;
                    D = mVar.D(this);
                    if (D == aVar) {
                        break;
                    }
                } else if (i11 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    D = ((p6.k) obj).f8444a;
                }
                if (!(D instanceof p6.j)) {
                    Intent intent2 = new Intent(securityActivity, (Class<?>) VirusTotalReport.class);
                    intent2.putExtra("app_selected", eVar);
                    intent2.putExtra("appReportVT", (x4.f2) D);
                    float f10 = UptodownApp.I;
                    securityActivity.startActivity(intent2, b4.d.a(securityActivity));
                }
                if (p6.k.a(D) != null) {
                    Intent intent3 = new Intent(securityActivity, (Class<?>) VirusTotalReport.class);
                    intent3.putExtra("app_selected", eVar);
                    intent3.putExtra("isVirusTotalReportAvaialable", false);
                    float f11 = UptodownApp.I;
                    securityActivity.startActivity(intent3, b4.d.a(securityActivity));
                    break;
                }
                break;
        }
        return xVar;
    }
}
