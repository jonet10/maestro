package androidx.room;

import androidx.lifecycle.l;
import d7.p;
import java.util.Iterator;
import java.util.Set;
import o7.c0;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final /* synthetic */ class RoomDatabaseKt__RoomDatabaseKt {
    public static final <R> Object useReaderConnection(RoomDatabase roomDatabase, p pVar, t6.c cVar) {
        return c0.C(new RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$2(roomDatabase, pVar, null), roomDatabase.getCoroutineScope().getCoroutineContext(), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object useWriterConnection(androidx.room.RoomDatabase r4, d7.p r5, t6.c r6) {
        /*
            boolean r0 = r6 instanceof androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 r0 = (androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 r0 = new androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            java.lang.Object r4 = r0.L$0
            androidx.room.RoomDatabase r4 = (androidx.room.RoomDatabase) r4
            p6.a.e(r6)
            goto L4e
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            r4 = 0
            return r4
        L30:
            p6.a.e(r6)
            o7.a0 r6 = r4.getCoroutineScope()
            t6.h r6 = r6.getCoroutineContext()
            androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2 r1 = new androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2
            r3 = 0
            r1.<init>(r4, r5, r3)
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r6 = o7.c0.C(r1, r6, r0)
            u6.a r5 = u6.a.f10762a
            if (r6 != r5) goto L4e
            return r5
        L4e:
            androidx.room.InvalidationTracker r4 = r4.getInvalidationTracker()
            r4.refreshAsync()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt__RoomDatabaseKt.useWriterConnection(androidx.room.RoomDatabase, d7.p, t6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
    
        com.google.gson.internal.a.p("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void validateAutoMigrations(androidx.room.RoomDatabase r10, androidx.room.DatabaseConfiguration r11) {
        /*
            r10.getClass()
            r11.getClass()
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Set r1 = r10.getRequiredAutoMigrationSpecClasses()
            int r2 = r1.size()
            boolean[] r3 = new boolean[r2]
            java.util.Iterator r1 = r1.iterator()
        L19:
            boolean r4 = r1.hasNext()
            r5 = -1
            if (r4 == 0) goto L66
            java.lang.Object r4 = r1.next()
            j7.c r4 = (j7.c) r4
            java.util.List<androidx.room.migration.AutoMigrationSpec> r6 = r11.autoMigrationSpecs
            java.util.Collection r6 = (java.util.Collection) r6
            int r6 = r6.size()
            int r6 = r6 + r5
            if (r6 < 0) goto L4c
        L31:
            int r7 = r6 + (-1)
            java.util.List<androidx.room.migration.AutoMigrationSpec> r8 = r11.autoMigrationSpecs
            java.lang.Object r8 = r8.get(r6)
            r9 = r4
            kotlin.jvm.internal.f r9 = (kotlin.jvm.internal.f) r9
            boolean r8 = r9.d(r8)
            if (r8 == 0) goto L47
            r5 = 1
            r3[r6] = r5
            r5 = r6
            goto L4c
        L47:
            if (r7 >= 0) goto L4a
            goto L4c
        L4a:
            r6 = r7
            goto L31
        L4c:
            if (r5 < 0) goto L58
            java.util.List<androidx.room.migration.AutoMigrationSpec> r6 = r11.autoMigrationSpecs
            java.lang.Object r5 = r6.get(r5)
            r0.put(r4, r5)
            goto L19
        L58:
            kotlin.jvm.internal.f r4 = (kotlin.jvm.internal.f) r4
            java.lang.String r10 = r4.b()
            java.lang.String r11 = ") is missing in the database configuration."
            java.lang.String r0 = "A required auto migration spec ("
            androidx.core.view.contentcapture.a.q(r10, r0, r11)
            return
        L66:
            java.util.List<androidx.room.migration.AutoMigrationSpec> r1 = r11.autoMigrationSpecs
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            int r1 = r1 + r5
            if (r1 < 0) goto L84
        L71:
            int r4 = r1 + (-1)
            if (r1 >= r2) goto L7e
            boolean r1 = r3[r1]
            if (r1 == 0) goto L7e
            if (r4 >= 0) goto L7c
            goto L84
        L7c:
            r1 = r4
            goto L71
        L7e:
            java.lang.String r10 = "Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder."
            com.google.gson.internal.a.p(r10)
            return
        L84:
            java.util.List r10 = r10.createAutoMigrations(r0)
            java.util.Iterator r10 = r10.iterator()
        L8c:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto Laa
            java.lang.Object r0 = r10.next()
            androidx.room.migration.Migration r0 = (androidx.room.migration.Migration) r0
            androidx.room.RoomDatabase$MigrationContainer r1 = r11.migrationContainer
            int r2 = r0.startVersion
            int r3 = r0.endVersion
            boolean r1 = r1.contains(r2, r3)
            if (r1 != 0) goto L8c
            androidx.room.RoomDatabase$MigrationContainer r1 = r11.migrationContainer
            r1.addMigration(r0)
            goto L8c
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt__RoomDatabaseKt.validateAutoMigrations(androidx.room.RoomDatabase, androidx.room.DatabaseConfiguration):void");
    }

    public static final void validateMigrationsNotRequired(Set<Integer> set, Set<Integer> set2) {
        set.getClass();
        set2.getClass();
        if (set.isEmpty()) {
            return;
        }
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (set2.contains(Integer.valueOf(intValue))) {
                o.o(l.u(intValue, "Inconsistency detected. A Migration was supplied to addMigration() that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(). Start version is: "));
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069 A[LOOP:1: B:5:0x0035->B:17:0x0069, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void validateTypeConverters(androidx.room.RoomDatabase r10, androidx.room.DatabaseConfiguration r11) {
        /*
            r10.getClass()
            r11.getClass()
            java.util.Map r0 = r10.getRequiredTypeConverterClassesMap$room_runtime_release()
            int r1 = r0.size()
            boolean[] r1 = new boolean[r1]
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L18:
            boolean r2 = r0.hasNext()
            r3 = -1
            if (r2 == 0) goto La4
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            j7.c r4 = (j7.c) r4
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r2 = r2.iterator()
        L35:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L18
            java.lang.Object r5 = r2.next()
            j7.c r5 = (j7.c) r5
            java.util.List<java.lang.Object> r6 = r11.typeConverters
            java.util.Collection r6 = (java.util.Collection) r6
            int r6 = r6.size()
            int r6 = r6 + r3
            if (r6 < 0) goto L66
        L4c:
            int r7 = r6 + (-1)
            java.util.List<java.lang.Object> r8 = r11.typeConverters
            java.lang.Object r8 = r8.get(r6)
            r9 = r5
            kotlin.jvm.internal.f r9 = (kotlin.jvm.internal.f) r9
            boolean r8 = r9.d(r8)
            if (r8 == 0) goto L61
            r7 = 1
            r1[r6] = r7
            goto L67
        L61:
            if (r7 >= 0) goto L64
            goto L66
        L64:
            r6 = r7
            goto L4c
        L66:
            r6 = r3
        L67:
            if (r6 < 0) goto L73
            java.util.List<java.lang.Object> r7 = r11.typeConverters
            java.lang.Object r6 = r7.get(r6)
            r10.addTypeConverter$room_runtime_release(r5, r6)
            goto L35
        L73:
            kotlin.jvm.internal.f r5 = (kotlin.jvm.internal.f) r5
            java.lang.String r10 = r5.b()
            kotlin.jvm.internal.f r4 = (kotlin.jvm.internal.f) r4
            java.lang.String r11 = r4.b()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "A required type converter ("
            r0.<init>(r1)
            r0.append(r10)
            java.lang.String r10 = ") for "
            r0.append(r10)
            r0.append(r11)
            java.lang.String r10 = " is missing in the database configuration."
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            throw r11
        La4:
            java.util.List<java.lang.Object> r10 = r11.typeConverters
            java.util.Collection r10 = (java.util.Collection) r10
            int r10 = r10.size()
            int r10 = r10 + r3
            if (r10 < 0) goto Lc7
        Laf:
            int r0 = r10 + (-1)
            boolean r2 = r1[r10]
            if (r2 == 0) goto Lba
            if (r0 >= 0) goto Lb8
            goto Lc7
        Lb8:
            r10 = r0
            goto Laf
        Lba:
            java.util.List<java.lang.Object> r11 = r11.typeConverters
            java.lang.Object r10 = r11.get(r10)
            java.lang.String r11 = "Unexpected type converter "
            java.lang.String r0 = ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder."
            androidx.core.view.contentcapture.a.h(r10, r11, r0)
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt__RoomDatabaseKt.validateTypeConverters(androidx.room.RoomDatabase, androidx.room.DatabaseConfiguration):void");
    }
}
