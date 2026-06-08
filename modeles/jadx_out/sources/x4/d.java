package x4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f11087a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f11088b;

    /* renamed from: l, reason: collision with root package name */
    public static final d f11089l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ d[] f11090m;

    static {
        d dVar = new d("OUTDATED", 0);
        f11087a = dVar;
        d dVar2 = new d("UPDATED", 1);
        f11088b = dVar2;
        d dVar3 = new d("UNAVAILABLE", 2);
        f11089l = dVar3;
        f11090m = new d[]{dVar, dVar2, dVar3};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f11090m.clone();
    }
}
