package androidx.room.util;

import androidx.annotation.IntRange;
import androidx.sqlite.SQLiteStatement;
import com.google.gson.internal.a;
import java.util.List;
import java.util.Map;
import r6.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MappedColumnsSQLiteStatementWrapper implements SQLiteStatement {
    private final Map<String, Integer> columnNameToIndexMap;
    private final String[] columnNames;
    private final SQLiteStatement delegate;
    private final int[] mapping;

    public MappedColumnsSQLiteStatementWrapper(SQLiteStatement sQLiteStatement, String[] strArr, int[] iArr) {
        sQLiteStatement.getClass();
        strArr.getClass();
        iArr.getClass();
        this.delegate = sQLiteStatement;
        this.columnNames = strArr;
        this.mapping = iArr;
        if (strArr.length != iArr.length) {
            a.p("Expected columnNames.size == mapping.size");
            throw null;
        }
        f fVar = new f();
        int length = strArr.length;
        int i = 0;
        int i6 = 0;
        while (i < length) {
            fVar.put(strArr[i], Integer.valueOf(this.mapping[i6]));
            i++;
            i6++;
        }
        int columnCount = getColumnCount();
        for (int i10 = 0; i10 < columnCount; i10++) {
            if (!fVar.containsKey(getColumnName(i10))) {
                fVar.put(getColumnName(i10), Integer.valueOf(i10));
            }
        }
        this.columnNameToIndexMap = fVar.c();
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindBlob */
    public void mo88bindBlob(@IntRange(from = 1) int i, byte[] bArr) {
        bArr.getClass();
        this.delegate.mo88bindBlob(i, bArr);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindBoolean(@IntRange(from = 1) int i, boolean z9) {
        this.delegate.bindBoolean(i, z9);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindDouble */
    public void mo89bindDouble(@IntRange(from = 1) int i, double d10) {
        this.delegate.mo89bindDouble(i, d10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindFloat(@IntRange(from = 1) int i, float f) {
        this.delegate.bindFloat(i, f);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindInt(@IntRange(from = 1) int i, int i6) {
        this.delegate.bindInt(i, i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindLong */
    public void mo90bindLong(@IntRange(from = 1) int i, long j) {
        this.delegate.mo90bindLong(i, j);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindNull */
    public void mo91bindNull(@IntRange(from = 1) int i) {
        this.delegate.mo91bindNull(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindText */
    public void mo92bindText(@IntRange(from = 1) int i, String str) {
        str.getClass();
        this.delegate.mo92bindText(i, str);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: clearBindings */
    public void mo93clearBindings() {
        this.delegate.mo93clearBindings();
    }

    @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public byte[] getBlob(@IntRange(from = 0) int i) {
        return this.delegate.getBlob(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean getBoolean(@IntRange(from = 0) int i) {
        return this.delegate.getBoolean(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnCount() {
        return this.delegate.getColumnCount();
    }

    public final int getColumnIndex(String str) {
        str.getClass();
        Integer num = this.columnNameToIndexMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getColumnName(@IntRange(from = 0) int i) {
        return this.delegate.getColumnName(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public List<String> getColumnNames() {
        return this.delegate.getColumnNames();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnType(@IntRange(from = 0) int i) {
        return this.delegate.getColumnType(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public double getDouble(@IntRange(from = 0) int i) {
        return this.delegate.getDouble(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public float getFloat(@IntRange(from = 0) int i) {
        return this.delegate.getFloat(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getInt(@IntRange(from = 0) int i) {
        return this.delegate.getInt(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public long getLong(@IntRange(from = 0) int i) {
        return this.delegate.getLong(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getText(@IntRange(from = 0) int i) {
        return this.delegate.getText(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean isNull(@IntRange(from = 0) int i) {
        return this.delegate.isNull(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        this.delegate.reset();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean step() {
        return this.delegate.step();
    }
}
