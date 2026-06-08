package androidx.sqlite.db;

import java.io.Closeable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i, byte[] bArr);

    void bindDouble(int i, double d10);

    void bindLong(int i, long j);

    void bindNull(int i);

    void bindString(int i, String str);

    void clearBindings();
}
