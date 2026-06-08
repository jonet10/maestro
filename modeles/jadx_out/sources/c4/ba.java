package c4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ba {

    /* renamed from: a, reason: collision with root package name */
    public static final ba f1426a;

    /* renamed from: b, reason: collision with root package name */
    public static final ba f1427b;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ ba[] f1428l;

    static {
        ba baVar = new ba("APPS", 0);
        f1426a = baVar;
        ba baVar2 = new ba("CATEGORIES", 1);
        f1427b = baVar2;
        f1428l = new ba[]{baVar, baVar2};
    }

    public static ba valueOf(String str) {
        return (ba) Enum.valueOf(ba.class, str);
    }

    public static ba[] values() {
        return (ba[]) f1428l.clone();
    }
}
