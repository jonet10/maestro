package com.uptodown.activities;

import a3.d;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.s;
import c4.e;
import c4.i9;
import c4.j9;
import c4.l1;
import c4.l9;
import c4.w4;
import c4.w6;
import com.uptodown.UptodownApp;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.RollbackActivity;
import e4.j0;
import f4.c;
import kotlin.jvm.internal.y;
import l5.f;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import t4.s0;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class RollbackActivity extends w4 {

    /* renamed from: f0, reason: collision with root package name */
    public static final /* synthetic */ int f3344f0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public j0 f3346c0;

    /* renamed from: e0, reason: collision with root package name */
    public final ActivityResultLauncher f3348e0;
    public final String Z = "RollbackActivity";
    public final m a0 = new m(new w6(this, 5));

    /* renamed from: b0, reason: collision with root package name */
    public final ViewModelLazy f3345b0 = new ViewModelLazy(y.a(l9.class), new j9(this, 0), new i9(this), new j9(this, 1));

    /* renamed from: d0, reason: collision with root package name */
    public final d f3347d0 = new d(this, 15);

    public RollbackActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 10));
        registerForActivityResult.getClass();
        this.f3348e0 = registerForActivityResult;
    }

    @Override // c4.w4
    public final String F0() {
        return this.Z;
    }

    public final s0 N0() {
        return (s0) this.a0.getValue();
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = N0().f10108a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            N0().f10111m.setNavigationIcon(drawable);
            N0().f10111m.setNavigationContentDescription(getString(2131951735));
        }
        Toolbar toolbar = N0().f10111m;
        boolean z9 = false;
        z9 = false;
        final int i = z9 ? 1 : 0;
        toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: c4.h9

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RollbackActivity f1690b;

            {
                this.f1690b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i6 = i;
                RollbackActivity rollbackActivity = this.f1690b;
                switch (i6) {
                    case 0:
                        int i10 = RollbackActivity.f3344f0;
                        rollbackActivity.finish();
                        break;
                    default:
                        int i11 = RollbackActivity.f3344f0;
                        Intent intent = new Intent(rollbackActivity.getApplicationContext(), (Class<?>) GdprPrivacySettings.class);
                        ActivityResultLauncher activityResultLauncher = rollbackActivity.f3348e0;
                        float f = UptodownApp.I;
                        activityResultLauncher.launch(intent, b4.d.b(rollbackActivity));
                        break;
                }
            }
        });
        N0().f10115q.setTypeface(c.f4882w);
        final int i6 = 1;
        N0().f10110l.setLayoutManager(new LinearLayoutManager(this, 1, false));
        N0().f10110l.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(2131166251);
        N0().f10110l.addItemDecoration(new f(dimension, dimension));
        N0().f10113o.setTypeface(c.f4883x);
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("gdpr_tracking_allowed")) {
                z9 = sharedPreferences.getBoolean("gdpr_tracking_allowed", false);
            }
        } catch (Exception unused) {
        }
        if (!z9) {
            N0().f10113o.setText(getString(2131952279));
        }
        N0().f10114p.setTypeface(c.f4883x);
        N0().f10112n.setTypeface(c.f4883x);
        N0().f10112n.setOnClickListener(new View.OnClickListener(this) { // from class: c4.h9

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RollbackActivity f1690b;

            {
                this.f1690b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i6;
                RollbackActivity rollbackActivity = this.f1690b;
                switch (i62) {
                    case 0:
                        int i10 = RollbackActivity.f3344f0;
                        rollbackActivity.finish();
                        break;
                    default:
                        int i11 = RollbackActivity.f3344f0;
                        Intent intent = new Intent(rollbackActivity.getApplicationContext(), (Class<?>) GdprPrivacySettings.class);
                        ActivityResultLauncher activityResultLauncher = rollbackActivity.f3348e0;
                        float f = UptodownApp.I;
                        activityResultLauncher.launch(intent, b4.d.b(rollbackActivity));
                        break;
                }
            }
        });
        N0().f10109b.setOnClickListener(new e(20));
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new s(this, (t6.c) null, 15), 2);
    }

    @Override // c4.k0, g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        l9 l9Var = (l9) this.f3345b0.getValue();
        l9Var.getClass();
        a0 viewModelScope = ViewModelKt.getViewModelScope(l9Var);
        v7.e eVar = m0.f8288a;
        c0.s(viewModelScope, v7.d.f10884a, null, new l1(true, l9Var, this, null, 2), 2);
    }
}
