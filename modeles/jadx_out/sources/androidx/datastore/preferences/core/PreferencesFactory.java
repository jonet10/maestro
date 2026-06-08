package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PreferencesFactory {
    public static final Preferences create(Preferences.Pair<?>... pairArr) {
        pairArr.getClass();
        return createMutable((Preferences.Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public static final Preferences createEmpty() {
        return new MutablePreferences(null, true, 1, null);
    }

    public static final MutablePreferences createMutable(Preferences.Pair<?>... pairArr) {
        pairArr.getClass();
        MutablePreferences mutablePreferences = new MutablePreferences(null, false, 1, null);
        mutablePreferences.putAll((Preferences.Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        return mutablePreferences;
    }
}
