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
public final class MutableLongList extends LongList {
    public /* synthetic */ MutableLongList(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 16 : i);
    }

    public static /* synthetic */ void trim$default(MutableLongList mutableLongList, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = mutableLongList._size;
        }
        mutableLongList.trim(i);
    }

    public final void add(@IntRange(from = 0) int i, long j) {
        int i6;
        if (i < 0 || i > (i6 = this._size)) {
            a.g(this._size, x.p(i, "Index ", " must be in 0.."));
            return;
        }
        ensureCapacity(i6 + 1);
        long[] jArr = this.content;
        int i10 = this._size;
        if (i != i10) {
            j.a0(jArr, jArr, i + 1, i, i10);
        }
        jArr[i] = j;
        this._size++;
    }

    public final boolean addAll(@IntRange(from = 0) int i, LongList longList) {
        longList.getClass();
        if (i < 0 || i > this._size) {
            a.g(this._size, x.p(i, "Index ", " must be in 0.."));
            return false;
        }
        if (longList.isEmpty()) {
            return false;
        }
        ensureCapacity(this._size + longList._size);
        long[] jArr = this.content;
        int i6 = this._size;
        if (i != i6) {
            j.a0(jArr, jArr, longList._size + i, i, i6);
        }
        j.a0(longList.content, jArr, i, 0, longList._size);
        this._size += longList._size;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i) {
        long[] jArr = this.content;
        if (jArr.length < i) {
            this.content = Arrays.copyOf(jArr, Math.max(i, (jArr.length * 3) / 2));
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(LongList longList) {
        longList.getClass();
        long[] jArr = longList.content;
        int i = longList._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(jArr[i6]);
        }
    }

    public final void plusAssign(LongList longList) {
        longList.getClass();
        addAll(this._size, longList);
    }

    public final boolean remove(long j) {
        int indexOf = indexOf(j);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(LongList longList) {
        longList.getClass();
        int i = this._size;
        int i6 = longList._size - 1;
        if (i6 >= 0) {
            int i10 = 0;
            while (true) {
                remove(longList.get(i10));
                if (i10 == i6) {
                    break;
                }
                i10++;
            }
        }
        return i != this._size;
    }

    public final long removeAt(@IntRange(from = 0) int i) {
        int i6;
        if (i < 0 || i >= (i6 = this._size)) {
            a.g(this._size - 1, x.p(i, "Index ", " must be in 0.."));
            return 0L;
        }
        long[] jArr = this.content;
        long j = jArr[i];
        if (i != i6 - 1) {
            j.a0(jArr, jArr, i, i + 1, i6);
        }
        this._size--;
        return j;
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
                long[] jArr = this.content;
                j.a0(jArr, jArr, i, i6, i10);
            }
            this._size -= i6 - i;
        }
    }

    public final boolean retainAll(long[] jArr) {
        jArr.getClass();
        int i = this._size;
        long[] jArr2 = this.content;
        int i6 = i - 1;
        while (true) {
            int i10 = 0;
            int i11 = -1;
            if (-1 >= i6) {
                break;
            }
            long j = jArr2[i6];
            int length = jArr.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (jArr[i10] == j) {
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

    public final long set(@IntRange(from = 0) int i, long j) {
        if (i < 0 || i >= this._size) {
            a.g(this._size - 1, x.p(i, "set index ", " must be between 0 .. "));
            return 0L;
        }
        long[] jArr = this.content;
        long j6 = jArr[i];
        jArr[i] = j;
        return j6;
    }

    public final void sort() {
        long[] jArr = this.content;
        int i = this._size;
        jArr.getClass();
        Arrays.sort(jArr, 0, i);
    }

    public final void sortDescending() {
        long[] jArr = this.content;
        int i = this._size;
        jArr.getClass();
        Arrays.sort(jArr, 0, i);
        q6.b bVar = e.Companion;
        int length = jArr.length;
        bVar.getClass();
        q6.b.d(0, i, length);
        int i6 = i / 2;
        if (i6 == 0) {
            return;
        }
        int i10 = i - 1;
        for (int i11 = 0; i11 < i6; i11++) {
            long j = jArr[i11];
            jArr[i11] = jArr[i10];
            jArr[i10] = j;
            i10--;
        }
    }

    public final void trim(int i) {
        int max = Math.max(i, this._size);
        long[] jArr = this.content;
        if (jArr.length > max) {
            this.content = Arrays.copyOf(jArr, max);
        }
    }

    public final void plusAssign(long[] jArr) {
        jArr.getClass();
        addAll(this._size, jArr);
    }

    public MutableLongList() {
        this(0, 1, null);
    }

    public final void plusAssign(long j) {
        add(j);
    }

    public MutableLongList(int i) {
        super(i, null);
    }

    public final void minusAssign(long[] jArr) {
        jArr.getClass();
        for (long j : jArr) {
            remove(j);
        }
    }

    public final void minusAssign(long j) {
        remove(j);
    }

    public final boolean removeAll(long[] jArr) {
        jArr.getClass();
        int i = this._size;
        for (long j : jArr) {
            remove(j);
        }
        return i != this._size;
    }

    public final boolean retainAll(LongList longList) {
        longList.getClass();
        int i = this._size;
        long[] jArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (!longList.contains(jArr[i6])) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final boolean add(long j) {
        ensureCapacity(this._size + 1);
        long[] jArr = this.content;
        int i = this._size;
        jArr[i] = j;
        this._size = i + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i, long[] jArr) {
        int i6;
        jArr.getClass();
        if (i >= 0 && i <= (i6 = this._size)) {
            if (jArr.length == 0) {
                return false;
            }
            ensureCapacity(i6 + jArr.length);
            long[] jArr2 = this.content;
            int i10 = this._size;
            if (i != i10) {
                j.a0(jArr2, jArr2, jArr.length + i, i, i10);
            }
            j.a0(jArr, jArr2, i, 0, jArr.length);
            this._size += jArr.length;
            return true;
        }
        a.g(this._size, x.p(i, "Index ", " must be in 0.."));
        return false;
    }

    public final boolean addAll(LongList longList) {
        longList.getClass();
        return addAll(this._size, longList);
    }

    public final boolean addAll(long[] jArr) {
        jArr.getClass();
        return addAll(this._size, jArr);
    }
}
