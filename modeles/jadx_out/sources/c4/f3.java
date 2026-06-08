package c4;

import android.content.SharedPreferences;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f3 implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1588a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1589b;

    public /* synthetic */ f3(int i, MainActivity mainActivity) {
        this.f1588a = i;
        this.f1589b = mainActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        int i = this.f1588a;
        int i6 = -1;
        boolean z9 = true;
        MainActivity mainActivity = this.f1589b;
        animation.getClass();
        switch (i) {
            case 0:
                ArrayList arrayList = mainActivity.U;
                int i10 = mainActivity.T;
                if (i10 > 0 && i10 < arrayList.size()) {
                    i6 = (-1) + mainActivity.T;
                    mainActivity.T = i6;
                }
                if (i6 < 0 || i6 >= arrayList.size()) {
                    ((x4.e3) arrayList.get(mainActivity.T)).a().setVisibility(8);
                    mainActivity.finish();
                } else {
                    RelativeLayout relativeLayout = mainActivity.W;
                    if (relativeLayout != null) {
                        relativeLayout.removeAllViews();
                    }
                    RelativeLayout a8 = ((x4.e3) arrayList.get(i6)).a();
                    RelativeLayout relativeLayout2 = mainActivity.W;
                    if (relativeLayout2 != null) {
                        relativeLayout2.addView(a8);
                    }
                    float f = UptodownApp.I;
                    try {
                        SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("SettingsPreferences", 0);
                        if (sharedPreferences.contains("animations")) {
                            z9 = sharedPreferences.getBoolean("animations", true);
                        }
                    } catch (Exception unused) {
                    }
                    if (z9) {
                        float f10 = UptodownApp.I;
                        a8.startAnimation(AnimationUtils.loadAnimation(mainActivity, 2130772028));
                        a8.setVisibility(0);
                    } else {
                        a8.setVisibility(0);
                    }
                }
                mainActivity.V = false;
                break;
            case 1:
                ArrayList arrayList2 = mainActivity.U;
                int i11 = MainActivity.G0;
                int i12 = mainActivity.T;
                if (i12 >= 0 && i12 < arrayList2.size() - 1) {
                    i6 = mainActivity.T + 1;
                    mainActivity.T = i6;
                }
                if (i6 >= 0 && i6 < arrayList2.size()) {
                    Object obj = arrayList2.get(i6);
                    obj.getClass();
                    mainActivity.o1((x4.e3) obj);
                    if (((x4.e3) arrayList2.get(mainActivity.T)).f11141a == 2 && ((x4.e3) arrayList2.get(0)).f11141a == 1) {
                        ((x4.e3) arrayList2.get(0)).a().removeAllViews();
                        arrayList2.remove(0);
                        mainActivity.T = 0;
                    }
                    mainActivity.v1();
                    break;
                } else {
                    mainActivity.j1();
                    break;
                }
                break;
            case 2:
                FrameLayout frameLayout = mainActivity.f3321t0;
                frameLayout.getClass();
                frameLayout.removeAllViews();
                break;
            case 3:
                FrameLayout frameLayout2 = mainActivity.f3323v0;
                frameLayout2.getClass();
                frameLayout2.removeAllViews();
                mainActivity.f3323v0 = null;
                break;
            default:
                RelativeLayout relativeLayout3 = mainActivity.S;
                if (relativeLayout3 != null) {
                    relativeLayout3.removeAllViews();
                    RelativeLayout relativeLayout4 = mainActivity.S;
                    if (relativeLayout4 != null) {
                        relativeLayout4.setVisibility(8);
                    }
                    mainActivity.S = null;
                }
                mainActivity.i1();
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.f1588a;
        animation.getClass();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i = this.f1588a;
        animation.getClass();
        switch (i) {
            case 0:
                this.f1589b.V = true;
                break;
        }
    }
}
