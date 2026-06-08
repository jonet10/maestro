package j$.util.stream;

import j$.util.Spliterator;
import java.util.Deque;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class j3 extends k3 {
    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        h2 a8;
        if (!c()) {
            return false;
        }
        boolean tryAdvance = this.f6261d.tryAdvance(consumer);
        if (!tryAdvance) {
            if (this.f6260c == null && (a8 = k3.a(this.f6262e)) != null) {
                Spliterator spliterator = a8.spliterator();
                this.f6261d = spliterator;
                return spliterator.tryAdvance(consumer);
            }
            this.f6258a = null;
        }
        return tryAdvance;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        if (this.f6258a == null) {
            return;
        }
        if (this.f6261d == null) {
            Spliterator spliterator = this.f6260c;
            if (spliterator == null) {
                Deque b7 = b();
                while (true) {
                    h2 a8 = k3.a(b7);
                    if (a8 != null) {
                        a8.forEach(consumer);
                    } else {
                        this.f6258a = null;
                        return;
                    }
                }
            } else {
                spliterator.forEachRemaining(consumer);
            }
        } else {
            while (tryAdvance(consumer)) {
            }
        }
    }
}
