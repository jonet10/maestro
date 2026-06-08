package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class s4 {
    protected int zza;

    public static void c(Iterable iterable, List list) {
        Charset charset = r5.f2778a;
        iterable.getClass();
        if (iterable instanceof v5) {
            List a8 = ((v5) iterable).a();
            v5 v5Var = (v5) list;
            int size = list.size();
            for (Object obj : a8) {
                if (obj == null) {
                    int size2 = v5Var.size() - size;
                    StringBuilder sb = new StringBuilder(String.valueOf(size2).length() + 26);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    int size3 = v5Var.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            com.google.gson.internal.a.i(sb2);
                            return;
                        }
                        v5Var.remove(size3);
                    }
                } else if (obj instanceof a5) {
                    v5Var.i();
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    a5.e(0, bArr.length, bArr);
                    v5Var.i();
                } else {
                    v5Var.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof i6) {
            list.addAll((Collection) iterable);
            return;
        }
        if (iterable instanceof Collection) {
            int size4 = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size4);
            } else if (list instanceof k6) {
                k6 k6Var = (k6) list;
                int i = k6Var.f2691l + size4;
                int length = k6Var.f2690b.length;
                if (i > length) {
                    if (length != 0) {
                        while (length < i) {
                            length = Math.max(((length * 3) / 2) + 1, 10);
                        }
                        k6Var.f2690b = Arrays.copyOf(k6Var.f2690b, length);
                    } else {
                        k6Var.f2690b = new Object[Math.max(i, 10)];
                    }
                }
            }
        }
        int size5 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj2 : iterable) {
                if (obj2 == null) {
                    k5.a(size5, list);
                    throw null;
                }
                list.add(obj2);
            }
            return;
        }
        List list2 = (List) iterable;
        int size6 = list2.size();
        for (int i6 = 0; i6 < size6; i6++) {
            Object obj3 = list2.get(i6);
            if (obj3 == null) {
                k5.a(size5, list);
                throw null;
            }
            list.add(obj3);
        }
    }

    public final byte[] a() {
        try {
            l5 l5Var = (l5) this;
            int j = l5Var.j();
            byte[] bArr = new byte[j];
            b5 b5Var = new b5(bArr, j);
            l5Var.d(b5Var);
            if (j - b5Var.f2515d == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e10) {
            String name = getClass().getName();
            androidx.privacysandbox.ads.adservices.customaudience.a.m(a4.x.o(new StringBuilder(name.length() + 72), "Serializing ", name, " to a byte array threw an IOException (should never happen)."), e10);
            return null;
        }
    }

    public abstract int b(m6 m6Var);
}
