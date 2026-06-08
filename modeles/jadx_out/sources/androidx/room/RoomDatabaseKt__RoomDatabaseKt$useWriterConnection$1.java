package androidx.room;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.RoomDatabaseKt__RoomDatabaseKt", f = "RoomDatabase.kt", l = {496}, m = "useWriterConnection")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1<R> extends v6.c {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1(t6.c cVar) {
        super(cVar);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RoomDatabaseKt.useWriterConnection(null, null, this);
    }
}
