package androidx.leanback.preference;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.Fragment;
import androidx.leanback.widget.VerticalGridView;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceRecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class BaseLeanbackPreferenceFragmentCompat extends PreferenceFragmentCompat {
    private Context mThemedContext;

    @Override // androidx.preference.PreferenceFragmentCompat
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Fragment getCallbackFragment() {
        return getParentFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (this.mThemedContext == null && getActivity() != null) {
            TypedValue typedValue = new TypedValue();
            getActivity().getTheme().resolveAttribute(androidx.preference.R.attr.preferenceTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i == 0) {
                i = R.style.PreferenceThemeOverlayLeanback;
            }
            this.mThemedContext = new ContextThemeWrapper(super.getContext(), i);
        }
        return this.mThemedContext;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        VerticalGridView verticalGridView = (VerticalGridView) layoutInflater.inflate(R.layout.leanback_preferences_list, viewGroup, false);
        verticalGridView.setWindowAlignment(3);
        verticalGridView.setFocusScrollStrategy(0);
        verticalGridView.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(verticalGridView));
        return verticalGridView;
    }
}
