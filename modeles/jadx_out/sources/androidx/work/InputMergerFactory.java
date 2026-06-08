package androidx.work;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class InputMergerFactory {
    public abstract InputMerger createInputMerger(String str);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final InputMerger createInputMergerWithDefaultFallback(String str) {
        str.getClass();
        InputMerger createInputMerger = createInputMerger(str);
        return createInputMerger == null ? InputMergerKt.fromClassName(str) : createInputMerger;
    }
}
