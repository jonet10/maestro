package g5;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5298a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x4.r f5299b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f5300l;

    public /* synthetic */ c(TvAppDetailFragment tvAppDetailFragment, x4.r rVar) {
        this.f5300l = tvAppDetailFragment;
        this.f5299b = rVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i6 = this.f5298a;
        TvAppDetailFragment tvAppDetailFragment = this.f5300l;
        x4.r rVar = this.f5299b;
        switch (i6) {
            case 0:
                dialogInterface.getClass();
                tvAppDetailFragment.i(rVar);
                dialogInterface.dismiss();
                break;
            default:
                dialogInterface.getClass();
                dialogInterface.dismiss();
                File g = rVar.g();
                if (g != null) {
                    float f = UptodownApp.I;
                    FragmentActivity requireActivity = tvAppDetailFragment.requireActivity();
                    requireActivity.getClass();
                    b4.d.r(requireActivity, g);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ c(x4.r rVar, TvAppDetailFragment tvAppDetailFragment) {
        this.f5299b = rVar;
        this.f5300l = tvAppDetailFragment;
    }
}
