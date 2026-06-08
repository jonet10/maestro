package g5;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import c4.ya;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y implements OnItemViewClickedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f5364a;

    public y(TvMyAppsFragment tvMyAppsFragment) {
        this.f5364a = tvMyAppsFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        boolean z9;
        viewHolder.getClass();
        obj.getClass();
        if (obj instanceof x4.e) {
            TvMyAppsFragment tvMyAppsFragment = this.f5364a;
            int i = 2;
            t6.c cVar = null;
            if (tvMyAppsFragment.f3435n) {
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(tvMyAppsFragment);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(lifecycleScope, t7.n.f10348a, null, new ya(tvMyAppsFragment, (x4.e) obj, cVar, 12), 2);
                return;
            }
            if (tvMyAppsFragment.f3434m) {
                long j = ((x4.e) obj).F;
                LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(tvMyAppsFragment);
                v7.e eVar2 = o7.m0.f8288a;
                o7.c0.s(lifecycleScope2, t7.n.f10348a, null, new z(tvMyAppsFragment, j, viewHolder, null), 2);
                return;
            }
            x4.e eVar3 = (x4.e) obj;
            if (tvMyAppsFragment.getParentFragmentManager().isDestroyed()) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(tvMyAppsFragment.requireContext());
            LayoutInflater layoutInflater = tvMyAppsFragment.getLayoutInflater();
            layoutInflater.getClass();
            int i6 = 0;
            View inflate = layoutInflater.inflate(2131558840, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(2131364374);
            textView.setTypeface(f4.c.f4882w);
            textView.setText(eVar3.f11122b);
            TextView textView2 = (TextView) inflate.findViewById(2131364261);
            int i10 = 1;
            if (eVar3.F > 0) {
                textView2.setTypeface(f4.c.f4883x);
                textView2.setOnClickListener(new c4.t(tvMyAppsFragment, eVar3, viewHolder, 13));
                z9 = true;
            } else {
                textView2.setVisibility(8);
                z9 = false;
            }
            TextView textView3 = (TextView) inflate.findViewById(2131364118);
            TextView textView4 = (TextView) inflate.findViewById(2131364486);
            if (tvMyAppsFragment.getContext() == null || l7.u.m0(tvMyAppsFragment.requireContext().getPackageName(), eVar3.f11123l, true)) {
                textView3.setVisibility(8);
                textView4.setVisibility(8);
            } else {
                textView3.setTypeface(f4.c.f4883x);
                textView3.setOnClickListener(new w(eVar3, tvMyAppsFragment, i6));
                if (eVar3.c()) {
                    textView4.setVisibility(8);
                } else {
                    textView4.setTypeface(f4.c.f4883x);
                    textView4.setOnClickListener(new w(eVar3, tvMyAppsFragment, i10));
                }
                z9 = true;
            }
            float f = UptodownApp.I;
            TextView textView5 = (TextView) inflate.findViewById(2131364116);
            if (tvMyAppsFragment.getContext() == null || l7.u.m0(tvMyAppsFragment.requireContext().getPackageName(), eVar3.f11123l, true)) {
                textView5.setVisibility(8);
            } else {
                textView5.setTypeface(f4.c.f4883x);
                textView5.setOnClickListener(new w(tvMyAppsFragment, eVar3, i));
            }
            TextView textView6 = (TextView) inflate.findViewById(2131363858);
            if (eVar3.v == 0) {
                textView6.setText(tvMyAppsFragment.getString(2131952395));
            } else {
                textView6.setText(tvMyAppsFragment.getString(2131952417));
            }
            textView6.setTypeface(f4.c.f4883x);
            textView6.setOnClickListener(new w(tvMyAppsFragment, eVar3, 3));
            if (z9) {
                builder.setView(inflate);
                AlertDialog create = builder.create();
                tvMyAppsFragment.f3433l = create;
                create.getClass();
                create.show();
            }
        }
    }
}
