package androidx.collection;

import a3.b;
import a4.x;
import androidx.annotation.IntRange;
import com.google.gson.internal.a;
import d7.l;
import d7.p;
import d7.q;
import i7.d;
import kotlin.jvm.internal.g;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class FloatList {
    public int _size;
    public float[] content;

    private FloatList(int i) {
        this.content = i == 0 ? FloatSetKt.getEmptyFloatArray() : new float[i];
    }

    public static /* synthetic */ String joinToString$default(FloatList floatList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, l lVar, int i6, Object obj) {
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
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        float[] fArr = floatList.content;
        int i10 = floatList._size;
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                sb.append(charSequence3);
                break;
            }
            float f = fArr[i11];
            if (i11 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i11 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Float.valueOf(f)));
            i11++;
        }
        return sb.toString();
    }

    public final boolean any(l lVar) {
        lVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (((Boolean) lVar.invoke(Float.valueOf(fArr[i6]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean contains(float f) {
        float[] fArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (fArr[i6] == f) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(FloatList floatList) {
        floatList.getClass();
        d K = f.K(0, floatList._size);
        int i = K.f5695a;
        int i6 = K.f5696b;
        if (i > i6) {
            return true;
        }
        while (contains(floatList.get(i))) {
            if (i == i6) {
                return true;
            }
            i++;
        }
        return false;
    }

    public final int count(l lVar) {
        lVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            if (((Boolean) lVar.invoke(Float.valueOf(fArr[i10]))).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    public final float elementAt(@IntRange(from = 0) int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        a.g(this._size - 1, x.p(i, "Index ", " must be in 0.."));
        return 0.0f;
    }

    public final float elementAtOrElse(@IntRange(from = 0) int i, l lVar) {
        lVar.getClass();
        return (i < 0 || i >= this._size) ? ((Number) lVar.invoke(Integer.valueOf(i))).floatValue() : this.content[i];
    }

    public boolean equals(Object obj) {
        if (obj instanceof FloatList) {
            FloatList floatList = (FloatList) obj;
            int i = floatList._size;
            int i6 = this._size;
            if (i == i6) {
                float[] fArr = this.content;
                float[] fArr2 = floatList.content;
                d K = f.K(0, i6);
                int i10 = K.f5695a;
                int i11 = K.f5696b;
                if (i10 > i11) {
                    return true;
                }
                while (fArr[i10] == fArr2[i10]) {
                    if (i10 == i11) {
                        return true;
                    }
                    i10++;
                }
                return false;
            }
        }
        return false;
    }

    public final float first(l lVar) {
        lVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            float f = fArr[i6];
            if (((Boolean) lVar.invoke(Float.valueOf(f))).booleanValue()) {
                return f;
            }
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("FloatList contains no element matching the predicate.");
        return 0.0f;
    }

    public final <R> R fold(R r9, p pVar) {
        pVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            r9 = (R) pVar.invoke(r9, Float.valueOf(fArr[i6]));
        }
        return r9;
    }

    public final <R> R foldIndexed(R r9, q qVar) {
        qVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            R r10 = r9;
            r9 = (R) qVar.invoke(Integer.valueOf(i6), r10, Float.valueOf(fArr[i6]));
        }
        return r9;
    }

    public final <R> R foldRight(R r9, p pVar) {
        pVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return r9;
            }
            r9 = (R) pVar.invoke(Float.valueOf(fArr[i]), r9);
        }
    }

    public final <R> R foldRightIndexed(R r9, q qVar) {
        qVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return r9;
            }
            r9 = (R) qVar.invoke(Integer.valueOf(i), Float.valueOf(fArr[i]), r9);
        }
    }

    public final void forEach(l lVar) {
        lVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            lVar.invoke(Float.valueOf(fArr[i6]));
        }
    }

    public final void forEachIndexed(p pVar) {
        pVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            pVar.invoke(Integer.valueOf(i6), Float.valueOf(fArr[i6]));
        }
    }

    public final void forEachReversed(l lVar) {
        lVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            } else {
                lVar.invoke(Float.valueOf(fArr[i]));
            }
        }
    }

    public final void forEachReversedIndexed(p pVar) {
        pVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            } else {
                pVar.invoke(Integer.valueOf(i), Float.valueOf(fArr[i]));
            }
        }
    }

    public final float get(@IntRange(from = 0) int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        a.g(this._size - 1, x.p(i, "Index ", " must be in 0.."));
        return 0.0f;
    }

    public final d getIndices() {
        return f.K(0, this._size);
    }

    @IntRange(from = -1)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        float[] fArr = this.content;
        int i = this._size;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            i6 += Float.floatToIntBits(fArr[i10]) * 31;
        }
        return i6;
    }

    public final int indexOf(float f) {
        float[] fArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (f == fArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfFirst(l lVar) {
        lVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (((Boolean) lVar.invoke(Float.valueOf(fArr[i6]))).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfLast(l lVar) {
        lVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
        } while (!((Boolean) lVar.invoke(Float.valueOf(fArr[i]))).booleanValue());
        return i;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, l lVar) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        float[] fArr = this.content;
        int i6 = this._size;
        int i10 = 0;
        while (true) {
            if (i10 >= i6) {
                sb.append(charSequence3);
                break;
            }
            float f = fArr[i10];
            if (i10 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i10 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Float.valueOf(f)));
            i10++;
        }
        return sb.toString();
    }

    public final float last(l lVar) {
        float f;
        lVar.getClass();
        float[] fArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                androidx.privacysandbox.ads.adservices.customaudience.a.s("FloatList contains no element matching the predicate.");
                return 0.0f;
            }
            f = fArr[i];
        } while (!((Boolean) lVar.invoke(Float.valueOf(f))).booleanValue());
        return f;
    }

    public final int lastIndexOf(float f) {
        float[] fArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
        } while (fArr[i] != f);
        return i;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(l lVar) {
        lVar.getClass();
        float[] fArr = this.content;
        for (int i = this._size - 1; -1 < i; i--) {
            if (((Boolean) lVar.invoke(Float.valueOf(fArr[i]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    public /* synthetic */ FloatList(int i, g gVar) {
        this(i);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final int count() {
        return this._size;
    }

    public final float first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("FloatList is empty.");
        return 0.0f;
    }

    public final float last() {
        if (!isEmpty()) {
            return this.content[this._size - 1];
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("FloatList is empty.");
        return 0.0f;
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

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4) {
        StringBuilder s6 = x.s(charSequence, charSequence2, charSequence3, charSequence4, charSequence2);
        float[] fArr = this.content;
        int i6 = this._size;
        int i10 = 0;
        while (true) {
            if (i10 < i6) {
                float f = fArr[i10];
                if (i10 == i) {
                    s6.append(charSequence4);
                    break;
                }
                if (i10 != 0) {
                    s6.append(charSequence);
                }
                s6.append(f);
                i10++;
            } else {
                s6.append(charSequence3);
                break;
            }
        }
        return s6.toString();
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, l lVar) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        float[] fArr = this.content;
        int i6 = this._size;
        int i10 = 0;
        while (true) {
            if (i10 < i6) {
                float f = fArr[i10];
                if (i10 == i) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i10 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Float.valueOf(f)));
                i10++;
            } else {
                sb.append(charSequence3);
                break;
            }
        }
        return sb.toString();
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, l lVar) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        float[] fArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                float f = fArr[i6];
                if (i6 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i6 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Float.valueOf(f)));
                i6++;
            } else {
                sb.append(charSequence3);
                break;
            }
        }
        return sb.toString();
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, l lVar) {
        charSequence.getClass();
        charSequence2.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        float[] fArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                float f = fArr[i6];
                if (i6 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i6 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Float.valueOf(f)));
                i6++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String joinToString$default(FloatList floatList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i6, Object obj) {
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
        return floatList.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final String joinToString(CharSequence charSequence, l lVar) {
        charSequence.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder("");
        float[] fArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                float f = fArr[i6];
                if (i6 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i6 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Float.valueOf(f)));
                i6++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        return sb.toString();
    }

    public final String joinToString(l lVar) {
        lVar.getClass();
        StringBuilder sb = new StringBuilder("");
        float[] fArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                float f = fArr[i6];
                if (i6 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i6 != 0) {
                    sb.append((CharSequence) ", ");
                }
                sb.append((CharSequence) lVar.invoke(Float.valueOf(f)));
                i6++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        return sb.toString();
    }
}
