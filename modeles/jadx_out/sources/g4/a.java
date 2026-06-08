package g4;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import b2.t1;
import c4.b1;
import c4.bc;
import c4.z0;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FollowListActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.core.activities.ConfirmDeleteActivity;
import e1.v4;
import java.io.File;
import m5.f1;
import m5.s1;
import m5.y0;
import x4.k2;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5132a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5133b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f5134l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5135m;

    public /* synthetic */ a(s1 s1Var, int i, k2 k2Var) {
        this.f5132a = 4;
        this.f5134l = s1Var;
        this.f5133b = i;
        this.f5135m = k2Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        e4.d dVar;
        int i = this.f5132a;
        int i6 = this.f5133b;
        Object obj = this.f5135m;
        Object obj2 = this.f5134l;
        switch (i) {
            case 0:
                String str = (String) obj2;
                ConfirmDeleteActivity confirmDeleteActivity = (ConfirmDeleteActivity) obj;
                int i10 = ConfirmDeleteActivity.f3373a;
                if (str != null) {
                    new File(str).delete();
                }
                Object systemService = confirmDeleteActivity.getSystemService("notification");
                systemService.getClass();
                ((NotificationManager) systemService).cancel(i6);
                confirmDeleteActivity.finish();
                break;
            case 1:
                f0.i iVar = ((m5.q) obj2).f7523b;
                ((w2) obj).f11431a.getClass();
                FollowListActivity followListActivity = (FollowListActivity) iVar.f4811b;
                float f = UptodownApp.I;
                if (b4.d.t() && (dVar = followListActivity.Q) != null) {
                    Object obj3 = dVar.f4505a.get(i6);
                    obj3.getClass();
                    w2 w2Var = (w2) obj3;
                    t6.c cVar = null;
                    if (w2Var.f11439r == 1) {
                        b1 z02 = followListActivity.z0();
                        String str2 = w2Var.f11431a;
                        str2.getClass();
                        z02.getClass();
                        z02.f1409e = true;
                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                        v7.e eVar = o7.m0.f8288a;
                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new z0(z02, followListActivity, str2, cVar, 1), 2);
                        e4.d dVar2 = followListActivity.Q;
                        dVar2.getClass();
                        ((w2) dVar2.f4505a.get(i6)).f11439r = 0;
                    } else {
                        b1 z03 = followListActivity.z0();
                        String str3 = w2Var.f11431a;
                        str3.getClass();
                        z03.getClass();
                        z03.f1409e = true;
                        o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(z03);
                        v7.e eVar2 = o7.m0.f8288a;
                        o7.c0.s(viewModelScope2, v7.d.f10884a, null, new z0(z03, followListActivity, str3, cVar, 0), 2);
                        e4.d dVar3 = followListActivity.Q;
                        dVar3.getClass();
                        ((w2) dVar3.f4505a.get(i6)).f11439r = 1;
                    }
                    e4.d dVar4 = followListActivity.Q;
                    if (dVar4 != null) {
                        dVar4.notifyItemChanged(i6);
                        break;
                    }
                }
                break;
            case 2:
                ((y0) obj2).f7641m.d((x4.g) obj, i6);
                break;
            case 3:
                ((f1) obj2).f7380l.d((x4.g) obj, i6);
                break;
            case 4:
                s1 s1Var = (s1) obj2;
                k2 k2Var = (k2) obj;
                a3.d dVar5 = s1Var.f7562a;
                Context context = s1Var.f7563b;
                UserCommentsActivity userCommentsActivity = (UserCommentsActivity) dVar5.f63b;
                float f10 = UptodownApp.I;
                if (b4.d.t() && userCommentsActivity.T()) {
                    if (u2.h(userCommentsActivity) != null) {
                        e4.b1 b1Var = userCommentsActivity.Q;
                        b1Var.getClass();
                        if (!j5.t.f6709b.contains(Long.valueOf(((k2) b1Var.f4493a.get(i6)).f11258a))) {
                            bc z04 = userCommentsActivity.z0();
                            e4.b1 b1Var2 = userCommentsActivity.Q;
                            b1Var2.getClass();
                            Object obj4 = b1Var2.f4493a.get(i6);
                            obj4.getClass();
                            k2 k2Var2 = (k2) obj4;
                            z04.getClass();
                            o7.a0 viewModelScope3 = ViewModelKt.getViewModelScope(z04);
                            v7.e eVar3 = o7.m0.f8288a;
                            o7.c0.s(viewModelScope3, v7.d.f10884a, null, new b6.g(k2Var2, userCommentsActivity, z04, (t6.c) null, 12), 2);
                        }
                    } else {
                        String string = userCommentsActivity.getString(2131952183);
                        string.getClass();
                        String string2 = userCommentsActivity.getString(2131952182);
                        string2.getClass();
                        t1.v(userCommentsActivity, string, string2);
                    }
                }
                if (z3.f2928c && u2.h(context) != null) {
                    new v4(context, 1).h(s1Var.f7573u);
                    if (!j5.t.f6709b.contains(Long.valueOf(k2Var.f11258a))) {
                        s1Var.f7569q.setText(String.valueOf(k2Var.f11267s + 1));
                        break;
                    }
                }
                break;
            case 5:
                ((n5.n) obj).f8100b.invoke(Integer.valueOf(i6), (String) obj2);
                break;
            default:
                u4.f0 f0Var = (u4.f0) obj2;
                u uVar = (u) obj;
                if (f0Var.getActivity() != null && !f0Var.requireActivity().isFinishing()) {
                    EditText editText = uVar.f5267l;
                    Integer h02 = l7.t.h0(editText.getText().toString());
                    Editable text = editText.getText();
                    text.getClass();
                    if (text.length() > 0 && h02 != null) {
                        String obj5 = editText.getText().toString();
                        int intValue = h02.intValue();
                        obj5.getClass();
                        if (intValue < i6 && obj5.length() == 4 && intValue > 1900) {
                            Object systemService2 = f0Var.requireContext().getSystemService("input_method");
                            systemService2.getClass();
                            ((InputMethodManager) systemService2).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                            FragmentActivity activity = f0Var.getActivity();
                            activity.getClass();
                            ((c4.k0) activity).Q();
                            Context requireContext = f0Var.requireContext();
                            requireContext.getClass();
                            int intValue2 = h02.intValue();
                            SharedPreferences sharedPreferences = requireContext.getSharedPreferences("SettingsPreferences", 0);
                            sharedPreferences.getClass();
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putInt("ageVerificationYear", intValue2);
                            edit.apply();
                            if (i6 - h02.intValue() < 18) {
                                f0Var.s();
                                break;
                            } else {
                                t4.b bVar = f0Var.f10473b;
                                bVar.getClass();
                                bVar.f9611l.setVisibility(8);
                                break;
                            }
                        } else {
                            FragmentActivity activity2 = f0Var.getActivity();
                            activity2.getClass();
                            String string3 = f0Var.getString(2131951667);
                            string3.getClass();
                            ((c4.k0) activity2).A(string3);
                            break;
                        }
                    } else {
                        FragmentActivity activity3 = f0Var.getActivity();
                        activity3.getClass();
                        String string4 = f0Var.getString(2131951667);
                        string4.getClass();
                        ((c4.k0) activity3).A(string4);
                        break;
                    }
                }
                break;
        }
    }

    public /* synthetic */ a(int i, Object obj, int i6, Object obj2) {
        this.f5132a = i6;
        this.f5134l = obj;
        this.f5135m = obj2;
        this.f5133b = i;
    }

    public /* synthetic */ a(n5.n nVar, int i, String str) {
        this.f5132a = 5;
        this.f5135m = nVar;
        this.f5133b = i;
        this.f5134l = str;
    }
}
