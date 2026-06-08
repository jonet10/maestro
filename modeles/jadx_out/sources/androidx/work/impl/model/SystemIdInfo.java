package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, primaryKeys = {"work_spec_id", "generation"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SystemIdInfo {

    @ColumnInfo(defaultValue = "0")
    private final int generation;

    @ColumnInfo(name = "system_id")
    public final int systemId;

    @ColumnInfo(name = "work_spec_id")
    public final String workSpecId;

    public SystemIdInfo(String str, int i, int i6) {
        str.getClass();
        this.workSpecId = str;
        this.generation = i;
        this.systemId = i6;
    }

    public static /* synthetic */ SystemIdInfo copy$default(SystemIdInfo systemIdInfo, String str, int i, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = systemIdInfo.workSpecId;
        }
        if ((i10 & 2) != 0) {
            i = systemIdInfo.generation;
        }
        if ((i10 & 4) != 0) {
            i6 = systemIdInfo.systemId;
        }
        return systemIdInfo.copy(str, i, i6);
    }

    public final String component1() {
        return this.workSpecId;
    }

    public final int component2() {
        return this.generation;
    }

    public final int component3() {
        return this.systemId;
    }

    public final SystemIdInfo copy(String str, int i, int i6) {
        str.getClass();
        return new SystemIdInfo(str, i, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
        return l.a(this.workSpecId, systemIdInfo.workSpecId) && this.generation == systemIdInfo.generation && this.systemId == systemIdInfo.systemId;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public int hashCode() {
        return (((this.workSpecId.hashCode() * 31) + this.generation) * 31) + this.systemId;
    }

    public String toString() {
        return "SystemIdInfo(workSpecId=" + this.workSpecId + ", generation=" + this.generation + ", systemId=" + this.systemId + ')';
    }
}
