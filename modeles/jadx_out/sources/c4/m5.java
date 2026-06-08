package c4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m5 {

    /* renamed from: a, reason: collision with root package name */
    public static final m5 f1863a;

    /* renamed from: b, reason: collision with root package name */
    public static final m5 f1864b;

    /* renamed from: l, reason: collision with root package name */
    public static final m5 f1865l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ m5[] f1866m;

    static {
        m5 m5Var = new m5("NAME", 0);
        f1863a = m5Var;
        m5 m5Var2 = new m5("DATE", 1);
        f1864b = m5Var2;
        m5 m5Var3 = new m5("SIZE", 2);
        f1865l = m5Var3;
        f1866m = new m5[]{m5Var, m5Var2, m5Var3};
    }

    public static m5 valueOf(String str) {
        return (m5) Enum.valueOf(m5.class, str);
    }

    public static m5[] values() {
        return (m5[]) f1866m.clone();
    }
}
