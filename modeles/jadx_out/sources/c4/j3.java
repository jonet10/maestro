package c4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.fragment.app.Fragment;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.uptodown.activities.MainActivity;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j3 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1753a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1754b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j3(MainActivity mainActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1753a = i;
        this.f1754b = mainActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1753a) {
            case 0:
                return new j3(this.f1754b, cVar, 0);
            case 1:
                return new j3(this.f1754b, cVar, 1);
            case 2:
                return new j3(this.f1754b, cVar, 2);
            case 3:
                return new j3(this.f1754b, cVar, 3);
            case 4:
                return new j3(this.f1754b, cVar, 4);
            case 5:
                return new j3(this.f1754b, cVar, 5);
            default:
                return new j3(this.f1754b, cVar, 6);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1753a) {
            case 0:
                j3 j3Var = (j3) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                j3Var.invokeSuspend(xVar);
                return xVar;
            case 1:
                j3 j3Var2 = (j3) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                j3Var2.invokeSuspend(xVar2);
                return xVar2;
            case 2:
                j3 j3Var3 = (j3) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                j3Var3.invokeSuspend(xVar3);
                return xVar3;
            case 3:
                return ((j3) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 4:
                j3 j3Var4 = (j3) create(a0Var, cVar);
                p6.x xVar4 = p6.x.f8463a;
                j3Var4.invokeSuspend(xVar4);
                return xVar4;
            case 5:
                j3 j3Var5 = (j3) create(a0Var, cVar);
                p6.x xVar5 = p6.x.f8463a;
                j3Var5.invokeSuspend(xVar5);
                return xVar5;
            default:
                j3 j3Var6 = (j3) create(a0Var, cVar);
                p6.x xVar6 = p6.x.f8463a;
                j3Var6.invokeSuspend(xVar6);
                return xVar6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r15v0, types: [org.json.JSONObject] */
    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        x4.n2 v;
        int i = this.f1753a;
        int i6 = 0;
        Cursor cursor = null;
        p6.x xVar = p6.x.f8463a;
        MainActivity mainActivity = this.f1754b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                mainActivity.u0();
                break;
            case 1:
                p6.a.e(obj);
                String y9 = com.google.android.gms.internal.measurement.z3.y(mainActivity, "fcmToken");
                if (y9 == null || y9.length() == 0) {
                    j5.v vVar = new j5.v(mainActivity);
                    String w2 = androidx.lifecycle.l.w("/eapi/v3/device/", Settings.Secure.getString(mainActivity.getContentResolver(), "android_id"), "/welcome-messages");
                    x4.g2 k5 = vVar.k("https://www.uptodown.app:443".concat(w2), null, ShareTarget.METHOD_GET, false);
                    JSONObject i10 = vVar.i(k5, w2);
                    k5.f11206d = i10;
                    if (i10 != null && i10.optInt("success") == 1 && (optJSONObject = i10.optJSONObject("data")) != null && (optJSONArray = optJSONObject.optJSONArray("messages")) != null) {
                        String y10 = com.google.android.gms.internal.measurement.z3.y(mainActivity, "Language");
                        if (y10 == null) {
                            y10 = "en";
                        }
                        j5.g l10 = j5.g.D.l(mainActivity);
                        l10.b();
                        int length = optJSONArray.length();
                        int i11 = 0;
                        while (i11 < length) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i11);
                            if (optJSONObject2 != null && (optJSONArray2 = optJSONObject2.optJSONArray("translations")) != null) {
                                int length2 = optJSONArray2.length();
                                int i12 = i6;
                                Cursor cursor2 = cursor;
                                Cursor cursor3 = cursor2;
                                ?? r13 = cursor2;
                                while (true) {
                                    if (i12 < length2) {
                                        ?? optJSONObject3 = optJSONArray2.optJSONObject(i12);
                                        if (optJSONObject3 != null) {
                                            if (cursor3 == null) {
                                                cursor3 = optJSONObject3;
                                            }
                                            if (kotlin.jvm.internal.l.a(optJSONObject3.optString("locale"), y10)) {
                                                v = t0.f.v(optJSONObject3);
                                            } else if (kotlin.jvm.internal.l.a(optJSONObject3.optString("locale"), "en")) {
                                                r13 = optJSONObject3;
                                            }
                                        }
                                        i12++;
                                        r13 = r13;
                                    } else {
                                        if (r13 == 0) {
                                            if (cursor3 == null) {
                                                v = null;
                                            } else {
                                                r13 = cursor3;
                                            }
                                        }
                                        v = t0.f.v(r13);
                                    }
                                }
                                if (v != null) {
                                    l10.d0(v.f11296b, v.f11297c, v.f11298d, v.f11299e);
                                }
                            }
                            i11++;
                            i6 = 0;
                            cursor = null;
                        }
                        l10.c();
                        break;
                    }
                }
                break;
            case 2:
                ArrayList w9 = a4.x.w(obj);
                j5.g l11 = j5.g.D.l(mainActivity);
                l11.b();
                x4.h2 X = l11.X("categories");
                if (X == null || !X.a()) {
                    j5.v vVar2 = new j5.v(mainActivity);
                    x4.g2 k10 = vVar2.k("https://www.uptodown.app:443".concat("/eapi/v2/categories/parents"), new HashMap(), ShareTarget.METHOD_GET, false);
                    k10.f11206d = vVar2.i(k10, "/eapi/v2/categories/parents");
                    if (!k10.b() && k10.f11203a != null) {
                        JSONObject jSONObject = k10.f11206d;
                        jSONObject.getClass();
                        w9 = t0.f.w(jSONObject);
                        String str = k10.f11203a;
                        str.getClass();
                        long currentTimeMillis = System.currentTimeMillis();
                        l11.r("categories");
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "categories");
                        contentValues.put("json", str);
                        contentValues.put("timestamp", String.valueOf(currentTimeMillis));
                        SQLiteDatabase sQLiteDatabase = l11.f6673a;
                        sQLiteDatabase.getClass();
                        sQLiteDatabase.insert("responses", null, contentValues);
                    }
                } else {
                    w9 = t0.f.w(new JSONObject((String) X.f11212b));
                }
                l11.c();
                if (!w9.isEmpty()) {
                    mainActivity.f3319r0.addAll(w9);
                    break;
                }
                break;
            case 3:
                p6.a.e(obj);
                j5.g l12 = j5.g.D.l(mainActivity);
                l12.b();
                ArrayList arrayList = new ArrayList();
                try {
                    SQLiteDatabase sQLiteDatabase2 = l12.f6673a;
                    sQLiteDatabase2.getClass();
                    cursor = sQLiteDatabase2.query("pending_system_messages", null, null, null, null, null, "timestamp ASC");
                    if (cursor.moveToFirst()) {
                        do {
                            arrayList.add(new x4.n2(cursor.getLong(cursor.getColumnIndexOrThrow("id")), cursor.getString(cursor.getColumnIndexOrThrow("title")), cursor.getString(cursor.getColumnIndexOrThrow("body")), cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getString(cursor.getColumnIndexOrThrow("action_button_text"))));
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
                x4.n2 n2Var = (x4.n2) q6.l.r0(arrayList);
                if (n2Var != null) {
                    long j = n2Var.f11295a;
                    SQLiteDatabase sQLiteDatabase3 = l12.f6673a;
                    sQLiteDatabase3.getClass();
                    sQLiteDatabase3.delete("pending_system_messages", "id = ?", new String[]{String.valueOf(j)});
                }
                l12.c();
                break;
            case 4:
                p6.a.e(obj);
                mainActivity.z();
                break;
            case 5:
                p6.a.e(obj);
                String string = mainActivity.getString(2131951692);
                string.getClass();
                mainActivity.A(string);
                break;
            default:
                p6.a.e(obj);
                Fragment W0 = mainActivity.W0();
                if (W0 instanceof u4.f0) {
                    ((u4.f0) W0).D();
                    break;
                }
                break;
        }
        return xVar;
    }
}
