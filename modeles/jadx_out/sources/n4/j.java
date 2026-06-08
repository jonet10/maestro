package n4;

import android.os.Bundle;
import com.uptodown.core.activities.InstallerActivity;
import g4.e0;
import g4.h0;
import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7970a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f7971b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f7972l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f7973m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(h0 h0Var, String str, String str2, t6.c cVar, int i) {
        super(2, cVar);
        this.f7970a = i;
        this.f7971b = h0Var;
        this.f7972l = str;
        this.f7973m = str2;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f7970a) {
            case 0:
                return new j(this.f7971b, this.f7972l, this.f7973m, cVar, 0);
            case 1:
                return new j(this.f7971b, this.f7972l, this.f7973m, cVar, 1);
            default:
                return new j(this.f7971b, this.f7972l, this.f7973m, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f7970a) {
            case 0:
                j jVar = (j) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                jVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                j jVar2 = (j) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                jVar2.invokeSuspend(xVar2);
                return xVar2;
            default:
                j jVar3 = (j) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                jVar3.invokeSuspend(xVar3);
                return xVar3;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f7970a) {
            case 0:
                p6.a.e(obj);
                h0 h0Var = this.f7971b;
                if (h0Var != null) {
                    h0Var.f5190a.M("invalid version code");
                }
                if (f4.c.f4881u != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("packageName", this.f7973m);
                    z4.d dVar = f4.c.f4881u;
                    if (dVar != null) {
                        dVar.send(304, bundle);
                    }
                }
                break;
            case 1:
                p6.a.e(obj);
                h0 h0Var2 = this.f7971b;
                if (h0Var2 != null) {
                    InstallerActivity installerActivity = h0Var2.f5190a;
                    installerActivity.runOnUiThread(new e0(installerActivity, 0));
                }
                if (f4.c.f4881u != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("packageName", this.f7973m);
                    z4.d dVar2 = f4.c.f4881u;
                    if (dVar2 != null) {
                        dVar2.send(301, bundle2);
                    }
                }
                break;
            default:
                p6.a.e(obj);
                h0 h0Var3 = this.f7971b;
                if (h0Var3 != null) {
                    h0Var3.f5190a.finish();
                }
                if (f4.c.f4881u != null) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("packageName", this.f7973m);
                    bundle3.putString("filename", this.f7972l);
                    z4.d dVar3 = f4.c.f4881u;
                    if (dVar3 != null) {
                        dVar3.send(302, bundle3);
                    }
                }
                break;
        }
        return p6.x.f8463a;
    }
}
