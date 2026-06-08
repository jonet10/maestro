package j8;

import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import d7.p;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.jvm.internal.m;
import p6.i;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6736a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6737b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(Object obj, int i) {
        super(2);
        this.f6736a = i;
        this.f6737b = obj;
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        String lowerCase;
        switch (this.f6736a) {
            case 0:
                int intValue = ((Number) obj).intValue();
                Boolean bool = (Boolean) obj2;
                bool.getClass();
                ((LinkedHashMap) this.f6737b).put(String.valueOf(intValue), bool);
                break;
            default:
                int intValue2 = ((Number) obj).intValue();
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                ArrayList arrayList = (ArrayList) this.f6737b;
                Integer valueOf = Integer.valueOf(intValue2);
                if (booleanValue) {
                    lowerCase = GBCConsentValue.GRANTED.getValue().toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                } else {
                    lowerCase = GBCConsentValue.DENIED.getValue().toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                }
                arrayList.add(new i(valueOf, lowerCase));
                break;
        }
        return x.f8463a;
    }
}
