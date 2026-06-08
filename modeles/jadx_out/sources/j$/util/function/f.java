package j$.util.function;

import java.util.function.Predicate;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class f implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6057a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Predicate f6058b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Predicate f6059c;

    public /* synthetic */ f(Predicate predicate, Predicate predicate2, int i) {
        this.f6057a = i;
        this.f6058b = predicate;
        this.f6059c = predicate2;
    }

    public final /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.f6057a) {
        }
        return Predicate$CC.$default$and(this, predicate);
    }

    public final /* synthetic */ Predicate negate() {
        switch (this.f6057a) {
        }
        return Predicate$CC.$default$negate(this);
    }

    public final /* synthetic */ Predicate or(Predicate predicate) {
        switch (this.f6057a) {
        }
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f6057a) {
            case 0:
                return this.f6058b.test(obj) && this.f6059c.test(obj);
            default:
                return this.f6058b.test(obj) || this.f6059c.test(obj);
        }
    }
}
