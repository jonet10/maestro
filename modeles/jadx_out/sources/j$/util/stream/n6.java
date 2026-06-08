package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class n6 implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public int f6299a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6300b;

    /* renamed from: c, reason: collision with root package name */
    public int f6301c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6302d;

    /* renamed from: e, reason: collision with root package name */
    public Object[] f6303e;
    public final /* synthetic */ w6 f;

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 16464;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.util.c.e(this, i);
    }

    public n6(w6 w6Var, int i, int i6, int i10, int i11) {
        this.f = w6Var;
        this.f6299a = i;
        this.f6300b = i6;
        this.f6301c = i10;
        this.f6302d = i11;
        Object[][] objArr = w6Var.f;
        this.f6303e = objArr == null ? w6Var.f6417e : objArr[i];
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        int i = this.f6299a;
        int i6 = this.f6302d;
        int i10 = this.f6300b;
        if (i == i10) {
            return i6 - this.f6301c;
        }
        long[] jArr = this.f.f6154d;
        return ((jArr[i10] + i6) - jArr[i]) - this.f6301c;
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        int i = this.f6299a;
        int i6 = this.f6300b;
        if (i >= i6 && (i != i6 || this.f6301c >= this.f6302d)) {
            return false;
        }
        Object[] objArr = this.f6303e;
        int i10 = this.f6301c;
        this.f6301c = i10 + 1;
        consumer.n(objArr[i10]);
        if (this.f6301c == this.f6303e.length) {
            this.f6301c = 0;
            int i11 = this.f6299a + 1;
            this.f6299a = i11;
            Object[][] objArr2 = this.f.f;
            if (objArr2 != null && i11 <= i6) {
                this.f6303e = objArr2[i11];
            }
        }
        return true;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        w6 w6Var;
        Objects.requireNonNull(consumer);
        int i = this.f6299a;
        int i6 = this.f6302d;
        int i10 = this.f6300b;
        if (i < i10 || (i == i10 && this.f6301c < i6)) {
            int i11 = this.f6301c;
            while (true) {
                w6Var = this.f;
                if (i >= i10) {
                    break;
                }
                Object[] objArr = w6Var.f[i];
                while (i11 < objArr.length) {
                    consumer.n(objArr[i11]);
                    i11++;
                }
                i++;
                i11 = 0;
            }
            Object[] objArr2 = this.f6299a == i10 ? this.f6303e : w6Var.f[i10];
            while (i11 < i6) {
                consumer.n(objArr2[i11]);
                i11++;
            }
            this.f6299a = i10;
            this.f6301c = i6;
        }
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        int i = this.f6299a;
        int i6 = this.f6300b;
        if (i < i6) {
            int i10 = i6 - 1;
            int i11 = this.f6301c;
            w6 w6Var = this.f;
            n6 n6Var = new n6(w6Var, i, i10, i11, w6Var.f[i10].length);
            this.f6299a = i6;
            this.f6301c = 0;
            this.f6303e = w6Var.f[i6];
            return n6Var;
        }
        if (i != i6) {
            return null;
        }
        int i12 = this.f6301c;
        int i13 = (this.f6302d - i12) / 2;
        if (i13 == 0) {
            return null;
        }
        j$.util.k1 v = j$.util.c.v(this.f6303e, i12, i12 + i13);
        this.f6301c += i13;
        return v;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }
}
