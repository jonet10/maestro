package m8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends e0 {

    /* renamed from: a, reason: collision with root package name */
    public final o8.e f7708a;

    /* renamed from: b, reason: collision with root package name */
    public final w8.a0 f7709b;

    /* renamed from: l, reason: collision with root package name */
    public final String f7710l;

    public e(o8.e eVar, String str) {
        this.f7708a = eVar;
        this.f7710l = str;
        this.f7709b = new w8.a0(new d(eVar.f8353l[1], eVar));
    }

    @Override // m8.e0
    public final long b() {
        try {
            String str = this.f7710l;
            if (str != null) {
                return Long.parseLong(str);
            }
            return -1L;
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    @Override // m8.e0
    public final w8.j c() {
        return this.f7709b;
    }
}
