package j$.util.stream;

import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class r2 extends j2 implements g2 {
    @Override // j$.util.stream.h2
    public final /* synthetic */ Object[] m(IntFunction intFunction) {
        return w3.m(this, intFunction);
    }

    @Override // j$.util.stream.g2
    public final void g(Object obj) {
        ((g2) this.f6235a).g(obj);
        ((g2) this.f6236b).g(obj);
    }

    @Override // j$.util.stream.g2
    public final void f(int i, Object obj) {
        h2 h2Var = this.f6235a;
        ((g2) h2Var).f(i, obj);
        ((g2) this.f6236b).f(i + ((int) ((g2) h2Var).count()), obj);
    }

    @Override // j$.util.stream.g2
    public final Object b() {
        long j = this.f6237c;
        if (j >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        Object newArray = newArray((int) j);
        f(0, newArray);
        return newArray;
    }

    public final String toString() {
        long j = this.f6237c;
        return j < 32 ? String.format("%s[%s.%s]", getClass().getName(), this.f6235a, this.f6236b) : String.format("%s[size=%d]", getClass().getName(), Long.valueOf(j));
    }
}
