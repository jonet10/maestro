package androidx.leanback.widget;

import android.util.SparseArray;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class SparseArrayObjectAdapter extends ObjectAdapter {
    private SparseArray<Object> mItems;

    public SparseArrayObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
        this.mItems = new SparseArray<>();
    }

    public void clear() {
        int size = this.mItems.size();
        if (size == 0) {
            return;
        }
        this.mItems.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public Object get(int i) {
        return this.mItems.valueAt(i);
    }

    public int indexOf(Object obj) {
        return this.mItems.indexOfValue(obj);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public boolean isImmediateNotifySupported() {
        return true;
    }

    public Object lookup(int i) {
        return this.mItems.get(i);
    }

    public void notifyArrayItemRangeChanged(int i, int i6) {
        notifyItemRangeChanged(i, i6);
    }

    public void set(int i, Object obj) {
        int indexOfKey = this.mItems.indexOfKey(i);
        SparseArray<Object> sparseArray = this.mItems;
        if (indexOfKey < 0) {
            sparseArray.append(i, obj);
            notifyItemRangeInserted(this.mItems.indexOfKey(i), 1);
        } else if (sparseArray.valueAt(indexOfKey) != obj) {
            this.mItems.setValueAt(indexOfKey, obj);
            notifyItemRangeChanged(indexOfKey, 1);
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        return this.mItems.size();
    }

    public int indexOf(int i) {
        return this.mItems.indexOfKey(i);
    }

    public SparseArrayObjectAdapter(Presenter presenter) {
        super(presenter);
        this.mItems = new SparseArray<>();
    }

    public SparseArrayObjectAdapter() {
        this.mItems = new SparseArray<>();
    }

    public void clear(int i) {
        int indexOfKey = this.mItems.indexOfKey(i);
        if (indexOfKey >= 0) {
            this.mItems.removeAt(indexOfKey);
            notifyItemRangeRemoved(indexOfKey, 1);
        }
    }
}
