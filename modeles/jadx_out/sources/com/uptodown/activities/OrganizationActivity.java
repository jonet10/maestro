package com.uptodown.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.g;
import b.s;
import b6.a;
import c4.d;
import c4.k0;
import c4.k6;
import c4.l6;
import c4.n6;
import com.uptodown.activities.OrganizationActivity;
import e4.b0;
import kotlin.jvm.internal.y;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import r7.o0;
import t6.c;
import t7.n;
import v7.e;
import x4.d0;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class OrganizationActivity extends k0 {
    public static final /* synthetic */ int R = 0;
    public final m O = new m(new g(this, 28));
    public final ViewModelLazy P = new ViewModelLazy(y.a(n6.class), new l6(this, 0), new k6(this), new l6(this, 1));
    public b0 Q;

    @Override // c4.k0
    public final void b0(d0 d0Var) {
        d0Var.getClass();
        r a8 = d0Var.a();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = m0.f8288a;
        c0.s(lifecycleScope, n.f10348a, null, new a(a8, this, null, 18), 2);
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        Intent intent = getIntent();
        c cVar = null;
        if (intent != null && (extras = intent.getExtras()) != null) {
            if (extras.containsKey("organizationID")) {
                o0 o0Var = z0().f1906d;
                Long valueOf = Long.valueOf(extras.getLong("organizationID"));
                o0Var.getClass();
                o0Var.g(null, valueOf);
            }
            if (extras.containsKey("organizationName")) {
                o0 o0Var2 = z0().f1907e;
                String string = extras.getString("organizationName");
                string.getClass();
                o0Var2.getClass();
                o0Var2.g(null, string);
            }
        }
        RelativeLayout relativeLayout = y0().f9686a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        final t4.d0 y02 = y0();
        if (drawable != null) {
            y02.f9696t.setNavigationIcon(drawable);
            y02.f9696t.setNavigationContentDescription(getString(2131951735));
        }
        Toolbar toolbar = y02.f9696t;
        RecyclerView recyclerView = y02.f9694r;
        TextView textView = y02.f9699x;
        toolbar.setNavigationOnClickListener(new d(this, 11));
        textView.setTypeface(f4.c.f4882w);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        recyclerView.setItemAnimator(null);
        if (((CharSequence) z0().f1907e.getValue()).length() > 0) {
            textView.setText((CharSequence) z0().f1907e.getValue());
        }
        y02.f9695s.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: c4.i6
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                int i = OrganizationActivity.R;
                OrganizationActivity organizationActivity = OrganizationActivity.this;
                if (organizationActivity.z0().f || organizationActivity.z0().g) {
                    return;
                }
                ScrollView scrollView = y02.f9695s;
                if (scrollView.getChildAt(scrollView.getChildCount() - 1).getBottom() - (scrollView.getScrollY() + scrollView.getHeight()) > 0 || organizationActivity.z0().f || organizationActivity.z0().g) {
                    return;
                }
                e4.b0 b0Var = organizationActivity.Q;
                if (b0Var != null) {
                    b0Var.a(true);
                }
                n6 z02 = organizationActivity.z0();
                z02.getClass();
                o7.a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(viewModelScope, v7.d.f10884a, null, new b6.a(z02, organizationActivity, null, 20), 2);
            }
        });
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new s(this, cVar, 10), 2);
        n6 z02 = z0();
        z02.getClass();
        a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
        e eVar = m0.f8288a;
        c0.s(viewModelScope, v7.d.f10884a, null, new a(z02, this, cVar, 19), 2);
    }

    public final t4.d0 y0() {
        return (t4.d0) this.O.getValue();
    }

    public final n6 z0() {
        return (n6) this.P.getValue();
    }
}
