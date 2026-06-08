package m8;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public String f7787a;

    /* renamed from: d, reason: collision with root package name */
    public String f7790d;
    public final ArrayList f;
    public ArrayList g;
    public String h;

    /* renamed from: b, reason: collision with root package name */
    public String f7788b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f7789c = "";

    /* renamed from: e, reason: collision with root package name */
    public int f7791e = -1;

    public t() {
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.add("");
    }

    public final u a() {
        if (this.f7787a == null) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("scheme == null");
            return null;
        }
        if (this.f7790d != null) {
            return new u(this);
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("host == null");
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x01f9, code lost:
    
        if (r2 <= 65535) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x005b, code lost:
    
        if (r14 == ':') goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0219 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(m8.u r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.t.b(m8.u, java.lang.String):int");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7787a);
        sb.append("://");
        if (!this.f7788b.isEmpty() || !this.f7789c.isEmpty()) {
            sb.append(this.f7788b);
            if (!this.f7789c.isEmpty()) {
                sb.append(':');
                sb.append(this.f7789c);
            }
            sb.append('@');
        }
        if (this.f7790d.indexOf(58) != -1) {
            sb.append('[');
            sb.append(this.f7790d);
            sb.append(']');
        } else {
            sb.append(this.f7790d);
        }
        int i = this.f7791e;
        if (i == -1) {
            i = u.b(this.f7787a);
        }
        if (i != u.b(this.f7787a)) {
            sb.append(':');
            sb.append(i);
        }
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            sb.append('/');
            sb.append((String) arrayList.get(i6));
        }
        if (this.g != null) {
            sb.append('?');
            u.g(sb, this.g);
        }
        if (this.h != null) {
            sb.append('#');
            sb.append(this.h);
        }
        return sb.toString();
    }
}
