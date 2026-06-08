package c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract /* synthetic */ class j {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1165a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93};

    public static /* synthetic */ boolean a(int i, int i6) {
        if (i != 0) {
            return i == i6;
        }
        throw null;
    }

    public static View b(ViewGroup viewGroup, int i, ViewGroup viewGroup2, boolean z9) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup2, z9);
    }

    public static /* synthetic */ int c(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ String d(int i) {
        switch (i) {
            case 1:
                return "IAB_VENDOR";
            case 2:
                return "NON_IAB_VENDOR";
            case 3:
                return "GOOGLE_VENDOR";
            case 4:
                return "PUBLISHER_VENDOR";
            case 5:
                return "PURPOSE";
            case 6:
                return "SPECIAL_PURPOSE";
            case 7:
                return "FEATURES";
            case 8:
                return "SPECIAL_FEATURE";
            case 9:
                return "GOOGLE_BASIC_CONSENT_PURPOSE";
            case 10:
                return "PURPOSE_PARTNER";
            case 11:
                return "MSPA_PURPOSE";
            case 12:
                return "MSPA_SENSITIVE_PURPOSE";
            default:
                return "null";
        }
    }

    public static /* synthetic */ int[] e(int i) {
        int[] iArr = new int[i];
        System.arraycopy(f1165a, 0, iArr, 0, i);
        return iArr;
    }
}
