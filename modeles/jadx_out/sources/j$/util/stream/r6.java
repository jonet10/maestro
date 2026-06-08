package j$.util.stream;

import j$.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class r6 extends v6 implements IntConsumer {
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.v6
    public final void p(Object obj, int i, int i6, Object obj2) {
        int[] iArr = (int[]) obj;
        IntConsumer intConsumer = (IntConsumer) obj2;
        while (i < i6) {
            intConsumer.accept(iArr[i]);
            i++;
        }
    }

    @Override // j$.util.stream.v6
    public final int q(Object obj) {
        return ((int[]) obj).length;
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            g((IntConsumer) consumer);
        } else {
            if (h8.f6218a) {
                h8.a(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
                throw null;
            }
            j$.util.c.b((q6) spliterator(), consumer);
        }
    }

    @Override // j$.util.stream.v6
    public final Object[] t() {
        return new int[8][];
    }

    @Override // j$.util.stream.v6
    public final Object newArray(int i) {
        return new int[i];
    }

    @Override // java.util.function.IntConsumer
    public void accept(int i) {
        u();
        int[] iArr = (int[]) this.f6401e;
        int i6 = this.f6152b;
        this.f6152b = i6 + 1;
        iArr[i6] = i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        j$.util.y0 spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new j$.util.h1(spliterator);
    }

    @Override // j$.util.stream.v6, java.lang.Iterable, j$.util.stream.h2
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public j$.util.y0 spliterator() {
        return new q6(this, 0, this.f6153c, 0, this.f6152b);
    }

    public final String toString() {
        int[] iArr = (int[]) b();
        if (iArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f6153c), Arrays.toString(iArr));
        }
        return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f6153c), Arrays.toString(Arrays.copyOf(iArr, 200)));
    }
}
