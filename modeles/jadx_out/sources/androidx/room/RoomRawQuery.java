package androidx.room;

import androidx.sqlite.SQLiteStatement;
import d7.l;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomRawQuery {
    private final l bindingFunction;
    private final String sql;

    public RoomRawQuery(String str, l lVar) {
        str.getClass();
        lVar.getClass();
        this.sql = str;
        this.bindingFunction = new b(lVar, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x _init_$lambda$0(SQLiteStatement sQLiteStatement) {
        sQLiteStatement.getClass();
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x bindingFunction$lambda$1(l lVar, SQLiteStatement sQLiteStatement) {
        sQLiteStatement.getClass();
        lVar.invoke(new BindOnlySQLiteStatement(sQLiteStatement));
        return x.f8463a;
    }

    public final l getBindingFunction() {
        return this.bindingFunction;
    }

    public final String getSql() {
        return this.sql;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomRawQuery(String str) {
        this(str, null, 2, 0 == true ? 1 : 0);
        str.getClass();
    }

    public /* synthetic */ RoomRawQuery(String str, l lVar, int i, kotlin.jvm.internal.g gVar) {
        this(str, (i & 2) != 0 ? new f(0) : lVar);
    }
}
