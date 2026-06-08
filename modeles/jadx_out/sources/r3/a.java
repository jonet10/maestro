package r3;

import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f8858a = new HashMap();

    @Override // r3.b
    public final boolean a(String str) {
        return this.f8858a.containsKey(str);
    }

    public final void b(String str, o3.a aVar) {
        this.f8858a.put(str, aVar);
    }

    public final void c(b bVar) {
        HashMap hashMap = this.f8858a;
        hashMap.clear();
        hashMap.putAll(bVar.getAll());
    }

    @Override // r3.b
    public final o3.b get(String str) {
        return (o3.a) this.f8858a.get(str);
    }

    @Override // r3.b
    public final HashMap getAll() {
        return new HashMap(this.f8858a);
    }
}
