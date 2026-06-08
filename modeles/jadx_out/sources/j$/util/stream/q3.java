package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class q3 extends s3 implements l5 {
    public final long[] h;

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.l5
    public final /* synthetic */ void l(Long l10) {
        w3.i(this, l10);
    }

    public q3(Spliterator spliterator, a aVar, long[] jArr) {
        super(spliterator, aVar, jArr.length);
        this.h = jArr;
    }

    public q3(q3 q3Var, Spliterator spliterator, long j, long j6) {
        super(q3Var, spliterator, j, j6, q3Var.h.length);
        this.h = q3Var.h;
    }

    @Override // j$.util.stream.s3
    public final s3 a(Spliterator spliterator, long j, long j6) {
        return new q3(this, spliterator, j, j6);
    }

    @Override // j$.util.stream.s3, j$.util.stream.m5
    public final void accept(long j) {
        int i = this.f;
        if (i >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(i));
        }
        long[] jArr = this.h;
        this.f = i + 1;
        jArr[i] = j;
    }
}
