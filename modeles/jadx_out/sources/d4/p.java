package d4;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.tv.preferences.TvPrivacyPreferences;
import com.uptodown.tv.ui.activity.TvMainActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class p implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3594a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3595b;

    public /* synthetic */ p(Object obj, int i) {
        this.f3594a = i;
        this.f3595b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i6 = this.f3594a;
        Object obj = this.f3595b;
        switch (i6) {
            case 0:
                PreferencesActivity preferencesActivity = (PreferencesActivity) obj;
                int i10 = PreferencesActivity.T;
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", preferencesActivity.getPackageName());
                if (intent.resolveActivity(preferencesActivity.getPackageManager()) != null) {
                    preferencesActivity.startActivityForResult(intent, 646);
                }
                dialogInterface.dismiss();
                break;
            case 1:
                TvMainActivity tvMainActivity = (TvMainActivity) obj;
                int i11 = TvMainActivity.f3407p;
                dialogInterface.dismiss();
                tvMainActivity.f3411o.launch(new Intent(tvMainActivity, (Class<?>) TvPrivacyPreferences.class));
                break;
            case 2:
                TvAppDetailFragment tvAppDetailFragment = (TvAppDetailFragment) obj;
                dialogInterface.dismiss();
                tvAppDetailFragment.startActivity(new Intent(tvAppDetailFragment.requireActivity(), (Class<?>) TvPrivacyPreferences.class));
                break;
            default:
                FragmentActivity fragmentActivity = (FragmentActivity) obj;
                dialogInterface.dismiss();
                if (!(fragmentActivity instanceof AppDetailActivity)) {
                    if (!(fragmentActivity instanceof MainActivity)) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, (Class<?>) GdprPrivacySettings.class));
                        break;
                    } else {
                        ((MainActivity) fragmentActivity).A0.launch(new Intent(fragmentActivity, (Class<?>) GdprPrivacySettings.class));
                        break;
                    }
                } else {
                    ((AppDetailActivity) fragmentActivity).V.launch(new Intent(fragmentActivity, (Class<?>) GdprPrivacySettings.class));
                    break;
                }
        }
    }
}
