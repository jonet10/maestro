package d8;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f3649a;

    /* renamed from: b, reason: collision with root package name */
    public int f3650b;

    @Override // d8.r0
    public final Object a() {
        return Arrays.copyOf(this.f3649a, this.f3650b);
    }

    @Override // d8.r0
    public final void b(int i) {
        byte[] bArr = this.f3649a;
        if (bArr.length < i) {
            int length = bArr.length * 2;
            if (i < length) {
                i = length;
            }
            this.f3649a = Arrays.copyOf(bArr, i);
        }
    }

    @Override // d8.r0
    public final int d() {
        return this.f3650b;
    }
}
