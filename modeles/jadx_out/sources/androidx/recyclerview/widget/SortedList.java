package androidx.recyclerview.widget;

import a4.x;
import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.internal.a;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t22, T2 t23);

        public abstract boolean areItemsTheSame(T2 t22, T2 t23);

        @Override // java.util.Comparator
        public abstract int compare(T2 t22, T2 t23);

        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return null;
        }

        public abstract void onChanged(int i, int i6);

        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i, int i6, Object obj) {
            onChanged(i, i6);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i) {
        this.mTClass = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t9, boolean z9) {
        int findIndexOf = findIndexOf(t9, this.mData, 0, this.mSize, 1);
        if (findIndexOf == -1) {
            findIndexOf = 0;
        } else if (findIndexOf < this.mSize) {
            T t10 = this.mData[findIndexOf];
            if (this.mCallback.areItemsTheSame(t10, t9)) {
                boolean areContentsTheSame = this.mCallback.areContentsTheSame(t10, t9);
                T[] tArr = this.mData;
                if (areContentsTheSame) {
                    tArr[findIndexOf] = t9;
                    return findIndexOf;
                }
                tArr[findIndexOf] = t9;
                Callback callback = this.mCallback;
                callback.onChanged(findIndexOf, 1, callback.getChangePayload(t10, t9));
                return findIndexOf;
            }
        }
        addToData(findIndexOf, t9);
        if (z9) {
            this.mCallback.onInserted(findIndexOf, 1);
        }
        return findIndexOf;
    }

    private void addAllInternal(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int sortAndDedup = sortAndDedup(tArr);
        if (this.mSize != 0) {
            merge(tArr, sortAndDedup);
            return;
        }
        this.mData = tArr;
        this.mSize = sortAndDedup;
        this.mCallback.onInserted(0, sortAndDedup);
    }

    private void addToData(int i, T t9) {
        int i6 = this.mSize;
        if (i > i6) {
            a.g(this.mSize, x.p(i, "cannot add item to ", " because size is "));
            return;
        }
        T[] tArr = this.mData;
        if (i6 == tArr.length) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length + 10));
            System.arraycopy(this.mData, 0, tArr2, 0, i);
            tArr2[i] = t9;
            System.arraycopy(this.mData, i, tArr2, i + 1, this.mSize - i);
            this.mData = tArr2;
        } else {
            System.arraycopy(tArr, i, tArr, i + 1, i6 - i);
            this.mData[i] = t9;
        }
        this.mSize++;
    }

    private T[] copyArray(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int findIndexOf(T t9, T[] tArr, int i, int i6, int i10) {
        while (i < i6) {
            int i11 = (i + i6) / 2;
            T t10 = tArr[i11];
            int compare = this.mCallback.compare(t10, t9);
            if (compare < 0) {
                i = i11 + 1;
            } else {
                if (compare == 0) {
                    if (!this.mCallback.areItemsTheSame(t10, t9)) {
                        int linearEqualitySearch = linearEqualitySearch(t9, i11, i, i6);
                        if (i10 != 1 || linearEqualitySearch != -1) {
                            return linearEqualitySearch;
                        }
                    }
                    return i11;
                }
                i6 = i11;
            }
        }
        if (i10 == 1) {
            return i;
        }
        return -1;
    }

    private int findSameItem(T t9, T[] tArr, int i, int i6) {
        while (i < i6) {
            if (this.mCallback.areItemsTheSame(tArr[i], t9)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int linearEqualitySearch(T t9, int i, int i6, int i10) {
        T t10;
        for (int i11 = i - 1; i11 >= i6; i11--) {
            T t11 = this.mData[i11];
            if (this.mCallback.compare(t11, t9) != 0) {
                break;
            }
            if (this.mCallback.areItemsTheSame(t11, t9)) {
                return i11;
            }
        }
        do {
            i++;
            if (i >= i10) {
                return -1;
            }
            t10 = this.mData[i];
            if (this.mCallback.compare(t10, t9) != 0) {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(t10, t9));
        return i;
    }

    private void merge(T[] tArr, int i) {
        boolean z9 = this.mCallback instanceof BatchedCallback;
        if (!z9) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i6 = 0;
        this.mOldDataStart = 0;
        int i10 = this.mSize;
        this.mOldDataSize = i10;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, i10 + i + 10));
        this.mNewDataStart = 0;
        while (true) {
            int i11 = this.mOldDataStart;
            int i12 = this.mOldDataSize;
            if (i11 >= i12 && i6 >= i) {
                break;
            }
            if (i11 == i12) {
                int i13 = i - i6;
                System.arraycopy(tArr, i6, this.mData, this.mNewDataStart, i13);
                int i14 = this.mNewDataStart + i13;
                this.mNewDataStart = i14;
                this.mSize += i13;
                this.mCallback.onInserted(i14 - i13, i13);
                break;
            }
            T[] tArr2 = this.mOldData;
            if (i6 == i) {
                int i15 = i12 - i11;
                System.arraycopy(tArr2, i11, this.mData, this.mNewDataStart, i15);
                this.mNewDataStart += i15;
                break;
            }
            T t9 = tArr2[i11];
            T t10 = tArr[i6];
            int compare = this.mCallback.compare(t9, t10);
            if (compare > 0) {
                T[] tArr3 = this.mData;
                int i16 = this.mNewDataStart;
                this.mNewDataStart = i16 + 1;
                tArr3[i16] = t10;
                this.mSize++;
                i6++;
                this.mCallback.onInserted(i16, 1);
            } else if (compare == 0 && this.mCallback.areItemsTheSame(t9, t10)) {
                T[] tArr4 = this.mData;
                int i17 = this.mNewDataStart;
                this.mNewDataStart = i17 + 1;
                tArr4[i17] = t10;
                i6++;
                this.mOldDataStart++;
                if (!this.mCallback.areContentsTheSame(t9, t10)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t9, t10));
                }
            } else {
                T[] tArr5 = this.mData;
                int i18 = this.mNewDataStart;
                this.mNewDataStart = i18 + 1;
                tArr5[i18] = t9;
                this.mOldDataStart++;
            }
        }
        this.mOldData = null;
        if (z9) {
            return;
        }
        endBatchedUpdates();
    }

    private boolean remove(T t9, boolean z9) {
        int findIndexOf = findIndexOf(t9, this.mData, 0, this.mSize, 2);
        if (findIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(findIndexOf, z9);
        return true;
    }

    private void removeItemAtIndex(int i, boolean z9) {
        T[] tArr = this.mData;
        System.arraycopy(tArr, i + 1, tArr, i, (this.mSize - i) - 1);
        int i6 = this.mSize - 1;
        this.mSize = i6;
        this.mData[i6] = null;
        if (z9) {
            this.mCallback.onRemoved(i, 1);
        }
    }

    private void replaceAllInsert(T t9) {
        T[] tArr = this.mData;
        int i = this.mNewDataStart;
        tArr[i] = t9;
        this.mNewDataStart = i + 1;
        this.mSize++;
        this.mCallback.onInserted(i, 1);
    }

    private void replaceAllInternal(@NonNull T[] tArr) {
        boolean z9 = this.mCallback instanceof BatchedCallback;
        if (!z9) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int sortAndDedup = sortAndDedup(tArr);
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, sortAndDedup));
        while (true) {
            int i = this.mNewDataStart;
            if (i >= sortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i6 = this.mOldDataStart;
            int i10 = this.mOldDataSize;
            if (i6 >= i10) {
                int i11 = sortAndDedup - i;
                System.arraycopy(tArr, i, this.mData, i, i11);
                this.mNewDataStart += i11;
                this.mSize += i11;
                this.mCallback.onInserted(i, i11);
                break;
            }
            if (i >= sortAndDedup) {
                int i12 = i10 - i6;
                this.mSize -= i12;
                this.mCallback.onRemoved(i, i12);
                break;
            }
            T t9 = this.mOldData[i6];
            T t10 = tArr[i];
            int compare = this.mCallback.compare(t9, t10);
            if (compare < 0) {
                replaceAllRemove();
            } else if (compare > 0) {
                replaceAllInsert(t10);
            } else if (this.mCallback.areItemsTheSame(t9, t10)) {
                T[] tArr2 = this.mData;
                int i13 = this.mNewDataStart;
                tArr2[i13] = t10;
                this.mOldDataStart++;
                this.mNewDataStart = i13 + 1;
                if (!this.mCallback.areContentsTheSame(t9, t10)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t9, t10));
                }
            } else {
                replaceAllRemove();
                replaceAllInsert(t10);
            }
        }
        this.mOldData = null;
        if (z9) {
            return;
        }
        endBatchedUpdates();
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.mCallback);
        int i = 0;
        int i6 = 1;
        for (int i10 = 1; i10 < tArr.length; i10++) {
            T t9 = tArr[i10];
            if (this.mCallback.compare(tArr[i], t9) == 0) {
                int findSameItem = findSameItem(t9, tArr, i, i6);
                if (findSameItem != -1) {
                    tArr[findSameItem] = t9;
                } else {
                    if (i6 != i10) {
                        tArr[i6] = t9;
                    }
                    i6++;
                }
            } else {
                if (i6 != i10) {
                    tArr[i6] = t9;
                }
                i = i6;
                i6++;
            }
        }
        return i6;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData == null) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
    }

    public void addAll(@NonNull T[] tArr, boolean z9) {
        throwIfInMutationOperation();
        if (tArr.length == 0) {
            return;
        }
        if (z9) {
            addAllInternal(tArr);
        } else {
            addAllInternal(copyArray(tArr));
        }
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.mBatchedCallback == null) {
            this.mBatchedCallback = new BatchedCallback(callback);
        }
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int i = this.mSize;
        if (i == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, i, (Object) null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, i);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.mCallback;
        BatchedCallback batchedCallback = this.mBatchedCallback;
        if (callback2 == batchedCallback) {
            this.mCallback = batchedCallback.mWrappedCallback;
        }
    }

    public T get(int i) throws IndexOutOfBoundsException {
        int i6;
        if (i >= this.mSize || i < 0) {
            a.g(this.mSize, x.p(i, "Asked to get item at ", " but size is "));
            return null;
        }
        T[] tArr = this.mOldData;
        return (tArr == null || i < (i6 = this.mNewDataStart)) ? this.mData[i] : tArr[(i - i6) + this.mOldDataStart];
    }

    public int indexOf(T t9) {
        T[] tArr = this.mOldData;
        T[] tArr2 = this.mData;
        if (tArr == null) {
            return findIndexOf(t9, tArr2, 0, this.mSize, 4);
        }
        int findIndexOf = findIndexOf(t9, tArr2, 0, this.mNewDataStart, 4);
        if (findIndexOf != -1) {
            return findIndexOf;
        }
        int findIndexOf2 = findIndexOf(t9, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
        if (findIndexOf2 != -1) {
            return (findIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
        }
        return -1;
    }

    public void recalculatePositionOfItemAt(int i) {
        throwIfInMutationOperation();
        T t9 = get(i);
        removeItemAtIndex(i, false);
        int add = add(t9, false);
        if (i != add) {
            this.mCallback.onMoved(i, add);
        }
    }

    public T removeItemAt(int i) {
        throwIfInMutationOperation();
        T t9 = get(i);
        removeItemAtIndex(i, true);
        return t9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int i, T t9) {
        throwIfInMutationOperation();
        T t10 = get(i);
        boolean z9 = t10 == t9 || !this.mCallback.areContentsTheSame(t10, t9);
        if (t10 != t9 && this.mCallback.compare(t10, t9) == 0) {
            this.mData[i] = t9;
            if (z9) {
                Callback callback = this.mCallback;
                callback.onChanged(i, 1, callback.getChangePayload(t10, t9));
                return;
            }
            return;
        }
        if (z9) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i, 1, callback2.getChangePayload(t10, t9));
        }
        removeItemAtIndex(i, false);
        int add = add(t9, false);
        if (i != add) {
            this.mCallback.onMoved(i, add);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        @SuppressLint({"UnknownNullness"})
        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areContentsTheSame(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areItemsTheSame(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t22, T2 t23) {
            return this.mWrappedCallback.compare(t22, t23);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return this.mWrappedCallback.getChangePayload(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i, int i6) {
            this.mBatchingListUpdateCallback.onChanged(i, i6, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i6) {
            this.mBatchingListUpdateCallback.onInserted(i, i6);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i6) {
            this.mBatchingListUpdateCallback.onMoved(i, i6);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i6) {
            this.mBatchingListUpdateCallback.onRemoved(i, i6);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i, int i6, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i, i6, obj);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    public boolean remove(T t9) {
        throwIfInMutationOperation();
        return remove(t9, true);
    }

    public void replaceAll(@NonNull T[] tArr, boolean z9) {
        throwIfInMutationOperation();
        if (z9) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public int add(T t9) {
        throwIfInMutationOperation();
        return add(t9, true);
    }
}
