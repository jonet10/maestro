package androidx.collection;

import a3.b;
import a4.x;
import androidx.annotation.IntRange;
import com.google.gson.internal.a;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import q6.e;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutableIntList extends IntList {
    public /* synthetic */ MutableIntList(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 16 : i);
    }

    public static /* synthetic */ void trim$default(MutableIntList mutableIntList, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = mutableIntList._size;
        }
        mutableIntList.trim(i);
    }

    public final void add(@IntRange(from = 0) int i, int i6) {
        int i10;
        if (i < 0 || i > (i10 = this._size)) {
            a.g(this._size, x.p(i, "Index ", " must be in 0.."));
            return;
        }
        ensureCapacity(i10 + 1);
        int[] iArr = this.content;
        int i11 = this._size;
        if (i != i11) {
            j.X(i + 1, i, iArr, iArr, i11);
        }
        iArr[i] = i6;
        this._size++;
    }

    public final boolean addAll(@IntRange(from = 0) int i, IntList intList) {
        intList.getClass();
        if (i < 0 || i > this._size) {
            a.g(this._size, x.p(i, "Index ", " must be in 0.."));
            return false;
        }
        if (intList.isEmpty()) {
            return false;
        }
        ensureCapacity(this._size + intList._size);
        int[] iArr = this.content;
        int i6 = this._size;
        if (i != i6) {
            j.X(intList._size + i, i, iArr, iArr, i6);
        }
        j.X(i, 0, intList.content, iArr, intList._size);
        this._size += intList._size;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i) {
        int[] iArr = this.content;
        if (iArr.length < i) {
            this.content = Arrays.copyOf(iArr, Math.max(i, (iArr.length * 3) / 2));
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(IntList intList) {
        intList.getClass();
        int[] iArr = intList.content;
        int i = intList._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(iArr[i6]);
        }
    }

    public final void plusAssign(IntList intList) {
        intList.getClass();
        addAll(this._size, intList);
    }

    public final boolean remove(int i) {
        int indexOf = indexOf(i);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(IntList intList) {
        intList.getClass();
        int i = this._size;
        int i6 = intList._size - 1;
        if (i6 >= 0) {
            int i10 = 0;
            while (true) {
                remove(intList.get(i10));
                if (i10 == i6) {
                    break;
                }
                i10++;
            }
        }
        return i != this._size;
    }

    public final int removeAt(@IntRange(from = 0) int i) {
        int i6;
        if (i < 0 || i >= (i6 = this._size)) {
            a.g(this._size - 1, x.p(i, "Index ", " must be in 0.."));
            return 0;
        }
        int[] iArr = this.content;
        int i10 = iArr[i];
        if (i != i6 - 1) {
            j.X(i, i + 1, iArr, iArr, i6);
        }
        this._size--;
        return i10;
    }

    public final void removeRange(@IntRange(from = 0) int i, @IntRange(from = 0) int i6) {
        int i10;
        if (i < 0 || i > (i10 = this._size) || i6 < 0 || i6 > i10) {
            b.j(i, i6, this._size);
            return;
        }
        if (i6 < i) {
            a.j("Start (", i, ") is more than end (", i6, 41);
        } else if (i6 != i) {
            if (i6 < i10) {
                int[] iArr = this.content;
                j.X(i, i6, iArr, iArr, i10);
            }
            this._size -= i6 - i;
        }
    }

    public final boolean retainAll(int[] iArr) {
        iArr.getClass();
        int i = this._size;
        int[] iArr2 = this.content;
        int i6 = i - 1;
        while (true) {
            int i10 = 0;
            int i11 = -1;
            if (-1 >= i6) {
                break;
            }
            int i12 = iArr2[i6];
            int length = iArr.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (iArr[i10] == i12) {
                    i11 = i10;
                    break;
                }
                i10++;
            }
            if (i11 < 0) {
                removeAt(i6);
            }
            i6--;
        }
        return i != this._size;
    }

    public final int set(@IntRange(from = 0) int i, int i6) {
        if (i < 0 || i >= this._size) {
            a.g(this._size - 1, x.p(i, "set index ", " must be between 0 .. "));
            return 0;
        }
        int[] iArr = this.content;
        int i10 = iArr[i];
        iArr[i] = i6;
        return i10;
    }

    public final void sort() {
        int[] iArr = this.content;
        int i = this._size;
        iArr.getClass();
        Arrays.sort(iArr, 0, i);
    }

    public final void sortDescending() {
        int[] iArr = this.content;
        int i = this._size;
        iArr.getClass();
        Arrays.sort(iArr, 0, i);
        q6.b bVar = e.Companion;
        int length = iArr.length;
        bVar.getClass();
        q6.b.d(0, i, length);
        int i6 = i / 2;
        if (i6 == 0) {
            return;
        }
        int i10 = i - 1;
        for (int i11 = 0; i11 < i6; i11++) {
            int i12 = iArr[i11];
            iArr[i11] = iArr[i10];
            iArr[i10] = i12;
            i10--;
        }
    }

    public final void trim(int i) {
        int max = Math.max(i, this._size);
        int[] iArr = this.content;
        if (iArr.length > max) {
            this.content = Arrays.copyOf(iArr, max);
        }
    }

    public final void plusAssign(int[] iArr) {
        iArr.getClass();
        addAll(this._size, iArr);
    }

    public MutableIntList() {
        this(0, 1, null);
    }

    public final void plusAssign(int i) {
        add(i);
    }

    public MutableIntList(int i) {
        super(i, null);
    }

    public final void minusAssign(int[] iArr) {
        iArr.getClass();
        for (int i : iArr) {
            remove(i);
        }
    }

    public final void minusAssign(int i) {
        remove(i);
    }

    public final boolean removeAll(int[] iArr) {
        iArr.getClass();
        int i = this._size;
        for (int i6 : iArr) {
            remove(i6);
        }
        return i != this._size;
    }

    public final boolean retainAll(IntList intList) {
        intList.getClass();
        int i = this._size;
        int[] iArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (!intList.contains(iArr[i6])) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final boolean add(int i) {
        ensureCapacity(this._size + 1);
        int[] iArr = this.content;
        int i6 = this._size;
        iArr[i6] = i;
        this._size = i6 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i, int[] iArr) {
        int i6;
        iArr.getClass();
        if (i >= 0 && i <= (i6 = this._size)) {
            if (iArr.length == 0) {
                return false;
            }
            ensureCapacity(i6 + iArr.length);
            int[] iArr2 = this.content;
            int i10 = this._size;
            if (i != i10) {
                j.X(iArr.length + i, i, iArr2, iArr2, i10);
            }
            j.b0(i, 0, iArr, iArr2, 12);
            this._size += iArr.length;
            return true;
        }
        a.g(this._size, x.p(i, "Index ", " must be in 0.."));
        return false;
    }

    public final boolean addAll(IntList intList) {
        intList.getClass();
        return addAll(this._size, intList);
    }

    public final boolean addAll(int[] iArr) {
        iArr.getClass();
        return addAll(this._size, iArr);
    }
}
