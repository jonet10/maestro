package u4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.viewbinding.ViewBindings;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.CustomWebView;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.InformationActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10463a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10464b;

    public /* synthetic */ e(f0 f0Var, int i) {
        this.f10463a = i;
        this.f10464b = f0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        int i = this.f10463a;
        f0 f0Var = this.f10464b;
        switch (i) {
            case 0:
                f0Var.t();
                break;
            case 1:
                Intent intent = new Intent(f0Var.requireActivity(), (Class<?>) FreeUpSpaceActivity.class);
                intent.putExtra("appInfo", f0Var.B());
                float f = UptodownApp.I;
                FragmentActivity requireActivity = f0Var.requireActivity();
                requireActivity.getClass();
                f0Var.startActivity(intent, b4.d.a(requireActivity));
                break;
            case 2:
                if (((Number) f0Var.G().R.getValue()).intValue() >= 0) {
                    Context requireContext = f0Var.requireContext();
                    requireContext.getClass();
                    boolean z9 = ((Number) f0Var.G().R.getValue()).intValue() > 0;
                    SharedPreferences sharedPreferences = requireContext.getSharedPreferences("SettingsPreferences", 0);
                    sharedPreferences.getClass();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean("storage_sdcard", z9);
                    edit.apply();
                    FragmentActivity activity = f0Var.getActivity();
                    activity.getClass();
                    AlertDialog alertDialog = ((c4.k0) activity).F;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                    }
                    f0Var.e0();
                    break;
                }
                break;
            case 3:
                f0Var.y();
                if (f0Var.getActivity() != null) {
                    FragmentActivity activity2 = f0Var.getActivity();
                    activity2.getClass();
                    AlertDialog alertDialog2 = ((c4.k0) activity2).F;
                    if (alertDialog2 != null) {
                        alertDialog2.dismiss();
                        break;
                    }
                }
                break;
            case 4:
                f0Var.t();
                break;
            case 5:
                FragmentActivity activity3 = f0Var.getActivity();
                activity3.getClass();
                AlertDialog alertDialog3 = ((c4.k0) activity3).F;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                    break;
                }
                break;
            case 6:
                float f10 = UptodownApp.I;
                if (b4.d.t()) {
                    FragmentActivity activity4 = f0Var.getActivity();
                    activity4.getClass();
                    if (((c4.k0) activity4).T()) {
                        v0 G = f0Var.G();
                        Context requireContext2 = f0Var.requireContext();
                        requireContext2.getClass();
                        long j = f0Var.B().f11158a;
                        String str2 = f0Var.B().f11159b;
                        str2.getClass();
                        String i6 = f0Var.B().i();
                        t4.b bVar = f0Var.f10473b;
                        bVar.getClass();
                        boolean isChecked = bVar.f9603d0.isChecked();
                        G.getClass();
                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(G);
                        v7.e eVar = o7.m0.f8288a;
                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new m0(G, j, str2, i6, isChecked, requireContext2, null), 2);
                        break;
                    }
                }
                break;
            case 7:
                if (f0Var.getContext() != null) {
                    CustomTabsIntent build = new CustomTabsIntent.Builder().build();
                    build.getClass();
                    Context requireContext3 = f0Var.requireContext();
                    requireContext3.getClass();
                    String H = d0.b.H(requireContext3);
                    if (l7.m.q0(H, ".uptodown.com/", false)) {
                        H = (l7.m.q0(H, "?", false) ? H.concat("&") : H.concat("?")).concat("userAgent=uptodownandroid");
                    }
                    build.intent.setData(Uri.parse(H));
                    try {
                        ActivityResultLauncher activityResultLauncher = f0Var.f10486y;
                        Intent intent2 = build.intent;
                        float f11 = UptodownApp.I;
                        FragmentActivity requireActivity2 = f0Var.requireActivity();
                        requireActivity2.getClass();
                        activityResultLauncher.launch(intent2, b4.d.b(requireActivity2));
                        break;
                    } catch (Exception unused) {
                        Intent intent3 = new Intent(f0Var.getActivity(), (Class<?>) CustomWebView.class);
                        intent3.putExtra("url", H);
                        float f12 = UptodownApp.I;
                        FragmentActivity requireActivity3 = f0Var.requireActivity();
                        requireActivity3.getClass();
                        f0Var.startActivity(intent3, b4.d.a(requireActivity3));
                        return;
                    }
                }
                break;
            case 8:
                x4.j jVar = new x4.j(0, (String) null, 7);
                x4.y1 y1Var = f0Var.B().G0;
                y1Var.getClass();
                if (y1Var.f11469l > -1) {
                    x4.y1 y1Var2 = f0Var.B().G0;
                    y1Var2.getClass();
                    jVar.f11224a = y1Var2.f11469l;
                    x4.y1 y1Var3 = f0Var.B().G0;
                    y1Var3.getClass();
                    jVar.f11229o = y1Var3.f11471n;
                } else {
                    x4.y1 y1Var4 = f0Var.B().G0;
                    y1Var4.getClass();
                    if (y1Var4.f11468b > -1) {
                        x4.y1 y1Var5 = f0Var.B().G0;
                        y1Var5.getClass();
                        jVar.f11224a = y1Var5.f11468b;
                        jVar.f11227m = true;
                    }
                }
                x4.y1 y1Var6 = f0Var.B().G0;
                y1Var6.getClass();
                String str3 = y1Var6.f11470m;
                if (str3 != null && str3.length() != 0) {
                    x4.y1 y1Var7 = f0Var.B().G0;
                    y1Var7.getClass();
                    jVar.f11225b = y1Var7.f11470m;
                }
                f0Var.Q(jVar);
                break;
            case 9:
                if (f0Var.getActivity() != null) {
                    if (!(f0Var.getActivity() instanceof MainActivity)) {
                        if (f0Var.getActivity() instanceof AppDetailActivity) {
                            FragmentActivity activity5 = f0Var.getActivity();
                            activity5.getClass();
                            ((AppDetailActivity) activity5).finish();
                            break;
                        }
                    } else {
                        FragmentActivity activity6 = f0Var.getActivity();
                        activity6.getClass();
                        ((MainActivity) activity6).h1();
                        break;
                    }
                }
                break;
            case 10:
                f0Var.T();
                break;
            case 11:
                if (!f0Var.requireActivity().isFinishing()) {
                    Intent intent4 = new Intent(f0Var.requireActivity(), (Class<?>) MoreInfo.class);
                    intent4.putExtra("appInfo", f0Var.B());
                    float f13 = UptodownApp.I;
                    FragmentActivity requireActivity4 = f0Var.requireActivity();
                    requireActivity4.getClass();
                    f0Var.startActivity(intent4, b4.d.a(requireActivity4));
                    break;
                }
                break;
            case 12:
                if (!f0Var.requireActivity().isFinishing() && f0Var.B().k()) {
                    FragmentActivity activity7 = f0Var.getActivity();
                    activity7.getClass();
                    if (((c4.k0) activity7).T()) {
                        Intent intent5 = new Intent(f0Var.requireActivity(), (Class<?>) OldVersionsActivity.class);
                        intent5.putExtra("appInfo", f0Var.B());
                        float f14 = UptodownApp.I;
                        FragmentActivity requireActivity5 = f0Var.requireActivity();
                        requireActivity5.getClass();
                        f0Var.startActivity(intent5, b4.d.a(requireActivity5));
                        break;
                    }
                }
                break;
            case 13:
                if (f0Var.getActivity() != null && !f0Var.requireActivity().isFinishing()) {
                    FragmentActivity activity8 = f0Var.getActivity();
                    activity8.getClass();
                    if (((c4.k0) activity8).T()) {
                        String string = f0Var.getString(2131951958);
                        string.getClass();
                        String string2 = f0Var.getString(2131952729);
                        string2.getClass();
                        FragmentActivity requireActivity6 = f0Var.requireActivity();
                        requireActivity6.getClass();
                        j5.c.e(requireActivity6, string2, string);
                        break;
                    }
                }
                break;
            case 14:
                f0Var.T();
                break;
            case 15:
                f0Var.T();
                break;
            case 16:
                if (!f0Var.requireActivity().isFinishing()) {
                    Intent intent6 = new Intent(f0Var.requireActivity(), (Class<?>) InformationActivity.class);
                    float f15 = UptodownApp.I;
                    FragmentActivity requireActivity7 = f0Var.requireActivity();
                    requireActivity7.getClass();
                    f0Var.startActivity(intent6, b4.d.a(requireActivity7));
                    break;
                }
                break;
            case 17:
                float f16 = UptodownApp.I;
                if (b4.d.t() && f0Var.G().C.getValue() != null) {
                    Context requireContext4 = f0Var.requireContext();
                    requireContext4.getClass();
                    Object value = f0Var.G().C.getValue();
                    value.getClass();
                    String str4 = ((x4.e) value).f11123l;
                    str4.getClass();
                    Intent intent7 = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str4)));
                    intent7.addFlags(268435456);
                    requireContext4.startActivity(intent7);
                    break;
                }
                break;
            case 18:
                float f17 = UptodownApp.I;
                if (b4.d.t()) {
                    FragmentActivity activity9 = f0Var.getActivity();
                    activity9.getClass();
                    if (((c4.k0) activity9).T()) {
                        FragmentActivity activity10 = f0Var.getActivity();
                        activity10.getClass();
                        AlertDialog alertDialog4 = ((c4.k0) activity10).F;
                        if (alertDialog4 != null) {
                            alertDialog4.dismiss();
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(f0Var.getContext());
                        View inflate = f0Var.getLayoutInflater().inflate(2131558537, (ViewGroup) null, false);
                        int i10 = 2131362457;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362457);
                        if (imageView != null) {
                            i10 = 2131362458;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362458);
                            if (imageView2 != null) {
                                i10 = 2131362558;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362558);
                                if (imageView3 != null) {
                                    i10 = 2131362559;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362559);
                                    if (imageView4 != null) {
                                        i10 = 2131362721;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131362721);
                                        if (relativeLayout != null) {
                                            i10 = 2131362783;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131362783);
                                            if (relativeLayout2 != null) {
                                                i10 = 2131364213;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364213);
                                                if (textView != null) {
                                                    i10 = 2131364388;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364388);
                                                    if (textView2 != null) {
                                                        i10 = 2131364615;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364615);
                                                        if (textView3 != null) {
                                                            LinearLayout linearLayout = (LinearLayout) inflate;
                                                            if (f0Var.getActivity() != null && !f0Var.requireActivity().isFinishing()) {
                                                                textView2.setTypeface(f4.c.f4882w);
                                                                textView3.setTypeface(f4.c.f4882w);
                                                                textView.setTypeface(f4.c.f4882w);
                                                                if (((Number) f0Var.G().E.getValue()).intValue() == 1) {
                                                                    relativeLayout2.setBackground(ContextCompat.getDrawable(f0Var.requireContext(), 2131231146));
                                                                    textView3.setTextColor(ContextCompat.getColor(f0Var.requireContext(), 2131100824));
                                                                    imageView4.setVisibility(0);
                                                                    imageView3.setImageDrawable(ContextCompat.getDrawable(f0Var.requireContext(), 2131231346));
                                                                }
                                                                if (((Number) f0Var.G().F.getValue()).intValue() == 1) {
                                                                    relativeLayout.setBackground(ContextCompat.getDrawable(f0Var.requireContext(), 2131231146));
                                                                    textView.setTextColor(ContextCompat.getColor(f0Var.requireContext(), 2131100824));
                                                                    imageView2.setVisibility(0);
                                                                    imageView.setImageDrawable(ContextCompat.getDrawable(f0Var.requireContext(), 2131231308));
                                                                }
                                                                relativeLayout.setOnClickListener(new p(f0Var, 17));
                                                                relativeLayout2.setOnClickListener(new p(f0Var, 18));
                                                                builder.setView(linearLayout);
                                                                builder.setCancelable(true);
                                                                f0Var.m0(builder);
                                                                break;
                                                            }
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
                        break;
                    }
                }
                break;
            case 19:
                float f18 = UptodownApp.I;
                if (b4.d.t() && !((Boolean) f0Var.G().T.getValue()).booleanValue()) {
                    f0Var.V();
                    break;
                }
                break;
            case 20:
                float f19 = UptodownApp.I;
                if (b4.d.t()) {
                    f0Var.n();
                    break;
                }
                break;
            case 21:
                float f20 = UptodownApp.I;
                if (b4.d.t()) {
                    f0Var.o();
                    break;
                }
                break;
            case 22:
                if (!f0Var.requireActivity().isFinishing()) {
                    FragmentActivity activity11 = f0Var.getActivity();
                    activity11.getClass();
                    if (((c4.k0) activity11).T()) {
                        Intent intent8 = new Intent(f0Var.requireActivity(), (Class<?>) OrganizationActivity.class);
                        intent8.putExtra("organizationID", f0Var.B().f11169k0);
                        intent8.putExtra("organizationName", f0Var.B().f11190w);
                        float f21 = UptodownApp.I;
                        FragmentActivity requireActivity8 = f0Var.requireActivity();
                        requireActivity8.getClass();
                        f0Var.startActivity(intent8, b4.d.a(requireActivity8));
                        break;
                    }
                }
                break;
            case 23:
                String str5 = f0Var.B().f11192x;
                if (str5 != null && str5.length() != 0) {
                    t4.b bVar2 = f0Var.f10473b;
                    bVar2.getClass();
                    int visibility = bVar2.f9604e0.getVisibility();
                    t4.b bVar3 = f0Var.f10473b;
                    if (visibility != 0) {
                        bVar3.getClass();
                        bVar3.f9638z0.setText(2131952511);
                        t4.b bVar4 = f0Var.f10473b;
                        bVar4.getClass();
                        bVar4.f9604e0.setVisibility(0);
                        t4.b bVar5 = f0Var.f10473b;
                        bVar5.getClass();
                        bVar5.X.setVisibility(8);
                        t4.b bVar6 = f0Var.f10473b;
                        bVar6.getClass();
                        bVar6.f9609j0.setMaxLines(6);
                        t4.b bVar7 = f0Var.f10473b;
                        bVar7.getClass();
                        bVar7.f9609j0.setEllipsize(TextUtils.TruncateAt.END);
                        t4.b bVar8 = f0Var.f10473b;
                        bVar8.getClass();
                        bVar8.Q.setVisibility(8);
                        t4.b bVar9 = f0Var.f10473b;
                        bVar9.getClass();
                        NestedScrollView nestedScrollView = bVar9.f9605f0;
                        t4.b bVar10 = f0Var.f10473b;
                        bVar10.getClass();
                        nestedScrollView.smoothScrollTo(0, bVar10.T.A.getBottom(), 1000);
                        break;
                    } else {
                        bVar3.getClass();
                        bVar3.f9638z0.setText(2131952510);
                        t4.b bVar11 = f0Var.f10473b;
                        bVar11.getClass();
                        bVar11.f9604e0.setVisibility(8);
                        String str6 = f0Var.B().R;
                        if ((str6 != null && str6.length() != 0) || ((str = f0Var.B().Q) != null && str.length() != 0)) {
                            t4.b bVar12 = f0Var.f10473b;
                            bVar12.getClass();
                            bVar12.X.setVisibility(0);
                        }
                        t4.b bVar13 = f0Var.f10473b;
                        bVar13.getClass();
                        bVar13.f9609j0.setMaxLines(Integer.MAX_VALUE);
                        t4.b bVar14 = f0Var.f10473b;
                        bVar14.getClass();
                        bVar14.f9609j0.setEllipsize(null);
                        String str7 = f0Var.B().f11171l0;
                        if (str7 != null && str7.length() != 0) {
                            t4.b bVar15 = f0Var.f10473b;
                            bVar15.getClass();
                            bVar15.Q.setVisibility(0);
                            break;
                        }
                    }
                }
                break;
            case 24:
                String str8 = f0Var.B().f11161c0;
                if (str8 != null && str8.length() != 0) {
                    t4.b bVar16 = f0Var.f10473b;
                    bVar16.getClass();
                    int visibility2 = bVar16.Y.f10129o.getVisibility();
                    t4.b bVar17 = f0Var.f10473b;
                    if (visibility2 != 0) {
                        bVar17.getClass();
                        bVar17.Y.f10126l.setText(2131952511);
                        t4.b bVar18 = f0Var.f10473b;
                        bVar18.getClass();
                        bVar18.Y.f10129o.setVisibility(0);
                        t4.b bVar19 = f0Var.f10473b;
                        bVar19.getClass();
                        bVar19.Y.f10128n.setMaxLines(6);
                        t4.b bVar20 = f0Var.f10473b;
                        bVar20.getClass();
                        bVar20.Y.f10128n.setEllipsize(TextUtils.TruncateAt.END);
                        t4.b bVar21 = f0Var.f10473b;
                        bVar21.getClass();
                        NestedScrollView nestedScrollView2 = bVar21.f9605f0;
                        t4.b bVar22 = f0Var.f10473b;
                        bVar22.getClass();
                        nestedScrollView2.smoothScrollTo(0, bVar22.Y.f10127m.getTop(), 1000);
                        break;
                    } else {
                        bVar17.getClass();
                        bVar17.Y.f10126l.setText(2131952510);
                        t4.b bVar23 = f0Var.f10473b;
                        bVar23.getClass();
                        bVar23.Y.f10129o.setVisibility(8);
                        t4.b bVar24 = f0Var.f10473b;
                        bVar24.getClass();
                        bVar24.Y.f10128n.setMaxLines(Integer.MAX_VALUE);
                        t4.b bVar25 = f0Var.f10473b;
                        bVar25.getClass();
                        bVar25.Y.f10128n.setEllipsize(null);
                        break;
                    }
                }
                break;
            case 25:
                f0Var.T();
                break;
            case 26:
                f0Var.t();
                break;
            case 27:
                f0Var.t();
                break;
            case 28:
                Context requireContext5 = f0Var.requireContext();
                requireContext5.getClass();
                FragmentActivity requireActivity9 = f0Var.requireActivity();
                requireActivity9.getClass();
                d0.b.j(requireContext5, (c4.k0) requireActivity9, f0Var.f10484w, f0Var.B(), false);
                break;
            default:
                if (f0Var.getActivity() instanceof c4.k0) {
                    FragmentActivity requireActivity10 = f0Var.requireActivity();
                    requireActivity10.getClass();
                    b2.t1.u((c4.k0) requireActivity10, f0Var.B().f11174n);
                    break;
                }
                break;
        }
    }
}
