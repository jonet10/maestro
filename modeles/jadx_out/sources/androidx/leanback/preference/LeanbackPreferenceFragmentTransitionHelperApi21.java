package androidx.leanback.preference;

import android.annotation.SuppressLint;
import android.app.Fragment;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import androidx.leanback.transition.FadeAndShortSlide;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class LeanbackPreferenceFragmentTransitionHelperApi21 {
    private LeanbackPreferenceFragmentTransitionHelperApi21() {
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void addTransitions(Fragment fragment) {
        FadeAndShortSlide fadeAndShortSlide = new FadeAndShortSlide(GravityCompat.START);
        FadeAndShortSlide fadeAndShortSlide2 = new FadeAndShortSlide(GravityCompat.END);
        fragment.setEnterTransition(fadeAndShortSlide2);
        fragment.setExitTransition(fadeAndShortSlide);
        fragment.setReenterTransition(fadeAndShortSlide);
        fragment.setReturnTransition(fadeAndShortSlide2);
    }

    public static void addTransitions(androidx.fragment.app.Fragment fragment) {
        FadeAndShortSlide fadeAndShortSlide = new FadeAndShortSlide(GravityCompat.START);
        FadeAndShortSlide fadeAndShortSlide2 = new FadeAndShortSlide(GravityCompat.END);
        fragment.setEnterTransition(fadeAndShortSlide2);
        fragment.setExitTransition(fadeAndShortSlide);
        fragment.setReenterTransition(fadeAndShortSlide);
        fragment.setReturnTransition(fadeAndShortSlide2);
    }
}
