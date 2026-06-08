package v3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f10832a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f10833b;

    /* renamed from: l, reason: collision with root package name */
    public static final d f10834l;

    /* renamed from: m, reason: collision with root package name */
    public static final d f10835m;

    /* renamed from: n, reason: collision with root package name */
    public static final d f10836n;

    /* renamed from: o, reason: collision with root package name */
    public static final d f10837o;

    /* renamed from: p, reason: collision with root package name */
    public static final d f10838p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ d[] f10839q;

    static {
        d dVar = new d("UNKNOWN", 0);
        f10832a = dVar;
        d dVar2 = new d("UNSTARTED", 1);
        f10833b = dVar2;
        d dVar3 = new d("ENDED", 2);
        f10834l = dVar3;
        d dVar4 = new d("PLAYING", 3);
        f10835m = dVar4;
        d dVar5 = new d("PAUSED", 4);
        f10836n = dVar5;
        d dVar6 = new d("BUFFERING", 5);
        f10837o = dVar6;
        d dVar7 = new d("VIDEO_CUED", 6);
        f10838p = dVar7;
        f10839q = new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f10839q.clone();
    }
}
