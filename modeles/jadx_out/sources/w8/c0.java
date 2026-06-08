package w8;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f10947a = new b0(new byte[0], 0, 0, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f10948b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f10949c;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f10948b = highestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i = 0; i < highestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        f10949c = atomicReferenceArr;
    }

    public static final void a(b0 b0Var) {
        b0Var.getClass();
        if (b0Var.f != null || b0Var.g != null) {
            com.google.gson.internal.a.p("Failed requirement.");
            return;
        }
        if (b0Var.f10942d) {
            return;
        }
        AtomicReference atomicReference = f10949c[(int) (Thread.currentThread().getId() & (f10948b - 1))];
        b0 b0Var2 = f10947a;
        b0 b0Var3 = (b0) atomicReference.getAndSet(b0Var2);
        if (b0Var3 == b0Var2) {
            return;
        }
        int i = b0Var3 != null ? b0Var3.f10941c : 0;
        if (i >= 65536) {
            atomicReference.set(b0Var3);
            return;
        }
        b0Var.f = b0Var3;
        b0Var.f10940b = 0;
        b0Var.f10941c = i + 8192;
        atomicReference.set(b0Var);
    }

    public static final b0 b() {
        AtomicReference atomicReference = f10949c[(int) (Thread.currentThread().getId() & (f10948b - 1))];
        b0 b0Var = f10947a;
        b0 b0Var2 = (b0) atomicReference.getAndSet(b0Var);
        if (b0Var2 == b0Var) {
            return new b0();
        }
        if (b0Var2 == null) {
            atomicReference.set(null);
            return new b0();
        }
        atomicReference.set(b0Var2.f);
        b0Var2.f = null;
        b0Var2.f10941c = 0;
        return b0Var2;
    }
}
