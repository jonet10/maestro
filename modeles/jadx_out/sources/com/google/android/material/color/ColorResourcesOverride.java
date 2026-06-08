package com.google.android.material.color;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface ColorResourcesOverride {
    boolean applyIfPossible(@NonNull Context context, @NonNull Map<Integer, Integer> map);

    @NonNull
    Context wrapContextIfPossible(@NonNull Context context, @NonNull Map<Integer, Integer> map);
}
