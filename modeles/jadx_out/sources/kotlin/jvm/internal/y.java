package kotlin.jvm.internal;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final z f7025a;

    static {
        z zVar = null;
        try {
            zVar = (z) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (zVar == null) {
            zVar = new z();
        }
        f7025a = zVar;
    }

    public static f a(Class cls) {
        f7025a.getClass();
        return new f(cls);
    }
}
