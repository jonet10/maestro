package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f6 implements m6 {
    public static final int[] j = new int[0];

    /* renamed from: k, reason: collision with root package name */
    public static final Unsafe f2579k = w6.l();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f2580a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f2581b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2582c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2583d;

    /* renamed from: e, reason: collision with root package name */
    public final s4 f2584e;
    public final int[] f;
    public final int g;
    public final int h;
    public final j5 i;

    public f6(int[] iArr, Object[] objArr, int i, int i6, s4 s4Var, int[] iArr2, int i10, int i11, j5 j5Var, j5 j5Var2) {
        this.f2580a = iArr;
        this.f2581b = objArr;
        this.f2582c = i;
        this.f2583d = i6;
        this.f = iArr2;
        this.g = i10;
        this.h = i11;
        this.i = j5Var;
        this.f2584e = s4Var;
    }

    public static int F(int i) {
        return (i >>> 20) & 255;
    }

    public static boolean j(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof l5) {
            return ((l5) obj).e();
        }
        return true;
    }

    public static int k(Object obj, long j6) {
        return ((Integer) w6.j(obj, j6)).intValue();
    }

    public static long l(Object obj, long j6) {
        return ((Long) w6.j(obj, j6)).longValue();
    }

    public static final int s(byte[] bArr, int i, int i6, z6 z6Var, Class cls, v4 v4Var) {
        z6 z6Var2 = z6.f2935l;
        switch (z6Var.ordinal()) {
            case 0:
                int i10 = i + 8;
                v4Var.f2839c = Double.valueOf(Double.longBitsToDouble(i5.X(i, bArr)));
                return i10;
            case 1:
                int i11 = i + 4;
                v4Var.f2839c = Float.valueOf(Float.intBitsToFloat(i5.W(i, bArr)));
                return i11;
            case 2:
            case 3:
                int V = i5.V(bArr, i, v4Var);
                v4Var.f2839c = Long.valueOf(v4Var.f2838b);
                return V;
            case 4:
            case 12:
            case 13:
                int S = i5.S(bArr, i, v4Var);
                v4Var.f2839c = Integer.valueOf(v4Var.f2837a);
                return S;
            case 5:
            case 15:
                int i12 = i + 8;
                v4Var.f2839c = Long.valueOf(i5.X(i, bArr));
                return i12;
            case 6:
            case 14:
                int i13 = i + 4;
                v4Var.f2839c = Integer.valueOf(i5.W(i, bArr));
                return i13;
            case 7:
                int V2 = i5.V(bArr, i, v4Var);
                v4Var.f2839c = Boolean.valueOf(v4Var.f2838b != 0);
                return V2;
            case 8:
                return i5.Y(bArr, i, v4Var);
            case 9:
            default:
                a3.b.n("unsupported field type.");
                return 0;
            case 10:
                m6 a8 = j6.f2671c.a(cls);
                l5 a10 = a8.a();
                int a0 = i5.a0(a10, a8, bArr, i, i6, v4Var);
                a8.g(a10);
                v4Var.f2839c = a10;
                return a0;
            case 11:
                return i5.Z(bArr, i, v4Var);
            case 16:
                int S2 = i5.S(bArr, i, v4Var);
                v4Var.f2839c = Integer.valueOf(d0.b.R(v4Var.f2837a));
                return S2;
            case 17:
                int V3 = i5.V(bArr, i, v4Var);
                v4Var.f2839c = Long.valueOf(d0.b.S(v4Var.f2838b));
                return V3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0277  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.measurement.f6 u(com.google.android.gms.internal.measurement.l6 r35, com.google.android.gms.internal.measurement.j5 r36, com.google.android.gms.internal.measurement.j5 r37) {
        /*
            Method dump skipped, instructions count: 1053
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.f6.u(com.google.android.gms.internal.measurement.l6, com.google.android.gms.internal.measurement.j5, com.google.android.gms.internal.measurement.j5):com.google.android.gms.internal.measurement.f6");
    }

    public static Field v(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e10) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + name.length() + 29 + String.valueOf(arrays).length());
            a4.x.B(sb, "Field ", str, " for ", name);
            androidx.privacysandbox.ads.adservices.customaudience.a.m(a4.x.n(sb, " not found. Known fields are ", arrays), e10);
            return null;
        }
    }

    public final Object A(int i, Object obj) {
        m6 y9 = y(i);
        int E = E(i) & 1048575;
        if (!o(i, obj)) {
            return y9.a();
        }
        Object object = f2579k.getObject(obj, E);
        if (j(object)) {
            return object;
        }
        l5 a8 = y9.a();
        if (object != null) {
            y9.b(a8, object);
        }
        return a8;
    }

    public final void B(int i, Object obj, Object obj2) {
        f2579k.putObject(obj, E(i) & 1048575, obj2);
        p(i, obj);
    }

    public final Object C(int i, int i6, Object obj) {
        m6 y9 = y(i6);
        if (!q(i, i6, obj)) {
            return y9.a();
        }
        Object object = f2579k.getObject(obj, E(i6) & 1048575);
        if (j(object)) {
            return object;
        }
        l5 a8 = y9.a();
        if (object != null) {
            y9.b(a8, object);
        }
        return a8;
    }

    public final void D(int i, Object obj, int i6, Object obj2) {
        f2579k.putObject(obj, E(i6) & 1048575, obj2);
        w6.g(obj, this.f2580a[i6 + 2] & 1048575, i);
    }

    public final int E(int i) {
        return this.f2580a[i + 1];
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final l5 a() {
        return (l5) ((l5) this.f2584e).n(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.m6
    public final void b(Object obj, Object obj2) {
        Object obj3;
        if (!j(obj)) {
            com.google.gson.internal.a.p("Mutating immutable message: ".concat(String.valueOf(obj)));
            return;
        }
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.f2580a;
            if (i >= iArr.length) {
                n6.b(obj, obj2);
                return;
            }
            int E = E(i);
            int i6 = E & 1048575;
            int F = F(E);
            int i10 = iArr[i];
            long j6 = i6;
            switch (F) {
                case 0:
                    if (o(i, obj2)) {
                        v6 v6Var = w6.f2888c;
                        obj3 = obj;
                        v6Var.g(obj3, j6, v6Var.f(obj2, j6));
                        p(i, obj3);
                        break;
                    }
                    obj3 = obj;
                    break;
                case 1:
                    if (o(i, obj2)) {
                        v6 v6Var2 = w6.f2888c;
                        v6Var2.e(obj, j6, v6Var2.d(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 2:
                    if (o(i, obj2)) {
                        w6.i(obj, j6, w6.h(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 3:
                    if (o(i, obj2)) {
                        w6.i(obj, j6, w6.h(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 4:
                    if (o(i, obj2)) {
                        w6.g(obj, j6, w6.f(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 5:
                    if (o(i, obj2)) {
                        w6.i(obj, j6, w6.h(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 6:
                    if (o(i, obj2)) {
                        w6.g(obj, j6, w6.f(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 7:
                    if (o(i, obj2)) {
                        v6 v6Var3 = w6.f2888c;
                        v6Var3.c(obj, j6, v6Var3.b(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 8:
                    if (o(i, obj2)) {
                        w6.k(j6, obj, w6.j(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 9:
                    w(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 10:
                    if (o(i, obj2)) {
                        w6.k(j6, obj, w6.j(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 11:
                    if (o(i, obj2)) {
                        w6.g(obj, j6, w6.f(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 12:
                    if (o(i, obj2)) {
                        w6.g(obj, j6, w6.f(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 13:
                    if (o(i, obj2)) {
                        w6.g(obj, j6, w6.f(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 14:
                    if (o(i, obj2)) {
                        w6.i(obj, j6, w6.h(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 15:
                    if (o(i, obj2)) {
                        w6.g(obj, j6, w6.f(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 16:
                    if (o(i, obj2)) {
                        w6.i(obj, j6, w6.h(obj2, j6));
                        p(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 17:
                    w(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case 49:
                    q5 q5Var = (q5) w6.j(obj, j6);
                    q5 q5Var2 = (q5) w6.j(obj2, j6);
                    int size = q5Var.size();
                    int size2 = q5Var2.size();
                    if (size > 0 && size2 > 0) {
                        if (!((t4) q5Var).f2807a) {
                            q5Var = q5Var.j(size2 + size);
                        }
                        q5Var.addAll(q5Var2);
                    }
                    if (size > 0) {
                        q5Var2 = q5Var;
                    }
                    w6.k(j6, obj, q5Var2);
                    obj3 = obj;
                    break;
                case 50:
                    j5 j5Var = n6.f2726a;
                    w6.k(j6, obj, j5.c(w6.j(obj, j6), w6.j(obj2, j6)));
                    obj3 = obj;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (q(i10, i, obj2)) {
                        w6.k(j6, obj, w6.j(obj2, j6));
                        w6.g(obj, iArr[i + 2] & 1048575, i10);
                    }
                    obj3 = obj;
                    break;
                case 60:
                    x(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 61:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (q(i10, i, obj2)) {
                        w6.k(j6, obj, w6.j(obj2, j6));
                        w6.g(obj, iArr[i + 2] & 1048575, i10);
                    }
                    obj3 = obj;
                    break;
                case 68:
                    x(i, obj, obj2);
                    obj3 = obj;
                    break;
                default:
                    obj3 = obj;
                    break;
            }
            i += 3;
            obj = obj3;
        }
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final int c(s4 s4Var) {
        int i;
        int s6;
        int a8;
        int i6;
        int i10;
        int b7;
        int s9;
        int size;
        int r9;
        int s10;
        int s11;
        int s12;
        int i11;
        int s13;
        int a10;
        f6 f6Var = this;
        s4 s4Var2 = s4Var;
        Unsafe unsafe = f2579k;
        int i12 = 1048575;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            int[] iArr = f6Var.f2580a;
            if (i14 >= iArr.length) {
                return ((l5) s4Var).zzc.c() + i16;
            }
            int E = f6Var.E(i14);
            int F = F(E);
            int i17 = iArr[i14];
            int i18 = iArr[i14 + 2];
            int i19 = i18 & i12;
            if (F <= 17) {
                if (i19 != i13) {
                    i15 = i19 == i12 ? 0 : unsafe.getInt(s4Var2, i19);
                    i13 = i19;
                }
                i = 1 << (i18 >>> 20);
            } else {
                i = 0;
            }
            int i20 = E & i12;
            if (F >= g5.f2597b.f2601a) {
                g5.f2598l.getClass();
            }
            long j6 = i20;
            switch (F) {
                case 0:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 8, i16);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 4, i16);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        long j10 = unsafe.getLong(s4Var2, j6);
                        s6 = b5.s(i17 << 3);
                        a8 = b5.a(j10);
                        i6 = a8 + s6;
                        i16 += i6;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        long j11 = unsafe.getLong(s4Var2, j6);
                        s6 = b5.s(i17 << 3);
                        a8 = b5.a(j11);
                        i6 = a8 + s6;
                        i16 += i6;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        long j12 = unsafe.getInt(s4Var2, j6);
                        s6 = b5.s(i17 << 3);
                        a8 = b5.a(j12);
                        i6 = a8 + s6;
                        i16 += i6;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 8, i16);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 4, i16);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 1, i16);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        int i21 = i17 << 3;
                        Object object = unsafe.getObject(s4Var2, j6);
                        if (object instanceof a5) {
                            int s14 = b5.s(i21);
                            int d10 = ((a5) object).d();
                            i16 = androidx.lifecycle.l.n(d10, d10, s14, i16);
                            break;
                        } else {
                            s6 = b5.s(i21);
                            a8 = b5.b((String) object);
                            i6 = a8 + s6;
                            i16 += i6;
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        Object object2 = unsafe.getObject(s4Var2, j6);
                        m6 y9 = f6Var.y(i14);
                        j5 j5Var = n6.f2726a;
                        int s15 = b5.s(i17 << 3);
                        int b10 = ((s4) object2).b(y9);
                        i16 = androidx.lifecycle.l.n(b10, b10, s15, i16);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        a5 a5Var = (a5) unsafe.getObject(s4Var2, j6);
                        int s16 = b5.s(i17 << 3);
                        int d11 = a5Var.d();
                        i16 = androidx.lifecycle.l.n(d11, d11, s16, i16);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        i16 = androidx.lifecycle.l.m(unsafe.getInt(s4Var2, j6), b5.s(i17 << 3), i16);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        long j13 = unsafe.getInt(s4Var2, j6);
                        s6 = b5.s(i17 << 3);
                        a8 = b5.a(j13);
                        i6 = a8 + s6;
                        i16 += i6;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 4, i16);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 8, i16);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        int i22 = unsafe.getInt(s4Var2, j6);
                        i16 = androidx.lifecycle.l.m((i22 >> 31) ^ (i22 + i22), b5.s(i17 << 3), i16);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        long j14 = unsafe.getLong(s4Var2, j6);
                        s6 = b5.s(i17 << 3);
                        a8 = b5.a((j14 >> 63) ^ (j14 + j14));
                        i6 = a8 + s6;
                        i16 += i6;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (f6Var.n(s4Var2, i14, i13, i15, i)) {
                        s4 s4Var3 = (s4) unsafe.getObject(s4Var2, j6);
                        m6 y10 = f6Var.y(i14);
                        int s17 = b5.s(i17 << 3);
                        i10 = s17 + s17;
                        b7 = s4Var3.b(y10);
                        i6 = b7 + i10;
                        i16 += i6;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i6 = n6.y(i17, (List) unsafe.getObject(s4Var2, j6));
                    i16 += i6;
                    break;
                case 19:
                    i6 = n6.x(i17, (List) unsafe.getObject(s4Var2, j6));
                    i16 += i6;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var2 = n6.f2726a;
                    if (list.size() != 0) {
                        s9 = (b5.s(i17 << 3) * list.size()) + n6.q(list);
                        i16 += s9;
                        break;
                    }
                    s9 = 0;
                    i16 += s9;
                case 21:
                    List list2 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var3 = n6.f2726a;
                    size = list2.size();
                    if (size != 0) {
                        r9 = n6.r(list2);
                        s10 = b5.s(i17 << 3);
                        s11 = (s10 * size) + r9;
                        i16 += s11;
                        break;
                    }
                    s11 = 0;
                    i16 += s11;
                case 22:
                    List list3 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var4 = n6.f2726a;
                    size = list3.size();
                    if (size != 0) {
                        r9 = n6.u(list3);
                        s10 = b5.s(i17 << 3);
                        s11 = (s10 * size) + r9;
                        i16 += s11;
                        break;
                    }
                    s11 = 0;
                    i16 += s11;
                case 23:
                    i6 = n6.y(i17, (List) unsafe.getObject(s4Var2, j6));
                    i16 += i6;
                    break;
                case 24:
                    i6 = n6.x(i17, (List) unsafe.getObject(s4Var2, j6));
                    i16 += i6;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var5 = n6.f2726a;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        s9 = (b5.s(i17 << 3) + 1) * size2;
                        i16 += s9;
                        break;
                    }
                    s9 = 0;
                    i16 += s9;
                case 26:
                    List list5 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var6 = n6.f2726a;
                    int size3 = list5.size();
                    if (size3 != 0) {
                        s11 = b5.s(i17 << 3) * size3;
                        if (list5 instanceof v5) {
                            v5 v5Var = (v5) list5;
                            for (int i23 = 0; i23 < size3; i23++) {
                                Object f = v5Var.f();
                                if (f instanceof a5) {
                                    int d12 = ((a5) f).d();
                                    s11 = androidx.lifecycle.l.m(d12, d12, s11);
                                } else {
                                    s11 = b5.b((String) f) + s11;
                                }
                            }
                        } else {
                            for (int i24 = 0; i24 < size3; i24++) {
                                Object obj = list5.get(i24);
                                if (obj instanceof a5) {
                                    int d13 = ((a5) obj).d();
                                    s11 = androidx.lifecycle.l.m(d13, d13, s11);
                                } else {
                                    s11 = b5.b((String) obj) + s11;
                                }
                            }
                        }
                        i16 += s11;
                        break;
                    }
                    s11 = 0;
                    i16 += s11;
                case 27:
                    List list6 = (List) unsafe.getObject(s4Var2, j6);
                    m6 y11 = f6Var.y(i14);
                    j5 j5Var7 = n6.f2726a;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        s12 = 0;
                    } else {
                        s12 = b5.s(i17 << 3) * size4;
                        for (int i25 = 0; i25 < size4; i25++) {
                            int b11 = ((s4) list6.get(i25)).b(y11);
                            s12 = androidx.lifecycle.l.m(b11, b11, s12);
                        }
                    }
                    i16 += s12;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var8 = n6.f2726a;
                    int size5 = list7.size();
                    if (size5 != 0) {
                        s11 = b5.s(i17 << 3) * size5;
                        for (int i26 = 0; i26 < list7.size(); i26++) {
                            int d14 = ((a5) list7.get(i26)).d();
                            s11 = androidx.lifecycle.l.m(d14, d14, s11);
                        }
                        i16 += s11;
                        break;
                    }
                    s11 = 0;
                    i16 += s11;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                    List list8 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var9 = n6.f2726a;
                    size = list8.size();
                    if (size != 0) {
                        r9 = n6.v(list8);
                        s10 = b5.s(i17 << 3);
                        s11 = (s10 * size) + r9;
                        i16 += s11;
                        break;
                    }
                    s11 = 0;
                    i16 += s11;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                    List list9 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var10 = n6.f2726a;
                    size = list9.size();
                    if (size != 0) {
                        r9 = n6.t(list9);
                        s10 = b5.s(i17 << 3);
                        s11 = (s10 * size) + r9;
                        i16 += s11;
                        break;
                    }
                    s11 = 0;
                    i16 += s11;
                case 31:
                    i6 = n6.x(i17, (List) unsafe.getObject(s4Var2, j6));
                    i16 += i6;
                    break;
                case 32:
                    i6 = n6.y(i17, (List) unsafe.getObject(s4Var2, j6));
                    i16 += i6;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var11 = n6.f2726a;
                    size = list10.size();
                    if (size != 0) {
                        r9 = n6.w(list10);
                        s10 = b5.s(i17 << 3);
                        s11 = (s10 * size) + r9;
                        i16 += s11;
                        break;
                    }
                    s11 = 0;
                    i16 += s11;
                case 34:
                    List list11 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var12 = n6.f2726a;
                    size = list11.size();
                    if (size != 0) {
                        r9 = n6.s(list11);
                        s10 = b5.s(i17 << 3);
                        s11 = (s10 * size) + r9;
                        i16 += s11;
                        break;
                    }
                    s11 = 0;
                    i16 += s11;
                case 35:
                    List list12 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var13 = n6.f2726a;
                    int size6 = list12.size() * 8;
                    if (size6 > 0) {
                        i16 = androidx.lifecycle.l.n(size6, b5.s(i17 << 3), size6, i16);
                        break;
                    } else {
                        break;
                    }
                case 36:
                    List list13 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var14 = n6.f2726a;
                    int size7 = list13.size() * 4;
                    if (size7 > 0) {
                        i16 = androidx.lifecycle.l.n(size7, b5.s(i17 << 3), size7, i16);
                        break;
                    } else {
                        break;
                    }
                case 37:
                    int q9 = n6.q((List) unsafe.getObject(s4Var2, j6));
                    if (q9 > 0) {
                        i16 = androidx.lifecycle.l.n(q9, b5.s(i17 << 3), q9, i16);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int r10 = n6.r((List) unsafe.getObject(s4Var2, j6));
                    if (r10 > 0) {
                        i16 = androidx.lifecycle.l.n(r10, b5.s(i17 << 3), r10, i16);
                        break;
                    } else {
                        break;
                    }
                case 39:
                    int u7 = n6.u((List) unsafe.getObject(s4Var2, j6));
                    if (u7 > 0) {
                        i16 = androidx.lifecycle.l.n(u7, b5.s(i17 << 3), u7, i16);
                        break;
                    } else {
                        break;
                    }
                case 40:
                    List list14 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var15 = n6.f2726a;
                    int size8 = list14.size() * 8;
                    if (size8 > 0) {
                        i16 = androidx.lifecycle.l.n(size8, b5.s(i17 << 3), size8, i16);
                        break;
                    } else {
                        break;
                    }
                case 41:
                    List list15 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var16 = n6.f2726a;
                    int size9 = list15.size() * 4;
                    if (size9 > 0) {
                        i16 = androidx.lifecycle.l.n(size9, b5.s(i17 << 3), size9, i16);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list16 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var17 = n6.f2726a;
                    int size10 = list16.size();
                    if (size10 > 0) {
                        i16 = androidx.lifecycle.l.n(size10, b5.s(i17 << 3), size10, i16);
                        break;
                    } else {
                        break;
                    }
                case 43:
                    int v = n6.v((List) unsafe.getObject(s4Var2, j6));
                    if (v > 0) {
                        i16 = androidx.lifecycle.l.n(v, b5.s(i17 << 3), v, i16);
                        break;
                    } else {
                        break;
                    }
                case 44:
                    int t9 = n6.t((List) unsafe.getObject(s4Var2, j6));
                    if (t9 > 0) {
                        i16 = androidx.lifecycle.l.n(t9, b5.s(i17 << 3), t9, i16);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    List list17 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var18 = n6.f2726a;
                    int size11 = list17.size() * 4;
                    if (size11 > 0) {
                        i16 = androidx.lifecycle.l.n(size11, b5.s(i17 << 3), size11, i16);
                        break;
                    } else {
                        break;
                    }
                case 46:
                    List list18 = (List) unsafe.getObject(s4Var2, j6);
                    j5 j5Var19 = n6.f2726a;
                    int size12 = list18.size() * 8;
                    if (size12 > 0) {
                        i16 = androidx.lifecycle.l.n(size12, b5.s(i17 << 3), size12, i16);
                        break;
                    } else {
                        break;
                    }
                case 47:
                    int w2 = n6.w((List) unsafe.getObject(s4Var2, j6));
                    if (w2 > 0) {
                        i16 = androidx.lifecycle.l.n(w2, b5.s(i17 << 3), w2, i16);
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    int s18 = n6.s((List) unsafe.getObject(s4Var2, j6));
                    if (s18 > 0) {
                        i16 = androidx.lifecycle.l.n(s18, b5.s(i17 << 3), s18, i16);
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List list19 = (List) unsafe.getObject(s4Var2, j6);
                    m6 y12 = f6Var.y(i14);
                    j5 j5Var20 = n6.f2726a;
                    int size13 = list19.size();
                    if (size13 == 0) {
                        i11 = 0;
                    } else {
                        i11 = 0;
                        for (int i27 = 0; i27 < size13; i27++) {
                            s4 s4Var4 = (s4) list19.get(i27);
                            int s19 = b5.s(i17 << 3);
                            i11 += s4Var4.b(y12) + s19 + s19;
                        }
                    }
                    i16 += i11;
                    break;
                case 50:
                    int i28 = i14 / 3;
                    b6 b6Var = (b6) unsafe.getObject(s4Var2, j6);
                    a6 a6Var = (a6) f6Var.f2581b[i28 + i28];
                    if (!b6Var.isEmpty()) {
                        s11 = 0;
                        for (Map.Entry entry : b6Var.entrySet()) {
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            t tVar = a6Var.f2493a;
                            int s20 = b5.s(i17 << 3);
                            int b12 = a6.b(tVar, key, value);
                            s11 = androidx.lifecycle.l.n(b12, b12, s20, s11);
                        }
                        i16 += s11;
                        break;
                    }
                    s11 = 0;
                    i16 += s11;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 8, i16);
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 4, i16);
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        long l10 = l(s4Var2, j6);
                        s13 = b5.s(i17 << 3);
                        a10 = b5.a(l10);
                        i16 += a10 + s13;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        long l11 = l(s4Var2, j6);
                        s13 = b5.s(i17 << 3);
                        a10 = b5.a(l11);
                        i16 += a10 + s13;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        long k5 = k(s4Var2, j6);
                        s13 = b5.s(i17 << 3);
                        a10 = b5.a(k5);
                        i16 += a10 + s13;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 8, i16);
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 4, i16);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 1, i16);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        int i29 = i17 << 3;
                        Object object3 = unsafe.getObject(s4Var2, j6);
                        if (object3 instanceof a5) {
                            int s21 = b5.s(i29);
                            int d15 = ((a5) object3).d();
                            i16 = androidx.lifecycle.l.n(d15, d15, s21, i16);
                            break;
                        } else {
                            s13 = b5.s(i29);
                            a10 = b5.b((String) object3);
                            i16 += a10 + s13;
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        Object object4 = unsafe.getObject(s4Var2, j6);
                        m6 y13 = f6Var.y(i14);
                        j5 j5Var21 = n6.f2726a;
                        int s22 = b5.s(i17 << 3);
                        int b13 = ((s4) object4).b(y13);
                        i16 = androidx.lifecycle.l.n(b13, b13, s22, i16);
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        a5 a5Var2 = (a5) unsafe.getObject(s4Var2, j6);
                        int s23 = b5.s(i17 << 3);
                        int d16 = a5Var2.d();
                        i16 = androidx.lifecycle.l.n(d16, d16, s23, i16);
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        i16 = androidx.lifecycle.l.m(k(s4Var2, j6), b5.s(i17 << 3), i16);
                        break;
                    } else {
                        break;
                    }
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        long k10 = k(s4Var2, j6);
                        s13 = b5.s(i17 << 3);
                        a10 = b5.a(k10);
                        i16 += a10 + s13;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 4, i16);
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        i16 = androidx.lifecycle.l.m(i17 << 3, 8, i16);
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        int k11 = k(s4Var2, j6);
                        i16 = androidx.lifecycle.l.m((k11 >> 31) ^ (k11 + k11), b5.s(i17 << 3), i16);
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        long l12 = l(s4Var2, j6);
                        s13 = b5.s(i17 << 3);
                        a10 = b5.a((l12 >> 63) ^ (l12 + l12));
                        i16 += a10 + s13;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (f6Var.q(i17, i14, s4Var2)) {
                        s4 s4Var5 = (s4) unsafe.getObject(s4Var2, j6);
                        m6 y14 = f6Var.y(i14);
                        int s24 = b5.s(i17 << 3);
                        i10 = s24 + s24;
                        b7 = s4Var5.b(y14);
                        i6 = b7 + i10;
                        i16 += i6;
                        break;
                    } else {
                        break;
                    }
            }
            i14 += 3;
            f6Var = this;
            s4Var2 = s4Var;
            i12 = 1048575;
        }
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void d(Object obj, z5 z5Var) {
        int i;
        f6 f6Var = this;
        Unsafe unsafe = f2579k;
        int i6 = 1048575;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1048575;
        while (true) {
            int[] iArr = f6Var.f2580a;
            if (i10 >= iArr.length) {
                ((l5) obj).zzc.b(z5Var);
                return;
            }
            int E = f6Var.E(i10);
            int F = F(E);
            int i13 = iArr[i10];
            if (F <= 17) {
                int i14 = iArr[i10 + 2];
                int i15 = i14 & i6;
                if (i15 != i12) {
                    i11 = i15 == i6 ? 0 : unsafe.getInt(obj, i15);
                    i12 = i15;
                }
                i = 1 << (i14 >>> 20);
            } else {
                i = 0;
            }
            long j6 = E & i6;
            switch (F) {
                case 0:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        ((b5) z5Var.f2934a).h(i13, Double.doubleToRawLongBits(w6.f2888c.f(obj, j6)));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        ((b5) z5Var.f2934a).f(i13, Float.floatToRawIntBits(w6.f2888c.d(obj, j6)));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        ((b5) z5Var.f2934a).g(i13, unsafe.getLong(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        ((b5) z5Var.f2934a).g(i13, unsafe.getLong(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        ((b5) z5Var.f2934a).d(i13, unsafe.getInt(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        ((b5) z5Var.f2934a).h(i13, unsafe.getLong(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        ((b5) z5Var.f2934a).f(i13, unsafe.getInt(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        boolean b7 = w6.f2888c.b(obj, j6);
                        b5 b5Var = (b5) z5Var.f2934a;
                        b5Var.m(i13 << 3);
                        b5Var.k(b7 ? (byte) 1 : (byte) 0);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        Object object = unsafe.getObject(obj, j6);
                        if (object instanceof String) {
                            b5 b5Var2 = (b5) z5Var.f2934a;
                            b5Var2.m((i13 << 3) | 2);
                            b5Var2.r((String) object);
                            break;
                        } else {
                            ((b5) z5Var.f2934a).i(i13, (a5) object);
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        z5Var.d(i13, unsafe.getObject(obj, j6), f6Var.y(i10));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        ((b5) z5Var.f2934a).i(i13, (a5) unsafe.getObject(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        ((b5) z5Var.f2934a).e(i13, unsafe.getInt(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        ((b5) z5Var.f2934a).d(i13, unsafe.getInt(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        ((b5) z5Var.f2934a).f(i13, unsafe.getInt(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        ((b5) z5Var.f2934a).h(i13, unsafe.getLong(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        int i16 = unsafe.getInt(obj, j6);
                        ((b5) z5Var.f2934a).e(i13, (i16 >> 31) ^ (i16 + i16));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        long j10 = unsafe.getLong(obj, j6);
                        ((b5) z5Var.f2934a).g(i13, (j10 >> 63) ^ (j10 + j10));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (f6Var.n(obj, i10, i12, i11, i)) {
                        z5Var.e(i13, unsafe.getObject(obj, j6), f6Var.y(i10));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    n6.c(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 19:
                    n6.d(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 20:
                    n6.e(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 21:
                    n6.f(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 22:
                    n6.j(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 23:
                    n6.h(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 24:
                    n6.m(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 25:
                    n6.p(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 26:
                    int i17 = iArr[i10];
                    List list = (List) unsafe.getObject(obj, j6);
                    j5 j5Var = n6.f2726a;
                    if (list != null && !list.isEmpty()) {
                        b5 b5Var3 = (b5) z5Var.f2934a;
                        if (list instanceof v5) {
                            v5 v5Var = (v5) list;
                            for (int i18 = 0; i18 < list.size(); i18++) {
                                Object f = v5Var.f();
                                if (f instanceof String) {
                                    b5Var3.m((i17 << 3) | 2);
                                    b5Var3.r((String) f);
                                } else {
                                    b5Var3.i(i17, (a5) f);
                                }
                            }
                            break;
                        } else {
                            for (int i19 = 0; i19 < list.size(); i19++) {
                                String str = (String) list.get(i19);
                                b5Var3.m((i17 << 3) | 2);
                                b5Var3.r(str);
                            }
                            break;
                        }
                    }
                    break;
                case 27:
                    int i20 = iArr[i10];
                    List list2 = (List) unsafe.getObject(obj, j6);
                    m6 y9 = f6Var.y(i10);
                    j5 j5Var2 = n6.f2726a;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i21 = 0; i21 < list2.size(); i21++) {
                            z5Var.d(i20, list2.get(i21), y9);
                        }
                        break;
                    }
                    break;
                case 28:
                    int i22 = iArr[i10];
                    List list3 = (List) unsafe.getObject(obj, j6);
                    j5 j5Var3 = n6.f2726a;
                    if (list3 != null && !list3.isEmpty()) {
                        z5Var.getClass();
                        for (int i23 = 0; i23 < list3.size(); i23++) {
                            ((b5) z5Var.f2934a).i(i22, (a5) list3.get(i23));
                        }
                        break;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                    n6.k(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                    n6.o(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 31:
                    n6.n(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 32:
                    n6.i(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 33:
                    n6.l(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 34:
                    n6.g(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, false);
                    break;
                case 35:
                    n6.c(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 36:
                    n6.d(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 37:
                    n6.e(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 38:
                    n6.f(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 39:
                    n6.j(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 40:
                    n6.h(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 41:
                    n6.m(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 42:
                    n6.p(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 43:
                    n6.k(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 44:
                    n6.o(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 45:
                    n6.n(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 46:
                    n6.i(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 47:
                    n6.l(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    n6.g(iArr[i10], (List) unsafe.getObject(obj, j6), z5Var, true);
                    break;
                case 49:
                    int i24 = iArr[i10];
                    List list4 = (List) unsafe.getObject(obj, j6);
                    m6 y10 = f6Var.y(i10);
                    j5 j5Var4 = n6.f2726a;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i25 = 0; i25 < list4.size(); i25++) {
                            z5Var.e(i24, list4.get(i25), y10);
                        }
                        break;
                    }
                    break;
                case 50:
                    Object object2 = unsafe.getObject(obj, j6);
                    if (object2 != null) {
                        int i26 = i10 / 3;
                        t tVar = ((a6) f6Var.f2581b[i26 + i26]).f2493a;
                        z5Var.getClass();
                        for (Map.Entry entry : ((b6) object2).entrySet()) {
                            b5 b5Var4 = (b5) z5Var.f2934a;
                            b5Var4.c(i13, 2);
                            b5Var4.m(a6.b(tVar, entry.getKey(), entry.getValue()));
                            a6.a(b5Var4, tVar, entry.getKey(), entry.getValue());
                        }
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (f6Var.q(i13, i10, obj)) {
                        ((b5) z5Var.f2934a).h(i13, Double.doubleToRawLongBits(((Double) w6.j(obj, j6)).doubleValue()));
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (f6Var.q(i13, i10, obj)) {
                        ((b5) z5Var.f2934a).f(i13, Float.floatToRawIntBits(((Float) w6.j(obj, j6)).floatValue()));
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (f6Var.q(i13, i10, obj)) {
                        ((b5) z5Var.f2934a).g(i13, l(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (f6Var.q(i13, i10, obj)) {
                        ((b5) z5Var.f2934a).g(i13, l(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (f6Var.q(i13, i10, obj)) {
                        ((b5) z5Var.f2934a).d(i13, k(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (f6Var.q(i13, i10, obj)) {
                        ((b5) z5Var.f2934a).h(i13, l(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (f6Var.q(i13, i10, obj)) {
                        ((b5) z5Var.f2934a).f(i13, k(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (f6Var.q(i13, i10, obj)) {
                        boolean booleanValue = ((Boolean) w6.j(obj, j6)).booleanValue();
                        b5 b5Var5 = (b5) z5Var.f2934a;
                        b5Var5.m(i13 << 3);
                        b5Var5.k(booleanValue ? (byte) 1 : (byte) 0);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (f6Var.q(i13, i10, obj)) {
                        Object object3 = unsafe.getObject(obj, j6);
                        if (object3 instanceof String) {
                            b5 b5Var6 = (b5) z5Var.f2934a;
                            b5Var6.m((i13 << 3) | 2);
                            b5Var6.r((String) object3);
                            break;
                        } else {
                            ((b5) z5Var.f2934a).i(i13, (a5) object3);
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (f6Var.q(i13, i10, obj)) {
                        z5Var.d(i13, unsafe.getObject(obj, j6), f6Var.y(i10));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (f6Var.q(i13, i10, obj)) {
                        ((b5) z5Var.f2934a).i(i13, (a5) unsafe.getObject(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (f6Var.q(i13, i10, obj)) {
                        ((b5) z5Var.f2934a).e(i13, k(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (f6Var.q(i13, i10, obj)) {
                        ((b5) z5Var.f2934a).d(i13, k(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (f6Var.q(i13, i10, obj)) {
                        ((b5) z5Var.f2934a).f(i13, k(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (f6Var.q(i13, i10, obj)) {
                        ((b5) z5Var.f2934a).h(i13, l(obj, j6));
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (f6Var.q(i13, i10, obj)) {
                        int k5 = k(obj, j6);
                        ((b5) z5Var.f2934a).e(i13, (k5 >> 31) ^ (k5 + k5));
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (f6Var.q(i13, i10, obj)) {
                        long l10 = l(obj, j6);
                        ((b5) z5Var.f2934a).g(i13, (l10 >> 63) ^ (l10 + l10));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (f6Var.q(i13, i10, obj)) {
                        z5Var.e(i13, unsafe.getObject(obj, j6), f6Var.y(i10));
                        break;
                    } else {
                        break;
                    }
            }
            i10 += 3;
            i6 = 1048575;
            f6Var = this;
        }
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final boolean e(Object obj) {
        int i;
        int i6;
        int i10;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1048575;
        while (i12 < this.g) {
            int i14 = this.f[i12];
            int[] iArr = this.f2580a;
            int i15 = iArr[i14];
            int E = E(i14);
            int i16 = iArr[i14 + 2];
            int i17 = i16 & 1048575;
            int i18 = 1 << (i16 >>> 20);
            if (i17 != i13) {
                if (i17 != 1048575) {
                    i11 = f2579k.getInt(obj, i17);
                }
                i6 = i14;
                i10 = i11;
                i = i17;
            } else {
                int i19 = i11;
                i = i13;
                i6 = i14;
                i10 = i19;
            }
            if ((268435456 & E) == 0 || n(obj, i6, i, i10, i18)) {
                int F = F(E);
                if (F == 9 || F == 17) {
                    if (n(obj, i6, i, i10, i18) && !y(i6).e(w6.j(obj, E & 1048575))) {
                    }
                    i12++;
                    i13 = i;
                    i11 = i10;
                } else {
                    if (F != 27) {
                        if (F == 60 || F == 68) {
                            if (q(i15, i6, obj) && !y(i6).e(w6.j(obj, E & 1048575))) {
                            }
                            i12++;
                            i13 = i;
                            i11 = i10;
                        } else if (F != 49) {
                            if (F != 50) {
                                continue;
                            } else {
                                b6 b6Var = (b6) w6.j(obj, E & 1048575);
                                if (b6Var.isEmpty()) {
                                    continue;
                                } else {
                                    int i20 = i6 / 3;
                                    if (((z6) ((a6) this.f2581b[i20 + i20]).f2493a.f2806b).f2938a == a7.f2502r) {
                                        m6 m6Var = null;
                                        for (Object obj2 : b6Var.values()) {
                                            if (m6Var == null) {
                                                m6Var = j6.f2671c.a(obj2.getClass());
                                            }
                                            if (!m6Var.e(obj2)) {
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            i12++;
                            i13 = i;
                            i11 = i10;
                        }
                    }
                    List list = (List) w6.j(obj, E & 1048575);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        m6 y9 = y(i6);
                        for (int i21 = 0; i21 < list.size(); i21++) {
                            if (y9.e(list.get(i21))) {
                            }
                        }
                    }
                    i12++;
                    i13 = i;
                    i11 = i10;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final boolean f(l5 l5Var, l5 l5Var2) {
        boolean a8;
        int i = 0;
        while (true) {
            int[] iArr = this.f2580a;
            if (i < iArr.length) {
                int E = E(i);
                long j6 = E & 1048575;
                switch (F(E)) {
                    case 0:
                        if (!m(l5Var, l5Var2, i)) {
                            break;
                        } else {
                            v6 v6Var = w6.f2888c;
                            if (Double.doubleToLongBits(v6Var.f(l5Var, j6)) != Double.doubleToLongBits(v6Var.f(l5Var2, j6))) {
                                break;
                            } else {
                                continue;
                                i += 3;
                            }
                        }
                    case 1:
                        if (!m(l5Var, l5Var2, i)) {
                            break;
                        } else {
                            v6 v6Var2 = w6.f2888c;
                            if (Float.floatToIntBits(v6Var2.d(l5Var, j6)) != Float.floatToIntBits(v6Var2.d(l5Var2, j6))) {
                                break;
                            } else {
                                continue;
                                i += 3;
                            }
                        }
                    case 2:
                        if (m(l5Var, l5Var2, i) && w6.h(l5Var, j6) == w6.h(l5Var2, j6)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 3:
                        if (m(l5Var, l5Var2, i) && w6.h(l5Var, j6) == w6.h(l5Var2, j6)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 4:
                        if (m(l5Var, l5Var2, i) && w6.f(l5Var, j6) == w6.f(l5Var2, j6)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 5:
                        if (m(l5Var, l5Var2, i) && w6.h(l5Var, j6) == w6.h(l5Var2, j6)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 6:
                        if (m(l5Var, l5Var2, i) && w6.f(l5Var, j6) == w6.f(l5Var2, j6)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 7:
                        if (!m(l5Var, l5Var2, i)) {
                            break;
                        } else {
                            v6 v6Var3 = w6.f2888c;
                            if (v6Var3.b(l5Var, j6) != v6Var3.b(l5Var2, j6)) {
                                break;
                            } else {
                                continue;
                                i += 3;
                            }
                        }
                    case 8:
                        if (m(l5Var, l5Var2, i) && n6.a(w6.j(l5Var, j6), w6.j(l5Var2, j6))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 9:
                        if (m(l5Var, l5Var2, i) && n6.a(w6.j(l5Var, j6), w6.j(l5Var2, j6))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 10:
                        if (m(l5Var, l5Var2, i) && n6.a(w6.j(l5Var, j6), w6.j(l5Var2, j6))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 11:
                        if (m(l5Var, l5Var2, i) && w6.f(l5Var, j6) == w6.f(l5Var2, j6)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 12:
                        if (m(l5Var, l5Var2, i) && w6.f(l5Var, j6) == w6.f(l5Var2, j6)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 13:
                        if (m(l5Var, l5Var2, i) && w6.f(l5Var, j6) == w6.f(l5Var2, j6)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 14:
                        if (m(l5Var, l5Var2, i) && w6.h(l5Var, j6) == w6.h(l5Var2, j6)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 15:
                        if (m(l5Var, l5Var2, i) && w6.f(l5Var, j6) == w6.f(l5Var2, j6)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 16:
                        if (m(l5Var, l5Var2, i) && w6.h(l5Var, j6) == w6.h(l5Var2, j6)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 17:
                        if (m(l5Var, l5Var2, i) && n6.a(w6.j(l5Var, j6), w6.j(l5Var2, j6))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    case 49:
                        a8 = n6.a(w6.j(l5Var, j6), w6.j(l5Var2, j6));
                        break;
                    case 50:
                        a8 = n6.a(w6.j(l5Var, j6), w6.j(l5Var2, j6));
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    case 64:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    case 68:
                        long j10 = iArr[i + 2] & 1048575;
                        if (w6.f(l5Var, j10) == w6.f(l5Var2, j10) && n6.a(w6.j(l5Var, j6), w6.j(l5Var2, j6))) {
                            continue;
                            i += 3;
                        }
                        break;
                    default:
                        i += 3;
                }
                if (a8) {
                    i += 3;
                }
            } else if (l5Var.zzc.equals(l5Var2.zzc)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void g(Object obj) {
        if (!j(obj)) {
            return;
        }
        if (obj instanceof l5) {
            l5 l5Var = (l5) obj;
            l5Var.i();
            l5Var.zza = 0;
            l5Var.f();
        }
        int i = 0;
        while (true) {
            int[] iArr = this.f2580a;
            if (i >= iArr.length) {
                this.i.getClass();
                r6 r6Var = ((l5) obj).zzc;
                if (r6Var.f2784e) {
                    r6Var.f2784e = false;
                    return;
                }
                return;
            }
            int E = E(i);
            int i6 = 1048575 & E;
            int F = F(E);
            long j6 = i6;
            if (F != 9) {
                if (F != 60 && F != 68) {
                    switch (F) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                        case 49:
                            t4 t4Var = (t4) ((q5) w6.j(obj, j6));
                            if (!t4Var.f2807a) {
                                break;
                            } else {
                                t4Var.f2807a = false;
                                break;
                            }
                        case 50:
                            Unsafe unsafe = f2579k;
                            Object object = unsafe.getObject(obj, j6);
                            if (object == null) {
                                break;
                            } else {
                                ((b6) object).f2517a = false;
                                unsafe.putObject(obj, j6, object);
                                break;
                            }
                    }
                } else if (q(iArr[i], i, obj)) {
                    y(i).g(f2579k.getObject(obj, j6));
                }
                i += 3;
            }
            if (o(i, obj)) {
                y(i).g(f2579k.getObject(obj, j6));
            }
            i += 3;
        }
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void h(Object obj, byte[] bArr, int i, int i6, v4 v4Var) {
        t(obj, bArr, i, i6, 0, v4Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x01ea, code lost:
    
        if (r2 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d9, code lost:
    
        if (r2 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00db, code lost:
    
        r6 = 1231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00dc, code lost:
    
        r1 = r6 + r1;
     */
    @Override // com.google.android.gms.internal.measurement.m6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(com.google.android.gms.internal.measurement.l5 r11) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.f6.i(com.google.android.gms.internal.measurement.l5):int");
    }

    public final boolean m(l5 l5Var, l5 l5Var2, int i) {
        return o(i, l5Var) == o(i, l5Var2);
    }

    public final boolean n(Object obj, int i, int i6, int i10, int i11) {
        return i6 == 1048575 ? o(i, obj) : (i10 & i11) != 0;
    }

    public final boolean o(int i, Object obj) {
        int i6 = this.f2580a[i + 2];
        long j6 = i6 & 1048575;
        if (j6 == 1048575) {
            int E = E(i);
            long j10 = E & 1048575;
            switch (F(E)) {
                case 0:
                    if (Double.doubleToRawLongBits(w6.f2888c.f(obj, j10)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(w6.f2888c.d(obj, j10)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (w6.h(obj, j10) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (w6.h(obj, j10) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (w6.f(obj, j10) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (w6.h(obj, j10) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (w6.f(obj, j10) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return w6.f2888c.b(obj, j10);
                case 8:
                    Object j11 = w6.j(obj, j10);
                    if (j11 instanceof String) {
                        if (((String) j11).isEmpty()) {
                            return false;
                        }
                    } else {
                        if (!(j11 instanceof a5)) {
                            s1.o.n();
                            return false;
                        }
                        if (a5.f2490l.equals(j11)) {
                            return false;
                        }
                    }
                    break;
                case 9:
                    if (w6.j(obj, j10) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (a5.f2490l.equals(w6.j(obj, j10))) {
                        return false;
                    }
                    break;
                case 11:
                    if (w6.f(obj, j10) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (w6.f(obj, j10) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (w6.f(obj, j10) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (w6.h(obj, j10) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (w6.f(obj, j10) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (w6.h(obj, j10) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (w6.j(obj, j10) == null) {
                        return false;
                    }
                    break;
                default:
                    s1.o.n();
                    return false;
            }
        } else if (((1 << (i6 >>> 20)) & w6.f(obj, j6)) == 0) {
            return false;
        }
        return true;
    }

    public final void p(int i, Object obj) {
        int i6 = this.f2580a[i + 2];
        long j6 = 1048575 & i6;
        if (j6 == 1048575) {
            return;
        }
        w6.g(obj, j6, (1 << (i6 >>> 20)) | w6.f(obj, j6));
    }

    public final boolean q(int i, int i6, Object obj) {
        return w6.f(obj, (long) (this.f2580a[i6 + 2] & 1048575)) == i;
    }

    public final int r(int i, int i6) {
        int[] iArr = this.f2580a;
        int length = (iArr.length / 3) - 1;
        while (i6 <= length) {
            int i10 = (length + i6) >>> 1;
            int i11 = i10 * 3;
            int i12 = iArr[i11];
            if (i == i12) {
                return i11;
            }
            if (i < i12) {
                length = i10 - 1;
            } else {
                i6 = i10 + 1;
            }
        }
        return -1;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final int t(java.lang.Object r42, byte[] r43, int r44, int r45, int r46, com.google.android.gms.internal.measurement.v4 r47) {
        /*
            Method dump skipped, instructions count: 4130
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.f6.t(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.v4):int");
    }

    public final void w(int i, Object obj, Object obj2) {
        if (o(i, obj2)) {
            int E = E(i) & 1048575;
            Unsafe unsafe = f2579k;
            long j6 = E;
            Object object = unsafe.getObject(obj2, j6);
            if (object == null) {
                int i6 = this.f2580a[i];
                String obj3 = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i6).length() + 38 + obj3.length());
                sb.append("Source subfield ");
                sb.append(i6);
                sb.append(" is present but null: ");
                sb.append(obj3);
                throw new IllegalStateException(sb.toString());
            }
            m6 y9 = y(i);
            if (!o(i, obj)) {
                if (j(object)) {
                    l5 a8 = y9.a();
                    y9.b(a8, object);
                    unsafe.putObject(obj, j6, a8);
                } else {
                    unsafe.putObject(obj, j6, object);
                }
                p(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!j(object2)) {
                l5 a10 = y9.a();
                y9.b(a10, object2);
                unsafe.putObject(obj, j6, a10);
                object2 = a10;
            }
            y9.b(object2, object);
        }
    }

    public final void x(int i, Object obj, Object obj2) {
        int[] iArr = this.f2580a;
        int i6 = iArr[i];
        if (q(i6, i, obj2)) {
            int E = E(i) & 1048575;
            Unsafe unsafe = f2579k;
            long j6 = E;
            Object object = unsafe.getObject(obj2, j6);
            if (object == null) {
                int i10 = iArr[i];
                String obj3 = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 38 + obj3.length());
                sb.append("Source subfield ");
                sb.append(i10);
                sb.append(" is present but null: ");
                sb.append(obj3);
                throw new IllegalStateException(sb.toString());
            }
            m6 y9 = y(i);
            if (!q(i6, i, obj)) {
                if (j(object)) {
                    l5 a8 = y9.a();
                    y9.b(a8, object);
                    unsafe.putObject(obj, j6, a8);
                } else {
                    unsafe.putObject(obj, j6, object);
                }
                w6.g(obj, iArr[i + 2] & 1048575, i6);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!j(object2)) {
                l5 a10 = y9.a();
                y9.b(a10, object2);
                unsafe.putObject(obj, j6, a10);
                object2 = a10;
            }
            y9.b(object2, object);
        }
    }

    public final m6 y(int i) {
        int i6 = i / 3;
        int i10 = i6 + i6;
        Object[] objArr = this.f2581b;
        m6 m6Var = (m6) objArr[i10];
        if (m6Var != null) {
            return m6Var;
        }
        m6 a8 = j6.f2671c.a((Class) objArr[i10 + 1]);
        objArr[i10] = a8;
        return a8;
    }

    public final s1 z(int i) {
        int i6 = i / 3;
        return (s1) this.f2581b[i6 + i6 + 1];
    }
}
