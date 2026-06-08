package b2;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h0 extends r1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f798a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f799b;

    public h0(String str, byte[] bArr) {
        this.f798a = str;
        this.f799b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r1)) {
            return false;
        }
        r1 r1Var = (r1) obj;
        h0 h0Var = (h0) r1Var;
        if (this.f798a.equals(h0Var.f798a)) {
            return Arrays.equals(this.f799b, r1Var instanceof h0 ? ((h0) r1Var).f799b : h0Var.f799b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f798a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f799b);
    }

    public final String toString() {
        return "File{filename=" + this.f798a + ", contents=" + Arrays.toString(this.f799b) + "}";
    }
}
