package j$.util.stream;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class u0 extends g5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6375b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f6376c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u0(a aVar, m5 m5Var, int i) {
        super(m5Var);
        this.f6375b = i;
        this.f6376c = aVar;
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i) {
        switch (this.f6375b) {
            case 0:
                this.f6205a.accept((m5) ((IntFunction) ((r) this.f6376c).f6336m).apply(i));
                break;
            default:
                ((IntConsumer) ((v0) this.f6376c).f6395m).accept(i);
                this.f6205a.accept(i);
                break;
        }
    }
}
