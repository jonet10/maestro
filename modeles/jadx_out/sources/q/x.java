package q;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f8625a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ x[] f8626b;

    /* JADX INFO: Fake field, exist only in values array */
    x EF0;

    static {
        x xVar = new x("UNKNOWN", 0);
        x xVar2 = new x("ANDROID_FIREBASE", 1);
        f8625a = xVar2;
        f8626b = new x[]{xVar, xVar2};
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) f8626b.clone();
    }
}
