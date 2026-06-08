package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class l3 implements f2 {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f6275a;

    /* renamed from: b, reason: collision with root package name */
    public int f6276b;

    @Override // j$.util.stream.h2
    public final /* synthetic */ void forEach(Consumer consumer) {
        w3.s(this, consumer);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ h2 j(long j, long j6, IntFunction intFunction) {
        return w3.v(this, j, j6);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ Object[] m(IntFunction intFunction) {
        return w3.m(this, intFunction);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ int o() {
        return 0;
    }

    @Override // j$.util.stream.h2
    public final /* bridge */ /* synthetic */ h2 a(int i) {
        a(i);
        throw null;
    }

    @Override // j$.util.stream.g2, j$.util.stream.h2
    public final g2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ void k(Object[] objArr, int i) {
        w3.p(this, (Long[]) objArr, i);
    }

    @Override // j$.util.stream.g2
    public final void f(int i, Object obj) {
        int i6 = this.f6276b;
        System.arraycopy(this.f6275a, 0, (long[]) obj, i, i6);
    }

    @Override // j$.util.stream.g2
    public final void g(Object obj) {
        LongConsumer longConsumer = (LongConsumer) obj;
        for (int i = 0; i < this.f6276b; i++) {
            longConsumer.accept(this.f6275a[i]);
        }
    }

    public l3(long j) {
        if (j >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            throw null;
        }
        this.f6275a = new long[(int) j];
        this.f6276b = 0;
    }

    public l3(long[] jArr) {
        this.f6275a = jArr;
        this.f6276b = jArr.length;
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        int i = this.f6276b;
        long[] jArr = this.f6275a;
        Spliterators.a(((long[]) Objects.requireNonNull(jArr)).length, 0, i);
        return new j$.util.s1(jArr, 0, i, 1040);
    }

    @Override // j$.util.stream.g2, j$.util.stream.h2
    public final j$.util.e1 spliterator() {
        int i = this.f6276b;
        long[] jArr = this.f6275a;
        Spliterators.a(((long[]) Objects.requireNonNull(jArr)).length, 0, i);
        return new j$.util.s1(jArr, 0, i, 1040);
    }

    @Override // j$.util.stream.g2
    public final Object b() {
        long[] jArr = this.f6275a;
        int length = jArr.length;
        int i = this.f6276b;
        return length == i ? jArr : Arrays.copyOf(jArr, i);
    }

    @Override // j$.util.stream.h2
    public final long count() {
        return this.f6276b;
    }

    public String toString() {
        long[] jArr = this.f6275a;
        return String.format("LongArrayNode[%d][%s]", Integer.valueOf(jArr.length - this.f6276b), Arrays.toString(jArr));
    }
}
