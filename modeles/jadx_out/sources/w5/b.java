package w5;

import b2.t1;
import com.google.android.gms.internal.measurement.z3;
import d7.p;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.x;
import u5.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10913a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f10914b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(x xVar, int i) {
        super(2);
        this.f10913a = i;
        this.f10914b = xVar;
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, java.util.Map] */
    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f10913a;
        p6.x xVar = p6.x.f8463a;
        x xVar2 = this.f10914b;
        switch (i) {
            case 0:
                int intValue = ((Number) obj).intValue();
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                if (intValue > 0 && intValue <= l7.m.u0((CharSequence) xVar2.f7024a) + 1) {
                    StringBuilder sb = new StringBuilder((String) xVar2.f7024a);
                    sb.setCharAt(intValue - 1, booleanValue ? '1' : '0');
                    xVar2.f7024a = sb.toString();
                    break;
                }
                break;
            default:
                String str = (String) obj;
                Set set = (Set) obj2;
                str.getClass();
                set.getClass();
                g b7 = z3.b(str);
                String str2 = (String) xVar2.f7024a;
                Integer valueOf = Integer.valueOf(b7.f10716a);
                Object obj3 = c.f10915a;
                ?? r52 = c.f10916b;
                Integer num = (Integer) r52.get(d.f10924p);
                String g = l.g(t1.c(valueOf, num == null ? 0 : num.intValue()), str2);
                xVar2.f7024a = g;
                Integer valueOf2 = Integer.valueOf(b7.f10717b.f10726a);
                Integer num2 = (Integer) r52.get(d.f10925q);
                xVar2.f7024a = l.g(t1.c(valueOf2, num2 == null ? 0 : num2.intValue()), g);
                List B0 = q6.l.B0(set);
                int size = B0.size();
                String str3 = "";
                int i6 = 0;
                int i10 = 0;
                int i11 = 0;
                while (i6 < size) {
                    int i12 = i6 + 1;
                    int intValue2 = ((Number) B0.get(i6)).intValue();
                    if (i11 == 0) {
                        i10++;
                        i11 = intValue2;
                    }
                    if (i6 == B0.size() - 1 || ((Number) B0.get(i12)).intValue() > intValue2 + 1) {
                        boolean z9 = intValue2 != i11;
                        String g3 = l.g(z9 ? "1" : "0", str3);
                        Integer valueOf3 = Integer.valueOf(i11);
                        Object obj4 = c.f10915a;
                        ?? r10 = c.f10916b;
                        d dVar = d.f10928t;
                        Integer num3 = (Integer) r10.get(dVar);
                        str3 = l.g(t1.c(valueOf3, num3 == null ? 0 : num3.intValue()), g3);
                        if (z9) {
                            Integer valueOf4 = Integer.valueOf(intValue2);
                            Integer num4 = (Integer) r10.get(dVar);
                            str3 = l.g(t1.c(valueOf4, num4 == null ? 0 : num4.intValue()), str3);
                        }
                        i11 = 0;
                    }
                    i6 = i12;
                }
                String str4 = (String) xVar2.f7024a;
                Integer valueOf5 = Integer.valueOf(i10);
                Object obj5 = c.f10915a;
                Integer num5 = (Integer) c.f10916b.get(d.f10922n);
                String g10 = l.g(t1.c(valueOf5, num5 != null ? num5.intValue() : 0), str4);
                xVar2.f7024a = g10;
                xVar2.f7024a = l.g(str3, g10);
                break;
        }
        return xVar;
    }
}
