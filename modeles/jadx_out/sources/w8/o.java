package w8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final v f10985a;

    static {
        v vVar;
        try {
            Class.forName("java.nio.file.Files");
            vVar = new w();
        } catch (ClassNotFoundException unused) {
            vVar = new v();
        }
        f10985a = vVar;
        String str = y.f11004b;
        String property = System.getProperty("java.io.tmpdir");
        property.getClass();
        q1.a.j(property, false);
        ClassLoader classLoader = x8.f.class.getClassLoader();
        classLoader.getClass();
        new x8.f(classLoader);
    }

    public abstract void a(y yVar, y yVar2);

    public abstract void b(y yVar);

    public abstract void c(y yVar);

    public final boolean d(y yVar) {
        yVar.getClass();
        return e(yVar) != null;
    }

    public abstract n e(y yVar);

    public abstract u f(y yVar);

    public abstract u g(y yVar);

    public abstract g0 h(y yVar);
}
