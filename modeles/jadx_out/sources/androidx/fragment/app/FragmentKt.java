package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d7.p;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FragmentKt {
    public static final void clearFragmentResult(Fragment fragment, String str) {
        fragment.getClass();
        str.getClass();
        fragment.getParentFragmentManager().clearFragmentResult(str);
    }

    public static final void clearFragmentResultListener(Fragment fragment, String str) {
        fragment.getClass();
        str.getClass();
        fragment.getParentFragmentManager().clearFragmentResultListener(str);
    }

    public static final void setFragmentResult(Fragment fragment, String str, Bundle bundle) {
        fragment.getClass();
        str.getClass();
        bundle.getClass();
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void setFragmentResultListener(Fragment fragment, String str, final p pVar) {
        fragment.getClass();
        str.getClass();
        pVar.getClass();
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentResultListener() { // from class: androidx.fragment.app.FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0
            @Override // androidx.fragment.app.FragmentResultListener
            public final /* synthetic */ void onFragmentResult(@NonNull String str2, @NonNull Bundle bundle) {
                str2.getClass();
                bundle.getClass();
                p.this.invoke(str2, bundle).getClass();
            }
        });
    }
}
