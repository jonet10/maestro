package q7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8729a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f8730b;

    /* renamed from: l, reason: collision with root package name */
    public static final a f8731l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ a[] f8732m;

    static {
        a aVar = new a("SUSPEND", 0);
        f8729a = aVar;
        a aVar2 = new a("DROP_OLDEST", 1);
        f8730b = aVar2;
        a aVar3 = new a("DROP_LATEST", 2);
        f8731l = aVar3;
        f8732m = new a[]{aVar, aVar2, aVar3};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f8732m.clone();
    }
}
