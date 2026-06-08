package androidx.tracing;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.tracing.TraceKt", f = "Trace.kt", l = {76}, m = "traceAsync")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TraceKt$traceAsync$1<T> extends c {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public TraceKt$traceAsync$1(t6.c cVar) {
        super(cVar);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TraceKt.traceAsync(null, 0, null, this);
    }
}
