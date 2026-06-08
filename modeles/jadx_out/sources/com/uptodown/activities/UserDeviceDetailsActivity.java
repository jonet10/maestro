package com.uptodown.activities;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBindings;
import b5.l;
import c4.b;
import c4.dc;
import c4.gc;
import c4.hc;
import c4.ic;
import c4.k0;
import c4.nc;
import c4.w6;
import com.uptodown.activities.UserDeviceDetailsActivity;
import e4.c1;
import f0.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.y;
import l5.f;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import r7.o0;
import t4.d1;
import t6.c;
import t7.n;
import v7.d;
import v7.e;
import x4.z2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class UserDeviceDetailsActivity extends k0 {
    public static final /* synthetic */ int T = 0;
    public c1 Q;
    public final m O = new m(new w6(this, 11));
    public final ViewModelLazy P = new ViewModelLazy(y.a(nc.class), new ic(this, 0), new hc(this), new ic(this, 1));
    public final i R = new i(this, 16);
    public final b S = new b(this, 6);

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f9702a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        getOnBackPressedDispatcher().addCallback(this.S);
        final int i = 1;
        final int i6 = 0;
        int i10 = 2;
        c cVar = null;
        if (getIntent() != null && (extras = getIntent().getExtras()) != null && extras.containsKey("user_device")) {
            o0 o0Var = z0().f1919a;
            Parcelable parcelable = Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("user_device", z2.class) : extras.getParcelable("user_device");
            parcelable.getClass();
            o0Var.getClass();
            o0Var.g(null, parcelable);
            final z2 z2Var = (z2) z0().f1919a.getValue();
            Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
            if (drawable != null) {
                y0().f9712t.setNavigationIcon(drawable);
                y0().f9712t.setNavigationContentDescription(getString(2131951735));
            }
            y0().f9712t.setNavigationOnClickListener(new dc(this, i6));
            y0().G.setTypeface(f4.c.f4882w);
            y0().f9712t.setNavigationOnClickListener(new dc(this, i));
            y0().f9715x.setTypeface(f4.c.f4882w);
            y0().C.setTypeface(f4.c.f4883x);
            y0().D.setTypeface(f4.c.f4883x);
            y0().f9713u.setTypeface(f4.c.f4883x);
            y0().v.setTypeface(f4.c.f4883x);
            y0().A.setTypeface(f4.c.f4883x);
            y0().B.setTypeface(f4.c.f4883x);
            y0().f9716y.setTypeface(f4.c.f4883x);
            y0().f9717z.setTypeface(f4.c.f4883x);
            y0().F.setTypeface(f4.c.f4883x);
            y0().E.setTypeface(f4.c.f4882w);
            y0().f9714w.setTypeface(f4.c.f4882w);
            y0().f9708p.setTypeface(f4.c.f4883x);
            y0().f9709q.setTypeface(f4.c.f4883x);
            y0().E.setOnClickListener(new View.OnClickListener(this) { // from class: c4.ec

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ UserDeviceDetailsActivity f1571b;

                {
                    this.f1571b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i11 = i6;
                    x4.z2 z2Var2 = z2Var;
                    UserDeviceDetailsActivity userDeviceDetailsActivity = this.f1571b;
                    switch (i11) {
                        case 0:
                            int i12 = UserDeviceDetailsActivity.T;
                            String string = userDeviceDetailsActivity.getString(2131952701);
                            string.getClass();
                            userDeviceDetailsActivity.H(string, new androidx.work.impl.utils.c(7, userDeviceDetailsActivity, z2Var2));
                            break;
                        default:
                            int i13 = UserDeviceDetailsActivity.T;
                            if (!userDeviceDetailsActivity.isFinishing()) {
                                AlertDialog alertDialog = userDeviceDetailsActivity.F;
                                if (alertDialog != null) {
                                    alertDialog.dismiss();
                                }
                                AlertDialog.Builder builder = new AlertDialog.Builder(userDeviceDetailsActivity);
                                View inflate = userDeviceDetailsActivity.getLayoutInflater().inflate(2131558527, (ViewGroup) null, false);
                                int i14 = 2131362148;
                                EditText editText = (EditText) ViewBindings.findChildViewById(inflate, 2131362148);
                                if (editText != null) {
                                    i14 = 2131363688;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363688);
                                    if (textView != null) {
                                        i14 = 2131364110;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364110);
                                        if (textView2 != null) {
                                            i14 = 2131364388;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364388);
                                            if (textView3 != null) {
                                                LinearLayout linearLayout = (LinearLayout) inflate;
                                                m8.q qVar = new m8.q(linearLayout, editText, textView, textView2, textView3);
                                                textView3.setTypeface(f4.c.f4882w);
                                                textView2.setTypeface(f4.c.f4882w);
                                                textView2.setOnClickListener(new t(userDeviceDetailsActivity, z2Var2, qVar, 8));
                                                textView.setTypeface(f4.c.f4882w);
                                                textView.setOnClickListener(new dc(userDeviceDetailsActivity, 3));
                                                builder.setView(linearLayout);
                                                userDeviceDetailsActivity.F = builder.create();
                                                if (!userDeviceDetailsActivity.isFinishing() && userDeviceDetailsActivity.F != null) {
                                                    userDeviceDetailsActivity.u0();
                                                    editText.postDelayed(new androidx.work.impl.c(z2Var2, qVar, userDeviceDetailsActivity, 2), 100L);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i14)));
                                break;
                            }
                            break;
                    }
                }
            });
            y0().f9703b.setOnClickListener(new View.OnClickListener(this) { // from class: c4.ec

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ UserDeviceDetailsActivity f1571b;

                {
                    this.f1571b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i11 = i;
                    x4.z2 z2Var2 = z2Var;
                    UserDeviceDetailsActivity userDeviceDetailsActivity = this.f1571b;
                    switch (i11) {
                        case 0:
                            int i12 = UserDeviceDetailsActivity.T;
                            String string = userDeviceDetailsActivity.getString(2131952701);
                            string.getClass();
                            userDeviceDetailsActivity.H(string, new androidx.work.impl.utils.c(7, userDeviceDetailsActivity, z2Var2));
                            break;
                        default:
                            int i13 = UserDeviceDetailsActivity.T;
                            if (!userDeviceDetailsActivity.isFinishing()) {
                                AlertDialog alertDialog = userDeviceDetailsActivity.F;
                                if (alertDialog != null) {
                                    alertDialog.dismiss();
                                }
                                AlertDialog.Builder builder = new AlertDialog.Builder(userDeviceDetailsActivity);
                                View inflate = userDeviceDetailsActivity.getLayoutInflater().inflate(2131558527, (ViewGroup) null, false);
                                int i14 = 2131362148;
                                EditText editText = (EditText) ViewBindings.findChildViewById(inflate, 2131362148);
                                if (editText != null) {
                                    i14 = 2131363688;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363688);
                                    if (textView != null) {
                                        i14 = 2131364110;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364110);
                                        if (textView2 != null) {
                                            i14 = 2131364388;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364388);
                                            if (textView3 != null) {
                                                LinearLayout linearLayout = (LinearLayout) inflate;
                                                m8.q qVar = new m8.q(linearLayout, editText, textView, textView2, textView3);
                                                textView3.setTypeface(f4.c.f4882w);
                                                textView2.setTypeface(f4.c.f4882w);
                                                textView2.setOnClickListener(new t(userDeviceDetailsActivity, z2Var2, qVar, 8));
                                                textView.setTypeface(f4.c.f4882w);
                                                textView.setOnClickListener(new dc(userDeviceDetailsActivity, 3));
                                                builder.setView(linearLayout);
                                                userDeviceDetailsActivity.F = builder.create();
                                                if (!userDeviceDetailsActivity.isFinishing() && userDeviceDetailsActivity.F != null) {
                                                    userDeviceDetailsActivity.u0();
                                                    editText.postDelayed(new androidx.work.impl.c(z2Var2, qVar, userDeviceDetailsActivity, 2), 100L);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i14)));
                                break;
                            }
                            break;
                    }
                }
            });
            y0().f9704l.setOnClickListener(new dc(this, i10));
            y0().f9715x.setText(z2Var.f11483l);
            y0().D.setText(z2Var.f11487p);
            y0().v.setText(z2Var.f11484m);
            y0().B.setText(z2Var.f11485n);
            TextView textView = y0().f9717z;
            long j = z2Var.f11488q;
            textView.setText(j <= 0 ? null : new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault()).format(new Date(j)));
            y0().f9711s.setLayoutManager(new LinearLayoutManager(this, 1, false));
            y0().f9711s.setItemAnimator(new DefaultItemAnimator());
            int dimension = (int) getResources().getDimension(2131166251);
            y0().f9711s.addItemDecoration(new f(dimension, dimension));
            nc z02 = z0();
            z02.getClass();
            a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
            e eVar = m0.f8288a;
            c0.s(viewModelScope, d.f10884a, null, new l(this, z2Var, z02, cVar, 13), 2);
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        p7.c cVar2 = n.f10348a;
        c0.s(lifecycleScope, cVar2, null, new gc(this, cVar, i6), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new gc(this, cVar, i), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new gc(this, cVar, i10), 2);
    }

    public final d1 y0() {
        return (d1) this.O.getValue();
    }

    public final nc z0() {
        return (nc) this.P.getValue();
    }
}
