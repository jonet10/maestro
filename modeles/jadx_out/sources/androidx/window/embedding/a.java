package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import j$.util.function.Predicate$CC;
import java.util.Set;
import java.util.function.Predicate;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f523a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f524b;

    public /* synthetic */ a(Set set, int i) {
        this.f523a = i;
        this.f524b = set;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f523a;
        return Predicate$CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        switch (this.f523a) {
        }
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f523a;
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        boolean m228translateIntentPredicates$lambda8;
        boolean m227translateActivityPredicates$lambda6;
        switch (this.f523a) {
            case 0:
                m228translateIntentPredicates$lambda8 = EmbeddingAdapter.m228translateIntentPredicates$lambda8(this.f524b, (Intent) obj);
                return m228translateIntentPredicates$lambda8;
            default:
                m227translateActivityPredicates$lambda6 = EmbeddingAdapter.m227translateActivityPredicates$lambda6(this.f524b, (Activity) obj);
                return m227translateActivityPredicates$lambda6;
        }
    }
}
