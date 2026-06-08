package b4;

import b5.j;
import com.uptodown.UptodownApp;
import d7.p;
import java.util.ArrayList;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1001a;

    /* renamed from: b, reason: collision with root package name */
    public int f1002b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ UptodownApp f1003l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(UptodownApp uptodownApp, t6.c cVar, int i) {
        super(2, cVar);
        this.f1001a = i;
        this.f1003l = uptodownApp;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1001a) {
            case 0:
                return new f(this.f1003l, cVar, 0);
            case 1:
                return new f(this.f1003l, cVar, 1);
            default:
                return new f(this.f1003l, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1001a) {
        }
        return ((f) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1001a;
        u6.a aVar = u6.a.f10762a;
        UptodownApp uptodownApp = this.f1003l;
        x xVar = x.f8463a;
        t6.c cVar = null;
        switch (i) {
            case 0:
                int i6 = this.f1002b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    float f = UptodownApp.I;
                    this.f1002b = 1;
                    v7.e eVar = m0.f8288a;
                    Object C = c0.C(new b(uptodownApp, null), v7.d.f10884a, this);
                    if (C != aVar) {
                        C = xVar;
                    }
                    if (C == aVar) {
                    }
                } else if (i6 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            case 1:
                int i10 = this.f1002b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    this.f1002b = 1;
                    float f10 = UptodownApp.I;
                    v7.e eVar2 = m0.f8288a;
                    Object C2 = c0.C(new e(uptodownApp, cVar, 0), v7.d.f10884a, this);
                    if (C2 != aVar) {
                        C2 = xVar;
                    }
                    if (C2 == aVar) {
                    }
                } else if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            default:
                int i11 = this.f1002b;
                try {
                    if (i11 == 0) {
                        p6.a.e(obj);
                        ArrayList i12 = j5.a.i(uptodownApp);
                        j5.a aVar2 = new j5.a();
                        this.f1002b = 1;
                        v7.e eVar3 = m0.f8288a;
                        Object C3 = c0.C(new j(uptodownApp, i12, aVar2, (t6.c) null), v7.d.f10884a, this);
                        if (C3 != aVar) {
                            C3 = xVar;
                        }
                        if (C3 == aVar) {
                        }
                    } else if (i11 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        break;
                    } else {
                        p6.a.e(obj);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                    new android.support.v4.media.g(uptodownApp, 20).F("preloadAppsInstalled", e10);
                }
                break;
        }
        return xVar;
    }
}
