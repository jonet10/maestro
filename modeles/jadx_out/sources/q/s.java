package q;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class s extends e0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f8612a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f8613b;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f8614c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8615d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f8616e;
    public final String f;
    public final long g;
    public final i0 h;
    public final b0 i;

    public s(long j, Integer num, a0 a0Var, long j6, byte[] bArr, String str, long j10, i0 i0Var, b0 b0Var) {
        this.f8612a = j;
        this.f8613b = num;
        this.f8614c = a0Var;
        this.f8615d = j6;
        this.f8616e = bArr;
        this.f = str;
        this.g = j10;
        this.h = i0Var;
        this.i = b0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e0) {
            e0 e0Var = (e0) obj;
            s sVar = (s) e0Var;
            if (this.f8612a == sVar.f8612a) {
                Integer num = sVar.f8613b;
                Integer num2 = this.f8613b;
                if (num2 != null ? num2.equals(num) : num == null) {
                    a0 a0Var = sVar.f8614c;
                    a0 a0Var2 = this.f8614c;
                    if (a0Var2 != null ? a0Var2.equals(a0Var) : a0Var == null) {
                        if (this.f8615d == sVar.f8615d) {
                            if (Arrays.equals(this.f8616e, e0Var instanceof s ? ((s) e0Var).f8616e : sVar.f8616e)) {
                                String str = sVar.f;
                                String str2 = this.f;
                                if (str2 != null ? str2.equals(str) : str == null) {
                                    if (this.g == sVar.g) {
                                        i0 i0Var = sVar.h;
                                        i0 i0Var2 = this.h;
                                        if (i0Var2 != null ? i0Var2.equals(i0Var) : i0Var == null) {
                                            b0 b0Var = sVar.i;
                                            b0 b0Var2 = this.i;
                                            if (b0Var2 != null ? b0Var2.equals(b0Var) : b0Var == null) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f8612a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f8613b;
        int hashCode = (i ^ (num == null ? 0 : num.hashCode())) * 1000003;
        a0 a0Var = this.f8614c;
        int hashCode2 = (hashCode ^ (a0Var == null ? 0 : a0Var.hashCode())) * 1000003;
        long j6 = this.f8615d;
        int hashCode3 = (((hashCode2 ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f8616e)) * 1000003;
        String str = this.f;
        int hashCode4 = (hashCode3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j10 = this.g;
        int i6 = (hashCode4 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        i0 i0Var = this.h;
        int hashCode5 = (i6 ^ (i0Var == null ? 0 : i0Var.hashCode())) * 1000003;
        b0 b0Var = this.i;
        return hashCode5 ^ (b0Var != null ? b0Var.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f8612a + ", eventCode=" + this.f8613b + ", complianceData=" + this.f8614c + ", eventUptimeMs=" + this.f8615d + ", sourceExtension=" + Arrays.toString(this.f8616e) + ", sourceExtensionJsonProto3=" + this.f + ", timezoneOffsetSeconds=" + this.g + ", networkConnectionInfo=" + this.h + ", experimentIds=" + this.i + "}";
    }
}
