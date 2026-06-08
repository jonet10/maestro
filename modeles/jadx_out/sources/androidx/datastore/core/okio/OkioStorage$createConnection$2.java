package androidx.datastore.core.okio;

import androidx.datastore.core.okio.OkioStorage;
import d7.a;
import java.util.Set;
import kotlin.jvm.internal.m;
import p6.x;
import w8.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class OkioStorage$createConnection$2 extends m implements a {
    final /* synthetic */ OkioStorage<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioStorage$createConnection$2(OkioStorage<T> okioStorage) {
        super(0);
        this.this$0 = okioStorage;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m42invoke() {
        y canonicalPath;
        OkioStorage.Companion companion = OkioStorage.Companion;
        Synchronizer activeFilesLock = companion.getActiveFilesLock();
        OkioStorage<T> okioStorage = this.this$0;
        synchronized (activeFilesLock) {
            Set<String> activeFiles$datastore_core_okio = companion.getActiveFiles$datastore_core_okio();
            canonicalPath = okioStorage.getCanonicalPath();
            activeFiles$datastore_core_okio.remove(canonicalPath.f11005a.t());
        }
    }

    @Override // d7.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m42invoke();
        return x.f8463a;
    }
}
