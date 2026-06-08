package androidx.datastore.core;

import androidx.datastore.core.SharedCounter;
import java.io.File;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MultiProcessCoordinator$lazySharedCounter$1 extends m implements d7.a {
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.datastore.core.MultiProcessCoordinator$lazySharedCounter$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements d7.a {
        final /* synthetic */ MultiProcessCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MultiProcessCoordinator multiProcessCoordinator) {
            super(0);
            this.this$0 = multiProcessCoordinator;
        }

        @Override // d7.a
        public final File invoke() {
            String str;
            File fileWithSuffix;
            MultiProcessCoordinator multiProcessCoordinator = this.this$0;
            str = multiProcessCoordinator.VERSION_SUFFIX;
            fileWithSuffix = multiProcessCoordinator.fileWithSuffix(str);
            this.this$0.createIfNotExists(fileWithSuffix);
            return fileWithSuffix;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProcessCoordinator$lazySharedCounter$1(MultiProcessCoordinator multiProcessCoordinator) {
        super(0);
        this.this$0 = multiProcessCoordinator;
    }

    @Override // d7.a
    public final SharedCounter invoke() {
        SharedCounter.Factory factory = SharedCounter.Factory;
        factory.loadLib();
        return factory.create$datastore_core_release(new AnonymousClass1(this.this$0));
    }
}
