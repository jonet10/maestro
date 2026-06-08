package g4;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import com.uptodown.core.activities.InstallerActivity;
import java.util.ArrayList;
import u4.v0;
import x4.b3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class f0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5163a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.u f5164b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f5165l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5166m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f5167n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f5168o;

    public /* synthetic */ f0(ArrayList arrayList, u4.f0 f0Var, ArrayList arrayList2, kotlin.jvm.internal.u uVar, t4.n0 n0Var) {
        this.f5165l = arrayList;
        this.f5166m = f0Var;
        this.f5167n = arrayList2;
        this.f5164b = uVar;
        this.f5168o = n0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object obj;
        int i = this.f5163a;
        Object obj2 = this.f5168o;
        kotlin.jvm.internal.u uVar = this.f5164b;
        Object obj3 = this.f5167n;
        Object obj4 = this.f5166m;
        Object obj5 = this.f5165l;
        switch (i) {
            case 0:
                TextView textView = (TextView) obj5;
                InstallerActivity installerActivity = (InstallerActivity) obj3;
                ImageView imageView = (ImageView) obj2;
                TextView textView2 = (TextView) obj4;
                int i6 = InstallerActivity.f3394j0;
                if (!uVar.f7021a) {
                    textView.setText(installerActivity.getString(2131951874));
                    imageView.setImageDrawable(ContextCompat.getDrawable(installerActivity, 2131231299));
                    textView2.setVisibility(0);
                    uVar.f7021a = true;
                    break;
                } else {
                    textView.setText(installerActivity.getString(2131951873));
                    imageView.setImageDrawable(ContextCompat.getDrawable(installerActivity, 2131231298));
                    textView2.setVisibility(8);
                    uVar.f7021a = false;
                    break;
                }
            default:
                ArrayList arrayList = (ArrayList) obj5;
                u4.f0 f0Var = (u4.f0) obj4;
                ArrayList arrayList2 = (ArrayList) obj3;
                t4.n0 n0Var = (t4.n0) obj2;
                int size = arrayList.size();
                int i10 = 0;
                while (true) {
                    if (i10 < size) {
                        obj = arrayList.get(i10);
                        i10++;
                        if (((b3) obj).f11067l == 1) {
                        }
                    } else {
                        obj = null;
                    }
                }
                b3 b3Var = (b3) obj;
                if (b3Var != null) {
                    v0 G = f0Var.G();
                    Context requireContext = f0Var.requireContext();
                    requireContext.getClass();
                    long j = f0Var.B().f11158a;
                    G.getClass();
                    o7.a0 viewModelScope = ViewModelKt.getViewModelScope(G);
                    v7.e eVar = o7.m0.f8288a;
                    o7.c0.s(viewModelScope, v7.d.f10884a, null, new u4.s0(requireContext, j, b3Var, arrayList2, G, null), 2);
                }
                if (uVar.f7021a && f0Var.B().k() && f0Var.B().j()) {
                    Context requireContext2 = f0Var.requireContext();
                    requireContext2.getClass();
                    FragmentActivity requireActivity = f0Var.requireActivity();
                    requireActivity.getClass();
                    d0.b.j(requireContext2, (c4.k0) requireActivity, f0Var.f10484w, f0Var.B(), false);
                }
                f0Var.r(n0Var);
                break;
        }
    }

    public /* synthetic */ f0(kotlin.jvm.internal.u uVar, TextView textView, InstallerActivity installerActivity, ImageView imageView, TextView textView2) {
        this.f5164b = uVar;
        this.f5165l = textView;
        this.f5167n = installerActivity;
        this.f5168o = imageView;
        this.f5166m = textView2;
    }
}
