package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class za {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2404a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2405b;

    public za(boolean z9, boolean z10) {
        this.f2404a = z9;
        this.f2405b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof za)) {
            return false;
        }
        za zaVar = (za) obj;
        return this.f2404a == zaVar.f2404a && this.f2405b == zaVar.f2405b;
    }

    public final int hashCode() {
        return ((this.f2404a ? 1231 : 1237) * 31) + (this.f2405b ? 1231 : 1237);
    }

    public final String toString() {
        return "DownloadAllButtonData(hasUpdates=" + this.f2404a + ", allCompleted=" + this.f2405b + ")";
    }
}
