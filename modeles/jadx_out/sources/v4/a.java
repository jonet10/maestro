package v4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import b2.t1;
import com.uptodown.UptodownApp;
import j1.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledFuture;
import r.p;
import s1.o;
import t4.n0;
import x.g;
import y.c;
import y.h;
import y1.j;
import y2.a0;
import y2.c0;
import y2.s;
import z.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements d, b, j1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10850a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10851b;

    public /* synthetic */ a(Object obj, int i) {
        this.f10850a = i;
        this.f10851b = obj;
    }

    @Override // z.b
    public Object execute() {
        SQLiteDatabase b7;
        int i = this.f10850a;
        Object obj = this.f10851b;
        switch (i) {
            case 1:
                h hVar = (h) ((c) obj);
                hVar.getClass();
                int i6 = u.a.f10369e;
                s sVar = new s(18);
                sVar.f11756l = null;
                sVar.f11757m = new ArrayList();
                sVar.f11758n = null;
                sVar.f11755b = "";
                HashMap hashMap = new HashMap();
                b7 = hVar.b();
                b7.beginTransaction();
                try {
                    u.a aVar = (u.a) h.j(b7.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new androidx.transition.a(hVar, hashMap, sVar, 6));
                    b7.setTransactionSuccessful();
                    return aVar;
                } finally {
                }
            case 2:
                h hVar2 = (h) ((y.d) obj);
                long f = hVar2.f11588b.f() - hVar2.f11590m.f11577d;
                b7 = hVar2.b();
                b7.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(f)};
                    Cursor rawQuery = b7.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (rawQuery.moveToNext()) {
                        try {
                            hVar2.f(rawQuery.getInt(0), u.c.MESSAGE_TOO_OLD, rawQuery.getString(1));
                        } catch (Throwable th) {
                            rawQuery.close();
                            throw th;
                        }
                    }
                    rawQuery.close();
                    int delete = b7.delete("events", "timestamp_ms < ?", strArr);
                    b7.setTransactionSuccessful();
                    b7.endTransaction();
                    return Integer.valueOf(delete);
                } finally {
                }
            case 3:
                h hVar3 = (h) ((g) obj).i;
                b7 = hVar3.b();
                b7.beginTransaction();
                try {
                    b7.compileStatement("DELETE FROM log_event_dropped").execute();
                    b7.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + hVar3.f11588b.f()).execute();
                    b7.setTransactionSuccessful();
                    return null;
                } finally {
                }
            default:
                s sVar2 = (s) obj;
                b7 = ((h) ((y.d) sVar2.f11756l)).b();
                b7.beginTransaction();
                try {
                    List list = (List) h.j(b7.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new o(23));
                    b7.setTransactionSuccessful();
                    b7.endTransaction();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((n0) sVar2.f11757m).e((p) it.next(), 1, false);
                    }
                    return null;
                } finally {
                }
        }
    }

    @Override // j1.a
    public Object g(j1.p pVar) {
        switch (this.f10850a) {
            case 5:
                ((CountDownLatch) this.f10851b).countDown();
                return null;
            case 9:
                return (j1.p) ((j) this.f10851b).call();
            default:
                ((Runnable) this.f10851b).run();
                return t1.x(null);
        }
    }

    @Override // j1.d
    public void s(j1.p pVar) {
        switch (this.f10850a) {
            case 0:
                UptodownApp uptodownApp = (UptodownApp) this.f10851b;
                pVar.getClass();
                if (pVar.i()) {
                    String str = (String) pVar.g();
                    SharedPreferences sharedPreferences = uptodownApp.getSharedPreferences("SettingsPreferences", 0);
                    sharedPreferences.getClass();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("fcmToken", str);
                    edit.apply();
                    break;
                }
                break;
            case 6:
                a0.c((Intent) this.f10851b);
                break;
            case 7:
                ((c0) this.f10851b).f11716b.c(null);
                break;
            default:
                ((ScheduledFuture) this.f10851b).cancel(false);
                break;
        }
    }
}
