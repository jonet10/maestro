package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class u8 extends y8 implements DoubleConsumer, j$.util.v0 {

    /* renamed from: e, reason: collision with root package name */
    public double f6392e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u8(Spliterator spliterator, int i) {
        super(spliterator);
        this.f = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u8(Spliterator spliterator, y8 y8Var, int i) {
        super(spliterator, y8Var);
        this.f = i;
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.a(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.f(this, consumer);
    }

    @Override // j$.util.e1
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        while (tryAdvance(doubleConsumer)) {
        }
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d10) {
        this.f6436d = (this.f6436d + 1) & 63;
        this.f6392e = d10;
    }

    @Override // j$.util.stream.y8
    public final Spliterator b(Spliterator spliterator) {
        switch (this.f) {
            case 0:
                return new u8((j$.util.v0) spliterator, this, 0);
            default:
                return new u8((j$.util.v0) spliterator, this, 1);
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

    @Override // j$.util.v0
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        switch (this.f) {
            case 0:
                boolean z9 = this.f6435c;
                Spliterator spliterator = this.f6433a;
                if (z9) {
                    this.f6435c = false;
                    boolean tryAdvance = ((j$.util.v0) spliterator).tryAdvance((DoubleConsumer) this);
                    if (tryAdvance && a()) {
                        DoublePredicate doublePredicate = null;
                        doublePredicate.test(this.f6392e);
                        throw null;
                    }
                    if (!tryAdvance) {
                        return tryAdvance;
                    }
                    doubleConsumer.accept(this.f6392e);
                    return tryAdvance;
                }
                return ((j$.util.v0) spliterator).tryAdvance(doubleConsumer);
            default:
                if (this.f6435c && a() && ((j$.util.v0) this.f6433a).tryAdvance((DoubleConsumer) this)) {
                    DoublePredicate doublePredicate2 = null;
                    doublePredicate2.test(this.f6392e);
                    throw null;
                }
                this.f6435c = false;
                return false;
        }
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public j$.util.v0 trySplit() {
        switch (this.f) {
            case 1:
                if (this.f6434b.get()) {
                    return null;
                }
                return (j$.util.v0) super.trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // j$.util.e1
    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.f) {
            case 1:
                tryAdvance((DoubleConsumer) obj);
                return false;
            default:
                return tryAdvance((DoubleConsumer) obj);
        }
    }
}
