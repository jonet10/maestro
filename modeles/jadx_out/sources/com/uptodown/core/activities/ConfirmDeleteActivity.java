package com.uptodown.core.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import c4.d;
import g4.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ConfirmDeleteActivity extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3373a = 0;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558458);
        String stringExtra = getIntent().getStringExtra("realPath");
        int intExtra = getIntent().getIntExtra("notificationId", -1);
        ((TextView) findViewById(2131363721)).setText(getString(2131951933, stringExtra));
        ((TextView) findViewById(2131363691)).setOnClickListener(new d(this, 18));
        ((TextView) findViewById(2131363759)).setOnClickListener(new a(intExtra, stringExtra, 0, this));
    }
}
