package v3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f10825a;

    /* renamed from: b, reason: collision with root package name */
    public static final c f10826b;

    /* renamed from: l, reason: collision with root package name */
    public static final c f10827l;

    /* renamed from: m, reason: collision with root package name */
    public static final c f10828m;

    /* renamed from: n, reason: collision with root package name */
    public static final c f10829n;

    /* renamed from: o, reason: collision with root package name */
    public static final c f10830o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ c[] f10831p;

    static {
        c cVar = new c("UNKNOWN", 0);
        f10825a = cVar;
        c cVar2 = new c("INVALID_PARAMETER_IN_REQUEST", 1);
        f10826b = cVar2;
        c cVar3 = new c("HTML_5_PLAYER", 2);
        f10827l = cVar3;
        c cVar4 = new c("VIDEO_NOT_FOUND", 3);
        f10828m = cVar4;
        c cVar5 = new c("VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER", 4);
        f10829n = cVar5;
        c cVar6 = new c("REQUEST_MISSING_HTTP_REFERER", 5);
        f10830o = cVar6;
        f10831p = new c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f10831p.clone();
    }
}
