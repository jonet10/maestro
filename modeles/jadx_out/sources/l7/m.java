package l7;

import a4.x;
import c4.d4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class m extends u {
    public static int A0(String str, CharSequence charSequence, int i) {
        int u02 = (i & 2) != 0 ? u0(charSequence) : 0;
        charSequence.getClass();
        str.getClass();
        return !(charSequence instanceof String) ? w0(charSequence, str, u02, 0, false, true) : ((String) charSequence).lastIndexOf(str, u02);
    }

    public static List B0(String str) {
        g gVar = new g(str);
        if (!gVar.hasNext()) {
            return q6.t.f8724a;
        }
        Object next = gVar.next();
        if (!gVar.hasNext()) {
            return a.a.H(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (gVar.hasNext()) {
            arrayList.add(gVar.next());
        }
        return arrayList;
    }

    public static String C0(int i, String str) {
        CharSequence charSequence;
        str.getClass();
        if (i < 0) {
            com.google.gson.internal.a.p(x.g(i, "Desired length ", " is less than zero."));
            return null;
        }
        if (i <= str.length()) {
            charSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            sb.append((CharSequence) str);
            int length = i - str.length();
            int i6 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append('0');
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                }
            }
            charSequence = sb;
        }
        return charSequence.toString();
    }

    public static String D0(int i, String str) {
        CharSequence charSequence;
        str.getClass();
        if (i < 0) {
            com.google.gson.internal.a.p(x.g(i, "Desired length ", " is less than zero."));
            return null;
        }
        if (i <= str.length()) {
            charSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            int length = i - str.length();
            int i6 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append('0');
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                }
            }
            sb.append((CharSequence) str);
            charSequence = sb;
        }
        return charSequence.toString();
    }

    public static final boolean E0(CharSequence charSequence, int i, CharSequence charSequence2, int i6, int i10, boolean z9) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i6 < 0 || i < 0 || i > charSequence.length() - i10 || i6 > charSequence2.length() - i10) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (!d0.b.D(charSequence.charAt(i + i11), charSequence2.charAt(i6 + i11), z9)) {
                return false;
            }
        }
        return true;
    }

    public static final List F0(String str, CharSequence charSequence) {
        int v02 = v0(charSequence, str, 0, false);
        if (v02 == -1) {
            return a.a.H(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        int i = 0;
        do {
            arrayList.add(charSequence.subSequence(i, v02).toString());
            i = str.length() + v02;
            v02 = v0(charSequence, str, i, false);
        } while (v02 != -1);
        arrayList.add(charSequence.subSequence(i, charSequence.length()).toString());
        return arrayList;
    }

    public static List G0(String str, String[] strArr) {
        str.getClass();
        if (strArr.length == 1) {
            String str2 = strArr[0];
            if (str2.length() != 0) {
                return F0(str2, str);
            }
        }
        List asList = Arrays.asList(strArr);
        asList.getClass();
        k7.k kVar = new k7.k(new k7.d(str, new d4(asList, 3)), 0);
        ArrayList arrayList = new ArrayList(q6.n.i0(kVar, 10));
        Iterator it = kVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList;
            }
            i7.d dVar = (i7.d) bVar.next();
            dVar.getClass();
            arrayList.add(str.subSequence(dVar.f5695a, dVar.f5696b + 1).toString());
        }
    }

    public static String H0(String str, String str2) {
        int y02 = y0(str, str2, 0, false, 6);
        return y02 == -1 ? str : str.substring(str2.length() + y02, str.length());
    }

    public static String I0(String str, char c9) {
        int x02 = x0(c9, 0, 6, str);
        return x02 == -1 ? str : str.substring(0, x02);
    }

    public static String J0(String str) {
        int length = str.length();
        if (127 <= length) {
            length = 127;
        }
        return str.substring(0, length);
    }

    public static CharSequence K0(CharSequence charSequence) {
        charSequence.getClass();
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z9 = false;
        while (i <= length) {
            boolean L = d0.b.L(charSequence.charAt(!z9 ? i : length));
            if (z9) {
                if (!L) {
                    break;
                }
                length--;
            } else if (L) {
                i++;
            } else {
                z9 = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static boolean q0(CharSequence charSequence, CharSequence charSequence2, boolean z9) {
        charSequence.getClass();
        charSequence2.getClass();
        if (charSequence2 instanceof String) {
            if (y0(charSequence, (String) charSequence2, 0, z9, 2) >= 0) {
                return true;
            }
        } else if (w0(charSequence, charSequence2, 0, charSequence.length(), z9, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean r0(String str, char c9) {
        str.getClass();
        return x0(c9, 0, 2, str) >= 0;
    }

    public static String t0(int i, String str) {
        str.getClass();
        if (i < 0) {
            s1.o.o(x.g(i, "Requested character count ", " is less than zero."));
            return null;
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        return str.substring(i);
    }

    public static int u0(CharSequence charSequence) {
        charSequence.getClass();
        return charSequence.length() - 1;
    }

    public static final int v0(CharSequence charSequence, String str, int i, boolean z9) {
        charSequence.getClass();
        str.getClass();
        return (z9 || !(charSequence instanceof String)) ? w0(charSequence, str, i, charSequence.length(), z9, false) : ((String) charSequence).indexOf(str, i);
    }

    public static final int w0(CharSequence charSequence, CharSequence charSequence2, int i, int i6, boolean z9, boolean z10) {
        i7.b bVar;
        CharSequence charSequence3 = charSequence2;
        int i10 = i;
        int i11 = i6;
        if (z10) {
            int u02 = u0(charSequence);
            if (i10 > u02) {
                i10 = u02;
            }
            if (i11 < 0) {
                i11 = 0;
            }
            bVar = new i7.b(i10, i11, -1);
        } else {
            if (i10 < 0) {
                i10 = 0;
            }
            int length = charSequence.length();
            if (i11 > length) {
                i11 = length;
            }
            bVar = new i7.d(i10, i11, 1);
        }
        boolean z11 = charSequence instanceof String;
        int i12 = bVar.f5697l;
        int i13 = bVar.f5696b;
        int i14 = bVar.f5695a;
        if (z11 && (charSequence3 instanceof String)) {
            if ((i12 > 0 && i14 <= i13) || (i12 < 0 && i13 <= i14)) {
                int i15 = i14;
                while (true) {
                    String str = (String) charSequence3;
                    String str2 = (String) charSequence;
                    int length2 = str.length();
                    if (!(!z9 ? str.regionMatches(0, str2, i15, length2) : str.regionMatches(z9, 0, str2, i15, length2))) {
                        if (i15 == i13) {
                            break;
                        }
                        i15 += i12;
                    } else {
                        return i15;
                    }
                }
            }
        } else if ((i12 > 0 && i14 <= i13) || (i12 < 0 && i13 <= i14)) {
            int i16 = i14;
            while (!E0(charSequence3, 0, charSequence, i16, charSequence3.length(), z9)) {
                if (i16 != i13) {
                    i16 += i12;
                    charSequence3 = charSequence2;
                }
            }
            return i16;
        }
        return -1;
    }

    public static int x0(char c9, int i, int i6, CharSequence charSequence) {
        char c10 = 0;
        if ((i6 & 2) != 0) {
            i = 0;
        }
        charSequence.getClass();
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(c9, i);
        }
        char[] cArr = {c9};
        if (charSequence instanceof String) {
            int length = cArr.length;
            if (length == 0) {
                androidx.privacysandbox.ads.adservices.customaudience.a.s("Array is empty.");
            } else if (length == 1) {
                c10 = cArr[0];
            } else {
                com.google.gson.internal.a.p("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(c10, i);
        }
        if (i < 0) {
            i = 0;
        }
        int length2 = charSequence.length() - 1;
        if (i > length2) {
            return -1;
        }
        while (!d0.b.D(cArr[0], charSequence.charAt(i), false)) {
            if (i == length2) {
                return -1;
            }
            i++;
        }
        return i;
    }

    public static /* synthetic */ int y0(CharSequence charSequence, String str, int i, boolean z9, int i6) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        if ((i6 & 4) != 0) {
            z9 = false;
        }
        return v0(charSequence, str, i, z9);
    }

    public static boolean z0(CharSequence charSequence) {
        charSequence.getClass();
        for (int i = 0; i < charSequence.length(); i++) {
            if (!d0.b.L(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
