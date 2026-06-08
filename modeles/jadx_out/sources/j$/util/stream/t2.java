package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class t2 implements b2 {

    /* renamed from: a, reason: collision with root package name */
    public final double[] f6364a;

    /* renamed from: b, reason: collision with root package name */
    public int f6365b;

    @Override // j$.util.stream.h2
    public final /* synthetic */ void forEach(Consumer consumer) {
        w3.q(this, consumer);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ h2 j(long j, long j6, IntFunction intFunction) {
        return w3.t(this, j, j6);
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
        w3.n(this, (Double[]) objArr, i);
    }

    @Override // j$.util.stream.g2
    public final void f(int i, Object obj) {
        int i6 = this.f6365b;
        System.arraycopy(this.f6364a, 0, (double[]) obj, i, i6);
    }

    @Override // j$.util.stream.g2
    public final void g(Object obj) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i = 0; i < this.f6365b; i++) {
            doubleConsumer.accept(this.f6364a[i]);
        }
    }

    public t2(long j) {
        if (j >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            throw null;
        }
        this.f6364a = new double[(int) j];
        this.f6365b = 0;
    }

    public t2(double[] dArr) {
        this.f6364a = dArr;
        this.f6365b = dArr.length;
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        int i = this.f6365b;
        double[] dArr = this.f6364a;
        Spliterators.a(((double[]) Objects.requireNonNull(dArr)).length, 0, i);
        return new j$.util.l1(dArr, 0, i, 1040);
    }

    @Override // j$.util.stream.g2, j$.util.stream.h2
    public final j$.util.e1 spliterator() {
        int i = this.f6365b;
        double[] dArr = this.f6364a;
        Spliterators.a(((double[]) Objects.requireNonNull(dArr)).length, 0, i);
        return new j$.util.l1(dArr, 0, i, 1040);
    }

    @Override // j$.util.stream.g2
    public final Object b() {
        double[] dArr = this.f6364a;
        int length = dArr.length;
        int i = this.f6365b;
        return length == i ? dArr : Arrays.copyOf(dArr, i);
    }

    @Override // j$.util.stream.h2
    public final long count() {
        return this.f6365b;
    }

    public String toString() {
        double[] dArr = this.f6364a;
        return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(dArr.length - this.f6365b), Arrays.toString(dArr));
    }
}
