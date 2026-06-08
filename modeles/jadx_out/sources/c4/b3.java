package c4;

import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class b3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1411a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1412b;

    public /* synthetic */ b3(int i, MainActivity mainActivity) {
        this.f1411a = i;
        this.f1412b = mainActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r7 = this;
            int r0 = r7.f1411a
            r1 = 2000(0x7d0, double:9.88E-321)
            r3 = 0
            com.uptodown.activities.MainActivity r4 = r7.f1412b
            switch(r0) {
                case 0: goto L5c;
                case 1: goto L1e;
                default: goto La;
            }
        La:
            int r0 = com.uptodown.activities.MainActivity.G0
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r5 = android.os.Looper.getMainLooper()
            r0.<init>(r5)
            c4.b3 r5 = new c4.b3
            r5.<init>(r3, r4)
            r0.postDelayed(r5, r1)
            return
        L1e:
            int r0 = com.uptodown.activities.MainActivity.G0
            java.lang.String r0 = "is_device_tracking_registered"
            java.lang.String r5 = "SettingsPreferences"
            android.content.SharedPreferences r5 = r4.getSharedPreferences(r5, r3)     // Catch: java.lang.Exception -> L33
            boolean r6 = r5.contains(r0)     // Catch: java.lang.Exception -> L33
            if (r6 == 0) goto L33
            boolean r0 = r5.getBoolean(r0, r3)     // Catch: java.lang.Exception -> L33
            goto L34
        L33:
            r0 = r3
        L34:
            if (r0 == 0) goto L3c
            r4.f3309g0 = r3
            r4.Q0()
            goto L5b
        L3c:
            int r0 = r4.f3309g0
            r5 = 5
            if (r0 >= r5) goto L56
            int r0 = r0 + 1
            r4.f3309g0 = r0
            android.os.Handler r0 = r4.f3308f0
            c4.b3 r3 = r4.f3326y0
            if (r3 == 0) goto L4f
            r0.postDelayed(r3, r1)
            goto L5b
        L4f:
            java.lang.String r0 = "checkRegisteredRunnable"
            kotlin.jvm.internal.l.i(r0)
            r0 = 0
            throw r0
        L56:
            r4.f3309g0 = r3
            r4.Q0()
        L5b:
            return
        L5c:
            int r0 = com.uptodown.activities.MainActivity.G0
            r0 = 2131363022(0x7f0a04ce, float:1.8345841E38)
            android.view.View r0 = r4.findViewById(r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            if (r0 == 0) goto L6c
            r0.setVisibility(r3)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.b3.run():void");
    }
}
