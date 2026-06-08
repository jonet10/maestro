package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r6 {
    public static final r6 f = new r6(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f2780a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f2781b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f2782c;

    /* renamed from: d, reason: collision with root package name */
    public int f2783d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2784e;

    public r6(int i, int[] iArr, Object[] objArr, boolean z9) {
        this.f2780a = i;
        this.f2781b = iArr;
        this.f2782c = objArr;
        this.f2784e = z9;
    }

    public static r6 a() {
        return new r6(0, new int[8], new Object[8], true);
    }

    public final void b(z5 z5Var) {
        if (this.f2780a != 0) {
            for (int i = 0; i < this.f2780a; i++) {
                int i6 = this.f2781b[i];
                Object obj = this.f2782c[i];
                int i10 = i6 & 7;
                int i11 = i6 >>> 3;
                if (i10 == 0) {
                    ((b5) z5Var.f2934a).g(i11, ((Long) obj).longValue());
                } else if (i10 == 1) {
                    ((b5) z5Var.f2934a).h(i11, ((Long) obj).longValue());
                } else if (i10 == 2) {
                    ((b5) z5Var.f2934a).i(i11, (a5) obj);
                } else if (i10 == 3) {
                    ((b5) z5Var.f2934a).c(i11, 3);
                    ((r6) obj).b(z5Var);
                    ((b5) z5Var.f2934a).c(i11, 4);
                } else {
                    if (i10 != 5) {
                        com.google.gson.internal.a.k(new s5());
                        return;
                    }
                    ((b5) z5Var.f2934a).f(i11, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int c() {
        int s6;
        int a8;
        int s9;
        int i = this.f2783d;
        if (i != -1) {
            return i;
        }
        int i6 = 0;
        for (int i10 = 0; i10 < this.f2780a; i10++) {
            int i11 = this.f2781b[i10];
            int i12 = i11 >>> 3;
            int i13 = i11 & 7;
            if (i13 != 0) {
                if (i13 == 1) {
                    ((Long) this.f2782c[i10]).getClass();
                    s9 = b5.s(i12 << 3) + 8;
                } else if (i13 == 2) {
                    int i14 = i12 << 3;
                    a5 a5Var = (a5) this.f2782c[i10];
                    int s10 = b5.s(i14);
                    int d10 = a5Var.d();
                    i6 = androidx.lifecycle.l.n(d10, d10, s10, i6);
                } else if (i13 == 3) {
                    int s11 = b5.s(i12 << 3);
                    s6 = s11 + s11;
                    a8 = ((r6) this.f2782c[i10]).c();
                } else {
                    if (i13 != 5) {
                        throw new IllegalStateException(new s5());
                    }
                    ((Integer) this.f2782c[i10]).getClass();
                    s9 = b5.s(i12 << 3) + 4;
                }
                i6 = s9 + i6;
            } else {
                int i15 = i12 << 3;
                long longValue = ((Long) this.f2782c[i10]).longValue();
                s6 = b5.s(i15);
                a8 = b5.a(longValue);
            }
            i6 = a8 + s6 + i6;
        }
        this.f2783d = i6;
        return i6;
    }

    public final void d(int i, Object obj) {
        if (!this.f2784e) {
            com.google.gson.internal.a.q();
            return;
        }
        e(this.f2780a + 1);
        int[] iArr = this.f2781b;
        int i6 = this.f2780a;
        iArr[i6] = i;
        this.f2782c[i6] = obj;
        this.f2780a = i6 + 1;
    }

    public final void e(int i) {
        int[] iArr = this.f2781b;
        if (i > iArr.length) {
            int i6 = this.f2780a;
            int i10 = (i6 / 2) + i6;
            if (i10 >= i) {
                i = i10;
            }
            if (i < 8) {
                i = 8;
            }
            this.f2781b = Arrays.copyOf(iArr, i);
            this.f2782c = Arrays.copyOf(this.f2782c, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof r6)) {
            r6 r6Var = (r6) obj;
            int i = this.f2780a;
            if (i == r6Var.f2780a) {
                int[] iArr = this.f2781b;
                int[] iArr2 = r6Var.f2781b;
                int i6 = 0;
                while (true) {
                    if (i6 >= i) {
                        Object[] objArr = this.f2782c;
                        Object[] objArr2 = r6Var.f2782c;
                        int i10 = this.f2780a;
                        for (int i11 = 0; i11 < i10; i11++) {
                            if (objArr[i11].equals(objArr2[i11])) {
                            }
                        }
                        return true;
                    }
                    if (iArr[i6] != iArr2[i6]) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f2780a;
        int i6 = i + 527;
        int[] iArr = this.f2781b;
        int i10 = 17;
        int i11 = 17;
        for (int i12 = 0; i12 < i; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        int i13 = ((i6 * 31) + i11) * 31;
        Object[] objArr = this.f2782c;
        int i14 = this.f2780a;
        for (int i15 = 0; i15 < i14; i15++) {
            i10 = (i10 * 31) + objArr[i15].hashCode();
        }
        return i13 + i10;
    }
}
