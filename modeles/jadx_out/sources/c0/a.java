package c0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1166a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1167b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1168c;

    public /* synthetic */ a(int i, String str, boolean z9) {
        this.f1166a = i;
        this.f1167b = str;
        this.f1168c = z9;
    }

    public String toString() {
        switch (this.f1166a) {
            case 0:
                String str = this.f1167b;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
                sb.append("{");
                sb.append(str);
                sb.append("}");
                sb.append(this.f1168c);
                return sb.toString();
            default:
                return super.toString();
        }
    }
}
