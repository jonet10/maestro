package j$.util.stream;

import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class c7 extends f7 implements DoubleConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final double[] f6165c;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    public c7(int i) {
        this.f6165c = new double[i];
    }

    @Override // j$.util.stream.f7
    public final void a(Object obj, long j) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i = 0; i < j; i++) {
            doubleConsumer.accept(this.f6165c[i]);
        }
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d10) {
        int i = this.f6197b;
        this.f6197b = i + 1;
        this.f6165c[i] = d10;
    }
}
