package j$.util.stream;

import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class d7 extends f7 implements IntConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final int[] f6176c;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    public d7(int i) {
        this.f6176c = new int[i];
    }

    @Override // j$.util.stream.f7
    public final void a(Object obj, long j) {
        IntConsumer intConsumer = (IntConsumer) obj;
        for (int i = 0; i < j; i++) {
            intConsumer.accept(this.f6176c[i]);
        }
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        int i6 = this.f6197b;
        this.f6197b = i6 + 1;
        this.f6176c[i6] = i;
    }
}
