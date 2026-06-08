package androidx.leanback.preference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Deprecated
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class LeanbackPreferenceFragment extends BaseLeanbackPreferenceFragment {
    public LeanbackPreferenceFragment() {
        LeanbackPreferenceFragmentTransitionHelperApi21.addTransitions(this);
    }

    @Override // androidx.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = LayoutInflater.from(onCreateView.getContext()).inflate(R.layout.leanback_preference_fragment, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R.id.main_frame)).addView(onCreateView);
        return inflate;
    }

    @Override // androidx.preference.PreferenceFragment, android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setTitle(getPreferenceScreen().getTitle());
    }

    public void setTitle(CharSequence charSequence) {
        View view = getView();
        TextView textView = view == null ? null : (TextView) view.findViewById(R.id.decor_title);
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
