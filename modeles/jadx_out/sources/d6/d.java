package d6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f3603a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f3604b;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ d[] f3605l;

    static {
        d dVar = new d("BULLET", 0);
        f3603a = dVar;
        d dVar2 = new d("ORDERED", 1);
        f3604b = dVar2;
        f3605l = new d[]{dVar, dVar2};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f3605l.clone();
    }
}
