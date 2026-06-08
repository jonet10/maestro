package androidx.preference;

import d7.p;
import java.util.Iterator;
import k7.f;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PreferenceGroupKt {
    public static final boolean contains(PreferenceGroup preferenceGroup, Preference preference) {
        preferenceGroup.getClass();
        preference.getClass();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        int i = 0;
        while (i < preferenceCount) {
            int i6 = i + 1;
            if (l.a(preferenceGroup.getPreference(i), preference)) {
                return true;
            }
            i = i6;
        }
        return false;
    }

    public static final void forEach(PreferenceGroup preferenceGroup, d7.l lVar) {
        preferenceGroup.getClass();
        lVar.getClass();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            lVar.invoke(get(preferenceGroup, i));
        }
    }

    public static final void forEachIndexed(PreferenceGroup preferenceGroup, p pVar) {
        preferenceGroup.getClass();
        pVar.getClass();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            pVar.invoke(Integer.valueOf(i), get(preferenceGroup, i));
        }
    }

    public static final <T extends Preference> T get(PreferenceGroup preferenceGroup, CharSequence charSequence) {
        preferenceGroup.getClass();
        charSequence.getClass();
        return (T) preferenceGroup.findPreference(charSequence);
    }

    public static final f getChildren(final PreferenceGroup preferenceGroup) {
        preferenceGroup.getClass();
        return new f() { // from class: androidx.preference.PreferenceGroupKt$children$1
            @Override // k7.f
            public Iterator<Preference> iterator() {
                return PreferenceGroupKt.iterator(PreferenceGroup.this);
            }
        };
    }

    public static final int getSize(PreferenceGroup preferenceGroup) {
        preferenceGroup.getClass();
        return preferenceGroup.getPreferenceCount();
    }

    public static final boolean isEmpty(PreferenceGroup preferenceGroup) {
        preferenceGroup.getClass();
        return preferenceGroup.getPreferenceCount() == 0;
    }

    public static final boolean isNotEmpty(PreferenceGroup preferenceGroup) {
        preferenceGroup.getClass();
        return preferenceGroup.getPreferenceCount() != 0;
    }

    public static final Iterator<Preference> iterator(PreferenceGroup preferenceGroup) {
        preferenceGroup.getClass();
        return new PreferenceGroupKt$iterator$1(preferenceGroup);
    }

    public static final void minusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        preferenceGroup.getClass();
        preference.getClass();
        preferenceGroup.removePreference(preference);
    }

    public static final void plusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        preferenceGroup.getClass();
        preference.getClass();
        preferenceGroup.addPreference(preference);
    }

    public static final Preference get(PreferenceGroup preferenceGroup, int i) {
        preferenceGroup.getClass();
        Preference preference = preferenceGroup.getPreference(i);
        preference.getClass();
        return preference;
    }
}
