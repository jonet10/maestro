package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.CustomWebView;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.FollowListActivity;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.Gallery;
import com.uptodown.activities.LanguageSettingsActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.core.activities.ConfirmDeleteActivity;
import com.uptodown.tv.ui.activity.TvMainActivity;
import com.uptodown.tv.ui.activity.TvSearchActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1488a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1489b;

    public /* synthetic */ d(Object obj, int i) {
        this.f1488a = i;
        this.f1489b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g5.t tVar;
        FragmentManager supportFragmentManager;
        FragmentManager supportFragmentManager2;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        FragmentActivity activity;
        FragmentManager supportFragmentManager3;
        FragmentTransaction beginTransaction2;
        FragmentTransaction replace;
        FragmentTransaction addToBackStack;
        int bindingAdapterPosition;
        int bindingAdapterPosition2;
        int bindingAdapterPosition3;
        int i = this.f1488a;
        Object obj = this.f1489b;
        switch (i) {
            case 0:
                AppFilesActivity appFilesActivity = (AppFilesActivity) obj;
                int i6 = AppFilesActivity.S;
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    appFilesActivity.getOnBackPressedDispatcher().onBackPressed();
                    return;
                }
                return;
            case 1:
                int i10 = CustomWebView.Q;
                ((CustomWebView) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 2:
                int i11 = FeedActivity.S;
                ((FeedActivity) obj).finish();
                return;
            case 3:
                int i12 = FollowListActivity.S;
                ((FollowListActivity) obj).finish();
                return;
            case 4:
                int i13 = FreeUpSpaceActivity.T;
                ((FreeUpSpaceActivity) obj).finish();
                return;
            case 5:
                int i14 = LanguageSettingsActivity.S;
                ((LanguageSettingsActivity) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 6:
                t2 t2Var = (t2) obj;
                t2Var.E0();
                e0.a aVar = t2Var.O;
                aVar.getClass();
                t2Var.P.launch(aVar.b());
                return;
            case 7:
                int i15 = MoreInfo.V;
                TextView textView = ((t4.q) obj).f10061l;
                if (textView.getMaxLines() == 1) {
                    textView.setMaxLines(Integer.MAX_VALUE);
                    return;
                } else {
                    textView.setMaxLines(1);
                    return;
                }
            case 8:
                int i16 = MyStatsActivity.R;
                ((MyStatsActivity) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 9:
                int i17 = NotificationsRegistryActivity.T;
                ((NotificationsRegistryActivity) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 10:
                int i18 = OldVersionsActivity.S;
                ((OldVersionsActivity) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 11:
                int i19 = OrganizationActivity.R;
                ((OrganizationActivity) obj).finish();
                return;
            case 12:
                int i20 = PublicListActivity.f3334e0;
                ((PublicListActivity) obj).finish();
                return;
            case 13:
                int i21 = SecurityActivity.f3349g0;
                ((SecurityActivity) obj).finish();
                return;
            case 14:
                int i22 = UserCommentsActivity.S;
                ((UserCommentsActivity) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 15:
                int i23 = UserDevicesActivity.R;
                ((UserDevicesActivity) obj).getOnBackPressedDispatcher().onBackPressed();
                return;
            case 16:
                view.getClass();
                w4.m mVar = ((e4.i1) obj).f4565l;
                Object tag = view.getTag();
                tag.getClass();
                mVar.q(((Integer) tag).intValue());
                return;
            case 17:
                e4.m1 m1Var = (e4.m1) obj;
                boolean z9 = m1Var.f4635m;
                v3.e eVar = m1Var.h;
                if (z9) {
                    if (eVar != null) {
                        ((z3.g) eVar).e();
                        return;
                    }
                    return;
                } else {
                    if (eVar != null) {
                        ((z3.g) eVar).f();
                        return;
                    }
                    return;
                }
            case 18:
                int i24 = ConfirmDeleteActivity.f3373a;
                ((ConfirmDeleteActivity) obj).finish();
                return;
            case 19:
                Fragment fragment = (g5.k) obj;
                if (fragment.getActivity() instanceof TvMainActivity) {
                    FragmentActivity activity2 = fragment.getActivity();
                    activity2.getClass();
                    tVar = ((TvMainActivity) activity2).f3409m;
                    if (tVar == null) {
                        kotlin.jvm.internal.l.i("tvMainFragment");
                        throw null;
                    }
                } else {
                    tVar = null;
                }
                if (tVar != null && (activity = fragment.getActivity()) != null && (supportFragmentManager3 = activity.getSupportFragmentManager()) != null && (beginTransaction2 = supportFragmentManager3.beginTransaction()) != null && (replace = beginTransaction2.replace(2131362197, tVar)) != null && (addToBackStack = replace.addToBackStack(null)) != null) {
                    addToBackStack.commit();
                }
                FragmentActivity activity3 = fragment.getActivity();
                if (activity3 != null && (supportFragmentManager2 = activity3.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager2.beginTransaction()) != null && (remove = beginTransaction.remove(fragment)) != null) {
                    remove.commit();
                }
                FragmentActivity activity4 = fragment.getActivity();
                if (activity4 == null || (supportFragmentManager = activity4.getSupportFragmentManager()) == null) {
                    return;
                }
                supportFragmentManager.popBackStack();
                return;
            case 20:
                g5.t tVar2 = (g5.t) obj;
                int i25 = g5.t.f5355l;
                tVar2.startActivity(new Intent(tVar2.getActivity(), (Class<?>) TvSearchActivity.class));
                return;
            case 21:
                Object tag2 = view.getTag();
                tag2.getClass();
                int intValue = ((Integer) tag2).intValue();
                Intent intent = new Intent(view.getContext(), (Class<?>) Gallery.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("images", ((x4.g) obj).X);
                bundle.putInt("index", intValue);
                intent.putExtra("bundle", bundle);
                view.getContext().startActivity(intent);
                return;
            case 22:
                ((AlertDialog) obj).dismiss();
                return;
            case 23:
                View view2 = (View) obj;
                ViewParent parent = view2.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(view2);
                    return;
                }
                return;
            case 24:
                ((z3.g) ((v3.e) obj)).f();
                return;
            case 25:
                m5.a aVar2 = (m5.a) obj;
                w4.b bVar = aVar2.f7295a;
                if (bVar == null || (bindingAdapterPosition = aVar2.getBindingAdapterPosition()) == -1) {
                    return;
                }
                bVar.b(bindingAdapterPosition);
                return;
            case 26:
                m5.d dVar = (m5.d) obj;
                w4.b bVar2 = dVar.f7337a;
                if (bVar2 == null || (bindingAdapterPosition2 = dVar.getBindingAdapterPosition()) == -1) {
                    return;
                }
                bVar2.b(bindingAdapterPosition2);
                return;
            case 27:
                ((m5.n) obj).f7481b.e();
                return;
            case 28:
                m5.m0 m0Var = (m5.m0) obj;
                w4.b bVar3 = m0Var.f7472a;
                if (bVar3 == null || (bindingAdapterPosition3 = m0Var.getBindingAdapterPosition()) == -1) {
                    return;
                }
                bVar3.b(bindingAdapterPosition3);
                return;
            default:
                a3.d dVar2 = ((m5.q0) obj).f7526b;
                dVar2.getClass();
                float f10 = UptodownApp.I;
                if (b4.d.t()) {
                    ((RepliesActivity) dVar2.f63b).w0();
                    return;
                }
                return;
        }
    }
}
