package g4;

import c3.y0;
import com.uptodown.core.activities.InstallerActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5204a;

    /* renamed from: b, reason: collision with root package name */
    public int f5205b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f5206l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k0(InstallerActivity installerActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f5204a = i;
        this.f5206l = installerActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5204a) {
            case 0:
                return new k0(this.f5206l, cVar, 0);
            default:
                return new k0(this.f5206l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5204a) {
            case 0:
                return ((k0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            default:
                ((k0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                return u6.a.f10762a;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f5204a;
        InstallerActivity installerActivity = this.f5206l;
        u6.a aVar = u6.a.f10762a;
        t6.c cVar = null;
        switch (i) {
            case 0:
                int i6 = this.f5205b;
                p6.x xVar = p6.x.f8463a;
                if (i6 == 0) {
                    p6.a.e(obj);
                    this.f5205b = 1;
                    int i10 = InstallerActivity.f3394j0;
                    v7.e eVar = o7.m0.f8288a;
                    Object C = o7.c0.C(new b.e(installerActivity, cVar, 5), v7.d.f10884a, this);
                    if (C != aVar) {
                        C = xVar;
                    }
                    if (C == aVar) {
                        return aVar;
                    }
                } else {
                    if (i6 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                }
                return xVar;
            default:
                int i11 = this.f5205b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                r7.d0 d0Var = f4.a.f4873e;
                y0 y0Var = new y0(installerActivity, 18);
                this.f5205b = 1;
                d0Var.f8968a.collect(y0Var, this);
                return aVar;
        }
    }
}
