package q5;

import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import d7.l;
import kotlin.jvm.internal.m;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends m implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8707a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f8708b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(i iVar, int i) {
        super(1);
        this.f8707a = i;
        this.f8708b = iVar;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        x xVar;
        ChoiceCmpCallback choiceCmpCallback;
        ChoiceCmpCallback choiceCmpCallback2;
        x xVar2;
        ChoiceCmpCallback choiceCmpCallback3;
        ChoiceCmpCallback choiceCmpCallback4;
        x xVar3;
        switch (this.f8707a) {
            case 0:
                USRegulationData uSRegulationData = (USRegulationData) obj;
                i iVar = this.f8708b;
                iVar.getClass();
                i.c();
                x xVar4 = x.f8463a;
                if (uSRegulationData == null || (choiceCmpCallback2 = iVar.f8711c) == null) {
                    xVar = null;
                } else {
                    choiceCmpCallback2.onReceiveUSRegulationsConsent(uSRegulationData);
                    xVar = xVar4;
                }
                if (xVar == null && (choiceCmpCallback = iVar.f8711c) != null) {
                    choiceCmpCallback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
                }
                return xVar4;
            case 1:
                USRegulationData uSRegulationData2 = (USRegulationData) obj;
                i iVar2 = this.f8708b;
                iVar2.getClass();
                i.c();
                x xVar5 = x.f8463a;
                if (uSRegulationData2 == null || (choiceCmpCallback4 = iVar2.f8711c) == null) {
                    xVar2 = null;
                } else {
                    choiceCmpCallback4.onReceiveUSRegulationsConsent(uSRegulationData2);
                    xVar2 = xVar5;
                }
                if (xVar2 == null && (choiceCmpCallback3 = iVar2.f8711c) != null) {
                    choiceCmpCallback3.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
                }
                return xVar5;
            default:
                ChoiceCmpCallback choiceCmpCallback5 = this.f8708b.f8711c;
                USRegulationData uSRegulationData3 = (USRegulationData) obj;
                x xVar6 = x.f8463a;
                if (uSRegulationData3 == null || choiceCmpCallback5 == null) {
                    xVar3 = null;
                } else {
                    choiceCmpCallback5.onReceiveUSRegulationsConsent(uSRegulationData3);
                    xVar3 = xVar6;
                }
                if (xVar3 == null && choiceCmpCallback5 != null) {
                    choiceCmpCallback5.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
                }
                return xVar6;
        }
    }
}
