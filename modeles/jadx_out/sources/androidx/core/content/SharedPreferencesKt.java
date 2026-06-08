package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(SharedPreferences sharedPreferences, boolean z9, l lVar) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        lVar.invoke(edit);
        if (z9) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z9, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z9 = false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        lVar.invoke(edit);
        if (z9) {
            edit.commit();
        } else {
            edit.apply();
        }
    }
}
