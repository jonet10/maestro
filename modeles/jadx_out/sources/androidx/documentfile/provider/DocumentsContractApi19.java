package androidx.documentfile.provider;

import a4.x;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class DocumentsContractApi19 {
    private static final String TAG = "DocumentFile";

    private DocumentsContractApi19() {
    }

    public static boolean canRead(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(getRawType(context, uri));
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String rawType = getRawType(context, uri);
        int queryForInt = queryForInt(context, uri, "flags", 0);
        if (TextUtils.isEmpty(rawType)) {
            return false;
        }
        if ((queryForInt & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(rawType) || (queryForInt & 8) == 0) {
            return (TextUtils.isEmpty(rawType) || (queryForInt & 2) == 0) ? false : true;
        }
        return true;
    }

    private static void closeQuietly(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                x.z(autoCloseable);
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean exists(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"document_id"}, null, null, null);
                boolean z9 = cursor.getCount() > 0;
                closeQuietly(cursor);
                return z9;
            } catch (Exception e10) {
                Log.w(TAG, "Failed query: " + e10);
                closeQuietly(cursor);
                return false;
            }
        } catch (Throwable th) {
            closeQuietly(cursor);
            throw th;
        }
    }

    public static long getFlags(Context context, Uri uri) {
        return queryForLong(context, uri, "flags", 0L);
    }

    public static String getName(Context context, Uri uri) {
        return queryForString(context, uri, "_display_name", null);
    }

    private static String getRawType(Context context, Uri uri) {
        return queryForString(context, uri, "mime_type", null);
    }

    public static String getType(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        if ("vnd.android.document/directory".equals(rawType)) {
            return null;
        }
        return rawType;
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(getRawType(context, uri));
    }

    public static boolean isFile(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        return ("vnd.android.document/directory".equals(rawType) || TextUtils.isEmpty(rawType)) ? false : true;
    }

    public static boolean isVirtual(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri) && (getFlags(context, uri) & 512) != 0;
    }

    public static long lastModified(Context context, Uri uri) {
        return queryForLong(context, uri, "last_modified", 0L);
    }

    public static long length(Context context, Uri uri) {
        return queryForLong(context, uri, "_size", 0L);
    }

    private static int queryForInt(Context context, Uri uri, String str, int i) {
        return (int) queryForLong(context, uri, str, i);
    }

    private static long queryForLong(Context context, Uri uri, String str, long j) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(uri, new String[]{str}, null, null, null);
                if (!cursor.moveToFirst() || cursor.isNull(0)) {
                    closeQuietly(cursor);
                    return j;
                }
                long j6 = cursor.getLong(0);
                closeQuietly(cursor);
                return j6;
            } catch (Exception e10) {
                Log.w(TAG, "Failed query: " + e10);
                closeQuietly(cursor);
                return j;
            }
        } catch (Throwable th) {
            closeQuietly(cursor);
            throw th;
        }
    }

    private static String queryForString(Context context, Uri uri, String str, String str2) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(uri, new String[]{str}, null, null, null);
                if (!cursor.moveToFirst() || cursor.isNull(0)) {
                    closeQuietly(cursor);
                    return str2;
                }
                String string = cursor.getString(0);
                closeQuietly(cursor);
                return string;
            } catch (Exception e10) {
                Log.w(TAG, "Failed query: " + e10);
                closeQuietly(cursor);
                return str2;
            }
        } catch (Throwable th) {
            closeQuietly(cursor);
            throw th;
        }
    }
}
