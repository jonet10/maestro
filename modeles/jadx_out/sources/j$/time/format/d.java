package j$.time.format;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class d implements f {

    /* renamed from: a, reason: collision with root package name */
    public final char f5827a;

    public d(char c9) {
        this.f5827a = c9;
    }

    @Override // j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        sb.append(this.f5827a);
        return true;
    }

    public final String toString() {
        char c9 = this.f5827a;
        if (c9 == '\'') {
            return "''";
        }
        return "'" + c9 + "'";
    }
}
