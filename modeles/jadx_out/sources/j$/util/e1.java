package j$.util;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public interface e1 extends Spliterator {
    void forEachRemaining(Object obj);

    boolean tryAdvance(Object obj);

    @Override // j$.util.Spliterator
    e1 trySplit();
}
