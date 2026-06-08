package p6;

import java.io.Serializable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m implements f, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public d7.a f8448a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f8449b;

    /* renamed from: l, reason: collision with root package name */
    public final Object f8450l;

    public m(d7.a aVar) {
        aVar.getClass();
        this.f8448a = aVar;
        this.f8449b = u.f8460a;
        this.f8450l = this;
    }

    @Override // p6.f
    public final Object getValue() {
        Object obj;
        Object obj2 = this.f8449b;
        u uVar = u.f8460a;
        if (obj2 != uVar) {
            return obj2;
        }
        synchronized (this.f8450l) {
            obj = this.f8449b;
            if (obj == uVar) {
                d7.a aVar = this.f8448a;
                aVar.getClass();
                obj = aVar.invoke();
                this.f8449b = obj;
                this.f8448a = null;
            }
        }
        return obj;
    }

    @Override // p6.f
    public final boolean isInitialized() {
        return this.f8449b != u.f8460a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
