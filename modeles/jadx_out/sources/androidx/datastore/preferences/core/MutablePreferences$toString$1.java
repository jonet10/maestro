package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import d7.l;
import java.util.Map;
import kotlin.jvm.internal.m;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutablePreferences$toString$1 extends m implements l {
    public static final MutablePreferences$toString$1 INSTANCE = new MutablePreferences$toString$1();

    public MutablePreferences$toString$1() {
        super(1);
    }

    @Override // d7.l
    public final CharSequence invoke(Map.Entry<Preferences.Key<?>, Object> entry) {
        entry.getClass();
        Object value = entry.getValue();
        return "  " + entry.getKey().getName() + " = " + (value instanceof byte[] ? j.k0((byte[]) value, ", ", null, 56) : String.valueOf(entry.getValue()));
    }
}
