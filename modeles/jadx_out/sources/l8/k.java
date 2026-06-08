package l8;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f7218a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7219b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7220c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7221d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f7222e;
    public final Object f;

    public k(String str, boolean z9, String str2, boolean z10, List list, List list2) {
        this.f7218a = str;
        this.f7219b = z9;
        this.f7220c = str2;
        this.f7221d = z10;
        this.f7222e = list;
        this.f = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kotlin.jvm.internal.l.a(this.f7218a, kVar.f7218a) && this.f7219b == kVar.f7219b && kotlin.jvm.internal.l.a(this.f7220c, kVar.f7220c) && this.f7221d == kVar.f7221d && kotlin.jvm.internal.l.a(this.f7222e, kVar.f7222e) && kotlin.jvm.internal.l.a(this.f, kVar.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, java.util.List] */
    public final int hashCode() {
        String str = this.f7218a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z9 = this.f7219b;
        int i = z9;
        if (z9 != 0) {
            i = 1;
        }
        int i6 = (hashCode + i) * 31;
        String str2 = this.f7220c;
        int hashCode2 = (i6 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z10 = this.f7221d;
        return this.f.hashCode() + j8.e.a((hashCode2 + (z10 ? 1 : z10 ? 1 : 0)) * 31, this.f7222e);
    }

    public final String toString() {
        return "MSPAPortalConfig(mspaJurisdiction=" + ((Object) this.f7218a) + ", isCoveredTransaction=" + this.f7219b + ", mspaSignalMode=" + ((Object) this.f7220c) + ", mspaAutoPopUp=" + this.f7221d + ", mspaOptOutPurposeIds=" + this.f7222e + ", mspaSensitiveDataPurposeIds=" + this.f + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ k() {
        /*
            r7 = this;
            r4 = 0
            q6.t r5 = q6.t.f8724a
            java.lang.String r1 = ""
            r2 = 0
            java.lang.String r3 = ""
            r6 = r5
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.k.<init>():void");
    }
}
