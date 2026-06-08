package p6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f8438a;

    /* renamed from: b, reason: collision with root package name */
    public static final g f8439b;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ g[] f8440l;

    /* JADX INFO: Fake field, exist only in values array */
    g EF0;

    static {
        g gVar = new g("SYNCHRONIZED", 0);
        g gVar2 = new g("PUBLICATION", 1);
        f8438a = gVar2;
        g gVar3 = new g("NONE", 2);
        f8439b = gVar3;
        f8440l = new g[]{gVar, gVar2, gVar3};
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f8440l.clone();
    }
}
