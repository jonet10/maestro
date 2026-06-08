package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class n6 {

    /* renamed from: a, reason: collision with root package name */
    public static final j5 f2726a;

    static {
        j6 j6Var = j6.f2671c;
        f2726a = new j5(6);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void b(Object obj, Object obj2) {
        l5 l5Var = (l5) obj;
        r6 r6Var = l5Var.zzc;
        r6 r6Var2 = ((l5) obj2).zzc;
        r6 r6Var3 = r6.f;
        if (!r6Var3.equals(r6Var2)) {
            if (r6Var3.equals(r6Var)) {
                int i = r6Var.f2780a + r6Var2.f2780a;
                int[] copyOf = Arrays.copyOf(r6Var.f2781b, i);
                System.arraycopy(r6Var2.f2781b, 0, copyOf, r6Var.f2780a, r6Var2.f2780a);
                Object[] copyOf2 = Arrays.copyOf(r6Var.f2782c, i);
                System.arraycopy(r6Var2.f2782c, 0, copyOf2, r6Var.f2780a, r6Var2.f2780a);
                r6Var = new r6(i, copyOf, copyOf2, true);
            } else {
                r6Var.getClass();
                if (!r6Var2.equals(r6Var3)) {
                    if (!r6Var.f2784e) {
                        com.google.gson.internal.a.q();
                        return;
                    }
                    int i6 = r6Var.f2780a + r6Var2.f2780a;
                    r6Var.e(i6);
                    System.arraycopy(r6Var2.f2781b, 0, r6Var.f2781b, r6Var.f2780a, r6Var2.f2780a);
                    System.arraycopy(r6Var2.f2782c, 0, r6Var.f2782c, r6Var.f2780a, r6Var2.f2780a);
                    r6Var.f2780a = i6;
                }
            }
        }
        l5Var.zzc = r6Var;
    }

    public static void c(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        if (list instanceof c5) {
            com.google.gson.internal.a.o();
            return;
        }
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                b5Var.h(i, Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Double) list.get(i11)).getClass();
            i10 += 8;
        }
        b5Var.m(i10);
        while (i6 < list.size()) {
            b5Var.p(Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
            i6++;
        }
    }

    public static void d(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        if (list instanceof h5) {
            com.google.gson.internal.a.o();
            return;
        }
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                b5Var.f(i, Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Float) list.get(i11)).getClass();
            i10 += 4;
        }
        b5Var.m(i10);
        while (i6 < list.size()) {
            b5Var.n(Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
            i6++;
        }
    }

    public static void e(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        int i6 = 0;
        if (!(list instanceof y5)) {
            if (!z9) {
                while (i6 < list.size()) {
                    b5Var.g(i, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            b5Var.c(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += b5.a(((Long) list.get(i11)).longValue());
            }
            b5Var.m(i10);
            while (i6 < list.size()) {
                b5Var.o(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        y5 y5Var = (y5) list;
        if (!z9) {
            while (i6 < y5Var.f2918l) {
                b5Var.g(i, y5Var.c(i6));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < y5Var.f2918l; i13++) {
            i12 += b5.a(y5Var.c(i13));
        }
        b5Var.m(i12);
        while (i6 < y5Var.f2918l) {
            b5Var.o(y5Var.c(i6));
            i6++;
        }
    }

    public static void f(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        int i6 = 0;
        if (!(list instanceof y5)) {
            if (!z9) {
                while (i6 < list.size()) {
                    b5Var.g(i, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            b5Var.c(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += b5.a(((Long) list.get(i11)).longValue());
            }
            b5Var.m(i10);
            while (i6 < list.size()) {
                b5Var.o(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        y5 y5Var = (y5) list;
        if (!z9) {
            while (i6 < y5Var.f2918l) {
                b5Var.g(i, y5Var.c(i6));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < y5Var.f2918l; i13++) {
            i12 += b5.a(y5Var.c(i13));
        }
        b5Var.m(i12);
        while (i6 < y5Var.f2918l) {
            b5Var.o(y5Var.c(i6));
            i6++;
        }
    }

    public static void g(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        int i6 = 0;
        if (!(list instanceof y5)) {
            if (!z9) {
                while (i6 < list.size()) {
                    long longValue = ((Long) list.get(i6)).longValue();
                    b5Var.g(i, (longValue >> 63) ^ (longValue + longValue));
                    i6++;
                }
                return;
            }
            b5Var.c(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                long longValue2 = ((Long) list.get(i11)).longValue();
                i10 += b5.a((longValue2 >> 63) ^ (longValue2 + longValue2));
            }
            b5Var.m(i10);
            while (i6 < list.size()) {
                long longValue3 = ((Long) list.get(i6)).longValue();
                b5Var.o((longValue3 >> 63) ^ (longValue3 + longValue3));
                i6++;
            }
            return;
        }
        y5 y5Var = (y5) list;
        if (!z9) {
            while (i6 < y5Var.f2918l) {
                long c9 = y5Var.c(i6);
                b5Var.g(i, (c9 >> 63) ^ (c9 + c9));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < y5Var.f2918l; i13++) {
            long c10 = y5Var.c(i13);
            i12 += b5.a((c10 >> 63) ^ (c10 + c10));
        }
        b5Var.m(i12);
        while (i6 < y5Var.f2918l) {
            long c11 = y5Var.c(i6);
            b5Var.o((c11 >> 63) ^ (c11 + c11));
            i6++;
        }
    }

    public static void h(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        int i6 = 0;
        if (!(list instanceof y5)) {
            if (!z9) {
                while (i6 < list.size()) {
                    b5Var.h(i, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            b5Var.c(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Long) list.get(i11)).getClass();
                i10 += 8;
            }
            b5Var.m(i10);
            while (i6 < list.size()) {
                b5Var.p(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        y5 y5Var = (y5) list;
        if (!z9) {
            while (i6 < y5Var.f2918l) {
                b5Var.h(i, y5Var.c(i6));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < y5Var.f2918l; i13++) {
            y5Var.c(i13);
            i12 += 8;
        }
        b5Var.m(i12);
        while (i6 < y5Var.f2918l) {
            b5Var.p(y5Var.c(i6));
            i6++;
        }
    }

    public static void i(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        int i6 = 0;
        if (!(list instanceof y5)) {
            if (!z9) {
                while (i6 < list.size()) {
                    b5Var.h(i, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            b5Var.c(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Long) list.get(i11)).getClass();
                i10 += 8;
            }
            b5Var.m(i10);
            while (i6 < list.size()) {
                b5Var.p(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        y5 y5Var = (y5) list;
        if (!z9) {
            while (i6 < y5Var.f2918l) {
                b5Var.h(i, y5Var.c(i6));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < y5Var.f2918l; i13++) {
            y5Var.c(i13);
            i12 += 8;
        }
        b5Var.m(i12);
        while (i6 < y5Var.f2918l) {
            b5Var.p(y5Var.c(i6));
            i6++;
        }
    }

    public static void j(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        int i6 = 0;
        if (!(list instanceof m5)) {
            if (!z9) {
                while (i6 < list.size()) {
                    b5Var.d(i, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            b5Var.c(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += b5.a(((Integer) list.get(i11)).intValue());
            }
            b5Var.m(i10);
            while (i6 < list.size()) {
                b5Var.l(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        m5 m5Var = (m5) list;
        if (!z9) {
            while (i6 < m5Var.f2713l) {
                b5Var.d(i, m5Var.d(i6));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < m5Var.f2713l; i13++) {
            i12 += b5.a(m5Var.d(i13));
        }
        b5Var.m(i12);
        while (i6 < m5Var.f2713l) {
            b5Var.l(m5Var.d(i6));
            i6++;
        }
    }

    public static void k(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        int i6 = 0;
        if (!(list instanceof m5)) {
            if (!z9) {
                while (i6 < list.size()) {
                    b5Var.e(i, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            b5Var.c(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += b5.s(((Integer) list.get(i11)).intValue());
            }
            b5Var.m(i10);
            while (i6 < list.size()) {
                b5Var.m(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        m5 m5Var = (m5) list;
        if (!z9) {
            while (i6 < m5Var.f2713l) {
                b5Var.e(i, m5Var.d(i6));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < m5Var.f2713l; i13++) {
            i12 += b5.s(m5Var.d(i13));
        }
        b5Var.m(i12);
        while (i6 < m5Var.f2713l) {
            b5Var.m(m5Var.d(i6));
            i6++;
        }
    }

    public static void l(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        int i6 = 0;
        if (!(list instanceof m5)) {
            if (!z9) {
                while (i6 < list.size()) {
                    int intValue = ((Integer) list.get(i6)).intValue();
                    b5Var.e(i, (intValue >> 31) ^ (intValue + intValue));
                    i6++;
                }
                return;
            }
            b5Var.c(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                int intValue2 = ((Integer) list.get(i11)).intValue();
                i10 += b5.s((intValue2 >> 31) ^ (intValue2 + intValue2));
            }
            b5Var.m(i10);
            while (i6 < list.size()) {
                int intValue3 = ((Integer) list.get(i6)).intValue();
                b5Var.m((intValue3 >> 31) ^ (intValue3 + intValue3));
                i6++;
            }
            return;
        }
        m5 m5Var = (m5) list;
        if (!z9) {
            while (i6 < m5Var.f2713l) {
                int d10 = m5Var.d(i6);
                b5Var.e(i, (d10 >> 31) ^ (d10 + d10));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < m5Var.f2713l; i13++) {
            int d11 = m5Var.d(i13);
            i12 += b5.s((d11 >> 31) ^ (d11 + d11));
        }
        b5Var.m(i12);
        while (i6 < m5Var.f2713l) {
            int d12 = m5Var.d(i6);
            b5Var.m((d12 >> 31) ^ (d12 + d12));
            i6++;
        }
    }

    public static void m(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        int i6 = 0;
        if (!(list instanceof m5)) {
            if (!z9) {
                while (i6 < list.size()) {
                    b5Var.f(i, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            b5Var.c(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Integer) list.get(i11)).getClass();
                i10 += 4;
            }
            b5Var.m(i10);
            while (i6 < list.size()) {
                b5Var.n(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        m5 m5Var = (m5) list;
        if (!z9) {
            while (i6 < m5Var.f2713l) {
                b5Var.f(i, m5Var.d(i6));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < m5Var.f2713l; i13++) {
            m5Var.d(i13);
            i12 += 4;
        }
        b5Var.m(i12);
        while (i6 < m5Var.f2713l) {
            b5Var.n(m5Var.d(i6));
            i6++;
        }
    }

    public static void n(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        int i6 = 0;
        if (!(list instanceof m5)) {
            if (!z9) {
                while (i6 < list.size()) {
                    b5Var.f(i, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            b5Var.c(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Integer) list.get(i11)).getClass();
                i10 += 4;
            }
            b5Var.m(i10);
            while (i6 < list.size()) {
                b5Var.n(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        m5 m5Var = (m5) list;
        if (!z9) {
            while (i6 < m5Var.f2713l) {
                b5Var.f(i, m5Var.d(i6));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < m5Var.f2713l; i13++) {
            m5Var.d(i13);
            i12 += 4;
        }
        b5Var.m(i12);
        while (i6 < m5Var.f2713l) {
            b5Var.n(m5Var.d(i6));
            i6++;
        }
    }

    public static void o(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        int i6 = 0;
        if (!(list instanceof m5)) {
            if (!z9) {
                while (i6 < list.size()) {
                    b5Var.d(i, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            b5Var.c(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += b5.a(((Integer) list.get(i11)).intValue());
            }
            b5Var.m(i10);
            while (i6 < list.size()) {
                b5Var.l(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        m5 m5Var = (m5) list;
        if (!z9) {
            while (i6 < m5Var.f2713l) {
                b5Var.d(i, m5Var.d(i6));
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < m5Var.f2713l; i13++) {
            i12 += b5.a(m5Var.d(i13));
        }
        b5Var.m(i12);
        while (i6 < m5Var.f2713l) {
            b5Var.l(m5Var.d(i6));
            i6++;
        }
    }

    public static void p(int i, List list, z5 z5Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) z5Var.f2934a;
        if (list instanceof w4) {
            com.google.gson.internal.a.o();
            return;
        }
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                boolean booleanValue = ((Boolean) list.get(i6)).booleanValue();
                b5Var.m(i << 3);
                b5Var.k(booleanValue ? (byte) 1 : (byte) 0);
                i6++;
            }
            return;
        }
        b5Var.c(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Boolean) list.get(i11)).getClass();
            i10++;
        }
        b5Var.m(i10);
        while (i6 < list.size()) {
            b5Var.k(((Boolean) list.get(i6)).booleanValue() ? (byte) 1 : (byte) 0);
            i6++;
        }
    }

    public static int q(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof y5)) {
            int i6 = 0;
            while (i < size) {
                i6 += b5.a(((Long) list.get(i)).longValue());
                i++;
            }
            return i6;
        }
        y5 y5Var = (y5) list;
        int i10 = 0;
        while (i < size) {
            i10 += b5.a(y5Var.c(i));
            i++;
        }
        return i10;
    }

    public static int r(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof y5)) {
            int i6 = 0;
            while (i < size) {
                i6 += b5.a(((Long) list.get(i)).longValue());
                i++;
            }
            return i6;
        }
        y5 y5Var = (y5) list;
        int i10 = 0;
        while (i < size) {
            i10 += b5.a(y5Var.c(i));
            i++;
        }
        return i10;
    }

    public static int s(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof y5)) {
            int i6 = 0;
            while (i < size) {
                long longValue = ((Long) list.get(i)).longValue();
                i6 += b5.a((longValue >> 63) ^ (longValue + longValue));
                i++;
            }
            return i6;
        }
        y5 y5Var = (y5) list;
        int i10 = 0;
        while (i < size) {
            long c9 = y5Var.c(i);
            i10 += b5.a((c9 >> 63) ^ (c9 + c9));
            i++;
        }
        return i10;
    }

    public static int t(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof m5)) {
            int i6 = 0;
            while (i < size) {
                i6 += b5.a(((Integer) list.get(i)).intValue());
                i++;
            }
            return i6;
        }
        m5 m5Var = (m5) list;
        int i10 = 0;
        while (i < size) {
            i10 += b5.a(m5Var.d(i));
            i++;
        }
        return i10;
    }

    public static int u(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof m5)) {
            int i6 = 0;
            while (i < size) {
                i6 += b5.a(((Integer) list.get(i)).intValue());
                i++;
            }
            return i6;
        }
        m5 m5Var = (m5) list;
        int i10 = 0;
        while (i < size) {
            i10 += b5.a(m5Var.d(i));
            i++;
        }
        return i10;
    }

    public static int v(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof m5)) {
            int i6 = 0;
            while (i < size) {
                i6 += b5.s(((Integer) list.get(i)).intValue());
                i++;
            }
            return i6;
        }
        m5 m5Var = (m5) list;
        int i10 = 0;
        while (i < size) {
            i10 += b5.s(m5Var.d(i));
            i++;
        }
        return i10;
    }

    public static int w(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof m5)) {
            int i6 = 0;
            while (i < size) {
                int intValue = ((Integer) list.get(i)).intValue();
                i6 += b5.s((intValue >> 31) ^ (intValue + intValue));
                i++;
            }
            return i6;
        }
        m5 m5Var = (m5) list;
        int i10 = 0;
        while (i < size) {
            int d10 = m5Var.d(i);
            i10 += b5.s((d10 >> 31) ^ (d10 + d10));
            i++;
        }
        return i10;
    }

    public static int x(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b5.s(i << 3) + 4) * size;
    }

    public static int y(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b5.s(i << 3) + 8) * size;
    }
}
