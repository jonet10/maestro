package g4;

import android.R;
import android.net.nsd.NsdServiceInfo;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class p0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5241a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0 f5242b;

    public /* synthetic */ p0(s0 s0Var, int i) {
        this.f5241a = i;
        this.f5242b = s0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView;
        NsdServiceInfo nsdServiceInfo;
        int i = this.f5241a;
        String str = null;
        s0 s0Var = this.f5242b;
        switch (i) {
            case 0:
                s0Var.C();
                TextView textView2 = s0Var.B;
                if (textView2 != null) {
                    textView2.setText(s0Var.getString(2131952580));
                }
                m4.g gVar = f4.c.f4884y;
                if (gVar != null && (nsdServiceInfo = gVar.f) != null) {
                    str = nsdServiceInfo.getServiceName();
                }
                if (str != null && (textView = s0Var.C) != null) {
                    textView.setText(str.substring(0, l7.m.y0(str, "_d:_", 0, false, 6)));
                }
                ProgressBar progressBar = s0Var.f5258z;
                if (progressBar != null) {
                    progressBar.setIndeterminate(false);
                    break;
                }
                break;
            default:
                s0Var.E();
                s0Var.E();
                View inflate = View.inflate(s0Var, 2131558525, null);
                View findViewById = inflate.findViewById(2131364211);
                findViewById.getClass();
                TextView textView3 = (TextView) findViewById;
                textView3.setTypeface(f4.c.f4882w);
                textView3.setText(s0Var.getString(2131952411));
                View findViewById2 = inflate.findViewById(2131363907);
                findViewById2.getClass();
                ((TextView) findViewById2).setVisibility(8);
                View findViewById3 = inflate.findViewById(2131363688);
                findViewById3.getClass();
                TextView textView4 = (TextView) findViewById3;
                textView4.setTypeface(f4.c.f4882w);
                textView4.setText(s0Var.getString(R.string.ok));
                textView4.setOnClickListener(new q0(s0Var, 4));
                s0Var.G(inflate);
                break;
        }
    }
}
