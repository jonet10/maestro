package androidx.sqlite;

import androidx.annotation.IntRange;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface SQLiteStatement extends AutoCloseable {
    /* renamed from: bindBlob */
    void mo88bindBlob(@IntRange(from = 1) int i, byte[] bArr);

    void bindBoolean(@IntRange(from = 1) int i, boolean z9);

    /* renamed from: bindDouble */
    void mo89bindDouble(@IntRange(from = 1) int i, double d10);

    void bindFloat(@IntRange(from = 1) int i, float f);

    void bindInt(@IntRange(from = 1) int i, int i6);

    /* renamed from: bindLong */
    void mo90bindLong(@IntRange(from = 1) int i, long j);

    /* renamed from: bindNull */
    void mo91bindNull(@IntRange(from = 1) int i);

    /* renamed from: bindText */
    void mo92bindText(@IntRange(from = 1) int i, String str);

    /* renamed from: clearBindings */
    void mo93clearBindings();

    @Override // java.lang.AutoCloseable
    void close();

    byte[] getBlob(@IntRange(from = 0) int i);

    boolean getBoolean(@IntRange(from = 0) int i);

    int getColumnCount();

    String getColumnName(@IntRange(from = 0) int i);

    List<String> getColumnNames();

    int getColumnType(@IntRange(from = 0) int i);

    double getDouble(@IntRange(from = 0) int i);

    float getFloat(@IntRange(from = 0) int i);

    int getInt(@IntRange(from = 0) int i);

    long getLong(@IntRange(from = 0) int i);

    String getText(@IntRange(from = 0) int i);

    boolean isNull(@IntRange(from = 0) int i);

    void reset();

    boolean step();
}
