package u4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import java.util.Map;
import x4.o2;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10469a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10470b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f10471l;

    public /* synthetic */ f(int i, Object obj, Object obj2) {
        this.f10469a = i;
        this.f10470b = obj;
        this.f10471l = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f10469a;
        Object obj = this.f10471l;
        Object obj2 = this.f10470b;
        switch (i) {
            case 0:
                ((f0) obj2).G().R.f(((Map.Entry) obj).getKey());
                break;
            case 1:
                f0 f0Var = (f0) obj2;
                if (((CheckBox) ((a4.d0) obj).f82l).isChecked()) {
                    Context requireContext = f0Var.requireContext();
                    requireContext.getClass();
                    SharedPreferences sharedPreferences = requireContext.getSharedPreferences("SettingsPreferences", 0);
                    sharedPreferences.getClass();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean("show_warning_download_incompatible", true);
                    edit.apply();
                }
                Context requireContext2 = f0Var.requireContext();
                requireContext2.getClass();
                f0Var.c0(requireContext2);
                if (f0Var.getActivity() != null) {
                    FragmentActivity activity = f0Var.getActivity();
                    activity.getClass();
                    AlertDialog alertDialog = ((c4.k0) activity).F;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                        break;
                    }
                }
                break;
            case 2:
                ((d7.a) obj).invoke();
                FragmentActivity activity2 = ((f0) obj2).getActivity();
                activity2.getClass();
                AlertDialog alertDialog2 = ((c4.k0) activity2).F;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
            case 3:
                f0 f0Var2 = (f0) obj2;
                x4.j jVar = (x4.j) obj;
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    f0Var2.Q(jVar);
                    break;
                }
                break;
            case 4:
                t4.q0 q0Var = (t4.q0) obj;
                f0 f0Var3 = (f0) obj2;
                TextView textView = q0Var.f10074w;
                TextView textView2 = q0Var.B;
                if (textView.getMaxLines() != Integer.MAX_VALUE) {
                    textView.setMaxLines(Integer.MAX_VALUE);
                    textView2.setText(f0Var3.getString(2131952510));
                    break;
                } else {
                    textView.setMaxLines(4);
                    textView2.setText(f0Var3.getString(2131952511));
                    break;
                }
            case 5:
                f0 f0Var4 = (f0) obj2;
                p2 p2Var = (p2) obj;
                float f10 = UptodownApp.I;
                if (b4.d.t()) {
                    f0Var4.Q(p2Var.f11329a);
                    break;
                }
                break;
            case 6:
                t4.p0 p0Var = (t4.p0) obj;
                f0 f0Var5 = (f0) obj2;
                TextView textView3 = p0Var.v;
                TextView textView4 = p0Var.A;
                if (textView3.getMaxLines() != Integer.MAX_VALUE) {
                    textView3.setMaxLines(Integer.MAX_VALUE);
                    textView4.setText(f0Var5.getString(2131952510));
                    break;
                } else {
                    textView3.setMaxLines(4);
                    textView4.setText(f0Var5.getString(2131952511));
                    break;
                }
            case 7:
                f0 f0Var6 = (f0) obj2;
                if (((t4.i) obj).f9862b.getVisibility() == 0) {
                    f0Var6.t();
                    break;
                }
                break;
            case 8:
                f0 f0Var7 = (f0) obj2;
                EditText editText = (EditText) ((e2.d) obj).f4467l;
                float f11 = UptodownApp.I;
                if (b4.d.t()) {
                    r7.o0 o0Var = f0Var7.G().H;
                    Editable text = editText.getText();
                    text.getClass();
                    o0Var.f(l7.m.K0(text).toString());
                    editText.setText((CharSequence) f0Var7.G().H.getValue());
                    FragmentActivity activity3 = f0Var7.getActivity();
                    activity3.getClass();
                    AlertDialog alertDialog3 = ((c4.k0) activity3).F;
                    if (alertDialog3 != null) {
                        alertDialog3.dismiss();
                        break;
                    }
                }
                break;
            case 9:
                f0 f0Var8 = (f0) obj2;
                if (!((kotlin.jvm.internal.u) obj).f7021a) {
                    a5.b.h();
                }
                FragmentActivity activity4 = f0Var8.getActivity();
                activity4.getClass();
                AlertDialog alertDialog4 = ((c4.k0) activity4).F;
                if (alertDialog4 != null) {
                    alertDialog4.dismiss();
                    break;
                }
                break;
            case 10:
                f0 f0Var9 = (f0) obj2;
                x4.c cVar = (x4.c) obj;
                if (f0Var9.getActivity() != null) {
                    FragmentActivity activity5 = f0Var9.getActivity();
                    activity5.getClass();
                    if (((c4.k0) activity5).T()) {
                        if (!(f0Var9.getActivity() instanceof MainActivity)) {
                            if (f0Var9.getActivity() instanceof AppDetailActivity) {
                                FragmentActivity activity6 = f0Var9.getActivity();
                                activity6.getClass();
                                AppDetailActivity appDetailActivity = (AppDetailActivity) activity6;
                                cVar.getClass();
                                d dVar = new d();
                                dVar.f10447b = cVar;
                                FragmentTransaction beginTransaction = appDetailActivity.getSupportFragmentManager().beginTransaction();
                                beginTransaction.getClass();
                                float f12 = UptodownApp.I;
                                b4.d.C(beginTransaction, appDetailActivity);
                                beginTransaction.add(2131362186, dVar, (String) null).addToBackStack(cVar.f11071a).commit();
                                appDetailActivity.U.add(dVar);
                                break;
                            }
                        } else {
                            FragmentActivity activity7 = f0Var9.getActivity();
                            activity7.getClass();
                            MainActivity mainActivity = (MainActivity) activity7;
                            cVar.getClass();
                            mainActivity.Y0();
                            d dVar2 = new d();
                            dVar2.f10447b = cVar;
                            FragmentTransaction beginTransaction2 = mainActivity.getSupportFragmentManager().beginTransaction();
                            beginTransaction2.getClass();
                            if (((CoordinatorLayout) mainActivity.findViewById(2131363229)) == null) {
                                String string = mainActivity.getString(2131951998);
                                string.getClass();
                                mainActivity.A(string);
                                break;
                            } else {
                                try {
                                    float f13 = UptodownApp.I;
                                    b4.d.C(beginTransaction2, mainActivity);
                                    beginTransaction2.add(2131363229, dVar2);
                                    beginTransaction2.addToBackStack(cVar.f11071a);
                                    if (mainActivity.W0() instanceof z1) {
                                        beginTransaction2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                                    }
                                    if (!mainActivity.isFinishing() && !mainActivity.getSupportFragmentManager().isDestroyed()) {
                                        try {
                                            beginTransaction2.commitAllowingStateLoss();
                                            break;
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                            String string2 = mainActivity.getString(2131951998);
                                            string2.getClass();
                                            mainActivity.A(string2);
                                            return;
                                        }
                                    }
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                    String string3 = mainActivity.getString(2131951998);
                                    string3.getClass();
                                    mainActivity.A(string3);
                                    return;
                                }
                            }
                        }
                    }
                }
                break;
            case 11:
                z1 z1Var = (z1) obj;
                Intent intent = new Intent("android.intent.action.SEND");
                intent.addFlags(524288);
                intent.setType("text/plain");
                o2 o2Var = ((p2) obj2).f11332d;
                o2Var.getClass();
                intent.putExtra("android.intent.extra.TEXT", o2Var.g);
                z1Var.startActivity(Intent.createChooser(intent, z1Var.getString(2131952430)));
                break;
            default:
                String str = (String) obj;
                str.getClass();
                Context context = ((x5.d) obj2).getContext();
                if (context != null) {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(str));
                    context.startActivity(intent2);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ f(Object obj, f0 f0Var, int i) {
        this.f10469a = i;
        this.f10471l = obj;
        this.f10470b = f0Var;
    }
}
