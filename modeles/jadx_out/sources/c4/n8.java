package c4;

import com.uptodown.activities.RepliesActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n8 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1911a;

    /* renamed from: b, reason: collision with root package name */
    public int f1912b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ RepliesActivity f1913l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n8(RepliesActivity repliesActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1911a = i;
        this.f1913l = repliesActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1911a) {
            case 0:
                return new n8(this.f1913l, cVar, 0);
            case 1:
                return new n8(this.f1913l, cVar, 1);
            case 2:
                return new n8(this.f1913l, cVar, 2);
            case 3:
                return new n8(this.f1913l, cVar, 3);
            default:
                return new n8(this.f1913l, cVar, 4);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1911a) {
            case 0:
                ((n8) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            case 1:
                ((n8) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            case 2:
                ((n8) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            case 3:
                ((n8) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((n8) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1911a) {
            case 0:
                int i = this.f1912b;
                if (i != 0) {
                    if (i == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                RepliesActivity repliesActivity = this.f1913l;
                r7.o0 o0Var = repliesActivity.z0().f2214b;
                m8 m8Var = new m8(repliesActivity);
                this.f1912b = 1;
                o0Var.collect(m8Var, this);
                return u6.a.f10762a;
            case 1:
                int i6 = this.f1912b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                RepliesActivity repliesActivity2 = this.f1913l;
                r7.o0 o0Var2 = repliesActivity2.z0().f2216d;
                o8 o8Var = new o8(repliesActivity2, 0);
                this.f1912b = 1;
                o0Var2.collect(o8Var, this);
                return u6.a.f10762a;
            case 2:
                int i10 = this.f1912b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                RepliesActivity repliesActivity3 = this.f1913l;
                r7.o0 o0Var3 = repliesActivity3.z0().f;
                o8 o8Var2 = new o8(repliesActivity3, 1);
                this.f1912b = 1;
                o0Var3.collect(o8Var2, this);
                return u6.a.f10762a;
            case 3:
                int i11 = this.f1912b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                RepliesActivity repliesActivity4 = this.f1913l;
                r7.o0 o0Var4 = repliesActivity4.z0().h;
                o8 o8Var3 = new o8(repliesActivity4, 2);
                this.f1912b = 1;
                o0Var4.collect(o8Var3, this);
                return u6.a.f10762a;
            default:
                int i12 = this.f1912b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                RepliesActivity repliesActivity5 = this.f1913l;
                r7.o0 o0Var5 = repliesActivity5.z0().j;
                o8 o8Var4 = new o8(repliesActivity5, 3);
                this.f1912b = 1;
                o0Var5.collect(o8Var4, this);
                return u6.a.f10762a;
        }
    }
}
