package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.annotation.CallSuper;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.preference.PreferenceFragmentCompat;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class PreferenceHeaderFragmentCompat extends Fragment implements PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {
    private OnBackPressedCallback onBackPressedCallback;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class InnerOnBackPressedCallback extends OnBackPressedCallback implements SlidingPaneLayout.PanelSlideListener {
        private final PreferenceHeaderFragmentCompat caller;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InnerOnBackPressedCallback(PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat) {
            super(true);
            preferenceHeaderFragmentCompat.getClass();
            this.caller = preferenceHeaderFragmentCompat;
            preferenceHeaderFragmentCompat.getSlidingPaneLayout().addPanelSlideListener(this);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            this.caller.getSlidingPaneLayout().closePane();
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
            view.getClass();
            setEnabled(false);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            view.getClass();
            setEnabled(true);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f) {
            view.getClass();
        }
    }

    private final SlidingPaneLayout buildContentView(LayoutInflater layoutInflater) {
        SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(layoutInflater.getContext());
        slidingPaneLayout.setId(R.id.preferences_sliding_pane_layout);
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(R.id.preferences_header);
        SlidingPaneLayout.LayoutParams layoutParams = new SlidingPaneLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.preferences_header_width), -1);
        layoutParams.weight = getResources().getInteger(R.integer.preferences_header_pane_weight);
        slidingPaneLayout.addView(fragmentContainerView, layoutParams);
        FragmentContainerView fragmentContainerView2 = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView2.setId(R.id.preferences_detail);
        SlidingPaneLayout.LayoutParams layoutParams2 = new SlidingPaneLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.preferences_detail_width), -1);
        layoutParams2.weight = getResources().getInteger(R.integer.preferences_detail_pane_weight);
        slidingPaneLayout.addView(fragmentContainerView2, layoutParams2);
        return slidingPaneLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-10, reason: not valid java name */
    public static final void m82onViewCreated$lambda10(PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat) {
        preferenceHeaderFragmentCompat.getClass();
        OnBackPressedCallback onBackPressedCallback = preferenceHeaderFragmentCompat.onBackPressedCallback;
        onBackPressedCallback.getClass();
        onBackPressedCallback.setEnabled(preferenceHeaderFragmentCompat.getChildFragmentManager().getBackStackEntryCount() == 0);
    }

    private final void openPreferenceHeader(Preference preference) {
        if (preference.getFragment() == null) {
            openPreferenceHeader(preference.getIntent());
            return;
        }
        String fragment = preference.getFragment();
        Fragment instantiate = fragment == null ? null : getChildFragmentManager().getFragmentFactory().instantiate(requireContext().getClassLoader(), fragment);
        if (instantiate != null) {
            instantiate.setArguments(preference.getExtras());
        }
        if (getChildFragmentManager().getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry backStackEntryAt = getChildFragmentManager().getBackStackEntryAt(0);
            backStackEntryAt.getClass();
            getChildFragmentManager().popBackStack(backStackEntryAt.getId(), 1);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        childFragmentManager.getClass();
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        beginTransaction.getClass();
        beginTransaction.setReorderingAllowed(true);
        int i = R.id.preferences_detail;
        instantiate.getClass();
        beginTransaction.replace(i, instantiate);
        if (getSlidingPaneLayout().isOpen()) {
            beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        }
        getSlidingPaneLayout().openPane();
        beginTransaction.commit();
    }

    public final SlidingPaneLayout getSlidingPaneLayout() {
        return (SlidingPaneLayout) requireView();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onAttach(Context context) {
        context.getClass();
        super.onAttach(context);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        parentFragmentManager.getClass();
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        beginTransaction.getClass();
        beginTransaction.setPrimaryNavigationFragment(this);
        beginTransaction.commit();
    }

    public Fragment onCreateInitialDetailFragment() {
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(R.id.preferences_header);
        if (findFragmentById == null) {
            com.google.gson.internal.a.i("null cannot be cast to non-null type androidx.preference.PreferenceFragmentCompat");
            return null;
        }
        PreferenceFragmentCompat preferenceFragmentCompat = (PreferenceFragmentCompat) findFragmentById;
        if (preferenceFragmentCompat.getPreferenceScreen().getPreferenceCount() <= 0) {
            return null;
        }
        int preferenceCount = preferenceFragmentCompat.getPreferenceScreen().getPreferenceCount();
        int i = 0;
        while (true) {
            if (i >= preferenceCount) {
                break;
            }
            int i6 = i + 1;
            Preference preference = preferenceFragmentCompat.getPreferenceScreen().getPreference(i);
            preference.getClass();
            if (preference.getFragment() == null) {
                i = i6;
            } else {
                String fragment = preference.getFragment();
                r2 = fragment != null ? getChildFragmentManager().getFragmentFactory().instantiate(requireContext().getClassLoader(), fragment) : null;
                if (r2 == null) {
                    return r2;
                }
                r2.setArguments(preference.getExtras());
            }
        }
        return r2;
    }

    public abstract PreferenceFragmentCompat onCreatePreferenceHeader();

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        SlidingPaneLayout buildContentView = buildContentView(layoutInflater);
        if (getChildFragmentManager().findFragmentById(R.id.preferences_header) == null) {
            PreferenceFragmentCompat onCreatePreferenceHeader = onCreatePreferenceHeader();
            FragmentManager childFragmentManager = getChildFragmentManager();
            childFragmentManager.getClass();
            FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
            beginTransaction.getClass();
            beginTransaction.setReorderingAllowed(true);
            beginTransaction.add(R.id.preferences_header, onCreatePreferenceHeader);
            beginTransaction.commit();
        }
        buildContentView.setLockMode(3);
        return buildContentView;
    }

    @Override // androidx.preference.PreferenceFragmentCompat.OnPreferenceStartFragmentCallback
    @CallSuper
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference) {
        preferenceFragmentCompat.getClass();
        preference.getClass();
        if (preferenceFragmentCompat.getId() == R.id.preferences_header) {
            openPreferenceHeader(preference);
            return true;
        }
        if (preferenceFragmentCompat.getId() != R.id.preferences_detail) {
            return false;
        }
        FragmentFactory fragmentFactory = getChildFragmentManager().getFragmentFactory();
        ClassLoader classLoader = requireContext().getClassLoader();
        String fragment = preference.getFragment();
        fragment.getClass();
        Fragment instantiate = fragmentFactory.instantiate(classLoader, fragment);
        instantiate.getClass();
        instantiate.setArguments(preference.getExtras());
        FragmentManager childFragmentManager = getChildFragmentManager();
        childFragmentManager.getClass();
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        beginTransaction.getClass();
        beginTransaction.setReorderingAllowed(true);
        beginTransaction.replace(R.id.preferences_detail, instantiate);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onViewCreated(View view, Bundle bundle) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        view.getClass();
        super.onViewCreated(view, bundle);
        this.onBackPressedCallback = new InnerOnBackPressedCallback(this);
        SlidingPaneLayout slidingPaneLayout = getSlidingPaneLayout();
        if (!ViewCompat.isLaidOut(slidingPaneLayout) || slidingPaneLayout.isLayoutRequested()) {
            slidingPaneLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.preference.PreferenceHeaderFragmentCompat$onViewCreated$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
                    view2.getClass();
                    view2.removeOnLayoutChangeListener(this);
                    OnBackPressedCallback onBackPressedCallback = PreferenceHeaderFragmentCompat.this.onBackPressedCallback;
                    onBackPressedCallback.getClass();
                    onBackPressedCallback.setEnabled(PreferenceHeaderFragmentCompat.this.getSlidingPaneLayout().isSlideable() && PreferenceHeaderFragmentCompat.this.getSlidingPaneLayout().isOpen());
                }
            });
        } else {
            OnBackPressedCallback onBackPressedCallback = this.onBackPressedCallback;
            onBackPressedCallback.getClass();
            onBackPressedCallback.setEnabled(getSlidingPaneLayout().isSlideable() && getSlidingPaneLayout().isOpen());
        }
        getChildFragmentManager().addOnBackStackChangedListener(new a(this, 0));
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = ViewTreeOnBackPressedDispatcherOwner.get(view);
        if (onBackPressedDispatcherOwner == null || (onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher()) == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        OnBackPressedCallback onBackPressedCallback2 = this.onBackPressedCallback;
        onBackPressedCallback2.getClass();
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        Fragment onCreateInitialDetailFragment;
        super.onViewStateRestored(bundle);
        if (bundle != null || (onCreateInitialDetailFragment = onCreateInitialDetailFragment()) == null) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        childFragmentManager.getClass();
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        beginTransaction.getClass();
        beginTransaction.setReorderingAllowed(true);
        beginTransaction.replace(R.id.preferences_detail, onCreateInitialDetailFragment);
        beginTransaction.commit();
    }

    private final void openPreferenceHeader(Intent intent) {
        if (intent == null) {
            return;
        }
        startActivity(intent);
    }
}
