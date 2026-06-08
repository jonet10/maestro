package androidx.work.impl.model;

import a4.x;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.RoomSQLiteQuery;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.NetworkRequestCompat;
import d7.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import q6.a0;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.__db = roomDatabase;
    }

    private final void __fetchRelationshipWorkProgressAsandroidxWorkData(SQLiteConnection sQLiteConnection, ArrayMap<String, List<Data>> arrayMap) {
        Set<String> keySet = arrayMap.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            RelationUtil.recursiveFetchArrayMap(arrayMap, true, new b(this, sQLiteConnection, 0));
            return;
        }
        StringBuilder t9 = x.t("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        StringUtil.appendPlaceholders(t9, keySet.size());
        t9.append(")");
        SQLiteStatement prepare = sQLiteConnection.prepare(t9.toString());
        Iterator<String> it = keySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            prepare.mo92bindText(i, it.next());
            i++;
        }
        try {
            int columnIndex = SQLiteStatementUtil.getColumnIndex(prepare, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (prepare.step()) {
                List<Data> list = arrayMap.get(prepare.getText(columnIndex));
                if (list != null) {
                    list.add(Data.Companion.fromByteArray(prepare.getBlob(0)));
                }
            }
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p6.x __fetchRelationshipWorkProgressAsandroidxWorkData$lambda$4(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap arrayMap) {
        arrayMap.getClass();
        rawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap);
        return p6.x.f8463a;
    }

    private final void __fetchRelationshipWorkTagAsjavaLangString(SQLiteConnection sQLiteConnection, ArrayMap<String, List<String>> arrayMap) {
        Set<String> keySet = arrayMap.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            RelationUtil.recursiveFetchArrayMap(arrayMap, true, new b(this, sQLiteConnection, 1));
            return;
        }
        StringBuilder t9 = x.t("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        StringUtil.appendPlaceholders(t9, keySet.size());
        t9.append(")");
        SQLiteStatement prepare = sQLiteConnection.prepare(t9.toString());
        Iterator<String> it = keySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            prepare.mo92bindText(i, it.next());
            i++;
        }
        try {
            int columnIndex = SQLiteStatementUtil.getColumnIndex(prepare, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (prepare.step()) {
                List<String> list = arrayMap.get(prepare.getText(columnIndex));
                if (list != null) {
                    list.add(prepare.getText(0));
                }
            }
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p6.x __fetchRelationshipWorkTagAsjavaLangString$lambda$3(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap arrayMap) {
        arrayMap.getClass();
        rawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
        return p6.x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkInfoPojos$lambda$0(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection) {
        int i;
        int i6;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z9;
        int i18;
        boolean z10;
        int i19;
        boolean z11;
        int i20;
        int i21;
        int i22;
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            roomRawQuery.getBindingFunction().invoke(prepare);
            int columnIndex = SQLiteStatementUtil.getColumnIndex(prepare, "id");
            int columnIndex2 = SQLiteStatementUtil.getColumnIndex(prepare, "state");
            int columnIndex3 = SQLiteStatementUtil.getColumnIndex(prepare, "output");
            int columnIndex4 = SQLiteStatementUtil.getColumnIndex(prepare, "initial_delay");
            int columnIndex5 = SQLiteStatementUtil.getColumnIndex(prepare, "interval_duration");
            int columnIndex6 = SQLiteStatementUtil.getColumnIndex(prepare, "flex_duration");
            int columnIndex7 = SQLiteStatementUtil.getColumnIndex(prepare, "run_attempt_count");
            int columnIndex8 = SQLiteStatementUtil.getColumnIndex(prepare, "backoff_policy");
            int columnIndex9 = SQLiteStatementUtil.getColumnIndex(prepare, "backoff_delay_duration");
            int columnIndex10 = SQLiteStatementUtil.getColumnIndex(prepare, "last_enqueue_time");
            int columnIndex11 = SQLiteStatementUtil.getColumnIndex(prepare, "period_count");
            int columnIndex12 = SQLiteStatementUtil.getColumnIndex(prepare, "generation");
            int columnIndex13 = SQLiteStatementUtil.getColumnIndex(prepare, "next_schedule_time_override");
            int columnIndex14 = SQLiteStatementUtil.getColumnIndex(prepare, "stop_reason");
            int columnIndex15 = SQLiteStatementUtil.getColumnIndex(prepare, "required_network_type");
            int columnIndex16 = SQLiteStatementUtil.getColumnIndex(prepare, "required_network_request");
            int columnIndex17 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_charging");
            int columnIndex18 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_device_idle");
            int columnIndex19 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_battery_not_low");
            int columnIndex20 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_storage_not_low");
            int columnIndex21 = SQLiteStatementUtil.getColumnIndex(prepare, "trigger_content_update_delay");
            int columnIndex22 = SQLiteStatementUtil.getColumnIndex(prepare, "trigger_max_content_delay");
            int columnIndex23 = SQLiteStatementUtil.getColumnIndex(prepare, "content_uri_triggers");
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            int i23 = columnIndex12;
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (prepare.step()) {
                int i24 = columnIndex11;
                String text = prepare.getText(columnIndex);
                if (arrayMap.containsKey(text)) {
                    i22 = columnIndex10;
                } else {
                    i22 = columnIndex10;
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(columnIndex);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
                columnIndex11 = i24;
                columnIndex10 = i22;
            }
            int i25 = columnIndex10;
            int i26 = columnIndex11;
            prepare.reset();
            rawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            rawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                if (columnIndex == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'id', found NULL value instead.");
                }
                String text3 = prepare.getText(columnIndex);
                if (columnIndex2 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'state', found NULL value instead.");
                }
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(columnIndex2));
                if (columnIndex3 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'output', found NULL value instead.");
                }
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(columnIndex3));
                long j = columnIndex4 == -1 ? 0L : prepare.getLong(columnIndex4);
                long j6 = columnIndex5 == -1 ? 0L : prepare.getLong(columnIndex5);
                long j10 = columnIndex6 == -1 ? 0L : prepare.getLong(columnIndex6);
                boolean z12 = false;
                int i27 = columnIndex7 == -1 ? 0 : (int) prepare.getLong(columnIndex7);
                if (columnIndex8 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'backoff_policy', found NULL value instead.");
                }
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(columnIndex8));
                long j11 = columnIndex9 == -1 ? 0L : prepare.getLong(columnIndex9);
                int i28 = i25;
                long j12 = i28 == -1 ? 0L : prepare.getLong(i28);
                int i29 = i26;
                if (i29 == -1) {
                    i = columnIndex2;
                    i6 = columnIndex3;
                    i10 = 0;
                } else {
                    i = columnIndex2;
                    i6 = columnIndex3;
                    i10 = (int) prepare.getLong(i29);
                }
                int i30 = i23;
                if (i30 == -1) {
                    i11 = columnIndex4;
                    i12 = 0;
                } else {
                    i11 = columnIndex4;
                    i12 = (int) prepare.getLong(i30);
                }
                int i31 = columnIndex13;
                long j13 = i31 == -1 ? 0L : prepare.getLong(i31);
                int i32 = columnIndex14;
                if (i32 == -1) {
                    i13 = i30;
                    i14 = i31;
                    i15 = 0;
                } else {
                    i13 = i30;
                    i14 = i31;
                    i15 = (int) prepare.getLong(i32);
                }
                int i33 = columnIndex15;
                if (i33 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_type', found NULL value instead.");
                }
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(i33));
                int i34 = columnIndex16;
                if (i34 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_request', found NULL value instead.");
                }
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(i34));
                int i35 = columnIndex17;
                if (i35 == -1) {
                    i16 = i33;
                    i17 = i34;
                    z9 = false;
                } else {
                    i16 = i33;
                    i17 = i34;
                    z9 = ((int) prepare.getLong(i35)) != 0;
                }
                int i36 = columnIndex18;
                if (i36 == -1) {
                    i18 = i35;
                    z10 = false;
                } else {
                    i18 = i35;
                    z10 = ((int) prepare.getLong(i36)) != 0;
                }
                int i37 = columnIndex19;
                if (i37 == -1) {
                    i19 = columnIndex5;
                    z11 = false;
                } else {
                    i19 = columnIndex5;
                    z11 = ((int) prepare.getLong(i37)) != 0;
                }
                int i38 = columnIndex20;
                if (i38 == -1) {
                    i20 = i36;
                    i21 = i37;
                } else {
                    i20 = i36;
                    i21 = i37;
                    if (((int) prepare.getLong(i38)) != 0) {
                        z12 = true;
                    }
                }
                int i39 = columnIndex21;
                boolean z13 = z12;
                long j14 = i39 == -1 ? 0L : prepare.getLong(i39);
                int i40 = columnIndex22;
                long j15 = i40 == -1 ? 0L : prepare.getLong(i40);
                columnIndex21 = i39;
                int i41 = columnIndex23;
                if (i41 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'content_uri_triggers', found NULL value instead.");
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z9, z10, z11, z13, j14, j15, WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(i41)));
                Object g02 = a0.g0(arrayMap, prepare.getText(columnIndex));
                g02.getClass();
                List list = (List) g02;
                Object g03 = a0.g0(arrayMap2, prepare.getText(columnIndex));
                g03.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j, j6, j10, constraints, i27, intToBackoffPolicy, j11, j12, i10, i12, j13, i15, list, (List) g03));
                int i42 = i11;
                i23 = i13;
                columnIndex13 = i14;
                columnIndex14 = i32;
                columnIndex15 = i16;
                columnIndex17 = i18;
                columnIndex18 = i20;
                columnIndex5 = i19;
                columnIndex19 = i21;
                columnIndex20 = i38;
                columnIndex4 = i42;
                columnIndex23 = i41;
                columnIndex22 = i40;
                columnIndex2 = i;
                columnIndex3 = i6;
                columnIndex16 = i17;
                i25 = i28;
                i26 = i29;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkInfoPojosFlow$lambda$2(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection) {
        int i;
        int i6;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z9;
        int i18;
        boolean z10;
        int i19;
        boolean z11;
        int i20;
        int i21;
        int i22;
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            roomRawQuery.getBindingFunction().invoke(prepare);
            int columnIndex = SQLiteStatementUtil.getColumnIndex(prepare, "id");
            int columnIndex2 = SQLiteStatementUtil.getColumnIndex(prepare, "state");
            int columnIndex3 = SQLiteStatementUtil.getColumnIndex(prepare, "output");
            int columnIndex4 = SQLiteStatementUtil.getColumnIndex(prepare, "initial_delay");
            int columnIndex5 = SQLiteStatementUtil.getColumnIndex(prepare, "interval_duration");
            int columnIndex6 = SQLiteStatementUtil.getColumnIndex(prepare, "flex_duration");
            int columnIndex7 = SQLiteStatementUtil.getColumnIndex(prepare, "run_attempt_count");
            int columnIndex8 = SQLiteStatementUtil.getColumnIndex(prepare, "backoff_policy");
            int columnIndex9 = SQLiteStatementUtil.getColumnIndex(prepare, "backoff_delay_duration");
            int columnIndex10 = SQLiteStatementUtil.getColumnIndex(prepare, "last_enqueue_time");
            int columnIndex11 = SQLiteStatementUtil.getColumnIndex(prepare, "period_count");
            int columnIndex12 = SQLiteStatementUtil.getColumnIndex(prepare, "generation");
            int columnIndex13 = SQLiteStatementUtil.getColumnIndex(prepare, "next_schedule_time_override");
            int columnIndex14 = SQLiteStatementUtil.getColumnIndex(prepare, "stop_reason");
            int columnIndex15 = SQLiteStatementUtil.getColumnIndex(prepare, "required_network_type");
            int columnIndex16 = SQLiteStatementUtil.getColumnIndex(prepare, "required_network_request");
            int columnIndex17 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_charging");
            int columnIndex18 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_device_idle");
            int columnIndex19 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_battery_not_low");
            int columnIndex20 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_storage_not_low");
            int columnIndex21 = SQLiteStatementUtil.getColumnIndex(prepare, "trigger_content_update_delay");
            int columnIndex22 = SQLiteStatementUtil.getColumnIndex(prepare, "trigger_max_content_delay");
            int columnIndex23 = SQLiteStatementUtil.getColumnIndex(prepare, "content_uri_triggers");
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            int i23 = columnIndex12;
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (prepare.step()) {
                int i24 = columnIndex11;
                String text = prepare.getText(columnIndex);
                if (arrayMap.containsKey(text)) {
                    i22 = columnIndex10;
                } else {
                    i22 = columnIndex10;
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(columnIndex);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
                columnIndex11 = i24;
                columnIndex10 = i22;
            }
            int i25 = columnIndex10;
            int i26 = columnIndex11;
            prepare.reset();
            rawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            rawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                if (columnIndex == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'id', found NULL value instead.");
                }
                String text3 = prepare.getText(columnIndex);
                if (columnIndex2 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'state', found NULL value instead.");
                }
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(columnIndex2));
                if (columnIndex3 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'output', found NULL value instead.");
                }
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(columnIndex3));
                long j = columnIndex4 == -1 ? 0L : prepare.getLong(columnIndex4);
                long j6 = columnIndex5 == -1 ? 0L : prepare.getLong(columnIndex5);
                long j10 = columnIndex6 == -1 ? 0L : prepare.getLong(columnIndex6);
                boolean z12 = false;
                int i27 = columnIndex7 == -1 ? 0 : (int) prepare.getLong(columnIndex7);
                if (columnIndex8 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'backoff_policy', found NULL value instead.");
                }
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(columnIndex8));
                long j11 = columnIndex9 == -1 ? 0L : prepare.getLong(columnIndex9);
                int i28 = i25;
                long j12 = i28 == -1 ? 0L : prepare.getLong(i28);
                int i29 = i26;
                if (i29 == -1) {
                    i = columnIndex2;
                    i6 = columnIndex3;
                    i10 = 0;
                } else {
                    i = columnIndex2;
                    i6 = columnIndex3;
                    i10 = (int) prepare.getLong(i29);
                }
                int i30 = i23;
                if (i30 == -1) {
                    i11 = columnIndex4;
                    i12 = 0;
                } else {
                    i11 = columnIndex4;
                    i12 = (int) prepare.getLong(i30);
                }
                int i31 = columnIndex13;
                long j13 = i31 == -1 ? 0L : prepare.getLong(i31);
                int i32 = columnIndex14;
                if (i32 == -1) {
                    i13 = i30;
                    i14 = i31;
                    i15 = 0;
                } else {
                    i13 = i30;
                    i14 = i31;
                    i15 = (int) prepare.getLong(i32);
                }
                int i33 = columnIndex15;
                if (i33 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_type', found NULL value instead.");
                }
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(i33));
                int i34 = columnIndex16;
                if (i34 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_request', found NULL value instead.");
                }
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(i34));
                int i35 = columnIndex17;
                if (i35 == -1) {
                    i16 = i33;
                    i17 = i34;
                    z9 = false;
                } else {
                    i16 = i33;
                    i17 = i34;
                    z9 = ((int) prepare.getLong(i35)) != 0;
                }
                int i36 = columnIndex18;
                if (i36 == -1) {
                    i18 = i35;
                    z10 = false;
                } else {
                    i18 = i35;
                    z10 = ((int) prepare.getLong(i36)) != 0;
                }
                int i37 = columnIndex19;
                if (i37 == -1) {
                    i19 = columnIndex5;
                    z11 = false;
                } else {
                    i19 = columnIndex5;
                    z11 = ((int) prepare.getLong(i37)) != 0;
                }
                int i38 = columnIndex20;
                if (i38 == -1) {
                    i20 = i36;
                    i21 = i37;
                } else {
                    i20 = i36;
                    i21 = i37;
                    if (((int) prepare.getLong(i38)) != 0) {
                        z12 = true;
                    }
                }
                int i39 = columnIndex21;
                boolean z13 = z12;
                long j14 = i39 == -1 ? 0L : prepare.getLong(i39);
                int i40 = columnIndex22;
                long j15 = i40 == -1 ? 0L : prepare.getLong(i40);
                columnIndex21 = i39;
                int i41 = columnIndex23;
                if (i41 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'content_uri_triggers', found NULL value instead.");
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z9, z10, z11, z13, j14, j15, WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(i41)));
                Object g02 = a0.g0(arrayMap, prepare.getText(columnIndex));
                g02.getClass();
                List list = (List) g02;
                Object g03 = a0.g0(arrayMap2, prepare.getText(columnIndex));
                g03.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j, j6, j10, constraints, i27, intToBackoffPolicy, j11, j12, i10, i12, j13, i15, list, (List) g03));
                int i42 = i11;
                i23 = i13;
                columnIndex13 = i14;
                columnIndex14 = i32;
                columnIndex15 = i16;
                columnIndex17 = i18;
                columnIndex18 = i20;
                columnIndex5 = i19;
                columnIndex19 = i21;
                columnIndex20 = i38;
                columnIndex4 = i42;
                columnIndex23 = i41;
                columnIndex22 = i40;
                columnIndex2 = i;
                columnIndex3 = i6;
                columnIndex16 = i17;
                i25 = i28;
                i26 = i29;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkInfoPojosLiveData$lambda$1(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection) {
        int i;
        int i6;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z9;
        int i18;
        boolean z10;
        int i19;
        boolean z11;
        int i20;
        int i21;
        int i22;
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            roomRawQuery.getBindingFunction().invoke(prepare);
            int columnIndex = SQLiteStatementUtil.getColumnIndex(prepare, "id");
            int columnIndex2 = SQLiteStatementUtil.getColumnIndex(prepare, "state");
            int columnIndex3 = SQLiteStatementUtil.getColumnIndex(prepare, "output");
            int columnIndex4 = SQLiteStatementUtil.getColumnIndex(prepare, "initial_delay");
            int columnIndex5 = SQLiteStatementUtil.getColumnIndex(prepare, "interval_duration");
            int columnIndex6 = SQLiteStatementUtil.getColumnIndex(prepare, "flex_duration");
            int columnIndex7 = SQLiteStatementUtil.getColumnIndex(prepare, "run_attempt_count");
            int columnIndex8 = SQLiteStatementUtil.getColumnIndex(prepare, "backoff_policy");
            int columnIndex9 = SQLiteStatementUtil.getColumnIndex(prepare, "backoff_delay_duration");
            int columnIndex10 = SQLiteStatementUtil.getColumnIndex(prepare, "last_enqueue_time");
            int columnIndex11 = SQLiteStatementUtil.getColumnIndex(prepare, "period_count");
            int columnIndex12 = SQLiteStatementUtil.getColumnIndex(prepare, "generation");
            int columnIndex13 = SQLiteStatementUtil.getColumnIndex(prepare, "next_schedule_time_override");
            int columnIndex14 = SQLiteStatementUtil.getColumnIndex(prepare, "stop_reason");
            int columnIndex15 = SQLiteStatementUtil.getColumnIndex(prepare, "required_network_type");
            int columnIndex16 = SQLiteStatementUtil.getColumnIndex(prepare, "required_network_request");
            int columnIndex17 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_charging");
            int columnIndex18 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_device_idle");
            int columnIndex19 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_battery_not_low");
            int columnIndex20 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_storage_not_low");
            int columnIndex21 = SQLiteStatementUtil.getColumnIndex(prepare, "trigger_content_update_delay");
            int columnIndex22 = SQLiteStatementUtil.getColumnIndex(prepare, "trigger_max_content_delay");
            int columnIndex23 = SQLiteStatementUtil.getColumnIndex(prepare, "content_uri_triggers");
            ArrayMap<String, List<String>> arrayMap = new ArrayMap<>();
            int i23 = columnIndex12;
            ArrayMap<String, List<Data>> arrayMap2 = new ArrayMap<>();
            while (prepare.step()) {
                int i24 = columnIndex11;
                String text = prepare.getText(columnIndex);
                if (arrayMap.containsKey(text)) {
                    i22 = columnIndex10;
                } else {
                    i22 = columnIndex10;
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = prepare.getText(columnIndex);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
                columnIndex11 = i24;
                columnIndex10 = i22;
            }
            int i25 = columnIndex10;
            int i26 = columnIndex11;
            prepare.reset();
            rawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
            rawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                if (columnIndex == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'id', found NULL value instead.");
                }
                String text3 = prepare.getText(columnIndex);
                if (columnIndex2 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'state', found NULL value instead.");
                }
                WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(columnIndex2));
                if (columnIndex3 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'output', found NULL value instead.");
                }
                Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(columnIndex3));
                long j = columnIndex4 == -1 ? 0L : prepare.getLong(columnIndex4);
                long j6 = columnIndex5 == -1 ? 0L : prepare.getLong(columnIndex5);
                long j10 = columnIndex6 == -1 ? 0L : prepare.getLong(columnIndex6);
                boolean z12 = false;
                int i27 = columnIndex7 == -1 ? 0 : (int) prepare.getLong(columnIndex7);
                if (columnIndex8 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'backoff_policy', found NULL value instead.");
                }
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(columnIndex8));
                long j11 = columnIndex9 == -1 ? 0L : prepare.getLong(columnIndex9);
                int i28 = i25;
                long j12 = i28 == -1 ? 0L : prepare.getLong(i28);
                int i29 = i26;
                if (i29 == -1) {
                    i = columnIndex2;
                    i6 = columnIndex3;
                    i10 = 0;
                } else {
                    i = columnIndex2;
                    i6 = columnIndex3;
                    i10 = (int) prepare.getLong(i29);
                }
                int i30 = i23;
                if (i30 == -1) {
                    i11 = columnIndex4;
                    i12 = 0;
                } else {
                    i11 = columnIndex4;
                    i12 = (int) prepare.getLong(i30);
                }
                int i31 = columnIndex13;
                long j13 = i31 == -1 ? 0L : prepare.getLong(i31);
                int i32 = columnIndex14;
                if (i32 == -1) {
                    i13 = i30;
                    i14 = i31;
                    i15 = 0;
                } else {
                    i13 = i30;
                    i14 = i31;
                    i15 = (int) prepare.getLong(i32);
                }
                int i33 = columnIndex15;
                if (i33 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_type', found NULL value instead.");
                }
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(i33));
                int i34 = columnIndex16;
                if (i34 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_request', found NULL value instead.");
                }
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(i34));
                int i35 = columnIndex17;
                if (i35 == -1) {
                    i16 = i33;
                    i17 = i34;
                    z9 = false;
                } else {
                    i16 = i33;
                    i17 = i34;
                    z9 = ((int) prepare.getLong(i35)) != 0;
                }
                int i36 = columnIndex18;
                if (i36 == -1) {
                    i18 = i35;
                    z10 = false;
                } else {
                    i18 = i35;
                    z10 = ((int) prepare.getLong(i36)) != 0;
                }
                int i37 = columnIndex19;
                if (i37 == -1) {
                    i19 = columnIndex5;
                    z11 = false;
                } else {
                    i19 = columnIndex5;
                    z11 = ((int) prepare.getLong(i37)) != 0;
                }
                int i38 = columnIndex20;
                if (i38 == -1) {
                    i20 = i36;
                    i21 = i37;
                } else {
                    i20 = i36;
                    i21 = i37;
                    if (((int) prepare.getLong(i38)) != 0) {
                        z12 = true;
                    }
                }
                int i39 = columnIndex21;
                boolean z13 = z12;
                long j14 = i39 == -1 ? 0L : prepare.getLong(i39);
                int i40 = columnIndex22;
                long j15 = i40 == -1 ? 0L : prepare.getLong(i40);
                columnIndex21 = i39;
                int i41 = columnIndex23;
                if (i41 == -1) {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'content_uri_triggers', found NULL value instead.");
                }
                Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z9, z10, z11, z13, j14, j15, WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(i41)));
                Object g02 = a0.g0(arrayMap, prepare.getText(columnIndex));
                g02.getClass();
                List list = (List) g02;
                Object g03 = a0.g0(arrayMap2, prepare.getText(columnIndex));
                g03.getClass();
                arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j, j6, j10, constraints, i27, intToBackoffPolicy, j11, j12, i10, i12, j13, i15, list, (List) g03));
                int i42 = i11;
                i23 = i13;
                columnIndex13 = i14;
                columnIndex14 = i32;
                columnIndex15 = i16;
                columnIndex17 = i18;
                columnIndex18 = i20;
                columnIndex5 = i19;
                columnIndex19 = i21;
                columnIndex20 = i38;
                columnIndex4 = i42;
                columnIndex23 = i41;
                columnIndex22 = i40;
                columnIndex2 = i;
                columnIndex3 = i6;
                columnIndex16 = i17;
                i25 = i28;
                i26 = i29;
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery supportSQLiteQuery) {
        supportSQLiteQuery.getClass();
        RoomRawQuery roomRawQuery = RoomSQLiteQuery.Companion.copyFrom(supportSQLiteQuery).toRoomRawQuery();
        return (List) DBUtil.performBlocking(this.__db, true, false, new c(roomRawQuery.getSql(), roomRawQuery, this, 0));
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public r7.h getWorkInfoPojosFlow(SupportSQLiteQuery supportSQLiteQuery) {
        supportSQLiteQuery.getClass();
        RoomRawQuery roomRawQuery = RoomSQLiteQuery.Companion.copyFrom(supportSQLiteQuery).toRoomRawQuery();
        return FlowUtil.createFlow(this.__db, false, new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, new c(roomRawQuery.getSql(), roomRawQuery, this, 1));
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(SupportSQLiteQuery supportSQLiteQuery) {
        supportSQLiteQuery.getClass();
        RoomRawQuery roomRawQuery = RoomSQLiteQuery.Companion.copyFrom(supportSQLiteQuery).toRoomRawQuery();
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, (l) new c(roomRawQuery.getSql(), roomRawQuery, this, 2));
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final List<j7.c> getRequiredConverters() {
            return t.f8724a;
        }

        private Companion() {
        }
    }
}
