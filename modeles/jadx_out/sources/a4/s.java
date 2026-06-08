package a4;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import c4.o1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s extends b {
    public final /* synthetic */ int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(g0 g0Var, Object obj, k0 k0Var, String str, int i) {
        super(g0Var, obj, k0Var, str);
        this.h = i;
    }

    @Override // a4.b
    public final void b(Bitmap bitmap, int i) {
        switch (this.h) {
            case 0:
                return;
            default:
                if (bitmap == null) {
                    throw new AssertionError("Attempted to complete action with no result!\n" + this);
                }
                o1 o1Var = (o1) d();
                if (o1Var != null) {
                    o1Var.a(bitmap, i);
                    if (bitmap.isRecycled()) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("Target callback must not recycle bitmap!");
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // a4.b
    public final void c(Exception exc) {
        switch (this.h) {
            case 0:
                break;
            default:
                o1 o1Var = (o1) d();
                if (o1Var != null) {
                    exc.getClass();
                    ((ProgressBar) o1Var.f1934a.f1976a.f1063m).setVisibility(8);
                    break;
                }
                break;
        }
    }

    private final void f(Exception exc) {
    }

    private final void e(Bitmap bitmap, int i) {
    }
}
