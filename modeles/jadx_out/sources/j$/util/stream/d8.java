package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class d8 extends b7 {
    @Override // j$.util.stream.b7
    public final b7 e(Spliterator spliterator) {
        return new d8(this.f6142b, spliterator, this.f6141a);
    }

    @Override // j$.util.stream.b7
    public final void d() {
        w6 w6Var = new w6();
        this.h = w6Var;
        Objects.requireNonNull(w6Var);
        this.f6145e = this.f6142b.R(new c8(w6Var, 0));
        this.f = new j$.util.q(13, this);
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Object obj;
        Objects.requireNonNull(consumer);
        boolean a8 = a();
        if (!a8) {
            return a8;
        }
        w6 w6Var = (w6) this.h;
        long j = this.g;
        if (w6Var.f6153c != 0) {
            if (j >= w6Var.count()) {
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
            for (int i = 0; i <= w6Var.f6153c; i++) {
                long j6 = w6Var.f6154d[i];
                Object[] objArr = w6Var.f[i];
                if (j < objArr.length + j6) {
                    obj = objArr[(int) (j - j6)];
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j));
        }
        if (j < w6Var.f6152b) {
            obj = w6Var.f6417e[(int) j];
        } else {
            throw new IndexOutOfBoundsException(Long.toString(j));
        }
        consumer.n(obj);
        return a8;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        if (this.h == null && !this.i) {
            Objects.requireNonNull(consumer);
            c();
            Objects.requireNonNull(consumer);
            c8 c8Var = new c8(consumer, 1);
            this.f6142b.Q(this.f6144d, c8Var);
            this.i = true;
            return;
        }
        while (tryAdvance(consumer)) {
        }
    }
}
