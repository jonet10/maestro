package j8;

import java.util.ArrayList;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f6725a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f6726b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6727c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f6728d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6729e;
    public final ArrayList f;

    public c(Integer num, Integer num2, String str, String str2, ArrayList arrayList) {
        Boolean bool = Boolean.FALSE;
        this.f6725a = num;
        this.f6726b = num2;
        this.f6727c = str;
        this.f6728d = bool;
        this.f6729e = str2;
        this.f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f6725a.equals(cVar.f6725a) && this.f6726b.equals(cVar.f6726b) && l.a(this.f6727c, cVar.f6727c) && l.a(this.f6728d, cVar.f6728d) && l.a(this.f6729e, cVar.f6729e) && this.f.equals(cVar.f);
    }

    public final int hashCode() {
        int hashCode = (this.f6726b.hashCode() + (this.f6725a.hashCode() * 31)) * 31;
        String str = this.f6727c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.f6728d;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.f6729e;
        return this.f.hashCode() + ((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "MSPASensitivePurpose(id=" + this.f6725a + ", order=" + this.f6726b + ", title=" + ((Object) this.f6727c) + ", value=" + this.f6728d + ", description=" + ((Object) this.f6729e) + ", nationalIds=" + this.f + ')';
    }
}
