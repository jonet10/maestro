package j$.util.concurrent;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class a extends p {
    public final ConcurrentHashMap i;
    public l j;

    public a(l[] lVarArr, int i, int i6, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i, 0, i6);
        this.i = concurrentHashMap;
        a();
    }

    public final boolean hasNext() {
        return this.f6009b != null;
    }

    public final boolean hasMoreElements() {
        return this.f6009b != null;
    }

    public final void remove() {
        l lVar = this.j;
        if (lVar == null) {
            throw new IllegalStateException();
        }
        this.j = null;
        this.i.g(lVar.f6001b, null, null);
    }
}
