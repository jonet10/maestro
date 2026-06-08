package androidx.transition;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.google.android.material.color.utilities.Contrast;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface TransitionSeekController {
    void addOnProgressChangedListener(@NonNull Consumer<TransitionSeekController> consumer);

    void addOnReadyListener(@NonNull Consumer<TransitionSeekController> consumer);

    void animateToEnd();

    void animateToStart(@NonNull Runnable runnable);

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    float getCurrentFraction();

    @IntRange(from = 0)
    long getCurrentPlayTimeMillis();

    @IntRange(from = 0)
    long getDurationMillis();

    boolean isReady();

    void removeOnProgressChangedListener(@NonNull Consumer<TransitionSeekController> consumer);

    void removeOnReadyListener(@NonNull Consumer<TransitionSeekController> consumer);

    void setCurrentFraction(@FloatRange(from = 0.0d, to = 1.0d) float f);

    void setCurrentPlayTimeMillis(@IntRange(from = 0) long j);
}
