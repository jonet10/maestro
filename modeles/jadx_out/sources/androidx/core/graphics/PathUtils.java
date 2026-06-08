package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PathUtils {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static float[] approximate(Path path, float f) {
            return path.approximate(f);
        }
    }

    private PathUtils() {
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path, @FloatRange(from = 0.0d) float f) {
        float[] approximate = Api26Impl.approximate(path, f);
        int length = approximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 1; i < length; i++) {
            int i6 = i * 3;
            int i10 = (i - 1) * 3;
            float f10 = approximate[i6];
            float f11 = approximate[i6 + 1];
            float f12 = approximate[i6 + 2];
            float f13 = approximate[i10];
            float f14 = approximate[i10 + 1];
            float f15 = approximate[i10 + 2];
            if (f10 != f13 && (f11 != f14 || f12 != f15)) {
                arrayList.add(new PathSegment(new PointF(f14, f15), f13, new PointF(f11, f12), f10));
            }
        }
        return arrayList;
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path) {
        return flatten(path, 0.5f);
    }
}
