package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.room.f;
import d7.l;
import java.util.LinkedHashMap;
import java.util.Map;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CreationExtrasKt {
    public static final CreationExtras CreationExtras(CreationExtras creationExtras, l lVar) {
        creationExtras.getClass();
        lVar.getClass();
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(creationExtras);
        lVar.invoke(mutableCreationExtras);
        return mutableCreationExtras;
    }

    public static /* synthetic */ CreationExtras CreationExtras$default(CreationExtras creationExtras, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            creationExtras = CreationExtras.Empty.INSTANCE;
        }
        if ((i & 2) != 0) {
            lVar = new f(26);
        }
        return CreationExtras(creationExtras, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x CreationExtras$lambda$0(MutableCreationExtras mutableCreationExtras) {
        mutableCreationExtras.getClass();
        return x.f8463a;
    }

    public static final boolean contains(CreationExtras creationExtras, CreationExtras.Key<?> key) {
        creationExtras.getClass();
        key.getClass();
        return creationExtras.getExtras$lifecycle_viewmodel().containsKey(key);
    }

    public static final MutableCreationExtras plus(CreationExtras creationExtras, CreationExtras creationExtras2) {
        creationExtras.getClass();
        creationExtras2.getClass();
        Map<CreationExtras.Key<?>, Object> extras$lifecycle_viewmodel = creationExtras.getExtras$lifecycle_viewmodel();
        Map<CreationExtras.Key<?>, Object> extras$lifecycle_viewmodel2 = creationExtras2.getExtras$lifecycle_viewmodel();
        extras$lifecycle_viewmodel.getClass();
        extras$lifecycle_viewmodel2.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(extras$lifecycle_viewmodel);
        linkedHashMap.putAll(extras$lifecycle_viewmodel2);
        return new MutableCreationExtras(linkedHashMap);
    }

    public static final void plusAssign(MutableCreationExtras mutableCreationExtras, CreationExtras creationExtras) {
        mutableCreationExtras.getClass();
        creationExtras.getClass();
        mutableCreationExtras.getExtras$lifecycle_viewmodel().putAll(creationExtras.getExtras$lifecycle_viewmodel());
    }

    public static final CreationExtras CreationExtras(CreationExtras creationExtras) {
        creationExtras.getClass();
        return CreationExtras$default(creationExtras, null, 2, null);
    }

    public static final CreationExtras CreationExtras() {
        return CreationExtras$default(null, null, 3, null);
    }
}
