package j$.util.stream;

import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class h0 extends k0 implements k5 {

    /* renamed from: c, reason: collision with root package name */
    public static final f0 f6209c;

    /* renamed from: d, reason: collision with root package name */
    public static final f0 f6210d;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.k0, j$.util.stream.m5
    public final void accept(int i) {
        n(Integer.valueOf(i));
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.f6254a) {
            return new j$.util.d0(((Integer) this.f6255b).intValue());
        }
        return null;
    }

    static {
        a7 a7Var = a7.INT_VALUE;
        q qVar = new q(9);
        q qVar2 = new q(10);
        j$.util.d0 d0Var = j$.util.d0.f6032c;
        f6209c = new f0(true, a7Var, d0Var, qVar, qVar2);
        f6210d = new f0(false, a7Var, d0Var, new q(9), new q(10));
    }
}
