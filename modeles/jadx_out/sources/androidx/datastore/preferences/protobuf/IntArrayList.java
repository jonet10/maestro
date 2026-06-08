package androidx.datastore.preferences.protobuf;

import a4.x;
import androidx.datastore.preferences.protobuf.Internal;
import com.google.gson.internal.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final IntArrayList EMPTY_LIST = new IntArrayList(new int[0], 0, false);
    private int[] array;
    private int size;

    public IntArrayList() {
        this(new int[10], 0, true);
    }

    private void addInt(int i, int i6) {
        int i10;
        ensureIsMutable();
        if (i < 0 || i > (i10 = this.size)) {
            a.r(makeOutOfBoundsExceptionMessage(i));
            return;
        }
        int[] iArr = this.array;
        if (i10 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i10 - i);
        } else {
            int[] iArr2 = new int[((i10 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.array, i, iArr2, i + 1, this.size - i);
            this.array = iArr2;
        }
        this.array[i] = i6;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    public static IntArrayList emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int i) {
        if (i < 0 || i >= this.size) {
            a.r(makeOutOfBoundsExceptionMessage(i));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i) {
        StringBuilder p10 = x.p(i, "Index:", ", Size:");
        p10.append(this.size);
        return p10.toString();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i = intArrayList.size;
        if (i == 0) {
            return false;
        }
        int i6 = this.size;
        if (Integer.MAX_VALUE - i6 < i) {
            throw new OutOfMemoryError();
        }
        int i10 = i6 + i;
        int[] iArr = this.array;
        if (i10 > iArr.length) {
            this.array = Arrays.copyOf(iArr, i10);
        }
        System.arraycopy(intArrayList.array, 0, this.array, this.size, intArrayList.size);
        this.size = i10;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.size != intArrayList.size) {
            return false;
        }
        int[] iArr = intArrayList.array;
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int i) {
        return Integer.valueOf(getInt(i));
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.IntList
    public int getInt(int i) {
        ensureIndexInRange(i);
        return this.array[i];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i6 = 0; i6 < this.size; i6++) {
            i = (i * 31) + this.array[i6];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.array[i] == intValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Integer> mutableCopyWithCapacity2(int i) {
        if (i >= this.size) {
            return new IntArrayList(Arrays.copyOf(this.array, i), this.size, true);
        }
        o.n();
        return null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer remove(int i) {
        ensureIsMutable();
        ensureIndexInRange(i);
        int[] iArr = this.array;
        int i6 = iArr[i];
        if (i < this.size - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractList
    public void removeRange(int i, int i6) {
        ensureIsMutable();
        if (i6 < i) {
            a.r("toIndex < fromIndex");
            return;
        }
        int[] iArr = this.array;
        System.arraycopy(iArr, i6, iArr, i, this.size - i6);
        this.size -= i6 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer set(int i, Integer num) {
        return Integer.valueOf(setInt(i, num.intValue()));
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.IntList
    public int setInt(int i, int i6) {
        ensureIsMutable();
        ensureIndexInRange(i);
        int[] iArr = this.array;
        int i10 = iArr[i];
        iArr[i] = i6;
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private IntArrayList(int[] iArr, int i, boolean z9) {
        super(z9);
        this.array = iArr;
        this.size = i;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, Integer num) {
        addInt(i, num.intValue());
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.IntList
    public void addInt(int i) {
        ensureIsMutable();
        int i6 = this.size;
        int[] iArr = this.array;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[((i6 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.array = iArr2;
        }
        int[] iArr3 = this.array;
        int i10 = this.size;
        this.size = i10 + 1;
        iArr3[i10] = i;
    }
}
