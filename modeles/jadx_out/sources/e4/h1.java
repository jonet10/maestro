package e4;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import b2.t1;
import m5.s1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h1 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4553a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4554b;

    public /* synthetic */ h1(Object obj, int i) {
        this.f4553a = i;
        this.f4554b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        switch (this.f4553a) {
            case 0:
                i1 i1Var = (i1) this.f4554b;
                i1Var.f4564b.f9808r.getViewTreeObserver().removeOnPreDrawListener(this);
                t4.g gVar = i1Var.f4564b;
                if (t1.E(gVar.f9808r)) {
                    ((TextView) gVar.f9815z).setVisibility(0);
                    ((TextView) gVar.f9815z).setTypeface(f4.c.f4882w);
                    break;
                }
                break;
            case 1:
                s1 s1Var = (s1) this.f4554b;
                TextView textView = s1Var.f7567o;
                TextView textView2 = s1Var.f7568p;
                textView.getViewTreeObserver().removeOnPreDrawListener(this);
                if (t1.E(s1Var.f7567o)) {
                    textView2.setVisibility(0);
                    textView2.setTypeface(f4.c.f4882w);
                    break;
                }
                break;
            case 2:
                ((t5.d) this.f4554b).b();
                break;
            case 3:
                t4.p0 p0Var = (t4.p0) this.f4554b;
                TextView textView3 = p0Var.A;
                TextView textView4 = p0Var.v;
                textView4.getViewTreeObserver().removeOnPreDrawListener(this);
                if (t1.E(textView4)) {
                    textView3.setVisibility(0);
                    textView3.setTypeface(f4.c.f4882w);
                    break;
                }
                break;
            default:
                t4.q0 q0Var = (t4.q0) this.f4554b;
                TextView textView5 = q0Var.B;
                TextView textView6 = q0Var.f10074w;
                textView6.getViewTreeObserver().removeOnPreDrawListener(this);
                if (t1.E(textView6)) {
                    textView5.setVisibility(0);
                    textView5.setTypeface(f4.c.f4882w);
                    break;
                }
                break;
        }
        return true;
    }
}
