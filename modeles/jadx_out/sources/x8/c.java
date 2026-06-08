package x8;

import a4.x;
import androidx.lifecycle.l;
import com.google.android.gms.internal.measurement.z3;
import w8.k;
import w8.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final k f11547a;

    /* renamed from: b, reason: collision with root package name */
    public static final k f11548b;

    /* renamed from: c, reason: collision with root package name */
    public static final k f11549c;

    /* renamed from: d, reason: collision with root package name */
    public static final k f11550d;

    /* renamed from: e, reason: collision with root package name */
    public static final k f11551e;

    static {
        k kVar = k.f10970m;
        f11547a = z3.m("/");
        f11548b = z3.m("\\");
        f11549c = z3.m("/\\");
        f11550d = z3.m(".");
        f11551e = z3.m("..");
    }

    public static final int a(y yVar) {
        k kVar = yVar.f11005a;
        if (kVar.f() != 0) {
            if (kVar.k(0) != 47) {
                if (kVar.k(0) == 92) {
                    if (kVar.f() > 2 && kVar.k(1) == 92) {
                        k kVar2 = f11548b;
                        kVar2.getClass();
                        int h = kVar.h(2, kVar2.j());
                        return h == -1 ? kVar.f() : h;
                    }
                } else if (kVar.f() > 2 && kVar.k(1) == 58 && kVar.k(2) == 92) {
                    char k5 = (char) kVar.k(0);
                    if ('a' <= k5 && k5 < '{') {
                        return 3;
                    }
                    if ('A' <= k5 && k5 < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static final y b(y yVar, y yVar2, boolean z9) {
        yVar2.getClass();
        if (a(yVar2) != -1) {
            return yVar2;
        }
        if (yVar2.e() != null) {
            return yVar2;
        }
        k c9 = c(yVar);
        if (c9 == null && (c9 = c(yVar2)) == null) {
            c9 = f(y.f11004b);
        }
        w8.h hVar = new w8.h();
        hVar.y(yVar.f11005a);
        if (hVar.f10961b > 0) {
            hVar.y(c9);
        }
        hVar.y(yVar2.f11005a);
        return d(hVar, z9);
    }

    public static final k c(y yVar) {
        k kVar = yVar.f11005a;
        k kVar2 = f11547a;
        if (k.i(kVar, kVar2) != -1) {
            return kVar2;
        }
        k kVar3 = yVar.f11005a;
        k kVar4 = f11548b;
        if (k.i(kVar3, kVar4) != -1) {
            return kVar4;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011c A[EDGE_INSN: B:72:0x011c->B:73:0x011c BREAK  A[LOOP:1: B:20:0x00ab->B:36:0x00ab], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final w8.y d(w8.h r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x8.c.d(w8.h, boolean):w8.y");
    }

    public static final k e(byte b7) {
        if (b7 == 47) {
            return f11547a;
        }
        if (b7 == 92) {
            return f11548b;
        }
        com.google.gson.internal.a.p(l.u(b7, "not a directory separator: "));
        return null;
    }

    public static final k f(String str) {
        if (kotlin.jvm.internal.l.a(str, "/")) {
            return f11547a;
        }
        if (kotlin.jvm.internal.l.a(str, "\\")) {
            return f11548b;
        }
        com.google.gson.internal.a.p(x.j("not a directory separator: ", str));
        return null;
    }
}
