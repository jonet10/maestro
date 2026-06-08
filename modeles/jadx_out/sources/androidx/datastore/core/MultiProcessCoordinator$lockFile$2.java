package androidx.datastore.core;

import java.io.File;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MultiProcessCoordinator$lockFile$2 extends m implements d7.a {
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProcessCoordinator$lockFile$2(MultiProcessCoordinator multiProcessCoordinator) {
        super(0);
        this.this$0 = multiProcessCoordinator;
    }

    @Override // d7.a
    public final File invoke() {
        String str;
        File fileWithSuffix;
        MultiProcessCoordinator multiProcessCoordinator = this.this$0;
        str = multiProcessCoordinator.LOCK_SUFFIX;
        fileWithSuffix = multiProcessCoordinator.fileWithSuffix(str);
        this.this$0.createIfNotExists(fileWithSuffix);
        return fileWithSuffix;
    }
}
