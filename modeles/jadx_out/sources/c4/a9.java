package c4;

import com.uptodown.activities.ReviewsActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a9 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1385a;

    /* renamed from: b, reason: collision with root package name */
    public int f1386b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f1387l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a9(ReviewsActivity reviewsActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1385a = i;
        this.f1387l = reviewsActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1385a) {
            case 0:
                return new a9(this.f1387l, cVar, 0);
            case 1:
                return new a9(this.f1387l, cVar, 1);
            case 2:
                return new a9(this.f1387l, cVar, 2);
            default:
                return new a9(this.f1387l, cVar, 3);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1385a) {
            case 0:
                ((a9) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            case 1:
                ((a9) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            case 2:
                ((a9) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((a9) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1385a;
        u6.a aVar = u6.a.f10762a;
        ReviewsActivity reviewsActivity = this.f1387l;
        switch (i) {
            case 0:
                int i6 = this.f1386b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i10 = ReviewsActivity.T;
                r7.o0 o0Var = reviewsActivity.A0().f1636b;
                z8 z8Var = new z8(reviewsActivity, 0);
                this.f1386b = 1;
                o0Var.collect(z8Var, this);
                return aVar;
            case 1:
                int i11 = this.f1386b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i12 = ReviewsActivity.T;
                r7.o0 o0Var2 = reviewsActivity.A0().f1638d;
                z8 z8Var2 = new z8(reviewsActivity, 1);
                this.f1386b = 1;
                o0Var2.collect(z8Var2, this);
                return aVar;
            case 2:
                int i13 = this.f1386b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i14 = ReviewsActivity.T;
                r7.o0 o0Var3 = reviewsActivity.A0().f;
                z8 z8Var3 = new z8(reviewsActivity, 2);
                this.f1386b = 1;
                o0Var3.collect(z8Var3, this);
                return aVar;
            default:
                int i15 = this.f1386b;
                if (i15 != 0) {
                    if (i15 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i16 = ReviewsActivity.T;
                r7.o0 o0Var4 = reviewsActivity.A0().h;
                z8 z8Var4 = new z8(reviewsActivity, 3);
                this.f1386b = 1;
                o0Var4.collect(z8Var4, this);
                return aVar;
        }
    }
}
