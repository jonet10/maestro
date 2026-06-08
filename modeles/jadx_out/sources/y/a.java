package y;

import androidx.leanback.media.MediaPlayerGlue;
import androidx.lifecycle.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class a {
    public static final a f = new a(10485760, 200, MediaPlayerGlue.FAST_FORWARD_REWIND_STEP, 604800000, 81920);

    /* renamed from: a, reason: collision with root package name */
    public final long f11574a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11575b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11576c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11577d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11578e;

    public a(long j, int i, int i6, long j6, int i10) {
        this.f11574a = j;
        this.f11575b = i;
        this.f11576c = i6;
        this.f11577d = j6;
        this.f11578e = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f11574a == aVar.f11574a && this.f11575b == aVar.f11575b && this.f11576c == aVar.f11576c && this.f11577d == aVar.f11577d && this.f11578e == aVar.f11578e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f11574a;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f11575b) * 1000003) ^ this.f11576c) * 1000003;
        long j6 = this.f11577d;
        return ((i ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f11578e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb.append(this.f11574a);
        sb.append(", loadBatchSize=");
        sb.append(this.f11575b);
        sb.append(", criticalSectionEnterTimeoutMs=");
        sb.append(this.f11576c);
        sb.append(", eventCleanUpAge=");
        sb.append(this.f11577d);
        sb.append(", maxBlobByteSizePerRow=");
        return l.x(sb, "}", this.f11578e);
    }
}
