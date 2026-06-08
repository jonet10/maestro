package androidx.coordinatorlayout.widget;

import a3.b;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import com.google.gson.internal.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DirectedAcyclicGraph<T> {
    private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
    private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    private final ArrayList<T> mSortResult = new ArrayList<>();
    private final HashSet<T> mSortTmpMarked = new HashSet<>();

    private void dfs(T t9, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t9)) {
            return;
        }
        if (hashSet.contains(t9)) {
            b.n("This graph contains cyclic dependencies");
            return;
        }
        hashSet.add(t9);
        ArrayList<T> arrayList2 = this.mGraph.get(t9);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                dfs(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t9);
        arrayList.add(t9);
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> acquire = this.mListPool.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(@NonNull T t9, @NonNull T t10) {
        if (!this.mGraph.containsKey(t9) || !this.mGraph.containsKey(t10)) {
            a.p("All nodes must be present in the graph before being added as an edge");
            return;
        }
        ArrayList<T> arrayList = this.mGraph.get(t9);
        if (arrayList == null) {
            arrayList = getEmptyList();
            this.mGraph.put(t9, arrayList);
        }
        arrayList.add(t10);
    }

    public void addNode(@NonNull T t9) {
        if (this.mGraph.containsKey(t9)) {
            return;
        }
        this.mGraph.put(t9, null);
    }

    public void clear() {
        int size = this.mGraph.size();
        int i = 0;
        while (true) {
            SimpleArrayMap<T, ArrayList<T>> simpleArrayMap = this.mGraph;
            if (i >= size) {
                simpleArrayMap.clear();
                return;
            }
            ArrayList<T> valueAt = simpleArrayMap.valueAt(i);
            if (valueAt != null) {
                poolList(valueAt);
            }
            i++;
        }
    }

    public boolean contains(@NonNull T t9) {
        return this.mGraph.containsKey(t9);
    }

    @Nullable
    public List getIncomingEdges(@NonNull T t9) {
        return this.mGraph.get(t9);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t9) {
        int size = this.mGraph.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i);
            if (valueAt != null && valueAt.contains(t9)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.mGraph.keyAt(i));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.size();
        for (int i = 0; i < size; i++) {
            dfs(this.mGraph.keyAt(i), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T t9) {
        int size = this.mGraph.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i);
            if (valueAt != null && valueAt.contains(t9)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.mGraph.size();
    }
}
