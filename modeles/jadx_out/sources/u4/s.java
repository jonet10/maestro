package u4;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import com.uptodown.UptodownApp;
import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s implements w4.g, k4.c, w4.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10593a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10594b;

    public /* synthetic */ s(f0 f0Var, int i) {
        this.f10593a = i;
        this.f10594b = f0Var;
    }

    @Override // w4.g
    public void A(String str) {
        this.f10594b.v(str);
    }

    @Override // k4.c
    public void c(File file, ArrayList arrayList) {
        f0 f0Var = this.f10594b;
        if (f0Var.getActivity() != null) {
            FragmentActivity activity = f0Var.getActivity();
            activity.getClass();
            if (activity.isFinishing()) {
                return;
            }
            FragmentActivity requireActivity = f0Var.requireActivity();
            requireActivity.getClass();
            new n4.h(requireActivity).k(arrayList, false);
            o7.c0.s(LifecycleOwnerKt.getLifecycleScope(f0Var), null, null, new w(f0Var, null, 9), 3);
            if (f0Var.getActivity() instanceof c4.k0) {
                e1.c0 c0Var = j5.g.D;
                FragmentActivity activity2 = f0Var.getActivity();
                activity2.getClass();
                j5.g l10 = c0Var.l(activity2);
                l10.b();
                String name = file.getName();
                name.getClass();
                x4.r G = l10.G(name);
                l10.c();
                FragmentActivity activity3 = f0Var.getActivity();
                activity3.getClass();
                ((c4.k0) activity3).X(G);
            }
        }
    }

    @Override // w4.c
    public void d(x4.g gVar) {
        int i = this.f10593a;
        f0 f0Var = this.f10594b;
        gVar.getClass();
        switch (i) {
            case 2:
                float f = UptodownApp.I;
                if (b4.d.t() && f0Var.getActivity() != null && !f0Var.requireActivity().isFinishing()) {
                    f0.c(f0Var, gVar);
                    break;
                }
                break;
            case 3:
                float f10 = UptodownApp.I;
                if (b4.d.t() && f0Var.getActivity() != null && !f0Var.requireActivity().isFinishing()) {
                    f0.c(f0Var, gVar);
                    break;
                }
                break;
            default:
                float f11 = UptodownApp.I;
                if (b4.d.t() && f0Var.getActivity() != null && !f0Var.requireActivity().isFinishing()) {
                    f0.c(f0Var, gVar);
                    break;
                }
                break;
        }
    }

    @Override // k4.c
    public void e(int i) {
        f0.k(this.f10594b, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b9  */
    /* JADX WARN: Type inference failed for: r4v1, types: [t6.c] */
    /* JADX WARN: Type inference failed for: r4v10 */
    @Override // w4.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(x4.r r15) {
        /*
            Method dump skipped, instructions count: 659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.s.g(x4.r):void");
    }

    @Override // k4.c
    public void l() {
        f0 f0Var = this.f10594b;
        if (f0Var.getContext() != null) {
            String string = f0Var.getString(2131952274, f0Var.getString(2131951718));
            string.getClass();
            f0Var.v(string);
        }
    }

    @Override // w4.g
    public void p(String str) {
        str.getClass();
        f0 f0Var = this.f10594b;
        FragmentActivity activity = f0Var.getActivity();
        activity.getClass();
        j5.c.e((c4.k0) activity, str, null);
        v0 G = f0Var.G();
        Context requireContext = f0Var.requireContext();
        requireContext.getClass();
        long j = f0Var.B().f11158a;
        G.getClass();
        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(G);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(viewModelScope, v7.d.f10884a, null, new n0(requireContext, G, j, (t6.c) null), 2);
    }

    @Override // k4.c
    public void t() {
        f0 f0Var = this.f10594b;
        if (f0Var.getContext() != null) {
            String string = f0Var.getString(2131951876, f0Var.getString(2131951718));
            string.getClass();
            f0Var.v(string);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011a  */
    @Override // w4.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(x4.r r13) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.s.u(x4.r):void");
    }

    @Override // k4.c
    public void v() {
        f0.k(this.f10594b, 0);
    }

    @Override // k4.c
    public void w() {
        f0 f0Var = this.f10594b;
        if (f0Var.getContext() != null) {
            String string = f0Var.getString(2131952008);
            string.getClass();
            f0Var.v(string);
        }
    }

    @Override // k4.c
    public void z() {
        f0 f0Var = this.f10594b;
        if (f0Var.getActivity() == null || !(f0Var.getActivity() instanceof c4.k0)) {
            return;
        }
        FragmentActivity activity = f0Var.getActivity();
        activity.getClass();
        ((c4.k0) activity).j();
    }

    @Override // k4.c
    public void i(File file) {
    }

    @Override // k4.c
    public void j(File file) {
    }
}
