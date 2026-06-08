package androidx.fragment.app;

import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FragmentViewModelLazyKt$activityViewModels$2 extends m implements d7.a {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$2(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    @Override // d7.a
    public final ViewModelProvider.Factory invoke() {
        FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
        requireActivity.getClass();
        return requireActivity.getDefaultViewModelProviderFactory();
    }
}
