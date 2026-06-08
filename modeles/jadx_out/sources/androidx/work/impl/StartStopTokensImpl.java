package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class StartStopTokensImpl implements StartStopTokens {
    private final Map<WorkGenerationalId, StartStopToken> runs = new LinkedHashMap();

    @Override // androidx.work.impl.StartStopTokens
    public boolean contains(WorkGenerationalId workGenerationalId) {
        workGenerationalId.getClass();
        return this.runs.containsKey(workGenerationalId);
    }

    @Override // androidx.work.impl.StartStopTokens
    public List<StartStopToken> remove(String str) {
        str.getClass();
        Map<WorkGenerationalId, StartStopToken> map = this.runs;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<WorkGenerationalId, StartStopToken> entry : map.entrySet()) {
            if (kotlin.jvm.internal.l.a(entry.getKey().getWorkSpecId(), str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            this.runs.remove((WorkGenerationalId) it.next());
        }
        return q6.l.G0(linkedHashMap.values());
    }

    @Override // androidx.work.impl.StartStopTokens
    public StartStopToken tokenFor(WorkGenerationalId workGenerationalId) {
        workGenerationalId.getClass();
        Map<WorkGenerationalId, StartStopToken> map = this.runs;
        StartStopToken startStopToken = map.get(workGenerationalId);
        if (startStopToken == null) {
            startStopToken = new StartStopToken(workGenerationalId);
            map.put(workGenerationalId, startStopToken);
        }
        return startStopToken;
    }

    @Override // androidx.work.impl.StartStopTokens
    public final StartStopToken tokenFor(WorkSpec workSpec) {
        int i = e.f575a;
        workSpec.getClass();
        return tokenFor(WorkSpecKt.generationalId(workSpec));
    }

    @Override // androidx.work.impl.StartStopTokens
    public StartStopToken remove(WorkGenerationalId workGenerationalId) {
        workGenerationalId.getClass();
        return this.runs.remove(workGenerationalId);
    }

    @Override // androidx.work.impl.StartStopTokens
    public final StartStopToken remove(WorkSpec workSpec) {
        int i = e.f575a;
        workSpec.getClass();
        return remove(WorkSpecKt.generationalId(workSpec));
    }
}
