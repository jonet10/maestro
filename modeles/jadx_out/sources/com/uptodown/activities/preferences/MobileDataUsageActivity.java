package com.uptodown.activities.preferences;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b.s;
import b4.d;
import c4.c6;
import c4.k0;
import c4.w6;
import com.uptodown.UptodownApp;
import d4.f;
import d4.g;
import d4.h;
import d4.l;
import f4.c;
import k0.k;
import kotlin.jvm.internal.y;
import o7.c0;
import p6.m;
import t4.v;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class MobileDataUsageActivity extends k0 {
    public static final /* synthetic */ int Q = 0;
    public final m O = new m(new w6(this, 18));
    public final ViewModelLazy P = new ViewModelLazy(y.a(l.class), new h(this, 0), new g(this), new h(this, 1));

    public final v A0() {
        return (v) this.O.getValue();
    }

    public final l B0() {
        return (l) this.P.getValue();
    }

    public final void C0(String str, String str2, String str3) {
        Bundle e10 = k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        if (str2 != null) {
            e10.putString("connectionType", str2);
        }
        if (str3 != null) {
            e10.putString("new_value", str3);
        }
        android.support.v4.media.g gVar = this.E;
        if (gVar != null) {
            gVar.E(e10, "settings_data_usage");
        }
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        float f = UptodownApp.I;
        int i = 0;
        if (d.n(this)) {
            setRequestedOrientation(0);
        }
        RelativeLayout relativeLayout = A0().f10143a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        A0().f10147n.setNavigationIcon(ContextCompat.getDrawable(this, 2131230922));
        A0().f10147n.setNavigationContentDescription(getString(2131951735));
        A0().f10147n.setNavigationOnClickListener(new f(this, 5));
        A0().F.setTypeface(c.f4882w);
        A0().G.setTypeface(c.f4882w);
        A0().G.setOnClickListener(new f(this, 10));
        A0().M.setTypeface(c.f4882w);
        A0().M.setOnClickListener(new f(this, 11));
        A0().f10157y.setTypeface(c.f4882w);
        A0().f10157y.setOnClickListener(new f(this, 12));
        A0().f10154u.setTypeface(c.f4883x);
        A0().f10155w.setTypeface(c.f4883x);
        A0().f10151r.setTypeface(c.f4883x);
        A0().J.setTypeface(c.f4883x);
        A0().f10150q.setTypeface(c.f4882w);
        A0().f10149p.setTypeface(c.f4883x);
        A0().A.setTypeface(c.f4882w);
        A0().A.setOnClickListener(new f(this, 13));
        A0().f10156x.setTypeface(c.f4882w);
        A0().f10156x.setOnClickListener(new f(this, i));
        A0().N.setTypeface(c.f4882w);
        A0().N.setOnClickListener(new f(this, 1));
        A0().L.setTypeface(c.f4882w);
        A0().I.setTypeface(c.f4883x);
        A0().K.setTypeface(c.f4882w);
        A0().K.setOnClickListener(new f(this, 2));
        A0().H.setTypeface(c.f4882w);
        int i6 = 3;
        A0().H.setOnClickListener(new f(this, i6));
        A0().f10148o.setTypeface(c.f4882w);
        A0().f10146m.setOnCheckedChangeListener(new c6(this, i6));
        A0().f10153t.setTypeface(c.f4882w);
        A0().f10152s.setTypeface(c.f4883x);
        A0().v.setTypeface(c.f4882w);
        A0().v.setOnClickListener(new f(this, 6));
        A0().f10158z.setTypeface(c.f4882w);
        A0().f10158z.setOnClickListener(new f(this, 7));
        A0().E.setTypeface(c.f4882w);
        A0().C.setTypeface(c.f4883x);
        A0().D.setTypeface(c.f4882w);
        A0().D.setOnClickListener(new f(this, 8));
        A0().B.setTypeface(c.f4882w);
        A0().B.setOnClickListener(new f(this, 9));
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new s(this, (t6.c) null, 20), 2);
        B0().a(this);
    }

    public final void y0(TextView textView, TextView textView2) {
        textView.setTextColor(ContextCompat.getColor(this, 2131100824));
        textView.setBackground(ContextCompat.getDrawable(this, 2131231146));
        textView2.setTextColor(ContextCompat.getColor(this, 2131099713));
        textView2.setBackground(ContextCompat.getDrawable(this, 2131231158));
    }

    public final void z0(TextView textView, TextView textView2, TextView textView3) {
        textView.setTextColor(ContextCompat.getColor(this, 2131100824));
        textView.setBackground(ContextCompat.getDrawable(this, 2131231197));
        textView2.setTextColor(ContextCompat.getColor(this, 2131100789));
        textView2.setBackground(null);
        textView3.setTextColor(ContextCompat.getColor(this, 2131100789));
        textView3.setBackground(null);
    }
}
