package androidx.window.embedding;

import android.view.WindowMetrics;
import j$.util.function.Predicate$CC;
import java.util.function.Predicate;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class b implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f525a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f526b;

    public /* synthetic */ b(Object obj, int i) {
        this.f525a = i;
        this.f526b = obj;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f525a;
        return Predicate$CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        switch (this.f525a) {
        }
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f525a;
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        boolean m229translateParentMetricsPredicate$lambda4;
        switch (this.f525a) {
            case 0:
                m229translateParentMetricsPredicate$lambda4 = EmbeddingAdapter.m229translateParentMetricsPredicate$lambda4((SplitRule) this.f526b, (WindowMetrics) obj);
                return m229translateParentMetricsPredicate$lambda4;
            default:
                return ((Boolean) ((androidx.room.b) this.f526b).invoke(obj)).booleanValue();
        }
    }
}
