package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class p3 extends s3 implements k5 {
    public final int[] h;

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        w3.g(this, num);
    }

    public p3(Spliterator spliterator, a aVar, int[] iArr) {
        super(spliterator, aVar, iArr.length);
        this.h = iArr;
    }

    public p3(p3 p3Var, Spliterator spliterator, long j, long j6) {
        super(p3Var, spliterator, j, j6, p3Var.h.length);
        this.h = p3Var.h;
    }

    @Override // j$.util.stream.s3
    public final s3 a(Spliterator spliterator, long j, long j6) {
        return new p3(this, spliterator, j, j6);
    }

    @Override // j$.util.stream.s3, j$.util.stream.m5
    public final void accept(int i) {
        int i6 = this.f;
        if (i6 >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(i6));
        }
        int[] iArr = this.h;
        this.f = i6 + 1;
        iArr[i6] = i;
    }
}
