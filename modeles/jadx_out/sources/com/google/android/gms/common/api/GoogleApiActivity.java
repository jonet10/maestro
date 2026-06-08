package com.google.android.gms.common.api;

import a4.c0;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.l;
import com.google.android.gms.common.annotation.KeepName;
import h0.b;
import j0.e;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@KeepName
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2465b = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f2466a = 0;

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i6, Intent intent) {
        super.onActivityResult(i, i6, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f2466a = 0;
            setResult(i6, intent);
            if (booleanExtra) {
                e d10 = e.d(this);
                if (i6 == -1) {
                    c0 c0Var = d10.v;
                    c0Var.sendMessage(c0Var.obtainMessage(3));
                } else if (i6 == 0) {
                    d10.e(new b(null, null, 13), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i == 2) {
            this.f2466a = 0;
            setResult(i6, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f2466a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        GoogleApiActivity googleApiActivity;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f2466a = bundle.getInt("resolution");
        }
        if (this.f2466a == 1) {
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
            return;
        }
        if (pendingIntent == null) {
            y.g(num);
            h0.e.f5407d.c(this, num.intValue(), this);
            this.f2466a = 1;
            return;
        }
        try {
            googleApiActivity = this;
            try {
                googleApiActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                googleApiActivity.f2466a = 1;
            } catch (ActivityNotFoundException e10) {
                e = e10;
                if (extras.getBoolean("notify_manager", true)) {
                    e.d(this).e(new b(null, null, 22), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String w2 = l.w("Activity not found while launching ", pendingIntent.toString(), ".");
                    if (Build.FINGERPRINT.contains("generic")) {
                        w2 = w2.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                    Log.e("GoogleApiActivity", w2, e);
                }
                googleApiActivity.f2466a = 1;
                finish();
            } catch (IntentSender.SendIntentException e11) {
                e = e11;
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                finish();
            }
        } catch (ActivityNotFoundException e12) {
            e = e12;
            googleApiActivity = this;
        } catch (IntentSender.SendIntentException e13) {
            e = e13;
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f2466a);
        super.onSaveInstanceState(bundle);
    }
}
