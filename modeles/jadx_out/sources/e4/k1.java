package e4;

import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class k1 implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4588a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l1 f4589b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x4.g f4590l;

    public /* synthetic */ k1(l1 l1Var, x4.g gVar, int i, int i6) {
        this.f4588a = i6;
        this.f4589b = l1Var;
        this.f4590l = gVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        switch (this.f4588a) {
            case 0:
                this.f4589b.f4607l.e(this.f4590l);
                break;
            default:
                this.f4589b.f4607l.e(this.f4590l);
                break;
        }
        return true;
    }
}
