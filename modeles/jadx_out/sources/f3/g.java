package f3;

import d8.o0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g {
    public static final f Companion = new f();

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f4846a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f4847b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f4848c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f4849d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f4850e;

    public /* synthetic */ g(int i, Boolean bool, Double d10, Integer num, Integer num2, Long l10) {
        if (31 != (i & 31)) {
            o0.e(e.f4845a.getDescriptor(), i, 31);
            throw null;
        }
        this.f4846a = bool;
        this.f4847b = d10;
        this.f4848c = num;
        this.f4849d = num2;
        this.f4850e = l10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return kotlin.jvm.internal.l.a(this.f4846a, gVar.f4846a) && kotlin.jvm.internal.l.a(this.f4847b, gVar.f4847b) && kotlin.jvm.internal.l.a(this.f4848c, gVar.f4848c) && kotlin.jvm.internal.l.a(this.f4849d, gVar.f4849d) && kotlin.jvm.internal.l.a(this.f4850e, gVar.f4850e);
    }

    public final int hashCode() {
        Boolean bool = this.f4846a;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d10 = this.f4847b;
        int hashCode2 = (hashCode + (d10 == null ? 0 : d10.hashCode())) * 31;
        Integer num = this.f4848c;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f4849d;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l10 = this.f4850e;
        return hashCode4 + (l10 != null ? l10.hashCode() : 0);
    }

    public final String toString() {
        return "SessionConfigs(sessionsEnabled=" + this.f4846a + ", sessionSamplingRate=" + this.f4847b + ", sessionTimeoutSeconds=" + this.f4848c + ", cacheDurationSeconds=" + this.f4849d + ", cacheUpdatedTimeSeconds=" + this.f4850e + ')';
    }

    public g(Boolean bool, Double d10, Integer num, Integer num2, Long l10) {
        this.f4846a = bool;
        this.f4847b = d10;
        this.f4848c = num;
        this.f4849d = num2;
        this.f4850e = l10;
    }
}
