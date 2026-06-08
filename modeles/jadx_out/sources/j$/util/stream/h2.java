package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public interface h2 {
    h2 a(int i);

    long count();

    void forEach(Consumer consumer);

    h2 j(long j, long j6, IntFunction intFunction);

    void k(Object[] objArr, int i);

    Object[] m(IntFunction intFunction);

    int o();

    Spliterator spliterator();
}
