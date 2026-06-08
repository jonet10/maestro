package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class u2 extends t2 implements w1 {
    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(int i) {
        w3.k();
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
        n((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void n(Double d10) {
        w3.d(this, d10);
    }

    @Override // j$.util.stream.z1
    public final /* bridge */ /* synthetic */ h2 build() {
        build();
        return this;
    }

    @Override // j$.util.stream.w1, j$.util.stream.z1
    public final b2 build() {
        int i = this.f6365b;
        double[] dArr = this.f6364a;
        if (i >= dArr.length) {
            return this;
        }
        j$.time.g.g("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(dArr.length)});
        return null;
    }

    @Override // j$.util.stream.m5
    public final void c(long j) {
        double[] dArr = this.f6364a;
        if (j != dArr.length) {
            j$.time.g.g("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j), Integer.valueOf(dArr.length)});
        } else {
            this.f6365b = 0;
        }
    }

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d10) {
        int i = this.f6365b;
        double[] dArr = this.f6364a;
        if (i < dArr.length) {
            this.f6365b = i + 1;
            dArr[i] = d10;
        } else {
            j$.time.g.g("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(dArr.length)});
        }
    }

    @Override // j$.util.stream.m5
    public final void end() {
        int i = this.f6365b;
        double[] dArr = this.f6364a;
        if (i >= dArr.length) {
            return;
        }
        j$.time.g.g("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(dArr.length)});
    }

    @Override // j$.util.stream.t2
    public final String toString() {
        double[] dArr = this.f6364a;
        return String.format("DoubleFixedNodeBuilder[%d][%s]", Integer.valueOf(dArr.length - this.f6365b), Arrays.toString(dArr));
    }
}
