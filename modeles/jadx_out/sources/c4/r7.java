package c4;

import com.uptodown.activities.PublicProfileActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r7 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2050a;

    /* renamed from: b, reason: collision with root package name */
    public int f2051b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f2052l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r7(PublicProfileActivity publicProfileActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f2050a = i;
        this.f2052l = publicProfileActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2050a) {
            case 0:
                return new r7(this.f2052l, cVar, 0);
            default:
                return new r7(this.f2052l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2050a) {
            case 0:
                ((r7) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((r7) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f2050a;
        u6.a aVar = u6.a.f10762a;
        PublicProfileActivity publicProfileActivity = this.f2052l;
        switch (i) {
            case 0:
                int i6 = this.f2051b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i10 = PublicProfileActivity.R;
                r7.o0 o0Var = publicProfileActivity.z0().f;
                q7 q7Var = new q7(publicProfileActivity, 0);
                this.f2051b = 1;
                o0Var.collect(q7Var, this);
                return aVar;
            default:
                int i11 = this.f2051b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i12 = PublicProfileActivity.R;
                r7.o0 o0Var2 = publicProfileActivity.z0().h;
                q7 q7Var2 = new q7(publicProfileActivity, 1);
                this.f2051b = 1;
                o0Var2.collect(q7Var2, this);
                return aVar;
        }
    }
}
