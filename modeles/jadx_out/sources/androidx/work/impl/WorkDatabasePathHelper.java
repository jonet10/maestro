package androidx.work.impl;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import q6.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkDatabasePathHelper {
    public static final WorkDatabasePathHelper INSTANCE = new WorkDatabasePathHelper();

    private WorkDatabasePathHelper() {
    }

    public static final void migrateDatabase(Context context) {
        String str;
        String str2;
        String str3;
        context.getClass();
        WorkDatabasePathHelper workDatabasePathHelper = INSTANCE;
        if (workDatabasePathHelper.getDefaultDatabasePath(context).exists()) {
            Logger logger = Logger.get();
            str = WorkDatabasePathHelperKt.TAG;
            logger.debug(str, "Migrating WorkDatabase to the no-backup directory");
            for (Map.Entry<File, File> entry : workDatabasePathHelper.migrationPaths(context).entrySet()) {
                File key = entry.getKey();
                File value = entry.getValue();
                if (key.exists()) {
                    if (value.exists()) {
                        Logger logger2 = Logger.get();
                        str3 = WorkDatabasePathHelperKt.TAG;
                        logger2.warning(str3, "Over-writing contents of " + value);
                    }
                    String str4 = key.renameTo(value) ? "Migrated " + key + "to " + value : "Renaming " + key + " to " + value + " failed";
                    Logger logger3 = Logger.get();
                    str2 = WorkDatabasePathHelperKt.TAG;
                    logger3.debug(str2, str4);
                }
            }
        }
    }

    public final File getDatabasePath(Context context) {
        context.getClass();
        File noBackupFilesDir = context.getNoBackupFilesDir();
        noBackupFilesDir.getClass();
        return noBackupFilesDir;
    }

    public final File getDefaultDatabasePath(Context context) {
        context.getClass();
        File databasePath = context.getDatabasePath(WorkDatabasePathHelperKt.WORK_DATABASE_NAME);
        databasePath.getClass();
        return databasePath;
    }

    public final Map<File, File> migrationPaths(Context context) {
        String[] strArr;
        context.getClass();
        File defaultDatabasePath = getDefaultDatabasePath(context);
        File databasePath = getDatabasePath(context);
        strArr = WorkDatabasePathHelperKt.DATABASE_EXTRA_FILES;
        int h02 = a0.h0(strArr.length);
        if (h02 < 16) {
            h02 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(h02);
        for (String str : strArr) {
            linkedHashMap.put(new File(defaultDatabasePath.getPath() + str), new File(databasePath.getPath() + str));
        }
        if (linkedHashMap.isEmpty()) {
            Map<File, File> singletonMap = Collections.singletonMap(defaultDatabasePath, databasePath);
            singletonMap.getClass();
            return singletonMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put(defaultDatabasePath, databasePath);
        return linkedHashMap2;
    }
}
