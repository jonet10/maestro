package k0;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f6880a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6881b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6882c;

    public h0(String str, boolean z9) {
        y.d(str);
        this.f6880a = str;
        y.d("com.google.android.gms");
        this.f6881b = "com.google.android.gms";
        this.f6882c = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return y.j(this.f6880a, h0Var.f6880a) && y.j(this.f6881b, h0Var.f6881b) && y.j(null, null) && this.f6882c == h0Var.f6882c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6880a, this.f6881b, null, 4225, Boolean.valueOf(this.f6882c)});
    }

    public final String toString() {
        String str = this.f6880a;
        if (str != null) {
            return str;
        }
        y.g(null);
        throw null;
    }
}
