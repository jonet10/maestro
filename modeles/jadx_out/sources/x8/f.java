package x8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.l;
import p6.m;
import w8.g0;
import w8.k;
import w8.n;
import w8.o;
import w8.u;
import w8.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends o {

    /* renamed from: c, reason: collision with root package name */
    public static final y f11557c;

    /* renamed from: b, reason: collision with root package name */
    public final m f11558b;

    static {
        String str = y.f11004b;
        f11557c = q1.a.j("/", false);
    }

    public f(ClassLoader classLoader) {
        this.f11558b = new m(new o9.a(classLoader, 8));
    }

    public static String i(y yVar) {
        y d10;
        y yVar2 = f11557c;
        yVar2.getClass();
        k kVar = yVar2.f11005a;
        yVar.getClass();
        y b7 = c.b(yVar2, yVar, true);
        k kVar2 = b7.f11005a;
        int a8 = c.a(b7);
        y yVar3 = a8 == -1 ? null : new y(kVar2.q(0, a8));
        int a10 = c.a(yVar2);
        if (!l.a(yVar3, a10 != -1 ? new y(kVar.q(0, a10)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + b7 + " and " + yVar2).toString());
        }
        ArrayList a11 = b7.a();
        ArrayList a12 = yVar2.a();
        int min = Math.min(a11.size(), a12.size());
        int i = 0;
        while (i < min && l.a(a11.get(i), a12.get(i))) {
            i++;
        }
        if (i == min && kVar2.f() == kVar.f()) {
            String str = y.f11004b;
            d10 = q1.a.j(".", false);
        } else {
            if (a12.subList(i, a12.size()).indexOf(c.f11551e) != -1) {
                throw new IllegalArgumentException(("Impossible relative path to resolve: " + b7 + " and " + yVar2).toString());
            }
            w8.h hVar = new w8.h();
            k c9 = c.c(yVar2);
            if (c9 == null && (c9 = c.c(b7)) == null) {
                c9 = c.f(y.f11004b);
            }
            int size = a12.size();
            for (int i6 = i; i6 < size; i6++) {
                hVar.y(c.f11551e);
                hVar.y(c9);
            }
            int size2 = a11.size();
            while (i < size2) {
                hVar.y((k) a11.get(i));
                hVar.y(c9);
                i++;
            }
            d10 = c.d(hVar, false);
        }
        return d10.f11005a.t();
    }

    @Override // w8.o
    public final void a(y yVar, y yVar2) {
        yVar2.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // w8.o
    public final void b(y yVar) {
        throw new IOException(this + " is read-only");
    }

    @Override // w8.o
    public final void c(y yVar) {
        throw new IOException(this + " is read-only");
    }

    @Override // w8.o
    public final n e(y yVar) {
        yVar.getClass();
        if (!q1.a.f(yVar)) {
            return null;
        }
        String i = i(yVar);
        for (p6.i iVar : (List) this.f11558b.getValue()) {
            n e10 = ((o) iVar.f8441a).e(((y) iVar.f8442b).d(i));
            if (e10 != null) {
                return e10;
            }
        }
        return null;
    }

    @Override // w8.o
    public final u f(y yVar) {
        if (!q1.a.f(yVar)) {
            s1.o.p(yVar, "file not found: ");
            return null;
        }
        String i = i(yVar);
        for (p6.i iVar : (List) this.f11558b.getValue()) {
            try {
                return ((o) iVar.f8441a).f(((y) iVar.f8442b).d(i));
            } catch (FileNotFoundException unused) {
            }
        }
        s1.o.p(yVar, "file not found: ");
        return null;
    }

    @Override // w8.o
    public final u g(y yVar) {
        throw new IOException("resources are not writable");
    }

    @Override // w8.o
    public final g0 h(y yVar) {
        yVar.getClass();
        if (!q1.a.f(yVar)) {
            s1.o.p(yVar, "file not found: ");
            return null;
        }
        String i = i(yVar);
        for (p6.i iVar : (List) this.f11558b.getValue()) {
            try {
                return ((o) iVar.f8441a).h(((y) iVar.f8442b).d(i));
            } catch (FileNotFoundException unused) {
            }
        }
        s1.o.p(yVar, "file not found: ");
        return null;
    }
}
