package com.uptodown.core.activities;

import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.inputmethod.a;
import g4.b;
import j$.util.concurrent.ConcurrentHashMap;
import n4.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ConfirmationIntentWrapperActivity extends AppCompatActivity {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f3374n = 0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f3375a;

    /* renamed from: b, reason: collision with root package name */
    public int f3376b = -1;

    /* renamed from: l, reason: collision with root package name */
    public b f3377l;

    /* renamed from: m, reason: collision with root package name */
    public final ActivityResultLauncher f3378m;

    public ConfirmationIntentWrapperActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 19));
        registerForActivityResult.getClass();
        this.f3378m = registerForActivityResult;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3376b = getIntent().getIntExtra("com.uptodown.sapk.session_id", -1);
        this.f3377l = new b();
        PackageInstaller packageInstaller = getPackageManager().getPackageInstaller();
        b bVar = this.f3377l;
        bVar.getClass();
        packageInstaller.registerSessionCallback(bVar);
        Intent intent = getIntent();
        intent.getClass();
        try {
            this.f3378m.launch((Intent) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) intent.getParcelableExtra("com.uptodown.sapk.confirmation_intent", Intent.class) : intent.getParcelableExtra("com.uptodown.sapk.confirmation_intent")));
        } catch (Exception e10) {
            e10.printStackTrace();
            ConcurrentHashMap concurrentHashMap = h.f7966c;
            d0.b.x(this.f3376b, false);
            this.f3375a = true;
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        b bVar = this.f3377l;
        if (bVar != null) {
            try {
                getPackageManager().getPackageInstaller().unregisterSessionCallback(bVar);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        if (!this.f3375a) {
            ConcurrentHashMap concurrentHashMap = h.f7966c;
            d0.b.x(this.f3376b, true);
            f4.a.f4869a.a();
        }
        super.onDestroy();
    }
}
