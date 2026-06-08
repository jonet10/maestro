package androidx.work.impl.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Dao
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface WorkNameDao {
    @Query("SELECT name FROM workname WHERE work_spec_id=:workSpecId")
    List<String> getNamesForWorkSpecId(String str);

    @Query("SELECT work_spec_id FROM workname WHERE name=:name")
    List<String> getWorkSpecIdsWithName(String str);

    @Insert(onConflict = 5)
    void insert(WorkName workName);
}
