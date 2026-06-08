package j8;

import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import d7.l;
import kotlin.jvm.internal.m;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends m implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final d f6730a = new d(1);

    @Override // d7.l
    public final Object invoke(Object obj) {
        x xVar;
        ChoiceCmpCallback callback;
        ChoiceCmpCallback callback2;
        USRegulationData uSRegulationData = (USRegulationData) obj;
        x xVar2 = x.f8463a;
        if (uSRegulationData == null || (callback2 = ChoiceCmp.INSTANCE.getCallback()) == null) {
            xVar = null;
        } else {
            callback2.onReceiveUSRegulationsConsent(uSRegulationData);
            xVar = xVar2;
        }
        if (xVar == null && (callback = ChoiceCmp.INSTANCE.getCallback()) != null) {
            callback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
        }
        return xVar2;
    }
}
