package c4;

import android.widget.LinearLayout;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1505a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1506b;

    public /* synthetic */ d3(int i, MainActivity mainActivity) {
        this.f1505a = i;
        this.f1506b = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1505a;
        MainActivity mainActivity = this.f1506b;
        switch (i) {
            case 0:
                LinearLayout linearLayout = (LinearLayout) mainActivity.findViewById(2131362622);
                if (linearLayout != null && linearLayout.getVisibility() == 0) {
                    mainActivity.k1();
                    break;
                }
                break;
            default:
                int i6 = MainActivity.G0;
                mainActivity.m1();
                break;
        }
    }
}
