package b9;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a extends q {
    @Override // b9.q
    public final q c() {
        return (a) this.f1121a;
    }

    @Override // b9.q
    public final void d(q qVar) {
        if (qVar instanceof a) {
            this.f1121a = qVar;
        } else {
            com.google.gson.internal.a.p("Parent of block must also be block (can not be inline)");
        }
    }
}
