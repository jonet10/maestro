package j$.util.stream;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class v extends j1 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f6393l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(a aVar, int i, int i6) {
        super(aVar, i);
        this.f6393l = i6;
    }

    @Override // j$.util.stream.a
    public final m5 M(int i, m5 m5Var) {
        switch (this.f6393l) {
            case 0:
                return new s(this, m5Var, 2);
            case 1:
                return new w0(0, m5Var);
            case 2:
                return new w0(this, m5Var, 3);
            case 3:
                return new e1(this, m5Var, 1);
            case 4:
                return m5Var;
            default:
                return new e1(this, m5Var, 4);
        }
    }
}
