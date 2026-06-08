package com.uptodown.activities;

import a4.g0;
import a4.l0;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.viewbinding.ViewBindings;
import b.s;
import b4.d;
import c4.jd;
import c4.k0;
import c4.ld;
import c4.md;
import c4.nd;
import c4.od;
import c4.w6;
import com.google.gson.internal.a;
import com.uptodown.UptodownApp;
import com.uptodown.activities.VirusTotalReport;
import f4.c;
import j$.util.concurrent.ConcurrentHashMap;
import j5.t;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.y;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import r7.o0;
import t4.j1;
import t4.t0;
import t7.n;
import x4.e;
import x4.f2;
import x4.g;
import x4.g1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class VirusTotalReport extends k0 {
    public static final /* synthetic */ int Q = 0;
    public final m O = new m(new w6(this, 15));
    public final ViewModelLazy P = new ViewModelLazy(y.a(od.class), new md(this, 0), new ld(this), new md(this, 1));

    public final void A0() {
        f2 f2Var = (f2) z0().f1971e.getValue();
        String str = f2Var != null ? f2Var.f11151a : null;
        if (str == null || str.length() == 0) {
            g gVar = (g) z0().f1969c.getValue();
            String str2 = gVar != null ? gVar.P : null;
            if (str2 == null || str2.length() == 0) {
                y0().f9912l.setVisibility(8);
            } else {
                TextView textView = y0().v;
                Object value = z0().f1969c.getValue();
                value.getClass();
                textView.setText(((g) value).P);
            }
        } else {
            TextView textView2 = y0().v;
            Object value2 = z0().f1971e.getValue();
            value2.getClass();
            textView2.setText(((f2) value2).f11151a);
        }
        g gVar2 = (g) z0().f1969c.getValue();
        String str3 = gVar2 != null ? gVar2.M : null;
        if (str3 == null || str3.length() == 0) {
            e eVar = (e) z0().f1970d.getValue();
            String str4 = eVar != null ? eVar.f11132u : null;
            if (str4 == null || str4.length() == 0) {
                y0().f9913m.setVisibility(8);
            } else {
                TextView textView3 = y0().f9923x;
                e eVar2 = (e) z0().f1970d.getValue();
                textView3.setText(eVar2 != null ? eVar2.f11132u : null);
            }
        } else {
            TextView textView4 = y0().f9923x;
            g gVar3 = (g) z0().f1969c.getValue();
            textView4.setText(gVar3 != null ? gVar3.M : null);
        }
        if (y0().f9912l.getVisibility() == 0) {
            final int i = 0;
            y0().f9912l.setOnClickListener(new jd(this, i));
            y0().f9912l.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: c4.kd

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ VirusTotalReport f1807b;

                {
                    this.f1807b = this;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    int i6 = i;
                    VirusTotalReport virusTotalReport = this.f1807b;
                    switch (i6) {
                        case 0:
                            int i10 = VirusTotalReport.Q;
                            String obj = virusTotalReport.y0().v.getText().toString();
                            if (obj != null && obj.length() != 0) {
                                Object systemService = virusTotalReport.getSystemService("clipboard");
                                systemService.getClass();
                                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(null, obj));
                                break;
                            }
                            break;
                        default:
                            int i11 = VirusTotalReport.Q;
                            String obj2 = virusTotalReport.y0().f9923x.getText().toString();
                            if (obj2 != null && obj2.length() != 0) {
                                Object systemService2 = virusTotalReport.getSystemService("clipboard");
                                systemService2.getClass();
                                ((ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText(null, obj2));
                                break;
                            }
                            break;
                    }
                    return true;
                }
            });
        }
        if (y0().f9913m.getVisibility() == 0) {
            final int i6 = 1;
            y0().f9913m.setOnClickListener(new jd(this, i6));
            y0().f9913m.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: c4.kd

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ VirusTotalReport f1807b;

                {
                    this.f1807b = this;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    int i62 = i6;
                    VirusTotalReport virusTotalReport = this.f1807b;
                    switch (i62) {
                        case 0:
                            int i10 = VirusTotalReport.Q;
                            String obj = virusTotalReport.y0().v.getText().toString();
                            if (obj != null && obj.length() != 0) {
                                Object systemService = virusTotalReport.getSystemService("clipboard");
                                systemService.getClass();
                                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(null, obj));
                                break;
                            }
                            break;
                        default:
                            int i11 = VirusTotalReport.Q;
                            String obj2 = virusTotalReport.y0().f9923x.getText().toString();
                            if (obj2 != null && obj2.length() != 0) {
                                Object systemService2 = virusTotalReport.getSystemService("clipboard");
                                systemService2.getClass();
                                ((ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText(null, obj2));
                                break;
                            }
                            break;
                    }
                    return true;
                }
            });
        }
        y0().f9914n.setVisibility(8);
    }

    public final void B0() {
        y0().f9922w.setVisibility(8);
        y0().f9923x.setVisibility(8);
        y0().f9920t.setText(getString(2131952788));
        y0().v.setText(getString(2131952791));
        y0().f9914n.setVisibility(8);
    }

    public final void C0() {
        View inflate = getLayoutInflater().inflate(2131558882, (ViewGroup) null, false);
        int i = 2131362552;
        if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362552)) != null) {
            i = 2131362775;
            if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362775)) != null) {
                i = 2131362776;
                if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362776)) != null) {
                    i = 2131362777;
                    if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362777)) != null) {
                        i = 2131364587;
                        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364587);
                        if (textView != null) {
                            i = 2131364588;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364588);
                            if (textView2 != null) {
                                i = 2131364589;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364589);
                                if (textView3 != null) {
                                    i = 2131364590;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364590);
                                    if (textView4 != null) {
                                        i = 2131364591;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131364591);
                                        if (textView5 != null) {
                                            i = 2131364592;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate, 2131364592);
                                            if (textView6 != null) {
                                                textView6.setTypeface(c.f4882w);
                                                textView5.setTypeface(c.f4883x);
                                                textView.setTypeface(c.f4883x);
                                                textView3.setTypeface(c.f4883x);
                                                textView2.setTypeface(c.f4883x);
                                                textView4.setTypeface(c.f4883x);
                                                y0().f9917q.addView((LinearLayout) inflate);
                                                return;
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
        a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    public final void D0(f2 f2Var) {
        View inflate = getLayoutInflater().inflate(2131558883, (ViewGroup) null, false);
        int i = 2131362194;
        if (((Flow) ViewBindings.findChildViewById(inflate, 2131362194)) != null) {
            i = 2131362553;
            if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362553)) != null) {
                i = 2131362778;
                if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362778)) != null) {
                    i = 2131362779;
                    if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362779)) != null) {
                        i = 2131362780;
                        if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362780)) != null) {
                            i = 2131364593;
                            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364593);
                            if (textView != null) {
                                i = 2131364594;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364594);
                                if (textView2 != null) {
                                    i = 2131364595;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364595);
                                    if (textView3 != null) {
                                        i = 2131364596;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364596);
                                        if (textView4 != null) {
                                            i = 2131364597;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131364597);
                                            if (textView5 != null) {
                                                i = 2131364598;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate, 2131364598);
                                                if (textView6 != null) {
                                                    i = 2131364599;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(inflate, 2131364599);
                                                    if (textView7 != null) {
                                                        LinearLayout linearLayout = (LinearLayout) inflate;
                                                        textView6.setTypeface(c.f4882w);
                                                        textView5.setTypeface(c.f4883x);
                                                        textView2.setTypeface(c.f4883x);
                                                        textView.setTypeface(c.f4883x);
                                                        textView7.setTypeface(c.f4882w);
                                                        textView4.setTypeface(c.f4882w);
                                                        textView3.setTypeface(c.f4882w);
                                                        int i6 = f2Var.f11153l;
                                                        if (i6 > 0) {
                                                            textView5.setText(getString(2131952795, String.valueOf(i6)));
                                                        } else {
                                                            textView5.setVisibility(8);
                                                        }
                                                        textView2.setText(getString(2131952780, f2Var.f11155n));
                                                        y0().f9917q.addView(linearLayout);
                                                        return;
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
            }
        }
        a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    public final void E0(f2 f2Var) {
        Object obj = null;
        View inflate = getLayoutInflater().inflate(2131558884, (ViewGroup) null, false);
        int i = 2131362554;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362554);
        if (imageView != null) {
            i = 2131362781;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362781);
            if (linearLayout != null) {
                i = 2131363300;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363300);
                if (relativeLayout != null) {
                    i = 2131364600;
                    TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364600);
                    if (textView != null) {
                        i = 2131364601;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364601);
                        if (textView2 != null) {
                            i = 2131364602;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364602);
                            if (textView3 != null) {
                                i = 2131364603;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364603);
                                if (textView4 != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) inflate;
                                    textView4.setTypeface(c.f4882w);
                                    textView3.setTypeface(c.f4883x);
                                    textView2.setTypeface(c.f4883x);
                                    textView.setTypeface(c.f4883x);
                                    textView3.setText(getString(2131952800, String.valueOf(f2Var.f11154m), String.valueOf(f2Var.f11153l)));
                                    textView2.setText(getString(2131952780, f2Var.f11155n));
                                    ArrayList arrayList = f2Var.f11156o;
                                    if (arrayList != null && !arrayList.isEmpty()) {
                                        ArrayList arrayList2 = f2Var.f11156o;
                                        arrayList2.getClass();
                                        int size = arrayList2.size();
                                        int i6 = 0;
                                        while (true) {
                                            if (i6 >= size) {
                                                break;
                                            }
                                            Object obj2 = arrayList2.get(i6);
                                            i6++;
                                            g1 g1Var = (g1) obj2;
                                            if (g1Var.f11201l == 0 && g1Var.f11202m == 0) {
                                                obj = obj2;
                                                break;
                                            }
                                        }
                                        if (((g1) obj) != null) {
                                            relativeLayout.setBackground(ContextCompat.getDrawable(this, 2131231242));
                                            imageView.setImageDrawable(ContextCompat.getDrawable(this, 2131231498));
                                        }
                                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                                        layoutParams.setMargins((int) getResources().getDimension(2131166252), (int) getResources().getDimension(2131166251), 0, 0);
                                        Iterator it = f2Var.f11156o.iterator();
                                        it.getClass();
                                        while (it.hasNext()) {
                                            Object next = it.next();
                                            next.getClass();
                                            g1 g1Var2 = (g1) next;
                                            t0 a8 = t0.a(getLayoutInflater());
                                            TextView textView5 = a8.f10126l;
                                            TextView textView6 = a8.f10127m;
                                            RelativeLayout relativeLayout2 = a8.f10125b;
                                            TextView textView7 = a8.f10128n;
                                            relativeLayout2.setLayoutParams(layoutParams);
                                            textView6.setTypeface(c.f4882w);
                                            textView6.setText(g1Var2.f11200b);
                                            textView5.setTypeface(c.f4883x);
                                            textView5.setText(g1Var2.f11199a);
                                            textView7.setTypeface(c.f4882w);
                                            if (g1Var2.f11201l == 1) {
                                                textView7.setText(getString(2131952505));
                                            } else if (g1Var2.f11202m == 1) {
                                                textView7.setText(getString(2131951664));
                                            } else {
                                                a8.f10129o.setBackground(ContextCompat.getDrawable(this, 2131231252));
                                                textView7.setText(getString(2131952206));
                                                textView7.setTextColor(ContextCompat.getColor(this, 2131100824));
                                                textView7.setBackground(ContextCompat.getDrawable(this, 2131231194));
                                            }
                                            linearLayout.addView(relativeLayout2);
                                        }
                                    }
                                    y0().f9917q.addView(linearLayout2);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f9910a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Intent intent = getIntent();
        t6.c cVar = null;
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("appInfo")) {
                z0().f1969c.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appInfo", g.class) : extras.getParcelable("appInfo"));
            }
            if (extras != null && extras.containsKey("app_selected")) {
                z0().f1970d.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("app_selected", e.class) : extras.getParcelable("app_selected"));
            }
            if (extras != null && extras.containsKey("old_version_name")) {
                z0().f.f(extras.getString("old_version_name"));
            }
            if (extras != null && extras.containsKey("oldVersionId")) {
                o0 o0Var = z0().h;
                Boolean bool = Boolean.TRUE;
                o0Var.getClass();
                o0Var.g(null, bool);
                o0 o0Var2 = z0().g;
                Long valueOf = Long.valueOf(extras.getLong("oldVersionId"));
                o0Var2.getClass();
                o0Var2.g(null, valueOf);
            }
            if (extras != null && extras.containsKey("appReportVT")) {
                z0().f1971e.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appReportVT", f2.class) : extras.getParcelable("appReportVT"));
            }
            if (extras != null && extras.containsKey("isVirusTotalReportAvaialable")) {
                o0 o0Var3 = z0().i;
                Boolean valueOf2 = Boolean.valueOf(extras.getBoolean("isVirusTotalReportAvaialable"));
                o0Var3.getClass();
                o0Var3.g(null, valueOf2);
            }
        }
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            y0().f9918r.setNavigationIcon(drawable);
            y0().f9918r.setNavigationContentDescription(getString(2131951735));
        }
        y0().f9918r.setNavigationOnClickListener(new jd(this, 2));
        y0().f9924y.setTypeface(c.f4882w);
        if (z0().f1969c.getValue() != null) {
            Object value = z0().f1969c.getValue();
            value.getClass();
            String i = ((g) value).i();
            if (i == null || i.length() == 0) {
                ((ImageView) y0().f9911b.f82l).setImageDrawable(ContextCompat.getDrawable(this, 2131231296));
            } else {
                g0 d10 = g0.d();
                Object value2 = z0().f1969c.getValue();
                value2.getClass();
                l0 e10 = d10.e(((g) value2).i());
                float f = UptodownApp.I;
                e10.h(d.x(this));
                e10.e((ImageView) y0().f9911b.f82l, null);
            }
        } else if (z0().f1970d.getValue() != null) {
            ConcurrentHashMap concurrentHashMap = t.f6708a;
            Object value3 = z0().f1970d.getValue();
            value3.getClass();
            ((ImageView) y0().f9911b.f82l).setImageDrawable(t.b(this, ((e) value3).f11123l));
        }
        ((TextView) y0().f9911b.f84n).setTypeface(c.f4882w);
        if (z0().f1969c.getValue() != null) {
            TextView textView = (TextView) y0().f9911b.f84n;
            Object value4 = z0().f1969c.getValue();
            value4.getClass();
            textView.setText(((g) value4).f11159b);
        } else if (z0().f1970d.getValue() != null) {
            TextView textView2 = (TextView) y0().f9911b.f84n;
            Object value5 = z0().f1970d.getValue();
            value5.getClass();
            textView2.setText(((e) value5).f11122b);
        }
        ((TextView) y0().f9911b.f85o).setTypeface(c.f4883x);
        CharSequence charSequence = (CharSequence) z0().f.getValue();
        if (charSequence != null && charSequence.length() != 0) {
            ((TextView) y0().f9911b.f85o).setText((CharSequence) z0().f.getValue());
        } else if (z0().f1969c.getValue() != null) {
            TextView textView3 = (TextView) y0().f9911b.f85o;
            Object value6 = z0().f1969c.getValue();
            value6.getClass();
            textView3.setText(((g) value6).f11170l);
        } else if (z0().f1970d.getValue() != null) {
            TextView textView4 = (TextView) y0().f9911b.f85o;
            Object value7 = z0().f1970d.getValue();
            value7.getClass();
            textView4.setText(((e) value7).f11125n);
        }
        if (z0().f1969c.getValue() != null) {
            Object value8 = z0().f1969c.getValue();
            value8.getClass();
            String str = ((g) value8).f11190w;
            if (str != null && str.length() != 0) {
                ((TextView) y0().f9911b.f83m).setTypeface(c.f4883x);
                ((TextView) y0().f9911b.f83m).setVisibility(0);
                TextView textView5 = (TextView) y0().f9911b.f83m;
                Object value9 = z0().f1969c.getValue();
                value9.getClass();
                textView5.setText(((g) value9).f11190w);
            }
        }
        y0().f9920t.setTypeface(c.f4883x);
        y0().f9919s.setTypeface(c.f4882w);
        y0().f9919s.setOnClickListener(new jd(this, 3));
        y0().A.setTypeface(c.f4882w);
        y0().f9925z.setTypeface(c.f4883x);
        y0().f9915o.setOnClickListener(new jd(this, 4));
        y0().C.setTypeface(c.f4882w);
        y0().B.setTypeface(c.f4883x);
        y0().f9916p.setOnClickListener(new jd(this, 5));
        y0().v.setTypeface(c.f4883x);
        y0().f9921u.setTypeface(c.f4882w);
        y0().f9923x.setTypeface(c.f4883x);
        y0().f9922w.setTypeface(c.f4882w);
        y0().f9914n.setOnClickListener(new c4.e(24));
        if (z0().f1971e.getValue() != null) {
            A0();
            Object value10 = z0().f1971e.getValue();
            value10.getClass();
            ArrayList arrayList = ((f2) value10).f11156o;
            if (arrayList == null || arrayList.isEmpty()) {
                Object value11 = z0().f1971e.getValue();
                value11.getClass();
                D0((f2) value11);
            } else {
                Object value12 = z0().f1971e.getValue();
                value12.getClass();
                E0((f2) value12);
            }
        } else {
            if (((Boolean) z0().i.getValue()).booleanValue()) {
                od z02 = z0();
                Object value13 = z0().f1969c.getValue();
                value13.getClass();
                long j = ((g) value13).J;
                long longValue = ((Number) z0().g.getValue()).longValue();
                boolean booleanValue = ((Boolean) z0().h.getValue()).booleanValue();
                z02.getClass();
                a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                v7.e eVar = m0.f8288a;
                c0.s(viewModelScope, v7.d.f10884a, null, new nd(z02, booleanValue, j, longValue, this, null), 2);
                c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new s(this, cVar, 18), 2);
            }
            C0();
            B0();
        }
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new s(this, cVar, 18), 2);
    }

    public final j1 y0() {
        return (j1) this.O.getValue();
    }

    public final od z0() {
        return (od) this.P.getValue();
    }
}
