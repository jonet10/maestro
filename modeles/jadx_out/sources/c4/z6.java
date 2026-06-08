package c4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.activities.PreregistrationActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class z6 implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2396a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PreregistrationActivity f2397b;

    public /* synthetic */ z6(PreregistrationActivity preregistrationActivity, int i) {
        this.f2396a = i;
        this.f2397b = preregistrationActivity;
    }

    @Override // d7.a
    public final Object invoke() {
        int i = this.f2396a;
        PreregistrationActivity preregistrationActivity = this.f2397b;
        switch (i) {
            case 0:
                int i6 = PreregistrationActivity.T;
                View inflate = preregistrationActivity.getLayoutInflater().inflate(2131558793, (ViewGroup) null, false);
                int i10 = 2131362190;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(inflate, 2131362190);
                if (frameLayout != null) {
                    i10 = 2131362757;
                    if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362757)) != null) {
                        i10 = 2131362818;
                        View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362818);
                        if (findChildViewById != null) {
                            i10 = 2131362950;
                            if (((NestedScrollView) ViewBindings.findChildViewById(inflate, 2131362950)) != null) {
                                i10 = 2131363357;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363357);
                                if (recyclerView != null) {
                                    i10 = 2131363569;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363569);
                                    if (toolbar != null) {
                                        i10 = 2131363832;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363832);
                                        if (textView != null) {
                                            i10 = 2131364089;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364089);
                                            if (textView2 != null) {
                                                i10 = 2131364423;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364423);
                                                if (textView3 != null) {
                                                    return new t4.j0((RelativeLayout) inflate, frameLayout, findChildViewById, recyclerView, toolbar, textView, textView2, textView3);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
                return null;
            default:
                int i11 = PreregistrationActivity.T;
                e7 e7Var = (e7) preregistrationActivity.O.getValue();
                e7Var.getClass();
                o7.a0 viewModelScope = ViewModelKt.getViewModelScope(e7Var);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(viewModelScope, v7.d.f10884a, null, new b.f(e7Var, true, preregistrationActivity, (t6.c) null), 2);
                preregistrationActivity.setResult(2);
                return p6.x.f8463a;
        }
    }
}
