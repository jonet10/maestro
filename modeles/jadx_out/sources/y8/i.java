package y8;

import b2.t1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends d9.a {

    /* renamed from: a, reason: collision with root package name */
    public final b9.f f11842a;

    /* renamed from: b, reason: collision with root package name */
    public String f11843b;

    /* renamed from: c, reason: collision with root package name */
    public final StringBuilder f11844c;

    public i(char c9, int i, int i6) {
        b9.f fVar = new b9.f();
        this.f11842a = fVar;
        this.f11844c = new StringBuilder();
        fVar.f = c9;
        fVar.g = i;
        fVar.h = i6;
    }

    @Override // d9.a
    public final void a(CharSequence charSequence) {
        if (this.f11843b == null) {
            this.f11843b = charSequence.toString();
            return;
        }
        StringBuilder sb = this.f11844c;
        sb.append(charSequence);
        sb.append('\n');
    }

    @Override // d9.a
    public final void c() {
        String a8 = a9.a.a(this.f11843b.trim());
        b9.f fVar = this.f11842a;
        fVar.i = a8;
        fVar.j = this.f11844c.toString();
    }

    @Override // d9.a
    public final b9.a d() {
        return this.f11842a;
    }

    @Override // d9.a
    public final a g(h hVar) {
        int i = hVar.f11836e;
        int i6 = hVar.f11833b;
        CharSequence charSequence = hVar.f11832a;
        int i10 = hVar.g;
        b9.f fVar = this.f11842a;
        if (i10 < 4) {
            char c9 = fVar.f;
            int i11 = fVar.g;
            int M = t1.M(c9, i, charSequence.length(), charSequence) - i;
            if (M >= i11 && t1.N(charSequence, i + M, charSequence.length()) == charSequence.length()) {
                return new a(-1, -1, true);
            }
        }
        int length = charSequence.length();
        for (int i12 = fVar.h; i12 > 0 && i6 < length && charSequence.charAt(i6) == ' '; i12--) {
            i6++;
        }
        return a.a(i6);
    }
}
