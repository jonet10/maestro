package c4;

import com.uptodown.activities.PublicProfileActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o7 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1953a;

    /* renamed from: b, reason: collision with root package name */
    public int f1954b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f1955l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f1956m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ x4.w2 f1957n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o7(PublicProfileActivity publicProfileActivity, kotlin.jvm.internal.x xVar, x4.w2 w2Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f1953a = i;
        this.f1955l = publicProfileActivity;
        this.f1956m = xVar;
        this.f1957n = w2Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1953a) {
            case 0:
                return new o7(this.f1955l, this.f1956m, this.f1957n, cVar, 0);
            default:
                return new o7(this.f1955l, this.f1956m, this.f1957n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1953a) {
            case 0:
                ((o7) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((o7) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1953a;
        x4.w2 w2Var = this.f1957n;
        kotlin.jvm.internal.x xVar = this.f1956m;
        u6.a aVar = u6.a.f10762a;
        PublicProfileActivity publicProfileActivity = this.f1955l;
        switch (i) {
            case 0:
                int i6 = this.f1954b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i10 = PublicProfileActivity.R;
                r7.o0 o0Var = publicProfileActivity.z0().f2355b;
                n7 n7Var = new n7(publicProfileActivity, xVar, w2Var);
                this.f1954b = 1;
                o0Var.collect(n7Var, this);
                return aVar;
            default:
                int i11 = this.f1954b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i12 = PublicProfileActivity.R;
                r7.o0 o0Var2 = publicProfileActivity.z0().f2357d;
                p7 p7Var = new p7(publicProfileActivity, xVar, w2Var);
                this.f1954b = 1;
                o0Var2.collect(p7Var, this);
                return aVar;
        }
    }
}
