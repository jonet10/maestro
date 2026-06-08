package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.UptodownApp;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.WishlistActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class pd implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2000a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WishlistActivity f2001b;

    public /* synthetic */ pd(WishlistActivity wishlistActivity, int i) {
        this.f2000a = i;
        this.f2001b = wishlistActivity;
    }

    @Override // d7.a
    public final Object invoke() {
        int i = this.f2000a;
        p6.x xVar = p6.x.f8463a;
        WishlistActivity wishlistActivity = this.f2001b;
        switch (i) {
            case 0:
                int i6 = WishlistActivity.f3367g0;
                View inflate = wishlistActivity.getLayoutInflater().inflate(2131558888, (ViewGroup) null, false);
                int i10 = 2131362825;
                View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362825);
                if (findChildViewById != null) {
                    i10 = 2131363363;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363363);
                    if (recyclerView != null) {
                        i10 = 2131363577;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363577);
                        if (toolbar != null) {
                            i10 = 2131363864;
                            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363864);
                            if (textView != null) {
                                i10 = 2131364090;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364090);
                                if (textView2 != null) {
                                    i10 = 2131364426;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364426);
                                    if (textView3 != null) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
                break;
            case 1:
                int i11 = WishlistActivity.f3367g0;
                Intent intent = new Intent(wishlistActivity, (Class<?>) LoginActivity.class);
                ActivityResultLauncher activityResultLauncher = wishlistActivity.f3372f0;
                float f = UptodownApp.I;
                activityResultLauncher.launch(intent, b4.d.b(wishlistActivity));
                AlertDialog alertDialog = wishlistActivity.F;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            default:
                int i12 = WishlistActivity.f3367g0;
                wishlistActivity.finish();
                break;
        }
        return xVar;
    }
}
