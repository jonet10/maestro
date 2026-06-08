package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class c3 implements d2 {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f6159a;

    /* renamed from: b, reason: collision with root package name */
    public int f6160b;

    @Override // j$.util.stream.h2
    public final /* synthetic */ void forEach(Consumer consumer) {
        w3.r(this, consumer);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ h2 j(long j, long j6, IntFunction intFunction) {
        return w3.u(this, j, j6);
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
        w3.o(this, (Integer[]) objArr, i);
    }

    @Override // j$.util.stream.g2
    public final void f(int i, Object obj) {
        int i6 = this.f6160b;
        System.arraycopy(this.f6159a, 0, (int[]) obj, i, i6);
    }

    @Override // j$.util.stream.g2
    public final void g(Object obj) {
        IntConsumer intConsumer = (IntConsumer) obj;
        for (int i = 0; i < this.f6160b; i++) {
            intConsumer.accept(this.f6159a[i]);
        }
    }

    public c3(long j) {
        if (j >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            throw null;
        }
        this.f6159a = new int[(int) j];
        this.f6160b = 0;
    }

    public c3(int[] iArr) {
        this.f6159a = iArr;
        this.f6160b = iArr.length;
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        int i = this.f6160b;
        int[] iArr = this.f6159a;
        Spliterators.a(((int[]) Objects.requireNonNull(iArr)).length, 0, i);
        return new j$.util.q1(iArr, 0, i, 1040);
    }

    @Override // j$.util.stream.g2, j$.util.stream.h2
    public final j$.util.e1 spliterator() {
        int i = this.f6160b;
        int[] iArr = this.f6159a;
        Spliterators.a(((int[]) Objects.requireNonNull(iArr)).length, 0, i);
        return new j$.util.q1(iArr, 0, i, 1040);
    }

    @Override // j$.util.stream.g2
    public final Object b() {
        int[] iArr = this.f6159a;
        int length = iArr.length;
        int i = this.f6160b;
        return length == i ? iArr : Arrays.copyOf(iArr, i);
    }

    @Override // j$.util.stream.h2
    public final long count() {
        return this.f6160b;
    }

    public String toString() {
        int[] iArr = this.f6159a;
        return String.format("IntArrayNode[%d][%s]", Integer.valueOf(iArr.length - this.f6160b), Arrays.toString(iArr));
    }
}
