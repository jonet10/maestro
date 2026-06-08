package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Dao
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface PreferenceDao {
    @Query("SELECT long_value FROM Preference where `key`=:key")
    Long getLongValue(String str);

    @Query("SELECT long_value FROM Preference where `key`=:key")
    LiveData<Long> getObservableLongValue(String str);

    @Insert(onConflict = 1)
    void insertPreference(Preference preference);
}
