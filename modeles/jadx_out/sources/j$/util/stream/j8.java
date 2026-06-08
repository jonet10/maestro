package j$.util.stream;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class j8 extends i5 implements r8 {

    /* renamed from: b, reason: collision with root package name */
    public long f6245b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6246c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f6247d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i8 f6248e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j8(i8 i8Var, m5 m5Var, boolean z9) {
        super(m5Var);
        this.f6248e = i8Var;
        this.f6247d = z9;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        boolean z9;
        boolean z10;
        if (!this.f6246c) {
            boolean test = this.f6248e.f6231m.test(obj);
            this.f6246c = !test;
            if (test) {
                z9 = false;
                z10 = this.f6247d;
                if (z10 && !z9) {
                    this.f6245b++;
                }
                if (!z10 || z9) {
                    this.f6224a.accept((m5) obj);
                }
                return;
            }
        }
        z9 = true;
        z10 = this.f6247d;
        if (z10) {
            this.f6245b++;
        }
        if (z10) {
        }
        this.f6224a.accept((m5) obj);
    }

    @Override // j$.util.stream.r8
    public final long h() {
        return this.f6245b;
    }
}
