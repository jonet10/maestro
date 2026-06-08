package b2;

import android.os.Build;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f871a;

    /* renamed from: b, reason: collision with root package name */
    public final int f872b;

    /* renamed from: c, reason: collision with root package name */
    public final long f873c;

    /* renamed from: d, reason: collision with root package name */
    public final long f874d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f875e;
    public final int f;

    public m1(int i, int i6, long j, long j6, boolean z9, int i10) {
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.PRODUCT;
        this.f871a = i;
        if (str == null) {
            com.google.gson.internal.a.i("Null model");
            throw null;
        }
        this.f872b = i6;
        this.f873c = j;
        this.f874d = j6;
        this.f875e = z9;
        this.f = i10;
        if (str2 == null) {
            com.google.gson.internal.a.i("Null manufacturer");
            throw null;
        }
        if (str3 != null) {
            return;
        }
        com.google.gson.internal.a.i("Null modelClass");
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        if (this.f871a != m1Var.f871a) {
            return false;
        }
        String str = Build.MODEL;
        if (!str.equals(str) || this.f872b != m1Var.f872b || this.f873c != m1Var.f873c || this.f874d != m1Var.f874d || this.f875e != m1Var.f875e || this.f != m1Var.f) {
            return false;
        }
        String str2 = Build.MANUFACTURER;
        if (!str2.equals(str2)) {
            return false;
        }
        String str3 = Build.PRODUCT;
        return str3.equals(str3);
    }

    public final int hashCode() {
        int hashCode = (((((this.f871a ^ 1000003) * 1000003) ^ Build.MODEL.hashCode()) * 1000003) ^ this.f872b) * 1000003;
        long j = this.f873c;
        int i = (hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j6 = this.f874d;
        return ((((((((i ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ (this.f875e ? 1231 : 1237)) * 1000003) ^ this.f) * 1000003) ^ Build.MANUFACTURER.hashCode()) * 1000003) ^ Build.PRODUCT.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceData{arch=");
        sb.append(this.f871a);
        sb.append(", model=");
        sb.append(Build.MODEL);
        sb.append(", availableProcessors=");
        sb.append(this.f872b);
        sb.append(", totalRam=");
        sb.append(this.f873c);
        sb.append(", diskSpace=");
        sb.append(this.f874d);
        sb.append(", isEmulator=");
        sb.append(this.f875e);
        sb.append(", state=");
        sb.append(this.f);
        sb.append(", manufacturer=");
        sb.append(Build.MANUFACTURER);
        sb.append(", modelClass=");
        return a4.x.n(sb, Build.PRODUCT, "}");
    }
}
