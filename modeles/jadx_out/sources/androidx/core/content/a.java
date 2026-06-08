package androidx.core.content;

import androidx.core.util.Consumer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f335a;

    public /* synthetic */ a(int i) {
        this.f335a = i;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        String str = (String) obj;
        switch (this.f335a) {
            case 0:
                IntentSanitizer.lambda$sanitizeByThrowing$1(str);
                break;
            default:
                IntentSanitizer.lambda$sanitizeByFiltering$0(str);
                break;
        }
    }
}
