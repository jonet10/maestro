package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import d7.l;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ActivityResultCallerKt {
    public static final <I, O> ActivityResultLauncher<x> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i, ActivityResultRegistry activityResultRegistry, l lVar) {
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new a(0, lVar)), activityResultContract, i);
    }

    public static final <I, O> ActivityResultLauncher<x> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i, l lVar) {
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, new a(1, lVar)), activityResultContract, i);
    }
}
