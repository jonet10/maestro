package com.uptodown.activities;

import a4.g0;
import a4.l0;
import a4.x;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import b4.d;
import c4.fb;
import c4.gb;
import c4.k0;
import c4.lb;
import c4.mb;
import c4.nb;
import c4.w6;
import c4.xc;
import c4.yc;
import c4.zc;
import com.google.android.gms.internal.measurement.i5;
import com.uptodown.UptodownApp;
import com.uptodown.util.views.UsernameTextView;
import f4.c;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import t4.z0;
import t7.n;
import v7.e;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class UserActivity extends k0 {
    public static final /* synthetic */ int W = 0;
    public final m O = new m(new w6(this, 8));
    public final ViewModelLazy P = new ViewModelLazy(y.a(zc.class), new nb(this, 0), new mb(this), new nb(this, 1));
    public String Q;
    public final ActivityResultLauncher R;
    public final ActivityResultLauncher S;
    public final ActivityResultLauncher T;
    public final ActivityResultLauncher U;
    public final ActivityResultLauncher V;

    public UserActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new gb(this, 1));
        registerForActivityResult.getClass();
        this.R = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new gb(this, 2));
        registerForActivityResult2.getClass();
        this.S = registerForActivityResult2;
        ActivityResultLauncher registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new gb(this, 3));
        registerForActivityResult3.getClass();
        this.T = registerForActivityResult3;
        ActivityResultLauncher registerForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new gb(this, 4));
        registerForActivityResult4.getClass();
        this.U = registerForActivityResult4;
        ActivityResultLauncher registerForActivityResult5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new gb(this, 5));
        registerForActivityResult5.getClass();
        this.V = registerForActivityResult5;
    }

    public final zc A0() {
        return (zc) this.P.getValue();
    }

    public final void B0() {
        if (T()) {
            Intent intent = new Intent(this, (Class<?>) LoginActivity.class);
            float f = UptodownApp.I;
            this.R.launch(intent, d.b(this));
        }
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = z0().f10273a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            z0().A.setNavigationIcon(drawable);
            z0().A.setNavigationContentDescription(getString(2131951735));
        }
        int i = 0;
        z0().A.setNavigationOnClickListener(new fb(this, i));
        z0().A.inflateMenu(2131689481);
        z0().A.setOverflowIcon(ContextCompat.getDrawable(this, 2131231365));
        z0().A.setOnMenuItemClickListener(new gb(this, i));
        z0().P.setTypeface(c.f4882w);
        z0().T.setTypeface(c.f4882w);
        z0().M.setTypeface(c.f4882w);
        z0().F.setTypeface(c.f4882w);
        z0().S.setTypeface(c.f4882w);
        z0().J.setTypeface(c.f4882w);
        z0().B.setTypeface(c.f4882w);
        z0().I.setTypeface(c.f4882w);
        z0().K.setTypeface(c.f4882w);
        z0().C.setTypeface(c.f4882w);
        z0().O.setTypeface(c.f4882w);
        z0().D.setTypeface(c.f4882w);
        z0().L.setTypeface(c.f4882w);
        z0().R.setTypeface(c.f4882w);
        z0().v.setVisibility(8);
        z0().Q.setTypeface(c.f4883x);
        z0().G.setTypeface(c.f4883x);
        z0().N.setTypeface(c.f4883x);
        z0().H.setTypeface(c.f4883x);
        z0().U.setTypeface(c.f4883x);
        z0().E.setTypeface(c.f4883x);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = m0.f8288a;
        p7.c cVar = n.f10348a;
        t6.c cVar2 = null;
        int i6 = 2;
        c0.s(lifecycleScope, cVar, null, new lb(this, cVar2, i), 2);
        int i10 = 1;
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new lb(this, cVar2, i10), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new lb(this, cVar2, i6), 2);
        zc A0 = A0();
        A0.getClass();
        c0.s(ViewModelKt.getViewModelScope(A0), v7.d.f10884a, null, new yc(this, A0, cVar2, i), 2);
        z0().f10275l.setOnClickListener(new fb(this, i10));
        z0().f10288z.setOnClickListener(new fb(this, i6));
        z0().M.setOnClickListener(new fb(this, 3));
        z0().f10287y.setOnClickListener(new fb(this, 4));
        z0().f10278o.setOnClickListener(new fb(this, 5));
        z0().f10286x.setOnClickListener(new fb(this, 6));
        z0().f10282s.setOnClickListener(new fb(this, 7));
        z0().f10281r.setOnClickListener(new fb(this, 8));
        z0().f10276m.setOnClickListener(new fb(this, 9));
        z0().f10277n.setOnClickListener(new fb(this, 10));
        z0().f10284u.setOnClickListener(new fb(this, 11));
        z0().f10285w.setOnClickListener(new fb(this, 12));
        z0().f10279p.setOnClickListener(new fb(this, 13));
        z0().f10280q.setOnClickListener(new fb(this, 14));
        z0().f10283t.setOnClickListener(new fb(this, 15));
        z0().U.setOnClickListener(new fb(this, 16));
        z0().E.setOnClickListener(new fb(this, 17));
    }

    @Override // c4.k0, g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        zc A0 = A0();
        A0.getClass();
        a0 viewModelScope = ViewModelKt.getViewModelScope(A0);
        e eVar = m0.f8288a;
        v7.d dVar = v7.d.f10884a;
        t6.c cVar = null;
        c0.s(viewModelScope, dVar, null, new yc(this, A0, cVar, 0), 2);
        Menu menu = z0().A.getMenu();
        MenuItem findItem = menu != null ? menu.findItem(2131361871) : null;
        if ((getResources().getConfiguration().uiMode & 48) == 16) {
            if (findItem != null) {
                findItem.setIcon(ContextCompat.getDrawable(this, 2131231366));
            }
        } else if (findItem != null) {
            findItem.setIcon(ContextCompat.getDrawable(this, 2131231443));
        }
        w2 h = u2.h(this);
        if ((h != null ? h.f11431a : null) == null || !u2.g(this)) {
            y0(this);
            return;
        }
        if (h.a() != null) {
            g0 d10 = g0.d();
            String str = h.f11433l;
            l0 e10 = d10.e(str != null ? x.k(str, UptodownApp.K, ":webp") : null);
            float f = UptodownApp.I;
            e10.h(d.x(this));
            e10.e(z0().f10275l, null);
            z0().f10275l.setBackground(ContextCompat.getDrawable(this, 2131231186));
        } else {
            z0().f10275l.setImageResource(2131231490);
        }
        z0().f10275l.setPadding(0, 0, 0, 0);
        z0().T.setText(h.f11434m);
        if (!h.d() || l.a(h.f11436o, "type0")) {
            int i = UsernameTextView.f3452s;
            i5.F(z0().T);
        } else {
            int i6 = UsernameTextView.f3452s;
            i5.g(z0().T, h.d(), h.f11436o);
        }
        if (h.d()) {
            z0().f10274b.setVisibility(0);
            ImageView imageView = z0().f10275l;
            int dimension = (int) imageView.getContext().getResources().getDimension(2131165270);
            imageView.setForeground(ContextCompat.getDrawable(imageView.getContext(), 2131231271));
            imageView.setPadding(dimension, dimension, dimension, dimension);
            z0().R.setText(getString(2131952679));
        } else {
            z0().R.setText(getString(2131952627));
        }
        z0().E.setVisibility(0);
        if (!h.d()) {
            z0().v.setVisibility(8);
        } else if (this.Q == null) {
            zc A02 = A0();
            A02.getClass();
            c0.s(ViewModelKt.getViewModelScope(A02), dVar, null, new yc(this, A02, cVar, 1), 2);
        } else {
            z0().v.setVisibility(0);
        }
        z0().M.setVisibility(0);
        float f10 = UptodownApp.I;
        d.A(this);
        d.z(this);
    }

    public final void y0(Context context) {
        zc A0 = A0();
        A0.getClass();
        context.getClass();
        a0 viewModelScope = ViewModelKt.getViewModelScope(A0);
        e eVar = m0.f8288a;
        c0.s(viewModelScope, v7.d.f10884a, null, new xc(context, null, 0), 2);
        z0().f10275l.setImageResource(2131231485);
        ImageView imageView = z0().f10275l;
        int dimension = (int) getResources().getDimension(2131166251);
        imageView.setPadding(dimension, dimension, dimension, dimension);
        z0().f10275l.setForeground(null);
        z0().f10275l.setBackground(ContextCompat.getDrawable(this, 2131231277));
        z0().T.setText(getString(2131952601));
        int i = UsernameTextView.f3452s;
        i5.F(z0().T);
        z0().T.setTextColor(ContextCompat.getColor(this, 2131100790));
        z0().R.setText(getString(2131952627));
        z0().M.setVisibility(8);
        z0().E.setVisibility(8);
        z0().v.setVisibility(8);
        this.Q = null;
        z0().f10274b.setVisibility(8);
    }

    public final z0 z0() {
        return (z0) this.O.getValue();
    }
}
