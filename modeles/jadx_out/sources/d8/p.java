package d8;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public double[] f3687a;

    /* renamed from: b, reason: collision with root package name */
    public int f3688b;

    @Override // d8.r0
    public final Object a() {
        return Arrays.copyOf(this.f3687a, this.f3688b);
    }

    @Override // d8.r0
    public final void b(int i) {
        double[] dArr = this.f3687a;
        if (dArr.length < i) {
            int length = dArr.length * 2;
            if (i < length) {
                i = length;
            }
            this.f3687a = Arrays.copyOf(dArr, i);
        }
    }

    @Override // d8.r0
    public final int d() {
        return this.f3688b;
    }
}
