package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.work.Constraints;
import androidx.work.impl.constraints.IndividualNetworkCallback;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import d7.l;
import d7.p;
import o7.c0;
import o7.e1;
import o7.s1;
import p6.x;
import q7.r;
import q7.s;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1", f = "WorkConstraintsTracker.kt", l = {SubsamplingScaleImageView.ORIENTATION_180}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class NetworkRequestConstraintController$track$1 extends i implements p {
    final /* synthetic */ Constraints $constraints;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetworkRequestConstraintController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkRequestConstraintController$track$1(Constraints constraints, NetworkRequestConstraintController networkRequestConstraintController, t6.c cVar) {
        super(2, cVar);
        this.$constraints = constraints;
        this.this$0 = networkRequestConstraintController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x invokeSuspend$lambda$0(e1 e1Var, s sVar, ConstraintsState constraintsState) {
        e1Var.c(null);
        ((r) sVar).p(constraintsState);
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x invokeSuspend$lambda$1(d7.a aVar) {
        aVar.invoke();
        return x.f8463a;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        NetworkRequestConstraintController$track$1 networkRequestConstraintController$track$1 = new NetworkRequestConstraintController$track$1(this.$constraints, this.this$0, cVar);
        networkRequestConstraintController$track$1.L$0 = obj;
        return networkRequestConstraintController$track$1;
    }

    @Override // d7.p
    public final Object invoke(s sVar, t6.c cVar) {
        return ((NetworkRequestConstraintController$track$1) create(sVar, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        ConnectivityManager connectivityManager;
        final d7.a addCallback;
        ConnectivityManager connectivityManager2;
        int i = this.label;
        x xVar = x.f8463a;
        if (i != 0) {
            if (i == 1) {
                p6.a.e(obj);
                return xVar;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        final s sVar = (s) this.L$0;
        NetworkRequest requiredNetworkRequest = this.$constraints.getRequiredNetworkRequest();
        if (requiredNetworkRequest == null) {
            r rVar = (r) sVar;
            rVar.getClass();
            rVar.m(null);
            return xVar;
        }
        final s1 s6 = c0.s(sVar, null, null, new NetworkRequestConstraintController$track$1$timeoutJob$1(this.this$0, sVar, null), 3);
        l lVar = new l() { // from class: androidx.work.impl.constraints.b
            @Override // d7.l
            public final Object invoke(Object obj2) {
                x invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = NetworkRequestConstraintController$track$1.invokeSuspend$lambda$0(s1.this, sVar, (ConstraintsState) obj2);
                return invokeSuspend$lambda$0;
            }
        };
        if (Build.VERSION.SDK_INT >= 30) {
            SharedNetworkCallback sharedNetworkCallback = SharedNetworkCallback.INSTANCE;
            connectivityManager2 = this.this$0.connManager;
            addCallback = sharedNetworkCallback.addCallback(connectivityManager2, requiredNetworkRequest, lVar);
        } else {
            IndividualNetworkCallback.Companion companion = IndividualNetworkCallback.Companion;
            connectivityManager = this.this$0.connManager;
            addCallback = companion.addCallback(connectivityManager, requiredNetworkRequest, lVar);
        }
        d7.a aVar = new d7.a() { // from class: androidx.work.impl.constraints.c
            @Override // d7.a
            public final Object invoke() {
                x invokeSuspend$lambda$1;
                invokeSuspend$lambda$1 = NetworkRequestConstraintController$track$1.invokeSuspend$lambda$1(d7.a.this);
                return invokeSuspend$lambda$1;
            }
        };
        this.label = 1;
        Object o10 = d0.b.o(sVar, aVar, this);
        u6.a aVar2 = u6.a.f10762a;
        return o10 == aVar2 ? aVar2 : xVar;
    }
}
