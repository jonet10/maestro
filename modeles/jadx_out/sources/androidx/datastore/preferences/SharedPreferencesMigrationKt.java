package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.migrations.SharedPreferencesMigration;
import androidx.datastore.preferences.core.Preferences;
import d7.a;
import d7.p;
import d7.q;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SharedPreferencesMigrationKt {
    private static final Set<String> MIGRATE_ALL_KEYS = new LinkedHashSet();

    public static final SharedPreferencesMigration<Preferences> SharedPreferencesMigration(Context context, String str, Set<String> set) {
        context.getClass();
        str.getClass();
        set.getClass();
        return set == MIGRATE_ALL_KEYS ? new SharedPreferencesMigration<>(context, str, null, getShouldRunMigration(set), getMigrationFunction(), 4, null) : new SharedPreferencesMigration<>(context, str, set, getShouldRunMigration(set), getMigrationFunction());
    }

    public static /* synthetic */ SharedPreferencesMigration SharedPreferencesMigration$default(a aVar, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            set = MIGRATE_ALL_KEYS;
        }
        return SharedPreferencesMigration(aVar, (Set<String>) set);
    }

    public static final Set<String> getMIGRATE_ALL_KEYS() {
        return MIGRATE_ALL_KEYS;
    }

    private static final q getMigrationFunction() {
        return new SharedPreferencesMigrationKt$getMigrationFunction$1(null);
    }

    private static final p getShouldRunMigration(Set<String> set) {
        return new SharedPreferencesMigrationKt$getShouldRunMigration$1(set, null);
    }

    public static /* synthetic */ SharedPreferencesMigration SharedPreferencesMigration$default(Context context, String str, Set set, int i, Object obj) {
        if ((i & 4) != 0) {
            set = MIGRATE_ALL_KEYS;
        }
        return SharedPreferencesMigration(context, str, set);
    }

    public static final SharedPreferencesMigration<Preferences> SharedPreferencesMigration(a aVar) {
        aVar.getClass();
        return SharedPreferencesMigration$default(aVar, null, 2, null);
    }

    public static final SharedPreferencesMigration<Preferences> SharedPreferencesMigration(a aVar, Set<String> set) {
        aVar.getClass();
        set.getClass();
        if (set == MIGRATE_ALL_KEYS) {
            return new SharedPreferencesMigration<>(aVar, (Set) null, getShouldRunMigration(set), getMigrationFunction(), 2, (g) null);
        }
        return new SharedPreferencesMigration<>(aVar, set, getShouldRunMigration(set), getMigrationFunction());
    }

    public static final SharedPreferencesMigration<Preferences> SharedPreferencesMigration(Context context, String str) {
        context.getClass();
        str.getClass();
        return SharedPreferencesMigration$default(context, str, null, 4, null);
    }
}
