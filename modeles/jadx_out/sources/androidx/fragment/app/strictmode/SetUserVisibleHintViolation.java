package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SetUserVisibleHintViolation extends Violation {
    private final boolean isVisibleToUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetUserVisibleHintViolation(Fragment fragment, boolean z9) {
        super(fragment, "Attempting to set user visible hint to " + z9 + " for fragment " + fragment);
        fragment.getClass();
        this.isVisibleToUser = z9;
    }

    public final boolean isVisibleToUser() {
        return this.isVisibleToUser;
    }
}
