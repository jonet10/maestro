package b9;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public q f1121a = null;

    /* renamed from: b, reason: collision with root package name */
    public q f1122b = null;

    /* renamed from: c, reason: collision with root package name */
    public q f1123c = null;

    /* renamed from: d, reason: collision with root package name */
    public q f1124d = null;

    /* renamed from: e, reason: collision with root package name */
    public q f1125e = null;

    public abstract void a(y2.s sVar);

    public final void b(q qVar) {
        qVar.f();
        qVar.d(this);
        q qVar2 = this.f1123c;
        if (qVar2 == null) {
            this.f1122b = qVar;
            this.f1123c = qVar;
        } else {
            qVar2.f1125e = qVar;
            qVar.f1124d = qVar2;
            this.f1123c = qVar;
        }
    }

    public q c() {
        return this.f1121a;
    }

    public void d(q qVar) {
        this.f1121a = qVar;
    }

    public String e() {
        return "";
    }

    public final void f() {
        q qVar = this.f1124d;
        if (qVar != null) {
            qVar.f1125e = this.f1125e;
        } else {
            q qVar2 = this.f1121a;
            if (qVar2 != null) {
                qVar2.f1122b = this.f1125e;
            }
        }
        q qVar3 = this.f1125e;
        if (qVar3 != null) {
            qVar3.f1124d = qVar;
        } else {
            q qVar4 = this.f1121a;
            if (qVar4 != null) {
                qVar4.f1123c = qVar;
            }
        }
        this.f1121a = null;
        this.f1125e = null;
        this.f1124d = null;
    }

    public final String toString() {
        return getClass().getSimpleName() + "{" + e() + "}";
    }
}
