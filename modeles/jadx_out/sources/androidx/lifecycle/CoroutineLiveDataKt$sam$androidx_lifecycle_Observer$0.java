package androidx.lifecycle;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0 implements Observer, kotlin.jvm.internal.h {
    private final /* synthetic */ d7.l function;

    public CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(d7.l lVar) {
        lVar.getClass();
        this.function = lVar;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.h)) {
            return kotlin.jvm.internal.l.a(getFunctionDelegate(), ((kotlin.jvm.internal.h) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.h
    public final p6.c getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
