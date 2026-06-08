package q;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class p extends b0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8608a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f8609b;

    public p(byte[] bArr, byte[] bArr2) {
        this.f8608a = bArr;
        this.f8609b = bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            boolean z9 = b0Var instanceof p;
            p pVar = (p) b0Var;
            if (Arrays.equals(this.f8608a, z9 ? pVar.f8608a : pVar.f8608a)) {
                p pVar2 = (p) b0Var;
                if (Arrays.equals(this.f8609b, z9 ? pVar2.f8609b : pVar2.f8609b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.f8608a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f8609b);
    }

    public final String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f8608a) + ", encryptedBlob=" + Arrays.toString(this.f8609b) + "}";
    }
}
