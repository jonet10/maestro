package j$.util.stream;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class Collectors {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f6120a;

    /* renamed from: b, reason: collision with root package name */
    public static final Set f6121b;

    static {
        h hVar = h.CONCURRENT;
        h hVar2 = h.UNORDERED;
        h hVar3 = h.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(hVar, hVar2, hVar3));
        Collections.unmodifiableSet(EnumSet.of(hVar, hVar2));
        f6120a = Collections.unmodifiableSet(EnumSet.of(hVar3));
        Collections.unmodifiableSet(EnumSet.of(hVar2, hVar3));
        f6121b = Collections.EMPTY_SET;
        Collections.unmodifiableSet(EnumSet.of(hVar2));
    }

    public static <T> Collector<T, ?, List<T>> toList() {
        return new k(new j$.time.format.a(11), new j$.time.format.a(12), new j$.time.format.a(15), f6120a);
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence charSequence) {
        return new k(new j$.util.q(4, charSequence), new j$.time.format.a(17), new j$.time.format.a(18), new j$.time.format.a(19), f6121b);
    }

    public static void a(double[] dArr, double d10) {
        double d11 = d10 - dArr[1];
        double d12 = dArr[0];
        double d13 = d12 + d11;
        dArr[1] = (d13 - d12) - d11;
        dArr[0] = d13;
    }

    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends U> function2) {
        return new k(new j$.time.format.a(20), new j$.util.function.c(function, function2, 2), new j$.time.format.a(9), f6120a);
    }
}
