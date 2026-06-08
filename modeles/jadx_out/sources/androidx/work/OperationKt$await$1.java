package androidx.work;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.work.OperationKt", f = "Operation.kt", l = {36}, m = "await")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class OperationKt$await$1 extends v6.c {
    int label;
    /* synthetic */ Object result;

    public OperationKt$await$1(t6.c cVar) {
        super(cVar);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OperationKt.await(null, this);
    }
}
