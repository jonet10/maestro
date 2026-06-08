package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class l implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f397a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f398b;

    public /* synthetic */ l(ViewConfiguration viewConfiguration, int i) {
        this.f397a = i;
        this.f398b = viewConfiguration;
    }

    @Override // androidx.core.util.Supplier
    public final Object get() {
        int scaledMaximumFlingVelocity;
        switch (this.f397a) {
            case 0:
                scaledMaximumFlingVelocity = this.f398b.getScaledMaximumFlingVelocity();
                break;
            default:
                scaledMaximumFlingVelocity = this.f398b.getScaledMinimumFlingVelocity();
                break;
        }
        return Integer.valueOf(scaledMaximumFlingVelocity);
    }
}
