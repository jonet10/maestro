package com.uptodown.activities;

import a4.g0;
import a4.l0;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import b5.l;
import b6.a;
import c4.a9;
import c4.b9;
import c4.c9;
import c4.g9;
import c4.k0;
import c4.w6;
import c4.y8;
import com.uptodown.UptodownApp;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.ReviewsActivity;
import e4.i0;
import f0.i;
import kotlin.jvm.internal.y;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import r7.o0;
import t4.r0;
import t6.c;
import t7.n;
import v7.d;
import v7.e;
import x4.g;
import x4.k2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ReviewsActivity extends k0 {
    public static final /* synthetic */ int T = 0;
    public i0 Q;
    public final ActivityResultLauncher S;
    public final m O = new m(new w6(this, 4));
    public final ViewModelLazy P = new ViewModelLazy(y.a(g9.class), new c9(this, 0), new b9(this), new c9(this, 1));
    public final i R = new i(this, 13);

    public ReviewsActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new y8(this));
        registerForActivityResult.getClass();
        this.S = registerForActivityResult;
    }

    public final g9 A0() {
        return (g9) this.P.getValue();
    }

    public final void B0() {
        y0().v.setAdapter(null);
        this.Q = null;
        A0().f1642m = true;
        A0().f1644o = 0;
        z0();
    }

    public final void C0(String str) {
        int intValue = ((Number) A0().f1641l.getValue()).intValue();
        if (1 > intValue || intValue >= 6) {
            String string = getString(2131952006);
            string.getClass();
            A(string);
        } else {
            g9 A0 = A0();
            A0.getClass();
            a0 viewModelScope = ViewModelKt.getViewModelScope(A0);
            e eVar = m0.f8288a;
            c0.s(viewModelScope, d.f10884a, null, new l(this, str, A0, (c) null, 11), 2);
        }
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f10087a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Intent intent = getIntent();
        c cVar = null;
        if (intent != null && (extras = intent.getExtras()) != null) {
            if (extras.containsKey("appInfo")) {
                o0 o0Var = A0().i;
                Parcelable parcelable = Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appInfo", g.class) : extras.getParcelable("appInfo");
                parcelable.getClass();
                o0Var.getClass();
                o0Var.g(null, parcelable);
            }
            if (extras.containsKey("myReview")) {
                A0().j.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("myReview", k2.class) : extras.getParcelable("myReview"));
                if (A0().j.getValue() != null) {
                    o0 o0Var2 = A0().f1641l;
                    Object value = A0().j.getValue();
                    value.getClass();
                    Integer valueOf = Integer.valueOf(((k2) value).f11264p);
                    o0Var2.getClass();
                    o0Var2.g(null, valueOf);
                }
            }
        }
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            y0().f10099w.setNavigationIcon(drawable);
            y0().f10099w.setNavigationContentDescription(getString(2131951735));
        }
        final int i = 3;
        y0().f10099w.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: c4.x8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ReviewsActivity f2311b;

            {
                this.f2311b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i6 = i;
                ReviewsActivity reviewsActivity = this.f2311b;
                switch (i6) {
                    case 0:
                        int i10 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "date")) {
                            r7.o0 o0Var3 = reviewsActivity.A0().f1640k;
                            o0Var3.getClass();
                            o0Var3.g(null, "date");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().C);
                            reviewsActivity.y0().B.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().B.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().D.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().D.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 1:
                        int i11 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "best")) {
                            r7.o0 o0Var4 = reviewsActivity.A0().f1640k;
                            o0Var4.getClass();
                            o0Var4.g(null, "best");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().B);
                            reviewsActivity.y0().C.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().C.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().D.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().D.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 2:
                        int i12 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "most")) {
                            r7.o0 o0Var5 = reviewsActivity.A0().f1640k;
                            o0Var5.getClass();
                            o0Var5.g(null, "most");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().D);
                            reviewsActivity.y0().B.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().B.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().C.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().C.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 3:
                        int i13 = ReviewsActivity.T;
                        reviewsActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        int i14 = ReviewsActivity.T;
                        Object systemService = reviewsActivity.getSystemService("input_method");
                        systemService.getClass();
                        ((InputMethodManager) systemService).hideSoftInputFromWindow(reviewsActivity.y0().f10088b.getWindowToken(), 0);
                        reviewsActivity.y0().f10088b.clearFocus();
                        x4.w2 h = x4.u2.h(reviewsActivity);
                        String str = h != null ? h.f11431a : null;
                        if (str != null && str.length() != 0) {
                            Editable text = reviewsActivity.y0().f10088b.getText();
                            text.getClass();
                            reviewsActivity.C0(l7.m.K0(text).toString());
                            break;
                        } else {
                            Intent intent2 = new Intent(reviewsActivity, (Class<?>) LoginActivity.class);
                            ActivityResultLauncher activityResultLauncher = reviewsActivity.S;
                            float f = UptodownApp.I;
                            activityResultLauncher.launch(intent2, b4.d.b(reviewsActivity));
                            break;
                        }
                        break;
                }
            }
        });
        g0 d10 = g0.d();
        g gVar = (g) A0().i.getValue();
        l0 e10 = d10.e(gVar != null ? gVar.i() : null);
        float f = UptodownApp.I;
        e10.g(b4.d.f(this));
        e10.h(b4.d.x(this));
        e10.e(y0().f10089l, null);
        y0().E.setTypeface(f4.c.f4882w);
        y0().f10101y.setTypeface(f4.c.f4882w);
        TextView textView = y0().f10101y;
        g gVar2 = (g) A0().i.getValue();
        textView.setText(gVar2 != null ? gVar2.f11159b : null);
        y0().f10102z.setTypeface(f4.c.f4883x);
        TextView textView2 = y0().f10102z;
        g gVar3 = (g) A0().i.getValue();
        textView2.setText(gVar3 != null ? gVar3.f11170l : null);
        y0().f10100x.setTypeface(f4.c.f4883x);
        TextView textView3 = y0().f10100x;
        g gVar4 = (g) A0().i.getValue();
        textView3.setText(gVar4 != null ? gVar4.f11190w : null);
        y0().A.setTypeface(f4.c.f4883x);
        y0().f10088b.setTypeface(f4.c.f4883x);
        final int i6 = 4;
        y0().f10090m.setOnClickListener(new View.OnClickListener(this) { // from class: c4.x8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ReviewsActivity f2311b;

            {
                this.f2311b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i6;
                ReviewsActivity reviewsActivity = this.f2311b;
                switch (i62) {
                    case 0:
                        int i10 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "date")) {
                            r7.o0 o0Var3 = reviewsActivity.A0().f1640k;
                            o0Var3.getClass();
                            o0Var3.g(null, "date");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().C);
                            reviewsActivity.y0().B.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().B.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().D.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().D.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 1:
                        int i11 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "best")) {
                            r7.o0 o0Var4 = reviewsActivity.A0().f1640k;
                            o0Var4.getClass();
                            o0Var4.g(null, "best");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().B);
                            reviewsActivity.y0().C.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().C.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().D.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().D.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 2:
                        int i12 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "most")) {
                            r7.o0 o0Var5 = reviewsActivity.A0().f1640k;
                            o0Var5.getClass();
                            o0Var5.g(null, "most");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().D);
                            reviewsActivity.y0().B.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().B.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().C.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().C.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 3:
                        int i13 = ReviewsActivity.T;
                        reviewsActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        int i14 = ReviewsActivity.T;
                        Object systemService = reviewsActivity.getSystemService("input_method");
                        systemService.getClass();
                        ((InputMethodManager) systemService).hideSoftInputFromWindow(reviewsActivity.y0().f10088b.getWindowToken(), 0);
                        reviewsActivity.y0().f10088b.clearFocus();
                        x4.w2 h = x4.u2.h(reviewsActivity);
                        String str = h != null ? h.f11431a : null;
                        if (str != null && str.length() != 0) {
                            Editable text = reviewsActivity.y0().f10088b.getText();
                            text.getClass();
                            reviewsActivity.C0(l7.m.K0(text).toString());
                            break;
                        } else {
                            Intent intent2 = new Intent(reviewsActivity, (Class<?>) LoginActivity.class);
                            ActivityResultLauncher activityResultLauncher = reviewsActivity.S;
                            float f10 = UptodownApp.I;
                            activityResultLauncher.launch(intent2, b4.d.b(reviewsActivity));
                            break;
                        }
                        break;
                }
            }
        });
        final Drawable drawable2 = ContextCompat.getDrawable(this, 2131231441);
        final Drawable drawable3 = ContextCompat.getDrawable(this, 2131231439);
        final int i10 = 1;
        final int i11 = 2;
        if (A0().j.getValue() != null) {
            Object value2 = A0().j.getValue();
            value2.getClass();
            if (((k2) value2).f11264p >= 1) {
                y0().f10091n.setImageDrawable(drawable2);
            }
            Object value3 = A0().j.getValue();
            value3.getClass();
            if (((k2) value3).f11264p >= 2) {
                y0().f10092o.setImageDrawable(drawable2);
            }
            Object value4 = A0().j.getValue();
            value4.getClass();
            if (((k2) value4).f11264p >= 3) {
                y0().f10093p.setImageDrawable(drawable2);
            }
            Object value5 = A0().j.getValue();
            value5.getClass();
            if (((k2) value5).f11264p >= 4) {
                y0().f10094q.setImageDrawable(drawable2);
            }
            Object value6 = A0().j.getValue();
            value6.getClass();
            if (((k2) value6).f11264p == 5) {
                y0().f10095r.setImageDrawable(drawable2);
            }
            Object value7 = A0().j.getValue();
            value7.getClass();
            String str = ((k2) value7).f11263o;
            if (str != null && str.length() != 0) {
                EditText editText = y0().f10088b;
                Object value8 = A0().j.getValue();
                value8.getClass();
                editText.setText(String.valueOf(((k2) value8).f11263o));
            }
        }
        y0().f10091n.setOnClickListener(new View.OnClickListener(this) { // from class: c4.w8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ReviewsActivity f2271b;

            {
                this.f2271b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i12 = i10;
                Drawable drawable4 = drawable3;
                Drawable drawable5 = drawable2;
                ReviewsActivity reviewsActivity = this.f2271b;
                switch (i12) {
                    case 0:
                        int i13 = ReviewsActivity.T;
                        float f10 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var3 = reviewsActivity.A0().f1641l;
                            o0Var3.getClass();
                            o0Var3.g(null, 4);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                    case 1:
                        int i14 = ReviewsActivity.T;
                        float f11 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var4 = reviewsActivity.A0().f1641l;
                            o0Var4.getClass();
                            o0Var4.g(null, 1);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                    case 2:
                        int i15 = ReviewsActivity.T;
                        float f12 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var5 = reviewsActivity.A0().f1641l;
                            o0Var5.getClass();
                            o0Var5.g(null, 2);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                    default:
                        int i16 = ReviewsActivity.T;
                        float f13 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var6 = reviewsActivity.A0().f1641l;
                            o0Var6.getClass();
                            o0Var6.g(null, 3);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                }
            }
        });
        y0().f10092o.setOnClickListener(new View.OnClickListener(this) { // from class: c4.w8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ReviewsActivity f2271b;

            {
                this.f2271b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i12 = i11;
                Drawable drawable4 = drawable3;
                Drawable drawable5 = drawable2;
                ReviewsActivity reviewsActivity = this.f2271b;
                switch (i12) {
                    case 0:
                        int i13 = ReviewsActivity.T;
                        float f10 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var3 = reviewsActivity.A0().f1641l;
                            o0Var3.getClass();
                            o0Var3.g(null, 4);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                    case 1:
                        int i14 = ReviewsActivity.T;
                        float f11 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var4 = reviewsActivity.A0().f1641l;
                            o0Var4.getClass();
                            o0Var4.g(null, 1);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                    case 2:
                        int i15 = ReviewsActivity.T;
                        float f12 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var5 = reviewsActivity.A0().f1641l;
                            o0Var5.getClass();
                            o0Var5.g(null, 2);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                    default:
                        int i16 = ReviewsActivity.T;
                        float f13 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var6 = reviewsActivity.A0().f1641l;
                            o0Var6.getClass();
                            o0Var6.g(null, 3);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                }
            }
        });
        y0().f10093p.setOnClickListener(new View.OnClickListener(this) { // from class: c4.w8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ReviewsActivity f2271b;

            {
                this.f2271b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i12 = i;
                Drawable drawable4 = drawable3;
                Drawable drawable5 = drawable2;
                ReviewsActivity reviewsActivity = this.f2271b;
                switch (i12) {
                    case 0:
                        int i13 = ReviewsActivity.T;
                        float f10 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var3 = reviewsActivity.A0().f1641l;
                            o0Var3.getClass();
                            o0Var3.g(null, 4);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                    case 1:
                        int i14 = ReviewsActivity.T;
                        float f11 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var4 = reviewsActivity.A0().f1641l;
                            o0Var4.getClass();
                            o0Var4.g(null, 1);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                    case 2:
                        int i15 = ReviewsActivity.T;
                        float f12 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var5 = reviewsActivity.A0().f1641l;
                            o0Var5.getClass();
                            o0Var5.g(null, 2);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                    default:
                        int i16 = ReviewsActivity.T;
                        float f13 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var6 = reviewsActivity.A0().f1641l;
                            o0Var6.getClass();
                            o0Var6.g(null, 3);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                }
            }
        });
        final int i12 = 0;
        y0().f10094q.setOnClickListener(new View.OnClickListener(this) { // from class: c4.w8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ReviewsActivity f2271b;

            {
                this.f2271b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i122 = i12;
                Drawable drawable4 = drawable3;
                Drawable drawable5 = drawable2;
                ReviewsActivity reviewsActivity = this.f2271b;
                switch (i122) {
                    case 0:
                        int i13 = ReviewsActivity.T;
                        float f10 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var3 = reviewsActivity.A0().f1641l;
                            o0Var3.getClass();
                            o0Var3.g(null, 4);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                    case 1:
                        int i14 = ReviewsActivity.T;
                        float f11 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var4 = reviewsActivity.A0().f1641l;
                            o0Var4.getClass();
                            o0Var4.g(null, 1);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                    case 2:
                        int i15 = ReviewsActivity.T;
                        float f12 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var5 = reviewsActivity.A0().f1641l;
                            o0Var5.getClass();
                            o0Var5.g(null, 2);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                    default:
                        int i16 = ReviewsActivity.T;
                        float f13 = UptodownApp.I;
                        if (b4.d.t()) {
                            r7.o0 o0Var6 = reviewsActivity.A0().f1641l;
                            o0Var6.getClass();
                            o0Var6.g(null, 3);
                            reviewsActivity.y0().f10091n.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10092o.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10093p.setImageDrawable(drawable5);
                            reviewsActivity.y0().f10094q.setImageDrawable(drawable4);
                            reviewsActivity.y0().f10095r.setImageDrawable(drawable4);
                            break;
                        }
                        break;
                }
            }
        });
        y0().f10095r.setOnClickListener(new c.e(17, this, drawable2));
        y0().C.setTypeface(f4.c.f4882w);
        y0().C.setOnClickListener(new View.OnClickListener(this) { // from class: c4.x8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ReviewsActivity f2311b;

            {
                this.f2311b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i12;
                ReviewsActivity reviewsActivity = this.f2311b;
                switch (i62) {
                    case 0:
                        int i102 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "date")) {
                            r7.o0 o0Var3 = reviewsActivity.A0().f1640k;
                            o0Var3.getClass();
                            o0Var3.g(null, "date");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().C);
                            reviewsActivity.y0().B.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().B.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().D.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().D.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 1:
                        int i112 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "best")) {
                            r7.o0 o0Var4 = reviewsActivity.A0().f1640k;
                            o0Var4.getClass();
                            o0Var4.g(null, "best");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().B);
                            reviewsActivity.y0().C.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().C.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().D.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().D.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 2:
                        int i122 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "most")) {
                            r7.o0 o0Var5 = reviewsActivity.A0().f1640k;
                            o0Var5.getClass();
                            o0Var5.g(null, "most");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().D);
                            reviewsActivity.y0().B.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().B.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().C.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().C.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 3:
                        int i13 = ReviewsActivity.T;
                        reviewsActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        int i14 = ReviewsActivity.T;
                        Object systemService = reviewsActivity.getSystemService("input_method");
                        systemService.getClass();
                        ((InputMethodManager) systemService).hideSoftInputFromWindow(reviewsActivity.y0().f10088b.getWindowToken(), 0);
                        reviewsActivity.y0().f10088b.clearFocus();
                        x4.w2 h = x4.u2.h(reviewsActivity);
                        String str2 = h != null ? h.f11431a : null;
                        if (str2 != null && str2.length() != 0) {
                            Editable text = reviewsActivity.y0().f10088b.getText();
                            text.getClass();
                            reviewsActivity.C0(l7.m.K0(text).toString());
                            break;
                        } else {
                            Intent intent2 = new Intent(reviewsActivity, (Class<?>) LoginActivity.class);
                            ActivityResultLauncher activityResultLauncher = reviewsActivity.S;
                            float f10 = UptodownApp.I;
                            activityResultLauncher.launch(intent2, b4.d.b(reviewsActivity));
                            break;
                        }
                        break;
                }
            }
        });
        y0().B.setTypeface(f4.c.f4882w);
        y0().B.setOnClickListener(new View.OnClickListener(this) { // from class: c4.x8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ReviewsActivity f2311b;

            {
                this.f2311b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i10;
                ReviewsActivity reviewsActivity = this.f2311b;
                switch (i62) {
                    case 0:
                        int i102 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "date")) {
                            r7.o0 o0Var3 = reviewsActivity.A0().f1640k;
                            o0Var3.getClass();
                            o0Var3.g(null, "date");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().C);
                            reviewsActivity.y0().B.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().B.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().D.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().D.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 1:
                        int i112 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "best")) {
                            r7.o0 o0Var4 = reviewsActivity.A0().f1640k;
                            o0Var4.getClass();
                            o0Var4.g(null, "best");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().B);
                            reviewsActivity.y0().C.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().C.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().D.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().D.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 2:
                        int i122 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "most")) {
                            r7.o0 o0Var5 = reviewsActivity.A0().f1640k;
                            o0Var5.getClass();
                            o0Var5.g(null, "most");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().D);
                            reviewsActivity.y0().B.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().B.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().C.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().C.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 3:
                        int i13 = ReviewsActivity.T;
                        reviewsActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        int i14 = ReviewsActivity.T;
                        Object systemService = reviewsActivity.getSystemService("input_method");
                        systemService.getClass();
                        ((InputMethodManager) systemService).hideSoftInputFromWindow(reviewsActivity.y0().f10088b.getWindowToken(), 0);
                        reviewsActivity.y0().f10088b.clearFocus();
                        x4.w2 h = x4.u2.h(reviewsActivity);
                        String str2 = h != null ? h.f11431a : null;
                        if (str2 != null && str2.length() != 0) {
                            Editable text = reviewsActivity.y0().f10088b.getText();
                            text.getClass();
                            reviewsActivity.C0(l7.m.K0(text).toString());
                            break;
                        } else {
                            Intent intent2 = new Intent(reviewsActivity, (Class<?>) LoginActivity.class);
                            ActivityResultLauncher activityResultLauncher = reviewsActivity.S;
                            float f10 = UptodownApp.I;
                            activityResultLauncher.launch(intent2, b4.d.b(reviewsActivity));
                            break;
                        }
                        break;
                }
            }
        });
        y0().D.setTypeface(f4.c.f4882w);
        y0().D.setOnClickListener(new View.OnClickListener(this) { // from class: c4.x8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ReviewsActivity f2311b;

            {
                this.f2311b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i11;
                ReviewsActivity reviewsActivity = this.f2311b;
                switch (i62) {
                    case 0:
                        int i102 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "date")) {
                            r7.o0 o0Var3 = reviewsActivity.A0().f1640k;
                            o0Var3.getClass();
                            o0Var3.g(null, "date");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().C);
                            reviewsActivity.y0().B.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().B.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().D.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().D.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 1:
                        int i112 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "best")) {
                            r7.o0 o0Var4 = reviewsActivity.A0().f1640k;
                            o0Var4.getClass();
                            o0Var4.g(null, "best");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().B);
                            reviewsActivity.y0().C.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().C.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().D.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().D.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 2:
                        int i122 = ReviewsActivity.T;
                        if (!kotlin.jvm.internal.l.a(reviewsActivity.A0().f1640k.getValue(), "most")) {
                            r7.o0 o0Var5 = reviewsActivity.A0().f1640k;
                            o0Var5.getClass();
                            o0Var5.g(null, "most");
                            com.google.android.gms.internal.measurement.z3.J(reviewsActivity.y0().D);
                            reviewsActivity.y0().B.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().B.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.y0().C.setBackground(ContextCompat.getDrawable(reviewsActivity, 2131231153));
                            reviewsActivity.y0().C.setTextColor(ContextCompat.getColorStateList(reviewsActivity, 2131100765));
                            reviewsActivity.B0();
                            break;
                        }
                        break;
                    case 3:
                        int i13 = ReviewsActivity.T;
                        reviewsActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        int i14 = ReviewsActivity.T;
                        Object systemService = reviewsActivity.getSystemService("input_method");
                        systemService.getClass();
                        ((InputMethodManager) systemService).hideSoftInputFromWindow(reviewsActivity.y0().f10088b.getWindowToken(), 0);
                        reviewsActivity.y0().f10088b.clearFocus();
                        x4.w2 h = x4.u2.h(reviewsActivity);
                        String str2 = h != null ? h.f11431a : null;
                        if (str2 != null && str2.length() != 0) {
                            Editable text = reviewsActivity.y0().f10088b.getText();
                            text.getClass();
                            reviewsActivity.C0(l7.m.K0(text).toString());
                            break;
                        } else {
                            Intent intent2 = new Intent(reviewsActivity, (Class<?>) LoginActivity.class);
                            ActivityResultLauncher activityResultLauncher = reviewsActivity.S;
                            float f10 = UptodownApp.I;
                            activityResultLauncher.launch(intent2, b4.d.b(reviewsActivity));
                            break;
                        }
                        break;
                }
            }
        });
        y0().v.setLayoutManager(new LinearLayoutManager(this, 1, false));
        int dimension = (int) getResources().getDimension(2131166251);
        y0().v.addItemDecoration(new l5.i(dimension, dimension, dimension, dimension));
        y0().f10098u.setOnScrollChangeListener(new y8(this));
        y0().f10097t.setOnClickListener(new c4.e(19));
        ViewCompat.setOnApplyWindowInsetsListener(y0().f10087a, new y8(this));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        p7.c cVar2 = n.f10348a;
        c0.s(lifecycleScope, cVar2, null, new a9(this, cVar, i12), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new a9(this, cVar, i10), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new a9(this, cVar, i11), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new a9(this, cVar, i), 2);
        z0();
    }

    public final r0 y0() {
        return (r0) this.O.getValue();
    }

    public final void z0() {
        if (A0().f1642m) {
            g9 A0 = A0();
            A0.getClass();
            a0 viewModelScope = ViewModelKt.getViewModelScope(A0);
            e eVar = m0.f8288a;
            c0.s(viewModelScope, d.f10884a, null, new a(A0, this, null, 25), 2);
        }
    }
}
