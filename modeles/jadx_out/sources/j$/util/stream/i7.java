package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer$CC;
import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class i7 implements Spliterator, Consumer {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f6226d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Spliterator f6227a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f6228b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6229c;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.util.c.e(this, i);
    }

    public i7(Spliterator spliterator, ConcurrentHashMap concurrentHashMap) {
        this.f6227a = spliterator;
        this.f6228b = concurrentHashMap;
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        this.f6229c = obj;
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        while (this.f6227a.tryAdvance(this)) {
            Object obj = this.f6229c;
            if (obj == null) {
                obj = f6226d;
            }
            if (this.f6228b.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.n(this.f6229c);
                this.f6229c = null;
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        this.f6227a.forEachRemaining(new j$.util.concurrent.t(8, this, consumer));
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        Spliterator trySplit = this.f6227a.trySplit();
        if (trySplit != null) {
            return new i7(trySplit, this.f6228b);
        }
        return null;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f6227a.estimateSize();
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return (this.f6227a.characteristics() & (-16469)) | 1;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        return this.f6227a.getComparator();
    }
}
