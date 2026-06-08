package androidx.room.coroutines;

import d7.p;
import t6.f;
import t6.g;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class ConnectionElement implements f {
    public static final Key Key = new Key(null);
    private final PooledConnectionImpl connectionWrapper;

    public ConnectionElement(PooledConnectionImpl pooledConnectionImpl) {
        pooledConnectionImpl.getClass();
        this.connectionWrapper = pooledConnectionImpl;
    }

    @Override // t6.h
    public <R> R fold(R r9, p pVar) {
        return (R) a.a.x(this, r9, pVar);
    }

    @Override // t6.h
    public <E extends f> E get(g gVar) {
        return (E) a.a.z(this, gVar);
    }

    public final PooledConnectionImpl getConnectionWrapper() {
        return this.connectionWrapper;
    }

    @Override // t6.f
    public g getKey() {
        return Key;
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
    public static final class Key implements g {
        public /* synthetic */ Key(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Key() {
        }
    }
}
