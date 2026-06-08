package j$.util;

import j$.util.stream.m5;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class f0 implements DoubleConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6043a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f6044b;

    public /* synthetic */ f0(Consumer consumer, int i) {
        this.f6043a = i;
        this.f6044b = consumer;
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d10) {
        switch (this.f6043a) {
            case 0:
                this.f6044b.accept(Double.valueOf(d10));
                break;
            default:
                ((m5) this.f6044b).accept(d10);
                break;
        }
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.f6043a) {
        }
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }
}
