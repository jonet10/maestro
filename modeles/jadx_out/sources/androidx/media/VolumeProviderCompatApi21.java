package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(21)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class VolumeProviderCompatApi21 {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i, int i6, int i10, final Delegate delegate) {
        return new VolumeProvider(i, i6, i10) { // from class: androidx.media.VolumeProviderCompatApi21.1
            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i11) {
                delegate.onAdjustVolume(i11);
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i11) {
                delegate.onSetVolumeTo(i11);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i) {
        ((VolumeProvider) obj).setCurrentVolume(i);
    }
}
