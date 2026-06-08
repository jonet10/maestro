package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class v8 extends y8 implements IntConsumer, j$.util.y0 {

    /* renamed from: e, reason: collision with root package name */
    public int f6402e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v8(Spliterator spliterator, int i) {
        super(spliterator);
        this.f = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v8(Spliterator spliterator, y8 y8Var, int i) {
        super(spliterator, y8Var);
        this.f = i;
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.b(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.g(this, consumer);
    }

    @Override // j$.util.e1
    public final void forEachRemaining(IntConsumer intConsumer) {
        while (tryAdvance(intConsumer)) {
        }
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        this.f6436d = (this.f6436d + 1) & 63;
        this.f6402e = i;
    }

    @Override // j$.util.stream.y8
    public final Spliterator b(Spliterator spliterator) {
        switch (this.f) {
            case 0:
                return new v8((j$.util.y0) spliterator, this, 0);
            default:
                return new v8((j$.util.y0) spliterator, this, 1);
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

    @Override // j$.util.y0
    public final boolean tryAdvance(IntConsumer intConsumer) {
        switch (this.f) {
            case 0:
                boolean z9 = this.f6435c;
                Spliterator spliterator = this.f6433a;
                if (z9) {
                    this.f6435c = false;
                    boolean tryAdvance = ((j$.util.y0) spliterator).tryAdvance((IntConsumer) this);
                    if (tryAdvance && a()) {
                        IntPredicate intPredicate = null;
                        intPredicate.test(this.f6402e);
                        throw null;
                    }
                    if (!tryAdvance) {
                        return tryAdvance;
                    }
                    intConsumer.accept(this.f6402e);
                    return tryAdvance;
                }
                return ((j$.util.y0) spliterator).tryAdvance(intConsumer);
            default:
                if (this.f6435c && a() && ((j$.util.y0) this.f6433a).tryAdvance((IntConsumer) this)) {
                    IntPredicate intPredicate2 = null;
                    intPredicate2.test(this.f6402e);
                    throw null;
                }
                this.f6435c = false;
                return false;
        }
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public j$.util.y0 trySplit() {
        switch (this.f) {
            case 1:
                if (this.f6434b.get()) {
                    return null;
                }
                return (j$.util.y0) super.trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // j$.util.e1
    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.f) {
            case 1:
                tryAdvance((IntConsumer) obj);
                return false;
            default:
                return tryAdvance((IntConsumer) obj);
        }
    }
}
