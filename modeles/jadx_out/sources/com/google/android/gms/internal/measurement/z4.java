package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z4 extends a5 {

    /* renamed from: m, reason: collision with root package name */
    public final int f2932m;

    public z4(byte[] bArr, int i) {
        super(bArr);
        a5.g(0, i, bArr.length);
        this.f2932m = i;
    }

    @Override // com.google.android.gms.internal.measurement.a5
    public final byte b(int i) {
        int i6 = this.f2932m;
        if (((i6 - (i + 1)) | i) >= 0) {
            return this.f2492b[i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 11);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 18 + String.valueOf(i6).length());
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i6);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.a5
    public final byte c(int i) {
        return this.f2492b[i];
    }

    @Override // com.google.android.gms.internal.measurement.a5
    public final int d() {
        return this.f2932m;
    }
}
