package b2;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j0 extends m2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f830a;

    /* renamed from: b, reason: collision with root package name */
    public final String f831b;

    /* renamed from: c, reason: collision with root package name */
    public final String f832c;

    /* renamed from: d, reason: collision with root package name */
    public final long f833d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f834e;
    public final boolean f;
    public final u1 g;
    public final l2 h;
    public final k2 i;
    public final v1 j;

    /* renamed from: k, reason: collision with root package name */
    public final List f835k;

    /* renamed from: l, reason: collision with root package name */
    public final int f836l;

    public j0(String str, String str2, String str3, long j, Long l10, boolean z9, u1 u1Var, l2 l2Var, k2 k2Var, v1 v1Var, List list, int i) {
        this.f830a = str;
        this.f831b = str2;
        this.f832c = str3;
        this.f833d = j;
        this.f834e = l10;
        this.f = z9;
        this.g = u1Var;
        this.h = l2Var;
        this.i = k2Var;
        this.j = v1Var;
        this.f835k = list;
        this.f836l = i;
    }

    @Override // b2.m2
    public final i0 a() {
        i0 i0Var = new i0();
        i0Var.f810a = this.f830a;
        i0Var.f811b = this.f831b;
        i0Var.f812c = this.f832c;
        i0Var.f813d = this.f833d;
        i0Var.f814e = this.f834e;
        i0Var.f = this.f;
        i0Var.g = this.g;
        i0Var.h = this.h;
        i0Var.i = this.i;
        i0Var.j = this.j;
        i0Var.f815k = this.f835k;
        i0Var.f816l = this.f836l;
        i0Var.f817m = (byte) 7;
        return i0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m2) {
            j0 j0Var = (j0) ((m2) obj);
            if (this.f830a.equals(j0Var.f830a) && this.f831b.equals(j0Var.f831b)) {
                String str = j0Var.f832c;
                String str2 = this.f832c;
                if (str2 != null ? str2.equals(str) : str == null) {
                    if (this.f833d == j0Var.f833d) {
                        Long l10 = j0Var.f834e;
                        Long l11 = this.f834e;
                        if (l11 != null ? l11.equals(l10) : l10 == null) {
                            if (this.f == j0Var.f && this.g.equals(j0Var.g)) {
                                l2 l2Var = j0Var.h;
                                l2 l2Var2 = this.h;
                                if (l2Var2 != null ? l2Var2.equals(l2Var) : l2Var == null) {
                                    k2 k2Var = j0Var.i;
                                    k2 k2Var2 = this.i;
                                    if (k2Var2 != null ? k2Var2.equals(k2Var) : k2Var == null) {
                                        v1 v1Var = j0Var.j;
                                        v1 v1Var2 = this.j;
                                        if (v1Var2 != null ? v1Var2.equals(v1Var) : v1Var == null) {
                                            List list = j0Var.f835k;
                                            List list2 = this.f835k;
                                            if (list2 != null ? list2.equals(list) : list == null) {
                                                if (this.f836l == j0Var.f836l) {
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
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((this.f830a.hashCode() ^ 1000003) * 1000003) ^ this.f831b.hashCode()) * 1000003;
        String str = this.f832c;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j = this.f833d;
        int i = (((hashCode ^ hashCode2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l10 = this.f834e;
        int hashCode3 = (((((i ^ (l10 == null ? 0 : l10.hashCode())) * 1000003) ^ (this.f ? 1231 : 1237)) * 1000003) ^ this.g.hashCode()) * 1000003;
        l2 l2Var = this.h;
        int hashCode4 = (hashCode3 ^ (l2Var == null ? 0 : l2Var.hashCode())) * 1000003;
        k2 k2Var = this.i;
        int hashCode5 = (hashCode4 ^ (k2Var == null ? 0 : k2Var.hashCode())) * 1000003;
        v1 v1Var = this.j;
        int hashCode6 = (hashCode5 ^ (v1Var == null ? 0 : v1Var.hashCode())) * 1000003;
        List list = this.f835k;
        return ((hashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.f836l;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Session{generator=");
        sb.append(this.f830a);
        sb.append(", identifier=");
        sb.append(this.f831b);
        sb.append(", appQualitySessionId=");
        sb.append(this.f832c);
        sb.append(", startedAt=");
        sb.append(this.f833d);
        sb.append(", endedAt=");
        sb.append(this.f834e);
        sb.append(", crashed=");
        sb.append(this.f);
        sb.append(", app=");
        sb.append(this.g);
        sb.append(", user=");
        sb.append(this.h);
        sb.append(", os=");
        sb.append(this.i);
        sb.append(", device=");
        sb.append(this.j);
        sb.append(", events=");
        sb.append(this.f835k);
        sb.append(", generatorType=");
        return androidx.lifecycle.l.x(sb, "}", this.f836l);
    }
}
