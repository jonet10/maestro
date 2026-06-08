package androidx.collection;

import a3.b;
import a4.x;
import androidx.collection.internal.ContainerHelpersKt;
import d7.a;
import d7.p;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class IntObjectMap<V> {
    public int _capacity;
    public int _size;
    public int[] keys;
    public long[] metadata;
    public Object[] values;

    private IntObjectMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = IntSetKt.getEmptyIntArray();
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public static /* synthetic */ String joinToString$default(IntObjectMap intObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, p pVar, int i6, Object obj) {
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
        int[] iArr = intObjectMap.keys;
        Object[] objArr = intObjectMap.values;
        long[] jArr3 = intObjectMap.metadata;
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
                            int i19 = iArr[i18];
                            i10 = i15;
                            Object obj2 = objArr[i18];
                            if (i13 == i11) {
                                r9.append(charSequence8);
                                break loop0;
                            }
                            if (i13 != 0) {
                                r9.append(charSequence5);
                            }
                            jArr2 = jArr3;
                            r9.append((CharSequence) pVar.invoke(Integer.valueOf(i19), obj2));
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
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                        if (!((Boolean) pVar.invoke(Integer.valueOf(iArr[i11]), objArr[i11])).booleanValue()) {
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
        Object[] objArr = this.values;
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
                            if (((Boolean) pVar.invoke(Integer.valueOf(iArr[i11]), objArr[i11])).booleanValue()) {
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

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean contains(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r2 = r2 * r1
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r0._capacity
            int r2 = r2 >>> 7
            r2 = r2 & r4
            r5 = 0
            r6 = r5
        L14:
            long[] r7 = r0.metadata
            int r8 = r2 >> 3
            r9 = r2 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r3
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L40:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L5b
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r2
            r11 = r11 & r4
            int[] r15 = r0.keys
            r15 = r15[r11]
            if (r15 != r1) goto L55
            goto L65
        L55:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L40
        L5b:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L69
            r11 = -1
        L65:
            if (r11 < 0) goto L68
            return r12
        L68:
            return r5
        L69:
            int r6 = r6 + 8
            int r2 = r2 + r6
            r2 = r2 & r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntObjectMap.contains(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean containsKey(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r2 = r2 * r1
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r0._capacity
            int r2 = r2 >>> 7
            r2 = r2 & r4
            r5 = 0
            r6 = r5
        L14:
            long[] r7 = r0.metadata
            int r8 = r2 >> 3
            r9 = r2 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r3
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L40:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L5b
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r2
            r11 = r11 & r4
            int[] r15 = r0.keys
            r15 = r15[r11]
            if (r15 != r1) goto L55
            goto L65
        L55:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L40
        L5b:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L69
            r11 = -1
        L65:
            if (r11 < 0) goto L68
            return r12
        L68:
            return r5
        L69:
            int r6 = r6 + 8
            int r2 = r2 + r6
            r2 = r2 & r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntObjectMap.containsKey(int):boolean");
    }

    public final boolean containsValue(V v) {
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i6; i10++) {
                        if ((255 & j) < 128 && l.a(v, objArr[(i << 3) + i10])) {
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
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                        if (((Boolean) pVar.invoke(Integer.valueOf(iArr[i12]), objArr[i12])).booleanValue()) {
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
        if (!(obj instanceof IntObjectMap)) {
            return false;
        }
        IntObjectMap intObjectMap = (IntObjectMap) obj;
        if (intObjectMap.getSize() != getSize()) {
            return false;
        }
        int[] iArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            loop0: while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i6; i10++) {
                        if ((255 & j) < 128) {
                            int i11 = (i << 3) + i10;
                            int i12 = iArr[i11];
                            Object obj2 = objArr[i11];
                            if (obj2 == null) {
                                if (intObjectMap.get(i12) != null || !intObjectMap.containsKey(i12)) {
                                    break loop0;
                                }
                            } else if (!obj2.equals(intObjectMap.get(i12))) {
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
            return false;
        }
        return true;
    }

    public final int findKeyIndex$collection(int i) {
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
        Object[] objArr = this.values;
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
                        pVar.invoke(Integer.valueOf(iArr[i11]), objArr[i11]);
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

    public final void forEachIndexed(d7.l lVar) {
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

    public final void forEachKey(d7.l lVar) {
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

    public final void forEachValue(d7.l lVar) {
        lVar.getClass();
        Object[] objArr = this.values;
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
                        lVar.invoke(objArr[(i << 3) + i10]);
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

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V get(int r14) {
        /*
            r13 = this;
            r0 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r0 = r0 * r14
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13._capacity
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        Lf:
            long[] r4 = r13.metadata
            int r5 = r0 >> 3
            r6 = r0 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L3b:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L56
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            int[] r11 = r13.keys
            r11 = r11[r10]
            if (r11 != r14) goto L50
            goto L60
        L50:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L3b
        L56:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L69
            r10 = -1
        L60:
            if (r10 < 0) goto L67
            java.lang.Object[] r14 = r13.values
            r14 = r14[r10]
            return r14
        L67:
            r14 = 0
            return r14
        L69:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntObjectMap.get(int):java.lang.Object");
    }

    public final int getCapacity() {
        return this._capacity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V getOrDefault(int r14, V r15) {
        /*
            r13 = this;
            r0 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r0 = r0 * r14
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13._capacity
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        Lf:
            long[] r4 = r13.metadata
            int r5 = r0 >> 3
            r6 = r0 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L3b:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L56
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            int[] r11 = r13.keys
            r11 = r11[r10]
            if (r11 != r14) goto L50
            goto L60
        L50:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L3b
        L56:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L68
            r10 = -1
        L60:
            if (r10 < 0) goto L67
            java.lang.Object[] r14 = r13.values
            r14 = r14[r10]
            return r14
        L67:
            return r15
        L68:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntObjectMap.getOrDefault(int, java.lang.Object):java.lang.Object");
    }

    public final V getOrElse(int i, a aVar) {
        aVar.getClass();
        V v = get(i);
        return v == null ? (V) aVar.invoke() : v;
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                        int i13 = iArr[i12];
                        Object obj = objArr[i12];
                        i6 += (obj != null ? obj.hashCode() : 0) ^ i13;
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

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, p pVar) {
        int[] iArr;
        int[] iArr2;
        CharSequence charSequence5 = charSequence;
        StringBuilder r9 = x.r(charSequence5, charSequence2, charSequence3, charSequence4, pVar);
        r9.append(charSequence2);
        int[] iArr3 = this.keys;
        Object[] objArr = this.values;
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
                            int i15 = iArr3[i14];
                            Object obj = objArr[i14];
                            iArr2 = iArr3;
                            if (i10 == i) {
                                r9.append(charSequence4);
                                break loop0;
                            }
                            if (i10 != 0) {
                                r9.append(charSequence5);
                            }
                            r9.append((CharSequence) pVar.invoke(Integer.valueOf(i15), obj));
                            i10++;
                        } else {
                            iArr2 = iArr3;
                        }
                        j >>= 8;
                        i13++;
                        charSequence5 = charSequence;
                        iArr3 = iArr2;
                    }
                    iArr = iArr3;
                    if (i12 != 8) {
                        break;
                    }
                } else {
                    iArr = iArr3;
                }
                if (i11 == length) {
                    break;
                }
                i6 = i11 + 1;
                charSequence5 = charSequence;
                iArr3 = iArr;
            }
            return r9.toString();
        }
        r9.append(charSequence3);
        return r9.toString();
    }

    public final boolean none() {
        return this._size == 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i13 = iArr[i12];
                            Object obj = objArr[i12];
                            sb.append(i13);
                            sb.append("=");
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
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

    public /* synthetic */ IntObjectMap(g gVar) {
        this();
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
        StringBuilder q9 = x.q(charSequence, charSequence2, charSequence3, pVar, charSequence2);
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i16 = iArr[i15];
                            i6 = i12;
                            Object obj = objArr[i15];
                            if (i11 == i) {
                                q9.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i11 != 0) {
                                q9.append(charSequence);
                            }
                            q9.append((CharSequence) pVar.invoke(Integer.valueOf(i16), obj));
                            i11++;
                        } else {
                            i6 = i12;
                        }
                        j >>= i6;
                        i14++;
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
            }
        }
        q9.append(charSequence3);
        return q9.toString();
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4) {
        int[] iArr;
        int[] iArr2;
        int i6;
        StringBuilder s6 = x.s(charSequence, charSequence2, charSequence3, charSequence4, charSequence2);
        int[] iArr3 = this.keys;
        Object[] objArr = this.values;
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
                            int i16 = iArr3[i15];
                            Object obj = objArr[i15];
                            iArr2 = iArr3;
                            if (i11 == i) {
                                s6.append(charSequence4);
                                break loop0;
                            }
                            if (i11 != 0) {
                                s6.append(charSequence);
                            }
                            s6.append(i16);
                            s6.append('=');
                            s6.append(obj);
                            i11++;
                        } else {
                            iArr2 = iArr3;
                            i6 = i12;
                        }
                        j >>= i6;
                        i14++;
                        iArr3 = iArr2;
                        i12 = i6;
                    }
                    iArr = iArr3;
                    if (i13 != i12) {
                        break;
                    }
                } else {
                    iArr = iArr3;
                }
                if (i10 == length) {
                    break;
                }
                i10++;
                iArr3 = iArr;
            }
            return s6.toString();
        }
        s6.append(charSequence3);
        return s6.toString();
    }

    public static /* synthetic */ String joinToString$default(IntObjectMap intObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i6, Object obj) {
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
        return intObjectMap.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, p pVar) {
        int i;
        StringBuilder q9 = x.q(charSequence, charSequence2, charSequence3, pVar, charSequence2);
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i15 = iArr[i14];
                            i = i11;
                            Object obj = objArr[i14];
                            if (i10 == -1) {
                                q9.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                q9.append(charSequence);
                            }
                            q9.append((CharSequence) pVar.invoke(Integer.valueOf(i15), obj));
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
        Object[] objArr = this.values;
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
                            int i15 = iArr[i14];
                            Object obj = objArr[i14];
                            if (i10 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                sb.append(charSequence);
                            }
                            i = i11;
                            sb.append((CharSequence) pVar.invoke(Integer.valueOf(i15), obj));
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
        Object[] objArr = this.values;
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
                            int i15 = iArr[i14];
                            Object obj = objArr[i14];
                            if (i10 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                sb.append(charSequence);
                            }
                            i = i11;
                            sb.append((CharSequence) pVar.invoke(Integer.valueOf(i15), obj));
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

    public final String joinToString(p pVar) {
        int i;
        pVar.getClass();
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i15 = iArr[i14];
                            Object obj = objArr[i14];
                            if (i10 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                sb.append((CharSequence) ", ");
                            }
                            Integer valueOf = Integer.valueOf(i15);
                            i = i11;
                            sb.append((CharSequence) pVar.invoke(valueOf, obj));
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
