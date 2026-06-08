package androidx.core.content;

import a4.x;
import android.content.ComponentName;
import android.net.Uri;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class b implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f336a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f337b;

    public /* synthetic */ b(String str, int i) {
        this.f336a = i;
        this.f337b = str;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f336a;
        return x.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final Predicate negate() {
        switch (this.f336a) {
        }
        return new androidx.core.util.b(this);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f336a;
        return x.b(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        boolean lambda$allowExtraOutput$16;
        boolean lambda$allowComponentWithPackage$9;
        boolean lambda$allowDataWithAuthority$8;
        boolean lambda$allowClipDataUriWithAuthority$11;
        boolean lambda$allowExtraStreamUriWithAuthority$15;
        switch (this.f336a) {
            case 0:
                lambda$allowExtraOutput$16 = IntentSanitizer.Builder.lambda$allowExtraOutput$16(this.f337b, (Uri) obj);
                return lambda$allowExtraOutput$16;
            case 1:
                return this.f337b.equals((String) obj);
            case 2:
                lambda$allowComponentWithPackage$9 = IntentSanitizer.Builder.lambda$allowComponentWithPackage$9(this.f337b, (ComponentName) obj);
                return lambda$allowComponentWithPackage$9;
            case 3:
                lambda$allowDataWithAuthority$8 = IntentSanitizer.Builder.lambda$allowDataWithAuthority$8(this.f337b, (Uri) obj);
                return lambda$allowDataWithAuthority$8;
            case 4:
                lambda$allowClipDataUriWithAuthority$11 = IntentSanitizer.Builder.lambda$allowClipDataUriWithAuthority$11(this.f337b, (Uri) obj);
                return lambda$allowClipDataUriWithAuthority$11;
            default:
                lambda$allowExtraStreamUriWithAuthority$15 = IntentSanitizer.Builder.lambda$allowExtraStreamUriWithAuthority$15(this.f337b, (Uri) obj);
                return lambda$allowExtraStreamUriWithAuthority$15;
        }
    }
}
