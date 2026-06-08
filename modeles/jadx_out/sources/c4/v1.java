package c4;

import com.uptodown.activities.LanguageSettingsActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v1 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2191a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LanguageSettingsActivity f2192b;

    /* renamed from: l, reason: collision with root package name */
    public int f2193l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v1(LanguageSettingsActivity languageSettingsActivity, v6.c cVar) {
        super(cVar);
        this.f2192b = languageSettingsActivity;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f2191a = obj;
        this.f2193l |= Integer.MIN_VALUE;
        return LanguageSettingsActivity.y0(this.f2192b, this);
    }
}
