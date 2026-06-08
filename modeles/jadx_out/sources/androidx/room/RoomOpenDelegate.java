package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteConnection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class RoomOpenDelegate implements RoomOpenDelegateMarker {
    private final String identityHash;
    private final String legacyIdentityHash;
    private final int version;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z9, String str) {
            this.isValid = z9;
            this.expectedFoundMsg = str;
        }
    }

    public RoomOpenDelegate(int i, String str, String str2) {
        str.getClass();
        str2.getClass();
        this.version = i;
        this.identityHash = str;
        this.legacyIdentityHash = str2;
    }

    public abstract void createAllTables(SQLiteConnection sQLiteConnection);

    public abstract void dropAllTables(SQLiteConnection sQLiteConnection);

    public final String getIdentityHash() {
        return this.identityHash;
    }

    public final String getLegacyIdentityHash() {
        return this.legacyIdentityHash;
    }

    public final int getVersion() {
        return this.version;
    }

    public abstract void onCreate(SQLiteConnection sQLiteConnection);

    public abstract void onOpen(SQLiteConnection sQLiteConnection);

    public abstract void onPostMigrate(SQLiteConnection sQLiteConnection);

    public abstract void onPreMigrate(SQLiteConnection sQLiteConnection);

    public abstract ValidationResult onValidateSchema(SQLiteConnection sQLiteConnection);
}
