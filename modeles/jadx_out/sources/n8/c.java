package n8;

import androidx.core.location.LocationRequestCompat;
import androidx.lifecycle.l;
import g4.z;
import j$.util.DesugarCollections;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import m8.d0;
import m8.u;
import s1.o;
import w8.g0;
import w8.h;
import w8.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f8114a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f8115b = new String[0];

    /* renamed from: c, reason: collision with root package name */
    public static final d0 f8116c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f8117d;

    /* renamed from: e, reason: collision with root package name */
    public static final TimeZone f8118e;
    public static final z f;
    public static final Pattern g;

    static {
        byte[] bArr = new byte[0];
        f8114a = bArr;
        h hVar = new h();
        hVar.write(bArr, 0, 0);
        long j = 0;
        f8116c = new d0(j, hVar, 0);
        if (j < 0 || j > j || 0 < j) {
            throw new ArrayIndexOutOfBoundsException();
        }
        k.d("efbbbf");
        k.d("feff");
        k.d("fffe");
        k.d("0000ffff");
        k.d("ffff0000");
        f8117d = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-32BE");
        Charset.forName("UTF-32LE");
        f8118e = DesugarTimeZone.getTimeZone("GMT");
        f = new z(9);
        g = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static AssertionError a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static String b(String str) {
        int i = -1;
        int i6 = 0;
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                while (i6 < lowerCase.length()) {
                    char charAt = lowerCase.charAt(i6);
                    if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                        return null;
                    }
                    i6++;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress f10 = (str.startsWith("[") && str.endsWith("]")) ? f(1, str.length() - 1, str) : f(0, str.length(), str);
        if (f10 == null) {
            return null;
        }
        byte[] address = f10.getAddress();
        if (address.length != 16) {
            o.j(l.w("Invalid IPv6 address: '", str, "'"));
            return null;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < address.length) {
            int i12 = i10;
            while (i12 < 16 && address[i12] == 0 && address[i12 + 1] == 0) {
                i12 += 2;
            }
            int i13 = i12 - i10;
            if (i13 > i11 && i13 >= 4) {
                i = i10;
                i11 = i13;
            }
            i10 = i12 + 2;
        }
        h hVar = new h();
        while (i6 < address.length) {
            if (i6 == i) {
                hVar.A(58);
                i6 += i11;
                if (i6 == 16) {
                    hVar.A(58);
                }
            } else {
                if (i6 > 0) {
                    hVar.A(58);
                }
                hVar.C(((address[i6] & 255) << 8) | (address[i6 + 1] & 255));
                i6 += 2;
            }
        }
        return hVar.r(hVar.f10961b, l7.a.f7151a);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static void d(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e10) {
                if (!n(e10)) {
                    throw e10;
                }
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static int e(char c9) {
        if (c9 >= '0' && c9 <= '9') {
            return c9 - '0';
        }
        if (c9 >= 'a' && c9 <= 'f') {
            return c9 - 'W';
        }
        if (c9 < 'A' || c9 > 'F') {
            return -1;
        }
        return c9 - '7';
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.net.InetAddress f(int r16, int r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n8.c.f(int, int, java.lang.String):java.net.InetAddress");
    }

    public static int g(int i, int i6, String str, String str2) {
        while (i < i6) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i6;
    }

    public static int h(String str, int i, int i6, char c9) {
        while (i < i6) {
            if (str.charAt(i) == c9) {
                return i;
            }
            i++;
        }
        return i6;
    }

    public static boolean i(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String j(u uVar, boolean z9) {
        String str = uVar.f7795d;
        int i = uVar.f7796e;
        boolean contains = str.contains(":");
        String str2 = uVar.f7795d;
        if (contains) {
            str2 = l.w("[", str2, "]");
        }
        if (!z9 && i == u.b(uVar.f7792a)) {
            return str2;
        }
        return str2 + ":" + i;
    }

    public static List k(List list) {
        return DesugarCollections.unmodifiableList(new ArrayList(list));
    }

    public static List l(Object... objArr) {
        return DesugarCollections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static String[] m(Comparator comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean n(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean o(Comparator comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean p(g0 g0Var, int i) {
        long nanoTime = System.nanoTime();
        long c9 = g0Var.a().e() ? g0Var.a().c() - nanoTime : Long.MAX_VALUE;
        g0Var.a().d(Math.min(c9, TimeUnit.MILLISECONDS.toNanos(i)) + nanoTime);
        try {
            h hVar = new h();
            while (g0Var.p(hVar, 8192L) != -1) {
                hVar.skip(hVar.f10961b);
            }
            if (c9 == LocationRequestCompat.PASSIVE_INTERVAL) {
                g0Var.a().a();
                return true;
            }
            g0Var.a().d(nanoTime + c9);
            return true;
        } catch (InterruptedIOException unused) {
            if (c9 == LocationRequestCompat.PASSIVE_INTERVAL) {
                g0Var.a().a();
                return false;
            }
            g0Var.a().d(nanoTime + c9);
            return false;
        } catch (Throwable th) {
            if (c9 == LocationRequestCompat.PASSIVE_INTERVAL) {
                g0Var.a().a();
            } else {
                g0Var.a().d(nanoTime + c9);
            }
            throw th;
        }
    }

    public static int q(int i, int i6, String str) {
        while (i < i6) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i6;
    }

    public static int r(int i, int i6, String str) {
        for (int i10 = i6 - 1; i10 >= i; i10--) {
            char charAt = str.charAt(i10);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i10 + 1;
            }
        }
        return i;
    }
}
