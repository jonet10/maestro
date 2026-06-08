package u4;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import c4.w6;
import com.uptodown.activities.MainActivity;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g1 extends z0 {

    /* renamed from: u, reason: collision with root package name */
    public String f10496u;
    public final p6.m v = new p6.m(new w6(this, 26));

    public g1(String str) {
        this.f10496u = str;
    }

    @Override // u4.z0
    public final ViewBinding a() {
        return (t4.o) this.v.getValue();
    }

    @Override // u4.z0
    public final String b() {
        return this.f10496u;
    }

    @Override // u4.z0
    public final View d() {
        return ((t4.o) this.v.getValue()).f10017b;
    }

    @Override // u4.z0
    public final TextView g() {
        return ((t4.o) this.v.getValue()).f10019m;
    }

    @Override // u4.z0
    public final RecyclerView h() {
        return ((t4.o) this.v.getValue()).f10018l;
    }

    @Override // u4.z0
    public final TextView i() {
        return ((t4.o) this.v.getValue()).f10020n;
    }

    @Override // u4.z0
    public final void j(x4.j jVar) {
        jVar.getClass();
        FragmentActivity activity = getActivity();
        activity.getClass();
        ((MainActivity) activity).y1(jVar);
    }

    @Override // u4.z0
    public final void k(p2 p2Var) {
        p2Var.getClass();
        FragmentActivity activity = getActivity();
        activity.getClass();
        ((MainActivity) activity).y1(p2Var.f11329a);
    }

    @Override // u4.z0
    public final void l(String str) {
        this.f10496u = str;
    }
}
