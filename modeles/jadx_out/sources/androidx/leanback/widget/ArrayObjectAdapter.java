package androidx.leanback.widget;

import android.util.Log;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ArrayObjectAdapter extends ObjectAdapter {
    private static final Boolean DEBUG = Boolean.FALSE;
    private static final String TAG = "ArrayObjectAdapter";
    private final List<Object> mItems;
    ListUpdateCallback mListUpdateCallback;
    final List<Object> mOldItems;
    private List<?> mUnmodifiableItems;

    public ArrayObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
        this.mItems = new ArrayList();
        this.mOldItems = new ArrayList();
    }

    public void add(Object obj) {
        add(this.mItems.size(), obj);
    }

    public void addAll(int i, Collection<?> collection) {
        int size = collection.size();
        if (size == 0) {
            return;
        }
        this.mItems.addAll(i, collection);
        notifyItemRangeInserted(i, size);
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
        return this.mItems.get(i);
    }

    public int indexOf(Object obj) {
        return this.mItems.indexOf(obj);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public boolean isImmediateNotifySupported() {
        return true;
    }

    public void move(int i, int i6) {
        if (i == i6) {
            return;
        }
        this.mItems.add(i6, this.mItems.remove(i));
        notifyItemMoved(i, i6);
    }

    public void notifyArrayItemRangeChanged(int i, int i6) {
        notifyItemRangeChanged(i, i6);
    }

    public boolean remove(Object obj) {
        int indexOf = this.mItems.indexOf(obj);
        if (indexOf >= 0) {
            this.mItems.remove(indexOf);
            notifyItemRangeRemoved(indexOf, 1);
        }
        return indexOf >= 0;
    }

    public int removeItems(int i, int i6) {
        int min = Math.min(i6, this.mItems.size() - i);
        if (min <= 0) {
            return 0;
        }
        for (int i10 = 0; i10 < min; i10++) {
            this.mItems.remove(i);
        }
        notifyItemRangeRemoved(i, min);
        return min;
    }

    public void replace(int i, Object obj) {
        this.mItems.set(i, obj);
        notifyItemRangeChanged(i, 1);
    }

    public void setItems(final List list, final DiffCallback diffCallback) {
        if (diffCallback == null) {
            this.mItems.clear();
            this.mItems.addAll(list);
            notifyChanged();
            return;
        }
        this.mOldItems.clear();
        this.mOldItems.addAll(this.mItems);
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: androidx.leanback.widget.ArrayObjectAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i6) {
                return diffCallback.areContentsTheSame(ArrayObjectAdapter.this.mOldItems.get(i), list.get(i6));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i6) {
                return diffCallback.areItemsTheSame(ArrayObjectAdapter.this.mOldItems.get(i), list.get(i6));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public Object getChangePayload(int i, int i6) {
                return diffCallback.getChangePayload(ArrayObjectAdapter.this.mOldItems.get(i), list.get(i6));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return list.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return ArrayObjectAdapter.this.mOldItems.size();
            }
        });
        this.mItems.clear();
        this.mItems.addAll(list);
        if (this.mListUpdateCallback == null) {
            this.mListUpdateCallback = new ListUpdateCallback() { // from class: androidx.leanback.widget.ArrayObjectAdapter.2
                @Override // androidx.recyclerview.widget.ListUpdateCallback
                public void onChanged(int i, int i6, Object obj) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onChanged");
                    }
                    ArrayObjectAdapter.this.notifyItemRangeChanged(i, i6, obj);
                }

                @Override // androidx.recyclerview.widget.ListUpdateCallback
                public void onInserted(int i, int i6) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onInserted");
                    }
                    ArrayObjectAdapter.this.notifyItemRangeInserted(i, i6);
                }

                @Override // androidx.recyclerview.widget.ListUpdateCallback
                public void onMoved(int i, int i6) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onMoved");
                    }
                    ArrayObjectAdapter.this.notifyItemMoved(i, i6);
                }

                @Override // androidx.recyclerview.widget.ListUpdateCallback
                public void onRemoved(int i, int i6) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onRemoved");
                    }
                    ArrayObjectAdapter.this.notifyItemRangeRemoved(i, i6);
                }
            };
        }
        calculateDiff.dispatchUpdatesTo(this.mListUpdateCallback);
        this.mOldItems.clear();
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        return this.mItems.size();
    }

    public <E> List<E> unmodifiableList() {
        if (this.mUnmodifiableItems == null) {
            this.mUnmodifiableItems = DesugarCollections.unmodifiableList(this.mItems);
        }
        return (List<E>) this.mUnmodifiableItems;
    }

    public void add(int i, Object obj) {
        this.mItems.add(i, obj);
        notifyItemRangeInserted(i, 1);
    }

    public ArrayObjectAdapter(Presenter presenter) {
        super(presenter);
        this.mItems = new ArrayList();
        this.mOldItems = new ArrayList();
    }

    public ArrayObjectAdapter() {
        this.mItems = new ArrayList();
        this.mOldItems = new ArrayList();
    }
}
