package j$.util.stream;

import j$.util.stream.IntStream;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class m0 implements IntFunction, LongFunction {

    /* renamed from: a, reason: collision with root package name */
    public IntFunction f6286a;

    @Override // java.util.function.IntFunction
    public Object apply(int i) {
        Object apply = this.f6286a.apply(i);
        if (apply == null) {
            return null;
        }
        if (apply instanceof IntStream) {
            return IntStream.Wrapper.convert((IntStream) apply);
        }
        if (apply instanceof java.util.stream.IntStream) {
            return IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) apply);
        }
        j$.util.g.a(apply.getClass(), "java.util.stream.IntStream");
        throw null;
    }

    @Override // java.util.function.LongFunction
    public Object apply(long j) {
        return w3.z(j, this.f6286a);
    }
}
