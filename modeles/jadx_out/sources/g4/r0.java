package g4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class r0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5250a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0 f5251b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f5252l;

    public /* synthetic */ r0(s0 s0Var, String str, int i) {
        this.f5250a = i;
        this.f5251b = s0Var;
        this.f5252l = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5250a) {
            case 0:
                s0 s0Var = this.f5251b;
                s0Var.E();
                s0Var.i(this.f5252l);
                break;
            default:
                s0 s0Var2 = this.f5251b;
                s0Var2.E();
                s0Var2.i(this.f5252l);
                break;
        }
    }
}
