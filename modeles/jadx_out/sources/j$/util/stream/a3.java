package j$.util.stream;

import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class a3 implements h2 {
    @Override // j$.util.stream.h2
    public final long count() {
        return 0L;
    }

    public final void g(Object obj) {
    }

    @Override // j$.util.stream.h2
    public /* synthetic */ h2 j(long j, long j6, IntFunction intFunction) {
        return w3.w(this, j, j6, intFunction);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ int o() {
        return 0;
    }

    @Override // j$.util.stream.h2
    public h2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.h2
    public final Object[] m(IntFunction intFunction) {
        return (Object[]) intFunction.apply(0);
    }

    public final void f(int i, Object obj) {
    }
}
