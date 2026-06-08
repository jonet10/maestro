package c4;

import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.core.content.ContextCompat;
import com.uptodown.activities.UserDeviceDetailsActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class fc implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1610a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserDeviceDetailsActivity f1611b;

    public /* synthetic */ fc(UserDeviceDetailsActivity userDeviceDetailsActivity, int i) {
        this.f1610a = i;
        this.f1611b = userDeviceDetailsActivity;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        int i = this.f1610a;
        p6.x xVar = p6.x.f8463a;
        j5.q qVar = j5.q.f6706a;
        j5.p pVar = j5.p.f6705a;
        final UserDeviceDetailsActivity userDeviceDetailsActivity = this.f1611b;
        switch (i) {
            case 0:
                j5.s sVar = (j5.s) obj;
                if (!kotlin.jvm.internal.l.a(sVar, pVar)) {
                    if (!(sVar instanceof j5.r)) {
                        if (!kotlin.jvm.internal.l.a(sVar, qVar)) {
                            com.google.gson.internal.a.b();
                            break;
                        }
                    } else {
                        final x4.z2 z2Var = ((jc) ((j5.r) sVar).f6707a).f1773a;
                        int i6 = UserDeviceDetailsActivity.T;
                        userDeviceDetailsActivity.y0().f9715x.setText(z2Var.f11483l);
                        userDeviceDetailsActivity.y0().v.setText(z2Var.f11484m);
                        userDeviceDetailsActivity.y0().B.setText(z2Var.f11485n);
                        if (z2Var.f11489r > 0) {
                            userDeviceDetailsActivity.y0().f9705m.setImageDrawable(ContextCompat.getDrawable(userDeviceDetailsActivity, 2131231470));
                        } else {
                            userDeviceDetailsActivity.y0().f9705m.setImageDrawable(ContextCompat.getDrawable(userDeviceDetailsActivity, 2131231315));
                        }
                        userDeviceDetailsActivity.y0().f9710r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: c4.cc
                            @Override // android.widget.RadioGroup.OnCheckedChangeListener
                            public final void onCheckedChanged(RadioGroup radioGroup, int i10) {
                                x4.z2 z2Var2 = z2Var;
                                ArrayList arrayList = z2Var2.f11491t;
                                ArrayList arrayList2 = z2Var2.f11490s;
                                int i11 = UserDeviceDetailsActivity.T;
                                UserDeviceDetailsActivity userDeviceDetailsActivity2 = UserDeviceDetailsActivity.this;
                                if (i10 == userDeviceDetailsActivity2.y0().f9708p.getId()) {
                                    if (((Boolean) userDeviceDetailsActivity2.z0().h.getValue()).booleanValue()) {
                                        if (arrayList2.size() > 1) {
                                            q6.q.j0(arrayList2, new n5(7));
                                        }
                                    } else if (arrayList2.size() > 1) {
                                        q6.q.j0(arrayList2, new n5(5));
                                    }
                                    e4.c1 c1Var = userDeviceDetailsActivity2.Q;
                                    if (c1Var != null) {
                                        arrayList2.getClass();
                                        c1Var.f4503a = arrayList2;
                                        c1Var.notifyDataSetChanged();
                                    }
                                    RadioButton radioButton = userDeviceDetailsActivity2.y0().f9708p;
                                    radioButton.setBackground(ContextCompat.getDrawable(userDeviceDetailsActivity2, 2131231150));
                                    radioButton.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(userDeviceDetailsActivity2, 2131231314), (Drawable) null, (Drawable) null, (Drawable) null);
                                    RadioButton radioButton2 = userDeviceDetailsActivity2.y0().f9709q;
                                    radioButton2.setBackground(ContextCompat.getDrawable(userDeviceDetailsActivity2, 2131230898));
                                    radioButton2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                                } else if (i10 == userDeviceDetailsActivity2.y0().f9709q.getId()) {
                                    if (((Boolean) userDeviceDetailsActivity2.z0().h.getValue()).booleanValue()) {
                                        if (arrayList.size() > 1) {
                                            q6.q.j0(arrayList, new n5(8));
                                        }
                                    } else if (arrayList.size() > 1) {
                                        q6.q.j0(arrayList, new n5(6));
                                    }
                                    e4.c1 c1Var2 = userDeviceDetailsActivity2.Q;
                                    if (c1Var2 != null) {
                                        arrayList.getClass();
                                        c1Var2.f4503a = arrayList;
                                        c1Var2.notifyDataSetChanged();
                                    }
                                    RadioButton radioButton3 = userDeviceDetailsActivity2.y0().f9709q;
                                    radioButton3.setBackground(ContextCompat.getDrawable(userDeviceDetailsActivity2, 2131231150));
                                    radioButton3.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(userDeviceDetailsActivity2, 2131231314), (Drawable) null, (Drawable) null, (Drawable) null);
                                    RadioButton radioButton4 = userDeviceDetailsActivity2.y0().f9708p;
                                    radioButton4.setBackground(ContextCompat.getDrawable(userDeviceDetailsActivity2, 2131230898));
                                    radioButton4.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                                userDeviceDetailsActivity2.y0().f9711s.smoothScrollToPosition(0);
                            }
                        });
                        userDeviceDetailsActivity.Q = new e4.c1(z2Var.f11490s, userDeviceDetailsActivity.R);
                        userDeviceDetailsActivity.y0().f9711s.setAdapter(userDeviceDetailsActivity.Q);
                        userDeviceDetailsActivity.y0().f9707o.setVisibility(8);
                        userDeviceDetailsActivity.y0().f9706n.setVisibility(0);
                        break;
                    }
                } else {
                    userDeviceDetailsActivity.y0().f9707o.setVisibility(0);
                    break;
                }
                break;
            case 1:
                j5.s sVar2 = (j5.s) obj;
                if (!kotlin.jvm.internal.l.a(sVar2, pVar)) {
                    if (!(sVar2 instanceof j5.r)) {
                        if (!kotlin.jvm.internal.l.a(sVar2, qVar)) {
                            com.google.gson.internal.a.b();
                            break;
                        }
                    } else {
                        kc kcVar = (kc) ((j5.r) sVar2).f6707a;
                        String str = kcVar.f1803b;
                        if (str != null && str.length() != 0) {
                            userDeviceDetailsActivity.A(kcVar.f1803b);
                        }
                        if (kcVar.f1802a == 1) {
                            userDeviceDetailsActivity.y0().f9715x.setText(kcVar.f1805d);
                            userDeviceDetailsActivity.setResult(3);
                            break;
                        }
                    }
                }
                break;
            default:
                j5.s sVar3 = (j5.s) obj;
                if (!kotlin.jvm.internal.l.a(sVar3, pVar)) {
                    if (!(sVar3 instanceof j5.r)) {
                        if (!kotlin.jvm.internal.l.a(sVar3, qVar)) {
                            com.google.gson.internal.a.b();
                            break;
                        }
                    } else {
                        lc lcVar = (lc) ((j5.r) sVar3).f6707a;
                        String str2 = lcVar.f1841b;
                        if (str2 != null && str2.length() != 0) {
                            userDeviceDetailsActivity.A(lcVar.f1841b);
                        }
                        if (lcVar.f1840a == 1) {
                            String str3 = lcVar.f1842c;
                            b bVar = userDeviceDetailsActivity.S;
                            if (!kotlin.jvm.internal.l.a(str3, Settings.Secure.getString(userDeviceDetailsActivity.getContentResolver(), "android_id"))) {
                                userDeviceDetailsActivity.setResult(4);
                                bVar.handleOnBackPressed();
                                break;
                            } else {
                                userDeviceDetailsActivity.setResult(5);
                                bVar.handleOnBackPressed();
                                break;
                            }
                        }
                    }
                }
                break;
        }
        return null;
    }
}
