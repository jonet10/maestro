package j$.util.stream;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class j2 implements h2 {

    /* renamed from: a, reason: collision with root package name */
    public final h2 f6235a;

    /* renamed from: b, reason: collision with root package name */
    public final h2 f6236b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6237c;

    @Override // j$.util.stream.h2
    public final int o() {
        return 2;
    }

    public j2(h2 h2Var, h2 h2Var2) {
        this.f6235a = h2Var;
        this.f6236b = h2Var2;
        this.f6237c = h2Var2.count() + h2Var.count();
    }

    @Override // j$.util.stream.h2
    public final h2 a(int i) {
        if (i == 0) {
            return this.f6235a;
        }
        if (i == 1) {
            return this.f6236b;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.h2
    public final long count() {
        return this.f6237c;
    }

    @Override // j$.util.stream.h2
    public /* bridge */ /* synthetic */ g2 a(int i) {
        return (g2) a(i);
    }
}
