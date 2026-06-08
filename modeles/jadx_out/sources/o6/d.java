package o6;

import android.graphics.Typeface;
import androidx.core.provider.FontsContractCompat;
import o7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends FontsContractCompat.FontRequestCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8222a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f8223b;

    public d(String str, l lVar) {
        this.f8222a = str;
        this.f8223b = lVar;
    }

    @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
    public final void onTypefaceRequestFailed(int i) {
        a.a.d(4, "FontManager", kotlin.jvm.internal.l.g(Integer.valueOf(i), "Google Fonts failed: reason="), null, Boolean.FALSE);
        this.f8223b.A(c.f8219b, null);
    }

    @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
    public final void onTypefaceRetrieved(Typeface typeface) {
        typeface.getClass();
        a.a.f(kotlin.jvm.internal.l.g(this.f8222a, "Google Fonts succeeded: "));
        this.f8223b.A(c.f8220l, typeface);
    }
}
