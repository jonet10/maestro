package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z6 {

    /* renamed from: l, reason: collision with root package name */
    public static final z6 f2935l;

    /* renamed from: m, reason: collision with root package name */
    public static final z6 f2936m;

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ z6[] f2937n;

    /* renamed from: a, reason: collision with root package name */
    public final a7 f2938a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2939b;

    /* JADX INFO: Fake field, exist only in values array */
    z6 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    z6 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    z6 EF2;

    static {
        z6 z6Var = new z6("DOUBLE", 0, a7.f2497m, 1);
        z6 z6Var2 = new z6("FLOAT", 1, a7.f2496l, 5);
        a7 a7Var = a7.f2495b;
        z6 z6Var3 = new z6("INT64", 2, a7Var, 0);
        z6 z6Var4 = new z6("UINT64", 3, a7Var, 0);
        a7 a7Var2 = a7.f2494a;
        z6 z6Var5 = new z6("INT32", 4, a7Var2, 0);
        z6 z6Var6 = new z6("FIXED64", 5, a7Var, 1);
        z6 z6Var7 = new z6("FIXED32", 6, a7Var2, 5);
        z6 z6Var8 = new z6("BOOL", 7, a7.f2498n, 0);
        z6 z6Var9 = new z6("STRING", 8, a7.f2499o, 2);
        f2935l = z6Var9;
        a7 a7Var3 = a7.f2502r;
        z6 z6Var10 = new z6("GROUP", 9, a7Var3, 3);
        f2936m = z6Var10;
        f2937n = new z6[]{z6Var, z6Var2, z6Var3, z6Var4, z6Var5, z6Var6, z6Var7, z6Var8, z6Var9, z6Var10, new z6("MESSAGE", 10, a7Var3, 2), new z6("BYTES", 11, a7.f2500p, 2), new z6("UINT32", 12, a7Var2, 0), new z6("ENUM", 13, a7.f2501q, 0), new z6("SFIXED32", 14, a7Var2, 5), new z6("SFIXED64", 15, a7Var, 1), new z6("SINT32", 16, a7Var2, 0), new z6("SINT64", 17, a7Var, 0)};
    }

    public z6(String str, int i, a7 a7Var, int i6) {
        this.f2938a = a7Var;
        this.f2939b = i6;
    }

    public static z6[] values() {
        return (z6[]) f2937n.clone();
    }
}
