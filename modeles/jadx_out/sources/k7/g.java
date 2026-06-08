package k7;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends h implements Iterator, t6.c, e7.a {

    /* renamed from: a, reason: collision with root package name */
    public int f6997a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6998b;

    /* renamed from: l, reason: collision with root package name */
    public Iterator f6999l;

    /* renamed from: m, reason: collision with root package name */
    public t6.c f7000m;

    @Override // k7.h
    public final void a(Object obj, v6.h hVar) {
        this.f6998b = obj;
        this.f6997a = 3;
        this.f7000m = hVar;
    }

    public final RuntimeException c() {
        int i = this.f6997a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f6997a);
    }

    @Override // t6.c
    public final t6.h getContext() {
        return t6.i.f10314a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.f6997a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw c();
                }
                Iterator it = this.f6999l;
                it.getClass();
                if (it.hasNext()) {
                    this.f6997a = 2;
                    return true;
                }
                this.f6999l = null;
            }
            this.f6997a = 5;
            t6.c cVar = this.f7000m;
            cVar.getClass();
            this.f7000m = null;
            cVar.resumeWith(x.f8463a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f6997a;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            com.google.gson.internal.a.l();
            return null;
        }
        if (i == 2) {
            this.f6997a = 1;
            Iterator it = this.f6999l;
            it.getClass();
            return it.next();
        }
        if (i != 3) {
            throw c();
        }
        this.f6997a = 0;
        Object obj = this.f6998b;
        this.f6998b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // t6.c
    public final void resumeWith(Object obj) {
        p6.a.e(obj);
        this.f6997a = 4;
    }
}
