package androidx.datastore.core;

import d7.p;
import t6.f;
import t6.g;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class UpdatingDataContextElement implements f {
    public static final Companion Companion = new Companion(null);
    private static final String NESTED_UPDATE_ERROR_MESSAGE = "Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.";
    private final DataStoreImpl<?> instance;
    private final UpdatingDataContextElement parent;

    public UpdatingDataContextElement(UpdatingDataContextElement updatingDataContextElement, DataStoreImpl<?> dataStoreImpl) {
        dataStoreImpl.getClass();
        this.parent = updatingDataContextElement;
        this.instance = dataStoreImpl;
    }

    public final void checkNotUpdating(DataStore<?> dataStore) {
        dataStore.getClass();
        if (this.instance == dataStore) {
            throw new IllegalStateException(NESTED_UPDATE_ERROR_MESSAGE.toString());
        }
        UpdatingDataContextElement updatingDataContextElement = this.parent;
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(dataStore);
        }
    }

    @Override // t6.h
    public <R> R fold(R r9, p pVar) {
        return (R) a.a.x(this, r9, pVar);
    }

    @Override // t6.h
    public <E extends f> E get(g gVar) {
        return (E) a.a.z(this, gVar);
    }

    @Override // t6.f
    public g getKey() {
        return Companion.Key.INSTANCE;
    }

    @Override // t6.h
    public h minusKey(g gVar) {
        return a.a.K(this, gVar);
    }

    @Override // t6.h
    public h plus(h hVar) {
        return a.a.L(this, hVar);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Key implements g {
            public static final Key INSTANCE = new Key();

            private Key() {
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final String getNESTED_UPDATE_ERROR_MESSAGE$datastore_core_release() {
            return UpdatingDataContextElement.NESTED_UPDATE_ERROR_MESSAGE;
        }

        private Companion() {
        }
    }
}
