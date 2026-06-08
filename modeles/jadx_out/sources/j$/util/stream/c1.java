package j$.util.stream;

import java.util.function.LongConsumer;
import java.util.function.LongFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class c1 extends h5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6156b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f6157c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c1(a aVar, m5 m5Var, int i) {
        super(m5Var);
        this.f6156b = i;
        this.f6157c = aVar;
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j) {
        switch (this.f6156b) {
            case 0:
                this.f6214a.accept((m5) ((LongFunction) ((r) this.f6157c).f6336m).apply(j));
                break;
            default:
                ((LongConsumer) ((g1) this.f6157c).f6201m).accept(j);
                this.f6214a.accept(j);
                break;
        }
    }
}
