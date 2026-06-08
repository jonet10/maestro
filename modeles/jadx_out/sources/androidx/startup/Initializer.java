package androidx.startup;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface Initializer<T> {
    @NonNull
    T create(@NonNull Context context);

    @NonNull
    List<Class<? extends Initializer<?>>> dependencies();
}
