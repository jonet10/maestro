package androidx.fragment.app;

import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View view) {
        view.getClass();
        F f = (F) FragmentManager.findFragment(view);
        f.getClass();
        return f;
    }
}
