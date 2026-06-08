package u2;

import a4.x;
import c.j;
import k0.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {
    public static final /* synthetic */ int h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f10404a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10405b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10406c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10407d;

    /* renamed from: e, reason: collision with root package name */
    public final long f10408e;
    public final long f;
    public final String g;

    static {
        byte b7 = (byte) (((byte) (0 | 2)) | 1);
        if (b7 == 3) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if ((b7 & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((b7 & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k.h("Missing required properties:", sb));
    }

    public b(String str, int i, String str2, String str3, long j, long j6, String str4) {
        this.f10404a = str;
        this.f10405b = i;
        this.f10406c = str2;
        this.f10407d = str3;
        this.f10408e = j;
        this.f = j6;
        this.g = str4;
    }

    public final a a() {
        a aVar = new a();
        aVar.f10399a = this.f10404a;
        aVar.f10400b = this.f10405b;
        aVar.f10401c = this.f10406c;
        aVar.f10402d = this.f10407d;
        aVar.f10403e = this.f10408e;
        aVar.f = this.f;
        aVar.g = this.g;
        aVar.h = (byte) 3;
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        String str = bVar.f10404a;
        String str2 = this.f10404a;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (!j.a(this.f10405b, bVar.f10405b)) {
            return false;
        }
        String str3 = bVar.f10406c;
        String str4 = this.f10406c;
        if (str4 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str4.equals(str3)) {
            return false;
        }
        String str5 = bVar.f10407d;
        String str6 = this.f10407d;
        if (str6 == null) {
            if (str5 != null) {
                return false;
            }
        } else if (!str6.equals(str5)) {
            return false;
        }
        if (this.f10408e != bVar.f10408e || this.f != bVar.f) {
            return false;
        }
        String str7 = bVar.g;
        String str8 = this.g;
        return str8 == null ? str7 == null : str8.equals(str7);
    }

    public final int hashCode() {
        String str = this.f10404a;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ j.c(this.f10405b)) * 1000003;
        String str2 = this.f10406c;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f10407d;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j = this.f10408e;
        int i = (hashCode3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j6 = this.f;
        int i6 = (i ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        String str4 = this.g;
        return (str4 != null ? str4.hashCode() : 0) ^ i6;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PersistedInstallationEntry{firebaseInstallationId=");
        sb.append(this.f10404a);
        sb.append(", registrationStatus=");
        int i = this.f10405b;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "REGISTER_ERROR" : "REGISTERED" : "UNREGISTERED" : "NOT_GENERATED" : "ATTEMPT_MIGRATION");
        sb.append(", authToken=");
        sb.append(this.f10406c);
        sb.append(", refreshToken=");
        sb.append(this.f10407d);
        sb.append(", expiresInSecs=");
        sb.append(this.f10408e);
        sb.append(", tokenCreationEpochInSecs=");
        sb.append(this.f);
        sb.append(", fisError=");
        return x.n(sb, this.g, "}");
    }
}
