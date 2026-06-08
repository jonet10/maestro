package g5;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import java.io.File;
import x4.t1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e0 implements OnItemViewClickedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvOldVersionsFragment f5307a;

    public e0(TvOldVersionsFragment tvOldVersionsFragment) {
        this.f5307a = tvOldVersionsFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        File externalFilesDir;
        if (obj instanceof t1) {
            TvOldVersionsFragment tvOldVersionsFragment = this.f5307a;
            x4.e eVar = tvOldVersionsFragment.f3441b;
            if (eVar == null || ((t1) obj).f11399m != eVar.f11124m) {
                e1.c0 c0Var = j5.g.D;
                Context requireContext = tvOldVersionsFragment.requireContext();
                requireContext.getClass();
                j5.g l10 = c0Var.l(requireContext);
                l10.b();
                x4.g gVar = tvOldVersionsFragment.f3440a;
                gVar.getClass();
                String str = gVar.F;
                str.getClass();
                t1 t1Var = (t1) obj;
                x4.r L = l10.L(t1Var.f11399m, str);
                l10.c();
                if (L == null) {
                    x4.r rVar = new x4.r();
                    x4.g gVar2 = tvOldVersionsFragment.f3440a;
                    gVar2.getClass();
                    rVar.b(gVar2, t1Var);
                    TvOldVersionsFragment.a(tvOldVersionsFragment, rVar);
                    return;
                }
                long j = L.f11361q;
                if (a5.b.c(j) || a5.c.b(j)) {
                    String str2 = L.f11355b;
                    if (str2 != null) {
                        x4.r b7 = a5.b.b();
                        if (kotlin.jvm.internal.l.a(b7 != null ? b7.f11355b : null, str2)) {
                            a5.b.f();
                            return;
                        } else {
                            a5.c.d();
                            return;
                        }
                    }
                    long j6 = L.f11361q;
                    if (j6 > 0) {
                        if (a5.b.c(j6) || a5.c.b(j6) || a5.b.e(j6)) {
                            a5.b.f();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (!L.c() || L.f11366w == null) {
                    x4.g gVar3 = tvOldVersionsFragment.f3440a;
                    gVar3.getClass();
                    L.a(gVar3);
                    TvOldVersionsFragment.a(tvOldVersionsFragment, L);
                    return;
                }
                x4.g gVar4 = tvOldVersionsFragment.f3440a;
                gVar4.getClass();
                String str3 = gVar4.F;
                long j10 = L.f11358n;
                String str4 = L.f11366w;
                str4.getClass();
                if (tvOldVersionsFragment.getActivity() != null) {
                    PackageManager packageManager = tvOldVersionsFragment.requireActivity().getPackageManager();
                    try {
                        packageManager.getClass();
                        str3.getClass();
                        if (j10 < n4.d.d(n4.i.e(packageManager, str3, 1))) {
                            AlertDialog alertDialog = tvOldVersionsFragment.f3442l;
                            if (alertDialog != null) {
                                alertDialog.dismiss();
                            }
                            AlertDialog.Builder builder = new AlertDialog.Builder(tvOldVersionsFragment.getContext());
                            builder.setTitle(tvOldVersionsFragment.getString(2131952803));
                            builder.setMessage(2131952294);
                            builder.setCancelable(false);
                            builder.setPositiveButton(R.string.ok, new g4.c0(tvOldVersionsFragment, str3, 2));
                            builder.setNegativeButton(R.string.cancel, new f5.b(10));
                            AlertDialog create = builder.create();
                            tvOldVersionsFragment.f3442l = create;
                            if (create != null) {
                                create.show();
                                return;
                            }
                            return;
                        }
                    } catch (PackageManager.NameNotFoundException e10) {
                        e10.printStackTrace();
                    }
                }
                Context requireContext2 = tvOldVersionsFragment.requireContext();
                requireContext2.getClass();
                h4.a aVar = new h4.a(requireContext2);
                if (aVar.d()) {
                    File[] externalFilesDirs = requireContext2.getExternalFilesDirs(null);
                    if (externalFilesDirs.length > 1) {
                        externalFilesDir = externalFilesDirs[1];
                    } else {
                        externalFilesDir = requireContext2.getExternalFilesDir(null);
                        aVar.g();
                        aVar.f();
                    }
                } else {
                    externalFilesDir = requireContext2.getExternalFilesDir(null);
                }
                File file = new File(externalFilesDir, "Apps");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, str4);
                float f = UptodownApp.I;
                FragmentActivity requireActivity = tvOldVersionsFragment.requireActivity();
                requireActivity.getClass();
                b4.d.r(requireActivity, file2);
            }
        }
    }
}
