package androidx.work.impl.model;

import androidx.room.RoomRawQuery;
import androidx.sqlite.SQLiteConnection;
import d7.l;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class c implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f604a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f605b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ RoomRawQuery f606l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ RawWorkInfoDao_Impl f607m;

    public /* synthetic */ c(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl, int i) {
        this.f604a = i;
        this.f605b = str;
        this.f606l = roomRawQuery;
        this.f607m = rawWorkInfoDao_Impl;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        List workInfoPojos$lambda$0;
        List workInfoPojosFlow$lambda$2;
        List workInfoPojosLiveData$lambda$1;
        switch (this.f604a) {
            case 0:
                workInfoPojos$lambda$0 = RawWorkInfoDao_Impl.getWorkInfoPojos$lambda$0(this.f605b, this.f606l, this.f607m, (SQLiteConnection) obj);
                return workInfoPojos$lambda$0;
            case 1:
                workInfoPojosFlow$lambda$2 = RawWorkInfoDao_Impl.getWorkInfoPojosFlow$lambda$2(this.f605b, this.f606l, this.f607m, (SQLiteConnection) obj);
                return workInfoPojosFlow$lambda$2;
            default:
                workInfoPojosLiveData$lambda$1 = RawWorkInfoDao_Impl.getWorkInfoPojosLiveData$lambda$1(this.f605b, this.f606l, this.f607m, (SQLiteConnection) obj);
                return workInfoPojosLiveData$lambda$1;
        }
    }
}
