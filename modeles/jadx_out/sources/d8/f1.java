package d8;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f1 extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public int[] f3642a;

    /* renamed from: b, reason: collision with root package name */
    public int f3643b;

    @Override // d8.r0
    public final Object a() {
        return new p6.r(Arrays.copyOf(this.f3642a, this.f3643b));
    }

    @Override // d8.r0
    public final void b(int i) {
        int[] iArr = this.f3642a;
        if (iArr.length < i) {
            int length = iArr.length * 2;
            if (i < length) {
                i = length;
            }
            this.f3642a = Arrays.copyOf(iArr, i);
        }
    }

    @Override // d8.r0
    public final int d() {
        return this.f3643b;
    }
}
