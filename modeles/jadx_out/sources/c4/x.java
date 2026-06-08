package c4;

import android.content.Intent;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2283a;

    /* renamed from: b, reason: collision with root package name */
    public int f2284b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ k0 f2285l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f2286m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x(k0 k0Var, long j, t6.c cVar, int i) {
        super(2, cVar);
        this.f2283a = i;
        this.f2285l = k0Var;
        this.f2286m = j;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2283a) {
            case 0:
                return new x(this.f2285l, this.f2286m, cVar, 0);
            default:
                return new x(this.f2285l, this.f2286m, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2283a) {
        }
        return ((x) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3;
        String message;
        int i = this.f2283a;
        p6.x xVar = p6.x.f8463a;
        long j = this.f2286m;
        Object obj4 = u6.a.f10762a;
        k0 k0Var = this.f2285l;
        switch (i) {
            case 0:
                int i6 = this.f2284b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var = new e1.s0(k0Var, j);
                    this.f2284b = 1;
                    Object a8 = s0Var.a(this);
                    obj2 = a8;
                    if (a8 == obj4) {
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
                    k0Var.x0((x4.g) obj2);
                }
                Throwable a10 = p6.k.a(obj2);
                if (a10 != null) {
                    int i10 = s4.y0.f9323l;
                    if (!d0.b.J(a10)) {
                        String string = k0Var.getString(2131951694);
                        string.getClass();
                        k0Var.A(string);
                        break;
                    } else {
                        k0Var.J();
                        break;
                    }
                }
                break;
            default:
                int i11 = this.f2284b;
                if (i11 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var2 = new e1.s0(k0Var, j);
                    this.f2284b = 1;
                    Object a11 = s0Var2.a(this);
                    obj3 = a11;
                    if (a11 == obj4) {
                        break;
                    }
                } else if (i11 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    obj3 = ((p6.k) obj).f8444a;
                }
                if (!(obj3 instanceof p6.j)) {
                    x4.g gVar = (x4.g) obj3;
                    if (!k0Var.isFinishing()) {
                        Intent intent = new Intent(k0Var, (Class<?>) AppDetailActivity.class);
                        intent.putExtra("appInfo", gVar);
                        float f = UptodownApp.I;
                        k0Var.startActivity(intent, b4.d.a(k0Var));
                    }
                }
                Throwable a12 = p6.k.a(obj3);
                if (a12 != null) {
                    int i12 = s4.y0.f9323l;
                    if (!d0.b.J(a12)) {
                        if (k0Var.T() && (message = a12.getMessage()) != null && message.length() != 0) {
                            String message2 = a12.getMessage();
                            message2.getClass();
                            k0Var.A(message2);
                            break;
                        }
                    } else {
                        k0Var.J();
                        break;
                    }
                }
                break;
        }
        return xVar;
    }
}
