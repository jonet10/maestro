package n2;

import java.util.Date;
import java.util.HashMap;
import l2.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements m2.a {
    public static final b f;
    public static final b g;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f7927a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f7928b;

    /* renamed from: c, reason: collision with root package name */
    public final a f7929c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7930d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f7926e = new a(0);
    public static final c h = new c();

    /* JADX WARN: Type inference failed for: r0v1, types: [n2.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [n2.b] */
    static {
        final int i = 0;
        f = new l2.f() { // from class: n2.b
            @Override // l2.a
            public final void a(Object obj, Object obj2) {
                switch (i) {
                    case 0:
                        ((g) obj2).b((String) obj);
                        break;
                    default:
                        ((g) obj2).c(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
        final int i6 = 1;
        g = new l2.f() { // from class: n2.b
            @Override // l2.a
            public final void a(Object obj, Object obj2) {
                switch (i6) {
                    case 0:
                        ((g) obj2).b((String) obj);
                        break;
                    default:
                        ((g) obj2).c(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
    }

    public d() {
        HashMap hashMap = new HashMap();
        this.f7927a = hashMap;
        HashMap hashMap2 = new HashMap();
        this.f7928b = hashMap2;
        this.f7929c = f7926e;
        this.f7930d = false;
        hashMap2.put(String.class, f);
        hashMap.remove(String.class);
        hashMap2.put(Boolean.class, g);
        hashMap.remove(Boolean.class);
        hashMap2.put(Date.class, h);
        hashMap.remove(Date.class);
    }

    public final m2.a a(Class cls, l2.d dVar) {
        this.f7927a.put(cls, dVar);
        this.f7928b.remove(cls);
        return this;
    }
}
