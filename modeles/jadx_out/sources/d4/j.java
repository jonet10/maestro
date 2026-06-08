package d4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f3576a;

    /* renamed from: b, reason: collision with root package name */
    public static final j f3577b;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ j[] f3578l;

    static {
        j jVar = new j("MOBILEDATA", 0);
        f3576a = jVar;
        j jVar2 = new j("WIFI", 1);
        f3577b = jVar2;
        f3578l = new j[]{jVar, jVar2};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f3578l.clone();
    }
}
