package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class OneTimeWorkRequestKt {
    public static final <W extends ListenableWorker> OneTimeWorkRequest.Builder OneTimeWorkRequestBuilder() {
        l.h();
        throw null;
    }

    public static final OneTimeWorkRequest.Builder setInputMerger(OneTimeWorkRequest.Builder builder, @NonNull j7.c cVar) {
        builder.getClass();
        cVar.getClass();
        return builder.setInputMerger(d0.b.F(cVar));
    }
}
