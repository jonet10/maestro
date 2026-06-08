package androidx.core.content.res;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.uptodown.core.activities.InstallerActivity;
import g4.k0;
import g4.s0;
import o7.c0;
import o7.m0;
import v7.d;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f342a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f343b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f344l;

    public /* synthetic */ a(Object obj, int i, int i6) {
        this.f342a = i6;
        this.f344l = obj;
        this.f343b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f342a;
        int i6 = this.f343b;
        Object obj = this.f344l;
        switch (i) {
            case 0:
                ((ResourcesCompat.FontCallback) obj).lambda$callbackFailAsync$1(i6);
                break;
            case 1:
                ((SideSheetBehavior) obj).lambda$setState$0(i6);
                break;
            case 2:
                InstallerActivity installerActivity = (InstallerActivity) obj;
                if (!installerActivity.f3398e0) {
                    int i10 = 0;
                    if (installerActivity.X == null) {
                        e eVar = m0.f8288a;
                        installerActivity.X = c0.s(c0.b(d.f10884a), null, null, new k0(installerActivity, null, i10), 3);
                    }
                    TextView textView = installerActivity.N;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    LinearLayout linearLayout = installerActivity.a0;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                    TextView textView2 = installerActivity.L;
                    if (textView2 != null) {
                        textView2.setText(installerActivity.getString(2131952703, Integer.valueOf(i6)));
                    }
                    ProgressBar progressBar = installerActivity.f3403y;
                    if (progressBar != null) {
                        progressBar.setIndeterminate(false);
                    }
                    ProgressBar progressBar2 = installerActivity.f3403y;
                    if (progressBar2 != null) {
                        progressBar2.setProgress(i6);
                    }
                    installerActivity.getWindow().addFlags(128);
                    ImageView imageView = installerActivity.P;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        break;
                    }
                }
                break;
            default:
                s0 s0Var = (s0) obj;
                ProgressBar progressBar3 = s0Var.f5258z;
                if (progressBar3 != null) {
                    progressBar3.setProgress(i6);
                }
                TextView textView3 = s0Var.f5257y;
                if (textView3 != null) {
                    textView3.setText(i6 + "%");
                    break;
                }
                break;
        }
    }
}
