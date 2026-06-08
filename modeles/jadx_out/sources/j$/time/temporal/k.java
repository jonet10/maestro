package j$.time.temporal;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public enum k implements q {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);

    private static final long serialVersionUID = -7501623920830201812L;

    /* renamed from: a, reason: collision with root package name */
    public final transient String f5910a;

    /* renamed from: b, reason: collision with root package name */
    public final transient u f5911b;

    /* renamed from: c, reason: collision with root package name */
    public final transient long f5912c;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j) {
        this.f5910a = str;
        this.f5911b = u.e((-365243219162L) + j, 365241780471L + j);
        this.f5912c = j;
    }

    @Override // j$.time.temporal.q
    public final m j(m mVar, long j) {
        if (!this.f5911b.d(j)) {
            throw new j$.time.b("Invalid value: " + this.f5910a + " " + j);
        }
        return mVar.a(j$.com.android.tools.r8.a.C(j, this.f5912c), a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final u range() {
        return this.f5911b;
    }

    @Override // j$.time.temporal.q
    public final boolean e(n nVar) {
        return nVar.c(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final u f(n nVar) {
        if (nVar.c(a.EPOCH_DAY)) {
            return this.f5911b;
        }
        j$.time.g.h(this, "Unsupported field: ");
        return null;
    }

    @Override // j$.time.temporal.q
    public final long g(n nVar) {
        return nVar.q(a.EPOCH_DAY) + this.f5912c;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f5910a;
    }
}
