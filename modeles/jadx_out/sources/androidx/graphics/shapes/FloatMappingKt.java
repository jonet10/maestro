package androidx.graphics.shapes;

import androidx.collection.FloatList;
import java.util.Collection;
import java.util.Iterator;
import q6.m;
import q6.x;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FloatMappingKt {
    public static final float linearMap(FloatList floatList, FloatList floatList2, float f) {
        floatList.getClass();
        floatList2.getClass();
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException(("Invalid progress: " + f).toString());
        }
        Iterator it = f.K(0, floatList._size).iterator();
        while (it.hasNext()) {
            int nextInt = ((x) it).nextInt();
            int i = nextInt + 1;
            if (progressInRange(f, floatList.get(nextInt), floatList.get(i % floatList.getSize()))) {
                int size = i % floatList.getSize();
                float positiveModulo = Utils.positiveModulo(floatList.get(size) - floatList.get(nextInt), 1.0f);
                return Utils.positiveModulo((Utils.positiveModulo(floatList2.get(size) - floatList2.get(nextInt), 1.0f) * (positiveModulo < 0.001f ? 0.5f : Utils.positiveModulo(f - floatList.get(nextInt), 1.0f) / positiveModulo)) + floatList2.get(nextInt), 1.0f);
            }
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("Collection contains no element matching the predicate.");
        return 0.0f;
    }

    public static final boolean progressInRange(float f, float f10, float f11) {
        return f11 >= f10 ? f10 <= f && f <= f11 : f >= f10 || f <= f11;
    }

    public static final void validateProgress(FloatList floatList) {
        int i;
        floatList.getClass();
        Boolean bool = Boolean.TRUE;
        float[] fArr = floatList.content;
        int i6 = floatList._size;
        int i10 = 0;
        while (true) {
            boolean z9 = true;
            if (i10 >= i6) {
                break;
            }
            float f = fArr[i10];
            if (!bool.booleanValue() || 0.0f > f || f > 1.0f) {
                z9 = false;
            }
            bool = Boolean.valueOf(z9);
            i10++;
        }
        if (!bool.booleanValue()) {
            androidx.core.content.pm.a.i(FloatList.joinToString$default(floatList, null, null, null, 0, null, 31, null), "FloatMapping - Progress outside of range: ");
            return;
        }
        Iterable K = f.K(1, floatList.getSize());
        if ((K instanceof Collection) && ((Collection) K).isEmpty()) {
            i = 0;
        } else {
            Iterator it = K.iterator();
            i = 0;
            while (it.hasNext()) {
                int nextInt = ((x) it).nextInt();
                if (floatList.get(nextInt) < floatList.get(nextInt - 1) && (i = i + 1) < 0) {
                    m.g0();
                    throw null;
                }
            }
        }
        if (i <= 1) {
            return;
        }
        androidx.core.content.pm.a.i(FloatList.joinToString$default(floatList, null, null, null, 0, null, 31, null), "FloatMapping - Progress wraps more than once: ");
    }
}
