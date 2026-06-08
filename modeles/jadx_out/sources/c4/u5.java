package c4;

import androidx.lifecycle.ViewModelKt;
import com.uptodown.activities.NotificationsRegistryActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u5 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2159a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NotificationsRegistryActivity f2160b;

    /* renamed from: l, reason: collision with root package name */
    public int f2161l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u5(NotificationsRegistryActivity notificationsRegistryActivity, int i, t6.c cVar, int i6) {
        super(2, cVar);
        this.f2159a = i6;
        this.f2160b = notificationsRegistryActivity;
        this.f2161l = i;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2159a) {
            case 0:
                return new u5(this.f2160b, cVar);
            case 1:
                return new u5(this.f2160b, this.f2161l, cVar, 1);
            default:
                return new u5(this.f2160b, this.f2161l, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2159a) {
            case 0:
                ((u5) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                return u6.a.f10762a;
            case 1:
                u5 u5Var = (u5) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                u5Var.invokeSuspend(xVar);
                return xVar;
            default:
                u5 u5Var2 = (u5) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                u5Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f2159a;
        p6.x xVar = p6.x.f8463a;
        NotificationsRegistryActivity notificationsRegistryActivity = this.f2160b;
        switch (i) {
            case 0:
                int i6 = this.f2161l;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i10 = NotificationsRegistryActivity.T;
                r7.o0 o0Var = notificationsRegistryActivity.B0().f1421b;
                c3.y0 y0Var = new c3.y0(notificationsRegistryActivity, 6);
                this.f2161l = 1;
                o0Var.collect(y0Var, this);
                return u6.a.f10762a;
            case 1:
                p6.a.e(obj);
                String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault()).format(new Long(System.currentTimeMillis()));
                format.getClass();
                int i11 = NotificationsRegistryActivity.T;
                NotificationsRegistryActivity notificationsRegistryActivity2 = this.f2160b;
                b6 B0 = notificationsRegistryActivity2.B0();
                e4.q qVar = notificationsRegistryActivity2.R;
                qVar.getClass();
                ArrayList arrayList = qVar.f4657a;
                int i12 = this.f2161l;
                Object obj2 = arrayList.get(i12);
                obj2.getClass();
                x4.s1 s1Var = (x4.s1) obj2;
                B0.getClass();
                o7.a0 viewModelScope = ViewModelKt.getViewModelScope(B0);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(viewModelScope, v7.d.f10884a, null, new b5.l(notificationsRegistryActivity2, s1Var, format, (t6.c) null, 9), 2);
                e4.q qVar2 = notificationsRegistryActivity2.R;
                qVar2.getClass();
                ((x4.s1) qVar2.f4657a.get(i12)).f11387d = notificationsRegistryActivity2.getString(2131952028, format);
                e4.q qVar3 = notificationsRegistryActivity2.R;
                qVar3.getClass();
                ((x4.s1) qVar3.f4657a.get(i12)).f11388e = "no_action";
                return xVar;
            default:
                p6.a.e(obj);
                e4.q qVar4 = notificationsRegistryActivity.R;
                qVar4.getClass();
                qVar4.notifyItemChanged(this.f2161l);
                return xVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u5(NotificationsRegistryActivity notificationsRegistryActivity, t6.c cVar) {
        super(2, cVar);
        this.f2159a = 0;
        this.f2160b = notificationsRegistryActivity;
    }
}
