package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m5 extends t4 implements RandomAccess, o5, i6 {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f2710m;

    /* renamed from: n, reason: collision with root package name */
    public static final m5 f2711n;

    /* renamed from: b, reason: collision with root package name */
    public int[] f2712b;

    /* renamed from: l, reason: collision with root package name */
    public int f2713l;

    static {
        int[] iArr = new int[0];
        f2710m = iArr;
        f2711n = new m5(iArr, 0, false);
    }

    public m5(int[] iArr, int i, boolean z9) {
        super(z9);
        this.f2712b = iArr;
        this.f2713l = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i6;
        int intValue = ((Integer) obj).intValue();
        b();
        if (i < 0 || i > (i6 = this.f2713l)) {
            com.google.gson.internal.a.r(v4.a(this.f2713l, i, (byte) 13, "Index:", ", Size:"));
            return;
        }
        int i10 = i + 1;
        int[] iArr = this.f2712b;
        int length = iArr.length;
        if (i6 < length) {
            System.arraycopy(iArr, i, iArr, i10, i6 - i);
        } else {
            int[] iArr2 = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2712b, 0, iArr2, 0, i);
            System.arraycopy(this.f2712b, i, iArr2, i10, this.f2713l - i);
            this.f2712b = iArr2;
        }
        this.f2712b[i] = intValue;
        this.f2713l++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.t4, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = r5.f2778a;
        collection.getClass();
        if (!(collection instanceof m5)) {
            return super.addAll(collection);
        }
        m5 m5Var = (m5) collection;
        int i = m5Var.f2713l;
        if (i == 0) {
            return false;
        }
        int i6 = this.f2713l;
        if (Integer.MAX_VALUE - i6 < i) {
            throw new OutOfMemoryError();
        }
        int i10 = i6 + i;
        int[] iArr = this.f2712b;
        if (i10 > iArr.length) {
            this.f2712b = Arrays.copyOf(iArr, i10);
        }
        System.arraycopy(m5Var.f2712b, 0, this.f2712b, this.f2713l, m5Var.f2713l);
        this.f2713l = i10;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.q5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final m5 j(int i) {
        if (i >= this.f2713l) {
            return new m5(i == 0 ? f2710m : Arrays.copyOf(this.f2712b, i), this.f2713l, true);
        }
        s1.o.n();
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int d(int i) {
        g(i);
        return this.f2712b[i];
    }

    public final void e(int i) {
        b();
        int i6 = this.f2713l;
        int length = this.f2712b.length;
        if (i6 == length) {
            int[] iArr = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2712b, 0, iArr, 0, this.f2713l);
            this.f2712b = iArr;
        }
        int[] iArr2 = this.f2712b;
        int i10 = this.f2713l;
        this.f2713l = i10 + 1;
        iArr2[i10] = i;
    }

    @Override // com.google.android.gms.internal.measurement.t4, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m5)) {
            return super.equals(obj);
        }
        m5 m5Var = (m5) obj;
        if (this.f2713l != m5Var.f2713l) {
            return false;
        }
        int[] iArr = m5Var.f2712b;
        for (int i = 0; i < this.f2713l; i++) {
            if (this.f2712b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void g(int i) {
        if (i < 0 || i >= this.f2713l) {
            com.google.gson.internal.a.r(v4.a(this.f2713l, i, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        g(i);
        return Integer.valueOf(this.f2712b[i]);
    }

    @Override // com.google.android.gms.internal.measurement.t4, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i6 = 0; i6 < this.f2713l; i6++) {
            i = (i * 31) + this.f2712b[i6];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i = this.f2713l;
        for (int i6 = 0; i6 < i; i6++) {
            if (this.f2712b[i6] == intValue) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.t4, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        b();
        g(i);
        int[] iArr = this.f2712b;
        int i6 = iArr[i];
        if (i < this.f2713l - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.f2713l--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i6) {
        b();
        if (i6 < i) {
            com.google.gson.internal.a.r("toIndex < fromIndex");
            return;
        }
        int[] iArr = this.f2712b;
        System.arraycopy(iArr, i6, iArr, i, this.f2713l - i6);
        this.f2713l -= i6 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        b();
        g(i);
        int[] iArr = this.f2712b;
        int i6 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2713l;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        e(((Integer) obj).intValue());
        return true;
    }
}
