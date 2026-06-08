package j$.util.stream;

import j$.util.Spliterator;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class k2 implements h2 {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f6256a;

    /* renamed from: b, reason: collision with root package name */
    public int f6257b;

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

    public k2(long j, IntFunction intFunction) {
        if (j >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            throw null;
        }
        this.f6256a = (Object[]) intFunction.apply((int) j);
        this.f6257b = 0;
    }

    public k2(Object[] objArr) {
        this.f6256a = objArr;
        this.f6257b = objArr.length;
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        return j$.util.c.v(this.f6256a, 0, this.f6257b);
    }

    @Override // j$.util.stream.h2
    public final void k(Object[] objArr, int i) {
        System.arraycopy(this.f6256a, 0, objArr, i, this.f6257b);
    }

    @Override // j$.util.stream.h2
    public final Object[] m(IntFunction intFunction) {
        Object[] objArr = this.f6256a;
        if (objArr.length == this.f6257b) {
            return objArr;
        }
        throw new IllegalStateException();
    }

    @Override // j$.util.stream.h2
    public final long count() {
        return this.f6257b;
    }

    @Override // j$.util.stream.h2
    public final void forEach(Consumer consumer) {
        for (int i = 0; i < this.f6257b; i++) {
            consumer.n(this.f6256a[i]);
        }
    }

    public String toString() {
        Object[] objArr = this.f6256a;
        return String.format("ArrayNode[%d][%s]", Integer.valueOf(objArr.length - this.f6257b), Arrays.toString(objArr));
    }
}
