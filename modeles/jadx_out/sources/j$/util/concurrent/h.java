package j$.util.concurrent;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class h extends a implements Iterator, Enumeration {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f5996k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(l[] lVarArr, int i, int i6, ConcurrentHashMap concurrentHashMap, int i10) {
        super(lVarArr, i, i6, concurrentHashMap);
        this.f5996k = i10;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f5996k) {
            case 0:
                l lVar = this.f6009b;
                if (lVar == null) {
                    throw new NoSuchElementException();
                }
                Object obj = lVar.f6001b;
                this.j = lVar;
                a();
                return obj;
            default:
                l lVar2 = this.f6009b;
                if (lVar2 == null) {
                    throw new NoSuchElementException();
                }
                Object obj2 = lVar2.f6002c;
                this.j = lVar2;
                a();
                return obj2;
        }
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        switch (this.f5996k) {
        }
        return next();
    }
}
