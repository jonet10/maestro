package r6;

import java.util.AbstractList;
import java.util.ListIterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements ListIterator, e7.a {

    /* renamed from: b, reason: collision with root package name */
    public int f8910b;

    /* renamed from: m, reason: collision with root package name */
    public int f8912m;

    /* renamed from: n, reason: collision with root package name */
    public final q6.f f8913n;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8909a = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f8911l = -1;

    public a(c cVar, int i) {
        int i6;
        this.f8913n = cVar;
        this.f8910b = i;
        i6 = ((AbstractList) cVar).modCount;
        this.f8912m = i6;
    }

    public void a() {
        int i;
        i = ((AbstractList) ((b) this.f8913n).f8918n).modCount;
        if (i == this.f8912m) {
            return;
        }
        a3.b.i();
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i;
        int i6;
        switch (this.f8909a) {
            case 0:
                a();
                b bVar = (b) this.f8913n;
                int i10 = this.f8910b;
                this.f8910b = i10 + 1;
                bVar.add(i10, obj);
                this.f8911l = -1;
                i = ((AbstractList) bVar).modCount;
                this.f8912m = i;
                break;
            default:
                c();
                c cVar = (c) this.f8913n;
                int i11 = this.f8910b;
                this.f8910b = i11 + 1;
                cVar.add(i11, obj);
                this.f8911l = -1;
                i6 = ((AbstractList) cVar).modCount;
                this.f8912m = i6;
                break;
        }
    }

    public void c() {
        int i;
        i = ((AbstractList) ((c) this.f8913n)).modCount;
        if (i == this.f8912m) {
            return;
        }
        a3.b.i();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f8909a) {
            case 0:
                if (this.f8910b < ((b) this.f8913n).f8916l) {
                }
                break;
            default:
                if (this.f8910b < ((c) this.f8913n).f8921b) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f8909a) {
            case 0:
                if (this.f8910b > 0) {
                }
                break;
            default:
                if (this.f8910b > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f8909a) {
            case 0:
                a();
                int i = this.f8910b;
                b bVar = (b) this.f8913n;
                if (i >= bVar.f8916l) {
                    com.google.gson.internal.a.l();
                    break;
                } else {
                    this.f8910b = i + 1;
                    this.f8911l = i;
                    break;
                }
            default:
                c();
                int i6 = this.f8910b;
                c cVar = (c) this.f8913n;
                if (i6 >= cVar.f8921b) {
                    com.google.gson.internal.a.l();
                    break;
                } else {
                    this.f8910b = i6 + 1;
                    this.f8911l = i6;
                    break;
                }
        }
        return null;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f8909a) {
        }
        return this.f8910b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f8909a) {
            case 0:
                a();
                int i = this.f8910b;
                if (i <= 0) {
                    com.google.gson.internal.a.l();
                    break;
                } else {
                    int i6 = i - 1;
                    this.f8910b = i6;
                    this.f8911l = i6;
                    b bVar = (b) this.f8913n;
                    break;
                }
            default:
                c();
                int i10 = this.f8910b;
                if (i10 <= 0) {
                    com.google.gson.internal.a.l();
                    break;
                } else {
                    int i11 = i10 - 1;
                    this.f8910b = i11;
                    this.f8911l = i11;
                    break;
                }
        }
        return null;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i;
        switch (this.f8909a) {
            case 0:
                i = this.f8910b;
                break;
            default:
                i = this.f8910b;
                break;
        }
        return i - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i;
        int i6;
        switch (this.f8909a) {
            case 0:
                b bVar = (b) this.f8913n;
                a();
                int i10 = this.f8911l;
                if (i10 == -1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Call next() or previous() before removing element from the iterator.");
                    break;
                } else {
                    bVar.d(i10);
                    this.f8910b = this.f8911l;
                    this.f8911l = -1;
                    i = ((AbstractList) bVar).modCount;
                    this.f8912m = i;
                    break;
                }
            default:
                c cVar = (c) this.f8913n;
                c();
                int i11 = this.f8911l;
                if (i11 == -1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Call next() or previous() before removing element from the iterator.");
                    break;
                } else {
                    cVar.d(i11);
                    this.f8910b = this.f8911l;
                    this.f8911l = -1;
                    i6 = ((AbstractList) cVar).modCount;
                    this.f8912m = i6;
                    break;
                }
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f8909a) {
            case 0:
                a();
                int i = this.f8911l;
                if (i == -1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Call next() or previous() before replacing element from the iterator.");
                    break;
                } else {
                    ((b) this.f8913n).set(i, obj);
                    break;
                }
            default:
                c();
                int i6 = this.f8911l;
                if (i6 == -1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Call next() or previous() before replacing element from the iterator.");
                    break;
                } else {
                    ((c) this.f8913n).set(i6, obj);
                    break;
                }
        }
    }

    public a(b bVar, int i) {
        int i6;
        this.f8913n = bVar;
        this.f8910b = i;
        i6 = ((AbstractList) bVar).modCount;
        this.f8912m = i6;
    }
}
