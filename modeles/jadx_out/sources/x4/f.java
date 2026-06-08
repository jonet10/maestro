package x4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f11143a;

    /* renamed from: b, reason: collision with root package name */
    public static final f f11144b;

    /* renamed from: l, reason: collision with root package name */
    public static final f f11145l;

    /* renamed from: m, reason: collision with root package name */
    public static final f f11146m;

    /* renamed from: n, reason: collision with root package name */
    public static final f f11147n;

    /* renamed from: o, reason: collision with root package name */
    public static final f f11148o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ f[] f11149p;

    static {
        f fVar = new f("UPDATE", 0);
        f11143a = fVar;
        f fVar2 = new f("PROMOTED", 1);
        f11144b = fVar2;
        f fVar3 = new f("LATEST", 2);
        f11145l = fVar3;
        f fVar4 = new f("EDITOR_CHOICE", 3);
        f11146m = fVar4;
        f fVar5 = new f("TRENDING", 4);
        f11147n = fVar5;
        f fVar6 = new f("NONE", 5);
        f11148o = fVar6;
        f11149p = new f[]{fVar, fVar2, fVar3, fVar4, fVar5, fVar6};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f11149p.clone();
    }
}
