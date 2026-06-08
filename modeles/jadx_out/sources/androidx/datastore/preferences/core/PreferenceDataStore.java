package androidx.datastore.preferences.core;

import androidx.datastore.core.DataStore;
import d7.p;
import r7.h;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PreferenceDataStore implements DataStore<Preferences> {
    private final DataStore<Preferences> delegate;

    public PreferenceDataStore(DataStore<Preferences> dataStore) {
        dataStore.getClass();
        this.delegate = dataStore;
    }

    @Override // androidx.datastore.core.DataStore
    public h getData() {
        return this.delegate.getData();
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(p pVar, c cVar) {
        return this.delegate.updateData(new PreferenceDataStore$updateData$2(pVar, null), cVar);
    }
}
