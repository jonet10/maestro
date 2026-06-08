package c4;

import android.content.Intent;
import android.view.View;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.WishlistActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class j7 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1761a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f1762b;

    public /* synthetic */ j7(PublicProfileActivity publicProfileActivity, int i) {
        this.f1761a = i;
        this.f1762b = publicProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1761a;
        PublicProfileActivity publicProfileActivity = this.f1762b;
        switch (i) {
            case 0:
                int i6 = PublicProfileActivity.R;
                publicProfileActivity.finish();
                break;
            case 1:
                int i10 = PublicProfileActivity.R;
                float f = UptodownApp.I;
                if (b4.d.t() && publicProfileActivity.T()) {
                    publicProfileActivity.startActivity(new Intent(publicProfileActivity, (Class<?>) FeedActivity.class), b4.d.a(publicProfileActivity));
                    break;
                }
                break;
            case 2:
                int i11 = PublicProfileActivity.R;
                publicProfileActivity.setResult(1);
                publicProfileActivity.finish();
                break;
            case 3:
                int i12 = PublicProfileActivity.R;
                publicProfileActivity.setResult(1);
                publicProfileActivity.finish();
                break;
            case 4:
                if (publicProfileActivity.T()) {
                    publicProfileActivity.startActivity(new Intent(publicProfileActivity, (Class<?>) WishlistActivity.class));
                    break;
                }
                break;
            default:
                int i13 = PublicProfileActivity.R;
                publicProfileActivity.setResult(1);
                publicProfileActivity.finish();
                break;
        }
    }
}
