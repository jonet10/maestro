package d8;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l1 extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public short[] f3671a;

    /* renamed from: b, reason: collision with root package name */
    public int f3672b;

    @Override // d8.r0
    public final Object a() {
        return new p6.w(Arrays.copyOf(this.f3671a, this.f3672b));
    }

    @Override // d8.r0
    public final void b(int i) {
        short[] sArr = this.f3671a;
        if (sArr.length < i) {
            int length = sArr.length * 2;
            if (i < length) {
                i = length;
            }
            this.f3671a = Arrays.copyOf(sArr, i);
        }
    }

    @Override // d8.r0
    public final int d() {
        return this.f3672b;
    }
}
