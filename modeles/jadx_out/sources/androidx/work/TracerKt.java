package androidx.work;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TracerKt {
    public static final <T> T traced(Tracer tracer, String str, d7.a aVar) {
        tracer.getClass();
        str.getClass();
        aVar.getClass();
        boolean isEnabled = tracer.isEnabled();
        if (isEnabled) {
            try {
                tracer.beginSection(str);
            } catch (Throwable th) {
                if (isEnabled) {
                    tracer.endSection();
                }
                throw th;
            }
        }
        T t9 = (T) aVar.invoke();
        if (isEnabled) {
            tracer.endSection();
        }
        return t9;
    }
}
