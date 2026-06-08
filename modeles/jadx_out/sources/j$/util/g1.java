package j$.util;

import j$.util.function.Consumer$CC;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class g1 implements Iterator, Consumer {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6061a = false;

    /* renamed from: b, reason: collision with root package name */
    public Object f6062b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Spliterator f6063c;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public g1(Spliterator spliterator) {
        this.f6063c = spliterator;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f6061a = true;
        this.f6062b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f6061a) {
            this.f6063c.tryAdvance(this);
        }
        return this.f6061a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f6061a && !hasNext()) {
            throw new NoSuchElementException();
        }
        this.f6061a = false;
        return this.f6062b;
    }
}
