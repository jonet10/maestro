package androidx.datastore.core.okio;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", l = {236, 137}, m = "writeScope")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class OkioStorageConnection$writeScope$1 extends c {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkioStorageConnection<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioStorageConnection$writeScope$1(OkioStorageConnection<T> okioStorageConnection, t6.c cVar) {
        super(cVar);
        this.this$0 = okioStorageConnection;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeScope(null, this);
    }
}
