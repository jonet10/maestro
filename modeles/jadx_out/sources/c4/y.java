package c4;

import android.content.Intent;
import com.uptodown.UptodownApp;
import com.uptodown.activities.VirusTotalReport;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2323a;

    /* renamed from: b, reason: collision with root package name */
    public int f2324b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ k0 f2325l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Long f2326m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ x4.f2 f2327n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(k0 k0Var, Long l10, x4.f2 f2Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f2323a = i;
        this.f2325l = k0Var;
        this.f2326m = l10;
        this.f2327n = f2Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2323a) {
            case 0:
                return new y(this.f2325l, this.f2326m, this.f2327n, cVar, 0);
            default:
                return new y(this.f2325l, this.f2326m, this.f2327n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2323a) {
        }
        return ((y) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object a8;
        Object a10;
        int i = this.f2323a;
        p6.x xVar = p6.x.f8463a;
        x4.f2 f2Var = this.f2327n;
        Long l10 = this.f2326m;
        u6.a aVar = u6.a.f10762a;
        k0 k0Var = this.f2325l;
        switch (i) {
            case 0:
                int i6 = this.f2324b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var = new e1.s0(k0Var, l10.longValue());
                    this.f2324b = 1;
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
                    Intent intent = new Intent(k0Var, (Class<?>) VirusTotalReport.class);
                    intent.putExtra("appInfo", (x4.g) a8);
                    intent.putExtra("appReportVT", f2Var);
                    float f = UptodownApp.I;
                    k0Var.startActivity(intent, b4.d.a(k0Var));
                    break;
                }
                break;
            default:
                int i10 = this.f2324b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var2 = new e1.s0(k0Var, l10.longValue());
                    this.f2324b = 1;
                    a10 = s0Var2.a(this);
                    if (a10 == aVar) {
                        break;
                    }
                } else if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    a10 = ((p6.k) obj).f8444a;
                }
                if (!(a10 instanceof p6.j)) {
                    Intent intent2 = new Intent(k0Var, (Class<?>) VirusTotalReport.class);
                    intent2.putExtra("appInfo", (x4.g) a10);
                    intent2.putExtra("appReportVT", f2Var);
                    float f10 = UptodownApp.I;
                    k0Var.startActivity(intent2, b4.d.a(k0Var));
                    break;
                }
                break;
        }
        return xVar;
    }
}
