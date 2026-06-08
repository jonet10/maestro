package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class ActivityResultContract<I, O> {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T t9) {
            this.value = t9;
        }

        public final T getValue() {
            return this.value;
        }
    }

    public abstract Intent createIntent(Context context, I i);

    public SynchronousResult<O> getSynchronousResult(Context context, I i) {
        context.getClass();
        return null;
    }

    public abstract O parseResult(int i, Intent intent);
}
