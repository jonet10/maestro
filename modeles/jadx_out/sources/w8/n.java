package w8;

import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10980a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10981b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f10982c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f10983d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f10984e;
    public final Long f;
    public final Map g = q6.a0.l0(q6.u.f8725a);

    public n(boolean z9, boolean z10, Long l10, Long l11, Long l12, Long l13) {
        this.f10980a = z9;
        this.f10981b = z10;
        this.f10982c = l10;
        this.f10983d = l11;
        this.f10984e = l12;
        this.f = l13;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f10980a) {
            arrayList.add("isRegularFile");
        }
        if (this.f10981b) {
            arrayList.add("isDirectory");
        }
        Long l10 = this.f10982c;
        if (l10 != null) {
            arrayList.add("byteCount=" + l10);
        }
        Long l11 = this.f10983d;
        if (l11 != null) {
            arrayList.add("createdAt=" + l11);
        }
        Long l12 = this.f10984e;
        if (l12 != null) {
            arrayList.add("lastModifiedAt=" + l12);
        }
        Long l13 = this.f;
        if (l13 != null) {
            arrayList.add("lastAccessedAt=" + l13);
        }
        Map map = this.g;
        if (!map.isEmpty()) {
            arrayList.add("extras=" + map);
        }
        return q6.l.x0(arrayList, ", ", "FileMetadata(", ")", null, 56);
    }
}
