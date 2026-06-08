package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f1332a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1333b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1334c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1335d;

    /* renamed from: e, reason: collision with root package name */
    public final k f1336e;
    public final String f;
    public final String g;

    public v0(String str, String str2, int i, long j, k kVar, String str3, String str4) {
        str.getClass();
        str2.getClass();
        str4.getClass();
        this.f1332a = str;
        this.f1333b = str2;
        this.f1334c = i;
        this.f1335d = j;
        this.f1336e = kVar;
        this.f = str3;
        this.g = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return kotlin.jvm.internal.l.a(this.f1332a, v0Var.f1332a) && kotlin.jvm.internal.l.a(this.f1333b, v0Var.f1333b) && this.f1334c == v0Var.f1334c && this.f1335d == v0Var.f1335d && this.f1336e.equals(v0Var.f1336e) && this.f.equals(v0Var.f) && kotlin.jvm.internal.l.a(this.g, v0Var.g);
    }

    public final int hashCode() {
        int o10 = (androidx.lifecycle.l.o(this.f1332a.hashCode() * 31, 31, this.f1333b) + this.f1334c) * 31;
        long j = this.f1335d;
        return this.g.hashCode() + androidx.lifecycle.l.o((this.f1336e.hashCode() + ((o10 + ((int) (j ^ (j >>> 32)))) * 31)) * 31, 31, this.f);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SessionInfo(sessionId=");
        sb.append(this.f1332a);
        sb.append(", firstSessionId=");
        sb.append(this.f1333b);
        sb.append(", sessionIndex=");
        sb.append(this.f1334c);
        sb.append(", eventTimestampUs=");
        sb.append(this.f1335d);
        sb.append(", dataCollectionStatus=");
        sb.append(this.f1336e);
        sb.append(", firebaseInstallationId=");
        sb.append(this.f);
        sb.append(", firebaseAuthenticationToken=");
        return a4.x.m(sb, this.g, ')');
    }
}
