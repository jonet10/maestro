package f3;

import java.util.concurrent.atomic.AtomicReference;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class k implements r7.i, kotlin.jvm.internal.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4859a;

    public k(AtomicReference atomicReference) {
        this.f4859a = atomicReference;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        this.f4859a.set((g) obj);
        return x.f8463a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof r7.i) && (obj instanceof kotlin.jvm.internal.h)) {
            return getFunctionDelegate().equals(((kotlin.jvm.internal.h) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.h
    public final p6.c getFunctionDelegate() {
        return new kotlin.jvm.internal.a(this.f4859a);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
