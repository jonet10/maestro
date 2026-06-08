package c4;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ua extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f2178a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Updates f2179b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua(Updates updates, t6.c cVar) {
        super(2, cVar);
        this.f2179b = updates;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new ua(this.f2179b, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((ua) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f2178a;
        if (i == 0) {
            p6.a.e(obj);
            Lifecycle.State state = Lifecycle.State.STARTED;
            Updates updates = this.f2179b;
            ta taVar = new ta(updates, (t6.c) null, 0);
            this.f2178a = 1;
            Object repeatOnLifecycle = RepeatOnLifecycleKt.repeatOnLifecycle(updates, state, taVar, this);
            u6.a aVar = u6.a.f10762a;
            if (repeatOnLifecycle == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return p6.x.f8463a;
    }
}
