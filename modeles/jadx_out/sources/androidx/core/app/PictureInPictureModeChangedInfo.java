package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PictureInPictureModeChangedInfo {
    private final boolean isInPictureInPictureMode;

    @RequiresApi(26)
    private Configuration newConfiguration;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public PictureInPictureModeChangedInfo(boolean z9, Configuration configuration) {
        this(z9);
        configuration.getClass();
        this.newConfiguration = configuration;
    }

    @RequiresApi(26)
    public final Configuration getNewConfig() {
        Configuration configuration = this.newConfiguration;
        if (configuration != null) {
            return configuration;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("PictureInPictureModeChangedInfo must be constructed with the constructor that takes a Configuration to access the newConfig. Are you running on an API 26 or higher device that makes this information available?");
        return null;
    }

    public final boolean isInPictureInPictureMode() {
        return this.isInPictureInPictureMode;
    }

    public PictureInPictureModeChangedInfo(boolean z9) {
        this.isInPictureInPictureMode = z9;
    }
}
