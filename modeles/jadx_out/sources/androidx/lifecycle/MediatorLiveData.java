package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<? super V> mObserver;
        int mVersion = -1;

        public Source(LiveData<V> liveData, Observer<? super V> observer) {
            this.mLiveData = liveData;
            this.mObserver = observer;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(V v) {
            if (this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(v);
            }
        }

        public void plug() {
            this.mLiveData.observeForever(this);
        }

        public void unplug() {
            this.mLiveData.removeObserver(this);
        }
    }

    public MediatorLiveData() {
        this.mSources = new SafeIterableMap<>();
    }

    @MainThread
    public <S> void addSource(LiveData<S> liveData, Observer<? super S> observer) {
        if (liveData == null) {
            com.google.gson.internal.a.i("source cannot be null");
            return;
        }
        Source<?> source = new Source<>(liveData, observer);
        Source<?> putIfAbsent = this.mSources.putIfAbsent(liveData, source);
        if (putIfAbsent != null && putIfAbsent.mObserver != observer) {
            com.google.gson.internal.a.p("This source was already added with the different observer");
        } else if (putIfAbsent == null && hasActiveObservers()) {
            source.plug();
        }
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().plug();
        }
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().unplug();
        }
    }

    @MainThread
    public <S> void removeSource(LiveData<S> liveData) {
        Source<?> remove = this.mSources.remove(liveData);
        if (remove != null) {
            remove.unplug();
        }
    }

    public MediatorLiveData(T t9) {
        super(t9);
        this.mSources = new SafeIterableMap<>();
    }
}
