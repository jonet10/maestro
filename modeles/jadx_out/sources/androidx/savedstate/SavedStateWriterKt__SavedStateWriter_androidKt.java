package androidx.savedstate;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final /* synthetic */ class SavedStateWriterKt__SavedStateWriter_androidKt {
    public static final <T> ArrayList<T> toArrayListUnsafe(Collection<?> collection) {
        collection.getClass();
        return collection instanceof ArrayList ? (ArrayList) collection : new ArrayList<>(collection);
    }
}
