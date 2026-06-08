package androidx.datastore.preferences;

import androidx.datastore.preferences.core.Preferences;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import d7.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import p6.x;
import q6.n;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.preferences.SharedPreferencesMigrationKt$getShouldRunMigration$1", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SharedPreferencesMigrationKt$getShouldRunMigration$1 extends i implements p {
    final /* synthetic */ Set<String> $keysToMigrate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigrationKt$getShouldRunMigration$1(Set<String> set, c cVar) {
        super(2, cVar);
        this.$keysToMigrate = set;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        SharedPreferencesMigrationKt$getShouldRunMigration$1 sharedPreferencesMigrationKt$getShouldRunMigration$1 = new SharedPreferencesMigrationKt$getShouldRunMigration$1(this.$keysToMigrate, cVar);
        sharedPreferencesMigrationKt$getShouldRunMigration$1.L$0 = obj;
        return sharedPreferencesMigrationKt$getShouldRunMigration$1;
    }

    @Override // d7.p
    public final Object invoke(Preferences preferences, c cVar) {
        return ((SharedPreferencesMigrationKt$getShouldRunMigration$1) create(preferences, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        if (this.label != 0) {
            a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        Set<Preferences.Key<?>> keySet = ((Preferences) this.L$0).asMap().keySet();
        ArrayList arrayList = new ArrayList(n.i0(keySet, 10));
        Iterator<T> it = keySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Preferences.Key) it.next()).getName());
        }
        boolean z9 = true;
        if (this.$keysToMigrate != SharedPreferencesMigrationKt.getMIGRATE_ALL_KEYS()) {
            Set<String> set = this.$keysToMigrate;
            if (set == null || !set.isEmpty()) {
                Iterator<T> it2 = set.iterator();
                while (it2.hasNext()) {
                    if (!arrayList.contains((String) it2.next())) {
                        break;
                    }
                }
            }
            z9 = false;
        }
        return Boolean.valueOf(z9);
    }
}
