package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class PathMotion {
    public PathMotion() {
    }

    @NonNull
    public abstract Path getPath(float f, float f10, float f11, float f12);

    public PathMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
    }
}
