package androidx.core.util;

import a4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class b implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Predicate f382a;

    public /* synthetic */ b(Predicate predicate) {
        this.f382a = predicate;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        return x.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final Predicate negate() {
        return new b(this);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        return x.b(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return !this.f382a.test(obj);
    }
}
