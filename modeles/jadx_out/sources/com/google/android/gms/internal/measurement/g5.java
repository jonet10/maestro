package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
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
public final class g5 {

    /* renamed from: b, reason: collision with root package name */
    public static final g5 f2597b;

    /* renamed from: l, reason: collision with root package name */
    public static final g5 f2598l;

    /* renamed from: m, reason: collision with root package name */
    public static final g5[] f2599m;

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ g5[] f2600n;

    /* renamed from: a, reason: collision with root package name */
    public final int f2601a;

    /* JADX INFO: Fake field, exist only in values array */
    g5 EF0;

    static {
        u5 u5Var = u5.f2824n;
        g5 g5Var = new g5("DOUBLE", 0, 0, 1, u5Var);
        u5 u5Var2 = u5.f2823m;
        g5 g5Var2 = new g5("FLOAT", 1, 1, 1, u5Var2);
        u5 u5Var3 = u5.f2822l;
        g5 g5Var3 = new g5("INT64", 2, 2, 1, u5Var3);
        g5 g5Var4 = new g5("UINT64", 3, 3, 1, u5Var3);
        u5 u5Var4 = u5.f2821b;
        g5 g5Var5 = new g5("INT32", 4, 4, 1, u5Var4);
        g5 g5Var6 = new g5("FIXED64", 5, 5, 1, u5Var3);
        g5 g5Var7 = new g5("FIXED32", 6, 6, 1, u5Var4);
        u5 u5Var5 = u5.f2825o;
        g5 g5Var8 = new g5("BOOL", 7, 7, 1, u5Var5);
        u5 u5Var6 = u5.f2826p;
        g5 g5Var9 = new g5("STRING", 8, 8, 1, u5Var6);
        u5 u5Var7 = u5.f2829s;
        g5 g5Var10 = new g5("MESSAGE", 9, 9, 1, u5Var7);
        u5 u5Var8 = u5.f2827q;
        g5 g5Var11 = new g5("BYTES", 10, 10, 1, u5Var8);
        g5 g5Var12 = new g5("UINT32", 11, 11, 1, u5Var4);
        u5 u5Var9 = u5.f2828r;
        g5 g5Var13 = new g5("ENUM", 12, 12, 1, u5Var9);
        g5 g5Var14 = new g5("SFIXED32", 13, 13, 1, u5Var4);
        g5 g5Var15 = new g5("SFIXED64", 14, 14, 1, u5Var3);
        g5 g5Var16 = new g5("SINT32", 15, 15, 1, u5Var4);
        g5 g5Var17 = new g5("SINT64", 16, 16, 1, u5Var3);
        g5 g5Var18 = new g5("GROUP", 17, 17, 1, u5Var7);
        g5 g5Var19 = new g5("DOUBLE_LIST", 18, 18, 2, u5Var);
        g5 g5Var20 = new g5("FLOAT_LIST", 19, 19, 2, u5Var2);
        g5 g5Var21 = new g5("INT64_LIST", 20, 20, 2, u5Var3);
        g5 g5Var22 = new g5("UINT64_LIST", 21, 21, 2, u5Var3);
        g5 g5Var23 = new g5("INT32_LIST", 22, 22, 2, u5Var4);
        g5 g5Var24 = new g5("FIXED64_LIST", 23, 23, 2, u5Var3);
        g5 g5Var25 = new g5("FIXED32_LIST", 24, 24, 2, u5Var4);
        g5 g5Var26 = new g5("BOOL_LIST", 25, 25, 2, u5Var5);
        g5 g5Var27 = new g5("STRING_LIST", 26, 26, 2, u5Var6);
        g5 g5Var28 = new g5("MESSAGE_LIST", 27, 27, 2, u5Var7);
        g5 g5Var29 = new g5("BYTES_LIST", 28, 28, 2, u5Var8);
        g5 g5Var30 = new g5("UINT32_LIST", 29, 29, 2, u5Var4);
        g5 g5Var31 = new g5("ENUM_LIST", 30, 30, 2, u5Var9);
        g5 g5Var32 = new g5("SFIXED32_LIST", 31, 31, 2, u5Var4);
        g5 g5Var33 = new g5("SFIXED64_LIST", 32, 32, 2, u5Var3);
        g5 g5Var34 = new g5("SINT32_LIST", 33, 33, 2, u5Var4);
        g5 g5Var35 = new g5("SINT64_LIST", 34, 34, 2, u5Var3);
        g5 g5Var36 = new g5("DOUBLE_LIST_PACKED", 35, 35, 3, u5Var);
        f2597b = g5Var36;
        g5 g5Var37 = new g5("FLOAT_LIST_PACKED", 36, 36, 3, u5Var2);
        g5 g5Var38 = new g5("INT64_LIST_PACKED", 37, 37, 3, u5Var3);
        g5 g5Var39 = new g5("UINT64_LIST_PACKED", 38, 38, 3, u5Var3);
        g5 g5Var40 = new g5("INT32_LIST_PACKED", 39, 39, 3, u5Var4);
        g5 g5Var41 = new g5("FIXED64_LIST_PACKED", 40, 40, 3, u5Var3);
        g5 g5Var42 = new g5("FIXED32_LIST_PACKED", 41, 41, 3, u5Var4);
        g5 g5Var43 = new g5("BOOL_LIST_PACKED", 42, 42, 3, u5Var5);
        g5 g5Var44 = new g5("UINT32_LIST_PACKED", 43, 43, 3, u5Var4);
        g5 g5Var45 = new g5("ENUM_LIST_PACKED", 44, 44, 3, u5Var9);
        g5 g5Var46 = new g5("SFIXED32_LIST_PACKED", 45, 45, 3, u5Var4);
        g5 g5Var47 = new g5("SFIXED64_LIST_PACKED", 46, 46, 3, u5Var3);
        g5 g5Var48 = new g5("SINT32_LIST_PACKED", 47, 47, 3, u5Var4);
        g5 g5Var49 = new g5("SINT64_LIST_PACKED", 48, 48, 3, u5Var3);
        f2598l = g5Var49;
        f2600n = new g5[]{g5Var, g5Var2, g5Var3, g5Var4, g5Var5, g5Var6, g5Var7, g5Var8, g5Var9, g5Var10, g5Var11, g5Var12, g5Var13, g5Var14, g5Var15, g5Var16, g5Var17, g5Var18, g5Var19, g5Var20, g5Var21, g5Var22, g5Var23, g5Var24, g5Var25, g5Var26, g5Var27, g5Var28, g5Var29, g5Var30, g5Var31, g5Var32, g5Var33, g5Var34, g5Var35, g5Var36, g5Var37, g5Var38, g5Var39, g5Var40, g5Var41, g5Var42, g5Var43, g5Var44, g5Var45, g5Var46, g5Var47, g5Var48, g5Var49, new g5("GROUP_LIST", 49, 49, 2, u5Var7), new g5("MAP", 50, 50, 4, u5.f2820a)};
        g5[] values = values();
        f2599m = new g5[values.length];
        for (g5 g5Var50 : values) {
            f2599m[g5Var50.f2601a] = g5Var50;
        }
    }

    public g5(String str, int i, int i6, int i10, u5 u5Var) {
        this.f2601a = i6;
        int i11 = i10 - 1;
        if (i11 == 1) {
            u5Var.getClass();
        } else if (i11 == 3) {
            u5Var.getClass();
        }
        if (i10 == 1) {
            u5 u5Var2 = u5.f2820a;
            u5Var.ordinal();
        }
    }

    public static g5[] values() {
        return (g5[]) f2600n.clone();
    }
}
