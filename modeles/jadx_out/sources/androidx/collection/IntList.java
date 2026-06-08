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
public abstract class IntList {
    public int _size;
    public int[] content;

    private IntList(int i) {
        this.content = i == 0 ? IntSetKt.getEmptyIntArray() : new int[i];
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, l lVar, int i6, Object obj) {
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
        int[] iArr = intList.content;
        int i10 = intList._size;
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                sb.append(charSequence3);
                break;
            }
            int i12 = iArr[i11];
            if (i11 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i11 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Integer.valueOf(i12)));
            i11++;
        }
        return sb.toString();
    }

    public final boolean any(l lVar) {
        lVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (((Boolean) lVar.invoke(Integer.valueOf(iArr[i6]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean contains(int i) {
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i10 = 0; i10 < i6; i10++) {
            if (iArr[i10] == i) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(IntList intList) {
        intList.getClass();
        d K = f.K(0, intList._size);
        int i = K.f5695a;
        int i6 = K.f5696b;
        if (i > i6) {
            return true;
        }
        while (contains(intList.get(i))) {
            if (i == i6) {
                return true;
            }
            i++;
        }
        return false;
    }

    public final int count(l lVar) {
        lVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            if (((Boolean) lVar.invoke(Integer.valueOf(iArr[i10]))).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    public final int elementAt(@IntRange(from = 0) int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        a.g(this._size - 1, x.p(i, "Index ", " must be in 0.."));
        return 0;
    }

    public final int elementAtOrElse(@IntRange(from = 0) int i, l lVar) {
        lVar.getClass();
        return (i < 0 || i >= this._size) ? ((Number) lVar.invoke(Integer.valueOf(i))).intValue() : this.content[i];
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntList) {
            IntList intList = (IntList) obj;
            int i = intList._size;
            int i6 = this._size;
            if (i == i6) {
                int[] iArr = this.content;
                int[] iArr2 = intList.content;
                d K = f.K(0, i6);
                int i10 = K.f5695a;
                int i11 = K.f5696b;
                if (i10 > i11) {
                    return true;
                }
                while (iArr[i10] == iArr2[i10]) {
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

    public final int first(l lVar) {
        lVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            int i10 = iArr[i6];
            if (((Boolean) lVar.invoke(Integer.valueOf(i10))).booleanValue()) {
                return i10;
            }
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("IntList contains no element matching the predicate.");
        return 0;
    }

    public final <R> R fold(R r9, p pVar) {
        pVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            r9 = (R) pVar.invoke(r9, Integer.valueOf(iArr[i6]));
        }
        return r9;
    }

    public final <R> R foldIndexed(R r9, q qVar) {
        qVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            R r10 = r9;
            r9 = (R) qVar.invoke(Integer.valueOf(i6), r10, Integer.valueOf(iArr[i6]));
        }
        return r9;
    }

    public final <R> R foldRight(R r9, p pVar) {
        pVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return r9;
            }
            r9 = (R) pVar.invoke(Integer.valueOf(iArr[i]), r9);
        }
    }

    public final <R> R foldRightIndexed(R r9, q qVar) {
        qVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return r9;
            }
            r9 = (R) qVar.invoke(Integer.valueOf(i), Integer.valueOf(iArr[i]), r9);
        }
    }

    public final void forEach(l lVar) {
        lVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            lVar.invoke(Integer.valueOf(iArr[i6]));
        }
    }

    public final void forEachIndexed(p pVar) {
        pVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            pVar.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i6]));
        }
    }

    public final void forEachReversed(l lVar) {
        lVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            } else {
                lVar.invoke(Integer.valueOf(iArr[i]));
            }
        }
    }

    public final void forEachReversedIndexed(p pVar) {
        pVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            } else {
                pVar.invoke(Integer.valueOf(i), Integer.valueOf(iArr[i]));
            }
        }
    }

    public final int get(@IntRange(from = 0) int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        a.g(this._size - 1, x.p(i, "Index ", " must be in 0.."));
        return 0;
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
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            i6 += iArr[i10] * 31;
        }
        return i6;
    }

    public final int indexOf(int i) {
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i10 = 0; i10 < i6; i10++) {
            if (i == iArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public final int indexOfFirst(l lVar) {
        lVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (((Boolean) lVar.invoke(Integer.valueOf(iArr[i6]))).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfLast(l lVar) {
        lVar.getClass();
        int[] iArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
        } while (!((Boolean) lVar.invoke(Integer.valueOf(iArr[i]))).booleanValue());
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
        int[] iArr = this.content;
        int i6 = this._size;
        int i10 = 0;
        while (true) {
            if (i10 >= i6) {
                sb.append(charSequence3);
                break;
            }
            int i11 = iArr[i10];
            if (i10 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i10 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Integer.valueOf(i11)));
            i10++;
        }
        return sb.toString();
    }

    public final int last(l lVar) {
        int i;
        lVar.getClass();
        int[] iArr = this.content;
        int i6 = this._size;
        do {
            i6--;
            if (-1 >= i6) {
                androidx.privacysandbox.ads.adservices.customaudience.a.s("IntList contains no element matching the predicate.");
                return 0;
            }
            i = iArr[i6];
        } while (!((Boolean) lVar.invoke(Integer.valueOf(i))).booleanValue());
        return i;
    }

    public final int lastIndexOf(int i) {
        int[] iArr = this.content;
        int i6 = this._size;
        do {
            i6--;
            if (-1 >= i6) {
                return -1;
            }
        } while (iArr[i6] != i);
        return i6;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(l lVar) {
        lVar.getClass();
        int[] iArr = this.content;
        for (int i = this._size - 1; -1 < i; i--) {
            if (((Boolean) lVar.invoke(Integer.valueOf(iArr[i]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    public /* synthetic */ IntList(int i, g gVar) {
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

    public final int first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("IntList is empty.");
        return 0;
    }

    public final int last() {
        if (!isEmpty()) {
            return this.content[this._size - 1];
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("IntList is empty.");
        return 0;
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
        int[] iArr = this.content;
        int i6 = this._size;
        int i10 = 0;
        while (true) {
            if (i10 < i6) {
                int i11 = iArr[i10];
                if (i10 == i) {
                    s6.append(charSequence4);
                    break;
                }
                if (i10 != 0) {
                    s6.append(charSequence);
                }
                s6.append(i11);
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
        int[] iArr = this.content;
        int i6 = this._size;
        int i10 = 0;
        while (true) {
            if (i10 < i6) {
                int i11 = iArr[i10];
                if (i10 == i) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i10 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Integer.valueOf(i11)));
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
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                int i10 = iArr[i6];
                if (i6 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i6 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Integer.valueOf(i10)));
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
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                int i10 = iArr[i6];
                if (i6 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i6 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Integer.valueOf(i10)));
                i6++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i6, Object obj) {
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
        return intList.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final String joinToString(CharSequence charSequence, l lVar) {
        charSequence.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                int i10 = iArr[i6];
                if (i6 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i6 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Integer.valueOf(i10)));
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
        int[] iArr = this.content;
        int i = this._size;
        int i6 = 0;
        while (true) {
            if (i6 < i) {
                int i10 = iArr[i6];
                if (i6 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i6 != 0) {
                    sb.append((CharSequence) ", ");
                }
                sb.append((CharSequence) lVar.invoke(Integer.valueOf(i10)));
                i6++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        return sb.toString();
    }
}
