package t7;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import o7.u0;
import o7.v0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class x {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10362b = AtomicIntegerFieldUpdater.newUpdater(x.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    public u0[] f10363a;

    public final void a(u0 u0Var) {
        u0Var.d((v0) this);
        u0[] u0VarArr = this.f10363a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f10362b;
        if (u0VarArr == null) {
            u0VarArr = new u0[4];
            this.f10363a = u0VarArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= u0VarArr.length) {
            u0VarArr = (u0[]) Arrays.copyOf(u0VarArr, atomicIntegerFieldUpdater.get(this) * 2);
            this.f10363a = u0VarArr;
        }
        int i = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i + 1);
        u0VarArr[i] = u0Var;
        u0Var.f8317b = i;
        d(i);
    }

    public final void b(u0 u0Var) {
        synchronized (this) {
            if (u0Var.b() != null) {
                c(u0Var.f8317b);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
    
        if (r6.compareTo(r7) < 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final o7.u0 c(int r9) {
        /*
            r8 = this;
            o7.u0[] r0 = r8.f10363a
            r0.getClass()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = t7.x.f10362b
            int r2 = r1.get(r8)
            r3 = -1
            int r2 = r2 + r3
            r1.set(r8, r2)
            int r2 = r1.get(r8)
            if (r9 >= r2) goto L7a
            int r2 = r1.get(r8)
            r8.e(r9, r2)
            int r2 = r9 + (-1)
            int r2 = r2 / 2
            if (r9 <= 0) goto L3a
            r4 = r0[r9]
            r4.getClass()
            r5 = r0[r2]
            r5.getClass()
            int r4 = r4.compareTo(r5)
            if (r4 >= 0) goto L3a
            r8.e(r9, r2)
            r8.d(r2)
            goto L7a
        L3a:
            int r2 = r9 * 2
            int r4 = r2 + 1
            int r5 = r1.get(r8)
            if (r4 < r5) goto L45
            goto L7a
        L45:
            o7.u0[] r5 = r8.f10363a
            r5.getClass()
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L63
            r6 = r5[r2]
            r6.getClass()
            r7 = r5[r4]
            r7.getClass()
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L63
            goto L64
        L63:
            r2 = r4
        L64:
            r4 = r5[r9]
            r4.getClass()
            r5 = r5[r2]
            r5.getClass()
            int r4 = r4.compareTo(r5)
            if (r4 > 0) goto L75
            goto L7a
        L75:
            r8.e(r9, r2)
            r9 = r2
            goto L3a
        L7a:
            int r9 = r1.get(r8)
            r9 = r0[r9]
            r9.getClass()
            r2 = 0
            r9.d(r2)
            r9.f8317b = r3
            int r1 = r1.get(r8)
            r0[r1] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.x.c(int):o7.u0");
    }

    public final void d(int i) {
        while (i > 0) {
            u0[] u0VarArr = this.f10363a;
            u0VarArr.getClass();
            int i6 = (i - 1) / 2;
            u0 u0Var = u0VarArr[i6];
            u0Var.getClass();
            u0 u0Var2 = u0VarArr[i];
            u0Var2.getClass();
            if (u0Var.compareTo(u0Var2) <= 0) {
                return;
            }
            e(i, i6);
            i = i6;
        }
    }

    public final void e(int i, int i6) {
        u0[] u0VarArr = this.f10363a;
        u0VarArr.getClass();
        u0 u0Var = u0VarArr[i6];
        u0Var.getClass();
        u0 u0Var2 = u0VarArr[i];
        u0Var2.getClass();
        u0VarArr[i] = u0Var;
        u0VarArr[i6] = u0Var2;
        u0Var.f8317b = i;
        u0Var2.f8317b = i6;
    }
}
