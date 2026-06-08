package j$.util;

import java.util.RandomAccess;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class k extends i implements RandomAccess {
    private static final long serialVersionUID = 1530674583602358482L;

    @Override // j$.util.i, java.util.List
    public final java.util.List subList(int i, int i6) {
        k kVar;
        synchronized (this.f6065b) {
            kVar = new k(this.f6070c.subList(i, i6), this.f6065b);
        }
        return kVar;
    }

    private Object writeReplace() {
        return new i(this.f6070c);
    }
}
