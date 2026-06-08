package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.UptodownApp;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.RecommendedActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class z7 implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2398a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecommendedActivity f2399b;

    public /* synthetic */ z7(RecommendedActivity recommendedActivity, int i) {
        this.f2398a = i;
        this.f2399b = recommendedActivity;
    }

    @Override // d7.a
    public final Object invoke() {
        int i = this.f2398a;
        p6.x xVar = p6.x.f8463a;
        RecommendedActivity recommendedActivity = this.f2399b;
        switch (i) {
            case 0:
                int i6 = RecommendedActivity.f3338g0;
                recommendedActivity.finish();
                return xVar;
            case 1:
                int i10 = RecommendedActivity.f3338g0;
                View inflate = recommendedActivity.getLayoutInflater().inflate(2131558799, (ViewGroup) null, false);
                int i11 = 2131362811;
                View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362811);
                if (findChildViewById != null) {
                    i11 = 2131363344;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363344);
                    if (recyclerView != null) {
                        i11 = 2131363368;
                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(inflate, 2131363368);
                        if (switchCompat != null) {
                            i11 = 2131363561;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363561);
                            if (toolbar != null) {
                                i11 = 2131363863;
                                TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363863);
                                if (textView != null) {
                                    i11 = 2131363967;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363967);
                                    if (textView2 != null) {
                                        i11 = 2131364088;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364088);
                                        if (textView3 != null) {
                                            i11 = 2131364410;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364410);
                                            if (textView4 != null) {
                                                return new t4.m0((RelativeLayout) inflate, findChildViewById, recyclerView, switchCompat, toolbar, textView, textView2, textView3, textView4);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i11)));
                return null;
            default:
                int i12 = RecommendedActivity.f3338g0;
                Intent intent = new Intent(recommendedActivity, (Class<?>) LoginActivity.class);
                ActivityResultLauncher activityResultLauncher = recommendedActivity.f3342e0;
                float f = UptodownApp.I;
                activityResultLauncher.launch(intent, b4.d.b(recommendedActivity));
                AlertDialog alertDialog = recommendedActivity.F;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                return xVar;
        }
    }
}
