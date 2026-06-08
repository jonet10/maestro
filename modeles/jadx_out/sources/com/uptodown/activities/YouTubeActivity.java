package com.uptodown.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c4.b;
import c4.k0;
import c4.w6;
import c4.wd;
import c4.xd;
import k9.c;
import p6.m;
import t4.i1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class YouTubeActivity extends k0 {
    public static final /* synthetic */ int Q = 0;
    public final m O = new m(new w6(this, 16));
    public final b P = new b(this, 7);

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f9893a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Window window = getWindow();
        window.getClass();
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                insetsController.setSystemBarsBehavior(2);
            }
        } else {
            window.getDecorView().setSystemUiVisibility(4);
            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        }
        getOnBackPressedDispatcher().addCallback(this, this.P);
        Intent intent = getIntent();
        String string = (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("id_youtube")) ? null : extras.getString("id_youtube");
        if (string == null || string.length() == 0) {
            finish();
            return;
        }
        c cVar = new c(this);
        cVar.d(1, "controls");
        cVar.d(1, "fs");
        y0().f9895l.a(new xd(0, this, string), new k9.b(cVar.f7009b));
        y0().f9895l.f3284a.add(new wd(this, 0));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        y0().f9895l.b();
    }

    public final i1 y0() {
        return (i1) this.O.getValue();
    }
}
