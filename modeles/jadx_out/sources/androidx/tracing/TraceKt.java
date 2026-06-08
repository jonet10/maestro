package androidx.tracing;

import d7.a;
import d7.l;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TraceKt {
    public static final <T> T trace(a aVar, a aVar2) {
        aVar.getClass();
        aVar2.getClass();
        boolean isEnabled = Trace.isEnabled();
        if (isEnabled) {
            Trace.beginSection((String) aVar.invoke());
        }
        try {
            return (T) aVar2.invoke();
        } finally {
            if (isEnabled) {
                Trace.endSection();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object traceAsync(java.lang.String r4, int r5, d7.l r6, t6.c r7) {
        /*
            boolean r0 = r7 instanceof androidx.tracing.TraceKt$traceAsync$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.tracing.TraceKt$traceAsync$1 r0 = (androidx.tracing.TraceKt$traceAsync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.tracing.TraceKt$traceAsync$1 r0 = new androidx.tracing.TraceKt$traceAsync$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2d
            int r5 = r0.I$0
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            p6.a.e(r7)     // Catch: java.lang.Throwable -> L2b
            goto L49
        L2b:
            r6 = move-exception
            goto L4d
        L2d:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            r4 = 0
            return r4
        L34:
            p6.a.e(r7)
            androidx.tracing.Trace.beginAsyncSection(r4, r5)
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L2b
            r0.I$0 = r5     // Catch: java.lang.Throwable -> L2b
            r0.label = r2     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r7 = r6.invoke(r0)     // Catch: java.lang.Throwable -> L2b
            u6.a r6 = u6.a.f10762a
            if (r7 != r6) goto L49
            return r6
        L49:
            androidx.tracing.Trace.endAsyncSection(r4, r5)
            return r7
        L4d:
            androidx.tracing.Trace.endAsyncSection(r4, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.tracing.TraceKt.traceAsync(java.lang.String, int, d7.l, t6.c):java.lang.Object");
    }

    private static final <T> Object traceAsync$$forInline(String str, int i, l lVar, c cVar) {
        Trace.beginAsyncSection(str, i);
        try {
            return lVar.invoke(cVar);
        } finally {
            Trace.endAsyncSection(str, i);
        }
    }

    public static final <T> T trace(String str, a aVar) {
        str.getClass();
        aVar.getClass();
        Trace.beginSection(str);
        try {
            return (T) aVar.invoke();
        } finally {
            Trace.endSection();
        }
    }

    public static final <T> T traceAsync(a aVar, a aVar2, a aVar3) {
        String str;
        int i;
        aVar.getClass();
        aVar2.getClass();
        aVar3.getClass();
        if (Trace.isEnabled()) {
            str = (String) aVar.invoke();
            i = ((Number) aVar2.invoke()).intValue();
            Trace.beginAsyncSection(str, i);
        } else {
            str = null;
            i = 0;
        }
        try {
            return (T) aVar3.invoke();
        } finally {
            if (str != null) {
                Trace.endAsyncSection(str, i);
            }
        }
    }
}
