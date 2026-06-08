package androidx.activity;

import d7.l;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FullyDrawnReporterKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object reportWhenComplete(androidx.activity.FullyDrawnReporter r4, d7.l r5, t6.c r6) {
        /*
            boolean r0 = r6 instanceof androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = (androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = new androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            p6.x r2 = p6.x.f8463a
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            androidx.activity.FullyDrawnReporter r4 = (androidx.activity.FullyDrawnReporter) r4
            p6.a.e(r6)     // Catch: java.lang.Throwable -> L2b
            goto L4e
        L2b:
            r5 = move-exception
            goto L52
        L2d:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            r4 = 0
            return r4
        L34:
            p6.a.e(r6)
            r4.addReporter()
            boolean r6 = r4.isFullyDrawnReported()
            if (r6 == 0) goto L41
            return r2
        L41:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L2b
            r0.label = r3     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r5 = r5.invoke(r0)     // Catch: java.lang.Throwable -> L2b
            u6.a r6 = u6.a.f10762a
            if (r5 != r6) goto L4e
            return r6
        L4e:
            r4.removeReporter()
            return r2
        L52:
            r4.removeReporter()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.FullyDrawnReporterKt.reportWhenComplete(androidx.activity.FullyDrawnReporter, d7.l, t6.c):java.lang.Object");
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, l lVar, t6.c cVar) {
        fullyDrawnReporter.addReporter();
        boolean isFullyDrawnReported = fullyDrawnReporter.isFullyDrawnReported();
        x xVar = x.f8463a;
        if (isFullyDrawnReported) {
            return xVar;
        }
        try {
            lVar.invoke(cVar);
            return xVar;
        } finally {
            fullyDrawnReporter.removeReporter();
        }
    }
}
