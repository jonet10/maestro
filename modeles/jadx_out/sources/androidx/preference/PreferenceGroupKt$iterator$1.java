package androidx.preference;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PreferenceGroupKt$iterator$1 implements Iterator<Preference>, e7.a {
    final /* synthetic */ PreferenceGroup $this_iterator;
    private int index;

    public PreferenceGroupKt$iterator$1(PreferenceGroup preferenceGroup) {
        this.$this_iterator = preferenceGroup;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_iterator.getPreferenceCount();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Preference next() {
        PreferenceGroup preferenceGroup = this.$this_iterator;
        int i = this.index;
        this.index = i + 1;
        Preference preference = preferenceGroup.getPreference(i);
        preference.getClass();
        return preference;
    }

    @Override // java.util.Iterator
    public void remove() {
        PreferenceGroup preferenceGroup = this.$this_iterator;
        int i = this.index - 1;
        this.index = i;
        preferenceGroup.removePreference(preferenceGroup.getPreference(i));
    }
}
