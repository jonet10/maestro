package androidx.room;

import androidx.room.InvalidationTracker;
import java.lang.ref.WeakReference;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WeakObserver extends InvalidationTracker.Observer {
    private final WeakReference<InvalidationTracker.Observer> delegateRef;
    private final InvalidationTracker tracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeakObserver(InvalidationTracker invalidationTracker, InvalidationTracker.Observer observer) {
        super(observer.getTables$room_runtime_release());
        invalidationTracker.getClass();
        observer.getClass();
        this.tracker = invalidationTracker;
        this.delegateRef = new WeakReference<>(observer);
    }

    @Override // androidx.room.InvalidationTracker.Observer
    public void onInvalidated(Set<String> set) {
        set.getClass();
        InvalidationTracker.Observer observer = this.delegateRef.get();
        if (observer == null) {
            this.tracker.removeObserver(this);
        } else {
            observer.onInvalidated(set);
        }
    }
}
