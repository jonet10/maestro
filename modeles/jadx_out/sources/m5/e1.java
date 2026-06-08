package m5;

import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class e1 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7372a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f1 f7373b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x4.g f7374l;

    public /* synthetic */ e1(f1 f1Var, x4.g gVar, int i, int i6) {
        this.f7372a = i6;
        this.f7373b = f1Var;
        this.f7374l = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7372a) {
            case 0:
                this.f7373b.f7380l.b(this.f7374l);
                break;
            case 1:
                this.f7373b.f7381m.f(this.f7374l);
                break;
            case 2:
                x4.g gVar = this.f7374l;
                f1 f1Var = this.f7373b;
                f1Var.f7380l.b(gVar);
                f1Var.i();
                break;
            default:
                this.f7373b.f7380l.b(this.f7374l);
                break;
        }
    }
}
