package j$.util.stream;

import j$.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class t6 extends v6 implements LongConsumer {
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.v6
    public final void p(Object obj, int i, int i6, Object obj2) {
        long[] jArr = (long[]) obj;
        LongConsumer longConsumer = (LongConsumer) obj2;
        while (i < i6) {
            longConsumer.accept(jArr[i]);
            i++;
        }
    }

    @Override // j$.util.stream.v6
    public final int q(Object obj) {
        return ((long[]) obj).length;
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            g((LongConsumer) consumer);
        } else {
            if (h8.f6218a) {
                h8.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
                throw null;
            }
            j$.util.c.c((s6) spliterator(), consumer);
        }
    }

    @Override // j$.util.stream.v6
    public final Object[] t() {
        return new long[8][];
    }

    @Override // j$.util.stream.v6
    public final Object newArray(int i) {
        return new long[i];
    }

    @Override // java.util.function.LongConsumer
    public void accept(long j) {
        u();
        long[] jArr = (long[]) this.f6401e;
        int i = this.f6152b;
        this.f6152b = i + 1;
        jArr[i] = j;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        j$.util.b1 spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new j$.util.i1(spliterator);
    }

    @Override // j$.util.stream.v6, java.lang.Iterable, j$.util.stream.h2
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public j$.util.b1 spliterator() {
        return new s6(this, 0, this.f6153c, 0, this.f6152b);
    }

    public final String toString() {
        long[] jArr = (long[]) b();
        if (jArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f6153c), Arrays.toString(jArr));
        }
        return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f6153c), Arrays.toString(Arrays.copyOf(jArr, 200)));
    }
}
