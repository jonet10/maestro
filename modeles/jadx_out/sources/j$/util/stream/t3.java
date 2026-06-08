package j$.util.stream;

import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class t3 extends w6 implements h2, z1 {
    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d10) {
        w3.c();
        throw null;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(int i) {
        w3.k();
        throw null;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        w3.l();
        throw null;
    }

    @Override // j$.util.stream.z1
    public final h2 build() {
        return this;
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
        return w3.w(this, j, j6, intFunction);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ int o() {
        return 0;
    }

    @Override // j$.util.stream.h2
    public final h2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.h2
    public final void k(Object[] objArr, int i) {
        long j = i;
        long count = count() + j;
        if (count > objArr.length || count < j) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.f6153c == 0) {
            System.arraycopy(this.f6417e, 0, objArr, i, this.f6152b);
            return;
        }
        for (int i6 = 0; i6 < this.f6153c; i6++) {
            Object[] objArr2 = this.f[i6];
            System.arraycopy(objArr2, 0, objArr, i, objArr2.length);
            i += this.f[i6].length;
        }
        int i10 = this.f6152b;
        if (i10 > 0) {
            System.arraycopy(this.f6417e, 0, objArr, i, i10);
        }
    }

    @Override // j$.util.stream.h2
    public final Object[] m(IntFunction intFunction) {
        long count = count();
        if (count >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) count);
        k(objArr, 0);
        return objArr;
    }

    @Override // j$.util.stream.m5
    public final void c(long j) {
        clear();
        p(j);
    }
}
