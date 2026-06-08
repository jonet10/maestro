package j$.util;

import j$.util.List;
import j$.util.Map;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f5973a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f5974b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};

    public static /* synthetic */ void q(java.util.Map map, BiConsumer biConsumer) {
        if (map instanceof Map) {
            ((Map) map).forEach(biConsumer);
        } else if (map instanceof ConcurrentMap) {
            j$.com.android.tools.r8.a.j((ConcurrentMap) map, biConsumer);
        } else {
            Map.CC.$default$forEach(map, biConsumer);
        }
    }

    public static /* synthetic */ Object t(java.util.Map map, Object obj, Object obj2) {
        return map instanceof Map ? ((Map) map).putIfAbsent(obj, obj2) : Map.CC.$default$putIfAbsent(map, obj, obj2);
    }

    public static /* synthetic */ void u(java.util.List list, Comparator comparator) {
        if (list instanceof List) {
            ((List) list).sort(comparator);
        } else {
            List.CC.$default$sort(list, comparator);
        }
    }

    public static b0 i(Optional optional) {
        if (optional == null) {
            return null;
        }
        if (!optional.isPresent()) {
            return b0.f5971b;
        }
        return new b0(optional.get());
    }

    public static c0 j(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        if (!optionalDouble.isPresent()) {
            return c0.f5975c;
        }
        return new c0(optionalDouble.getAsDouble());
    }

    public static e0 l(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        if (!optionalLong.isPresent()) {
            return e0.f6039c;
        }
        return new e0(optionalLong.getAsLong());
    }

    public static d0 k(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        if (!optionalInt.isPresent()) {
            return d0.f6032c;
        }
        return new d0(optionalInt.getAsInt());
    }

    public static Object s(java.util.Map map, Object obj, Object obj2) {
        if (map instanceof Map) {
            return ((Map) map).getOrDefault(obj, obj2);
        }
        if (!(map instanceof ConcurrentMap)) {
            return Map.CC.$default$getOrDefault(map, obj, obj2);
        }
        Object obj3 = ((ConcurrentMap) map).get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public static void r(Iterator it, Consumer consumer) {
        if (it instanceof z) {
            ((z) it).forEachRemaining(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static OptionalDouble n(c0 c0Var) {
        if (c0Var == null) {
            return null;
        }
        boolean z9 = c0Var.f5976a;
        if (!z9) {
            return OptionalDouble.empty();
        }
        if (z9) {
            return OptionalDouble.of(c0Var.f5977b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static OptionalInt o(d0 d0Var) {
        if (d0Var == null) {
            return null;
        }
        boolean z9 = d0Var.f6033a;
        if (!z9) {
            return OptionalInt.empty();
        }
        if (z9) {
            return OptionalInt.of(d0Var.f6034b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static OptionalLong p(e0 e0Var) {
        if (e0Var == null) {
            return null;
        }
        boolean z9 = e0Var.f6040a;
        if (!z9) {
            return OptionalLong.empty();
        }
        if (z9) {
            return OptionalLong.of(e0Var.f6041b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static Optional m(b0 b0Var) {
        if (b0Var == null) {
            return null;
        }
        Object obj = b0Var.f5972a;
        if (obj == null) {
            return Optional.empty();
        }
        if (obj != null) {
            return Optional.of(obj);
        }
        throw new NoSuchElementException("No value present");
    }

    public static k1 v(Object[] objArr, int i, int i6) {
        Spliterators.a(((Object[]) Objects.requireNonNull(objArr)).length, i, i6);
        return new k1(objArr, i, i6, 1040);
    }

    public static e w(f fVar, Comparator comparator) {
        Objects.requireNonNull(comparator);
        return new e(fVar, comparator);
    }

    public static long d(Spliterator spliterator) {
        if ((spliterator.characteristics() & 64) == 0) {
            return -1L;
        }
        return spliterator.estimateSize();
    }

    public static boolean e(Spliterator spliterator, int i) {
        return (spliterator.characteristics() & i) == i;
    }

    public static boolean g(y0 y0Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            return y0Var.tryAdvance((IntConsumer) consumer);
        }
        if (v1.f6472a) {
            v1.a(y0Var.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return y0Var.tryAdvance((IntConsumer) new j0(consumer, 0));
    }

    public static void b(y0 y0Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            y0Var.forEachRemaining((IntConsumer) consumer);
        } else {
            if (v1.f6472a) {
                v1.a(y0Var.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            y0Var.forEachRemaining((IntConsumer) new j0(consumer, 0));
        }
    }

    public static boolean h(b1 b1Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            return b1Var.tryAdvance((LongConsumer) consumer);
        }
        if (v1.f6472a) {
            v1.a(b1Var.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return b1Var.tryAdvance((LongConsumer) new n0(consumer, 0));
    }

    public static void c(b1 b1Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            b1Var.forEachRemaining((LongConsumer) consumer);
        } else {
            if (v1.f6472a) {
                v1.a(b1Var.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            b1Var.forEachRemaining((LongConsumer) new n0(consumer, 0));
        }
    }

    public static boolean f(v0 v0Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            return v0Var.tryAdvance((DoubleConsumer) consumer);
        }
        if (v1.f6472a) {
            v1.a(v0Var.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return v0Var.tryAdvance((DoubleConsumer) new f0(consumer, 0));
    }

    public static void a(v0 v0Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            v0Var.forEachRemaining((DoubleConsumer) consumer);
        } else {
            if (v1.f6472a) {
                v1.a(v0Var.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            v0Var.forEachRemaining((DoubleConsumer) new f0(consumer, 0));
        }
    }

    public Spliterator trySplit() {
        return null;
    }

    public boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        return false;
    }

    public void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
    }

    public long estimateSize() {
        return 0L;
    }

    public int characteristics() {
        return 16448;
    }
}
