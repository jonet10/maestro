package g9;

import d7.l;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends m implements l {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5388b;

    /* renamed from: l, reason: collision with root package name */
    public static final a f5389l;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5390a;

    static {
        int i = 1;
        f5388b = new a(i, 0);
        f5389l = new a(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i, int i6) {
        super(i);
        this.f5390a = i6;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        String valueOf;
        switch (this.f5390a) {
            case 0:
                String str = (String) obj;
                str.getClass();
                Locale locale = Locale.ROOT;
                String lowerCase = str.toLowerCase(locale);
                lowerCase.getClass();
                if (lowerCase.length() <= 0) {
                    return lowerCase;
                }
                StringBuilder sb = new StringBuilder();
                char charAt = lowerCase.charAt(0);
                if (Character.isLowerCase(charAt)) {
                    Locale locale2 = Locale.getDefault();
                    locale2.getClass();
                    String valueOf2 = String.valueOf(charAt);
                    valueOf2.getClass();
                    valueOf = valueOf2.toUpperCase(locale2);
                    valueOf.getClass();
                    if (valueOf.length() <= 1) {
                        String valueOf3 = String.valueOf(charAt);
                        valueOf3.getClass();
                        String upperCase = valueOf3.toUpperCase(locale);
                        upperCase.getClass();
                        if (valueOf.equals(upperCase)) {
                            valueOf = String.valueOf(Character.toTitleCase(charAt));
                        }
                    } else if (charAt != 329) {
                        char charAt2 = valueOf.charAt(0);
                        String lowerCase2 = valueOf.substring(1).toLowerCase(locale);
                        lowerCase2.getClass();
                        valueOf = charAt2 + lowerCase2;
                    }
                } else {
                    valueOf = String.valueOf(charAt);
                }
                sb.append((Object) valueOf);
                sb.append(lowerCase.substring(1));
                return sb.toString();
            default:
                return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(((Number) obj).byteValue())}, 1));
        }
    }
}
