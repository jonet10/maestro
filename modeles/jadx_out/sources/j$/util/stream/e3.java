package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class e3 extends r6 implements d2, x1 {
    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d10) {
        w3.c();
        throw null;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        w3.l();
        throw null;
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.x1, j$.util.stream.z1
    public final d2 build() {
        return this;
    }

    @Override // j$.util.stream.z1
    public final h2 build() {
        return this;
    }

    @Override // j$.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        w3.g(this, num);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.m5
    public final void end() {
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

    @Override // j$.util.stream.v6, j$.util.stream.g2
    public final void f(int i, Object obj) {
        super.f(i, (int[]) obj);
    }

    @Override // j$.util.stream.v6, j$.util.stream.g2
    public final void g(Object obj) {
        super.g((IntConsumer) obj);
    }

    @Override // j$.util.stream.r6, j$.util.stream.v6, java.lang.Iterable, j$.util.stream.h2
    public final Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // j$.util.stream.r6, j$.util.stream.v6, java.lang.Iterable, j$.util.stream.h2
    public final j$.util.e1 spliterator() {
        return super.spliterator();
    }

    @Override // j$.util.stream.m5
    public final void c(long j) {
        clear();
        s(j);
    }

    @Override // j$.util.stream.v6, j$.util.stream.g2
    public final Object b() {
        return (int[]) super.b();
    }
}
