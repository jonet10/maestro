package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class d3 extends c3 implements x1 {
    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d10) {
        w3.c();
        throw null;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        w3.l();
        throw null;
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        w3.g(this, num);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.z1
    public final /* bridge */ /* synthetic */ h2 build() {
        build();
        return this;
    }

    @Override // j$.util.stream.x1, j$.util.stream.z1
    public final d2 build() {
        int i = this.f6160b;
        int[] iArr = this.f6159a;
        if (i >= iArr.length) {
            return this;
        }
        j$.time.g.g("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr.length)});
        return null;
    }

    @Override // j$.util.stream.m5
    public final void c(long j) {
        int[] iArr = this.f6159a;
        if (j != iArr.length) {
            j$.time.g.g("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j), Integer.valueOf(iArr.length)});
        } else {
            this.f6160b = 0;
        }
    }

    @Override // j$.util.stream.m5
    public final void accept(int i) {
        int i6 = this.f6160b;
        int[] iArr = this.f6159a;
        if (i6 < iArr.length) {
            this.f6160b = i6 + 1;
            iArr[i6] = i;
        } else {
            j$.time.g.g("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(iArr.length)});
        }
    }

    @Override // j$.util.stream.m5
    public final void end() {
        int i = this.f6160b;
        int[] iArr = this.f6159a;
        if (i >= iArr.length) {
            return;
        }
        j$.time.g.g("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr.length)});
    }

    @Override // j$.util.stream.c3
    public final String toString() {
        int[] iArr = this.f6159a;
        return String.format("IntFixedNodeBuilder[%d][%s]", Integer.valueOf(iArr.length - this.f6160b), Arrays.toString(iArr));
    }
}
