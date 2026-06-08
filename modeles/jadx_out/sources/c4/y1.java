package c4;

import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import com.uptodown.UptodownApp;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.WishlistActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class y1 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2330a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ListsActivity f2331b;

    public /* synthetic */ y1(ListsActivity listsActivity, int i) {
        this.f2330a = i;
        this.f2331b = listsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f2330a;
        ListsActivity listsActivity = this.f2331b;
        switch (i) {
            case 0:
                int i6 = ListsActivity.S;
                listsActivity.finish();
                break;
            case 1:
                if (listsActivity.T()) {
                    Intent intent = new Intent(listsActivity, (Class<?>) WishlistActivity.class);
                    ActivityResultLauncher activityResultLauncher = listsActivity.R;
                    float f = UptodownApp.I;
                    activityResultLauncher.launch(intent, b4.d.b(listsActivity));
                    break;
                }
                break;
            case 2:
                if (listsActivity.T()) {
                    Intent intent2 = new Intent(listsActivity, (Class<?>) RecommendedActivity.class);
                    ActivityResultLauncher activityResultLauncher2 = listsActivity.R;
                    float f10 = UptodownApp.I;
                    activityResultLauncher2.launch(intent2, b4.d.b(listsActivity));
                    break;
                }
                break;
            default:
                if (listsActivity.T()) {
                    Intent intent3 = new Intent(listsActivity, (Class<?>) PreregistrationActivity.class);
                    ActivityResultLauncher activityResultLauncher3 = listsActivity.R;
                    float f11 = UptodownApp.I;
                    activityResultLauncher3.launch(intent3, b4.d.b(listsActivity));
                    break;
                }
                break;
        }
    }
}
