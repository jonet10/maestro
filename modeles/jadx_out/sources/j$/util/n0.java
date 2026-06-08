package j$.util;

import j$.util.stream.m5;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class n0 implements LongConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6097a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f6098b;

    public /* synthetic */ n0(Consumer consumer, int i) {
        this.f6097a = i;
        this.f6098b = consumer;
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        switch (this.f6097a) {
            case 0:
                this.f6098b.accept(Long.valueOf(j));
                break;
            default:
                ((m5) this.f6098b).accept(j);
                break;
        }
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f6097a) {
        }
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }
}
