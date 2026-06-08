package g4;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c0 implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5143a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5144b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Serializable f5145l;

    public /* synthetic */ c0(Object obj, Serializable serializable, int i) {
        this.f5143a = i;
        this.f5144b = obj;
        this.f5145l = serializable;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i6 = this.f5143a;
        Serializable serializable = this.f5145l;
        Object obj = this.f5144b;
        switch (i6) {
            case 0:
                InstallerActivity installerActivity = (InstallerActivity) obj;
                int i10 = InstallerActivity.f3394j0;
                h4.a aVar = new h4.a(installerActivity);
                aVar.i(true);
                aVar.e("install_apk_as_root_system", true);
                installerActivity.H(installerActivity, (ArrayList) serializable);
                break;
            case 1:
                InstallerActivity installerActivity2 = (InstallerActivity) obj;
                int i11 = InstallerActivity.f3394j0;
                h4.a aVar2 = new h4.a(installerActivity2);
                aVar2.i(true);
                aVar2.e("install_apk_as_root_system", false);
                installerActivity2.H(installerActivity2, (ArrayList) serializable);
                break;
            default:
                TvOldVersionsFragment tvOldVersionsFragment = (TvOldVersionsFragment) obj;
                String str = (String) serializable;
                dialogInterface.getClass();
                dialogInterface.dismiss();
                if (tvOldVersionsFragment.getActivity() != null) {
                    FragmentActivity requireActivity = tvOldVersionsFragment.requireActivity();
                    requireActivity.getClass();
                    str.getClass();
                    Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str)));
                    intent.addFlags(268435456);
                    requireActivity.startActivity(intent);
                    break;
                }
                break;
        }
    }
}
