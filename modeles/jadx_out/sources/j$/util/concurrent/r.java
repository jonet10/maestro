package j$.util.concurrent;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class r extends l {

    /* renamed from: e, reason: collision with root package name */
    public r f6014e;
    public r f;
    public r g;
    public r h;
    public boolean i;

    public r(int i, Object obj, Object obj2, l lVar, r rVar) {
        super(i, obj, obj2, lVar);
        this.f6014e = rVar;
    }

    @Override // j$.util.concurrent.l
    public final l a(int i, Object obj) {
        return b(i, obj, null);
    }

    public final r b(int i, Object obj, Class cls) {
        if (obj == null) {
            return null;
        }
        r rVar = this;
        do {
            r rVar2 = rVar.f;
            r rVar3 = rVar.g;
            int i6 = rVar.f6000a;
            if (i6 <= i) {
                if (i6 >= i) {
                    Object obj2 = rVar.f6001b;
                    if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                        return rVar;
                    }
                    if (rVar2 != null) {
                        if (rVar3 != null) {
                            if (cls != null || (cls = ConcurrentHashMap.c(obj)) != null) {
                                int i10 = ConcurrentHashMap.g;
                                int compareTo = (obj2 == null || obj2.getClass() != cls) ? 0 : ((Comparable) obj).compareTo(obj2);
                                if (compareTo != 0) {
                                    if (compareTo >= 0) {
                                        rVar2 = rVar3;
                                    }
                                }
                            }
                            r b7 = rVar3.b(i, obj, cls);
                            if (b7 != null) {
                                return b7;
                            }
                        }
                    }
                }
                rVar = rVar3;
            }
            rVar = rVar2;
        } while (rVar != null);
        return null;
    }
}
