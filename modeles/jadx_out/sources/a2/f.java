package a2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements l {

    /* renamed from: c, reason: collision with root package name */
    public static final q2.e f17c = new q2.e(3);

    /* renamed from: a, reason: collision with root package name */
    public final Object f18a;

    /* renamed from: b, reason: collision with root package name */
    public Object f19b;

    public f(e2.d dVar) {
        this.f18a = dVar;
        this.f19b = f17c;
    }

    @Override // a2.l
    public void a(k kVar, int i) {
        int[] iArr = (int[]) this.f19b;
        try {
            kVar.read((byte[]) this.f18a, iArr[0], i);
            iArr[0] = iArr[0] + i;
        } finally {
            kVar.close();
        }
    }

    public f(byte[] bArr, int[] iArr) {
        this.f18a = bArr;
        this.f19b = iArr;
    }
}
