package i2;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.datastore.preferences.core.PreferencesFactory;
import d7.l;
import j7.k;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ k[] f5648d;

    /* renamed from: a, reason: collision with root package name */
    public final String f5649a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadLocal f5650b;

    /* renamed from: c, reason: collision with root package name */
    public final DataStore f5651c;

    static {
        s sVar = new s(kotlin.jvm.internal.d.NO_RECEIVER, f.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0);
        y.f7025a.getClass();
        f5648d = new k[]{sVar};
    }

    public f(Context context, String str) {
        context.getClass();
        this.f5649a = str;
        this.f5650b = new ThreadLocal();
        final int i = 0;
        final int i6 = 1;
        this.f5651c = (DataStore) PreferenceDataStoreDelegateKt.preferencesDataStore$default(str, new ReplaceFileCorruptionHandler(new l(this) { // from class: i2.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f5635b;

            {
                this.f5635b = this;
            }

            @Override // d7.l
            public final Object invoke(Object obj) {
                switch (i) {
                    case 0:
                        CorruptionException corruptionException = (CorruptionException) obj;
                        corruptionException.getClass();
                        Log.w(y.a(f.class).c(), "CorruptionException in " + this.f5635b.f5649a + " DataStore running in process " + Process.myPid(), corruptionException);
                        return PreferencesFactory.createEmpty();
                    default:
                        Context context2 = (Context) obj;
                        context2.getClass();
                        return a.a.H(SharedPreferencesMigrationKt.SharedPreferencesMigration$default(context2, this.f5635b.f5649a, null, 4, null));
                }
            }
        }), new l(this) { // from class: i2.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f5635b;

            {
                this.f5635b = this;
            }

            @Override // d7.l
            public final Object invoke(Object obj) {
                switch (i6) {
                    case 0:
                        CorruptionException corruptionException = (CorruptionException) obj;
                        corruptionException.getClass();
                        Log.w(y.a(f.class).c(), "CorruptionException in " + this.f5635b.f5649a + " DataStore running in process " + Process.myPid(), corruptionException);
                        return PreferencesFactory.createEmpty();
                    default:
                        Context context2 = (Context) obj;
                        context2.getClass();
                        return a.a.H(SharedPreferencesMigrationKt.SharedPreferencesMigration$default(context2, this.f5635b.f5649a, null, 4, null));
                }
            }
        }, null, 8, null).getValue(context, f5648d[0]);
    }

    public final void a(l lVar) {
    }
}
