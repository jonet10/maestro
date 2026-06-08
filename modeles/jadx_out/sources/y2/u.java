package y2;

import android.util.Log;
import java.util.Arrays;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f11763d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a, reason: collision with root package name */
    public final String f11764a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11765b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11766c;

    public u(String str, String str2) {
        String str3;
        if (str2 == null || !str2.startsWith("/topics/")) {
            str3 = str2;
        } else {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in " + str + ".");
            str3 = str2.substring(8);
        }
        if (str3 == null || !f11763d.matcher(str3).matches()) {
            com.google.gson.internal.a.p(androidx.lifecycle.l.w("Invalid topic name: ", str3, " does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}."));
            throw null;
        }
        this.f11764a = str3;
        this.f11765b = str;
        this.f11766c = a4.x.k(str, "!", str2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f11764a.equals(uVar.f11764a) && this.f11765b.equals(uVar.f11765b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11765b, this.f11764a});
    }
}
