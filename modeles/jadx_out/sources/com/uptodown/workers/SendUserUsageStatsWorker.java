package com.uptodown.workers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.work.ListenableWorker;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import b4.d;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import f4.c;
import j5.u;
import j5.v;
import java.util.HashMap;
import org.json.JSONObject;
import t0.f;
import x4.g2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class SendUserUsageStatsWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3489a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendUserUsageStatsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f3489a = context;
        Activity activity = c.f4875o;
        this.f3489a = f.e(context);
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        String str;
        Context context = this.f3489a;
        if (u.b(context)) {
            int s6 = z3.s(context, 0, "stats_downloads");
            int s9 = z3.s(context, 0, "stats_installs");
            int s10 = z3.s(context, 0, "stats_updates");
            z3.t(0L, context, "stats_time");
            long a8 = u.a(context);
            v vVar = new v(context);
            HashMap hashMap = new HashMap();
            hashMap.put("usageTime", String.valueOf(a8));
            hashMap.put("downloads", String.valueOf(s6));
            hashMap.put("installations", String.valueOf(s9));
            hashMap.put("updates", String.valueOf(s10));
            hashMap.put("lastUpdate", String.valueOf(System.currentTimeMillis() / 1000));
            g2 k5 = vVar.k("https://www.uptodown.app:443".concat("/eapi/user-data/native-app-usage"), hashMap, ShareTarget.METHOD_POST, false);
            k5.f11206d = vVar.i(k5, "/eapi/user-data/native-app-usage");
            if (!k5.b() && (str = k5.f11203a) != null && str.length() != 0) {
                String str2 = k5.f11203a;
                str2.getClass();
                if (new JSONObject(str2).optInt("success") == 1) {
                    z3.O(context, 0, "stats_downloads");
                    z3.O(context, 0, "stats_installs");
                    z3.O(context, 0, "stats_updates");
                    z3.Q(0L, context, "stats_time");
                }
            }
        } else {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            sharedPreferences.getClass();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("stats_enabled", false);
            edit.apply();
            float f = UptodownApp.I;
            if (d.p(context, "SendUserUsageStatsWorker")) {
                WorkManager.Companion.getInstance(context).cancelAllWorkByTag("SendUserUsageStatsWorker");
            }
        }
        ListenableWorker.Result success = ListenableWorker.Result.success();
        success.getClass();
        return success;
    }
}
