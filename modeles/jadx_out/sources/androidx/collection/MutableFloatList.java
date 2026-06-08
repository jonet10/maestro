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
public final class MutableFloatList extends FloatList {
    public /* synthetic */ MutableFloatList(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 16 : i);
    }

    public static /* synthetic */ void trim$default(MutableFloatList mutableFloatList, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = mutableFloatList._size;
        }
        mutableFloatList.trim(i);
    }

    public final void add(@IntRange(from = 0) int i, float f) {
        int i6;
        if (i < 0 || i > (i6 = this._size)) {
            a.g(this._size, x.p(i, "Index ", " must be in 0.."));
            return;
        }
        ensureCapacity(i6 + 1);
        float[] fArr = this.content;
        int i10 = this._size;
        if (i != i10) {
            j.Z(fArr, i + 1, fArr, i, i10);
        }
        fArr[i] = f;
        this._size++;
    }

    public final boolean addAll(@IntRange(from = 0) int i, FloatList floatList) {
        floatList.getClass();
        if (i < 0 || i > this._size) {
            a.g(this._size, x.p(i, "Index ", " must be in 0.."));
            return false;
        }
        if (floatList.isEmpty()) {
            return false;
        }
        ensureCapacity(this._size + floatList._size);
        float[] fArr = this.content;
        int i6 = this._size;
        if (i != i6) {
            j.Z(fArr, floatList._size + i, fArr, i, i6);
        }
        j.Z(floatList.content, i, fArr, 0, floatList._size);
        this._size += floatList._size;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i) {
        float[] fArr = this.content;
        if (fArr.length < i) {
            this.content = Arrays.copyOf(fArr, Math.max(i, (fArr.length * 3) / 2));
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(FloatList floatList) {
        floatList.getClass();
        float[] fArr = floatList.content;
        int i = floatList._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(fArr[i6]);
        }
    }

    public final void plusAssign(FloatList floatList) {
        floatList.getClass();
        addAll(this._size, floatList);
    }

    public final boolean remove(float f) {
        int indexOf = indexOf(f);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(FloatList floatList) {
        floatList.getClass();
        int i = this._size;
        int i6 = floatList._size - 1;
        if (i6 >= 0) {
            int i10 = 0;
            while (true) {
                remove(floatList.get(i10));
                if (i10 == i6) {
                    break;
                }
                i10++;
            }
        }
        return i != this._size;
    }

    public final float removeAt(@IntRange(from = 0) int i) {
        int i6;
        if (i < 0 || i >= (i6 = this._size)) {
            a.g(this._size - 1, x.p(i, "Index ", " must be in 0.."));
            return 0.0f;
        }
        float[] fArr = this.content;
        float f = fArr[i];
        if (i != i6 - 1) {
            j.Z(fArr, i, fArr, i + 1, i6);
        }
        this._size--;
        return f;
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
                float[] fArr = this.content;
                j.Z(fArr, i, fArr, i6, i10);
            }
            this._size -= i6 - i;
        }
    }

    public final boolean retainAll(float[] fArr) {
        fArr.getClass();
        int i = this._size;
        float[] fArr2 = this.content;
        int i6 = i - 1;
        while (true) {
            int i10 = 0;
            int i11 = -1;
            if (-1 >= i6) {
                break;
            }
            float f = fArr2[i6];
            int length = fArr.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (fArr[i10] == f) {
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

    public final float set(@IntRange(from = 0) int i, float f) {
        if (i < 0 || i >= this._size) {
            a.g(this._size - 1, x.p(i, "set index ", " must be between 0 .. "));
            return 0.0f;
        }
        float[] fArr = this.content;
        float f10 = fArr[i];
        fArr[i] = f;
        return f10;
    }

    public final void sort() {
        float[] fArr = this.content;
        int i = this._size;
        fArr.getClass();
        Arrays.sort(fArr, 0, i);
    }

    public final void sortDescending() {
        float[] fArr = this.content;
        int i = this._size;
        fArr.getClass();
        Arrays.sort(fArr, 0, i);
        q6.b bVar = e.Companion;
        int length = fArr.length;
        bVar.getClass();
        q6.b.d(0, i, length);
        int i6 = i / 2;
        if (i6 == 0) {
            return;
        }
        int i10 = i - 1;
        for (int i11 = 0; i11 < i6; i11++) {
            float f = fArr[i11];
            fArr[i11] = fArr[i10];
            fArr[i10] = f;
            i10--;
        }
    }

    public final void trim(int i) {
        int max = Math.max(i, this._size);
        float[] fArr = this.content;
        if (fArr.length > max) {
            this.content = Arrays.copyOf(fArr, max);
        }
    }

    public final void plusAssign(float[] fArr) {
        fArr.getClass();
        addAll(this._size, fArr);
    }

    public MutableFloatList() {
        this(0, 1, null);
    }

    public final void plusAssign(float f) {
        add(f);
    }

    public MutableFloatList(int i) {
        super(i, null);
    }

    public final void minusAssign(float[] fArr) {
        fArr.getClass();
        for (float f : fArr) {
            remove(f);
        }
    }

    public final void minusAssign(float f) {
        remove(f);
    }

    public final boolean removeAll(float[] fArr) {
        fArr.getClass();
        int i = this._size;
        for (float f : fArr) {
            remove(f);
        }
        return i != this._size;
    }

    public final boolean retainAll(FloatList floatList) {
        floatList.getClass();
        int i = this._size;
        float[] fArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (!floatList.contains(fArr[i6])) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final boolean add(float f) {
        ensureCapacity(this._size + 1);
        float[] fArr = this.content;
        int i = this._size;
        fArr[i] = f;
        this._size = i + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i, float[] fArr) {
        int i6;
        fArr.getClass();
        if (i >= 0 && i <= (i6 = this._size)) {
            if (fArr.length == 0) {
                return false;
            }
            ensureCapacity(i6 + fArr.length);
            float[] fArr2 = this.content;
            int i10 = this._size;
            if (i != i10) {
                j.Z(fArr2, fArr.length + i, fArr2, i, i10);
            }
            j.Z(fArr, i, fArr2, 0, fArr.length);
            this._size += fArr.length;
            return true;
        }
        a.g(this._size, x.p(i, "Index ", " must be in 0.."));
        return false;
    }

    public final boolean addAll(FloatList floatList) {
        floatList.getClass();
        return addAll(this._size, floatList);
    }

    public final boolean addAll(float[] fArr) {
        fArr.getClass();
        return addAll(this._size, fArr);
    }
}
