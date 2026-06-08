package j$.time.format;

import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class n {
    public static final a f = new a(0);

    /* renamed from: a, reason: collision with root package name */
    public n f5847a;

    /* renamed from: b, reason: collision with root package name */
    public final n f5848b;

    /* renamed from: c, reason: collision with root package name */
    public final List f5849c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5850d;

    /* renamed from: e, reason: collision with root package name */
    public int f5851e;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put('G', j$.time.temporal.a.ERA);
        hashMap.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        hashMap.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.h hVar = j$.time.temporal.j.f5906a;
        hashMap.put('Q', hVar);
        hashMap.put('q', hVar);
        j$.time.temporal.a aVar = j$.time.temporal.a.MONTH_OF_YEAR;
        hashMap.put('M', aVar);
        hashMap.put('L', aVar);
        hashMap.put('D', j$.time.temporal.a.DAY_OF_YEAR);
        hashMap.put('d', j$.time.temporal.a.DAY_OF_MONTH);
        hashMap.put('F', j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_WEEK;
        hashMap.put('E', aVar2);
        hashMap.put('c', aVar2);
        hashMap.put('e', aVar2);
        hashMap.put('a', j$.time.temporal.a.AMPM_OF_DAY);
        hashMap.put('H', j$.time.temporal.a.HOUR_OF_DAY);
        hashMap.put('k', j$.time.temporal.a.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', j$.time.temporal.a.HOUR_OF_AMPM);
        hashMap.put('h', j$.time.temporal.a.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', j$.time.temporal.a.MINUTE_OF_HOUR);
        hashMap.put('s', j$.time.temporal.a.SECOND_OF_MINUTE);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_SECOND;
        hashMap.put('S', aVar3);
        hashMap.put('A', j$.time.temporal.a.MILLI_OF_DAY);
        hashMap.put('n', aVar3);
        hashMap.put('N', j$.time.temporal.a.NANO_OF_DAY);
        hashMap.put('g', j$.time.temporal.l.f5913a);
    }

    public n() {
        this.f5847a = this;
        this.f5849c = new ArrayList();
        this.f5851e = -1;
        this.f5848b = null;
        this.f5850d = false;
    }

    public n(n nVar) {
        this.f5847a = this;
        this.f5849c = new ArrayList();
        this.f5851e = -1;
        this.f5848b = nVar;
        this.f5850d = true;
    }

    public final void g(j$.time.temporal.q qVar, int i) {
        Objects.requireNonNull(qVar, "field");
        if (i < 1 || i > 19) {
            j$.time.g.i("The width must be from 1 to 19 inclusive but was ", i);
        } else {
            f(new i(qVar, i, i, u.NOT_NEGATIVE));
        }
    }

    public final void h(j$.time.temporal.q qVar, int i, int i6, u uVar) {
        if (i == i6 && uVar == u.NOT_NEGATIVE) {
            g(qVar, i6);
            return;
        }
        Objects.requireNonNull(qVar, "field");
        Objects.requireNonNull(uVar, "signStyle");
        if (i < 1 || i > 19) {
            j$.time.g.i("The minimum width must be from 1 to 19 inclusive but was ", i);
            return;
        }
        if (i6 < 1 || i6 > 19) {
            j$.time.g.i("The maximum width must be from 1 to 19 inclusive but was ", i6);
            return;
        }
        if (i6 < i) {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i6 + " < " + i);
        }
        f(new i(qVar, i, i6, uVar));
    }

    public final void f(i iVar) {
        i a8;
        n nVar = this.f5847a;
        int i = nVar.f5851e;
        if (i < 0) {
            nVar.f5851e = b(iVar);
            return;
        }
        i iVar2 = (i) ((ArrayList) nVar.f5849c).get(i);
        int i6 = iVar.f5832b;
        int i10 = iVar.f5833c;
        if (i6 == i10 && iVar.f5834d == u.NOT_NEGATIVE) {
            a8 = iVar2.b(i10);
            b(iVar.a());
            this.f5847a.f5851e = i;
        } else {
            a8 = iVar2.a();
            this.f5847a.f5851e = b(iVar);
        }
        ((ArrayList) this.f5847a.f5849c).set(i, a8);
    }

    public final void e(j$.time.temporal.a aVar, Map map) {
        Objects.requireNonNull(aVar, "field");
        Objects.requireNonNull(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        v vVar = v.FULL;
        b(new m(aVar, vVar, new b(new r(0, Collections.singletonMap(vVar, linkedHashMap)))));
    }

    public final void c(char c9) {
        b(new d(c9));
    }

    public final void d(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.isEmpty()) {
            return;
        }
        if (str.length() == 1) {
            b(new d(str.charAt(0)));
        } else {
            b(new l(str));
        }
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        e eVar = dateTimeFormatter.f5819a;
        if (eVar.f5829b) {
            eVar = new e(eVar.f5828a, false);
        }
        b(eVar);
    }

    public final void j() {
        n nVar = this.f5847a;
        nVar.f5851e = -1;
        this.f5847a = new n(nVar);
    }

    public final void i() {
        n nVar = this.f5847a;
        if (nVar.f5848b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        int size = ((ArrayList) nVar.f5849c).size();
        n nVar2 = this.f5847a;
        if (size > 0) {
            e eVar = new e(nVar2.f5849c, nVar2.f5850d);
            this.f5847a = this.f5847a.f5848b;
            b(eVar);
            return;
        }
        this.f5847a = nVar2.f5848b;
    }

    public final int b(f fVar) {
        Objects.requireNonNull(fVar, "pp");
        n nVar = this.f5847a;
        nVar.getClass();
        ((ArrayList) nVar.f5849c).add(fVar);
        this.f5847a.f5851e = -1;
        return ((ArrayList) r2.f5849c).size() - 1;
    }

    public final DateTimeFormatter k(t tVar, j$.time.chrono.l lVar) {
        return l(Locale.getDefault(), tVar, lVar);
    }

    public final DateTimeFormatter l(Locale locale, t tVar, j$.time.chrono.l lVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.f5847a.f5848b != null) {
            i();
        }
        e eVar = new e(this.f5849c, false);
        s sVar = s.f5860a;
        return new DateTimeFormatter(eVar, locale, tVar, lVar);
    }
}
