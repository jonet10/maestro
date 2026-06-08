package androidx.datastore.core.okio;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.okio.OkioReadScope", f = "OkioStorage.kt", l = {SubsamplingScaleImageView.ORIENTATION_180, 187}, m = "readData$suspendImpl")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class OkioReadScope$readData$1<T> extends c {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkioReadScope<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioReadScope$readData$1(OkioReadScope<T> okioReadScope, t6.c cVar) {
        super(cVar);
        this.this$0 = okioReadScope;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OkioReadScope.readData$suspendImpl(this.this$0, this);
    }
}
