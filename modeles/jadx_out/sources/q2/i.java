package q2;

import android.content.Context;
import android.os.Build;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import d7.l;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.util.DateRetargetClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import o7.c0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final Preferences.Key f8673b = PreferencesKeys.longKey("fire-global");

    /* renamed from: c, reason: collision with root package name */
    public static final Preferences.Key f8674c = PreferencesKeys.longKey("fire-count");

    /* renamed from: d, reason: collision with root package name */
    public static final Preferences.Key f8675d = PreferencesKeys.stringKey("last-used-date");

    /* renamed from: a, reason: collision with root package name */
    public final i2.f f8676a;

    public i(Context context, String str) {
        this.f8676a = new i2.f(context, "FirebaseHeartBeat".concat(str));
    }

    public final synchronized long a(MutablePreferences mutablePreferences) {
        long j;
        try {
            long longValue = ((Long) i2.g.a(mutablePreferences, f8674c, 0L)).longValue();
            String str = "";
            Set hashSet = new HashSet();
            String str2 = null;
            for (Map.Entry<Preferences.Key<?>, Object> entry : mutablePreferences.asMap().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set<String> set = (Set) entry.getValue();
                    for (String str3 : set) {
                        if (str2 != null && str2.compareTo(str3) <= 0) {
                        }
                        str = entry.getKey().getName();
                        hashSet = set;
                        str2 = str3;
                    }
                }
            }
            HashSet hashSet2 = new HashSet(hashSet);
            hashSet2.remove(str2);
            mutablePreferences.set(PreferencesKeys.stringSetKey(str), hashSet2);
            j = longValue - 1;
            mutablePreferences.set(f8674c, Long.valueOf(j));
        } catch (Throwable th) {
            throw th;
        }
        return j;
    }

    public final synchronized void b() {
        this.f8676a.a(new androidx.room.b(this, 16));
    }

    public final synchronized ArrayList c() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            String d10 = d(System.currentTimeMillis());
            i2.f fVar = this.f8676a;
            fVar.getClass();
            for (Map.Entry entry : ((Map) c0.w(t6.i.f10314a, new i2.b(fVar, null))).entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(d10);
                    if (!hashSet.isEmpty()) {
                        arrayList.add(new a(((Preferences.Key) entry.getKey()).getName(), new ArrayList(hashSet)));
                    }
                }
            }
            l(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized String d(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            return DateRetargetClass.toInstant(new Date(j)).atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j));
    }

    public final synchronized Preferences.Key e(MutablePreferences mutablePreferences, String str) {
        for (Map.Entry<Preferences.Key<?>, Object> entry : mutablePreferences.asMap().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return PreferencesKeys.stringSetKey(entry.getKey().getName());
                    }
                }
            }
        }
        return null;
    }

    public final synchronized boolean f(long j, long j6) {
        return d(j).equals(d(j6));
    }

    public final synchronized void g() {
        this.f8676a.a(new androidx.work.impl.model.a(10, this, d(System.currentTimeMillis())));
    }

    public final synchronized void h(MutablePreferences mutablePreferences, String str) {
        try {
            Preferences.Key e10 = e(mutablePreferences, str);
            if (e10 == null) {
                return;
            }
            HashSet hashSet = new HashSet((Collection) i2.g.a(mutablePreferences, e10, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                mutablePreferences.remove(e10);
            } else {
                mutablePreferences.set(e10, hashSet);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean i(long j) {
        return j(f8673b, j);
    }

    public final synchronized boolean j(Preferences.Key key, long j) {
        i2.f fVar = this.f8676a;
        fVar.getClass();
        key.getClass();
        i2.c cVar = new i2.c(fVar, key, null);
        t6.i iVar = t6.i.f10314a;
        if (f(((Long) c0.w(iVar, cVar)).longValue(), j)) {
            return false;
        }
        i2.f fVar2 = this.f8676a;
        Long valueOf = Long.valueOf(j);
        fVar2.getClass();
        return true;
    }

    public final synchronized void k(long j, final String str) {
        final String d10 = d(j);
        final Preferences.Key<Set<String>> stringSetKey = PreferencesKeys.stringSetKey(str);
        this.f8676a.a(new l() { // from class: q2.h
            @Override // d7.l
            public final Object invoke(Object obj) {
                i iVar = i.this;
                String str2 = d10;
                String str3 = str;
                Preferences.Key key = stringSetKey;
                MutablePreferences mutablePreferences = (MutablePreferences) obj;
                iVar.getClass();
                Preferences.Key key2 = i.f8675d;
                if (((String) i2.g.a(mutablePreferences, key2, "")).equals(str2)) {
                    Preferences.Key e10 = iVar.e(mutablePreferences, str2);
                    if (e10 == null || e10.getName().equals(str3)) {
                        return null;
                    }
                    synchronized (iVar) {
                        iVar.h(mutablePreferences, str2);
                        HashSet hashSet = new HashSet((Collection) i2.g.a(mutablePreferences, key, new HashSet()));
                        hashSet.add(str2);
                        mutablePreferences.set(key, hashSet);
                    }
                    return null;
                }
                Preferences.Key key3 = i.f8674c;
                long longValue = ((Long) i2.g.a(mutablePreferences, key3, 0L)).longValue();
                if (longValue + 1 == 30) {
                    longValue = iVar.a(mutablePreferences);
                }
                HashSet hashSet2 = new HashSet((Collection) i2.g.a(mutablePreferences, key, new HashSet()));
                hashSet2.add(str2);
                mutablePreferences.set(key, hashSet2);
                mutablePreferences.set(key3, Long.valueOf(longValue + 1));
                mutablePreferences.set(key2, str2);
                return null;
            }
        });
    }

    public final synchronized void l(long j) {
        this.f8676a.a(new androidx.room.support.c(3, j));
    }
}
