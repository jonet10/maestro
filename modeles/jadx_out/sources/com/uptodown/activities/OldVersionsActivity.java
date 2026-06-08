package com.uptodown.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.g;
import androidx.work.impl.utils.c;
import c4.e6;
import c4.f6;
import c4.h6;
import c4.k0;
import com.uptodown.UptodownApp;
import e4.s;
import f0.i;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import l5.f;
import l7.u;
import m1.a;
import n4.d;
import o7.c0;
import o7.m0;
import p6.m;
import t7.n;
import x4.a0;
import x4.d0;
import x4.e;
import x4.r;
import x4.t1;
import x4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class OldVersionsActivity extends k0 {
    public static final /* synthetic */ int S = 0;
    public s Q;
    public final m O = new m(new g(this, 27));
    public final ViewModelLazy P = new ViewModelLazy(y.a(h6.class), new f6(this, 0), new e6(this), new f6(this, 1));
    public final i R = new i(this, 9);

    public final h6 A0() {
        return (h6) this.P.getValue();
    }

    public final void B0(r rVar) {
        String str = rVar.f11355b;
        str.getClass();
        long j = rVar.f11358n;
        PackageManager packageManager = getPackageManager();
        try {
            packageManager.getClass();
            if (j < d.d(n4.i.e(packageManager, str, 128))) {
                String str2 = rVar.f11355b;
                str2.getClass();
                String string = getString(2131952294);
                string.getClass();
                H(string, new c(5, this, str2));
                return;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        File g = rVar.g();
        if (g == null || !g.exists()) {
            return;
        }
        float f = UptodownApp.I;
        b4.d.q(this, null, g);
    }

    public final void C0(r rVar) {
        int r9 = rVar.r(this);
        if (r9 >= 0) {
            Object value = A0().f1681d.getValue();
            value.getClass();
            String str = ((x4.g) value).f11159b;
            str.getClass();
            o0(r9, str);
            return;
        }
        A(getString(2131951992) + " (108)");
    }

    public final void D0(int i, r rVar) {
        Object value = A0().f1681d.getValue();
        value.getClass();
        if (u.m0(((x4.g) value).F, rVar != null ? rVar.f11355b : null, false)) {
            if (i == 203) {
                E0(rVar);
                return;
            }
            if (i == 208) {
                String string = getString(2131952382);
                string.getClass();
                A(string);
            } else {
                if (this.Q == null || A0().f1682e) {
                    return;
                }
                Long valueOf = rVar != null ? Long.valueOf(rVar.f11361q) : null;
                x4.g gVar = (x4.g) A0().f1681d.getValue();
                if (l.a(valueOf, gVar != null ? Long.valueOf(gVar.f11158a) : null)) {
                    E0(rVar);
                }
            }
        }
    }

    public final void E0(r rVar) {
        t1 t1Var;
        Object obj;
        Object value = A0().f1681d.getValue();
        value.getClass();
        ArrayList arrayList = ((x4.g) value).E0;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    obj = null;
                    break;
                }
                obj = arrayList.get(i);
                i++;
                t1 t1Var2 = (t1) obj;
                if (rVar != null && t1Var2.f11399m == rVar.f11358n) {
                    break;
                }
            }
            t1Var = (t1) obj;
        } else {
            t1Var = null;
        }
        Object value2 = A0().f1681d.getValue();
        value2.getClass();
        ArrayList arrayList2 = ((x4.g) value2).E0;
        Integer valueOf = arrayList2 != null ? Integer.valueOf(arrayList2.indexOf(t1Var)) : null;
        if (t1Var == null || valueOf == null) {
            s sVar = this.Q;
            if (sVar != null) {
                sVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        s sVar2 = this.Q;
        if (sVar2 != null) {
            sVar2.notifyItemChanged(valueOf.intValue());
        }
    }

    @Override // c4.k0
    public final void b0(d0 d0Var) {
        d0Var.getClass();
        r a8 = d0Var.a();
        if ((a8 != null ? Long.valueOf(a8.f11358n) : null) != null) {
            D0(d0Var.c(), a8);
        }
        if ((d0Var instanceof x) && a8 != null && a8.g() != null) {
            runOnUiThread(new a(this, a8, 2, false));
        }
        if (d0Var instanceof a0) {
            D0(d0Var.c(), a8);
        }
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f9667a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        A0().f = true;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            if (extras.containsKey("app")) {
                A0().f1680c.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("app", e.class) : extras.getParcelable("app"));
            }
            if (extras.containsKey("appInfo")) {
                A0().f1681d.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appInfo", x4.g.class) : extras.getParcelable("appInfo"));
            }
        }
        Toolbar toolbar = (Toolbar) findViewById(2131363553);
        if (toolbar != null) {
            Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
            if (drawable != null) {
                toolbar.setNavigationIcon(drawable);
                toolbar.setNavigationContentDescription(getString(2131951735));
            }
            toolbar.setNavigationOnClickListener(new c4.d(this, 10));
        }
        ((TextView) findViewById(2131364439)).setTypeface(f4.c.f4882w);
        y0().f9670m.setTypeface(f4.c.f4883x);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        linearLayoutManager.setItemPrefetchEnabled(false);
        y0().f9669l.setLayoutManager(linearLayoutManager);
        y0().f9669l.setItemAnimator(null);
        y0().f9669l.addItemDecoration(new f((int) getResources().getDimension(2131166251), (int) getResources().getDimension(2131166253)));
        y0().f9668b.setOnClickListener(new c4.e(15));
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new b.s(this, (t6.c) null, 9), 2);
        z0();
    }

    @Override // c4.k0
    public final boolean s0() {
        return false;
    }

    public final t4.c0 y0() {
        return (t4.c0) this.O.getValue();
    }

    public final void z0() {
        A0().f1682e = true;
        if (A0().f1681d.getValue() != null) {
            h6 A0 = A0();
            A0.getClass();
            o7.a0 viewModelScope = ViewModelKt.getViewModelScope(A0);
            v7.e eVar = m0.f8288a;
            c0.s(viewModelScope, v7.d.f10884a, null, new b6.g(A0, this, null, 5), 2);
        }
    }
}
