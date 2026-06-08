package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8307a;

    /* renamed from: b, reason: collision with root package name */
    public final i f8308b;

    /* renamed from: c, reason: collision with root package name */
    public final d7.q f8309c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f8310d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f8311e;

    public /* synthetic */ t(Object obj, i iVar, d7.q qVar, Throwable th, int i) {
        this(obj, (i & 2) != 0 ? null : iVar, (i & 4) != 0 ? null : qVar, (Object) null, (i & 16) != 0 ? null : th);
    }

    public static t a(t tVar, i iVar, Throwable th, int i) {
        Object obj = tVar.f8307a;
        if ((i & 2) != 0) {
            iVar = tVar.f8308b;
        }
        i iVar2 = iVar;
        d7.q qVar = tVar.f8309c;
        Object obj2 = tVar.f8310d;
        if ((i & 16) != 0) {
            th = tVar.f8311e;
        }
        return new t(obj, iVar2, qVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return kotlin.jvm.internal.l.a(this.f8307a, tVar.f8307a) && kotlin.jvm.internal.l.a(this.f8308b, tVar.f8308b) && kotlin.jvm.internal.l.a(this.f8309c, tVar.f8309c) && kotlin.jvm.internal.l.a(this.f8310d, tVar.f8310d) && kotlin.jvm.internal.l.a(this.f8311e, tVar.f8311e);
    }

    public final int hashCode() {
        Object obj = this.f8307a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        i iVar = this.f8308b;
        int hashCode2 = (hashCode + (iVar == null ? 0 : iVar.hashCode())) * 31;
        d7.q qVar = this.f8309c;
        int hashCode3 = (hashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        Object obj2 = this.f8310d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f8311e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f8307a + ", cancelHandler=" + this.f8308b + ", onCancellation=" + this.f8309c + ", idempotentResume=" + this.f8310d + ", cancelCause=" + this.f8311e + ')';
    }

    public t(Object obj, i iVar, d7.q qVar, Object obj2, Throwable th) {
        this.f8307a = obj;
        this.f8308b = iVar;
        this.f8309c = qVar;
        this.f8310d = obj2;
        this.f8311e = th;
    }
}
