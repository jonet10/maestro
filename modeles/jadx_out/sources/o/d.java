package o;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f8126a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f8127b;

    /* renamed from: l, reason: collision with root package name */
    public static final d f8128l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ d[] f8129m;

    static {
        d dVar = new d("DEFAULT", 0);
        f8126a = dVar;
        d dVar2 = new d("VERY_LOW", 1);
        f8127b = dVar2;
        d dVar3 = new d("HIGHEST", 2);
        f8128l = dVar3;
        f8129m = new d[]{dVar, dVar2, dVar3};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f8129m.clone();
    }
}
