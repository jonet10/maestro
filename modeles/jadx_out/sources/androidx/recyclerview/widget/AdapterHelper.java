package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.internal.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class AdapterHelper implements OpReorderer.Callback {
    private static final boolean DEBUG = false;
    static final int POSITION_TYPE_INVISIBLE = 0;
    static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    final Callback mCallback;
    final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    Runnable mOnItemProcessedCallback;
    final OpReorderer mOpReorderer;
    final ArrayList<UpdateOp> mPendingUpdates;
    final ArrayList<UpdateOp> mPostponedList;
    private Pools.Pool<UpdateOp> mUpdateOpPool;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface Callback {
        RecyclerView.ViewHolder findViewHolder(int i);

        void markViewHoldersUpdated(int i, int i6, Object obj);

        void offsetPositionsForAdd(int i, int i6);

        void offsetPositionsForMove(int i, int i6);

        void offsetPositionsForRemovingInvisible(int i, int i6);

        void offsetPositionsForRemovingLaidOutOrNewView(int i, int i6);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class UpdateOp {
        static final int ADD = 1;
        static final int MOVE = 8;
        static final int POOL_SIZE = 30;
        static final int REMOVE = 2;
        static final int UPDATE = 4;
        int cmd;
        int itemCount;
        Object payload;
        int positionStart;

        public UpdateOp(int i, int i6, int i10, Object obj) {
            this.cmd = i;
            this.positionStart = i6;
            this.itemCount = i10;
            this.payload = obj;
        }

        public String cmdToString() {
            int i = this.cmd;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UpdateOp)) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i = this.cmd;
            if (i != updateOp.cmd) {
                return false;
            }
            if (i == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
                return true;
            }
            if (this.itemCount != updateOp.itemCount || this.positionStart != updateOp.positionStart) {
                return false;
            }
            Object obj2 = this.payload;
            Object obj3 = updateOp.payload;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
        }
    }

    public AdapterHelper(Callback callback, boolean z9) {
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.mPendingUpdates = new ArrayList<>();
        this.mPostponedList = new ArrayList<>();
        this.mExistingUpdateTypes = 0;
        this.mCallback = callback;
        this.mDisableRecycler = z9;
        this.mOpReorderer = new OpReorderer(this);
    }

    private void applyAdd(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyMove(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyRemove(UpdateOp updateOp) {
        boolean z9;
        char c9;
        int i = updateOp.positionStart;
        int i6 = updateOp.itemCount + i;
        char c10 = 65535;
        int i10 = i;
        int i11 = 0;
        while (i10 < i6) {
            if (this.mCallback.findViewHolder(i10) != null || canFindInPreLayout(i10)) {
                if (c10 == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(2, i, i11, null));
                    z9 = true;
                } else {
                    z9 = false;
                }
                c9 = 1;
            } else {
                if (c10 == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(2, i, i11, null));
                    z9 = true;
                } else {
                    z9 = false;
                }
                c9 = 0;
            }
            if (z9) {
                i10 -= i11;
                i6 -= i11;
                i11 = 1;
            } else {
                i11++;
            }
            i10++;
            c10 = c9;
        }
        if (i11 != updateOp.itemCount) {
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(2, i, i11, null);
        }
        if (c10 == 0) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private void applyUpdate(UpdateOp updateOp) {
        int i = updateOp.positionStart;
        int i6 = updateOp.itemCount + i;
        int i10 = 0;
        boolean z9 = -1;
        int i11 = i;
        while (i < i6) {
            if (this.mCallback.findViewHolder(i) != null || canFindInPreLayout(i)) {
                if (!z9) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(4, i11, i10, updateOp.payload));
                    i11 = i;
                    i10 = 0;
                }
                z9 = true;
            } else {
                if (z9) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(4, i11, i10, updateOp.payload));
                    i11 = i;
                    i10 = 0;
                }
                z9 = false;
            }
            i10++;
            i++;
        }
        if (i10 != updateOp.itemCount) {
            Object obj = updateOp.payload;
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(4, i11, i10, obj);
        }
        if (z9) {
            postponeAndUpdateViewHolders(updateOp);
        } else {
            dispatchAndUpdateViewHolders(updateOp);
        }
    }

    private boolean canFindInPreLayout(int i) {
        int size = this.mPostponedList.size();
        for (int i6 = 0; i6 < size; i6++) {
            UpdateOp updateOp = this.mPostponedList.get(i6);
            int i10 = updateOp.cmd;
            if (i10 == 8) {
                if (findPositionOffset(updateOp.itemCount, i6 + 1) == i) {
                    return true;
                }
            } else if (i10 == 1) {
                int i11 = updateOp.positionStart;
                int i12 = updateOp.itemCount + i11;
                while (i11 < i12) {
                    if (findPositionOffset(i11, i6 + 1) == i) {
                        return true;
                    }
                    i11++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int i;
        int i6 = updateOp.cmd;
        if (i6 == 1 || i6 == 8) {
            a.p("should not dispatch add or move for pre layout");
            return;
        }
        int updatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, i6);
        int i10 = updateOp.positionStart;
        int i11 = updateOp.cmd;
        if (i11 == 2) {
            i = 0;
        } else {
            if (i11 != 4) {
                c2.a.h(updateOp, "op should be remove or update.");
                return;
            }
            i = 1;
        }
        int i12 = 1;
        for (int i13 = 1; i13 < updateOp.itemCount; i13++) {
            int updatePositionWithPostponed2 = updatePositionWithPostponed((i * i13) + updateOp.positionStart, updateOp.cmd);
            int i14 = updateOp.cmd;
            if (i14 == 2 ? updatePositionWithPostponed2 != updatePositionWithPostponed : !(i14 == 4 && updatePositionWithPostponed2 == updatePositionWithPostponed + 1)) {
                UpdateOp obtainUpdateOp = obtainUpdateOp(i14, updatePositionWithPostponed, i12, updateOp.payload);
                dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp, i10);
                recycleUpdateOp(obtainUpdateOp);
                if (updateOp.cmd == 4) {
                    i10 += i12;
                }
                i12 = 1;
                updatePositionWithPostponed = updatePositionWithPostponed2;
            } else {
                i12++;
            }
        }
        Object obj = updateOp.payload;
        recycleUpdateOp(updateOp);
        if (i12 > 0) {
            UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, i12, obj);
            dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp2, i10);
            recycleUpdateOp(obtainUpdateOp2);
        }
    }

    private void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        this.mPostponedList.add(updateOp);
        int i = updateOp.cmd;
        if (i == 1) {
            this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
            return;
        }
        if (i == 2) {
            this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(updateOp.positionStart, updateOp.itemCount);
            return;
        }
        if (i == 4) {
            this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
        } else if (i == 8) {
            this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
        } else {
            c2.a.h(updateOp, "Unknown update op type for ");
        }
    }

    private int updatePositionWithPostponed(int i, int i6) {
        ArrayList<UpdateOp> arrayList;
        int i10;
        int i11;
        int size = this.mPostponedList.size() - 1;
        while (true) {
            arrayList = this.mPostponedList;
            if (size < 0) {
                break;
            }
            UpdateOp updateOp = arrayList.get(size);
            int i12 = updateOp.cmd;
            int i13 = updateOp.positionStart;
            if (i12 == 8) {
                int i14 = updateOp.itemCount;
                if (i13 < i14) {
                    i11 = i14;
                    i10 = i13;
                } else {
                    i10 = i14;
                    i11 = i13;
                }
                if (i < i10 || i > i11) {
                    if (i < i13) {
                        if (i6 == 1) {
                            updateOp.positionStart = i13 + 1;
                            updateOp.itemCount = i14 + 1;
                        } else if (i6 == 2) {
                            updateOp.positionStart = i13 - 1;
                            updateOp.itemCount = i14 - 1;
                        }
                    }
                } else if (i10 == i13) {
                    if (i6 == 1) {
                        updateOp.itemCount = i14 + 1;
                    } else if (i6 == 2) {
                        updateOp.itemCount = i14 - 1;
                    }
                    i++;
                } else {
                    if (i6 == 1) {
                        updateOp.positionStart = i13 + 1;
                    } else if (i6 == 2) {
                        updateOp.positionStart = i13 - 1;
                    }
                    i--;
                }
            } else if (i13 <= i) {
                if (i12 == 1) {
                    i -= updateOp.itemCount;
                } else if (i12 == 2) {
                    i += updateOp.itemCount;
                }
            } else if (i6 == 1) {
                updateOp.positionStart = i13 + 1;
            } else if (i6 == 2) {
                updateOp.positionStart = i13 - 1;
            }
            size--;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.mPostponedList.get(size2);
            int i15 = updateOp2.cmd;
            int i16 = updateOp2.itemCount;
            if (i15 == 8) {
                if (i16 == updateOp2.positionStart || i16 < 0) {
                    this.mPostponedList.remove(size2);
                    recycleUpdateOp(updateOp2);
                }
            } else if (i16 <= 0) {
                this.mPostponedList.remove(size2);
                recycleUpdateOp(updateOp2);
            }
        }
        return i;
    }

    public AdapterHelper addUpdateOp(UpdateOp... updateOpArr) {
        Collections.addAll(this.mPendingUpdates, updateOpArr);
        return this;
    }

    public int applyPendingUpdatesToPosition(int i) {
        int size = this.mPendingUpdates.size();
        for (int i6 = 0; i6 < size; i6++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i6);
            int i10 = updateOp.cmd;
            if (i10 != 1) {
                if (i10 == 2) {
                    int i11 = updateOp.positionStart;
                    if (i11 <= i) {
                        int i12 = updateOp.itemCount;
                        if (i11 + i12 > i) {
                            return -1;
                        }
                        i -= i12;
                    } else {
                        continue;
                    }
                } else if (i10 == 8) {
                    int i13 = updateOp.positionStart;
                    if (i13 == i) {
                        i = updateOp.itemCount;
                    } else {
                        if (i13 < i) {
                            i--;
                        }
                        if (updateOp.itemCount <= i) {
                            i++;
                        }
                    }
                }
            } else if (updateOp.positionStart <= i) {
                i += updateOp.itemCount;
            }
        }
        return i;
    }

    public void consumePostponedUpdates() {
        int size = this.mPostponedList.size();
        for (int i = 0; i < size; i++) {
            this.mCallback.onDispatchSecondPass(this.mPostponedList.get(i));
        }
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int size = this.mPendingUpdates.size();
        int i = 0;
        while (true) {
            ArrayList<UpdateOp> arrayList = this.mPendingUpdates;
            if (i >= size) {
                recycleUpdateOpsAndClearList(arrayList);
                this.mExistingUpdateTypes = 0;
                return;
            }
            UpdateOp updateOp = arrayList.get(i);
            int i6 = updateOp.cmd;
            if (i6 == 1) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
            } else if (i6 == 2) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForRemovingInvisible(updateOp.positionStart, updateOp.itemCount);
            } else if (i6 == 4) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
            } else if (i6 == 8) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
            }
            Runnable runnable = this.mOnItemProcessedCallback;
            if (runnable != null) {
                runnable.run();
            }
            i++;
        }
    }

    public void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int i) {
        this.mCallback.onDispatchFirstPass(updateOp);
        int i6 = updateOp.cmd;
        if (i6 == 2) {
            this.mCallback.offsetPositionsForRemovingInvisible(i, updateOp.itemCount);
        } else if (i6 == 4) {
            this.mCallback.markViewHoldersUpdated(i, updateOp.itemCount, updateOp.payload);
        } else {
            a.p("only remove and update ops can be dispatched in first pass");
        }
    }

    public int findPositionOffset(int i, int i6) {
        int size = this.mPostponedList.size();
        while (i6 < size) {
            UpdateOp updateOp = this.mPostponedList.get(i6);
            int i10 = updateOp.cmd;
            int i11 = updateOp.positionStart;
            if (i10 == 8) {
                if (i11 == i) {
                    i = updateOp.itemCount;
                } else {
                    if (i11 < i) {
                        i--;
                    }
                    if (updateOp.itemCount <= i) {
                        i++;
                    }
                }
            } else if (i11 > i) {
                continue;
            } else if (i10 == 2) {
                int i12 = updateOp.itemCount;
                if (i < i11 + i12) {
                    return -1;
                }
                i -= i12;
            } else if (i10 == 1) {
                i += updateOp.itemCount;
            }
            i6++;
        }
        return i;
    }

    public boolean hasAnyUpdateTypes(int i) {
        return (i & this.mExistingUpdateTypes) != 0;
    }

    public boolean hasPendingUpdates() {
        return this.mPendingUpdates.size() > 0;
    }

    public boolean hasUpdates() {
        return (this.mPostponedList.isEmpty() || this.mPendingUpdates.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int i, int i6, int i10, Object obj) {
        UpdateOp acquire = this.mUpdateOpPool.acquire();
        if (acquire == null) {
            return new UpdateOp(i, i6, i10, obj);
        }
        acquire.cmd = i;
        acquire.positionStart = i6;
        acquire.itemCount = i10;
        acquire.payload = obj;
        return acquire;
    }

    public boolean onItemRangeChanged(int i, int i6, Object obj) {
        if (i6 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(4, i, i6, obj));
        this.mExistingUpdateTypes |= 4;
        return this.mPendingUpdates.size() == 1;
    }

    public boolean onItemRangeInserted(int i, int i6) {
        if (i6 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(1, i, i6, null));
        this.mExistingUpdateTypes |= 1;
        return this.mPendingUpdates.size() == 1;
    }

    public boolean onItemRangeMoved(int i, int i6, int i10) {
        if (i == i6) {
            return false;
        }
        if (i10 != 1) {
            a.p("Moving more than 1 item is not supported yet");
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(8, i, i6, null));
        this.mExistingUpdateTypes |= 8;
        return this.mPendingUpdates.size() == 1;
    }

    public boolean onItemRangeRemoved(int i, int i6) {
        if (i6 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(2, i, i6, null));
        this.mExistingUpdateTypes |= 2;
        return this.mPendingUpdates.size() == 1;
    }

    public void preProcess() {
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int size = this.mPendingUpdates.size();
        int i = 0;
        while (true) {
            ArrayList<UpdateOp> arrayList = this.mPendingUpdates;
            if (i >= size) {
                arrayList.clear();
                return;
            }
            UpdateOp updateOp = arrayList.get(i);
            int i6 = updateOp.cmd;
            if (i6 == 1) {
                applyAdd(updateOp);
            } else if (i6 == 2) {
                applyRemove(updateOp);
            } else if (i6 == 4) {
                applyUpdate(updateOp);
            } else if (i6 == 8) {
                applyMove(updateOp);
            }
            Runnable runnable = this.mOnItemProcessedCallback;
            if (runnable != null) {
                runnable.run();
            }
            i++;
        }
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp updateOp) {
        if (this.mDisableRecycler) {
            return;
        }
        updateOp.payload = null;
        this.mUpdateOpPool.release(updateOp);
    }

    public void recycleUpdateOpsAndClearList(List<UpdateOp> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            recycleUpdateOp(list.get(i));
        }
        list.clear();
    }

    public void reset() {
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public AdapterHelper(Callback callback) {
        this(callback, false);
    }

    public int findPositionOffset(int i) {
        return findPositionOffset(i, 0);
    }
}
