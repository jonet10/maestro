package c4;

import android.widget.CompoundButton;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c6 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1466a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1467b;

    public /* synthetic */ c6(Object obj, int i) {
        this.f1466a = i;
        this.f1467b = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCheckedChanged(android.widget.CompoundButton r9, boolean r10) {
        /*
            r8 = this;
            int r0 = r8.f1466a
            r1 = 1
            r2 = 0
            java.lang.String r3 = "SettingsPreferences"
            java.lang.Object r4 = r8.f1467b
            switch(r0) {
                case 0: goto La7;
                case 1: goto La1;
                case 2: goto L89;
                case 3: goto L19;
                default: goto Lb;
            }
        Lb:
            m5.z1 r4 = (m5.z1) r4
            w4.o r9 = r4.f7654b
            if (r9 == 0) goto L18
            int r10 = r4.getBindingAdapterPosition()
            r9.a(r10)
        L18:
            return
        L19:
            com.uptodown.activities.preferences.MobileDataUsageActivity r4 = (com.uptodown.activities.preferences.MobileDataUsageActivity) r4
            int r9 = com.uptodown.activities.preferences.MobileDataUsageActivity.Q
            java.lang.String r9 = "autoplay_wifi"
            java.lang.String r0 = "autoplay_mobile_data"
            d4.l r5 = r4.B0()
            r7.o0 r5 = r5.f3584b
            java.lang.Object r5 = r5.getValue()
            d4.j r6 = d4.j.f3576a
            java.lang.String r7 = "autoplay"
            if (r5 != r6) goto L5e
            android.content.SharedPreferences r9 = r4.getSharedPreferences(r3, r2)     // Catch: java.lang.Exception -> L40
            boolean r1 = r9.contains(r0)     // Catch: java.lang.Exception -> L40
            if (r1 == 0) goto L40
            boolean r9 = r9.getBoolean(r0, r2)     // Catch: java.lang.Exception -> L40
            goto L41
        L40:
            r9 = r2
        L41:
            if (r10 == r9) goto L88
            android.content.SharedPreferences r9 = r4.getSharedPreferences(r3, r2)
            r9.getClass()
            android.content.SharedPreferences$Editor r9 = r9.edit()
            r9.putBoolean(r0, r10)
            r9.apply()
            java.lang.String r9 = "mobile"
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r4.C0(r7, r9, r10)
            goto L88
        L5e:
            android.content.SharedPreferences r0 = r4.getSharedPreferences(r3, r2)     // Catch: java.lang.Exception -> L6c
            boolean r5 = r0.contains(r9)     // Catch: java.lang.Exception -> L6c
            if (r5 == 0) goto L6c
            boolean r1 = r0.getBoolean(r9, r1)     // Catch: java.lang.Exception -> L6c
        L6c:
            if (r10 == r1) goto L88
            android.content.SharedPreferences r0 = r4.getSharedPreferences(r3, r2)
            r0.getClass()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r9, r10)
            r0.apply()
            java.lang.String r9 = "wifi"
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r4.C0(r7, r9, r10)
        L88:
            return
        L89:
            com.uptodown.activities.preferences.AdvancedPreferencesActivity r4 = (com.uptodown.activities.preferences.AdvancedPreferencesActivity) r4
            int r9 = com.uptodown.activities.preferences.AdvancedPreferencesActivity.Q
            android.content.SharedPreferences r9 = r4.getSharedPreferences(r3, r2)
            r9.getClass()
            android.content.SharedPreferences$Editor r9 = r9.edit()
            java.lang.String r0 = "animations"
            r9.putBoolean(r0, r10)
            r9.apply()
            return
        La1:
            com.google.android.material.chip.Chip r4 = (com.google.android.material.chip.Chip) r4
            com.google.android.material.chip.Chip.a(r4, r9, r10)
            return
        La7:
            com.uptodown.activities.OldVersionsActivity r4 = (com.uptodown.activities.OldVersionsActivity) r4
            int r9 = com.uptodown.activities.OldVersionsActivity.S
            r9 = r10 ^ 1
            android.content.SharedPreferences r10 = r4.getSharedPreferences(r3, r2)
            r10.getClass()
            android.content.SharedPreferences$Editor r10 = r10.edit()
            java.lang.String r0 = "show_warning_download_incompatible"
            r10.putBoolean(r0, r9)
            r10.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.c6.onCheckedChanged(android.widget.CompoundButton, boolean):void");
    }
}
