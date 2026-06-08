package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y5 extends t4 implements RandomAccess, p5, i6 {

    /* renamed from: m, reason: collision with root package name */
    public static final long[] f2915m;

    /* renamed from: n, reason: collision with root package name */
    public static final y5 f2916n;

    /* renamed from: b, reason: collision with root package name */
    public long[] f2917b;

    /* renamed from: l, reason: collision with root package name */
    public int f2918l;

    static {
        long[] jArr = new long[0];
        f2915m = jArr;
        f2916n = new y5(jArr, 0, false);
    }

    public y5(long[] jArr, int i, boolean z9) {
        super(z9);
        this.f2917b = jArr;
        this.f2918l = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i6;
        long longValue = ((Long) obj).longValue();
        b();
        if (i < 0 || i > (i6 = this.f2918l)) {
            com.google.gson.internal.a.r(v4.a(this.f2918l, i, (byte) 13, "Index:", ", Size:"));
            return;
        }
        int i10 = i + 1;
        long[] jArr = this.f2917b;
        int length = jArr.length;
        if (i6 < length) {
            System.arraycopy(jArr, i, jArr, i10, i6 - i);
        } else {
            long[] jArr2 = new long[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2917b, 0, jArr2, 0, i);
            System.arraycopy(this.f2917b, i, jArr2, i10, this.f2918l - i);
            this.f2917b = jArr2;
        }
        this.f2917b[i] = longValue;
        this.f2918l++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.t4, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = r5.f2778a;
        collection.getClass();
        if (!(collection instanceof y5)) {
            return super.addAll(collection);
        }
        y5 y5Var = (y5) collection;
        int i = y5Var.f2918l;
        if (i == 0) {
            return false;
        }
        int i6 = this.f2918l;
        if (Integer.MAX_VALUE - i6 < i) {
            throw new OutOfMemoryError();
        }
        int i10 = i6 + i;
        long[] jArr = this.f2917b;
        if (i10 > jArr.length) {
            this.f2917b = Arrays.copyOf(jArr, i10);
        }
        System.arraycopy(y5Var.f2917b, 0, this.f2917b, this.f2918l, y5Var.f2918l);
        this.f2918l = i10;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final long c(int i) {
        g(i);
        return this.f2917b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.q5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final y5 j(int i) {
        if (i >= this.f2918l) {
            return new y5(i == 0 ? f2915m : Arrays.copyOf(this.f2917b, i), this.f2918l, true);
        }
        s1.o.n();
        return null;
    }

    public final void e(long j) {
        b();
        int i = this.f2918l;
        int length = this.f2917b.length;
        if (i == length) {
            long[] jArr = new long[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2917b, 0, jArr, 0, this.f2918l);
            this.f2917b = jArr;
        }
        long[] jArr2 = this.f2917b;
        int i6 = this.f2918l;
        this.f2918l = i6 + 1;
        jArr2[i6] = j;
    }

    @Override // com.google.android.gms.internal.measurement.t4, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y5)) {
            return super.equals(obj);
        }
        y5 y5Var = (y5) obj;
        if (this.f2918l != y5Var.f2918l) {
            return false;
        }
        long[] jArr = y5Var.f2917b;
        for (int i = 0; i < this.f2918l; i++) {
            if (this.f2917b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void g(int i) {
        if (i < 0 || i >= this.f2918l) {
            com.google.gson.internal.a.r(v4.a(this.f2918l, i, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        g(i);
        return Long.valueOf(this.f2917b[i]);
    }

    @Override // com.google.android.gms.internal.measurement.t4, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i6 = 0; i6 < this.f2918l; i6++) {
            long j = this.f2917b[i6];
            Charset charset = r5.f2778a;
            i = (i * 31) + ((int) (j ^ (j >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i = this.f2918l;
        for (int i6 = 0; i6 < i; i6++) {
            if (this.f2917b[i6] == longValue) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.t4, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        b();
        g(i);
        long[] jArr = this.f2917b;
        long j = jArr[i];
        if (i < this.f2918l - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.f2918l--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i6) {
        b();
        if (i6 < i) {
            com.google.gson.internal.a.r("toIndex < fromIndex");
            return;
        }
        long[] jArr = this.f2917b;
        System.arraycopy(jArr, i6, jArr, i, this.f2918l - i6);
        this.f2918l -= i6 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        b();
        g(i);
        long[] jArr = this.f2917b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2918l;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        e(((Long) obj).longValue());
        return true;
    }
}
