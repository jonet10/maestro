package c4;

import android.content.Context;
import com.uptodown.activities.AppInstalledDetailsActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1742a;

    /* renamed from: b, reason: collision with root package name */
    public int f1743b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ AppInstalledDetailsActivity f1744l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(AppInstalledDetailsActivity appInstalledDetailsActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1742a = i;
        this.f1744l = appInstalledDetailsActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1742a) {
            case 0:
                return new j(this.f1744l, cVar, 0);
            case 1:
                return new j(this.f1744l, cVar, 1);
            case 2:
                return new j(this.f1744l, cVar, 2);
            case 3:
                return new j(this.f1744l, cVar, 3);
            default:
                return new j(this.f1744l, cVar, 4);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1742a) {
        }
        return ((j) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        x4.r rVar;
        Object a8;
        x4.j jVar;
        int i = this.f1742a;
        int i6 = 0;
        AppInstalledDetailsActivity appInstalledDetailsActivity = this.f1744l;
        u6.a aVar = u6.a.f10762a;
        p6.x xVar = p6.x.f8463a;
        t6.c cVar = null;
        switch (i) {
            case 0:
                int i10 = this.f1743b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    e1.c0 c0Var = j5.g.D;
                    AppInstalledDetailsActivity appInstalledDetailsActivity2 = this.f1744l;
                    Context applicationContext = appInstalledDetailsActivity2.getApplicationContext();
                    applicationContext.getClass();
                    j5.g l10 = c0Var.l(applicationContext);
                    l10.b();
                    x4.e eVar = appInstalledDetailsActivity2.f3301b0;
                    eVar.getClass();
                    String str = eVar.f11123l;
                    str.getClass();
                    x4.q2 Y = l10.Y(str);
                    t6.c cVar2 = null;
                    if (Y != null) {
                        Context applicationContext2 = appInstalledDetailsActivity2.getApplicationContext();
                        applicationContext2.getClass();
                        rVar = Y.a(applicationContext2);
                    } else {
                        rVar = null;
                    }
                    l10.c();
                    if (Y != null && !Y.c()) {
                        v7.e eVar2 = o7.m0.f8288a;
                        p7.c cVar3 = t7.n.f10348a;
                        b5.l lVar = new b5.l(appInstalledDetailsActivity2, Y, rVar, cVar2, 1);
                        this.f1743b = 1;
                        if (o7.c0.C(lVar, cVar3, this) == aVar) {
                        }
                    }
                } else if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            case 1:
                int i11 = this.f1743b;
                if (i11 == 0) {
                    p6.a.e(obj);
                    x4.e eVar3 = appInstalledDetailsActivity.f3301b0;
                    eVar3.getClass();
                    e1.s0 s0Var = new e1.s0(appInstalledDetailsActivity, eVar3.F);
                    this.f1743b = 1;
                    a8 = s0Var.a(this);
                    if (a8 == aVar) {
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
                    appInstalledDetailsActivity.f3302c0 = gVar;
                    if (!appInstalledDetailsActivity.isFinishing() && (jVar = gVar.G) != null && jVar.f11230p == 1) {
                        appInstalledDetailsActivity.R0().Q.setText(appInstalledDetailsActivity.getString(2131951695));
                    }
                }
                Throwable a10 = p6.k.a(a8);
                if (a10 != null) {
                    int i12 = s4.y0.f9323l;
                    if (d0.b.J(a10)) {
                        appInstalledDetailsActivity.J();
                    }
                }
                break;
            case 2:
                int i13 = this.f1743b;
                if (i13 == 0) {
                    p6.a.e(obj);
                    this.f1743b = 1;
                    if (AppInstalledDetailsActivity.N0(appInstalledDetailsActivity, this) == aVar) {
                    }
                } else if (i13 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            case 3:
                int i14 = this.f1743b;
                if (i14 == 0) {
                    p6.a.e(obj);
                    this.f1743b = 1;
                    int i15 = AppInstalledDetailsActivity.f3300e0;
                    v7.e eVar4 = o7.m0.f8288a;
                    Object C = o7.c0.C(new j(appInstalledDetailsActivity, cVar, i6), v7.d.f10884a, this);
                    if (C != aVar) {
                        C = xVar;
                    }
                    if (C == aVar) {
                    }
                } else if (i14 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            default:
                int i16 = this.f1743b;
                if (i16 == 0) {
                    p6.a.e(obj);
                    this.f1743b = 1;
                    int i17 = AppInstalledDetailsActivity.f3300e0;
                    v7.e eVar5 = o7.m0.f8288a;
                    Object C2 = o7.c0.C(new j(appInstalledDetailsActivity, cVar, i6), v7.d.f10884a, this);
                    if (C2 != aVar) {
                        C2 = xVar;
                    }
                    if (C2 == aVar) {
                    }
                } else if (i16 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
        }
        return xVar;
    }
}
