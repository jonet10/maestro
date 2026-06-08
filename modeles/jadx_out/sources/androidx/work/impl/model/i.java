package androidx.work.impl.model;

import androidx.collection.ArrayMap;
import androidx.sqlite.SQLiteConnection;
import d7.l;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class i implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f624a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f625b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ SQLiteConnection f626l;

    public /* synthetic */ i(WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection, int i) {
        this.f624a = i;
        this.f625b = workSpecDao_Impl;
        this.f626l = sQLiteConnection;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        x __fetchRelationshipWorkProgressAsandroidxWorkData$lambda$53;
        x __fetchRelationshipWorkTagAsjavaLangString$lambda$52;
        switch (this.f624a) {
            case 0:
                __fetchRelationshipWorkProgressAsandroidxWorkData$lambda$53 = WorkSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData$lambda$53(this.f625b, this.f626l, (ArrayMap) obj);
                return __fetchRelationshipWorkProgressAsandroidxWorkData$lambda$53;
            default:
                __fetchRelationshipWorkTagAsjavaLangString$lambda$52 = WorkSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString$lambda$52(this.f625b, this.f626l, (ArrayMap) obj);
                return __fetchRelationshipWorkTagAsjavaLangString$lambda$52;
        }
    }
}
