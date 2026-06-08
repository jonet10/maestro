package j$.util.stream;

import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class e7 extends f7 implements LongConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final long[] f6184c;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    public e7(int i) {
        this.f6184c = new long[i];
    }

    @Override // j$.util.stream.f7
    public final void a(Object obj, long j) {
        LongConsumer longConsumer = (LongConsumer) obj;
        for (int i = 0; i < j; i++) {
            longConsumer.accept(this.f6184c[i]);
        }
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        int i = this.f6197b;
        this.f6197b = i + 1;
        this.f6184c[i] = j;
    }
}
