package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import d7.l;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class f implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f614a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f615b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ List f616l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f617m;

    public /* synthetic */ f(String str, List list, WorkSpecDao_Impl workSpecDao_Impl, int i) {
        this.f614a = i;
        this.f615b = str;
        this.f616l = list;
        this.f617m = workSpecDao_Impl;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        List workStatusPojoFlowDataForIds$lambda$11;
        List workStatusPojoLiveDataForIds$lambda$10;
        List workStatusPojoForIds$lambda$9;
        switch (this.f614a) {
            case 0:
                workStatusPojoFlowDataForIds$lambda$11 = WorkSpecDao_Impl.getWorkStatusPojoFlowDataForIds$lambda$11(this.f615b, this.f616l, this.f617m, (SQLiteConnection) obj);
                return workStatusPojoFlowDataForIds$lambda$11;
            case 1:
                workStatusPojoLiveDataForIds$lambda$10 = WorkSpecDao_Impl.getWorkStatusPojoLiveDataForIds$lambda$10(this.f615b, this.f616l, this.f617m, (SQLiteConnection) obj);
                return workStatusPojoLiveDataForIds$lambda$10;
            default:
                workStatusPojoForIds$lambda$9 = WorkSpecDao_Impl.getWorkStatusPojoForIds$lambda$9(this.f615b, this.f616l, this.f617m, (SQLiteConnection) obj);
                return workStatusPojoForIds$lambda$9;
        }
    }
}
