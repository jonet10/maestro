package j$.util;

import j$.util.stream.m5;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class j0 implements IntConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6079a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f6080b;

    public /* synthetic */ j0(Consumer consumer, int i) {
        this.f6079a = i;
        this.f6080b = consumer;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        switch (this.f6079a) {
            case 0:
                this.f6080b.accept(Integer.valueOf(i));
                break;
            default:
                ((m5) this.f6080b).accept(i);
                break;
        }
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.f6079a) {
        }
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }
}
