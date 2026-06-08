package j$.util;

import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class x implements DoubleConsumer {

    /* renamed from: a, reason: collision with root package name */
    public double f6474a;

    /* renamed from: b, reason: collision with root package name */
    public double f6475b;
    private long count;
    private double sum;
    private double min = Double.POSITIVE_INFINITY;
    private double max = Double.NEGATIVE_INFINITY;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d10) {
        this.count++;
        this.f6475b += d10;
        b(d10);
        this.min = Math.min(this.min, d10);
        this.max = Math.max(this.max, d10);
    }

    public final void a(x xVar) {
        this.count += xVar.count;
        this.f6475b += xVar.f6475b;
        b(xVar.sum);
        b(xVar.f6474a);
        this.min = Math.min(this.min, xVar.min);
        this.max = Math.max(this.max, xVar.max);
    }

    public final void b(double d10) {
        double d11 = d10 - this.f6474a;
        double d12 = this.sum;
        double d13 = d12 + d11;
        this.f6474a = (d13 - d12) - d11;
        this.sum = d13;
    }

    public final String toString() {
        double d10;
        String simpleName = x.class.getSimpleName();
        Long valueOf = Long.valueOf(this.count);
        double d11 = this.sum + this.f6474a;
        if (Double.isNaN(d11) && Double.isInfinite(this.f6475b)) {
            d11 = this.f6475b;
        }
        Double valueOf2 = Double.valueOf(d11);
        Double valueOf3 = Double.valueOf(this.min);
        if (this.count > 0) {
            double d12 = this.sum + this.f6474a;
            if (Double.isNaN(d12) && Double.isInfinite(this.f6475b)) {
                d12 = this.f6475b;
            }
            d10 = d12 / this.count;
        } else {
            d10 = 0.0d;
        }
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", simpleName, valueOf, valueOf2, valueOf3, Double.valueOf(d10), Double.valueOf(this.max));
    }
}
