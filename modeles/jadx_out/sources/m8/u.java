package m8;

import j$.util.DesugarCollections;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u {
    public static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public final String f7792a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7793b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7794c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7795d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7796e;
    public final List f;
    public final List g;
    public final String h;
    public final String i;

    public u(t tVar) {
        this.f7792a = tVar.f7787a;
        String str = tVar.f7788b;
        this.f7793b = h(str, 0, str.length(), false);
        String str2 = tVar.f7789c;
        this.f7794c = h(str2, 0, str2.length(), false);
        this.f7795d = tVar.f7790d;
        int i = tVar.f7791e;
        this.f7796e = i == -1 ? b(tVar.f7787a) : i;
        this.f = i(tVar.f, false);
        ArrayList arrayList = tVar.g;
        this.g = arrayList != null ? i(arrayList, true) : null;
        String str3 = tVar.h;
        this.h = str3 != null ? h(str3, 0, str3.length(), false) : null;
        this.i = tVar.toString();
    }

    public static String a(String str, int i, int i6, String str2, boolean z9, boolean z10, boolean z11, boolean z12) {
        int i10 = i;
        while (i10 < i6) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z12) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z9 || (z10 && !j(i10, i6, str)))) || (codePointAt == 43 && z11)))) {
                w8.h hVar = new w8.h();
                hVar.F(i, i10, str);
                w8.h hVar2 = null;
                while (i10 < i6) {
                    int codePointAt2 = str.codePointAt(i10);
                    if (!z9 || (codePointAt2 != 9 && codePointAt2 != 10 && codePointAt2 != 12 && codePointAt2 != 13)) {
                        if (codePointAt2 == 43 && z11) {
                            hVar.G(z9 ? "+" : "%2B");
                        } else if (codePointAt2 < 32 || codePointAt2 == 127 || ((codePointAt2 >= 128 && z12) || str2.indexOf(codePointAt2) != -1 || (codePointAt2 == 37 && (!z9 || (z10 && !j(i10, i6, str)))))) {
                            if (hVar2 == null) {
                                hVar2 = new w8.h();
                            }
                            hVar2.H(codePointAt2);
                            while (!hVar2.c()) {
                                byte readByte = hVar2.readByte();
                                hVar.A(37);
                                char[] cArr = j;
                                hVar.A(cArr[((readByte & 255) >> 4) & 15]);
                                hVar.A(cArr[readByte & 15]);
                            }
                        } else {
                            hVar.H(codePointAt2);
                        }
                    }
                    i10 += Character.charCount(codePointAt2);
                }
                return hVar.r(hVar.f10961b, l7.a.f7151a);
            }
            i10 += Character.charCount(codePointAt);
        }
        return str.substring(i, i6);
    }

    public static int b(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static void g(StringBuilder sb, List list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static String h(String str, int i, int i6, boolean z9) {
        int i10;
        int i11 = i;
        while (i11 < i6) {
            char charAt = str.charAt(i11);
            if (charAt == '%' || (charAt == '+' && z9)) {
                w8.h hVar = new w8.h();
                hVar.F(i, i11, str);
                while (i11 < i6) {
                    int codePointAt = str.codePointAt(i11);
                    if (codePointAt != 37 || (i10 = i11 + 2) >= i6) {
                        if (codePointAt == 43 && z9) {
                            hVar.A(32);
                        }
                        hVar.H(codePointAt);
                    } else {
                        int e10 = n8.c.e(str.charAt(i11 + 1));
                        int e11 = n8.c.e(str.charAt(i10));
                        if (e10 != -1 && e11 != -1) {
                            hVar.A((e10 << 4) + e11);
                            i11 = i10;
                        }
                        hVar.H(codePointAt);
                    }
                    i11 += Character.charCount(codePointAt);
                }
                return hVar.r(hVar.f10961b, l7.a.f7151a);
            }
            i11++;
        }
        return str.substring(i, i6);
    }

    public static List i(ArrayList arrayList, boolean z9) {
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            arrayList2.add(str != null ? h(str, 0, str.length(), z9) : null);
        }
        return DesugarCollections.unmodifiableList(arrayList2);
    }

    public static boolean j(int i, int i6, String str) {
        int i10 = i + 2;
        return i10 < i6 && str.charAt(i) == '%' && n8.c.e(str.charAt(i + 1)) != -1 && n8.c.e(str.charAt(i10)) != -1;
    }

    public static ArrayList k(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public final String c() {
        if (this.f7794c.isEmpty()) {
            return "";
        }
        int length = this.f7792a.length() + 3;
        String str = this.i;
        return str.substring(str.indexOf(58, length) + 1, str.indexOf(64));
    }

    public final ArrayList d() {
        int length = this.f7792a.length() + 3;
        String str = this.i;
        int indexOf = str.indexOf(47, length);
        int g = n8.c.g(indexOf, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < g) {
            int i = indexOf + 1;
            int h = n8.c.h(str, i, g, '/');
            arrayList.add(str.substring(i, h));
            indexOf = h;
        }
        return arrayList;
    }

    public final String e() {
        if (this.g == null) {
            return null;
        }
        String str = this.i;
        int indexOf = str.indexOf(63) + 1;
        return str.substring(indexOf, n8.c.h(str, indexOf, str.length(), '#'));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof u) && ((u) obj).i.equals(this.i);
    }

    public final String f() {
        if (this.f7793b.isEmpty()) {
            return "";
        }
        int length = this.f7792a.length() + 3;
        String str = this.i;
        return str.substring(length, n8.c.g(length, str.length(), str, ":@"));
    }

    public final int hashCode() {
        return this.i.hashCode();
    }

    public final URI l() {
        t tVar = new t();
        String str = this.f7792a;
        tVar.f7787a = str;
        tVar.f7788b = f();
        tVar.f7789c = c();
        tVar.f7790d = this.f7795d;
        int b7 = b(str);
        int i = this.f7796e;
        if (i == b7) {
            i = -1;
        }
        tVar.f7791e = i;
        ArrayList arrayList = tVar.f;
        arrayList.clear();
        arrayList.addAll(d());
        String e10 = e();
        String str2 = null;
        tVar.g = e10 != null ? k(a(e10, 0, e10.length(), " \"'<>#", true, false, true, true)) : null;
        if (this.h != null) {
            String str3 = this.i;
            str2 = str3.substring(str3.indexOf(35) + 1);
        }
        tVar.h = str2;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            String str4 = (String) arrayList.get(i6);
            arrayList.set(i6, a(str4, 0, str4.length(), "[]", true, true, false, true));
        }
        ArrayList arrayList2 = tVar.g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                String str5 = (String) tVar.g.get(i10);
                if (str5 != null) {
                    tVar.g.set(i10, a(str5, 0, str5.length(), "\\^`{|}", true, true, true, true));
                }
            }
        }
        String str6 = tVar.h;
        if (str6 != null) {
            tVar.h = a(str6, 0, str6.length(), " \"#<>\\^`{|}", true, true, false, false);
        }
        String tVar2 = tVar.toString();
        try {
            return new URI(tVar2);
        } catch (URISyntaxException e11) {
            try {
                return URI.create(tVar2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                com.google.gson.internal.a.k(e11);
                return null;
            }
        }
    }

    public final String toString() {
        return this.i;
    }
}
