package androidx.appcompat.app;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(24)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class LocaleOverlayHelper {
    private LocaleOverlayHelper() {
    }

    private static LocaleListCompat combineLocales(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        while (i < localeListCompat2.size() + localeListCompat.size()) {
            Locale locale = i < localeListCompat.size() ? localeListCompat.get(i) : localeListCompat2.get(i - localeListCompat.size());
            if (locale != null) {
                linkedHashSet.add(locale);
            }
            i++;
        }
        return LocaleListCompat.create((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    public static LocaleListCompat combineLocalesIfOverlayExists(LocaleList localeList, LocaleList localeList2) {
        return (localeList == null || localeList.isEmpty()) ? LocaleListCompat.getEmptyLocaleList() : combineLocales(LocaleListCompat.wrap(localeList), LocaleListCompat.wrap(localeList2));
    }

    public static LocaleListCompat combineLocalesIfOverlayExists(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        if (localeListCompat != null && !localeListCompat.isEmpty()) {
            return combineLocales(localeListCompat, localeListCompat2);
        }
        return LocaleListCompat.getEmptyLocaleList();
    }
}
