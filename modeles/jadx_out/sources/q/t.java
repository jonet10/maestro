package q;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class t extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f8617a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8618b;

    /* renamed from: c, reason: collision with root package name */
    public final n f8619c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f8620d;

    /* renamed from: e, reason: collision with root package name */
    public final String f8621e;
    public final ArrayList f;

    public t(long j, long j6, n nVar, Integer num, String str, ArrayList arrayList) {
        j0 j0Var = j0.f8593a;
        this.f8617a = j;
        this.f8618b = j6;
        this.f8619c = nVar;
        this.f8620d = num;
        this.f8621e = str;
        this.f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        t tVar = (t) ((f0) obj);
        if (this.f8617a != tVar.f8617a || this.f8618b != tVar.f8618b || !this.f8619c.equals(tVar.f8619c)) {
            return false;
        }
        Integer num = tVar.f8620d;
        Integer num2 = this.f8620d;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        String str = tVar.f8621e;
        String str2 = this.f8621e;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (!this.f.equals(tVar.f)) {
            return false;
        }
        Object obj2 = j0.f8593a;
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        long j = this.f8617a;
        long j6 = this.f8618b;
        int hashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f8619c.hashCode()) * 1000003;
        Integer num = this.f8620d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f8621e;
        return ((((hashCode2 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.f.hashCode()) * 1000003) ^ j0.f8593a.hashCode();
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f8617a + ", requestUptimeMs=" + this.f8618b + ", clientInfo=" + this.f8619c + ", logSource=" + this.f8620d + ", logSourceName=" + this.f8621e + ", logEvents=" + this.f + ", qosTier=" + j0.f8593a + "}";
    }
}
