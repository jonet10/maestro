package a4;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.view.Window;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.util.Predicate;
import androidx.fragment.app.Fragment;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract /* synthetic */ class x {
    public static void A(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
    }

    public static void B(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static String C(String str, String str2) {
        return str + str2;
    }

    public static androidx.core.util.a a(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new androidx.core.util.a(predicate, predicate2, 1);
    }

    public static androidx.core.util.a b(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new androidx.core.util.a(predicate, predicate2, 0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int c(String str) {
        char c9;
        str.getClass();
        switch (str.hashCode()) {
            case -1310311125:
                if (str.equals("easing")) {
                    c9 = 0;
                    break;
                }
                c9 = 65535;
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c9 = 1;
                    break;
                }
                c9 = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c9 = 2;
                    break;
                }
                c9 = 65535;
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c9 = 3;
                    break;
                }
                c9 = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c9 = 4;
                    break;
                }
                c9 = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c9 = 5;
                    break;
                }
                c9 = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c9 = 6;
                    break;
                }
                c9 = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c9 = 7;
                    break;
                }
                c9 = 65535;
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c9 = '\b';
                    break;
                }
                c9 = 65535;
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c9 = '\t';
                    break;
                }
                c9 = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c9 = '\n';
                    break;
                }
                c9 = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c9 = 11;
                    break;
                }
                c9 = 65535;
                break;
            case -880905839:
                if (str.equals(TypedValues.AttributesType.S_TARGET)) {
                    c9 = '\f';
                    break;
                }
                c9 = 65535;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c9 = '\r';
                    break;
                }
                c9 = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c9 = 14;
                    break;
                }
                c9 = 65535;
                break;
            case 97692013:
                if (str.equals(TypedValues.AttributesType.S_FRAME)) {
                    c9 = 15;
                    break;
                }
                c9 = 65535;
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c9 = 16;
                    break;
                }
                c9 = 65535;
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
                    c9 = 17;
                    break;
                }
                c9 = 65535;
                break;
            case 1167159411:
                if (str.equals(TypedValues.AttributesType.S_PIVOT_TARGET)) {
                    c9 = 18;
                    break;
                }
                c9 = 65535;
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c9 = 19;
                    break;
                }
                c9 = 65535;
                break;
            default:
                c9 = 65535;
                break;
        }
        switch (c9) {
            case 0:
                return TypedValues.AttributesType.TYPE_EASING;
            case 1:
                return 308;
            case 2:
                return 309;
            case 3:
                return 310;
            case 4:
                return 304;
            case 5:
                return 305;
            case 6:
                return 306;
            case 7:
                return 315;
            case '\b':
                return 313;
            case '\t':
                return 314;
            case '\n':
                return 311;
            case 11:
                return 312;
            case '\f':
                return TypedValues.TYPE_TARGET;
            case '\r':
                return 307;
            case 14:
                return 303;
            case 15:
                return 100;
            case 16:
                return 301;
            case 17:
                return TypedValues.AttributesType.TYPE_PATH_ROTATE;
            case 18:
                return TypedValues.AttributesType.TYPE_PIVOT_TARGET;
            case 19:
                return 302;
            default:
                return -1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int d(String str) {
        char c9;
        str.getClass();
        switch (str.hashCode()) {
            case -1310311125:
                if (str.equals("easing")) {
                    c9 = 0;
                    break;
                }
                c9 = 65535;
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c9 = 1;
                    break;
                }
                c9 = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c9 = 2;
                    break;
                }
                c9 = 65535;
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c9 = 3;
                    break;
                }
                c9 = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c9 = 4;
                    break;
                }
                c9 = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c9 = 5;
                    break;
                }
                c9 = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c9 = 6;
                    break;
                }
                c9 = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c9 = 7;
                    break;
                }
                c9 = 65535;
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c9 = '\b';
                    break;
                }
                c9 = 65535;
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c9 = '\t';
                    break;
                }
                c9 = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c9 = '\n';
                    break;
                }
                c9 = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c9 = 11;
                    break;
                }
                c9 = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c9 = '\f';
                    break;
                }
                c9 = 65535;
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c9 = '\r';
                    break;
                }
                c9 = 65535;
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
                    c9 = 14;
                    break;
                }
                c9 = 65535;
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c9 = 15;
                    break;
                }
                c9 = 65535;
                break;
            default:
                c9 = 65535;
                break;
        }
        switch (c9) {
            case 0:
                return TypedValues.CycleType.TYPE_EASING;
            case 1:
                return 308;
            case 2:
                return 309;
            case 3:
                return 310;
            case 4:
                return 304;
            case 5:
                return 305;
            case 6:
                return 306;
            case 7:
                return 315;
            case '\b':
                return 313;
            case '\t':
                return 314;
            case '\n':
                return 311;
            case 11:
                return 312;
            case '\f':
                return TypedValues.CycleType.TYPE_ALPHA;
            case '\r':
                return TypedValues.CycleType.TYPE_CURVE_FIT;
            case 14:
                return TypedValues.CycleType.TYPE_PATH_ROTATE;
            case 15:
                return TypedValues.CycleType.TYPE_VISIBILITY;
            default:
                return -1;
        }
    }

    public static double e(double d10, double d11, double d12) {
        return (Math.sin(d10) * d11) + d12;
    }

    public static float f(float f, float f10, float f11, float f12) {
        return ((f - f10) * f11) + f12;
    }

    public static String g(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String h(long j, String str) {
        return str + j;
    }

    public static String i(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String j(String str, String str2) {
        return str + str2;
    }

    public static String k(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String l(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    public static String m(StringBuilder sb, String str, char c9) {
        sb.append(str);
        sb.append(c9);
        return sb.toString();
    }

    public static String n(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String o(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static StringBuilder p(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder q(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, d7.p pVar, CharSequence charSequence4) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        pVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence4);
        return sb;
    }

    public static StringBuilder r(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, d7.p pVar) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        pVar.getClass();
        return new StringBuilder();
    }

    public static StringBuilder s(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence5);
        return sb;
    }

    public static StringBuilder t(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder u(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder v(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static ArrayList w(Object obj) {
        p6.a.e(obj);
        return new ArrayList();
    }

    public static void x(int i, int i6, d7.l lVar) {
        lVar.invoke(Integer.valueOf(i + i6));
    }

    public static void y(Window window, int i) {
        window.setBackgroundDrawable(new ColorDrawable(i));
    }

    public static /* synthetic */ void z(AutoCloseable autoCloseable) {
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (autoCloseable instanceof ExecutorService) {
            androidx.core.provider.b.d((ExecutorService) autoCloseable);
            return;
        }
        if (autoCloseable instanceof TypedArray) {
            ((TypedArray) autoCloseable).recycle();
            return;
        }
        if (autoCloseable instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) autoCloseable).release();
            return;
        }
        if (autoCloseable instanceof MediaDrm) {
            ((MediaDrm) autoCloseable).release();
            return;
        }
        if (autoCloseable instanceof DrmManagerClient) {
            ((DrmManagerClient) autoCloseable).release();
        } else if (autoCloseable instanceof ContentProviderClient) {
            ((ContentProviderClient) autoCloseable).release();
        } else {
            s1.o.n();
        }
    }
}
