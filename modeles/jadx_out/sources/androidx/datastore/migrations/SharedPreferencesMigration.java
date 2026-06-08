package androidx.datastore.migrations;

import a4.x;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.datastore.core.DataMigration;
import d7.a;
import d7.p;
import d7.q;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import p6.f;
import q6.l;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SharedPreferencesMigration<T> implements DataMigration<T> {
    private final Context context;
    private final Set<String> keySet;
    private final q migrate;
    private final String name;
    private final f sharedPrefs$delegate;
    private final p shouldRunMigration;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$4, reason: invalid class name */
    public static final class AnonymousClass4 extends m implements a {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $sharedPreferencesName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context, String str) {
            super(0);
            this.$context = context;
            this.$sharedPreferencesName = str;
        }

        @Override // d7.a
        public final SharedPreferences invoke() {
            SharedPreferences sharedPreferences = this.$context.getSharedPreferences(this.$sharedPreferencesName, 0);
            sharedPreferences.getClass();
            return sharedPreferences;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(24)
    public static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @DoNotInline
        public static final boolean deleteSharedPreferences(Context context, String str) {
            context.getClass();
            str.getClass();
            return context.deleteSharedPreferences(str);
        }
    }

    private SharedPreferencesMigration(a aVar, Set<String> set, p pVar, q qVar, Context context, String str) {
        this.shouldRunMigration = pVar;
        this.migrate = qVar;
        this.context = context;
        this.name = str;
        this.sharedPrefs$delegate = p6.a.d(aVar);
        this.keySet = set == SharedPreferencesMigration_androidKt.getMIGRATE_ALL_KEYS() ? null : l.I0(set);
    }

    private final void deleteSharedPreferences(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.deleteSharedPreferences(context, str);
            return;
        }
        File sharedPrefsFile = getSharedPrefsFile(context, str);
        File sharedPrefsBackup = getSharedPrefsBackup(sharedPrefsFile);
        sharedPrefsFile.delete();
        sharedPrefsBackup.delete();
    }

    private final SharedPreferences getSharedPrefs() {
        return (SharedPreferences) this.sharedPrefs$delegate.getValue();
    }

    private final File getSharedPrefsBackup(File file) {
        return new File(file.getPath() + ".bak");
    }

    private final File getSharedPrefsFile(Context context, String str) {
        return new File(new File(context.getApplicationInfo().dataDir, "shared_prefs"), x.C(str, ".xml"));
    }

    @Override // androidx.datastore.core.DataMigration
    public Object cleanUp(c cVar) throws IOException {
        Context context;
        String str;
        SharedPreferences.Editor edit = getSharedPrefs().edit();
        Set<String> set = this.keySet;
        if (set == null) {
            edit.clear();
        } else {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                edit.remove((String) it.next());
            }
        }
        if (!edit.commit()) {
            com.google.gson.internal.a.n("Unable to delete migrated keys from SharedPreferences.");
            return null;
        }
        if (getSharedPrefs().getAll().isEmpty() && (context = this.context) != null && (str = this.name) != null) {
            deleteSharedPreferences(context, str);
        }
        Set<String> set2 = this.keySet;
        if (set2 != null) {
            set2.clear();
        }
        return p6.x.f8463a;
    }

    @Override // androidx.datastore.core.DataMigration
    public Object migrate(T t9, c cVar) {
        return this.migrate.invoke(new SharedPreferencesView(getSharedPrefs(), this.keySet), t9, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
    
        if (r5.isEmpty() == false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    @Override // androidx.datastore.core.DataMigration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object shouldMigrate(T r5, t6.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1 r0 = (androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1 r0 = new androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            java.lang.Object r5 = r0.L$0
            androidx.datastore.migrations.SharedPreferencesMigration r5 = (androidx.datastore.migrations.SharedPreferencesMigration) r5
            p6.a.e(r6)
            goto L43
        L29:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L30:
            p6.a.e(r6)
            d7.p r6 = r4.shouldRunMigration
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r6 = r6.invoke(r5, r0)
            u6.a r5 = u6.a.f10762a
            if (r6 != r5) goto L42
            return r5
        L42:
            r5 = r4
        L43:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L4e
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L4e:
            java.util.Set<java.lang.String> r6 = r5.keySet
            r0 = 0
            if (r6 != 0) goto L67
            android.content.SharedPreferences r5 = r5.getSharedPrefs()
            java.util.Map r5 = r5.getAll()
            r5.getClass()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L65
            goto L88
        L65:
            r2 = r0
            goto L88
        L67:
            android.content.SharedPreferences r5 = r5.getSharedPrefs()
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L72
            goto L65
        L72:
            java.util.Iterator r6 = r6.iterator()
        L76:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L65
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r5.contains(r1)
            if (r1 == 0) goto L76
        L88:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.migrations.SharedPreferencesMigration.shouldMigrate(java.lang.Object, t6.c):java.lang.Object");
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @e(c = "androidx.datastore.migrations.SharedPreferencesMigration$1", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(c cVar) {
            super(2, cVar);
        }

        @Override // v6.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass1(cVar);
        }

        public final Object invoke(T t9, c cVar) {
            return ((AnonymousClass1) create(t9, cVar)).invokeSuspend(p6.x.f8463a);
        }

        @Override // v6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label == 0) {
                p6.a.e(obj);
                return Boolean.TRUE;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }

        @Override // d7.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((AnonymousClass1) obj, (c) obj2);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @e(c = "androidx.datastore.migrations.SharedPreferencesMigration$2", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(c cVar) {
            super(2, cVar);
        }

        @Override // v6.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass2(cVar);
        }

        public final Object invoke(T t9, c cVar) {
            return ((AnonymousClass2) create(t9, cVar)).invokeSuspend(p6.x.f8463a);
        }

        @Override // v6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label == 0) {
                p6.a.e(obj);
                return Boolean.TRUE;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }

        @Override // d7.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((AnonymousClass2) obj, (c) obj2);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @e(c = "androidx.datastore.migrations.SharedPreferencesMigration$3", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$3, reason: invalid class name */
    public static final class AnonymousClass3 extends i implements p {
        int label;

        public AnonymousClass3(c cVar) {
            super(2, cVar);
        }

        @Override // v6.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass3(cVar);
        }

        public final Object invoke(T t9, c cVar) {
            return ((AnonymousClass3) create(t9, cVar)).invokeSuspend(p6.x.f8463a);
        }

        @Override // v6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label == 0) {
                p6.a.e(obj);
                return Boolean.TRUE;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }

        @Override // d7.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((AnonymousClass3) obj, (c) obj2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String str, Set<String> set, q qVar) {
        this(context, str, set, null, qVar, 8, null);
        context.getClass();
        str.getClass();
        set.getClass();
        qVar.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(a aVar, q qVar) {
        this(aVar, (Set) null, (p) null, qVar, 6, (g) null);
        aVar.getClass();
        qVar.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(a aVar, Set<String> set, q qVar) {
        this(aVar, set, (p) null, qVar, 4, (g) null);
        aVar.getClass();
        set.getClass();
        qVar.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String str, q qVar) {
        this(context, str, null, null, qVar, 12, null);
        context.getClass();
        str.getClass();
        qVar.getClass();
    }

    public /* synthetic */ SharedPreferencesMigration(a aVar, Set set, p pVar, q qVar, Context context, String str, int i, g gVar) {
        this(aVar, (Set<String>) set, (i & 4) != 0 ? new AnonymousClass1(null) : pVar, qVar, context, str);
    }

    public /* synthetic */ SharedPreferencesMigration(a aVar, Set set, p pVar, q qVar, int i, g gVar) {
        this(aVar, (Set<String>) ((i & 2) != 0 ? SharedPreferencesMigration_androidKt.getMIGRATE_ALL_KEYS() : set), (i & 4) != 0 ? new AnonymousClass2(null) : pVar, qVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(a aVar, Set<String> set, p pVar, q qVar) {
        this(aVar, set, pVar, qVar, (Context) null, (String) null);
        aVar.getClass();
        set.getClass();
        pVar.getClass();
        qVar.getClass();
    }

    public /* synthetic */ SharedPreferencesMigration(Context context, String str, Set set, p pVar, q qVar, int i, g gVar) {
        this(context, str, (i & 4) != 0 ? SharedPreferencesMigration_androidKt.getMIGRATE_ALL_KEYS() : set, (i & 8) != 0 ? new AnonymousClass3(null) : pVar, qVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String str, Set<String> set, p pVar, q qVar) {
        this(new AnonymousClass4(context, str), set, pVar, qVar, context, str);
        context.getClass();
        str.getClass();
        set.getClass();
        pVar.getClass();
        qVar.getClass();
    }
}
