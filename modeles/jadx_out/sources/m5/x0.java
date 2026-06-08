package m5;

import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class x0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7633a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y0 f7634b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x4.g f7635l;

    public /* synthetic */ x0(y0 y0Var, x4.g gVar, int i, int i6) {
        this.f7633a = i6;
        this.f7634b = y0Var;
        this.f7635l = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7633a) {
            case 0:
                this.f7634b.f7641m.b(this.f7635l);
                break;
            default:
                x4.g gVar = this.f7635l;
                y0 y0Var = this.f7634b;
                y0Var.f7641m.b(gVar);
                y0Var.k();
                break;
        }
    }
}
