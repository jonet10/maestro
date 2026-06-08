package androidx.core.content;

import a4.x;
import android.content.ComponentName;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class c implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f338a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f339b;

    public /* synthetic */ c(Object obj, int i) {
        this.f338a = i;
        this.f339b = obj;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f338a;
        return x.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final Predicate negate() {
        switch (this.f338a) {
        }
        return new androidx.core.util.b(this);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f338a;
        return x.b(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        boolean lambda$asPredicate$0;
        switch (this.f338a) {
            case 0:
                return ((ComponentName) this.f339b).equals((ComponentName) obj);
            default:
                lambda$asPredicate$0 = UriMatcherCompat.lambda$asPredicate$0((UriMatcher) this.f339b, (Uri) obj);
                return lambda$asPredicate$0;
        }
    }
}
