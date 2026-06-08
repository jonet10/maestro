package j$.util.concurrent;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class j extends p implements Spliterator {
    public final /* synthetic */ int i;
    public long j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(l[] lVarArr, int i, int i6, int i10, long j, int i11) {
        super(lVarArr, i, i6, i10);
        this.i = i11;
        this.j = j;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        switch (this.i) {
            case 0:
                return 4353;
            default:
                return 4352;
        }
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        switch (this.i) {
        }
        return j$.util.c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        switch (this.i) {
        }
        return j$.util.c.e(this, i);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        switch (this.i) {
            case 0:
                throw new IllegalStateException();
            default:
                throw new IllegalStateException();
        }
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        switch (this.i) {
            case 0:
                int i = this.f;
                int i6 = this.g;
                int i10 = (i + i6) >>> 1;
                if (i10 <= i) {
                    return null;
                }
                l[] lVarArr = this.f6008a;
                this.g = i10;
                long j = this.j >>> 1;
                this.j = j;
                return new j(lVarArr, this.h, i10, i6, j, 0);
            default:
                int i11 = this.f;
                int i12 = this.g;
                int i13 = (i11 + i12) >>> 1;
                if (i13 <= i11) {
                    return null;
                }
                l[] lVarArr2 = this.f6008a;
                this.g = i13;
                long j6 = this.j >>> 1;
                this.j = j6;
                return new j(lVarArr2, this.h, i13, i12, j6, 1);
        }
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        switch (this.i) {
            case 0:
                consumer.getClass();
                while (true) {
                    l a8 = a();
                    if (a8 == null) {
                        break;
                    } else {
                        consumer.n(a8.f6001b);
                    }
                }
            default:
                consumer.getClass();
                while (true) {
                    l a10 = a();
                    if (a10 == null) {
                        break;
                    } else {
                        consumer.n(a10.f6002c);
                    }
                }
        }
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        switch (this.i) {
            case 0:
                consumer.getClass();
                l a8 = a();
                if (a8 != null) {
                    consumer.n(a8.f6001b);
                    break;
                }
                break;
            default:
                consumer.getClass();
                l a10 = a();
                if (a10 != null) {
                    consumer.n(a10.f6002c);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        switch (this.i) {
        }
        return this.j;
    }
}
