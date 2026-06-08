package q2;

import a4.d0;
import android.content.Context;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;
import java.util.concurrent.Executor;
import s1.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class b implements s1.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8644a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f8645b;

    public /* synthetic */ b(r rVar, int i) {
        this.f8644a = i;
        this.f8645b = rVar;
    }

    @Override // s1.d
    public final Object c(d0 d0Var) {
        FirebaseMessaging lambda$getComponents$0;
        switch (this.f8644a) {
            case 0:
                return new d((Context) d0Var.a(Context.class), ((n1.f) d0Var.a(n1.f.class)).d(), d0Var.p(e.class), d0Var.c(a3.c.class), (Executor) d0Var.e(this.f8645b));
            default:
                lambda$getComponents$0 = FirebaseMessagingRegistrar.lambda$getComponents$0(this.f8645b, d0Var);
                return lambda$getComponents$0;
        }
    }
}
