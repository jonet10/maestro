package androidx.recyclerview.widget;

import a4.x;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.internal.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f470x - diagonal2.f470x;
        }
    };

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i6);

        public abstract boolean areItemsTheSame(int i, int i6);

        @Nullable
        public Object getChangePayload(int i, int i6) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        public CenteredArray(int i) {
            int[] iArr = new int[i];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }

        public int[] backingData() {
            return this.mData;
        }

        public void fill(int i) {
            Arrays.fill(this.mData, i);
        }

        public int get(int i) {
            return this.mData[i + this.mMid];
        }

        public void set(int i, int i6) {
            this.mData[i + this.mMid] = i6;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Diagonal {
        public final int size;

        /* renamed from: x, reason: collision with root package name */
        public final int f470x;

        /* renamed from: y, reason: collision with root package name */
        public final int f471y;

        public Diagonal(int i, int i6, int i10) {
            this.f470x = i;
            this.f471y = i6;
            this.size = i10;
        }

        public int endX() {
            return this.f470x + this.size;
        }

        public int endY() {
            return this.f471y + this.size;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t9, @NonNull T t10);

        public abstract boolean areItemsTheSame(@NonNull T t9, @NonNull T t10);

        @Nullable
        public Object getChangePayload(@NonNull T t9, @NonNull T t10) {
            return null;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i, int i6, boolean z9) {
            this.posInOwnerList = i;
            this.currentPos = i6;
            this.removal = z9;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        public int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        public boolean hasAdditionOrRemoval() {
            return this.endY - this.startY != this.endX - this.startX;
        }

        public boolean isAddition() {
            return this.endY - this.startY > this.endX - this.startX;
        }

        @NonNull
        public Diagonal toDiagonal() {
            if (!hasAdditionOrRemoval()) {
                int i = this.startX;
                return new Diagonal(i, this.startY, this.endX - i);
            }
            if (this.reverse) {
                return new Diagonal(this.startX, this.startY, diagonalSize());
            }
            boolean isAddition = isAddition();
            int i6 = this.startX;
            return isAddition ? new Diagonal(i6, this.startY + 1, diagonalSize()) : new Diagonal(i6 + 1, this.startY, diagonalSize());
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i) {
        int i6;
        int i10;
        int i11;
        boolean z9 = (range.oldSize() - range.newSize()) % 2 == 0;
        int oldSize = range.oldSize() - range.newSize();
        int i12 = -i;
        for (int i13 = i12; i13 <= i; i13 += 2) {
            if (i13 == i12 || (i13 != i && centeredArray2.get(i13 + 1) < centeredArray2.get(i13 - 1))) {
                i6 = centeredArray2.get(i13 + 1);
                i10 = i6;
            } else {
                i6 = centeredArray2.get(i13 - 1);
                i10 = i6 - 1;
            }
            int i14 = range.newListEnd - ((range.oldListEnd - i10) - i13);
            int i15 = (i == 0 || i10 != i6) ? i14 : i14 + 1;
            while (i10 > range.oldListStart && i14 > range.newListStart && callback.areItemsTheSame(i10 - 1, i14 - 1)) {
                i10--;
                i14--;
            }
            centeredArray2.set(i13, i10);
            if (z9 && (i11 = oldSize - i13) >= i12 && i11 <= i && centeredArray.get(i11) >= i10) {
                Snake snake = new Snake();
                snake.startX = i10;
                snake.startY = i14;
                snake.endX = i6;
                snake.endY = i15;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z9) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i);
        CenteredArray centeredArray2 = new CenteredArray(i);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake midPoint = midPoint(range, callback, centeredArray, centeredArray2);
            if (midPoint != null) {
                if (midPoint.diagonalSize() > 0) {
                    arrayList.add(midPoint.toDiagonal());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                range2.oldListEnd = midPoint.startX;
                range2.newListEnd = midPoint.startY;
                arrayList2.add(range2);
                range.oldListEnd = range.oldListEnd;
                range.newListEnd = range.newListEnd;
                range.oldListStart = midPoint.endX;
                range.newListStart = midPoint.endY;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z9);
    }

    @Nullable
    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i) {
        int i6;
        int i10;
        int i11;
        boolean z9 = Math.abs(range.oldSize() - range.newSize()) % 2 == 1;
        int oldSize = range.oldSize() - range.newSize();
        int i12 = -i;
        for (int i13 = i12; i13 <= i; i13 += 2) {
            if (i13 == i12 || (i13 != i && centeredArray.get(i13 + 1) > centeredArray.get(i13 - 1))) {
                i6 = centeredArray.get(i13 + 1);
                i10 = i6;
            } else {
                i6 = centeredArray.get(i13 - 1);
                i10 = i6 + 1;
            }
            int i14 = ((i10 - range.oldListStart) + range.newListStart) - i13;
            int i15 = (i == 0 || i10 != i6) ? i14 : i14 - 1;
            while (i10 < range.oldListEnd && i14 < range.newListEnd && callback.areItemsTheSame(i10, i14)) {
                i10++;
                i14++;
            }
            centeredArray.set(i13, i10);
            if (z9 && (i11 = oldSize - i13) >= i12 + 1 && i11 <= i - 1 && centeredArray2.get(i11) <= i10) {
                Snake snake = new Snake();
                snake.startX = i6;
                snake.startY = i15;
                snake.endX = i10;
                snake.endY = i14;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int oldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i = 0; i < oldSize; i++) {
                Snake forward = forward(range, callback, centeredArray, centeredArray2, i);
                if (forward != null) {
                    return forward;
                }
                Snake backward = backward(range, callback, centeredArray, centeredArray2, i);
                if (backward != null) {
                    return backward;
                }
            }
        }
        return null;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range(int i, int i6, int i10, int i11) {
            this.oldListStart = i;
            this.oldListEnd = i6;
            this.newListStart = i10;
            this.newListEnd = i11;
        }

        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range() {
        }
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        public DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z9) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z9;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
            if (diagonal == null || diagonal.f470x != 0 || diagonal.f471y != 0) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i) {
            int size = this.mDiagonals.size();
            int i6 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                Diagonal diagonal = this.mDiagonals.get(i10);
                while (i6 < diagonal.f471y) {
                    if (this.mNewItemStatuses[i6] == 0 && this.mCallback.areItemsTheSame(i, i6)) {
                        int i11 = this.mCallback.areContentsTheSame(i, i6) ? 8 : 4;
                        this.mOldItemStatuses[i] = (i6 << 4) | i11;
                        this.mNewItemStatuses[i6] = (i << 4) | i11;
                        return;
                    }
                    i6++;
                }
                i6 = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            for (Diagonal diagonal : this.mDiagonals) {
                for (int i = 0; i < diagonal.size; i++) {
                    int i6 = diagonal.f470x + i;
                    int i10 = diagonal.f471y + i;
                    int i11 = this.mCallback.areContentsTheSame(i6, i10) ? 1 : 2;
                    this.mOldItemStatuses[i6] = (i10 << 4) | i11;
                    this.mNewItemStatuses[i10] = (i6 << 4) | i11;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int i = 0;
            for (Diagonal diagonal : this.mDiagonals) {
                while (i < diagonal.f470x) {
                    if (this.mOldItemStatuses[i] == 0) {
                        findMatchingAddition(i);
                    }
                    i++;
                }
                i = diagonal.endX();
            }
        }

        @Nullable
        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i, boolean z9) {
            PostponedUpdate postponedUpdate;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postponedUpdate = null;
                    break;
                }
                postponedUpdate = it.next();
                if (postponedUpdate.posInOwnerList == i && postponedUpdate.removal == z9) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next = it.next();
                if (z9) {
                    next.currentPos--;
                } else {
                    next.currentPos++;
                }
            }
            return postponedUpdate;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i) {
            if (i < 0 || i >= this.mNewListSize) {
                a.g(this.mNewListSize, x.p(i, "Index out of bounds - passed position = ", ", new list size = "));
                return 0;
            }
            int i6 = this.mNewItemStatuses[i];
            if ((i6 & 15) == 0) {
                return -1;
            }
            return i6 >> 4;
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i) {
            if (i < 0 || i >= this.mOldListSize) {
                a.g(this.mOldListSize, x.p(i, "Index out of bounds - passed position = ", ", old list size = "));
                return 0;
            }
            int i6 = this.mOldItemStatuses[i];
            if ((i6 & 15) == 0) {
                return -1;
            }
            return i6 >> 4;
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            int i;
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            int i6 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i10 = this.mOldListSize;
            int i11 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int endX = diagonal.endX();
                int endY = diagonal.endY();
                while (true) {
                    if (i10 <= endX) {
                        break;
                    }
                    i10--;
                    int i12 = this.mOldItemStatuses[i10];
                    if ((i12 & 12) != 0) {
                        int i13 = i12 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i13, false);
                        if (postponedUpdate != null) {
                            int i14 = (i6 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i10, i14);
                            if ((i12 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i14, 1, this.mCallback.getChangePayload(i10, i13));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i10, (i6 - i10) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i10, 1);
                        i6--;
                    }
                }
                while (i11 > endY) {
                    i11--;
                    int i15 = this.mNewItemStatuses[i11];
                    if ((i15 & 12) != 0) {
                        int i16 = i15 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i16, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i11, i6 - i10, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i6 - postponedUpdate2.currentPos) - 1, i10);
                            if ((i15 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i10, 1, this.mCallback.getChangePayload(i16, i11));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i10, 1);
                        i6++;
                    }
                }
                int i17 = diagonal.f470x;
                int i18 = diagonal.f471y;
                for (i = 0; i < diagonal.size; i++) {
                    if ((this.mOldItemStatuses[i17] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i17, 1, this.mCallback.getChangePayload(i17, i18));
                    }
                    i17++;
                    i18++;
                }
                i10 = diagonal.f470x;
                i11 = diagonal.f471y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }
    }
}
