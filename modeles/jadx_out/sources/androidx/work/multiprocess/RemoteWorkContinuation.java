package androidx.work.multiprocess;

import androidx.annotation.RestrictTo;
import androidx.work.OneTimeWorkRequest;
import java.util.Collections;
import java.util.List;
import m1.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class RemoteWorkContinuation {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteWorkContinuation() {
    }

    public static RemoteWorkContinuation combine(List<RemoteWorkContinuation> list) {
        return list.get(0).combineInternal(list);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract RemoteWorkContinuation combineInternal(List<RemoteWorkContinuation> list);

    public abstract b enqueue();

    public final RemoteWorkContinuation then(OneTimeWorkRequest oneTimeWorkRequest) {
        return then(Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract RemoteWorkContinuation then(List<OneTimeWorkRequest> list);
}
