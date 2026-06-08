package g5;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c0 implements OnItemViewClickedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvMyDownloadsFragment f5301a;

    public c0(TvMyDownloadsFragment tvMyDownloadsFragment) {
        this.f5301a = tvMyDownloadsFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof x4.r) {
            final x4.r rVar = (x4.r) obj;
            final TvMyDownloadsFragment tvMyDownloadsFragment = this.f5301a;
            AlertDialog alertDialog = tvMyDownloadsFragment.f3438b;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (tvMyDownloadsFragment.getActivity() == null || tvMyDownloadsFragment.requireActivity().isFinishing()) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(tvMyDownloadsFragment.getContext());
            LayoutInflater layoutInflater = tvMyDownloadsFragment.getLayoutInflater();
            layoutInflater.getClass();
            final int i = 0;
            View inflate = layoutInflater.inflate(2131558832, (ViewGroup) null, false);
            ((TextView) inflate.findViewById(2131363907)).setOnClickListener(new View.OnClickListener() { // from class: g5.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    File g;
                    int i6 = i;
                    TvMyDownloadsFragment tvMyDownloadsFragment2 = tvMyDownloadsFragment;
                    x4.r rVar2 = rVar;
                    switch (i6) {
                        case 0:
                            if (rVar2.c() && (g = rVar2.g()) != null) {
                                float f = UptodownApp.I;
                                FragmentActivity requireActivity = tvMyDownloadsFragment2.requireActivity();
                                requireActivity.getClass();
                                b4.d.r(requireActivity, g);
                            }
                            AlertDialog alertDialog2 = tvMyDownloadsFragment2.f3438b;
                            if (alertDialog2 != null) {
                                alertDialog2.dismiss();
                                break;
                            }
                            break;
                        default:
                            rVar2.d();
                            e1.c0 c0Var = j5.g.D;
                            Context requireContext = tvMyDownloadsFragment2.requireContext();
                            requireContext.getClass();
                            j5.g l10 = c0Var.l(requireContext);
                            l10.b();
                            l10.j(rVar2);
                            l10.c();
                            ArrayObjectAdapter arrayObjectAdapter = tvMyDownloadsFragment2.f3437a;
                            arrayObjectAdapter.getClass();
                            arrayObjectAdapter.remove(rVar2);
                            AlertDialog alertDialog3 = tvMyDownloadsFragment2.f3438b;
                            if (alertDialog3 != null) {
                                alertDialog3.dismiss();
                                break;
                            }
                            break;
                    }
                }
            });
            final int i6 = 1;
            ((TextView) inflate.findViewById(2131363757)).setOnClickListener(new View.OnClickListener() { // from class: g5.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    File g;
                    int i62 = i6;
                    TvMyDownloadsFragment tvMyDownloadsFragment2 = tvMyDownloadsFragment;
                    x4.r rVar2 = rVar;
                    switch (i62) {
                        case 0:
                            if (rVar2.c() && (g = rVar2.g()) != null) {
                                float f = UptodownApp.I;
                                FragmentActivity requireActivity = tvMyDownloadsFragment2.requireActivity();
                                requireActivity.getClass();
                                b4.d.r(requireActivity, g);
                            }
                            AlertDialog alertDialog2 = tvMyDownloadsFragment2.f3438b;
                            if (alertDialog2 != null) {
                                alertDialog2.dismiss();
                                break;
                            }
                            break;
                        default:
                            rVar2.d();
                            e1.c0 c0Var = j5.g.D;
                            Context requireContext = tvMyDownloadsFragment2.requireContext();
                            requireContext.getClass();
                            j5.g l10 = c0Var.l(requireContext);
                            l10.b();
                            l10.j(rVar2);
                            l10.c();
                            ArrayObjectAdapter arrayObjectAdapter = tvMyDownloadsFragment2.f3437a;
                            arrayObjectAdapter.getClass();
                            arrayObjectAdapter.remove(rVar2);
                            AlertDialog alertDialog3 = tvMyDownloadsFragment2.f3438b;
                            if (alertDialog3 != null) {
                                alertDialog3.dismiss();
                                break;
                            }
                            break;
                    }
                }
            });
            builder.setView(inflate);
            AlertDialog create = builder.create();
            tvMyDownloadsFragment.f3438b = create;
            if (create != null) {
                create.show();
            }
        }
    }
}
