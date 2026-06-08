package androidx.datastore.core;

import d7.l;
import java.io.File;
import kotlin.jvm.internal.m;
import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MultiProcessDataStoreFactory$create$1 extends m implements l {
    final /* synthetic */ a0 $scope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProcessDataStoreFactory$create$1(a0 a0Var) {
        super(1);
        this.$scope = a0Var;
    }

    @Override // d7.l
    public final InterProcessCoordinator invoke(File file) {
        file.getClass();
        return new MultiProcessCoordinator(this.$scope.getCoroutineContext(), file);
    }
}
