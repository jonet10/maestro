package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    final ListUpdateCallback mWrapped;
    int mLastEventType = 0;
    int mLastEventPosition = -1;
    int mLastEventCount = -1;
    Object mLastEventPayload = null;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i = this.mLastEventType;
        if (i == 0) {
            return;
        }
        if (i == 1) {
            this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
        } else if (i == 2) {
            this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
        } else if (i == 3) {
            this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
        }
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i, int i6, Object obj) {
        int i10;
        if (this.mLastEventType == 3) {
            int i11 = this.mLastEventPosition;
            int i12 = this.mLastEventCount;
            if (i <= i11 + i12 && (i10 = i + i6) >= i11 && this.mLastEventPayload == obj) {
                this.mLastEventPosition = Math.min(i, i11);
                this.mLastEventCount = Math.max(i12 + i11, i10) - this.mLastEventPosition;
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i;
        this.mLastEventCount = i6;
        this.mLastEventPayload = obj;
        this.mLastEventType = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i6) {
        int i10;
        if (this.mLastEventType == 1 && i >= (i10 = this.mLastEventPosition)) {
            int i11 = this.mLastEventCount;
            if (i <= i10 + i11) {
                this.mLastEventCount = i11 + i6;
                this.mLastEventPosition = Math.min(i, i10);
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i;
        this.mLastEventCount = i6;
        this.mLastEventType = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i6) {
        dispatchLastEvent();
        this.mWrapped.onMoved(i, i6);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i6) {
        int i10;
        if (this.mLastEventType == 2 && (i10 = this.mLastEventPosition) >= i && i10 <= i + i6) {
            this.mLastEventCount += i6;
            this.mLastEventPosition = i;
        } else {
            dispatchLastEvent();
            this.mLastEventPosition = i;
            this.mLastEventCount = i6;
            this.mLastEventType = 2;
        }
    }
}
