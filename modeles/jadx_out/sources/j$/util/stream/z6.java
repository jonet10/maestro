package j$.util.stream;

import j$.util.Spliterator;
import java.util.EnumMap;
import java.util.Map;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DISTINCT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class z6 {
    public static final z6 DISTINCT;
    public static final z6 ORDERED;
    public static final z6 SHORT_CIRCUIT;
    public static final z6 SIZED;
    public static final z6 SORTED;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f6442k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f6443l;

    /* renamed from: m, reason: collision with root package name */
    public static final int f6444m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f6445n;

    /* renamed from: o, reason: collision with root package name */
    public static final int f6446o;

    /* renamed from: p, reason: collision with root package name */
    public static final int f6447p;

    /* renamed from: q, reason: collision with root package name */
    public static final int f6448q;

    /* renamed from: r, reason: collision with root package name */
    public static final int f6449r;

    /* renamed from: s, reason: collision with root package name */
    public static final int f6450s;

    /* renamed from: t, reason: collision with root package name */
    public static final int f6451t;

    /* renamed from: u, reason: collision with root package name */
    public static final int f6452u;
    public static final /* synthetic */ z6[] v;

    /* renamed from: a, reason: collision with root package name */
    public final Map f6453a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6454b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6455c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6456d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6457e;

    public static z6 valueOf(String str) {
        return (z6) Enum.valueOf(z6.class, str);
    }

    public static z6[] values() {
        return (z6[]) v.clone();
    }

    static {
        y6 y6Var = y6.SPLITERATOR;
        j$.time.format.r k5 = k(y6Var);
        y6 y6Var2 = y6.STREAM;
        k5.b(y6Var2);
        y6 y6Var3 = y6.OP;
        ((EnumMap) k5.f5859a).put((EnumMap) y6Var3, (y6) 3);
        z6 z6Var = new z6("DISTINCT", 0, 0, k5);
        DISTINCT = z6Var;
        j$.time.format.r k10 = k(y6Var);
        k10.b(y6Var2);
        ((EnumMap) k10.f5859a).put((EnumMap) y6Var3, (y6) 3);
        z6 z6Var2 = new z6("SORTED", 1, 1, k10);
        SORTED = z6Var2;
        j$.time.format.r k11 = k(y6Var);
        k11.b(y6Var2);
        ((EnumMap) k11.f5859a).put((EnumMap) y6Var3, (y6) 3);
        y6 y6Var4 = y6.TERMINAL_OP;
        ((EnumMap) k11.f5859a).put((EnumMap) y6Var4, (y6) 2);
        y6 y6Var5 = y6.UPSTREAM_TERMINAL_OP;
        ((EnumMap) k11.f5859a).put((EnumMap) y6Var5, (y6) 2);
        z6 z6Var3 = new z6("ORDERED", 2, 2, k11);
        ORDERED = z6Var3;
        j$.time.format.r k12 = k(y6Var);
        k12.b(y6Var2);
        ((EnumMap) k12.f5859a).put((EnumMap) y6Var3, (y6) 2);
        z6 z6Var4 = new z6("SIZED", 3, 3, k12);
        SIZED = z6Var4;
        j$.time.format.r k13 = k(y6Var3);
        k13.b(y6Var4);
        int i6 = 0;
        z6 z6Var5 = new z6("SHORT_CIRCUIT", 4, 12, k13);
        SHORT_CIRCUIT = z6Var5;
        v = new z6[]{z6Var, z6Var2, z6Var3, z6Var4, z6Var5};
        f = f(y6Var);
        g = f(y6Var2);
        h = f(y6Var3);
        f(y6Var4);
        f(y6Var5);
        for (z6 z6Var6 : values()) {
            i6 |= z6Var6.f6457e;
        }
        i = i6;
        int i10 = g;
        j = i10;
        int i11 = i10 << 1;
        f6442k = i11;
        f6443l = i10 | i11;
        z6 z6Var7 = DISTINCT;
        f6444m = z6Var7.f6455c;
        f6445n = z6Var7.f6456d;
        z6 z6Var8 = SORTED;
        f6446o = z6Var8.f6455c;
        f6447p = z6Var8.f6456d;
        z6 z6Var9 = ORDERED;
        f6448q = z6Var9.f6455c;
        f6449r = z6Var9.f6456d;
        z6 z6Var10 = SIZED;
        f6450s = z6Var10.f6455c;
        f6451t = z6Var10.f6456d;
        f6452u = SHORT_CIRCUIT.f6455c;
    }

    public static j$.time.format.r k(y6 y6Var) {
        j$.time.format.r rVar = new j$.time.format.r(1, new EnumMap(y6.class));
        rVar.b(y6Var);
        return rVar;
    }

    public z6(String str, int i6, int i10, j$.time.format.r rVar) {
        for (y6 y6Var : y6.values()) {
            j$.util.c.t(rVar.f5859a, y6Var, 0);
        }
        this.f6453a = rVar.f5859a;
        int i11 = i10 * 2;
        this.f6454b = i11;
        this.f6455c = 1 << i11;
        this.f6456d = 2 << i11;
        this.f6457e = 3 << i11;
    }

    public final boolean j(int i6) {
        return (i6 & this.f6457e) == this.f6455c;
    }

    public static int f(y6 y6Var) {
        int i6 = 0;
        for (z6 z6Var : values()) {
            i6 |= ((Integer) z6Var.f6453a.get(y6Var)).intValue() << z6Var.f6454b;
        }
        return i6;
    }

    public static int e(int i6, int i10) {
        int i11;
        if (i6 == 0) {
            i11 = i;
        } else {
            i11 = ~(((j & i6) << 1) | i6 | ((f6442k & i6) >> 1));
        }
        return i6 | (i10 & i11);
    }

    public static int g(Spliterator spliterator) {
        int characteristics = spliterator.characteristics();
        int i6 = characteristics & 4;
        int i10 = f;
        return (i6 == 0 || spliterator.getComparator() == null) ? characteristics & i10 : characteristics & i10 & (-5);
    }
}
