package r;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f8826a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f8827b;

    /* renamed from: c, reason: collision with root package name */
    public final m f8828c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8829d;

    /* renamed from: e, reason: collision with root package name */
    public final long f8830e;
    public final Map f;
    public final Integer g;
    public final String h;
    public final byte[] i;
    public final byte[] j;

    public i(String str, Integer num, m mVar, long j, long j6, HashMap hashMap, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f8826a = str;
        this.f8827b = num;
        this.f8828c = mVar;
        this.f8829d = j;
        this.f8830e = j6;
        this.f = hashMap;
        this.g = num2;
        this.h = str2;
        this.i = bArr;
        this.j = bArr2;
    }

    public final String a(String str) {
        String str2 = (String) this.f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final h c() {
        h hVar = new h();
        String str = this.f8826a;
        if (str == null) {
            com.google.gson.internal.a.i("Null transportName");
            return null;
        }
        hVar.f8816b = str;
        hVar.f8818m = this.f8827b;
        hVar.f8819n = this.g;
        hVar.f8817l = this.h;
        hVar.f8824s = this.i;
        hVar.f8825t = this.j;
        m mVar = this.f8828c;
        if (mVar == null) {
            com.google.gson.internal.a.i("Null encodedPayload");
            return null;
        }
        hVar.f8820o = mVar;
        hVar.f8821p = Long.valueOf(this.f8829d);
        hVar.f8822q = Long.valueOf(this.f8830e);
        hVar.f8823r = new HashMap(this.f);
        return hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f8826a.equals(iVar.f8826a)) {
                Integer num = iVar.f8827b;
                Integer num2 = this.f8827b;
                if (num2 != null ? num2.equals(num) : num == null) {
                    if (this.f8828c.equals(iVar.f8828c) && this.f8829d == iVar.f8829d && this.f8830e == iVar.f8830e && this.f.equals(iVar.f)) {
                        Integer num3 = iVar.g;
                        Integer num4 = this.g;
                        if (num4 != null ? num4.equals(num3) : num3 == null) {
                            String str = iVar.h;
                            String str2 = this.h;
                            if (str2 != null ? str2.equals(str) : str == null) {
                                if (Arrays.equals(this.i, iVar.i) && Arrays.equals(this.j, iVar.j)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f8826a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f8827b;
        int hashCode2 = (((hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f8828c.hashCode()) * 1000003;
        long j = this.f8829d;
        int i = (hashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j6 = this.f8830e;
        int hashCode3 = (((i ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f.hashCode()) * 1000003;
        Integer num2 = this.g;
        int hashCode4 = (hashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.h;
        return ((((hashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.i)) * 1000003) ^ Arrays.hashCode(this.j);
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f8826a + ", code=" + this.f8827b + ", encodedPayload=" + this.f8828c + ", eventMillis=" + this.f8829d + ", uptimeMillis=" + this.f8830e + ", autoMetadata=" + this.f + ", productId=" + this.g + ", pseudonymousId=" + this.h + ", experimentIdsClear=" + Arrays.toString(this.i) + ", experimentIdsEncrypted=" + Arrays.toString(this.j) + "}";
    }
}
