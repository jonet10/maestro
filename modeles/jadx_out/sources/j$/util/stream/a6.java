package j$.util.stream;

import java.util.Comparator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class a6 extends i5 {

    /* renamed from: b, reason: collision with root package name */
    public final Comparator f6135b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6136c;

    public a6(m5 m5Var, Comparator comparator) {
        super(m5Var);
        this.f6135b = comparator;
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final boolean e() {
        this.f6136c = true;
        return false;
    }
}
