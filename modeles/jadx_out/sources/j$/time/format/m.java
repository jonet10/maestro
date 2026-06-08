package j$.time.format;

import java.util.Locale;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class m implements f {

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.temporal.q f5843a;

    /* renamed from: b, reason: collision with root package name */
    public final v f5844b;

    /* renamed from: c, reason: collision with root package name */
    public final b f5845c;

    /* renamed from: d, reason: collision with root package name */
    public volatile i f5846d;

    public m(j$.time.temporal.q qVar, v vVar, b bVar) {
        this.f5843a = qVar;
        this.f5844b = vVar;
        this.f5845c = bVar;
    }

    @Override // j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        String a8;
        Long a10 = pVar.a(this.f5843a);
        if (a10 == null) {
            return false;
        }
        j$.time.chrono.l lVar = (j$.time.chrono.l) pVar.f5856a.k(j$.time.temporal.r.f5917b);
        if (lVar == null || lVar == j$.time.chrono.s.f5797c) {
            b bVar = this.f5845c;
            long longValue = a10.longValue();
            v vVar = this.f5844b;
            Locale locale = pVar.f5857b.f5820b;
            a8 = bVar.f5825a.a(longValue, vVar);
        } else {
            b bVar2 = this.f5845c;
            long longValue2 = a10.longValue();
            v vVar2 = this.f5844b;
            Locale locale2 = pVar.f5857b.f5820b;
            a8 = bVar2.f5825a.a(longValue2, vVar2);
        }
        if (a8 != null) {
            sb.append(a8);
            return true;
        }
        if (this.f5846d == null) {
            this.f5846d = new i(this.f5843a, 1, 19, u.NORMAL);
        }
        return this.f5846d.e(pVar, sb);
    }

    public final String toString() {
        v vVar = v.FULL;
        v vVar2 = this.f5844b;
        j$.time.temporal.q qVar = this.f5843a;
        if (vVar2 == vVar) {
            return "Text(" + qVar + ")";
        }
        return "Text(" + qVar + "," + vVar2 + ")";
    }
}
