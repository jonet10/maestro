package p9;

import android.app.Dialog;
import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f8532a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, k kVar) {
        super(context, 2132017456);
        this.f8532a = kVar;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f8532a.a();
    }
}
