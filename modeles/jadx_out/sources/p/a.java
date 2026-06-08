package p;

import com.google.android.gms.internal.measurement.z3;
import j$.util.DesugarCollections;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final String f8390c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set f8391d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f8392e;
    public static final a f;

    /* renamed from: a, reason: collision with root package name */
    public final String f8393a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8394b;

    static {
        String E = z3.E("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f8390c = E;
        String E2 = z3.E("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        String E3 = z3.E("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f8391d = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(new o.c("proto"), new o.c("json"))));
        f8392e = new a(E, null);
        f = new a(E2, E3);
    }

    public a(String str, String str2) {
        this.f8393a = str;
        this.f8394b = str2;
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            com.google.gson.internal.a.p("Version marker missing from extras");
            return null;
        }
        String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
        if (split.length != 2) {
            com.google.gson.internal.a.p("Extra is not a valid encoded LegacyFlgDestination");
            return null;
        }
        String str2 = split[0];
        if (str2.isEmpty()) {
            com.google.gson.internal.a.p("Missing endpoint in CCTDestination extras");
            return null;
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }
}
