package j8;

import java.util.ArrayList;
import kotlin.jvm.internal.l;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f6720a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f6721b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f6722c;

    /* renamed from: d, reason: collision with root package name */
    public final k6.a f6723d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f6724e;
    public Object f;
    public final boolean g;

    public b(Integer num, Boolean bool, k6.a aVar, ArrayList arrayList, boolean z9) {
        Boolean bool2 = Boolean.FALSE;
        this.f6720a = num;
        this.f6721b = bool;
        this.f6722c = bool2;
        this.f6723d = aVar;
        this.f6724e = arrayList;
        this.f = t.f8724a;
        this.g = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6720a.equals(bVar.f6720a) && this.f6721b.equals(bVar.f6721b) && l.a(this.f6722c, bVar.f6722c) && this.f6723d.equals(bVar.f6723d) && this.f6724e.equals(bVar.f6724e) && l.a(this.f, bVar.f) && this.g == bVar.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = (this.f6721b.hashCode() + (this.f6720a.hashCode() * 961)) * 31;
        Boolean bool = this.f6722c;
        int hashCode2 = (this.f6724e.hashCode() + ((this.f6723d.hashCode() + ((hashCode + (bool == null ? 0 : bool.hashCode())) * 31)) * 31)) * 31;
        Object obj = this.f;
        int hashCode3 = (hashCode2 + (obj != null ? obj.hashCode() : 0)) * 31;
        boolean z9 = this.g;
        int i = z9;
        if (z9 != 0) {
            i = 1;
        }
        return hashCode3 + i;
    }

    public final String toString() {
        return "MSPAPurpose(id=" + this.f6720a + ", category=, defaultValue=" + this.f6721b + ", value=" + this.f6722c + ", consentBanner=" + this.f6723d + ", purposes=" + this.f6724e + ", applicableSensitivePurposes=" + this.f + ", noticeOnly=" + this.g + ')';
    }
}
