package j$.time.format;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class l implements f {

    /* renamed from: a, reason: collision with root package name */
    public final String f5842a;

    public l(String str) {
        this.f5842a = str;
    }

    @Override // j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        sb.append(this.f5842a);
        return true;
    }

    public final String toString() {
        return "'" + this.f5842a.replace("'", "''") + "'";
    }
}
