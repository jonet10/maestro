package i2;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import java.io.Serializable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class g {
    public static final Object a(MutablePreferences mutablePreferences, Preferences.Key key, Serializable serializable) {
        mutablePreferences.getClass();
        key.getClass();
        Object obj = mutablePreferences.get(key);
        return obj == null ? serializable : obj;
    }
}
