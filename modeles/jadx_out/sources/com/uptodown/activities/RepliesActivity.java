package com.uptodown.activities;

import a3.d;
import a4.g0;
import a4.l0;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Spanned;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.work.multiprocess.RemoteWorkManager;
import b.n;
import c4.j0;
import c4.j8;
import c4.k0;
import c4.k7;
import c4.mc;
import c4.n8;
import c4.p8;
import c4.q8;
import c4.v8;
import c4.w6;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.util.views.UsernameTextView;
import e4.h0;
import j5.t;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import r7.o0;
import t6.c;
import v7.e;
import x4.k2;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class RepliesActivity extends k0 {
    public static final /* synthetic */ int S = 0;
    public h0 Q;
    public final m O = new m(new w6(this, 3));
    public final ViewModelLazy P = new ViewModelLazy(y.a(v8.class), new q8(this, 0), new p8(this), new q8(this, 1));
    public final d R = new d(this, 14);

    public final void A0() {
        Object systemService = getSystemService("input_method");
        systemService.getClass();
        ((InputMethodManager) systemService).hideSoftInputFromWindow(y0().f10022b.getWindowToken(), 0);
        if (T()) {
            if (y0().f10022b.getText() == null || l7.m.K0(y0().f10022b.getText().toString()).toString().length() <= 0) {
                if (l7.m.K0(y0().f10022b.getText().toString()).toString().length() == 0) {
                    String string = getString(2131951982);
                    string.getClass();
                    A(string);
                    return;
                }
                return;
            }
            String obj = y0().f10022b.getText().toString();
            String y9 = z3.y(this, "last_review_text");
            String y10 = z3.y(this, "last_review_timestamp");
            if (y10 == null) {
                y10 = "0";
            }
            if (obj != null && obj.equalsIgnoreCase(y9) && System.currentTimeMillis() - Long.parseLong(y10) < RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS) {
                y0().f10022b.setText("");
                return;
            }
            Context applicationContext = getApplicationContext();
            applicationContext.getClass();
            String obj2 = y0().f10022b.getText().toString();
            obj2.getClass();
            z3.R(applicationContext, "last_review_text", obj2);
            Context applicationContext2 = getApplicationContext();
            applicationContext2.getClass();
            String valueOf = String.valueOf(System.currentTimeMillis());
            valueOf.getClass();
            z3.R(applicationContext2, "last_review_timestamp", valueOf);
            v8 z02 = z0();
            String obj3 = y0().f10022b.getText().toString();
            Object value = z0().f2220m.getValue();
            value.getClass();
            long j = ((k2) value).f11258a;
            z02.getClass();
            obj3.getClass();
            a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
            e eVar = m0.f8288a;
            c0.s(viewModelScope, v7.d.f10884a, null, new mc(this, obj3, j, z02, (c) null), 2);
        }
    }

    public final void B0() {
        if (isFinishing()) {
            return;
        }
        Intent intent = new Intent(getApplicationContext(), (Class<?>) LoginActivity.class);
        float f = UptodownApp.I;
        startActivity(intent, b4.d.a(this));
    }

    public final void C0(String str) {
        float f = UptodownApp.I;
        if (!b4.d.t() || !T() || str == null || str.length() == 0) {
            return;
        }
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new n(this, str, (c) null, 26), 3);
    }

    public final void D0(final k2 k2Var) {
        CharSequence charSequence;
        boolean b7 = k2Var.b();
        int i = k2Var.f11265q;
        final int i6 = 5;
        final int i10 = 4;
        final int i11 = 3;
        final int i12 = 2;
        final int i13 = 0;
        final int i14 = 1;
        if (!b7) {
            if (i > 0) {
                y0().f10030s.f10058z.setTypeface(f4.c.f4883x);
                if (k2Var.f11265q == 1) {
                    y0().f10030s.f10058z.setText(getString(2131952534));
                } else {
                    y0().f10030s.f10058z.setText(getString(2131952533, String.valueOf(k2Var.f11265q)));
                }
            } else {
                y0().f10030s.f10054u.setVisibility(8);
            }
            y0().f10030s.f10054u.setVisibility(8);
            y0().f10030s.f10053t.setOnClickListener(new View.OnClickListener(this) { // from class: c4.k8

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ RepliesActivity f1795b;

                {
                    this.f1795b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i15 = i11;
                    x4.k2 k2Var2 = k2Var;
                    RepliesActivity repliesActivity = this.f1795b;
                    switch (i15) {
                        case 0:
                            int i16 = RepliesActivity.S;
                            float f = UptodownApp.I;
                            if (b4.d.t()) {
                                RepliesActivity repliesActivity2 = this.f1795b;
                                if (x4.u2.h(repliesActivity2) == null) {
                                    String string = repliesActivity2.getString(2131952183);
                                    string.getClass();
                                    String string2 = repliesActivity2.getString(2131952182);
                                    string2.getClass();
                                    b2.t1.v(repliesActivity2, string, string2);
                                    break;
                                } else {
                                    new e1.v4(repliesActivity2, 1).h(repliesActivity2.y0().f10031t.f10066n);
                                    x4.k2 k2Var3 = k2Var;
                                    if (!j5.t.f6709b.contains(Long.valueOf(k2Var3.f11258a))) {
                                        v8 z02 = repliesActivity2.z0();
                                        z02.getClass();
                                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                                        v7.e eVar = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new b6.g(k2Var3, repliesActivity2, z02, (t6.c) null, 9), 2);
                                        repliesActivity2.y0().f10031t.f10076y.setText(String.valueOf(k2Var3.f11267s + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            int i17 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        case 2:
                            int i18 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        case 3:
                            int i19 = RepliesActivity.S;
                            float f10 = UptodownApp.I;
                            if (b4.d.t()) {
                                RepliesActivity repliesActivity3 = this.f1795b;
                                if (x4.u2.h(repliesActivity3) == null) {
                                    String string3 = repliesActivity3.getString(2131952183);
                                    string3.getClass();
                                    String string4 = repliesActivity3.getString(2131952182);
                                    string4.getClass();
                                    b2.t1.v(repliesActivity3, string3, string4);
                                    break;
                                } else {
                                    new e1.v4(repliesActivity3, 1).h(repliesActivity3.y0().f10030s.f10047n);
                                    x4.k2 k2Var4 = k2Var;
                                    if (!j5.t.f6709b.contains(Long.valueOf(k2Var4.f11258a))) {
                                        v8 z03 = repliesActivity3.z0();
                                        z03.getClass();
                                        o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(z03);
                                        v7.e eVar2 = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope2, v7.d.f10884a, null, new b6.g(k2Var4, repliesActivity3, z03, (t6.c) null, 9), 2);
                                        repliesActivity3.y0().f10030s.f10056x.setText(String.valueOf(k2Var4.f11267s + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4:
                            int i20 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        default:
                            int i21 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                    }
                }
            });
            if (t.f6709b.contains(Long.valueOf(k2Var.f11258a))) {
                y0().f10030s.f10047n.setImageDrawable(ContextCompat.getDrawable(this, 2131231344));
            }
            y0().f10030s.f10056x.setTypeface(f4.c.f4883x);
            y0().f10030s.f10056x.setText(String.valueOf(k2Var.f11267s));
            y0().f10030s.f10048o.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231441));
            y0().f10030s.f10049p.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231439));
            y0().f10030s.f10050q.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231439));
            y0().f10030s.f10051r.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231439));
            y0().f10030s.f10052s.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231439));
            if (k2Var.f11264p >= 2) {
                y0().f10030s.f10049p.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231441));
            }
            if (k2Var.f11264p >= 3) {
                y0().f10030s.f10050q.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231441));
            }
            if (k2Var.f11264p >= 4) {
                y0().f10030s.f10051r.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231441));
            }
            if (k2Var.f11264p == 5) {
                y0().f10030s.f10052s.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231441));
            }
            final w2 h = u2.h(this);
            if (h == null || !l.a(h.f11431a, k2Var.f11259b)) {
                y0().f10030s.f10046m.setVisibility(0);
                if (k2Var.f11271x == 1) {
                    y0().f10030s.f10046m.setImageDrawable(ContextCompat.getDrawable(this, 2131231341));
                } else {
                    y0().f10030s.f10046m.setImageDrawable(ContextCompat.getDrawable(this, 2131231340));
                }
            } else {
                y0().f10030s.f10046m.setVisibility(8);
            }
            y0().f10030s.f10046m.setOnClickListener(new View.OnClickListener() { // from class: c4.l8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i15 = i14;
                    RepliesActivity repliesActivity = this;
                    x4.w2 w2Var = h;
                    switch (i15) {
                        case 0:
                            if (w2Var == null) {
                                int i16 = RepliesActivity.S;
                                repliesActivity.B0();
                                break;
                            } else {
                                repliesActivity.R.D(-1);
                                break;
                            }
                        default:
                            if (w2Var == null) {
                                int i17 = RepliesActivity.S;
                                repliesActivity.B0();
                                break;
                            } else {
                                repliesActivity.R.D(-1);
                                break;
                            }
                    }
                }
            });
            y0().f10030s.B.setTypeface(f4.c.f4882w);
            y0().f10030s.f10055w.setTypeface(f4.c.f4883x);
            y0().f10030s.v.setTypeface(f4.c.f4883x);
            y0().f10030s.f10057y.setTypeface(f4.c.f4883x);
            CharSequence charSequence2 = (CharSequence) z0().f2222o.getValue();
            if (charSequence2 == null || charSequence2.length() == 0) {
                String e10 = u2.e(k2Var.f11261m);
                if (e10 == null || e10.length() == 0) {
                    charSequence = null;
                    l0 f = g0.d().f();
                    float f10 = UptodownApp.I;
                    f.h(b4.d.x(this));
                    f.e(y0().f10030s.f10045l, null);
                } else {
                    l0 e11 = g0.d().e(u2.e(k2Var.f11261m));
                    float f11 = UptodownApp.I;
                    e11.h(b4.d.x(this));
                    charSequence = null;
                    e11.e(y0().f10030s.f10045l, null);
                }
            } else {
                l0 e12 = g0.d().e(u2.e((String) z0().f2222o.getValue()));
                float f12 = UptodownApp.I;
                e12.h(b4.d.x(this));
                charSequence = null;
                e12.e(y0().f10030s.f10045l, null);
            }
            String str = k2Var.f11260l;
            if (str == null || str.length() == 0) {
                CharSequence charSequence3 = (CharSequence) z0().f2219l.getValue();
                if (charSequence3 != null && charSequence3.length() != 0) {
                    y0().f10030s.B.setText((CharSequence) z0().f2219l.getValue());
                    int i15 = UsernameTextView.f3452s;
                    i5.g(y0().f10030s.B, k2Var.b(), k2Var.f11270w);
                }
            } else {
                y0().f10030s.B.setText(k2Var.f11260l);
                int i16 = UsernameTextView.f3452s;
                i5.g(y0().f10030s.B, k2Var.b(), k2Var.f11270w);
            }
            String str2 = k2Var.f11266r;
            if (str2 != null && str2.length() != 0) {
                y0().f10030s.f10055w.setText(k2Var.f11266r);
            }
            String str3 = k2Var.f11263o;
            if (str3 == null || str3.length() == 0) {
                y0().f10030s.v.setVisibility(8);
            } else {
                y0().f10030s.v.setMaxLines(Integer.MAX_VALUE);
                TextView textView = y0().f10030s.v;
                Spanned a8 = k2Var.a();
                textView.setText(a8 != null ? l7.m.K0(a8) : charSequence);
                if (k2Var.f11265q > 0) {
                    y0().f10030s.f10057y.setText(String.valueOf(k2Var.f11265q));
                }
            }
            if (k2Var.f11268t == 1) {
                y0().f10030s.f10044b.setVisibility(0);
            }
            String str4 = k2Var.f11259b;
            if (str4 == null || str4.length() == 0) {
                return;
            }
            y0().f10030s.B.setOnClickListener(new View.OnClickListener(this) { // from class: c4.k8

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ RepliesActivity f1795b;

                {
                    this.f1795b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i152 = i10;
                    x4.k2 k2Var2 = k2Var;
                    RepliesActivity repliesActivity = this.f1795b;
                    switch (i152) {
                        case 0:
                            int i162 = RepliesActivity.S;
                            float f13 = UptodownApp.I;
                            if (b4.d.t()) {
                                RepliesActivity repliesActivity2 = this.f1795b;
                                if (x4.u2.h(repliesActivity2) == null) {
                                    String string = repliesActivity2.getString(2131952183);
                                    string.getClass();
                                    String string2 = repliesActivity2.getString(2131952182);
                                    string2.getClass();
                                    b2.t1.v(repliesActivity2, string, string2);
                                    break;
                                } else {
                                    new e1.v4(repliesActivity2, 1).h(repliesActivity2.y0().f10031t.f10066n);
                                    x4.k2 k2Var3 = k2Var;
                                    if (!j5.t.f6709b.contains(Long.valueOf(k2Var3.f11258a))) {
                                        v8 z02 = repliesActivity2.z0();
                                        z02.getClass();
                                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                                        v7.e eVar = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new b6.g(k2Var3, repliesActivity2, z02, (t6.c) null, 9), 2);
                                        repliesActivity2.y0().f10031t.f10076y.setText(String.valueOf(k2Var3.f11267s + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            int i17 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        case 2:
                            int i18 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        case 3:
                            int i19 = RepliesActivity.S;
                            float f102 = UptodownApp.I;
                            if (b4.d.t()) {
                                RepliesActivity repliesActivity3 = this.f1795b;
                                if (x4.u2.h(repliesActivity3) == null) {
                                    String string3 = repliesActivity3.getString(2131952183);
                                    string3.getClass();
                                    String string4 = repliesActivity3.getString(2131952182);
                                    string4.getClass();
                                    b2.t1.v(repliesActivity3, string3, string4);
                                    break;
                                } else {
                                    new e1.v4(repliesActivity3, 1).h(repliesActivity3.y0().f10030s.f10047n);
                                    x4.k2 k2Var4 = k2Var;
                                    if (!j5.t.f6709b.contains(Long.valueOf(k2Var4.f11258a))) {
                                        v8 z03 = repliesActivity3.z0();
                                        z03.getClass();
                                        o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(z03);
                                        v7.e eVar2 = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope2, v7.d.f10884a, null, new b6.g(k2Var4, repliesActivity3, z03, (t6.c) null, 9), 2);
                                        repliesActivity3.y0().f10030s.f10056x.setText(String.valueOf(k2Var4.f11267s + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4:
                            int i20 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        default:
                            int i21 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                    }
                }
            });
            y0().f10030s.f10045l.setOnClickListener(new View.OnClickListener(this) { // from class: c4.k8

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ RepliesActivity f1795b;

                {
                    this.f1795b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i152 = i6;
                    x4.k2 k2Var2 = k2Var;
                    RepliesActivity repliesActivity = this.f1795b;
                    switch (i152) {
                        case 0:
                            int i162 = RepliesActivity.S;
                            float f13 = UptodownApp.I;
                            if (b4.d.t()) {
                                RepliesActivity repliesActivity2 = this.f1795b;
                                if (x4.u2.h(repliesActivity2) == null) {
                                    String string = repliesActivity2.getString(2131952183);
                                    string.getClass();
                                    String string2 = repliesActivity2.getString(2131952182);
                                    string2.getClass();
                                    b2.t1.v(repliesActivity2, string, string2);
                                    break;
                                } else {
                                    new e1.v4(repliesActivity2, 1).h(repliesActivity2.y0().f10031t.f10066n);
                                    x4.k2 k2Var3 = k2Var;
                                    if (!j5.t.f6709b.contains(Long.valueOf(k2Var3.f11258a))) {
                                        v8 z02 = repliesActivity2.z0();
                                        z02.getClass();
                                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                                        v7.e eVar = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new b6.g(k2Var3, repliesActivity2, z02, (t6.c) null, 9), 2);
                                        repliesActivity2.y0().f10031t.f10076y.setText(String.valueOf(k2Var3.f11267s + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            int i17 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        case 2:
                            int i18 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        case 3:
                            int i19 = RepliesActivity.S;
                            float f102 = UptodownApp.I;
                            if (b4.d.t()) {
                                RepliesActivity repliesActivity3 = this.f1795b;
                                if (x4.u2.h(repliesActivity3) == null) {
                                    String string3 = repliesActivity3.getString(2131952183);
                                    string3.getClass();
                                    String string4 = repliesActivity3.getString(2131952182);
                                    string4.getClass();
                                    b2.t1.v(repliesActivity3, string3, string4);
                                    break;
                                } else {
                                    new e1.v4(repliesActivity3, 1).h(repliesActivity3.y0().f10030s.f10047n);
                                    x4.k2 k2Var4 = k2Var;
                                    if (!j5.t.f6709b.contains(Long.valueOf(k2Var4.f11258a))) {
                                        v8 z03 = repliesActivity3.z0();
                                        z03.getClass();
                                        o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(z03);
                                        v7.e eVar2 = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope2, v7.d.f10884a, null, new b6.g(k2Var4, repliesActivity3, z03, (t6.c) null, 9), 2);
                                        repliesActivity3.y0().f10030s.f10056x.setText(String.valueOf(k2Var4.f11267s + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4:
                            int i20 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        default:
                            int i21 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                    }
                }
            });
            return;
        }
        if (i > 0) {
            y0().f10031t.A.setTypeface(f4.c.f4883x);
            if (k2Var.f11265q == 1) {
                y0().f10031t.A.setText(getString(2131952534));
            } else {
                y0().f10031t.A.setText(getString(2131952533, String.valueOf(k2Var.f11265q)));
            }
        } else {
            y0().f10031t.v.setVisibility(8);
        }
        y0().f10031t.f10073u.setOnClickListener(new View.OnClickListener(this) { // from class: c4.k8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RepliesActivity f1795b;

            {
                this.f1795b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i152 = i13;
                x4.k2 k2Var2 = k2Var;
                RepliesActivity repliesActivity = this.f1795b;
                switch (i152) {
                    case 0:
                        int i162 = RepliesActivity.S;
                        float f13 = UptodownApp.I;
                        if (b4.d.t()) {
                            RepliesActivity repliesActivity2 = this.f1795b;
                            if (x4.u2.h(repliesActivity2) == null) {
                                String string = repliesActivity2.getString(2131952183);
                                string.getClass();
                                String string2 = repliesActivity2.getString(2131952182);
                                string2.getClass();
                                b2.t1.v(repliesActivity2, string, string2);
                                break;
                            } else {
                                new e1.v4(repliesActivity2, 1).h(repliesActivity2.y0().f10031t.f10066n);
                                x4.k2 k2Var3 = k2Var;
                                if (!j5.t.f6709b.contains(Long.valueOf(k2Var3.f11258a))) {
                                    v8 z02 = repliesActivity2.z0();
                                    z02.getClass();
                                    o7.a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                                    v7.e eVar = o7.m0.f8288a;
                                    o7.c0.s(viewModelScope, v7.d.f10884a, null, new b6.g(k2Var3, repliesActivity2, z02, (t6.c) null, 9), 2);
                                    repliesActivity2.y0().f10031t.f10076y.setText(String.valueOf(k2Var3.f11267s + 1));
                                    break;
                                }
                            }
                        }
                        break;
                    case 1:
                        int i17 = RepliesActivity.S;
                        repliesActivity.C0(k2Var2.f11259b);
                        break;
                    case 2:
                        int i18 = RepliesActivity.S;
                        repliesActivity.C0(k2Var2.f11259b);
                        break;
                    case 3:
                        int i19 = RepliesActivity.S;
                        float f102 = UptodownApp.I;
                        if (b4.d.t()) {
                            RepliesActivity repliesActivity3 = this.f1795b;
                            if (x4.u2.h(repliesActivity3) == null) {
                                String string3 = repliesActivity3.getString(2131952183);
                                string3.getClass();
                                String string4 = repliesActivity3.getString(2131952182);
                                string4.getClass();
                                b2.t1.v(repliesActivity3, string3, string4);
                                break;
                            } else {
                                new e1.v4(repliesActivity3, 1).h(repliesActivity3.y0().f10030s.f10047n);
                                x4.k2 k2Var4 = k2Var;
                                if (!j5.t.f6709b.contains(Long.valueOf(k2Var4.f11258a))) {
                                    v8 z03 = repliesActivity3.z0();
                                    z03.getClass();
                                    o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(z03);
                                    v7.e eVar2 = o7.m0.f8288a;
                                    o7.c0.s(viewModelScope2, v7.d.f10884a, null, new b6.g(k2Var4, repliesActivity3, z03, (t6.c) null, 9), 2);
                                    repliesActivity3.y0().f10030s.f10056x.setText(String.valueOf(k2Var4.f11267s + 1));
                                    break;
                                }
                            }
                        }
                        break;
                    case 4:
                        int i20 = RepliesActivity.S;
                        repliesActivity.C0(k2Var2.f11259b);
                        break;
                    default:
                        int i21 = RepliesActivity.S;
                        repliesActivity.C0(k2Var2.f11259b);
                        break;
                }
            }
        });
        if (t.f6709b.contains(Long.valueOf(k2Var.f11258a))) {
            y0().f10031t.f10066n.setImageDrawable(ContextCompat.getDrawable(this, 2131231344));
        }
        y0().f10031t.f10076y.setTypeface(f4.c.f4883x);
        y0().f10031t.f10076y.setText(String.valueOf(k2Var.f11267s));
        y0().f10031t.f10067o.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231442));
        y0().f10031t.f10068p.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231440));
        y0().f10031t.f10069q.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231440));
        y0().f10031t.f10070r.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231440));
        y0().f10031t.f10071s.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231440));
        if (k2Var.f11264p >= 2) {
            y0().f10031t.f10068p.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231442));
        }
        if (k2Var.f11264p >= 3) {
            y0().f10031t.f10069q.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231442));
        }
        if (k2Var.f11264p >= 4) {
            y0().f10031t.f10070r.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231442));
        }
        if (k2Var.f11264p == 5) {
            y0().f10031t.f10071s.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), 2131231442));
        }
        final w2 h6 = u2.h(this);
        if (h6 == null || !l.a(h6.f11431a, k2Var.f11259b)) {
            y0().f10031t.f10065m.setVisibility(0);
            if (k2Var.f11271x == 1) {
                y0().f10031t.f10065m.setImageDrawable(ContextCompat.getDrawable(this, 2131231341));
            } else {
                y0().f10031t.f10065m.setImageDrawable(ContextCompat.getDrawable(this, 2131231340));
            }
        } else {
            y0().f10031t.f10065m.setVisibility(8);
        }
        y0().f10031t.f10065m.setOnClickListener(new View.OnClickListener() { // from class: c4.l8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i152 = i13;
                RepliesActivity repliesActivity = this;
                x4.w2 w2Var = h6;
                switch (i152) {
                    case 0:
                        if (w2Var == null) {
                            int i162 = RepliesActivity.S;
                            repliesActivity.B0();
                            break;
                        } else {
                            repliesActivity.R.D(-1);
                            break;
                        }
                    default:
                        if (w2Var == null) {
                            int i17 = RepliesActivity.S;
                            repliesActivity.B0();
                            break;
                        } else {
                            repliesActivity.R.D(-1);
                            break;
                        }
                }
            }
        });
        y0().f10031t.C.setTypeface(f4.c.f4882w);
        y0().f10031t.f10075x.setTypeface(f4.c.f4883x);
        y0().f10031t.f10074w.setTypeface(f4.c.f4883x);
        y0().f10031t.f10077z.setTypeface(f4.c.f4883x);
        CharSequence charSequence4 = (CharSequence) z0().f2222o.getValue();
        if (charSequence4 == null || charSequence4.length() == 0) {
            String e13 = u2.e(k2Var.f11261m);
            if (e13 == null || e13.length() == 0) {
                l0 f13 = g0.d().f();
                float f14 = UptodownApp.I;
                f13.h(b4.d.x(this));
                f13.e(y0().f10031t.f10064l, null);
            } else {
                l0 e14 = g0.d().e(u2.e(k2Var.f11261m));
                float f15 = UptodownApp.I;
                e14.h(b4.d.x(this));
                e14.e(y0().f10031t.f10064l, null);
            }
        } else {
            l0 e15 = g0.d().e(u2.e((String) z0().f2222o.getValue()));
            float f16 = UptodownApp.I;
            e15.h(b4.d.x(this));
            e15.e(y0().f10031t.f10064l, null);
        }
        String str5 = k2Var.f11260l;
        if (str5 == null || str5.length() == 0) {
            CharSequence charSequence5 = (CharSequence) z0().f2219l.getValue();
            if (charSequence5 != null && charSequence5.length() != 0) {
                y0().f10031t.C.setText((CharSequence) z0().f2219l.getValue());
                int i17 = UsernameTextView.f3452s;
                i5.g(y0().f10031t.C, k2Var.b(), k2Var.f11270w);
            }
        } else {
            y0().f10031t.C.setText(k2Var.f11260l);
            int i18 = UsernameTextView.f3452s;
            i5.g(y0().f10031t.C, k2Var.b(), k2Var.f11270w);
        }
        String str6 = k2Var.f11266r;
        if (str6 != null && str6.length() != 0) {
            y0().f10031t.f10075x.setText(k2Var.f11266r);
        }
        String str7 = k2Var.f11263o;
        if (str7 == null || str7.length() == 0) {
            y0().f10031t.f10074w.setVisibility(8);
        } else {
            y0().f10031t.f10074w.setMaxLines(Integer.MAX_VALUE);
            TextView textView2 = y0().f10031t.f10074w;
            Spanned a10 = k2Var.a();
            textView2.setText(a10 != null ? l7.m.K0(a10) : null);
            if (k2Var.f11265q > 1) {
                y0().f10031t.f10077z.setText(String.valueOf(k2Var.f11265q));
            }
        }
        if (k2Var.f11268t == 1) {
            y0().f10031t.f10063b.setVisibility(0);
        }
        String str8 = k2Var.f11259b;
        if (str8 != null && str8.length() != 0) {
            y0().f10031t.C.setOnClickListener(new View.OnClickListener(this) { // from class: c4.k8

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ RepliesActivity f1795b;

                {
                    this.f1795b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i152 = i14;
                    x4.k2 k2Var2 = k2Var;
                    RepliesActivity repliesActivity = this.f1795b;
                    switch (i152) {
                        case 0:
                            int i162 = RepliesActivity.S;
                            float f132 = UptodownApp.I;
                            if (b4.d.t()) {
                                RepliesActivity repliesActivity2 = this.f1795b;
                                if (x4.u2.h(repliesActivity2) == null) {
                                    String string = repliesActivity2.getString(2131952183);
                                    string.getClass();
                                    String string2 = repliesActivity2.getString(2131952182);
                                    string2.getClass();
                                    b2.t1.v(repliesActivity2, string, string2);
                                    break;
                                } else {
                                    new e1.v4(repliesActivity2, 1).h(repliesActivity2.y0().f10031t.f10066n);
                                    x4.k2 k2Var3 = k2Var;
                                    if (!j5.t.f6709b.contains(Long.valueOf(k2Var3.f11258a))) {
                                        v8 z02 = repliesActivity2.z0();
                                        z02.getClass();
                                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                                        v7.e eVar = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new b6.g(k2Var3, repliesActivity2, z02, (t6.c) null, 9), 2);
                                        repliesActivity2.y0().f10031t.f10076y.setText(String.valueOf(k2Var3.f11267s + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            int i172 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        case 2:
                            int i182 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        case 3:
                            int i19 = RepliesActivity.S;
                            float f102 = UptodownApp.I;
                            if (b4.d.t()) {
                                RepliesActivity repliesActivity3 = this.f1795b;
                                if (x4.u2.h(repliesActivity3) == null) {
                                    String string3 = repliesActivity3.getString(2131952183);
                                    string3.getClass();
                                    String string4 = repliesActivity3.getString(2131952182);
                                    string4.getClass();
                                    b2.t1.v(repliesActivity3, string3, string4);
                                    break;
                                } else {
                                    new e1.v4(repliesActivity3, 1).h(repliesActivity3.y0().f10030s.f10047n);
                                    x4.k2 k2Var4 = k2Var;
                                    if (!j5.t.f6709b.contains(Long.valueOf(k2Var4.f11258a))) {
                                        v8 z03 = repliesActivity3.z0();
                                        z03.getClass();
                                        o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(z03);
                                        v7.e eVar2 = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope2, v7.d.f10884a, null, new b6.g(k2Var4, repliesActivity3, z03, (t6.c) null, 9), 2);
                                        repliesActivity3.y0().f10030s.f10056x.setText(String.valueOf(k2Var4.f11267s + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4:
                            int i20 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        default:
                            int i21 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                    }
                }
            });
            y0().f10031t.f10064l.setOnClickListener(new View.OnClickListener(this) { // from class: c4.k8

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ RepliesActivity f1795b;

                {
                    this.f1795b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i152 = i12;
                    x4.k2 k2Var2 = k2Var;
                    RepliesActivity repliesActivity = this.f1795b;
                    switch (i152) {
                        case 0:
                            int i162 = RepliesActivity.S;
                            float f132 = UptodownApp.I;
                            if (b4.d.t()) {
                                RepliesActivity repliesActivity2 = this.f1795b;
                                if (x4.u2.h(repliesActivity2) == null) {
                                    String string = repliesActivity2.getString(2131952183);
                                    string.getClass();
                                    String string2 = repliesActivity2.getString(2131952182);
                                    string2.getClass();
                                    b2.t1.v(repliesActivity2, string, string2);
                                    break;
                                } else {
                                    new e1.v4(repliesActivity2, 1).h(repliesActivity2.y0().f10031t.f10066n);
                                    x4.k2 k2Var3 = k2Var;
                                    if (!j5.t.f6709b.contains(Long.valueOf(k2Var3.f11258a))) {
                                        v8 z02 = repliesActivity2.z0();
                                        z02.getClass();
                                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                                        v7.e eVar = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new b6.g(k2Var3, repliesActivity2, z02, (t6.c) null, 9), 2);
                                        repliesActivity2.y0().f10031t.f10076y.setText(String.valueOf(k2Var3.f11267s + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            int i172 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        case 2:
                            int i182 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        case 3:
                            int i19 = RepliesActivity.S;
                            float f102 = UptodownApp.I;
                            if (b4.d.t()) {
                                RepliesActivity repliesActivity3 = this.f1795b;
                                if (x4.u2.h(repliesActivity3) == null) {
                                    String string3 = repliesActivity3.getString(2131952183);
                                    string3.getClass();
                                    String string4 = repliesActivity3.getString(2131952182);
                                    string4.getClass();
                                    b2.t1.v(repliesActivity3, string3, string4);
                                    break;
                                } else {
                                    new e1.v4(repliesActivity3, 1).h(repliesActivity3.y0().f10030s.f10047n);
                                    x4.k2 k2Var4 = k2Var;
                                    if (!j5.t.f6709b.contains(Long.valueOf(k2Var4.f11258a))) {
                                        v8 z03 = repliesActivity3.z0();
                                        z03.getClass();
                                        o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(z03);
                                        v7.e eVar2 = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope2, v7.d.f10884a, null, new b6.g(k2Var4, repliesActivity3, z03, (t6.c) null, 9), 2);
                                        repliesActivity3.y0().f10030s.f10056x.setText(String.valueOf(k2Var4.f11267s + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4:
                            int i20 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                        default:
                            int i21 = RepliesActivity.S;
                            repliesActivity.C0(k2Var2.f11259b);
                            break;
                    }
                }
            });
        }
        y0().f10031t.f10072t.setOnClickListener(new j8(this, i10));
        y0().f10031t.f10072t.setVisibility(0);
        ImageView imageView = y0().f10031t.f10064l;
        int dimension = (int) imageView.getContext().getResources().getDimension(2131165270);
        imageView.setForeground(ContextCompat.getDrawable(imageView.getContext(), 2131231271));
        imageView.setPadding(dimension, dimension, dimension, dimension);
        y0().f10031t.f10062a.setVisibility(0);
        y0().f10030s.f10043a.setVisibility(8);
    }

    public final void E0() {
        w2 h = u2.h(this);
        if ((h != null ? h.f11433l : null) == null) {
            y0().f10025n.setImageDrawable(ContextCompat.getDrawable(this, 2131231479));
            return;
        }
        l0 e10 = g0.d().e(u2.e(h.f11433l));
        float f = UptodownApp.I;
        e10.g(b4.d.f(this));
        e10.h(b4.d.x(this));
        e10.e(y0().f10025n, null);
        if (h.d()) {
            ImageView imageView = y0().f10025n;
            int dimension = (int) imageView.getContext().getResources().getDimension(2131165270);
            imageView.setForeground(ContextCompat.getDrawable(imageView.getContext(), 2131231273));
            imageView.setPadding(dimension, dimension, dimension, dimension);
        }
    }

    public final void F0() {
        w2 h = u2.h(this);
        if ((h != null ? h.f11431a : null) != null) {
            String str = h.f11431a;
            str.getClass();
            if (str.length() > 0) {
                y0().f10028q.setVisibility(8);
                return;
            }
        }
        y0().f10028q.setVisibility(0);
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f10021a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Intent intent = getIntent();
        c cVar = null;
        if (intent != null && (extras = intent.getExtras()) != null) {
            if (extras.containsKey("review")) {
                z0().f2220m.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("review", k2.class) : extras.getParcelable("review"));
            }
            if (extras.containsKey("appName")) {
                z0().f2218k.f(extras.getString("appName"));
            }
            if (extras.containsKey("username")) {
                z0().f2219l.f(extras.getString("username"));
            }
            if (extras.containsKey("appIconUrl")) {
                z0().f2221n.f(extras.getString("appIconUrl"));
            }
            if (extras.containsKey("userAvatarUrl")) {
                z0().f2222o.f(extras.getString("userAvatarUrl"));
            }
            if (extras.containsKey("appId")) {
                o0 o0Var = z0().f2223p;
                Long valueOf = Long.valueOf(extras.getLong("appId"));
                o0Var.getClass();
                o0Var.g(null, valueOf);
            }
            if (extras.containsKey("appUrl")) {
                z0().f2224q.f(extras.getString("appUrl"));
            }
        }
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            y0().f10033w.setNavigationIcon(drawable);
            y0().f10033w.setNavigationContentDescription(getString(2131951735));
        }
        int i = 0;
        y0().f10033w.setNavigationOnClickListener(new j8(this, i));
        y0().A.setTypeface(f4.c.f4882w);
        y0().f10034x.setTypeface(f4.c.f4883x);
        y0().f10035y.setTypeface(f4.c.f4882w);
        y0().f10035y.setText((CharSequence) z0().f2218k.getValue());
        l0 e10 = g0.d().e((String) z0().f2221n.getValue());
        float f = UptodownApp.I;
        e10.g(b4.d.f(this));
        e10.h(b4.d.x(this));
        e10.e(y0().f10023l, null);
        y0().f10026o.setVisibility(0);
        int i6 = 1;
        y0().f10026o.setOnClickListener(new j8(this, i6));
        y0().f10036z.setTypeface(f4.c.f4883x);
        E0();
        int i10 = 2;
        y0().f10024m.setOnClickListener(new j8(this, i10));
        int i11 = 3;
        y0().f10028q.setOnClickListener(new j8(this, i11));
        y0().f10022b.setTypeface(f4.c.f4883x);
        y0().f10022b.setOnEditorActionListener(new c4.k2(this, i6));
        F0();
        y0().v.setLayoutManager(new LinearLayoutManager(this, 1, false));
        y0().v.setItemAnimator(new DefaultItemAnimator());
        y0().f10029r.getViewTreeObserver().addOnScrollChangedListener(new k7(this, i6));
        ViewCompat.setOnApplyWindowInsetsListener(y0().f10021a, new a(this, 9));
        if (z0().f2220m.getValue() != null) {
            Object value = z0().f2220m.getValue();
            value.getClass();
            long j = ((k2) value).f11258a;
            v8 z02 = z0();
            z02.getClass();
            a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
            e eVar = m0.f8288a;
            c0.s(viewModelScope, v7.d.f10884a, null, new j0(z02, this, j, null), 2);
            Object value2 = z0().f2220m.getValue();
            value2.getClass();
            D0((k2) value2);
        } else {
            finish();
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        p7.c cVar2 = t7.n.f10348a;
        c0.s(lifecycleScope, cVar2, null, new n8(this, cVar, i), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new n8(this, cVar, i6), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new n8(this, cVar, i10), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new n8(this, cVar, i11), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new n8(this, cVar, 4), 2);
    }

    @Override // c4.k0, g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        F0();
        E0();
    }

    public final t4.o0 y0() {
        return (t4.o0) this.O.getValue();
    }

    public final v8 z0() {
        return (v8) this.P.getValue();
    }
}
