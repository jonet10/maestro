package o5;

import androidx.work.ListenableWorker;
import b.s;
import com.uptodown.workers.AppUpdatedWorker;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f8175a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppUpdatedWorker f8176b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(AppUpdatedWorker appUpdatedWorker, t6.c cVar) {
        super(2, cVar);
        this.f8176b = appUpdatedWorker;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new d(this.f8176b, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((d) create((a0) obj, (t6.c) obj2)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f8175a;
        t6.c cVar = null;
        if (i == 0) {
            p6.a.e(obj);
            this.f8175a = 1;
            v7.e eVar = m0.f8288a;
            Object C = c0.C(new s(this.f8176b, cVar, 28), v7.d.f10884a, this);
            Object obj2 = u6.a.f10762a;
            if (C != obj2) {
                C = x.f8463a;
            }
            if (C == obj2) {
                return obj2;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return ListenableWorker.Result.success();
    }
}
