package androidx.work.impl.model;

import androidx.sqlite.db.SupportSQLiteQuery;
import o7.w;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RawWorkInfoDaoKt {
    public static final r7.h getWorkInfoPojosFlow(RawWorkInfoDao rawWorkInfoDao, w wVar, SupportSQLiteQuery supportSQLiteQuery) {
        rawWorkInfoDao.getClass();
        wVar.getClass();
        supportSQLiteQuery.getClass();
        return WorkSpecDaoKt.dedup(rawWorkInfoDao.getWorkInfoPojosFlow(supportSQLiteQuery), wVar);
    }
}
