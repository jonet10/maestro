package androidx.activity;

import android.view.View;
import k7.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewTreeFullyDrawnReporterOwner {
    public static final FullyDrawnReporterOwner get(View view) {
        view.getClass();
        k7.f h02 = i.h0(ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$1.INSTANCE, view);
        ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2 viewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2 = ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2.INSTANCE;
        viewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2.getClass();
        k7.c cVar = new k7.c(new k7.d(new k7.d(h02, viewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2), new androidx.room.f(28)));
        return (FullyDrawnReporterOwner) (!cVar.hasNext() ? null : cVar.next());
    }

    public static final void set(View view, FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        view.getClass();
        fullyDrawnReporterOwner.getClass();
        view.setTag(R.id.report_drawn, fullyDrawnReporterOwner);
    }
}
