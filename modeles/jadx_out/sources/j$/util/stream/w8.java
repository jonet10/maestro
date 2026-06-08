package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class w8 extends y8 implements LongConsumer, j$.util.b1 {

    /* renamed from: e, reason: collision with root package name */
    public long f6418e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w8(Spliterator spliterator, int i) {
        super(spliterator);
        this.f = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w8(Spliterator spliterator, y8 y8Var, int i) {
        super(spliterator, y8Var);
        this.f = i;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.c(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.h(this, consumer);
    }

    @Override // j$.util.e1
    public final void forEachRemaining(LongConsumer longConsumer) {
        while (tryAdvance(longConsumer)) {
        }
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        this.f6436d = (this.f6436d + 1) & 63;
        this.f6418e = j;
    }

    @Override // j$.util.stream.y8
    public final Spliterator b(Spliterator spliterator) {
        switch (this.f) {
            case 0:
                return new w8((j$.util.b1) spliterator, this, 0);
            default:
                return new w8((j$.util.b1) spliterator, this, 1);
        }
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public /* bridge */ /* synthetic */ Spliterator trySplit() {
        switch (this.f) {
            case 1:
                return trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.e1 trySplit() {
        switch (this.f) {
            case 1:
                return trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // j$.util.b1
    public final boolean tryAdvance(LongConsumer longConsumer) {
        switch (this.f) {
            case 0:
                boolean z9 = this.f6435c;
                Spliterator spliterator = this.f6433a;
                if (z9) {
                    this.f6435c = false;
                    boolean tryAdvance = ((j$.util.b1) spliterator).tryAdvance((LongConsumer) this);
                    if (tryAdvance && a()) {
                        LongPredicate longPredicate = null;
                        longPredicate.test(this.f6418e);
                        throw null;
                    }
                    if (!tryAdvance) {
                        return tryAdvance;
                    }
                    longConsumer.accept(this.f6418e);
                    return tryAdvance;
                }
                return ((j$.util.b1) spliterator).tryAdvance(longConsumer);
            default:
                if (this.f6435c && a() && ((j$.util.b1) this.f6433a).tryAdvance((LongConsumer) this)) {
                    LongPredicate longPredicate2 = null;
                    longPredicate2.test(this.f6418e);
                    throw null;
                }
                this.f6435c = false;
                return false;
        }
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public j$.util.b1 trySplit() {
        switch (this.f) {
            case 1:
                if (this.f6434b.get()) {
                    return null;
                }
                return (j$.util.b1) super.trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // j$.util.e1
    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.f) {
            case 1:
                tryAdvance((LongConsumer) obj);
                return false;
            default:
                return tryAdvance((LongConsumer) obj);
        }
    }
}
