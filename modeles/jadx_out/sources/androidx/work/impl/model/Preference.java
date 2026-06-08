package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Entity
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Preference {

    @PrimaryKey
    @ColumnInfo(name = "key")
    private final String key;

    @ColumnInfo(name = "long_value")
    private final Long value;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Preference(String str, boolean z9) {
        this(str, Long.valueOf(z9 ? 1L : 0L));
        str.getClass();
    }

    public static /* synthetic */ Preference copy$default(Preference preference, String str, Long l10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = preference.key;
        }
        if ((i & 2) != 0) {
            l10 = preference.value;
        }
        return preference.copy(str, l10);
    }

    public final String component1() {
        return this.key;
    }

    public final Long component2() {
        return this.value;
    }

    public final Preference copy(String str, Long l10) {
        str.getClass();
        return new Preference(str, l10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        return l.a(this.key, preference.key) && l.a(this.value, preference.value);
    }

    public final String getKey() {
        return this.key;
    }

    public final Long getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = this.key.hashCode() * 31;
        Long l10 = this.value;
        return hashCode + (l10 == null ? 0 : l10.hashCode());
    }

    public String toString() {
        return "Preference(key=" + this.key + ", value=" + this.value + ')';
    }

    public Preference(String str, Long l10) {
        str.getClass();
        this.key = str;
        this.value = l10;
    }
}
