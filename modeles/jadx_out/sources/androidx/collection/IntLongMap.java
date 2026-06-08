package androidx.collection;

import a3.b;
import a4.x;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import d7.l;
import d7.p;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class IntLongMap {
    public int _capacity;
    public int _size;
    public int[] keys;
    public long[] metadata;
    public long[] values;

    private IntLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = IntSetKt.getEmptyIntArray();
        this.values = LongSetKt.getEmptyLongArray();
    }

    public static /* synthetic */ String joinToString$default(IntLongMap intLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, p pVar, int i6, Object obj) {
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
        int[] iArr = intLongMap.keys;
        long[] jArr3 = intLongMap.values;
        long[] jArr4 = intLongMap.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i12 = 0;
            int i13 = 0;
            loop0: while (true) {
                long j = jArr4[i12];
                int i14 = i12;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i15 = 8;
                    int i16 = 8 - ((~(i14 - length)) >>> 31);
                    int i17 = 0;
                    while (i17 < i16) {
                        if ((j & 255) < 128) {
                            int i18 = (i14 << 3) + i17;
                            int i19 = iArr[i18];
                            long j6 = jArr3[i18];
                            if (i13 == i11) {
                                r9.append(charSequence8);
                                break loop0;
                            }
                            if (i13 != 0) {
                                r9.append(charSequence5);
                            }
                            i10 = i15;
                            jArr2 = jArr4;
                            r9.append((CharSequence) pVar.invoke(Integer.valueOf(i19), Long.valueOf(j6)));
                            i13++;
                        } else {
                            jArr2 = jArr4;
                            i10 = i15;
                        }
                        j >>= i10;
                        i17++;
                        i15 = i10;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    if (i16 != i15) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                }
                if (i14 == length) {
                    break;
                }
                i12 = i14 + 1;
                jArr4 = jArr;
            }
            return r9.toString();
        }
        r9.append(charSequence7);
        return r9.toString();
    }

    public final boolean all(p pVar) {
        pVar.getClass();
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        int i11 = (i << 3) + i10;
                        if (!((Boolean) pVar.invoke(Integer.valueOf(iArr[i11]), Long.valueOf(jArr[i11]))).booleanValue()) {
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
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr2[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i6; i10++) {
                        if ((255 & j) < 128) {
                            int i11 = (i << 3) + i10;
                            if (((Boolean) pVar.invoke(Integer.valueOf(iArr[i11]), Long.valueOf(jArr[i11]))).booleanValue()) {
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

    public final boolean contains(int i) {
        return findKeyIndex(i) >= 0;
    }

    public final boolean containsKey(int i) {
        return findKeyIndex(i) >= 0;
    }

    public final boolean containsValue(long j) {
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j6 = jArr2[i];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i6; i10++) {
                        if ((255 & j6) < 128 && j == jArr[(i << 3) + i10]) {
                            return true;
                        }
                        j6 >>= 8;
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
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i6 = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j) < 128) {
                        int i12 = (i << 3) + i11;
                        if (((Boolean) pVar.invoke(Integer.valueOf(iArr[i12]), Long.valueOf(jArr[i12]))).booleanValue()) {
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
        if (!(obj instanceof IntLongMap)) {
            return false;
        }
        IntLongMap intLongMap = (IntLongMap) obj;
        if (intLongMap.getSize() != getSize()) {
            return false;
        }
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr2[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i6; i10++) {
                        if ((255 & j) < 128) {
                            int i11 = (i << 3) + i10;
                            if (jArr[i11] != intLongMap.get(iArr[i11])) {
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

    public final int findKeyIndex(int i) {
        int i6 = ScatterMapKt.MurmurHashC1 * i;
        int i10 = i6 ^ (i6 << 16);
        int i11 = i10 & 127;
        int i12 = this._capacity;
        int i13 = (i10 >>> 7) & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i15 = i13 >> 3;
            int i16 = (i13 & 7) << 3;
            long j = ((jArr[i15 + 1] << (64 - i16)) & ((-i16) >> 63)) | (jArr[i15] >>> i16);
            long j6 = (i11 * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j10 = (~j6) & (j6 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j10 != 0; j10 &= j10 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j10) >> 3) + i13) & i12;
                if (this.keys[numberOfTrailingZeros] == i) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i14 += 8;
            i13 = (i13 + i14) & i12;
        }
    }

    public final void forEach(p pVar) {
        pVar.getClass();
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        int i11 = (i << 3) + i10;
                        pVar.invoke(Integer.valueOf(iArr[i11]), Long.valueOf(jArr[i11]));
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
        int[] iArr = this.keys;
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
                        lVar.invoke(Integer.valueOf(iArr[(i << 3) + i10]));
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
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        lVar.invoke(Long.valueOf(jArr[(i << 3) + i10]));
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

    public final long get(int i) {
        int findKeyIndex = findKeyIndex(i);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        a.s(androidx.lifecycle.l.u(i, "Cannot find value for key "));
        return 0L;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final long getOrDefault(int i, long j) {
        int findKeyIndex = findKeyIndex(i);
        return findKeyIndex >= 0 ? this.values[findKeyIndex] : j;
    }

    public final long getOrElse(int i, d7.a aVar) {
        aVar.getClass();
        int findKeyIndex = findKeyIndex(i);
        return findKeyIndex < 0 ? ((Number) aVar.invoke()).longValue() : this.values[findKeyIndex];
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int i;
        int i6;
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            long j = jArr2[i10];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i10 - length)) >>> 31);
                int i13 = 0;
                while (i13 < i12) {
                    if ((255 & j) < 128) {
                        int i14 = (i10 << 3) + i13;
                        int i15 = iArr[i14];
                        long j6 = jArr[i14];
                        i6 = i10;
                        i11 += ((int) (j6 ^ (j6 >>> 32))) ^ i15;
                    } else {
                        i6 = i10;
                    }
                    j >>= 8;
                    i13++;
                    i10 = i6;
                }
                int i16 = i10;
                if (i12 != 8) {
                    return i11;
                }
                i = i16;
            } else {
                i = i10;
            }
            if (i == length) {
                return i11;
            }
            i10 = i + 1;
        }
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4) {
        int[] iArr;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        int i6;
        StringBuilder s6 = x.s(charSequence, charSequence2, charSequence3, charSequence4, charSequence2);
        int[] iArr3 = this.keys;
        long[] jArr3 = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i10 = 0;
            int i11 = 0;
            loop0: while (true) {
                long j = jArr4[i10];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8;
                    int i13 = 8 - ((~(i10 - length)) >>> 31);
                    int i14 = 0;
                    while (i14 < i13) {
                        if ((j & 255) < 128) {
                            int i15 = (i10 << 3) + i14;
                            i6 = i12;
                            int i16 = iArr3[i15];
                            iArr2 = iArr3;
                            jArr2 = jArr3;
                            long j6 = jArr2[i15];
                            if (i11 == i) {
                                s6.append(charSequence4);
                                break loop0;
                            }
                            if (i11 != 0) {
                                s6.append(charSequence);
                            }
                            s6.append(i16);
                            s6.append('=');
                            s6.append(j6);
                            i11++;
                        } else {
                            iArr2 = iArr3;
                            jArr2 = jArr3;
                            i6 = i12;
                        }
                        j >>= i6;
                        i14++;
                        i12 = i6;
                        iArr3 = iArr2;
                        jArr3 = jArr2;
                    }
                    iArr = iArr3;
                    jArr = jArr3;
                    if (i13 != i12) {
                        break;
                    }
                } else {
                    iArr = iArr3;
                    jArr = jArr3;
                }
                if (i10 == length) {
                    break;
                }
                i10++;
                iArr3 = iArr;
                jArr3 = jArr;
            }
            return s6.toString();
        }
        s6.append(charSequence3);
        return s6.toString();
    }

    public final boolean none() {
        return this._size == 0;
    }

    public String toString() {
        int i;
        int i6;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                long j = jArr2[i10];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i10 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((255 & j) < 128) {
                            int i14 = (i10 << 3) + i13;
                            int i15 = iArr[i14];
                            i6 = i10;
                            long j6 = jArr[i14];
                            sb.append(i15);
                            sb.append("=");
                            sb.append(j6);
                            i11++;
                            if (i11 < this._size) {
                                sb.append(", ");
                            }
                        } else {
                            i6 = i10;
                        }
                        j >>= 8;
                        i13++;
                        i10 = i6;
                    }
                    int i16 = i10;
                    if (i12 != 8) {
                        break;
                    }
                    i = i16;
                } else {
                    i = i10;
                }
                if (i == length) {
                    break;
                }
                i10 = i + 1;
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

    public /* synthetic */ IntLongMap(g gVar) {
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
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i10 = 0;
            int i11 = 0;
            loop0: while (true) {
                long j = jArr2[i10];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8;
                    int i13 = 8 - ((~(i10 - length)) >>> 31);
                    int i14 = 0;
                    while (i14 < i13) {
                        if ((j & 255) < 128) {
                            int i15 = (i10 << 3) + i14;
                            int i16 = iArr[i15];
                            long j6 = jArr[i15];
                            i6 = i12;
                            if (i11 == i) {
                                q9.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i11 != 0) {
                                q9.append(charSequence4);
                            }
                            q9.append((CharSequence) pVar.invoke(Integer.valueOf(i16), Long.valueOf(j6)));
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

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, p pVar) {
        CharSequence charSequence5 = charSequence;
        StringBuilder r9 = x.r(charSequence5, charSequence2, charSequence3, charSequence4, pVar);
        r9.append(charSequence2);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j = jArr2[i6];
                int i11 = i6;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j & 255) < 128) {
                            int i14 = (i11 << 3) + i13;
                            int i15 = iArr[i14];
                            long j6 = jArr[i14];
                            if (i10 == i) {
                                r9.append(charSequence4);
                                break loop0;
                            }
                            if (i10 != 0) {
                                r9.append(charSequence5);
                            }
                            r9.append((CharSequence) pVar.invoke(Integer.valueOf(i15), Long.valueOf(j6)));
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

    public static /* synthetic */ String joinToString$default(IntLongMap intLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i6, Object obj) {
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
        return intLongMap.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, p pVar) {
        int i;
        StringBuilder q9 = x.q(charSequence, charSequence2, charSequence3, pVar, charSequence2);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j = jArr2[i6];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i6 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j & 255) < 128) {
                            int i14 = (i6 << 3) + i13;
                            int i15 = iArr[i14];
                            long j6 = jArr[i14];
                            i = i11;
                            if (i10 == -1) {
                                q9.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                q9.append(charSequence);
                            }
                            q9.append((CharSequence) pVar.invoke(Integer.valueOf(i15), Long.valueOf(j6)));
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

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, p pVar) {
        int i;
        charSequence.getClass();
        charSequence2.getClass();
        pVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j = jArr2[i6];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i6 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((255 & j) < 128) {
                            int i14 = (i6 << 3) + i13;
                            int i15 = iArr[i14];
                            long j6 = jArr[i14];
                            if (i10 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                sb.append(charSequence);
                            }
                            Integer valueOf = Integer.valueOf(i15);
                            Long valueOf2 = Long.valueOf(j6);
                            i = i11;
                            sb.append((CharSequence) pVar.invoke(valueOf, valueOf2));
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

    public final String joinToString(CharSequence charSequence, p pVar) {
        int i;
        charSequence.getClass();
        pVar.getClass();
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j = jArr2[i6];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i6 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((255 & j) < 128) {
                            int i14 = (i6 << 3) + i13;
                            int i15 = iArr[i14];
                            long j6 = jArr[i14];
                            if (i10 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                sb.append(charSequence);
                            }
                            Integer valueOf = Integer.valueOf(i15);
                            i = i11;
                            sb.append((CharSequence) pVar.invoke(valueOf, Long.valueOf(j6)));
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
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j = jArr2[i6];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i6 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((255 & j) < 128) {
                            int i14 = (i6 << 3) + i13;
                            int i15 = iArr[i14];
                            long j6 = jArr[i14];
                            if (i10 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                sb.append((CharSequence) ", ");
                            }
                            Integer valueOf = Integer.valueOf(i15);
                            Long valueOf2 = Long.valueOf(j6);
                            i = i11;
                            sb.append((CharSequence) pVar.invoke(valueOf, valueOf2));
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
