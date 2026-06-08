package androidx.work.impl.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Dao
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface DependencyDao {
    @Query("SELECT work_spec_id FROM dependency WHERE prerequisite_id=:id")
    List<String> getDependentWorkIds(String str);

    @Query("SELECT prerequisite_id FROM dependency WHERE work_spec_id=:id")
    List<String> getPrerequisites(String str);

    @Query("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=:id AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)")
    boolean hasCompletedAllPrerequisites(String str);

    @Query("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=:id")
    boolean hasDependents(String str);

    @Insert(onConflict = 5)
    void insertDependency(Dependency dependency);
}
