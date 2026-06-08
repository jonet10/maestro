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
final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final FloatArrayList EMPTY_LIST = new FloatArrayList(new float[0], 0, false);
    private float[] array;
    private int size;

    public FloatArrayList() {
        this(new float[10], 0, true);
    }

    private void addFloat(int i, float f) {
        int i6;
        ensureIsMutable();
        if (i < 0 || i > (i6 = this.size)) {
            a.r(makeOutOfBoundsExceptionMessage(i));
            return;
        }
        float[] fArr = this.array;
        if (i6 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i6 - i);
        } else {
            float[] fArr2 = new float[((i6 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.array, i, fArr2, i + 1, this.size - i);
            this.array = fArr2;
        }
        this.array[i] = f;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    public static FloatArrayList emptyList() {
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
    public boolean add(Float f) {
        addFloat(f.floatValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i = floatArrayList.size;
        if (i == 0) {
            return false;
        }
        int i6 = this.size;
        if (Integer.MAX_VALUE - i6 < i) {
            throw new OutOfMemoryError();
        }
        int i10 = i6 + i;
        float[] fArr = this.array;
        if (i10 > fArr.length) {
            this.array = Arrays.copyOf(fArr, i10);
        }
        System.arraycopy(floatArrayList.array, 0, this.array, this.size, floatArrayList.size);
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
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.size != floatArrayList.size) {
            return false;
        }
        float[] fArr = floatArrayList.array;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.array[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Float get(int i) {
        return Float.valueOf(getFloat(i));
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.FloatList
    public float getFloat(int i) {
        ensureIndexInRange(i);
        return this.array[i];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i6 = 0; i6 < this.size; i6++) {
            i = (i * 31) + Float.floatToIntBits(this.array[i6]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.array[i] == floatValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Float> mutableCopyWithCapacity2(int i) {
        if (i >= this.size) {
            return new FloatArrayList(Arrays.copyOf(this.array, i), this.size, true);
        }
        o.n();
        return null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float remove(int i) {
        ensureIsMutable();
        ensureIndexInRange(i);
        float[] fArr = this.array;
        float f = fArr[i];
        if (i < this.size - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    public void removeRange(int i, int i6) {
        ensureIsMutable();
        if (i6 < i) {
            a.r("toIndex < fromIndex");
            return;
        }
        float[] fArr = this.array;
        System.arraycopy(fArr, i6, fArr, i, this.size - i6);
        this.size -= i6 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float set(int i, Float f) {
        return Float.valueOf(setFloat(i, f.floatValue()));
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.FloatList
    public float setFloat(int i, float f) {
        ensureIsMutable();
        ensureIndexInRange(i);
        float[] fArr = this.array;
        float f10 = fArr[i];
        fArr[i] = f;
        return f10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private FloatArrayList(float[] fArr, int i, boolean z9) {
        super(z9);
        this.array = fArr;
        this.size = i;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, Float f) {
        addFloat(i, f.floatValue());
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.FloatList
    public void addFloat(float f) {
        ensureIsMutable();
        int i = this.size;
        float[] fArr = this.array;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.array = fArr2;
        }
        float[] fArr3 = this.array;
        int i6 = this.size;
        this.size = i6 + 1;
        fArr3[i6] = f;
    }
}
