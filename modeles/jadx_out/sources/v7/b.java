package v7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f10867a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f10868b;

    /* renamed from: l, reason: collision with root package name */
    public static final b f10869l;

    /* renamed from: m, reason: collision with root package name */
    public static final b f10870m;

    /* renamed from: n, reason: collision with root package name */
    public static final b f10871n;

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ b[] f10872o;

    static {
        b bVar = new b("CPU_ACQUIRED", 0);
        f10867a = bVar;
        b bVar2 = new b("BLOCKING", 1);
        f10868b = bVar2;
        b bVar3 = new b("PARKING", 2);
        f10869l = bVar3;
        b bVar4 = new b("DORMANT", 3);
        f10870m = bVar4;
        b bVar5 = new b("TERMINATED", 4);
        f10871n = bVar5;
        f10872o = new b[]{bVar, bVar2, bVar3, bVar4, bVar5};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f10872o.clone();
    }
}
