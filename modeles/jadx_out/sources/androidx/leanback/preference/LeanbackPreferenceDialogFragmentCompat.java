package androidx.leanback.preference;

import a4.x;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.preference.DialogPreference;
import androidx.privacysandbox.ads.adservices.customaudience.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class LeanbackPreferenceDialogFragmentCompat extends Fragment {
    public static final String ARG_KEY = "key";
    private DialogPreference mPreference;

    public LeanbackPreferenceDialogFragmentCompat() {
        LeanbackPreferenceFragmentTransitionHelperApi21.addTransitions(this);
    }

    public DialogPreference getPreference() {
        if (this.mPreference == null) {
            this.mPreference = (DialogPreference) ((DialogPreference.TargetFragment) getTargetFragment()).findPreference(getArguments().getString("key"));
        }
        return this.mPreference;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment targetFragment = getTargetFragment();
        if (targetFragment instanceof DialogPreference.TargetFragment) {
            return;
        }
        a.i(x.i("Target fragment ", targetFragment, " must implement TargetFragment interface"));
    }
}
