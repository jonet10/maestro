package androidx.lifecycle;

import androidx.annotation.MainThread;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LiveDataKt {
    @MainThread
    public static final <T> Observer<T> observe(LiveData<T> liveData, LifecycleOwner lifecycleOwner, final d7.l lVar) {
        liveData.getClass();
        lifecycleOwner.getClass();
        lVar.getClass();
        Observer<T> observer = new Observer() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t9) {
                d7.l.this.invoke(t9);
            }
        };
        liveData.observe(lifecycleOwner, observer);
        return observer;
    }
}
