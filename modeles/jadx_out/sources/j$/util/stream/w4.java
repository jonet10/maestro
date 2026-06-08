package j$.util.stream;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class w4 extends x4 {
    @Override // j$.util.stream.s4, java.util.function.Supplier
    public final Object get() {
        return Long.valueOf(this.f6424b);
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        this.f6424b += ((x4) r4Var).f6424b;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f6424b++;
    }
}
