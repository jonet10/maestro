package androidx.activity.contextaware;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ContextAwareHelper {
    private volatile Context context;
    private final Set<OnContextAvailableListener> listeners = new CopyOnWriteArraySet();

    public final void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        onContextAvailableListener.getClass();
        Context context = this.context;
        if (context != null) {
            onContextAvailableListener.onContextAvailable(context);
        }
        this.listeners.add(onContextAvailableListener);
    }

    public final void clearAvailableContext() {
        this.context = null;
    }

    public final void dispatchOnContextAvailable(Context context) {
        context.getClass();
        this.context = context;
        Iterator<OnContextAvailableListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onContextAvailable(context);
        }
    }

    public final Context peekAvailableContext() {
        return this.context;
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        onContextAvailableListener.getClass();
        this.listeners.remove(onContextAvailableListener);
    }
}
