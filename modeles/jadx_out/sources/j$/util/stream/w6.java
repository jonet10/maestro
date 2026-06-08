package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class w6 extends c implements Consumer, Iterable {

    /* renamed from: e, reason: collision with root package name */
    public Object[] f6417e = new Object[1 << 4];
    public Object[][] f;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    public final void p(long j) {
        long length;
        int i = this.f6153c;
        if (i == 0) {
            length = this.f6417e.length;
        } else {
            length = this.f6154d[i] + this.f[i].length;
        }
        if (j > length) {
            if (this.f == null) {
                Object[][] objArr = new Object[8][];
                this.f = objArr;
                this.f6154d = new long[8];
                objArr[0] = this.f6417e;
            }
            int i6 = i + 1;
            while (j > length) {
                Object[][] objArr2 = this.f;
                if (i6 >= objArr2.length) {
                    int length2 = objArr2.length * 2;
                    this.f = (Object[][]) Arrays.copyOf(objArr2, length2);
                    this.f6154d = Arrays.copyOf(this.f6154d, length2);
                }
                int i10 = this.f6151a;
                if (i6 != 0 && i6 != 1) {
                    i10 = Math.min((i10 + i6) - 1, 30);
                }
                int i11 = 1 << i10;
                this.f[i6] = new Object[i11];
                long[] jArr = this.f6154d;
                jArr[i6] = jArr[i6 - 1] + r5[r7].length;
                length += i11;
                i6++;
            }
        }
    }

    @Override // j$.util.stream.c
    public final void clear() {
        Object[][] objArr = this.f;
        if (objArr != null) {
            this.f6417e = objArr[0];
            int i = 0;
            while (true) {
                Object[] objArr2 = this.f6417e;
                if (i >= objArr2.length) {
                    break;
                }
                objArr2[i] = null;
                i++;
            }
            this.f = null;
            this.f6154d = null;
        } else {
            for (int i6 = 0; i6 < this.f6152b; i6++) {
                this.f6417e[i6] = null;
            }
        }
        this.f6152b = 0;
        this.f6153c = 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        j$.util.Spliterator spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new j$.util.g1(spliterator);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer consumer) {
        for (int i = 0; i < this.f6153c; i++) {
            for (Object obj : this.f[i]) {
                consumer.n(obj);
            }
        }
        for (int i6 = 0; i6 < this.f6152b; i6++) {
            consumer.n(this.f6417e[i6]);
        }
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public void n(Object obj) {
        long length;
        int i = this.f6152b;
        Object[] objArr = this.f6417e;
        if (i == objArr.length) {
            if (this.f == null) {
                Object[][] objArr2 = new Object[8][];
                this.f = objArr2;
                this.f6154d = new long[8];
                objArr2[0] = objArr;
            }
            int i6 = this.f6153c;
            int i10 = i6 + 1;
            Object[][] objArr3 = this.f;
            if (i10 >= objArr3.length || objArr3[i10] == null) {
                if (i6 == 0) {
                    length = objArr.length;
                } else {
                    length = objArr3[i6].length + this.f6154d[i6];
                }
                p(length + 1);
            }
            this.f6152b = 0;
            int i11 = this.f6153c + 1;
            this.f6153c = i11;
            this.f6417e = this.f[i11];
        }
        Object[] objArr4 = this.f6417e;
        int i12 = this.f6152b;
        this.f6152b = i12 + 1;
        objArr4[i12] = obj;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        Objects.requireNonNull(arrayList);
        forEach(new j$.util.q(9, arrayList));
        return "SpinedBuffer:" + arrayList.toString();
    }

    @Override // java.lang.Iterable
    public j$.util.Spliterator spliterator() {
        return new n6(this, 0, this.f6153c, 0, this.f6152b);
    }
}
