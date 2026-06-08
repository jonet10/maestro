package d3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f3553a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f3554b;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ d[] f3555l;

    static {
        d dVar = new d("CRASHLYTICS", 0);
        f3553a = dVar;
        d dVar2 = new d("PERFORMANCE", 1);
        f3554b = dVar2;
        f3555l = new d[]{dVar, dVar2, new d("MATT_SAYS_HI", 2)};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f3555l.clone();
    }
}
