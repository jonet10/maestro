package androidx.datastore.preferences.core;

import d7.p;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {94}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PreferenceDataStore$updateData$2 extends i implements p {
    final /* synthetic */ p $transform;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceDataStore$updateData$2(p pVar, c cVar) {
        super(2, cVar);
        this.$transform = pVar;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        PreferenceDataStore$updateData$2 preferenceDataStore$updateData$2 = new PreferenceDataStore$updateData$2(this.$transform, cVar);
        preferenceDataStore$updateData$2.L$0 = obj;
        return preferenceDataStore$updateData$2;
    }

    @Override // d7.p
    public final Object invoke(Preferences preferences, c cVar) {
        return ((PreferenceDataStore$updateData$2) create(preferences, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            a.e(obj);
            Preferences preferences = (Preferences) this.L$0;
            p pVar = this.$transform;
            this.label = 1;
            obj = pVar.invoke(preferences, this);
            u6.a aVar = u6.a.f10762a;
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a.e(obj);
        }
        Preferences preferences2 = (Preferences) obj;
        preferences2.getClass();
        ((MutablePreferences) preferences2).freeze$datastore_preferences_core_release();
        return preferences2;
    }
}
