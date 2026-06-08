package e1;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4453a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c5 f4454b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f4455c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c2 f4456d;

    public /* synthetic */ z1(c2 c2Var, c5 c5Var, Bundle bundle, int i) {
        this.f4453a = i;
        this.f4454b = c5Var;
        this.f4455c = bundle;
        this.f4456d = c2Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        switch (this.f4453a) {
            case 0:
                c2 c2Var = this.f4456d;
                c2Var.i.B();
                return c2Var.i.d0(this.f4455c, this.f4454b);
            default:
                c2 c2Var2 = this.f4456d;
                c2Var2.i.B();
                return c2Var2.i.d0(this.f4455c, this.f4454b);
        }
    }
}
