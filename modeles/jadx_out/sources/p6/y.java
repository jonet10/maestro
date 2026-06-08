package p6;

import java.io.Serializable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y implements f, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public d7.a f8464a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8465b;

    @Override // p6.f
    public final Object getValue() {
        if (this.f8465b == u.f8460a) {
            d7.a aVar = this.f8464a;
            aVar.getClass();
            this.f8465b = aVar.invoke();
            this.f8464a = null;
        }
        return this.f8465b;
    }

    @Override // p6.f
    public final boolean isInitialized() {
        return this.f8465b != u.f8460a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
