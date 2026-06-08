package d8;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i1 extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public long[] f3657a;

    /* renamed from: b, reason: collision with root package name */
    public int f3658b;

    @Override // d8.r0
    public final Object a() {
        return new p6.t(Arrays.copyOf(this.f3657a, this.f3658b));
    }

    @Override // d8.r0
    public final void b(int i) {
        long[] jArr = this.f3657a;
        if (jArr.length < i) {
            int length = jArr.length * 2;
            if (i < length) {
                i = length;
            }
            this.f3657a = Arrays.copyOf(jArr, i);
        }
    }

    @Override // d8.r0
    public final int d() {
        return this.f3658b;
    }
}
