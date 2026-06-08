package androidx.collection;

import a3.b;
import a4.x;
import d7.a;
import d7.l;
import d7.p;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class FloatFloatMap {
    public int _capacity;
    public int _size;
    public float[] keys;
    public long[] metadata;
    public float[] values;

    private FloatFloatMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = FloatSetKt.getEmptyFloatArray();
        this.values = FloatSetKt.getEmptyFloatArray();
    }

    public static /* synthetic */ String joinToString$default(FloatFloatMap floatFloatMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, p pVar, int i6, Object obj) {
        long[] jArr;
        long[] jArr2;
        int i10;
        if (obj != null) {
            b.r("Super calls with default arguments not supported in this target, function: joinToString");
            return null;
        }
        CharSequence charSequence5 = (i6 & 1) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = (i6 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence7 = (i6 & 4) == 0 ? charSequence3 : "";
        int i11 = (i6 & 8) != 0 ? -1 : i;
        CharSequence charSequence8 = (i6 & 16) != 0 ? "..." : charSequence4;
        StringBuilder r9 = x.r(charSequence5, charSequence6, charSequence7, charSequence8, pVar);
        r9.append(charSequence6);
        float[] fArr = floatFloatMap.keys;
        float[] fArr2 = floatFloatMap.values;
        long[] jArr3 = floatFloatMap.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i12 = 0;
            int i13 = 0;
            loop0: while (true) {
                long j = jArr3[i12];
                int i14 = i12;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i15 = 8;
                    int i16 = 8 - ((~(i14 - length)) >>> 31);
                    int i17 = 0;
                    while (i17 < i16) {
                        if ((j & 255) < 128) {
                            int i18 = (i14 << 3) + i17;
                            float f = fArr[i18];
                            float f10 = fArr2[i18];
                            if (i13 == i11) {
                                r9.append(charSequence8);
                                break loop0;
                            }
                            if (i13 != 0) {
                                r9.append(charSequence5);
                            }
                            i10 = i15;
                            Float valueOf = Float.valueOf(f);
                            jArr2 = jArr3;
                            r9.append((CharSequence) pVar.invoke(valueOf, Float.valueOf(f10)));
                            i13++;
                        } else {
                            jArr2 = jArr3;
                            i10 = i15;
                        }
                        j >>= i10;
                        i17++;
                        i15 = i10;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i16 != i15) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i14 == length) {
                    break;
                }
                i12 = i14 + 1;
                jArr3 = jArr;
            }
            return r9.toString();
        }
        r9.append(charSequence7);
        return r9.toString();
    }

    public final boolean all(p pVar) {
        pVar.getClass();
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        int i11 = (i << 3) + i10;
                        if (!((Boolean) pVar.invoke(Float.valueOf(fArr[i11]), Float.valueOf(fArr2[i11]))).booleanValue()) {
                            return false;
                        }
                    }
                    j >>= 8;
                }
                if (i6 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    public final boolean any(p pVar) {
        pVar.getClass();
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i6; i10++) {
                        if ((255 & j) < 128) {
                            int i11 = (i << 3) + i10;
                            if (((Boolean) pVar.invoke(Float.valueOf(fArr[i11]), Float.valueOf(fArr2[i11]))).booleanValue()) {
                                return true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    public final boolean contains(float f) {
        return findKeyIndex(f) >= 0;
    }

    public final boolean containsKey(float f) {
        return findKeyIndex(f) >= 0;
    }

    public final boolean containsValue(float f) {
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i6; i10++) {
                        if ((255 & j) < 128 && f == fArr[(i << 3) + i10]) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    public final int count(p pVar) {
        pVar.getClass();
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i6 = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j) < 128) {
                        int i12 = (i << 3) + i11;
                        if (((Boolean) pVar.invoke(Float.valueOf(fArr[i12]), Float.valueOf(fArr2[i12]))).booleanValue()) {
                            i6++;
                        }
                    }
                    j >>= 8;
                }
                if (i10 != 8) {
                    return i6;
                }
            }
            if (i == length) {
                return i6;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FloatFloatMap)) {
            return false;
        }
        FloatFloatMap floatFloatMap = (FloatFloatMap) obj;
        if (floatFloatMap.getSize() != getSize()) {
            return false;
        }
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i6; i10++) {
                        if ((255 & j) < 128) {
                            int i11 = (i << 3) + i10;
                            if (fArr2[i11] != floatFloatMap.get(fArr[i11])) {
                                return false;
                            }
                        }
                        j >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return true;
    }

    public final int findKeyIndex(float f) {
        int floatToIntBits = Float.floatToIntBits(f) * ScatterMapKt.MurmurHashC1;
        int i = floatToIntBits ^ (floatToIntBits << 16);
        int i6 = i & 127;
        int i10 = this._capacity;
        int i11 = (i >>> 7) & i10;
        int i12 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i13 = i11 >> 3;
            int i14 = (i11 & 7) << 3;
            long j = ((jArr[i13 + 1] << (64 - i14)) & ((-i14) >> 63)) | (jArr[i13] >>> i14);
            long j6 = (i6 * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j10 = (~j6) & (j6 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j10 != 0; j10 &= j10 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j10) >> 3) + i11) & i10;
                if (this.keys[numberOfTrailingZeros] == f) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i12 += 8;
            i11 = (i11 + i12) & i10;
        }
    }

    public final void forEach(p pVar) {
        pVar.getClass();
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        int i11 = (i << 3) + i10;
                        pVar.invoke(Float.valueOf(fArr[i11]), Float.valueOf(fArr2[i11]));
                    }
                    j >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void forEachIndexed(l lVar) {
        lVar.getClass();
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        x.x(i << 3, i10, lVar);
                    }
                    j >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void forEachKey(l lVar) {
        lVar.getClass();
        float[] fArr = this.keys;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        lVar.invoke(Float.valueOf(fArr[(i << 3) + i10]));
                    }
                    j >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void forEachValue(l lVar) {
        lVar.getClass();
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        lVar.invoke(Float.valueOf(fArr[(i << 3) + i10]));
                    }
                    j >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final float get(float f) {
        int findKeyIndex = findKeyIndex(f);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        throw new NoSuchElementException("Cannot find value for key " + f);
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final float getOrDefault(float f, float f10) {
        int findKeyIndex = findKeyIndex(f);
        return findKeyIndex >= 0 ? this.values[findKeyIndex] : f10;
    }

    public final float getOrElse(float f, a aVar) {
        aVar.getClass();
        int findKeyIndex = findKeyIndex(f);
        return findKeyIndex < 0 ? ((Number) aVar.invoke()).floatValue() : this.values[findKeyIndex];
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i6 = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j) < 128) {
                        int i12 = (i << 3) + i11;
                        float f = fArr[i12];
                        i6 += Float.floatToIntBits(fArr2[i12]) ^ Float.floatToIntBits(f);
                    }
                    j >>= 8;
                }
                if (i10 != 8) {
                    return i6;
                }
            }
            if (i == length) {
                return i6;
            }
            i++;
        }
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, p pVar) {
        int i;
        charSequence.getClass();
        charSequence2.getClass();
        pVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j = jArr[i6];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i6 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((255 & j) < 128) {
                            int i14 = (i6 << 3) + i13;
                            float f = fArr[i14];
                            float f10 = fArr2[i14];
                            if (i10 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                sb.append(charSequence);
                            }
                            i = i11;
                            sb.append((CharSequence) pVar.invoke(Float.valueOf(f), Float.valueOf(f10)));
                            i10++;
                        } else {
                            i = i11;
                        }
                        j >>= i;
                        i13++;
                        i11 = i;
                    }
                    if (i12 != i11) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
            return sb.toString();
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public final boolean none() {
        return this._size == 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i6 = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8 - ((~(i - length)) >>> 31);
                    for (int i11 = 0; i11 < i10; i11++) {
                        if ((255 & j) < 128) {
                            int i12 = (i << 3) + i11;
                            float f = fArr[i12];
                            float f10 = fArr2[i12];
                            sb.append(f);
                            sb.append("=");
                            sb.append(f10);
                            i6++;
                            if (i6 < this._size) {
                                sb.append(", ");
                            }
                        }
                        j >>= 8;
                    }
                    if (i10 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    public /* synthetic */ FloatFloatMap(g gVar) {
        this();
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final int count() {
        return getSize();
    }

    public final String joinToString(CharSequence charSequence) {
        charSequence.getClass();
        return joinToString$default(this, charSequence, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2) {
        charSequence.getClass();
        charSequence2.getClass();
        return joinToString$default(this, charSequence, charSequence2, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        x.A(charSequence, charSequence2, charSequence3);
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, null, 24, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i) {
        x.A(charSequence, charSequence2, charSequence3);
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, null, 16, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, p pVar) {
        int i6;
        CharSequence charSequence4 = charSequence;
        StringBuilder q9 = x.q(charSequence4, charSequence2, charSequence3, pVar, charSequence2);
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i10 = 0;
            int i11 = 0;
            loop0: while (true) {
                long j = jArr[i10];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8;
                    int i13 = 8 - ((~(i10 - length)) >>> 31);
                    int i14 = 0;
                    while (i14 < i13) {
                        if ((j & 255) < 128) {
                            int i15 = (i10 << 3) + i14;
                            float f = fArr[i15];
                            float f10 = fArr2[i15];
                            i6 = i12;
                            if (i11 == i) {
                                q9.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i11 != 0) {
                                q9.append(charSequence4);
                            }
                            q9.append((CharSequence) pVar.invoke(Float.valueOf(f), Float.valueOf(f10)));
                            i11++;
                        } else {
                            i6 = i12;
                        }
                        j >>= i6;
                        i14++;
                        charSequence4 = charSequence;
                        i12 = i6;
                    }
                    if (i13 != i12) {
                        break;
                    }
                }
                if (i10 == length) {
                    break;
                }
                i10++;
                charSequence4 = charSequence;
            }
            return q9.toString();
        }
        q9.append(charSequence3);
        return q9.toString();
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4) {
        float[] fArr;
        float[] fArr2;
        int i6;
        StringBuilder s6 = x.s(charSequence, charSequence2, charSequence3, charSequence4, charSequence2);
        float[] fArr3 = this.keys;
        float[] fArr4 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i10 = 0;
            int i11 = 0;
            loop0: while (true) {
                long j = jArr[i10];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8;
                    int i13 = 8 - ((~(i10 - length)) >>> 31);
                    int i14 = 0;
                    while (i14 < i13) {
                        if ((j & 255) < 128) {
                            int i15 = (i10 << 3) + i14;
                            i6 = i12;
                            float f = fArr3[i15];
                            float f10 = fArr4[i15];
                            fArr2 = fArr3;
                            if (i11 == i) {
                                s6.append(charSequence4);
                                break loop0;
                            }
                            if (i11 != 0) {
                                s6.append(charSequence);
                            }
                            s6.append(f);
                            s6.append('=');
                            s6.append(f10);
                            i11++;
                        } else {
                            fArr2 = fArr3;
                            i6 = i12;
                        }
                        j >>= i6;
                        i14++;
                        fArr3 = fArr2;
                        i12 = i6;
                    }
                    fArr = fArr3;
                    if (i13 != i12) {
                        break;
                    }
                } else {
                    fArr = fArr3;
                }
                if (i10 == length) {
                    break;
                }
                i10++;
                fArr3 = fArr;
            }
            return s6.toString();
        }
        s6.append(charSequence3);
        return s6.toString();
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, p pVar) {
        CharSequence charSequence5 = charSequence;
        StringBuilder r9 = x.r(charSequence5, charSequence2, charSequence3, charSequence4, pVar);
        r9.append(charSequence2);
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j = jArr[i6];
                int i11 = i6;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j & 255) < 128) {
                            int i14 = (i11 << 3) + i13;
                            float f = fArr[i14];
                            float f10 = fArr2[i14];
                            if (i10 == i) {
                                r9.append(charSequence4);
                                break loop0;
                            }
                            if (i10 != 0) {
                                r9.append(charSequence5);
                            }
                            r9.append((CharSequence) pVar.invoke(Float.valueOf(f), Float.valueOf(f10)));
                            i10++;
                        }
                        j >>= 8;
                        i13++;
                        charSequence5 = charSequence;
                    }
                    if (i12 != 8) {
                        break;
                    }
                }
                if (i11 == length) {
                    break;
                }
                i6 = i11 + 1;
                charSequence5 = charSequence;
            }
        }
        r9.append(charSequence3);
        return r9.toString();
    }

    public static /* synthetic */ String joinToString$default(FloatFloatMap floatFloatMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i6, Object obj) {
        if (obj != null) {
            b.r("Super calls with default arguments not supported in this target, function: joinToString");
            return null;
        }
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i6 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i6 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i6 & 8) != 0) {
            i = -1;
        }
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return floatFloatMap.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, p pVar) {
        int i;
        StringBuilder q9 = x.q(charSequence, charSequence2, charSequence3, pVar, charSequence2);
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j = jArr[i6];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i6 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j & 255) < 128) {
                            int i14 = (i6 << 3) + i13;
                            float f = fArr[i14];
                            float f10 = fArr2[i14];
                            i = i11;
                            if (i10 == -1) {
                                q9.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                q9.append(charSequence);
                            }
                            q9.append((CharSequence) pVar.invoke(Float.valueOf(f), Float.valueOf(f10)));
                            i10++;
                        } else {
                            i = i11;
                        }
                        j >>= i;
                        i13++;
                        i11 = i;
                    }
                    if (i12 != i11) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        q9.append(charSequence3);
        return q9.toString();
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence charSequence, p pVar) {
        int i;
        charSequence.getClass();
        pVar.getClass();
        StringBuilder sb = new StringBuilder("");
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j = jArr[i6];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i6 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((255 & j) < 128) {
                            int i14 = (i6 << 3) + i13;
                            float f = fArr[i14];
                            float f10 = fArr2[i14];
                            if (i10 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                sb.append(charSequence);
                            }
                            i = i11;
                            sb.append((CharSequence) pVar.invoke(Float.valueOf(f), Float.valueOf(f10)));
                            i10++;
                        } else {
                            i = i11;
                        }
                        j >>= i;
                        i13++;
                        i11 = i;
                    }
                    if (i12 != i11) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public final String joinToString(p pVar) {
        int i;
        pVar.getClass();
        StringBuilder sb = new StringBuilder("");
        float[] fArr = this.keys;
        float[] fArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j = jArr[i6];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i6 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((255 & j) < 128) {
                            int i14 = (i6 << 3) + i13;
                            float f = fArr[i14];
                            float f10 = fArr2[i14];
                            if (i10 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                sb.append((CharSequence) ", ");
                            }
                            i = i11;
                            sb.append((CharSequence) pVar.invoke(Float.valueOf(f), Float.valueOf(f10)));
                            i10++;
                        } else {
                            i = i11;
                        }
                        j >>= i;
                        i13++;
                        i11 = i;
                    }
                    if (i12 != i11) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }
}
