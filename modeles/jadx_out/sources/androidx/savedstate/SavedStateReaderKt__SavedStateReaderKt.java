package androidx.savedstate;

import androidx.lifecycle.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final /* synthetic */ class SavedStateReaderKt__SavedStateReaderKt {
    public static final Void keyOrValueNotFoundError(String str) {
        str.getClass();
        throw new IllegalArgumentException(l.w("No valid saved state was found for the key '", str, "'. It may be missing, null, or not of the expected type. This can occur if the value was saved with a different type or if the saved state was modified unexpectedly."));
    }
}
