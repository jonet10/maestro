package c4;

import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1972a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d7.a f1973b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ k0 f1974l;

    public /* synthetic */ p(k0 k0Var, d7.a aVar, int i) {
        this.f1972a = i;
        this.f1974l = k0Var;
        this.f1973b = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f1972a) {
            case 0:
                this.f1973b.invoke();
                this.f1974l.Q();
                break;
            case 1:
                this.f1973b.invoke();
                this.f1974l.Q();
                break;
            case 2:
                this.f1974l.Q();
                this.f1973b.invoke();
                break;
            case 3:
                this.f1974l.Q();
                this.f1973b.invoke();
                break;
            case 4:
                this.f1973b.invoke();
                this.f1974l.Q();
                break;
            case 5:
                this.f1973b.invoke();
                this.f1974l.Q();
                break;
            default:
                this.f1973b.invoke();
                this.f1974l.Q();
                break;
        }
    }

    public /* synthetic */ p(d7.a aVar, k0 k0Var, int i) {
        this.f1972a = i;
        this.f1973b = aVar;
        this.f1974l = k0Var;
    }
}
