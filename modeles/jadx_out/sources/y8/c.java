package y8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends d9.a {

    /* renamed from: a, reason: collision with root package name */
    public final b9.b f11813a = new b9.b();

    @Override // d9.a
    public final b9.a d() {
        return this.f11813a;
    }

    @Override // d9.a
    public final a g(h hVar) {
        char charAt;
        int i = hVar.f11836e;
        CharSequence charSequence = hVar.f11832a;
        if (hVar.g >= 4 || i >= charSequence.length() || charSequence.charAt(i) != '>') {
            return null;
        }
        int i6 = hVar.f11834c + hVar.g;
        int i10 = i6 + 1;
        CharSequence charSequence2 = hVar.f11832a;
        int i11 = i + 1;
        if (i11 < charSequence2.length() && ((charAt = charSequence2.charAt(i11)) == '\t' || charAt == ' ')) {
            i10 = i6 + 2;
        }
        return new a(-1, i10, false);
    }
}
