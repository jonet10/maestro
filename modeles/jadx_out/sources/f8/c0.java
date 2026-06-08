package f8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c0 {

    /* renamed from: l, reason: collision with root package name */
    public static final c0 f4941l;

    /* renamed from: m, reason: collision with root package name */
    public static final c0 f4942m;

    /* renamed from: n, reason: collision with root package name */
    public static final c0 f4943n;

    /* renamed from: o, reason: collision with root package name */
    public static final c0 f4944o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ c0[] f4945p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ w6.b f4946q;

    /* renamed from: a, reason: collision with root package name */
    public final char f4947a;

    /* renamed from: b, reason: collision with root package name */
    public final char f4948b;

    static {
        c0 c0Var = new c0("OBJ", 0, '{', '}');
        f4941l = c0Var;
        c0 c0Var2 = new c0("LIST", 1, '[', ']');
        f4942m = c0Var2;
        c0 c0Var3 = new c0("MAP", 2, '{', '}');
        f4943n = c0Var3;
        c0 c0Var4 = new c0("POLY_OBJ", 3, '[', ']');
        f4944o = c0Var4;
        c0[] c0VarArr = {c0Var, c0Var2, c0Var3, c0Var4};
        f4945p = c0VarArr;
        f4946q = new w6.b(c0VarArr);
    }

    public c0(String str, int i, char c9, char c10) {
        this.f4947a = c9;
        this.f4948b = c10;
    }

    public static c0 valueOf(String str) {
        return (c0) Enum.valueOf(c0.class, str);
    }

    public static c0[] values() {
        return (c0[]) f4945p.clone();
    }
}
