package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import d7.l;
import j7.c;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewModelInitializer<T extends ViewModel> {
    private final c clazz;
    private final l initializer;

    public ViewModelInitializer(c cVar, l lVar) {
        cVar.getClass();
        lVar.getClass();
        this.clazz = cVar;
        this.initializer = lVar;
    }

    public final c getClazz$lifecycle_viewmodel() {
        return this.clazz;
    }

    public final l getInitializer$lifecycle_viewmodel() {
        return this.initializer;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelInitializer(Class<T> cls, l lVar) {
        this(y.a(cls), lVar);
        cls.getClass();
        lVar.getClass();
    }
}
