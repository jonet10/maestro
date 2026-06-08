package androidx.datastore.core.okio;

import d7.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Synchronizer {
    public final <T> T withLock(a aVar) {
        T t9;
        aVar.getClass();
        synchronized (this) {
            t9 = (T) aVar.invoke();
        }
        return t9;
    }
}
