package n5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f8083a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ f[] f8084b;

    static {
        f fVar = new f("ALL", 0);
        f8083a = fVar;
        f8084b = new f[]{fVar, new f("TOP_LEFT", 1), new f("TOP_RIGHT", 2), new f("BOTTOM_LEFT", 3), new f("BOTTOM_RIGHT", 4), new f("TOP", 5), new f("BOTTOM", 6), new f("LEFT", 7), new f("RIGHT", 8), new f("OTHER_TOP_LEFT", 9), new f("OTHER_TOP_RIGHT", 10), new f("OTHER_BOTTOM_LEFT", 11), new f("OTHER_BOTTOM_RIGHT", 12), new f("DIAGONAL_FROM_TOP_LEFT", 13), new f("DIAGONAL_FROM_TOP_RIGHT", 14)};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f8084b.clone();
    }
}
