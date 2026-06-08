package j$.util.stream;

import j$.util.Spliterator;
import java.util.Iterator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public interface g extends AutoCloseable {
    boolean isParallel();

    Iterator iterator();

    g onClose(Runnable runnable);

    g parallel();

    g sequential();

    Spliterator spliterator();

    g unordered();
}
