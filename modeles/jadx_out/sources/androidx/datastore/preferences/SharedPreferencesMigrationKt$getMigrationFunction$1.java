package androidx.datastore.preferences;

import androidx.datastore.migrations.SharedPreferencesView;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import d7.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import p6.x;
import q6.n;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.preferences.SharedPreferencesMigrationKt$getMigrationFunction$1", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SharedPreferencesMigrationKt$getMigrationFunction$1 extends i implements q {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public SharedPreferencesMigrationKt$getMigrationFunction$1(c cVar) {
        super(3, cVar);
    }

    @Override // d7.q
    public final Object invoke(SharedPreferencesView sharedPreferencesView, Preferences preferences, c cVar) {
        SharedPreferencesMigrationKt$getMigrationFunction$1 sharedPreferencesMigrationKt$getMigrationFunction$1 = new SharedPreferencesMigrationKt$getMigrationFunction$1(cVar);
        sharedPreferencesMigrationKt$getMigrationFunction$1.L$0 = sharedPreferencesView;
        sharedPreferencesMigrationKt$getMigrationFunction$1.L$1 = preferences;
        return sharedPreferencesMigrationKt$getMigrationFunction$1.invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        if (this.label != 0) {
            a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        SharedPreferencesView sharedPreferencesView = (SharedPreferencesView) this.L$0;
        Preferences preferences = (Preferences) this.L$1;
        Set<Preferences.Key<?>> keySet = preferences.asMap().keySet();
        ArrayList arrayList = new ArrayList(n.i0(keySet, 10));
        Iterator<T> it = keySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Preferences.Key) it.next()).getName());
        }
        Map<String, Object> all = sharedPreferencesView.getAll();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : all.entrySet()) {
            if (!arrayList.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        MutablePreferences mutablePreferences = preferences.toMutablePreferences();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str = (String) entry2.getKey();
            Object value = entry2.getValue();
            if (value instanceof Boolean) {
                mutablePreferences.set(PreferencesKeys.booleanKey(str), value);
            } else if (value instanceof Float) {
                mutablePreferences.set(PreferencesKeys.floatKey(str), value);
            } else if (value instanceof Integer) {
                mutablePreferences.set(PreferencesKeys.intKey(str), value);
            } else if (value instanceof Long) {
                mutablePreferences.set(PreferencesKeys.longKey(str), value);
            } else if (value instanceof String) {
                mutablePreferences.set(PreferencesKeys.stringKey(str), value);
            } else if (value instanceof Set) {
                mutablePreferences.set(PreferencesKeys.stringSetKey(str), (Set) value);
            }
        }
        return mutablePreferences.toPreferences();
    }
}
