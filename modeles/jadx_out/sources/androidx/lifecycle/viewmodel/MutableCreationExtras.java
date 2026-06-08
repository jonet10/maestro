package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.Map;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras(Map<CreationExtras.Key<?>, ? extends Object> map) {
        map.getClass();
        getExtras$lifecycle_viewmodel().putAll(map);
    }

    @Override // androidx.lifecycle.viewmodel.CreationExtras
    public <T> T get(CreationExtras.Key<T> key) {
        key.getClass();
        return (T) getExtras$lifecycle_viewmodel().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void set(CreationExtras.Key<T> key, T t9) {
        key.getClass();
        getExtras$lifecycle_viewmodel().put(key, t9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MutableCreationExtras() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MutableCreationExtras(CreationExtras creationExtras) {
        this((Map<CreationExtras.Key<?>, ? extends Object>) creationExtras.getExtras$lifecycle_viewmodel());
        creationExtras.getClass();
    }

    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i, g gVar) {
        this((i & 1) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }
}
