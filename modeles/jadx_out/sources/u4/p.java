package u4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10565a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10566b;

    public /* synthetic */ p(f0 f0Var, int i) {
        this.f10565a = i;
        this.f10566b = f0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f10565a;
        f0 f0Var = this.f10566b;
        switch (i) {
            case 0:
                if (f0Var.getActivity() instanceof c4.k0) {
                    FragmentActivity requireActivity = f0Var.requireActivity();
                    requireActivity.getClass();
                    b2.t1.u((c4.k0) requireActivity, f0Var.B().f11174n);
                    break;
                }
                break;
            case 1:
                FragmentActivity activity = f0Var.getActivity();
                activity.getClass();
                AlertDialog alertDialog = ((c4.k0) activity).F;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            case 2:
                Context requireContext = f0Var.requireContext();
                requireContext.getClass();
                FragmentActivity requireActivity2 = f0Var.requireActivity();
                requireActivity2.getClass();
                d0.b.j(requireContext, (c4.k0) requireActivity2, f0Var.f10484w, f0Var.B(), false);
                break;
            case 3:
                FragmentActivity activity2 = f0Var.getActivity();
                activity2.getClass();
                ((c4.k0) activity2).Q();
                break;
            case 4:
                if (f0Var.getActivity() != null && f0Var.isAdded() && !f0Var.requireActivity().isFinishing()) {
                    FragmentActivity activity3 = f0Var.getActivity();
                    activity3.getClass();
                    AlertDialog alertDialog2 = ((c4.k0) activity3).F;
                    if (alertDialog2 != null) {
                        alertDialog2.dismiss();
                        break;
                    }
                }
                break;
            case 5:
                f0Var.t();
                break;
            case 6:
                if (f0Var.getActivity() != null && !f0Var.requireActivity().isFinishing()) {
                    FragmentActivity activity4 = f0Var.getActivity();
                    activity4.getClass();
                    ((c4.k0) activity4).Q();
                    if (f0Var.getActivity() != null && (f0Var.getActivity() instanceof MainActivity)) {
                        FragmentActivity activity5 = f0Var.getActivity();
                        activity5.getClass();
                        ((MainActivity) activity5).getOnBackPressedDispatcher().onBackPressed();
                        break;
                    } else {
                        FragmentActivity activity6 = f0Var.getActivity();
                        activity6.getClass();
                        ((c4.k0) activity6).finish();
                        break;
                    }
                }
                break;
            case 7:
                Context requireContext2 = f0Var.requireContext();
                requireContext2.getClass();
                f0Var.p(requireContext2);
                Context requireContext3 = f0Var.requireContext();
                requireContext3.getClass();
                FragmentActivity requireActivity3 = f0Var.requireActivity();
                requireActivity3.getClass();
                d0.b.j(requireContext3, (c4.k0) requireActivity3, f0Var.f10484w, f0Var.B(), false);
                FragmentActivity activity7 = f0Var.getActivity();
                activity7.getClass();
                ((c4.k0) activity7).Q();
                break;
            case 8:
                Context requireContext4 = f0Var.requireContext();
                requireContext4.getClass();
                FragmentActivity requireActivity4 = f0Var.requireActivity();
                requireActivity4.getClass();
                d0.b.j(requireContext4, (c4.k0) requireActivity4, f0Var.f10484w, f0Var.B(), false);
                break;
            case 9:
                f0Var.P();
                break;
            case 10:
                f0Var.P();
                break;
            case 11:
                Context requireContext5 = f0Var.requireContext();
                requireContext5.getClass();
                FragmentActivity requireActivity5 = f0Var.requireActivity();
                requireActivity5.getClass();
                d0.b.j(requireContext5, (c4.k0) requireActivity5, f0Var.f10484w, f0Var.B(), false);
                break;
            case 12:
                r7.o0 o0Var = a5.b.f193a;
                if (!a5.b.c(f0Var.B().f11158a) && !a5.b.e(f0Var.B().f11158a)) {
                    r7.o0 o0Var2 = a5.c.f197a;
                    if (a5.c.b(f0Var.B().f11158a) || a5.c.c(f0Var.B().f11158a)) {
                        if (!(a5.c.f197a.getValue() instanceof x4.y0)) {
                            x4.r a8 = a5.c.a();
                            if (a8 != null && a5.c.b(f0Var.B().f11158a)) {
                                android.support.v4.media.g gVar = f0Var.f10476n;
                                if (gVar != null) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "paused");
                                    gVar.E(bundle, "download");
                                }
                                a5.c.e();
                                f0Var.i0(a8);
                                break;
                            }
                        } else {
                            a5.c.f();
                            break;
                        }
                    }
                } else if (!a5.b.d()) {
                    x4.r b7 = a5.b.b();
                    if (b7 != null && a5.b.c(f0Var.B().f11158a)) {
                        android.support.v4.media.g gVar2 = f0Var.f10476n;
                        if (gVar2 != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "paused");
                            gVar2.E(bundle2, "download");
                        }
                        a5.b.g();
                        f0Var.i0(b7);
                        break;
                    }
                } else {
                    a5.b.h();
                    break;
                }
                break;
            case 13:
                f0Var.t();
                break;
            case 14:
                f0Var.R();
                FragmentActivity activity8 = f0Var.getActivity();
                activity8.getClass();
                AlertDialog alertDialog3 = ((c4.k0) activity8).F;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                    break;
                }
                break;
            case 15:
                FragmentActivity activity9 = f0Var.getActivity();
                activity9.getClass();
                AlertDialog alertDialog4 = ((c4.k0) activity9).F;
                if (alertDialog4 != null) {
                    alertDialog4.dismiss();
                    break;
                }
                break;
            case 16:
                Context requireContext6 = f0Var.requireContext();
                requireContext6.getClass();
                FragmentActivity requireActivity6 = f0Var.requireActivity();
                requireActivity6.getClass();
                d0.b.j(requireContext6, (c4.k0) requireActivity6, f0Var.f10484w, f0Var.B(), false);
                break;
            case 17:
                f0Var.n();
                FragmentActivity activity10 = f0Var.getActivity();
                activity10.getClass();
                ((c4.k0) activity10).Q();
                break;
            case 18:
                f0Var.o();
                FragmentActivity activity11 = f0Var.getActivity();
                activity11.getClass();
                ((c4.k0) activity11).Q();
                break;
            case 19:
                Intent intent = new Intent(f0Var.requireActivity(), (Class<?>) FreeUpSpaceActivity.class);
                intent.putExtra("appInfo", f0Var.B());
                float f = UptodownApp.I;
                FragmentActivity requireActivity7 = f0Var.requireActivity();
                requireActivity7.getClass();
                f0Var.startActivity(intent, b4.d.a(requireActivity7));
                break;
            case 20:
                Context requireContext7 = f0Var.requireContext();
                requireContext7.getClass();
                f0Var.p(requireContext7);
                FragmentActivity activity12 = f0Var.getActivity();
                activity12.getClass();
                AlertDialog alertDialog5 = ((c4.k0) activity12).F;
                if (alertDialog5 != null) {
                    alertDialog5.dismiss();
                    break;
                }
                break;
            case 21:
                FragmentActivity activity13 = f0Var.getActivity();
                activity13.getClass();
                AlertDialog alertDialog6 = ((c4.k0) activity13).F;
                if (alertDialog6 != null) {
                    alertDialog6.dismiss();
                    break;
                }
                break;
            case 22:
                v0 G = f0Var.G();
                Context requireContext8 = f0Var.requireContext();
                requireContext8.getClass();
                long j = f0Var.B().f11158a;
                G.getClass();
                o7.a0 viewModelScope = ViewModelKt.getViewModelScope(G);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(viewModelScope, v7.d.f10884a, null, new n0(G, requireContext8, j, (t6.c) null), 2);
                FragmentActivity activity14 = f0Var.getActivity();
                activity14.getClass();
                AlertDialog alertDialog7 = ((c4.k0) activity14).F;
                if (alertDialog7 != null) {
                    alertDialog7.dismiss();
                    break;
                }
                break;
            case 23:
                FragmentActivity activity15 = f0Var.getActivity();
                activity15.getClass();
                AlertDialog alertDialog8 = ((c4.k0) activity15).F;
                if (alertDialog8 != null) {
                    alertDialog8.dismiss();
                    break;
                }
                break;
            default:
                FragmentActivity activity16 = f0Var.getActivity();
                activity16.getClass();
                ((c4.k0) activity16).Q();
                if (f0Var.getActivity() != null && (f0Var.getActivity() instanceof MainActivity)) {
                    FragmentActivity activity17 = f0Var.getActivity();
                    activity17.getClass();
                    ((MainActivity) activity17).getOnBackPressedDispatcher().onBackPressed();
                    break;
                } else {
                    FragmentActivity activity18 = f0Var.getActivity();
                    activity18.getClass();
                    ((c4.k0) activity18).finish();
                    break;
                }
        }
    }
}
