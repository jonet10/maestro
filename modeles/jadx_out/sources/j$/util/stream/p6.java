package j$.util.stream;

import j$.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class p6 extends v6 implements DoubleConsumer {
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // j$.util.stream.v6
    public final void p(Object obj, int i, int i6, Object obj2) {
        double[] dArr = (double[]) obj;
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj2;
        while (i < i6) {
            doubleConsumer.accept(dArr[i]);
            i++;
        }
    }

    @Override // j$.util.stream.v6
    public final int q(Object obj) {
        return ((double[]) obj).length;
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            g((DoubleConsumer) consumer);
        } else {
            if (h8.f6218a) {
                h8.a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
                throw null;
            }
            j$.util.c.a((o6) spliterator(), consumer);
        }
    }

    @Override // j$.util.stream.v6
    public final Object[] t() {
        return new double[8][];
    }

    @Override // j$.util.stream.v6
    public final Object newArray(int i) {
        return new double[i];
    }

    @Override // java.util.function.DoubleConsumer
    public void accept(double d10) {
        u();
        double[] dArr = (double[]) this.f6401e;
        int i = this.f6152b;
        this.f6152b = i + 1;
        dArr[i] = d10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        j$.util.v0 spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new j$.util.j1(spliterator);
    }

    @Override // j$.util.stream.v6, java.lang.Iterable, j$.util.stream.h2
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public j$.util.v0 spliterator() {
        return new o6(this, 0, this.f6153c, 0, this.f6152b);
    }

    public final String toString() {
        double[] dArr = (double[]) b();
        if (dArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f6153c), Arrays.toString(dArr));
        }
        return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f6153c), Arrays.toString(Arrays.copyOf(dArr, 200)));
    }
}
