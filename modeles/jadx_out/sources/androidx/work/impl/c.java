package androidx.work.impl;

import android.R;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.work.WorkerParameters;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.uptodown.activities.UserDeviceDetailsActivity;
import g4.b0;
import g4.q0;
import g4.s0;
import java.util.ArrayList;
import l7.u;
import m8.q;
import x4.z2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f557a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f558b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f559l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f560m;

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, int i) {
        this.f557a = i;
        this.f558b = obj;
        this.f559l = obj2;
        this.f560m = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f557a;
        Object obj = this.f560m;
        Object obj2 = this.f559l;
        Object obj3 = this.f558b;
        switch (i) {
            case 0:
                ((Processor) obj3).lambda$startWork$1((m1.b) obj2, (WorkerWrapper) obj);
                return;
            case 1:
                WorkLauncherImpl.startWork$lambda$0((WorkLauncherImpl) obj3, (StartStopToken) obj2, (WorkerParameters.RuntimeExtras) obj);
                return;
            case 2:
                z2 z2Var = (z2) obj3;
                EditText editText = (EditText) ((q) obj2).f7781l;
                UserDeviceDetailsActivity userDeviceDetailsActivity = (UserDeviceDetailsActivity) obj;
                int i6 = UserDeviceDetailsActivity.T;
                String str = z2Var.f11483l;
                if (str != null && str.length() != 0) {
                    editText.requestFocus();
                    editText.setText(z2Var.f11483l);
                    editText.selectAll();
                }
                userDeviceDetailsActivity.showKeyboard(editText);
                return;
            case 3:
                s0 s0Var = (s0) obj3;
                String str2 = (String) obj2;
                String str3 = (String) obj;
                s0Var.E();
                str2.getClass();
                int i10 = 1;
                if (!u.k0(str2, ".apk", true) && !u.k0(str2, ".xapk", true) && !u.k0(str2, ".apks", true) && !u.k0(str2, ".apkm", true) && !u.k0(str2, ".zip", true)) {
                    s0Var.i(s0Var.getString(2131952271) + str2 + " " + str3);
                    return;
                }
                s0Var.E();
                View inflate = View.inflate(s0Var, 2131558525, null);
                View findViewById = inflate.findViewById(2131364211);
                findViewById.getClass();
                TextView textView = (TextView) findViewById;
                textView.setTypeface(f4.c.f4882w);
                textView.setText(str2);
                View findViewById2 = inflate.findViewById(2131363907);
                findViewById2.getClass();
                TextView textView2 = (TextView) findViewById2;
                textView2.setTypeface(f4.c.f4882w);
                textView2.setOnClickListener(new b0(i10, s0Var, str2));
                View findViewById3 = inflate.findViewById(2131363688);
                findViewById3.getClass();
                TextView textView3 = (TextView) findViewById3;
                textView3.setTypeface(f4.c.f4882w);
                textView3.setText(s0Var.getString(R.string.ok));
                textView3.setOnClickListener(new q0(s0Var, 2));
                s0Var.G(inflate);
                return;
            case 4:
                j1.i iVar = (j1.i) obj;
                try {
                    ((FirebaseMessagingService) obj3).b((Intent) obj2);
                    return;
                } finally {
                    iVar.a(null);
                }
            default:
                ((z3.f) obj3).loadUrl("javascript:" + ((String) obj2) + '(' + q6.l.x0((ArrayList) obj, ",", null, null, null, 62) + ')');
                return;
        }
    }
}
