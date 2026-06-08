package e8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4757a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f4758b;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ a[] f4759l;

    static {
        a aVar = new a("NONE", 0);
        f4757a = aVar;
        a aVar2 = new a("ALL_JSON_OBJECTS", 1);
        a aVar3 = new a("POLYMORPHIC", 2);
        f4758b = aVar3;
        f4759l = new a[]{aVar, aVar2, aVar3};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f4759l.clone();
    }
}
