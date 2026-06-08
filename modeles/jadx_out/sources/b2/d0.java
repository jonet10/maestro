package b2;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 extends p1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f762a;

    /* renamed from: b, reason: collision with root package name */
    public final String f763b;

    /* renamed from: c, reason: collision with root package name */
    public final int f764c;

    /* renamed from: d, reason: collision with root package name */
    public final int f765d;

    /* renamed from: e, reason: collision with root package name */
    public final long f766e;
    public final long f;
    public final long g;
    public final String h;
    public final List i;

    public d0(int i, String str, int i6, int i10, long j, long j6, long j10, String str2, List list) {
        this.f762a = i;
        this.f763b = str;
        this.f764c = i6;
        this.f765d = i10;
        this.f766e = j;
        this.f = j6;
        this.g = j10;
        this.h = str2;
        this.i = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p1) {
            d0 d0Var = (d0) ((p1) obj);
            if (this.f762a == d0Var.f762a && this.f763b.equals(d0Var.f763b) && this.f764c == d0Var.f764c && this.f765d == d0Var.f765d && this.f766e == d0Var.f766e && this.f == d0Var.f && this.g == d0Var.g) {
                String str = d0Var.h;
                String str2 = this.h;
                if (str2 != null ? str2.equals(str) : str == null) {
                    List list = d0Var.i;
                    List list2 = this.i;
                    if (list2 != null ? list2.equals(list) : list == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((((((this.f762a ^ 1000003) * 1000003) ^ this.f763b.hashCode()) * 1000003) ^ this.f764c) * 1000003) ^ this.f765d) * 1000003;
        long j = this.f766e;
        int i = (hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j6 = this.f;
        int i6 = (i ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        long j10 = this.g;
        int i10 = (i6 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        String str = this.h;
        int hashCode2 = (i10 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.i;
        return hashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "ApplicationExitInfo{pid=" + this.f762a + ", processName=" + this.f763b + ", reasonCode=" + this.f764c + ", importance=" + this.f765d + ", pss=" + this.f766e + ", rss=" + this.f + ", timestamp=" + this.g + ", traceFile=" + this.h + ", buildIdMappingForArch=" + this.i + "}";
    }
}
