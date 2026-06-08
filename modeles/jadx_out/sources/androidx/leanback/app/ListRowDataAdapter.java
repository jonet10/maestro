package androidx.leanback.app;

import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Row;
import androidx.lifecycle.l;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class ListRowDataAdapter extends ObjectAdapter {
    public static final int ON_CHANGED = 16;
    public static final int ON_ITEM_RANGE_CHANGED = 2;
    public static final int ON_ITEM_RANGE_INSERTED = 4;
    public static final int ON_ITEM_RANGE_REMOVED = 8;
    private final ObjectAdapter mAdapter;
    final ObjectAdapter.DataObserver mDataObserver;
    int mLastVisibleRowIndex;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class QueueBasedDataObserver extends ObjectAdapter.DataObserver {
        public QueueBasedDataObserver() {
        }

        @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
        public void onChanged() {
            ListRowDataAdapter.this.initialize();
            ListRowDataAdapter.this.notifyChanged();
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class SimpleDataObserver extends ObjectAdapter.DataObserver {
        public SimpleDataObserver() {
        }

        @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
        public void onChanged() {
            ListRowDataAdapter.this.initialize();
            onEventFired(16, -1, -1);
        }

        public void onEventFired(int i, int i6, int i10) {
            ListRowDataAdapter.this.doNotify(i, i6, i10);
        }

        @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
        public void onItemRangeChanged(int i, int i6) {
            int i10 = ListRowDataAdapter.this.mLastVisibleRowIndex;
            if (i <= i10) {
                onEventFired(2, i, Math.min(i6, (i10 - i) + 1));
            }
        }

        @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
        public void onItemRangeInserted(int i, int i6) {
            ListRowDataAdapter listRowDataAdapter = ListRowDataAdapter.this;
            int i10 = listRowDataAdapter.mLastVisibleRowIndex;
            if (i <= i10) {
                listRowDataAdapter.mLastVisibleRowIndex = i10 + i6;
                onEventFired(4, i, i6);
                return;
            }
            listRowDataAdapter.initialize();
            int i11 = ListRowDataAdapter.this.mLastVisibleRowIndex;
            if (i11 > i10) {
                onEventFired(4, i10 + 1, i11 - i10);
            }
        }

        @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
        public void onItemRangeRemoved(int i, int i6) {
            int i10 = (i + i6) - 1;
            ListRowDataAdapter listRowDataAdapter = ListRowDataAdapter.this;
            int i11 = listRowDataAdapter.mLastVisibleRowIndex;
            if (i10 < i11) {
                listRowDataAdapter.mLastVisibleRowIndex = i11 - i6;
                onEventFired(8, i, i6);
                return;
            }
            listRowDataAdapter.initialize();
            int i12 = ListRowDataAdapter.this.mLastVisibleRowIndex;
            int i13 = i11 - i12;
            if (i13 > 0) {
                onEventFired(8, Math.min(i12 + 1, i), i13);
            }
        }
    }

    public ListRowDataAdapter(ObjectAdapter objectAdapter) {
        super(objectAdapter.getPresenterSelector());
        this.mAdapter = objectAdapter;
        initialize();
        if (objectAdapter.isImmediateNotifySupported()) {
            this.mDataObserver = new SimpleDataObserver();
        } else {
            this.mDataObserver = new QueueBasedDataObserver();
        }
        attach();
    }

    public void attach() {
        initialize();
        this.mAdapter.registerObserver(this.mDataObserver);
    }

    public void detach() {
        this.mAdapter.unregisterObserver(this.mDataObserver);
    }

    public void doNotify(int i, int i6, int i10) {
        if (i == 2) {
            notifyItemRangeChanged(i6, i10);
            return;
        }
        if (i == 4) {
            notifyItemRangeInserted(i6, i10);
            return;
        }
        if (i == 8) {
            notifyItemRangeRemoved(i6, i10);
        } else if (i == 16) {
            notifyChanged();
        } else {
            a.p(l.u(i, "Invalid event type "));
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public Object get(int i) {
        return this.mAdapter.get(i);
    }

    public void initialize() {
        this.mLastVisibleRowIndex = -1;
        for (int size = this.mAdapter.size() - 1; size >= 0; size--) {
            if (((Row) this.mAdapter.get(size)).isRenderedAsRowView()) {
                this.mLastVisibleRowIndex = size;
                return;
            }
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        return this.mLastVisibleRowIndex + 1;
    }
}
