package l9;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.google.gson.b;
import com.google.gson.e;
import com.google.gson.internal.o;
import com.google.gson.reflect.TypeToken;
import com.inmobi.cmp.core.model.Vector;
import java.io.IOException;
import k0.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f7262a;

    public a(Application application) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
        defaultSharedPreferences.getClass();
        this.f7262a = defaultSharedPreferences;
    }

    public static void i(a aVar, int i, int i6, int i10) {
        aVar.getClass();
        if (i == 0) {
            throw null;
        }
        if (i6 == 0) {
            throw null;
        }
        if (i10 == 0) {
            throw null;
        }
        String str = "1" + k.a(i) + k.a(i6) + k.a(i10);
        aVar.f(37, str);
        aVar.f(38, str);
    }

    public final String a(int i, int i6) {
        String j = j(38);
        return j.length() > 0 ? j.substring(i, i6) : "";
    }

    public final void b(int i) {
        if (i == 0) {
            throw null;
        }
        SharedPreferences.Editor edit = this.f7262a.edit();
        edit.getClass();
        edit.remove(k.b(i));
        edit.apply();
    }

    public final void c(int i, int i6) {
        if (i == 0) {
            throw null;
        }
        SharedPreferences.Editor edit = this.f7262a.edit();
        edit.getClass();
        edit.putInt(k.b(i), i6);
        edit.apply();
    }

    public final void d(int i, long j) {
        if (i == 0) {
            throw null;
        }
        SharedPreferences.Editor edit = this.f7262a.edit();
        edit.getClass();
        edit.putLong(k.b(i), j);
        edit.apply();
    }

    public final void e(int i, Vector vector) {
        if (i == 0) {
            throw null;
        }
        vector.getClass();
        b bVar = new b();
        StringBuilder sb = new StringBuilder();
        try {
            k3.b bVar2 = new k3.b(new o(sb));
            bVar2.s(bVar.g);
            bVar2.f6973r = bVar.f;
            bVar2.u(2);
            bVar2.f6975t = false;
            bVar.e(vector, Vector.class, bVar2);
            f(i, sb.toString());
        } catch (IOException e10) {
            throw new e(e10);
        }
    }

    public final void f(int i, String str) {
        if (i == 0) {
            throw null;
        }
        str.getClass();
        SharedPreferences.Editor edit = this.f7262a.edit();
        edit.getClass();
        edit.putString(k.b(i), str);
        edit.apply();
    }

    public final void g(int i, boolean z9) {
        if (i == 0) {
            throw null;
        }
        SharedPreferences.Editor edit = this.f7262a.edit();
        edit.getClass();
        edit.putBoolean(k.b(i), z9);
        edit.apply();
    }

    public final void h(String str, String str2) {
        SharedPreferences.Editor edit = this.f7262a.edit();
        edit.getClass();
        edit.putString(str, str2);
        edit.apply();
    }

    public final String j(int i) {
        if (i == 0) {
            throw null;
        }
        String string = this.f7262a.getString(k.b(i), "");
        return string == null ? "" : string;
    }

    public final Vector k(int i) {
        if (i == 0) {
            throw null;
        }
        try {
            return (Vector) new b().b(j(i), new TypeToken<Vector>() { // from class: com.inmobi.cmp.data.storage.SharedStorage$getVectorPreference$type$1
            }.f3267b);
        } catch (Exception unused) {
            return null;
        }
    }
}
