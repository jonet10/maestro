package androidx.room.driver;

import a1.b;
import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.l;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import androidx.room.driver.SupportSQLiteStatement;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.g;
import l7.m;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class SupportSQLiteStatement implements SQLiteStatement {
    public static final Companion Companion = new Companion(null);
    private final SupportSQLiteDatabase db;
    private boolean isClosed;
    private final String sql;

    private SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        this.db = supportSQLiteDatabase;
        this.sql = str;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindBoolean(int i, boolean z9) {
        mo90bindLong(i, z9 ? 1L : 0L);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindFloat(int i, float f) {
        mo89bindDouble(i, f);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindInt(int i, int i6) {
        mo90bindLong(i, i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final /* synthetic */ boolean getBoolean(int i) {
        return l.c(this, i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final /* synthetic */ List getColumnNames() {
        return l.d(this);
    }

    public final SupportSQLiteDatabase getDb() {
        return this.db;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final float getFloat(int i) {
        return (float) getDouble(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final int getInt(int i) {
        return (int) getLong(i);
    }

    public final String getSql() {
        return this.sql;
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final void setClosed(boolean z9) {
        this.isClosed = z9;
    }

    public final void throwIfClosed() {
        if (this.isClosed) {
            throw l.p(21, "statement is closed");
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class SupportAndroidSQLiteStatement extends SupportSQLiteStatement {
        public static final Companion Companion = new Companion(null);
        private int[] bindingTypes;
        private byte[][] blobBindings;
        private Cursor cursor;
        private double[] doubleBindings;
        private long[] longBindings;
        private String[] stringBindings;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SupportAndroidSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            super(supportSQLiteDatabase, str, null);
            supportSQLiteDatabase.getClass();
            str.getClass();
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        private final void ensureCapacity(int i, int i6) {
            int i10 = i6 + 1;
            int[] iArr = this.bindingTypes;
            if (iArr.length < i10) {
                this.bindingTypes = Arrays.copyOf(iArr, i10);
            }
            if (i == 1) {
                long[] jArr = this.longBindings;
                if (jArr.length < i10) {
                    this.longBindings = Arrays.copyOf(jArr, i10);
                    return;
                }
                return;
            }
            if (i == 2) {
                double[] dArr = this.doubleBindings;
                if (dArr.length < i10) {
                    this.doubleBindings = Arrays.copyOf(dArr, i10);
                    return;
                }
                return;
            }
            if (i == 3) {
                String[] strArr = this.stringBindings;
                if (strArr.length < i10) {
                    this.stringBindings = (String[]) Arrays.copyOf(strArr, i10);
                    return;
                }
                return;
            }
            if (i != 4) {
                return;
            }
            byte[][] bArr = this.blobBindings;
            if (bArr.length < i10) {
                this.blobBindings = (byte[][]) Arrays.copyOf(bArr, i10);
            }
        }

        private final void ensureCursor() {
            if (this.cursor == null) {
                this.cursor = getDb().query(new SupportSQLiteQuery() { // from class: androidx.room.driver.SupportSQLiteStatement$SupportAndroidSQLiteStatement$ensureCursor$1
                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
                        int[] iArr;
                        int[] iArr2;
                        long[] jArr;
                        double[] dArr;
                        String[] strArr;
                        byte[][] bArr;
                        supportSQLiteProgram.getClass();
                        iArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.bindingTypes;
                        int length = iArr.length;
                        for (int i = 1; i < length; i++) {
                            iArr2 = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.bindingTypes;
                            int i6 = iArr2[i];
                            if (i6 == 1) {
                                jArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.longBindings;
                                supportSQLiteProgram.bindLong(i, jArr[i]);
                            } else if (i6 == 2) {
                                dArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.doubleBindings;
                                supportSQLiteProgram.bindDouble(i, dArr[i]);
                            } else if (i6 == 3) {
                                strArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.stringBindings;
                                String str = strArr[i];
                                str.getClass();
                                supportSQLiteProgram.bindString(i, str);
                            } else if (i6 == 4) {
                                bArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.blobBindings;
                                byte[] bArr2 = bArr[i];
                                bArr2.getClass();
                                supportSQLiteProgram.bindBlob(i, bArr2);
                            } else if (i6 == 5) {
                                supportSQLiteProgram.bindNull(i);
                            }
                        }
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public int getArgCount() {
                        int[] iArr;
                        iArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.bindingTypes;
                        return iArr.length;
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public String getSql() {
                        return SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.getSql();
                    }
                });
            }
        }

        private final void throwIfInvalidColumn(Cursor cursor, int i) {
            if (i < 0 || i >= cursor.getColumnCount()) {
                throw l.p(25, "column index out of range");
            }
        }

        private final Cursor throwIfNoRow() {
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor;
            }
            throw l.p(21, "no row");
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo88bindBlob(int i, byte[] bArr) {
            bArr.getClass();
            throwIfClosed();
            ensureCapacity(4, i);
            this.bindingTypes[i] = 4;
            this.blobBindings[i] = bArr;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo89bindDouble(int i, double d10) {
            throwIfClosed();
            ensureCapacity(2, i);
            this.bindingTypes[i] = 2;
            this.doubleBindings[i] = d10;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo90bindLong(int i, long j) {
            throwIfClosed();
            ensureCapacity(1, i);
            this.bindingTypes[i] = 1;
            this.longBindings[i] = j;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo91bindNull(int i) {
            throwIfClosed();
            ensureCapacity(5, i);
            this.bindingTypes[i] = 5;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo92bindText(int i, String str) {
            str.getClass();
            throwIfClosed();
            ensureCapacity(3, i);
            this.bindingTypes[i] = 3;
            this.stringBindings[i] = str;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo93clearBindings() {
            throwIfClosed();
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (!isClosed()) {
                mo93clearBindings();
                reset();
            }
            setClosed(true);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int i) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i);
            byte[] blob = throwIfNoRow.getBlob(i);
            blob.getClass();
            return blob;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.getColumnCount();
            }
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor == null) {
                a.i("Required value was null.");
                return null;
            }
            throwIfInvalidColumn(cursor, i);
            String columnName = cursor.getColumnName(i);
            columnName.getClass();
            return columnName;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int i) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                throwIfInvalidColumn(cursor, i);
                return Companion.getDataType(cursor, i);
            }
            a.i("Required value was null.");
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i);
            return throwIfNoRow.getDouble(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i);
            return throwIfNoRow.getLong(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int i) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i);
            String string = throwIfNoRow.getString(i);
            string.getClass();
            return string;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i);
            return throwIfNoRow.isNull(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            throwIfClosed();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                cursor.close();
            }
            this.cursor = null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            a.i("Required value was null.");
            return false;
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int getDataType(Cursor cursor, int i) {
                int type = cursor.getType(i);
                int type2 = cursor.getType(i);
                if (type2 == 0) {
                    return 5;
                }
                int i6 = 1;
                if (type2 != 1) {
                    i6 = 2;
                    if (type2 != 2) {
                        i6 = 3;
                        if (type2 != 3) {
                            if (type2 == 4) {
                                return 4;
                            }
                            o.h(type, "Unknown field type: ");
                            return 0;
                        }
                    }
                }
                return i6;
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private final boolean isRowStatement(String str) {
            String obj = m.K0(str).toString();
            if (obj.length() < 3) {
                return false;
            }
            String upperCase = obj.substring(0, 3).toUpperCase(Locale.ROOT);
            upperCase.getClass();
            int hashCode = upperCase.hashCode();
            if (hashCode != 79487) {
                if (hashCode != 81978) {
                    if (hashCode == 85954 && upperCase.equals("WIT")) {
                        return true;
                    }
                } else if (upperCase.equals("SEL")) {
                    return true;
                }
            } else if (upperCase.equals("PRA")) {
                return true;
            }
            return false;
        }

        public final SupportSQLiteStatement create(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            supportSQLiteDatabase.getClass();
            str.getClass();
            return isRowStatement(str) ? new SupportAndroidSQLiteStatement(supportSQLiteDatabase, str) : new SupportOtherAndroidSQLiteStatement(supportSQLiteDatabase, str);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str, g gVar) {
        this(supportSQLiteDatabase, str);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class SupportOtherAndroidSQLiteStatement extends SupportSQLiteStatement {
        private final androidx.sqlite.db.SupportSQLiteStatement delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SupportOtherAndroidSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            super(supportSQLiteDatabase, str, null);
            supportSQLiteDatabase.getClass();
            str.getClass();
            this.delegate = supportSQLiteDatabase.compileStatement(str);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo88bindBlob(int i, byte[] bArr) {
            bArr.getClass();
            throwIfClosed();
            this.delegate.bindBlob(i, bArr);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo89bindDouble(int i, double d10) {
            throwIfClosed();
            this.delegate.bindDouble(i, d10);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo90bindLong(int i, long j) {
            throwIfClosed();
            this.delegate.bindLong(i, j);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo91bindNull(int i) {
            throwIfClosed();
            this.delegate.bindNull(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo92bindText(int i, String str) {
            str.getClass();
            throwIfClosed();
            this.delegate.bindString(i, str);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo93clearBindings() {
            throwIfClosed();
            this.delegate.clearBindings();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
            setClosed(true);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new b();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new b();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new b();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new b();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new b();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new b();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new b();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            throwIfClosed();
            this.delegate.execute();
            return false;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
        }
    }
}
