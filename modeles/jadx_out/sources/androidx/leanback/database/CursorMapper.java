package androidx.leanback.database;

import android.database.Cursor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class CursorMapper {
    private Cursor mCursor;

    public abstract Object bind(Cursor cursor);

    public abstract void bindColumns(Cursor cursor);

    public Object convert(Cursor cursor) {
        if (cursor != this.mCursor) {
            this.mCursor = cursor;
            bindColumns(cursor);
        }
        return bind(this.mCursor);
    }
}
