package com.uptodown.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c4.g;
import c4.k0;
import c4.pb;
import c4.rb;
import c4.sb;
import c4.ub;
import c4.w6;
import com.uptodown.activities.UserAvatarActivity;
import e4.a1;
import f0.i;
import f4.c;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.y;
import l5.l;
import o7.c0;
import p6.m;
import t7.n;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class UserAvatarActivity extends k0 {
    public static final /* synthetic */ int V = 0;
    public a1 Q;
    public a1 R;
    public int S;
    public final m O = new m(new w6(this, 9));
    public final ViewModelLazy P = new ViewModelLazy(y.a(ub.class), new sb(this, 0), new rb(this), new sb(this, 1));
    public final AtomicBoolean T = new AtomicBoolean(false);
    public final i U = new i(this, 15);

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f9587a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        z0().f2184e.f(u2.h(this));
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        t4.a1 y02 = y0();
        if (drawable != null) {
            y02.f9593p.setNavigationIcon(drawable);
            y02.f9593p.setNavigationContentDescription(getString(2131951735));
        }
        Toolbar toolbar = y02.f9593p;
        RecyclerView recyclerView = y02.f9591n;
        TextView textView = y02.f9595r;
        RecyclerView recyclerView2 = y02.f9592o;
        final int i = 0;
        toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: c4.ob

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UserAvatarActivity f1965b;

            {
                this.f1965b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i6 = i;
                t6.c cVar = null;
                UserAvatarActivity userAvatarActivity = this.f1965b;
                switch (i6) {
                    case 0:
                        int i10 = UserAvatarActivity.V;
                        userAvatarActivity.finish();
                        break;
                    case 1:
                        int i11 = UserAvatarActivity.V;
                        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(userAvatarActivity), null, null, new pb(userAvatarActivity, cVar, 0), 3);
                        break;
                    default:
                        int i12 = UserAvatarActivity.V;
                        j5.c.e(userAvatarActivity, d0.b.H(userAvatarActivity), null);
                        break;
                }
            }
        });
        y02.f9597t.setTypeface(c.f4882w);
        y02.f9596s.setTypeface(c.f4882w);
        textView.setTypeface(c.f4882w);
        y02.f9594q.setTypeface(c.f4882w);
        y02.f9598u.setTypeface(c.f4882w);
        final int i6 = 1;
        textView.setOnClickListener(new View.OnClickListener(this) { // from class: c4.ob

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UserAvatarActivity f1965b;

            {
                this.f1965b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i6;
                t6.c cVar = null;
                UserAvatarActivity userAvatarActivity = this.f1965b;
                switch (i62) {
                    case 0:
                        int i10 = UserAvatarActivity.V;
                        userAvatarActivity.finish();
                        break;
                    case 1:
                        int i11 = UserAvatarActivity.V;
                        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(userAvatarActivity), null, null, new pb(userAvatarActivity, cVar, 0), 3);
                        break;
                    default:
                        int i12 = UserAvatarActivity.V;
                        j5.c.e(userAvatarActivity, d0.b.H(userAvatarActivity), null);
                        break;
                }
            }
        });
        final int i10 = 2;
        if (z0().f2184e.getValue() != null) {
            Object value = z0().f2184e.getValue();
            value.getClass();
            if (((w2) value).d()) {
                y02.f9588b.setOnClickListener(new View.OnClickListener(this) { // from class: c4.ob

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ UserAvatarActivity f1965b;

                    {
                        this.f1965b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i62 = i10;
                        t6.c cVar = null;
                        UserAvatarActivity userAvatarActivity = this.f1965b;
                        switch (i62) {
                            case 0:
                                int i102 = UserAvatarActivity.V;
                                userAvatarActivity.finish();
                                break;
                            case 1:
                                int i11 = UserAvatarActivity.V;
                                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(userAvatarActivity), null, null, new pb(userAvatarActivity, cVar, 0), 3);
                                break;
                            default:
                                int i12 = UserAvatarActivity.V;
                                j5.c.e(userAvatarActivity, d0.b.H(userAvatarActivity), null);
                                break;
                        }
                    }
                });
            }
        }
        int i11 = getResources().getDisplayMetrics().widthPixels;
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131166251);
        int i12 = 6;
        while (true) {
            if ((i11 - ((i12 + 1) * dimensionPixelSize)) / i12 > getResources().getDimensionPixelSize(2131165366)) {
                break;
            }
            i12--;
            if (i12 <= 0) {
                i12 = 1;
                break;
            }
        }
        this.S = (i11 - ((i12 + 1) * dimensionPixelSize)) / i12;
        recyclerView.setLayoutManager(new GridLayoutManager(this, i12));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView.setItemAnimator(defaultItemAnimator);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, 0, false));
        recyclerView2.addItemDecoration(new l(this));
        recyclerView2.setItemAnimator(defaultItemAnimator);
        t6.c cVar = null;
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new g(this, cVar, 8), 3);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new pb(this, cVar, i6), 2);
    }

    public final t4.a1 y0() {
        return (t4.a1) this.O.getValue();
    }

    public final ub z0() {
        return (ub) this.P.getValue();
    }
}
