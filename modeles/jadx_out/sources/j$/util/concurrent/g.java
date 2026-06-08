package j$.util.concurrent;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class g extends l {

    /* renamed from: e, reason: collision with root package name */
    public final l[] f5995e;

    public g(l[] lVarArr) {
        super(-1, null, null);
        this.f5995e = lVarArr;
    }

    @Override // j$.util.concurrent.l
    public final l a(int i, Object obj) {
        l k5;
        Object obj2;
        l[] lVarArr = this.f5995e;
        loop0: while (true) {
            int length = lVarArr.length;
            if (length == 0 || (k5 = ConcurrentHashMap.k(lVarArr, (length - 1) & i)) == null) {
                return null;
            }
            do {
                int i6 = k5.f6000a;
                if (i6 != i || ((obj2 = k5.f6001b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                    if (i6 < 0) {
                        if (k5 instanceof g) {
                            lVarArr = ((g) k5).f5995e;
                        } else {
                            return k5.a(i, obj);
                        }
                    } else {
                        k5 = k5.f6003d;
                    }
                }
            } while (k5 != null);
            return null;
        }
        return k5;
    }
}
