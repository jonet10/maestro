package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k6 extends t4 implements RandomAccess {

    /* renamed from: m, reason: collision with root package name */
    public static final Object[] f2688m;

    /* renamed from: n, reason: collision with root package name */
    public static final k6 f2689n;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f2690b;

    /* renamed from: l, reason: collision with root package name */
    public int f2691l;

    static {
        Object[] objArr = new Object[0];
        f2688m = objArr;
        f2689n = new k6(objArr, 0, false);
    }

    public k6(Object[] objArr, int i, boolean z9) {
        super(z9);
        this.f2690b = objArr;
        this.f2691l = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i6;
        b();
        if (i < 0 || i > (i6 = this.f2691l)) {
            com.google.gson.internal.a.r(v4.a(this.f2691l, i, (byte) 13, "Index:", ", Size:"));
            return;
        }
        int i10 = i + 1;
        Object[] objArr = this.f2690b;
        int length = objArr.length;
        if (i6 < length) {
            System.arraycopy(objArr, i, objArr, i10, i6 - i);
        } else {
            Object[] objArr2 = new Object[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2690b, 0, objArr2, 0, i);
            System.arraycopy(this.f2690b, i, objArr2, i10, this.f2691l - i);
            this.f2690b = objArr2;
        }
        this.f2690b[i] = obj;
        this.f2691l++;
        ((AbstractList) this).modCount++;
    }

    public final void c(int i) {
        if (i < 0 || i >= this.f2691l) {
            com.google.gson.internal.a.r(v4.a(this.f2691l, i, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        c(i);
        return this.f2690b[i];
    }

    @Override // com.google.android.gms.internal.measurement.q5
    public final /* bridge */ /* synthetic */ q5 j(int i) {
        if (i >= this.f2691l) {
            return new k6(i == 0 ? f2688m : Arrays.copyOf(this.f2690b, i), this.f2691l, true);
        }
        s1.o.n();
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.t4, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        b();
        c(i);
        Object[] objArr = this.f2690b;
        Object obj = objArr[i];
        if (i < this.f2691l - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f2691l--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        b();
        c(i);
        Object[] objArr = this.f2690b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2691l;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        int i = this.f2691l;
        int length = this.f2690b.length;
        if (i == length) {
            this.f2690b = Arrays.copyOf(this.f2690b, Math.max(((length * 3) / 2) + 1, 10));
        }
        Object[] objArr = this.f2690b;
        int i6 = this.f2691l;
        this.f2691l = i6 + 1;
        objArr[i6] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
