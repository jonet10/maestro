package x8;

import d7.p;
import g4.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import l7.m;
import q6.a0;
import q6.l;
import w8.d0;
import w8.n;
import w8.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f11546a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int a(char c9) {
        if ('0' <= c9 && c9 < ':') {
            return c9 - '0';
        }
        if ('a' <= c9 && c9 < 'g') {
            return c9 - 'W';
        }
        if ('A' <= c9 && c9 < 'G') {
            return c9 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c9);
    }

    public static final LinkedHashMap b(ArrayList arrayList) {
        String str = y.f11004b;
        y j = q1.a.j("/", false);
        p6.i[] iVarArr = {new p6.i(j, new g(j))};
        LinkedHashMap linkedHashMap = new LinkedHashMap(a0.h0(1));
        a0.j0(linkedHashMap, iVarArr);
        for (g gVar : l.C0(arrayList, new z(15))) {
            if (((g) linkedHashMap.put(gVar.f11559a, gVar)) == null) {
                while (true) {
                    y yVar = gVar.f11559a;
                    y c9 = yVar.c();
                    if (c9 != null) {
                        g gVar2 = (g) linkedHashMap.get(c9);
                        if (gVar2 != null) {
                            gVar2.h.add(yVar);
                            break;
                        }
                        g gVar3 = new g(c9);
                        linkedHashMap.put(c9, gVar3);
                        gVar3.h.add(yVar);
                        gVar = gVar3;
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static final String c(int i) {
        d0.b.v(16);
        String num = Integer.toString(i, 16);
        num.getClass();
        return "0x".concat(num);
    }

    public static final g d(w8.a0 a0Var) {
        Long valueOf;
        int f = a0Var.f();
        if (f != 33639248) {
            throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(f));
        }
        a0Var.skip(4L);
        short i = a0Var.i();
        int i6 = i & 65535;
        if ((i & 1) != 0) {
            com.google.gson.internal.a.n("unsupported zip: general purpose bit flag=".concat(c(i6)));
            return null;
        }
        int i10 = a0Var.i() & 65535;
        short i11 = a0Var.i();
        int i12 = i11 & 65535;
        short i13 = a0Var.i();
        int i14 = i13 & 65535;
        if (i12 == -1) {
            valueOf = null;
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(14, 0);
            gregorianCalendar.set(((i14 >> 9) & 127) + 1980, ((i14 >> 5) & 15) - 1, i13 & 31, (i12 >> 11) & 31, (i12 >> 5) & 63, (i11 & 31) << 1);
            valueOf = Long.valueOf(gregorianCalendar.getTime().getTime());
        }
        a0Var.f();
        w wVar = new w();
        wVar.f7023a = a0Var.f() & 4294967295L;
        w wVar2 = new w();
        wVar2.f7023a = a0Var.f() & 4294967295L;
        int i15 = a0Var.i() & 65535;
        int i16 = a0Var.i() & 65535;
        int i17 = a0Var.i() & 65535;
        a0Var.skip(8L);
        w wVar3 = new w();
        wVar3.f7023a = a0Var.f() & 4294967295L;
        String j = a0Var.j(i15);
        if (m.r0(j, (char) 0)) {
            com.google.gson.internal.a.n("bad zip: filename contains 0x00");
            return null;
        }
        long j6 = wVar2.f7023a == 4294967295L ? 8 : 0L;
        if (wVar.f7023a == 4294967295L) {
            j6 += 8;
        }
        if (wVar3.f7023a == 4294967295L) {
            j6 += 8;
        }
        u uVar = new u();
        e(a0Var, i16, new h(uVar, j6, wVar2, a0Var, wVar, wVar3));
        if (j6 > 0 && !uVar.f7021a) {
            com.google.gson.internal.a.n("bad zip: zip64 extra required but absent");
            return null;
        }
        String j10 = a0Var.j(i17);
        String str = y.f11004b;
        return new g(q1.a.j("/", false).d(j), l7.u.k0(j, "/", false), j10, wVar.f7023a, wVar2.f7023a, i10, valueOf, wVar3.f7023a);
    }

    public static final void e(w8.a0 a0Var, int i, p pVar) {
        w8.h hVar = a0Var.f10934b;
        long j = i;
        while (j != 0) {
            if (j < 4) {
                com.google.gson.internal.a.n("bad zip: truncated header in extra field");
                return;
            }
            int i6 = a0Var.i() & 65535;
            long i10 = a0Var.i() & 65535;
            long j6 = j - 4;
            if (j6 < i10) {
                com.google.gson.internal.a.n("bad zip: truncated value in extra field");
                return;
            }
            a0Var.t(i10);
            long j10 = hVar.f10961b;
            pVar.invoke(Integer.valueOf(i6), Long.valueOf(i10));
            long j11 = (hVar.f10961b + i10) - j10;
            if (j11 < 0) {
                com.google.gson.internal.a.n(androidx.lifecycle.l.u(i6, "unsupported zip: too many bytes processed for "));
                return;
            } else {
                if (j11 > 0) {
                    hVar.skip(j11);
                }
                j = j6 - i10;
            }
        }
    }

    public static final n f(w8.a0 a0Var, n nVar) {
        x xVar = new x();
        xVar.f7024a = nVar != null ? nVar.f10984e : null;
        x xVar2 = new x();
        x xVar3 = new x();
        int f = a0Var.f();
        if (f != 67324752) {
            throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(f));
        }
        a0Var.skip(2L);
        short i = a0Var.i();
        int i6 = i & 65535;
        if ((i & 1) != 0) {
            com.google.gson.internal.a.n("unsupported zip: general purpose bit flag=".concat(c(i6)));
            return null;
        }
        a0Var.skip(18L);
        int i10 = a0Var.i() & 65535;
        a0Var.skip(a0Var.i() & 65535);
        if (nVar == null) {
            a0Var.skip(i10);
            return null;
        }
        e(a0Var, i10, new i(a0Var, xVar, xVar2, xVar3));
        return new n(nVar.f10980a, nVar.f10981b, nVar.f10982c, (Long) xVar3.f7024a, (Long) xVar.f7024a, (Long) xVar2.f7024a);
    }

    public static final int g(d0 d0Var, int i) {
        int i6;
        int[] iArr = d0Var.f10954o;
        int i10 = i + 1;
        int length = d0Var.f10953n.length;
        iArr.getClass();
        int i11 = length - 1;
        int i12 = 0;
        while (true) {
            if (i12 <= i11) {
                i6 = (i12 + i11) >>> 1;
                int i13 = iArr[i6];
                if (i13 >= i10) {
                    if (i13 <= i10) {
                        break;
                    }
                    i11 = i6 - 1;
                } else {
                    i12 = i6 + 1;
                }
            } else {
                i6 = (-i12) - 1;
                break;
            }
        }
        return i6 >= 0 ? i6 : ~i6;
    }
}
