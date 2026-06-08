package o5;

import com.uptodown.workers.GetUpdatesWorker;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GetUpdatesWorker f8183a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(GetUpdatesWorker getUpdatesWorker, t6.c cVar) {
        super(2, cVar);
        this.f8183a = getUpdatesWorker;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new h(this.f8183a, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((h) create((a0) obj, (t6.c) obj2)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047 A[Catch: Exception -> 0x001d, TRY_ENTER, TryCatch #1 {Exception -> 0x001d, blocks: (B:3:0x0009, B:5:0x0018, B:8:0x0020, B:16:0x0047, B:17:0x007a, B:19:0x0080, B:21:0x0084, B:24:0x008b, B:26:0x009b, B:28:0x00a3, B:29:0x00c7, B:31:0x00a7, B:33:0x00ab, B:35:0x00be, B:36:0x00c1, B:37:0x005f), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab A[Catch: Exception -> 0x001d, TryCatch #1 {Exception -> 0x001d, blocks: (B:3:0x0009, B:5:0x0018, B:8:0x0020, B:16:0x0047, B:17:0x007a, B:19:0x0080, B:21:0x0084, B:24:0x008b, B:26:0x009b, B:28:0x00a3, B:29:0x00c7, B:31:0x00a7, B:33:0x00ab, B:35:0x00be, B:36:0x00c1, B:37:0x005f), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005f A[Catch: Exception -> 0x001d, TryCatch #1 {Exception -> 0x001d, blocks: (B:3:0x0009, B:5:0x0018, B:8:0x0020, B:16:0x0047, B:17:0x007a, B:19:0x0080, B:21:0x0084, B:24:0x008b, B:26:0x009b, B:28:0x00a3, B:29:0x00c7, B:31:0x00a7, B:33:0x00ab, B:35:0x00be, B:36:0x00c1, B:37:0x005f), top: B:2:0x0009 }] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            com.uptodown.workers.GetUpdatesWorker r0 = r10.f8183a
            android.content.Context r1 = r0.f3482a
            java.lang.String r2 = "https://t.uptodown.app:443/eapi/v3/tracker/updates/"
            p6.a.e(r11)
            r1.getClass()     // Catch: java.lang.Exception -> L1d
            android.content.ContentResolver r11 = r1.getContentResolver()     // Catch: java.lang.Exception -> L1d
            java.lang.String r3 = "android_id"
            java.lang.String r11 = android.provider.Settings.Secure.getString(r11, r3)     // Catch: java.lang.Exception -> L1d
            if (r11 != 0) goto L20
            androidx.work.ListenableWorker$Result r11 = androidx.work.ListenableWorker.Result.success()     // Catch: java.lang.Exception -> L1d
            return r11
        L1d:
            r11 = move-exception
            goto Ldf
        L20:
            int r3 = z4.c.f11961a     // Catch: java.lang.Exception -> L1d
            j5.v r3 = new j5.v     // Catch: java.lang.Exception -> L1d
            r4 = 0
            r3.<init>(r1, r4)     // Catch: java.lang.Exception -> L1d
            r1.getClass()     // Catch: java.lang.Exception -> L1d
            java.lang.String r5 = "updates_active"
            r6 = 1
            java.lang.String r7 = "SettingsPreferences"
            android.content.SharedPreferences r7 = r1.getSharedPreferences(r7, r4)     // Catch: java.lang.Exception -> L3f
            boolean r8 = r7.contains(r5)     // Catch: java.lang.Exception -> L3f
            if (r8 == 0) goto L3f
            boolean r5 = r7.getBoolean(r5, r6)     // Catch: java.lang.Exception -> L3f
            goto L40
        L3f:
            r5 = r6
        L40:
            java.lang.String r7 = "success"
            r8 = 404(0x194, float:5.66E-43)
            r9 = 0
            if (r5 != 0) goto L5f
            x4.g2 r11 = new x4.g2     // Catch: java.lang.Exception -> L1d
            r11.<init>()     // Catch: java.lang.Exception -> L1d
            r11.f11204b = r8     // Catch: java.lang.Exception -> L1d
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L1d
            r2.<init>()     // Catch: java.lang.Exception -> L1d
            r2.put(r7, r6)     // Catch: java.lang.Exception -> L1d
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Exception -> L1d
            r11.f11203a = r4     // Catch: java.lang.Exception -> L1d
            r11.f11206d = r2     // Catch: java.lang.Exception -> L1d
            goto L7a
        L5f:
            java.lang.String r11 = r2.concat(r11)     // Catch: java.lang.Exception -> L1d
            java.lang.String r2 = "GET"
            x4.g2 r11 = r3.k(r11, r9, r2, r4)     // Catch: java.lang.Exception -> L1d
            androidx.work.Data r2 = r0.getInputData()     // Catch: java.lang.Exception -> L1d
            java.lang.String r4 = "source"
            java.lang.String r2 = r2.getString(r4)     // Catch: java.lang.Exception -> L1d
            android.support.v4.media.g r4 = r0.f3483b     // Catch: java.lang.Exception -> L1d
            java.lang.String r5 = "getUpdates"
            r4.G(r5, r9, r11, r2)     // Catch: java.lang.Exception -> L1d
        L7a:
            boolean r2 = r3.c(r11)     // Catch: java.lang.Exception -> L1d
            if (r2 == 0) goto La7
            java.lang.String r2 = r11.f11203a     // Catch: java.lang.Exception -> L1d
            if (r2 == 0) goto La7
            int r2 = r2.length()     // Catch: java.lang.Exception -> L1d
            if (r2 != 0) goto L8b
            goto La7
        L8b:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L1d
            java.lang.String r11 = r11.f11203a     // Catch: java.lang.Exception -> L1d
            r11.getClass()     // Catch: java.lang.Exception -> L1d
            r2.<init>(r11)     // Catch: java.lang.Exception -> L1d
            int r11 = r2.optInt(r7)     // Catch: java.lang.Exception -> L1d
            if (r11 != r6) goto Lc7
            java.lang.String r11 = "data"
            org.json.JSONObject r11 = r2.optJSONObject(r11)     // Catch: java.lang.Exception -> L1d
            if (r11 == 0) goto Lc7
            com.uptodown.workers.GetUpdatesWorker.b(r0, r11)     // Catch: java.lang.Exception -> L1d
            goto Lc7
        La7:
            int r11 = r11.f11204b     // Catch: java.lang.Exception -> L1d
            if (r11 != r8) goto Lc7
            e1.c0 r11 = j5.g.D     // Catch: java.lang.Exception -> L1d
            j5.g r11 = r11.l(r1)     // Catch: java.lang.Exception -> L1d
            r11.b()     // Catch: java.lang.Exception -> L1d
            java.util.ArrayList r2 = r11.a0()     // Catch: java.lang.Exception -> L1d
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Exception -> L1d
            if (r2 != 0) goto Lc1
            r11.u()     // Catch: java.lang.Exception -> L1d
        Lc1:
            r11.c()     // Catch: java.lang.Exception -> L1d
            o5.p.a(r1, r9)     // Catch: java.lang.Exception -> L1d
        Lc7:
            android.os.Bundle r11 = new android.os.Bundle     // Catch: java.lang.Exception -> L1d
            r11.<init>()     // Catch: java.lang.Exception -> L1d
            java.lang.String r2 = "newUpdatesAvailableCount"
            int r0 = r0.f3484c     // Catch: java.lang.Exception -> L1d
            r11.putInt(r2, r0)     // Catch: java.lang.Exception -> L1d
            z4.e r0 = com.uptodown.UptodownApp.f3289c0     // Catch: java.lang.Exception -> L1d
            r2 = 601(0x259, float:8.42E-43)
            r0.send(r2, r11)     // Catch: java.lang.Exception -> L1d
            androidx.work.ListenableWorker$Result r11 = androidx.work.ListenableWorker.Result.success()     // Catch: java.lang.Exception -> L1d
            return r11
        Ldf:
            r11.printStackTrace()
            android.support.v4.media.g r0 = new android.support.v4.media.g
            r2 = 20
            r0.<init>(r1, r2)
            java.lang.String r1 = "getUpdatesWorker"
            r0.F(r1, r11)
            androidx.work.ListenableWorker$Result r11 = androidx.work.ListenableWorker.Result.success()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: o5.h.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
