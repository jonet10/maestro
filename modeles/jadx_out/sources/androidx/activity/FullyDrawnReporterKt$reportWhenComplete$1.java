package androidx.activity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", l = {185}, m = "reportWhenComplete")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FullyDrawnReporterKt$reportWhenComplete$1 extends v6.c {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public FullyDrawnReporterKt$reportWhenComplete$1(t6.c cVar) {
        super(cVar);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FullyDrawnReporterKt.reportWhenComplete(null, null, this);
    }
}
