package e1;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4411a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4412b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4413c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4414d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c2 f4415e;

    public /* synthetic */ y1(c2 c2Var, String str, String str2, String str3, int i) {
        this.f4411a = i;
        this.f4412b = str;
        this.f4413c = str2;
        this.f4414d = str3;
        this.f4415e = c2Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4411a) {
            case 0:
                c2 c2Var = this.f4415e;
                c2Var.i.B();
                m mVar = c2Var.i.f4307l;
                u4.U(mVar);
                return mVar.c0(this.f4412b, this.f4413c, this.f4414d);
            case 1:
                c2 c2Var2 = this.f4415e;
                c2Var2.i.B();
                m mVar2 = c2Var2.i.f4307l;
                u4.U(mVar2);
                return mVar2.c0(this.f4412b, this.f4413c, this.f4414d);
            case 2:
                c2 c2Var3 = this.f4415e;
                c2Var3.i.B();
                m mVar3 = c2Var3.i.f4307l;
                u4.U(mVar3);
                return mVar3.g0(this.f4412b, this.f4413c, this.f4414d);
            default:
                c2 c2Var4 = this.f4415e;
                c2Var4.i.B();
                m mVar4 = c2Var4.i.f4307l;
                u4.U(mVar4);
                return mVar4.g0(this.f4412b, this.f4413c, this.f4414d);
        }
    }
}
