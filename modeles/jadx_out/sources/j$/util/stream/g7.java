package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class g7 extends h7 implements Consumer {

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f6207b;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public g7(int i) {
        this.f6207b = new Object[i];
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f6217a;
        this.f6217a = i + 1;
        this.f6207b[i] = obj;
    }
}
