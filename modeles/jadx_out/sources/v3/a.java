package v3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10806a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f10807b;

    /* renamed from: l, reason: collision with root package name */
    public static final a f10808l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f10809m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f10810n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f10811o;

    /* renamed from: p, reason: collision with root package name */
    public static final a f10812p;

    /* renamed from: q, reason: collision with root package name */
    public static final a f10813q;

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ a[] f10814r;

    static {
        a aVar = new a("UNKNOWN", 0);
        f10806a = aVar;
        a aVar2 = new a("SMALL", 1);
        f10807b = aVar2;
        a aVar3 = new a("MEDIUM", 2);
        f10808l = aVar3;
        a aVar4 = new a("LARGE", 3);
        f10809m = aVar4;
        a aVar5 = new a("HD720", 4);
        f10810n = aVar5;
        a aVar6 = new a("HD1080", 5);
        f10811o = aVar6;
        a aVar7 = new a("HIGH_RES", 6);
        f10812p = aVar7;
        a aVar8 = new a("DEFAULT", 7);
        f10813q = aVar8;
        f10814r = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f10814r.clone();
    }
}
