package h9;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final g f5606a;

    /* renamed from: b, reason: collision with root package name */
    public final p f5607b;

    /* renamed from: c, reason: collision with root package name */
    public final k f5608c;

    /* renamed from: d, reason: collision with root package name */
    public final e f5609d;

    /* renamed from: e, reason: collision with root package name */
    public final a f5610e;

    public /* synthetic */ t() {
        this(new g(), new p(null, null, null, null, null, 1023), new k(), new e((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 127), new a((String) null, (String) null, (String) null, (String) null, (List) null, 63));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return kotlin.jvm.internal.l.a(this.f5606a, tVar.f5606a) && kotlin.jvm.internal.l.a(this.f5607b, tVar.f5607b) && kotlin.jvm.internal.l.a(this.f5608c, tVar.f5608c) && kotlin.jvm.internal.l.a(this.f5609d, tVar.f5609d) && kotlin.jvm.internal.l.a(this.f5610e, tVar.f5610e);
    }

    public final int hashCode() {
        return this.f5610e.hashCode() + ((this.f5609d.hashCode() + ((this.f5608c.hashCode() + ((this.f5607b.hashCode() + (this.f5606a.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TranslationsText(coreUiLabels=" + this.f5606a + ", premiumUiLabels=" + this.f5607b + ", mobileUiLabels=" + this.f5608c + ", consentOrPay=" + this.f5609d + ", advanced=" + this.f5610e + ')';
    }

    public t(g gVar, p pVar, k kVar, e eVar, a aVar) {
        this.f5606a = gVar;
        this.f5607b = pVar;
        this.f5608c = kVar;
        this.f5609d = eVar;
        this.f5610e = aVar;
    }
}
