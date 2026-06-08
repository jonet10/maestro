package t3;

import a4.x;
import androidx.lifecycle.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    public String f9558b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9559c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9560d = true;

    /* renamed from: a, reason: collision with root package name */
    public final r3.b f9557a = f();

    public final void a(String str) {
        this.f9558b = str;
        this.f9559c = false;
        this.f9560d = false;
    }

    public abstract void b(String str, r3.b bVar);

    public final String c() {
        String str = this.f9558b;
        if (str == null || str.isEmpty() || this.f9559c) {
            this.f9558b = d(this.f9557a);
            this.f9559c = false;
            this.f9560d = true;
        }
        return this.f9558b;
    }

    public abstract String d(r3.b bVar);

    public final Object e(String str) {
        boolean z9 = this.f9560d;
        r3.b bVar = this.f9557a;
        if (!z9) {
            b(this.f9558b, bVar);
            this.f9559c = false;
            this.f9560d = true;
        }
        if (bVar.a(str)) {
            return bVar.get(str).getValue();
        }
        throw new q3.b(l.w("Invalid field: '", str, "'"));
    }

    public abstract r3.b f();

    public final void g(String str, Object obj) {
        boolean z9 = this.f9560d;
        r3.b bVar = this.f9557a;
        if (!z9) {
            b(this.f9558b, bVar);
            this.f9559c = false;
            this.f9560d = true;
        }
        if (!bVar.a(str)) {
            throw new q3.b(x.C(str, " not found"));
        }
        bVar.get(str).setValue(obj);
        this.f9559c = true;
    }
}
