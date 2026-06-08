package r3;

import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f8859a;

    @Override // r3.b
    public final boolean a(String str) {
        return this.f8859a.containsKey(str);
    }

    @Override // r3.b
    public final o3.b get(String str) {
        return (o3.b) this.f8859a.get(str);
    }

    @Override // r3.b
    public final HashMap getAll() {
        return new HashMap(this.f8859a);
    }
}
