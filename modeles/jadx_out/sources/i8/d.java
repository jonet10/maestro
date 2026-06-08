package i8;

import android.text.style.BulletSpan;
import android.text.style.LeadingMarginSpan;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends b {
    @Override // i8.b
    public final Object[] b(int i) {
        int i6 = 10;
        if (i > 1) {
            i6 = 10 - this.f5704a.getLeadingMargin(true);
            if (i > 2) {
                i6 -= (i - 2) * 20;
            }
        }
        return new Object[]{new LeadingMarginSpan.Standard((i - 1) * 20), new BulletSpan(i6)};
    }
}
