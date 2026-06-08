package com.uptodown.activities;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.s;
import c4.d0;
import c4.g5;
import c4.h5;
import c4.i5;
import c4.j5;
import c4.k0;
import c4.k5;
import c4.m5;
import c4.o5;
import c4.z4;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MyDownloads;
import e4.b;
import f0.i;
import g4.v;
import j5.g;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import l5.f;
import l7.u;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import t6.c;
import t7.n;
import v7.d;
import v7.e;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class MyDownloads extends k0 {
    public static final /* synthetic */ int V = 0;
    public b Q;
    public boolean S;
    public final m O = new m(new z4(this, 0));
    public final ViewModelLazy P = new ViewModelLazy(y.a(o5.class), new k5(this, 0), new j5(this), new k5(this, 1));
    public m5 R = m5.f1864b;
    public final c4.b T = new c4.b(this, 4);
    public final i U = new i(this, 8);

    public final t4.y A0() {
        return (t4.y) this.O.getValue();
    }

    public final o5 B0() {
        return (o5) this.P.getValue();
    }

    public final void C0(boolean z9) {
        o5 B0 = B0();
        m5 m5Var = this.R;
        B0.getClass();
        m5Var.getClass();
        a0 viewModelScope = ViewModelKt.getViewModelScope(B0);
        e eVar = m0.f8288a;
        c0.s(viewModelScope, d.f10884a, null, new d0(z9, B0, this, m5Var, null), 2);
    }

    public final void D0() {
        int i;
        b bVar = this.Q;
        if (bVar != null) {
            boolean[] zArr = bVar.f4487d;
            if (zArr != null) {
                i = 0;
                for (boolean z9 : zArr) {
                    if (z9) {
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            TextView textView = (TextView) A0().f10239l.f5275b;
            this.Q.getClass();
            textView.setEnabled(!r3.f4485b.isEmpty());
        } else {
            i = 0;
        }
        if (i > 0) {
            ((TextView) A0().f10239l.f5276l).setEnabled(true);
            ((TextView) A0().f10239l.f5276l).setBackground(ContextCompat.getDrawable(this, 2131231146));
        } else {
            ((TextView) A0().f10239l.f5276l).setEnabled(false);
            ((TextView) A0().f10239l.f5276l).setBackground(ContextCompat.getDrawable(this, 2131231155));
        }
        ((TextView) A0().f10239l.f5277m).setText(getString(2131951883, String.valueOf(i)));
    }

    public final void E0() {
        ((RelativeLayout) A0().f10239l.f5278n).setVisibility(0);
        ((RelativeLayout) A0().f10239l.f5280p).setVisibility(0);
        ((LinearLayout) ((b5.m) A0().f10239l.f5279o).f1061b).setVisibility(4);
        D0();
    }

    public final void F0() {
        b bVar = this.Q;
        if (bVar != null) {
            bVar.c(false);
        }
        ((RelativeLayout) A0().f10239l.f5278n).setVisibility(0);
        ((LinearLayout) ((b5.m) A0().f10239l.f5279o).f1061b).setVisibility(0);
        ((RelativeLayout) A0().f10239l.f5280p).setVisibility(4);
    }

    @Override // c4.k0
    public final void b0(x4.d0 d0Var) {
        d0Var.getClass();
        int c9 = d0Var.c();
        r a8 = d0Var.a();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = m0.f8288a;
        c0.s(lifecycleScope, n.f10348a, null, new b.n(this, c9, a8, (c) null), 2);
    }

    @Override // c4.k0
    public final void e0(String str) {
        b bVar;
        b bVar2 = this.Q;
        Integer valueOf = bVar2 != null ? Integer.valueOf(bVar2.f4488e) : null;
        if (valueOf != null && valueOf.intValue() >= 0 && (bVar = this.Q) != null) {
            bVar.notifyItemChanged(valueOf.intValue());
        }
        b bVar3 = this.Q;
        if (bVar3 != null) {
            bVar3.f4488e = -1;
        }
    }

    @Override // c4.k0
    public final void f0(String str, String str2) {
        b bVar;
        if (str == null || (bVar = this.Q) == null || bVar.f4485b.isEmpty()) {
            return;
        }
        b bVar2 = this.Q;
        bVar2.getClass();
        Iterator it = bVar2.f4485b.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            int i6 = i + 1;
            if (u.m0(((r) it.next()).f11355b, str, true)) {
                break;
            } else {
                i = i6;
            }
        }
        if (i >= 0) {
            b bVar3 = this.Q;
            bVar3.getClass();
            bVar3.notifyItemChanged(i);
            b bVar4 = this.Q;
            bVar4.getClass();
            String string = getString(2131952081, ((r) bVar4.f4485b.get(i)).f11366w);
            string.getClass();
            A(string);
        }
        b bVar5 = this.Q;
        bVar5.getClass();
        bVar5.f4488e = -1;
    }

    @Override // c4.k0
    public final void n0() {
        b bVar = this.Q;
        if (bVar != null) {
            bVar.f4488e = -1;
        }
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        final int i = 1;
        c cVar = null;
        if (extras != null && extras.containsKey("remoteInstallPath")) {
            Bundle extras2 = getIntent().getExtras();
            String string = extras2 != null ? extras2.getString("remoteInstallPath") : null;
            string.getClass();
            File file = new File(string);
            if (file.exists()) {
                W(file, null);
            }
            Object systemService = getSystemService("notification");
            systemService.getClass();
            ((NotificationManager) systemService).cancel(8);
        }
        RelativeLayout relativeLayout = A0().f10237a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            A0().f10243p.setNavigationIcon(drawable);
            A0().f10243p.setNavigationContentDescription(getString(2131951735));
        }
        ((TextView) findViewById(2131364446)).setTypeface(f4.c.f4882w);
        final int i6 = 0;
        A0().f10243p.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: c4.e5

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MyDownloads f1554b;

            {
                this.f1554b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i10 = i6;
                MyDownloads myDownloads = this.f1554b;
                switch (i10) {
                    case 0:
                        int i11 = MyDownloads.V;
                        myDownloads.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i12 = MyDownloads.V;
                        myDownloads.A0().f10242o.setIconified(false);
                        break;
                    case 2:
                        int i13 = MyDownloads.V;
                        String string2 = myDownloads.getString(2131951932);
                        string2.getClass();
                        myDownloads.H(String.format(string2, Arrays.copyOf(new Object[0], 0)), new z4(myDownloads, 4));
                        break;
                    default:
                        int i14 = MyDownloads.V;
                        String string3 = myDownloads.getString(2131951934);
                        string3.getClass();
                        myDownloads.H(String.format(string3, Arrays.copyOf(new Object[0], 0)), new z4(myDownloads, 1));
                        break;
                }
            }
        });
        A0().f10243p.inflateMenu(2131689479);
        A0().f10243p.setOnMenuItemClickListener(new a(this, 4));
        A0().f10242o.setOnQueryTextListener(new h5(this));
        A0().f10242o.setOnClickListener(new View.OnClickListener(this) { // from class: c4.e5

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MyDownloads f1554b;

            {
                this.f1554b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i10 = i;
                MyDownloads myDownloads = this.f1554b;
                switch (i10) {
                    case 0:
                        int i11 = MyDownloads.V;
                        myDownloads.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i12 = MyDownloads.V;
                        myDownloads.A0().f10242o.setIconified(false);
                        break;
                    case 2:
                        int i13 = MyDownloads.V;
                        String string2 = myDownloads.getString(2131951932);
                        string2.getClass();
                        myDownloads.H(String.format(string2, Arrays.copyOf(new Object[0], 0)), new z4(myDownloads, 4));
                        break;
                    default:
                        int i14 = MyDownloads.V;
                        String string3 = myDownloads.getString(2131951934);
                        string3.getClass();
                        myDownloads.H(String.format(string3, Arrays.copyOf(new Object[0], 0)), new z4(myDownloads, 1));
                        break;
                }
            }
        });
        ((ImageView) A0().f10242o.findViewById(R.id.search_close_btn)).setBackgroundResource(2131230917);
        EditText editText = (EditText) A0().f10242o.findViewById(R.id.search_src_text);
        editText.setTypeface(f4.c.f4883x);
        editText.setTextColor(ContextCompat.getColor(this, 2131100787));
        editText.setHintTextColor(ContextCompat.getColor(this, 2131099760));
        ((TextView) ((b5.m) A0().f10239l.f5279o).f1062l).setTypeface(f4.c.f4883x);
        ((TextView) ((b5.m) A0().f10239l.f5279o).f1063m).setTypeface(f4.c.f4882w);
        ((TextView) ((b5.m) A0().f10239l.f5279o).f1063m).setText(getString(2131952435));
        HashMap hashMap = new HashMap();
        hashMap.put(0, getString(2131952437));
        hashMap.put(1, getString(2131952435));
        final int i10 = 2;
        hashMap.put(2, getString(2131952439));
        ((LinearLayout) ((b5.m) A0().f10239l.f5279o).f1061b).setOnClickListener(new c.e(11, this, hashMap));
        A0().f10241n.setLayoutManager(new LinearLayoutManager(this, 1, false));
        int dimension = (int) getResources().getDimension(2131166251);
        A0().f10241n.addItemDecoration(new f(dimension, dimension));
        A0().f10241n.setItemAnimator(null);
        A0().f10241n.addOnItemTouchListener(new i5(this));
        A0().f10244q.setTypeface(f4.c.f4883x);
        v vVar = A0().f10239l;
        ((TextView) A0().f10239l.f5277m).setTypeface(f4.c.f4883x);
        ((TextView) A0().f10239l.f5275b).setTypeface(f4.c.f4882w);
        ((TextView) A0().f10239l.f5275b).setOnClickListener(new View.OnClickListener(this) { // from class: c4.e5

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MyDownloads f1554b;

            {
                this.f1554b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i10;
                MyDownloads myDownloads = this.f1554b;
                switch (i102) {
                    case 0:
                        int i11 = MyDownloads.V;
                        myDownloads.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i12 = MyDownloads.V;
                        myDownloads.A0().f10242o.setIconified(false);
                        break;
                    case 2:
                        int i13 = MyDownloads.V;
                        String string2 = myDownloads.getString(2131951932);
                        string2.getClass();
                        myDownloads.H(String.format(string2, Arrays.copyOf(new Object[0], 0)), new z4(myDownloads, 4));
                        break;
                    default:
                        int i14 = MyDownloads.V;
                        String string3 = myDownloads.getString(2131951934);
                        string3.getClass();
                        myDownloads.H(String.format(string3, Arrays.copyOf(new Object[0], 0)), new z4(myDownloads, 1));
                        break;
                }
            }
        });
        ((TextView) A0().f10239l.f5276l).setTypeface(f4.c.f4882w);
        final int i11 = 3;
        ((TextView) A0().f10239l.f5276l).setOnClickListener(new View.OnClickListener(this) { // from class: c4.e5

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MyDownloads f1554b;

            {
                this.f1554b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i11;
                MyDownloads myDownloads = this.f1554b;
                switch (i102) {
                    case 0:
                        int i112 = MyDownloads.V;
                        myDownloads.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i12 = MyDownloads.V;
                        myDownloads.A0().f10242o.setIconified(false);
                        break;
                    case 2:
                        int i13 = MyDownloads.V;
                        String string2 = myDownloads.getString(2131951932);
                        string2.getClass();
                        myDownloads.H(String.format(string2, Arrays.copyOf(new Object[0], 0)), new z4(myDownloads, 4));
                        break;
                    default:
                        int i14 = MyDownloads.V;
                        String string3 = myDownloads.getString(2131951934);
                        string3.getClass();
                        myDownloads.H(String.format(string3, Arrays.copyOf(new Object[0], 0)), new z4(myDownloads, 1));
                        break;
                }
            }
        });
        A0().f10238b.setOnClickListener(new c4.e(12));
        F0();
        hideKeyboardOnScroll(A0().f10240m);
        z();
        getOnBackPressedDispatcher().addCallback(this, this.T);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new s(this, cVar, 7), 2);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        try {
            g l10 = g.D.l(this);
            l10.b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("checked", (Integer) 1);
            SQLiteDatabase sQLiteDatabase = l10.f6673a;
            sQLiteDatabase.getClass();
            sQLiteDatabase.update("downloads", contentValues, null, null);
            l10.c();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        super.onPause();
    }

    @Override // c4.k0, g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        Object systemService = getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(258);
        C0(true);
    }

    @Override // c4.k0
    public final void p0(File file) {
        b bVar = this.Q;
        if (bVar != null) {
            bVar.f4488e = -1;
        }
        if (bVar != null) {
            bVar.a(file);
        }
    }

    @Override // c4.k0
    public final void q0(File file) {
        file.getClass();
        b bVar = this.Q;
        if (bVar != null) {
            bVar.a(file);
        }
    }

    @Override // c4.k0
    public final void r0(File file) {
        b bVar = this.Q;
        if (bVar != null) {
            Iterator it = bVar.f4485b.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i6 = i + 1;
                if (l.a(((r) it.next()).f(), file)) {
                    bVar.f4488e = i;
                    break;
                }
                i = i6;
            }
            int i10 = bVar.f4488e;
            if (i10 >= 0) {
                bVar.notifyItemChanged(i10);
            }
        }
    }

    @Override // c4.k0
    public final void x0(x4.g gVar) {
        gVar.getClass();
        if (isFinishing() || !T()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) AppDetailActivity.class);
        intent.putExtra("appInfo", gVar);
        float f = UptodownApp.I;
        startActivity(intent, b4.d.a(this));
    }

    public final void y0(boolean z9) {
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new g5(this, z9, null), 3);
    }

    public final void z0(int i) {
        b bVar = this.Q;
        if (bVar == null || bVar.f4485b.isEmpty()) {
            return;
        }
        b bVar2 = this.Q;
        bVar2.getClass();
        if (i < bVar2.f4485b.size()) {
            c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new c4.m(this, i, null), 3);
        }
    }

    @Override // c4.k0
    public final void g0() {
    }

    @Override // c4.k0
    public final void Y(String str) {
    }

    @Override // c4.k0
    public final void Z(String str) {
    }

    @Override // c4.k0
    public final void a0(String str) {
    }

    @Override // c4.k0
    public final void h0(String str) {
    }
}
