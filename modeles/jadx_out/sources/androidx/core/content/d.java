package androidx.core.content;

import a4.x;
import android.content.ClipData;
import android.content.ComponentName;
import android.net.Uri;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class d implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f340a;

    public /* synthetic */ d(int i) {
        this.f340a = i;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f340a;
        return x.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final Predicate negate() {
        switch (this.f340a) {
        }
        return new androidx.core.util.b(this);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f340a;
        return x.b(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        boolean lambda$allowAnyComponent$10;
        boolean lambda$allowExtra$14;
        boolean lambda$new$0;
        boolean lambda$new$1;
        boolean lambda$new$2;
        boolean lambda$new$3;
        boolean lambda$new$4;
        boolean lambda$new$5;
        boolean lambda$new$6;
        boolean lambda$new$7;
        boolean lambda$allowExtra$12;
        switch (this.f340a) {
            case 0:
                lambda$allowAnyComponent$10 = IntentSanitizer.Builder.lambda$allowAnyComponent$10((ComponentName) obj);
                return lambda$allowAnyComponent$10;
            case 1:
                lambda$allowExtra$14 = IntentSanitizer.Builder.lambda$allowExtra$14(obj);
                return lambda$allowExtra$14;
            case 2:
                lambda$new$0 = IntentSanitizer.Builder.lambda$new$0((String) obj);
                return lambda$new$0;
            case 3:
                lambda$new$1 = IntentSanitizer.Builder.lambda$new$1((Uri) obj);
                return lambda$new$1;
            case 4:
                lambda$new$2 = IntentSanitizer.Builder.lambda$new$2((String) obj);
                return lambda$new$2;
            case 5:
                lambda$new$3 = IntentSanitizer.Builder.lambda$new$3((String) obj);
                return lambda$new$3;
            case 6:
                lambda$new$4 = IntentSanitizer.Builder.lambda$new$4((String) obj);
                return lambda$new$4;
            case 7:
                lambda$new$5 = IntentSanitizer.Builder.lambda$new$5((ComponentName) obj);
                return lambda$new$5;
            case 8:
                lambda$new$6 = IntentSanitizer.Builder.lambda$new$6((Uri) obj);
                return lambda$new$6;
            case 9:
                lambda$new$7 = IntentSanitizer.Builder.lambda$new$7((ClipData) obj);
                return lambda$new$7;
            default:
                lambda$allowExtra$12 = IntentSanitizer.Builder.lambda$allowExtra$12(obj);
                return lambda$allowExtra$12;
        }
    }
}
