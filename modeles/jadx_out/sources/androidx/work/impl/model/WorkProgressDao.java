package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.work.Data;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Dao
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface WorkProgressDao {
    @Query("DELETE from WorkProgress where work_spec_id=:workSpecId")
    void delete(String str);

    @Query("DELETE FROM WorkProgress")
    void deleteAll();

    @Query("SELECT progress FROM WorkProgress WHERE work_spec_id=:workSpecId")
    Data getProgressForWorkSpecId(String str);

    @Insert(onConflict = 1)
    void insert(WorkProgress workProgress);
}
