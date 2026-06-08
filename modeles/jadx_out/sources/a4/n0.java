package a4;

import android.graphics.BitmapFactory;
import android.net.NetworkInfo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class n0 {
    public static void a(int i, int i6, int i10, int i11, BitmapFactory.Options options, k0 k0Var) {
        int min;
        double floor;
        if (i11 > i6 || i10 > i) {
            if (i6 == 0) {
                floor = Math.floor(i10 / i);
            } else if (i == 0) {
                floor = Math.floor(i11 / i6);
            } else {
                int floor2 = (int) Math.floor(i11 / i6);
                int floor3 = (int) Math.floor(i10 / i);
                k0Var.getClass();
                min = Math.min(floor2, floor3);
            }
            min = (int) floor;
        } else {
            min = 1;
        }
        options.inSampleSize = min;
        options.inJustDecodeBounds = false;
    }

    public static BitmapFactory.Options c(k0 k0Var) {
        boolean b7 = k0Var.b();
        if (!b7) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = b7;
        options.inInputShareable = false;
        options.inPurgeable = false;
        return options;
    }

    public abstract boolean b(k0 k0Var);

    public int d() {
        return 0;
    }

    public abstract m0 e(k0 k0Var, int i);

    public boolean f(NetworkInfo networkInfo) {
        return false;
    }
}
