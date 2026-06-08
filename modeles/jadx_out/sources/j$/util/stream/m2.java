package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class m2 extends n2 {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f6288k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m2(a aVar, Spliterator spliterator, LongFunction longFunction, BinaryOperator binaryOperator, int i) {
        super(aVar, spliterator, longFunction, binaryOperator);
        this.f6288k = i;
    }

    @Override // j$.util.stream.n2, j$.util.stream.d
    public final d c(Spliterator spliterator) {
        switch (this.f6288k) {
        }
        return new n2(this, spliterator);
    }

    @Override // j$.util.stream.n2, j$.util.stream.d
    public final /* bridge */ /* synthetic */ Object a() {
        switch (this.f6288k) {
        }
        return a();
    }
}
