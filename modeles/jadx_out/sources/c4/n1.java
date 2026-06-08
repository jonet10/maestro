package c4;

import android.content.SharedPreferences;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Gallery;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class n1 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1887a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Gallery f1888b;

    public /* synthetic */ n1(Gallery gallery, int i) {
        this.f1887a = i;
        this.f1888b = gallery;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1887a;
        Gallery gallery = this.f1888b;
        switch (i) {
            case 0:
                gallery.Q.handleOnBackPressed();
                break;
            default:
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    int i6 = Gallery.R;
                    boolean z9 = true;
                    if (gallery.y0().f10010l.getVisibility() != 0) {
                        RelativeLayout relativeLayout = gallery.y0().f10010l;
                        try {
                            SharedPreferences sharedPreferences = gallery.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences.contains("animations")) {
                                z9 = sharedPreferences.getBoolean("animations", true);
                            }
                        } catch (Exception unused) {
                        }
                        if (!z9) {
                            relativeLayout.setVisibility(0);
                            break;
                        } else {
                            float f10 = UptodownApp.I;
                            relativeLayout.startAnimation(AnimationUtils.loadAnimation(gallery, 2130772031));
                            relativeLayout.setVisibility(0);
                            break;
                        }
                    } else {
                        RelativeLayout relativeLayout2 = gallery.y0().f10010l;
                        try {
                            SharedPreferences sharedPreferences2 = gallery.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences2.contains("animations")) {
                                z9 = sharedPreferences2.getBoolean("animations", true);
                            }
                        } catch (Exception unused2) {
                        }
                        if (!z9) {
                            relativeLayout2.setVisibility(8);
                            break;
                        } else {
                            float f11 = UptodownApp.I;
                            relativeLayout2.startAnimation(AnimationUtils.loadAnimation(gallery, 2130772036));
                            relativeLayout2.setVisibility(8);
                            break;
                        }
                    }
                }
                break;
        }
    }
}
