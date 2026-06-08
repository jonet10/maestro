package androidx.savedstate.internal;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SynchronizedObject_jvmKt {
    public static final <T> T synchronizedImpl(SynchronizedObject synchronizedObject, d7.a aVar) {
        T t9;
        synchronizedObject.getClass();
        aVar.getClass();
        synchronized (synchronizedObject) {
            t9 = (T) aVar.invoke();
        }
        return t9;
    }
}
