package q6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class j extends t0.f {
    public static boolean T(int[] iArr, int i) {
        int length = iArr.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                i6 = -1;
                break;
            }
            if (i == iArr[i6]) {
                break;
            }
            i6++;
        }
        return i6 >= 0;
    }

    public static boolean U(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr.length == objArr2.length) {
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                Object obj2 = objArr2[i];
                if (obj != obj2) {
                    if (obj != null && obj2 != null) {
                        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                            if (!U((Object[]) obj, (Object[]) obj2)) {
                            }
                        } else if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                            if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                            }
                        } else if ((obj instanceof short[]) && (obj2 instanceof short[])) {
                            if (!Arrays.equals((short[]) obj, (short[]) obj2)) {
                            }
                        } else if ((obj instanceof int[]) && (obj2 instanceof int[])) {
                            if (!Arrays.equals((int[]) obj, (int[]) obj2)) {
                            }
                        } else if ((obj instanceof long[]) && (obj2 instanceof long[])) {
                            if (!Arrays.equals((long[]) obj, (long[]) obj2)) {
                            }
                        } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
                            if (!Arrays.equals((float[]) obj, (float[]) obj2)) {
                            }
                        } else if ((obj instanceof double[]) && (obj2 instanceof double[])) {
                            if (!Arrays.equals((double[]) obj, (double[]) obj2)) {
                            }
                        } else if ((obj instanceof char[]) && (obj2 instanceof char[])) {
                            if (!Arrays.equals((char[]) obj, (char[]) obj2)) {
                            }
                        } else if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
                            if (!Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                            }
                        } else if ((obj instanceof p6.p) && (obj2 instanceof p6.p)) {
                            if (!Arrays.equals(((p6.p) obj).f8455a, ((p6.p) obj2).f8455a)) {
                            }
                        } else if ((obj instanceof p6.w) && (obj2 instanceof p6.w)) {
                            if (!Arrays.equals(((p6.w) obj).f8462a, ((p6.w) obj2).f8462a)) {
                            }
                        } else if ((obj instanceof p6.r) && (obj2 instanceof p6.r)) {
                            if (!Arrays.equals(((p6.r) obj).f8457a, ((p6.r) obj2).f8457a)) {
                            }
                        } else if ((obj instanceof p6.t) && (obj2 instanceof p6.t)) {
                            if (!Arrays.equals(((p6.t) obj).f8459a, ((p6.t) obj2).f8459a)) {
                            }
                        } else if (!obj.equals(obj2)) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static final void V(Object[] objArr, StringBuilder sb, ArrayList arrayList) {
        if (arrayList.contains(objArr)) {
            sb.append("[...]");
            return;
        }
        arrayList.add(objArr);
        sb.append('[');
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            Object obj = objArr[i];
            if (obj == null) {
                sb.append("null");
            } else if (obj instanceof Object[]) {
                V((Object[]) obj, sb, arrayList);
            } else if (obj instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) obj);
                arrays.getClass();
                sb.append(arrays);
            } else if (obj instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) obj);
                arrays2.getClass();
                sb.append(arrays2);
            } else if (obj instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) obj);
                arrays3.getClass();
                sb.append(arrays3);
            } else if (obj instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) obj);
                arrays4.getClass();
                sb.append(arrays4);
            } else if (obj instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) obj);
                arrays5.getClass();
                sb.append(arrays5);
            } else if (obj instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) obj);
                arrays6.getClass();
                sb.append(arrays6);
            } else if (obj instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) obj);
                arrays7.getClass();
                sb.append(arrays7);
            } else if (obj instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) obj);
                arrays8.getClass();
                sb.append(arrays8);
            } else if (obj instanceof p6.p) {
                sb.append(l.x0(new p6.p(((p6.p) obj).f8455a), ", ", "[", "]", null, 56));
            } else if (obj instanceof p6.w) {
                sb.append(l.x0(new p6.w(((p6.w) obj).f8462a), ", ", "[", "]", null, 56));
            } else if (obj instanceof p6.r) {
                sb.append(l.x0(new p6.r(((p6.r) obj).f8457a), ", ", "[", "]", null, 56));
            } else if (obj instanceof p6.t) {
                sb.append(l.x0(new p6.t(((p6.t) obj).f8459a), ", ", "[", "]", null, 56));
            } else {
                sb.append(obj.toString());
            }
        }
        sb.append(']');
        arrayList.remove(arrayList.size() - 1);
    }

    public static void W(int i, int i6, int i10, Object[] objArr, Object[] objArr2) {
        objArr.getClass();
        objArr2.getClass();
        System.arraycopy(objArr, i6, objArr2, i, i10 - i6);
    }

    public static void X(int i, int i6, int[] iArr, int[] iArr2, int i10) {
        iArr.getClass();
        iArr2.getClass();
        System.arraycopy(iArr, i6, iArr2, i, i10 - i6);
    }

    public static void Y(byte[] bArr, int i, byte[] bArr2, int i6, int i10) {
        bArr.getClass();
        bArr2.getClass();
        System.arraycopy(bArr, i6, bArr2, i, i10 - i6);
    }

    public static void Z(float[] fArr, int i, float[] fArr2, int i6, int i10) {
        fArr.getClass();
        fArr2.getClass();
        System.arraycopy(fArr, i6, fArr2, i, i10 - i6);
    }

    public static void a0(long[] jArr, long[] jArr2, int i, int i6, int i10) {
        jArr.getClass();
        jArr2.getClass();
        System.arraycopy(jArr, i6, jArr2, i, i10 - i6);
    }

    public static /* synthetic */ void b0(int i, int i6, int[] iArr, int[] iArr2, int i10) {
        if ((i10 & 2) != 0) {
            i = 0;
        }
        if ((i10 & 8) != 0) {
            i6 = iArr.length;
        }
        X(i, 0, iArr, iArr2, i6);
    }

    public static /* synthetic */ void c0(Object[] objArr, Object[] objArr2, int i, int i6, int i10, int i11) {
        if ((i11 & 2) != 0) {
            i = 0;
        }
        if ((i11 & 4) != 0) {
            i6 = 0;
        }
        if ((i11 & 8) != 0) {
            i10 = objArr.length;
        }
        W(i, i6, i10, objArr, objArr2);
    }

    public static Object[] d0(Object[] objArr, int i, int i6) {
        objArr.getClass();
        t0.f.m(i6, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i, i6);
        copyOfRange.getClass();
        return copyOfRange;
    }

    public static void e0(Object obj, Object[] objArr, int i, int i6) {
        objArr.getClass();
        Arrays.fill(objArr, i, i6, obj);
    }

    public static void f0(long[] jArr) {
        int length = jArr.length;
        jArr.getClass();
        Arrays.fill(jArr, 0, length, -9187201950435737472L);
    }

    public static ArrayList h0(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static int i0(int[] iArr) {
        if (iArr.length != 0) {
            return iArr[0];
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("Array is empty.");
        return 0;
    }

    public static int j0(Object[] objArr, Object obj) {
        objArr.getClass();
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static String k0(byte[] bArr, String str, d7.l lVar, int i) {
        String str2 = (i & 2) != 0 ? "" : "[";
        String str3 = (i & 4) == 0 ? "]" : "";
        if ((i & 32) != 0) {
            lVar = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str2);
        int i6 = 0;
        for (byte b7 : bArr) {
            i6++;
            if (i6 > 1) {
                sb.append((CharSequence) str);
            }
            if (lVar != null) {
                sb.append((CharSequence) lVar.invoke(Byte.valueOf(b7)));
            } else {
                sb.append((CharSequence) String.valueOf((int) b7));
            }
        }
        sb.append((CharSequence) str3);
        return sb.toString();
    }

    public static List l0(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return t.f8724a;
        }
        if (length == 1) {
            return a.a.H(Integer.valueOf(iArr[0]));
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static List m0(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new h(objArr, false)) : a.a.H(objArr[0]) : t.f8724a;
    }

    public static Set n0(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        if (length == 0) {
            return v.f8726a;
        }
        if (length == 1) {
            Set singleton = Collections.singleton(objArr[0]);
            singleton.getClass();
            return singleton;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(a0.h0(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }
}
