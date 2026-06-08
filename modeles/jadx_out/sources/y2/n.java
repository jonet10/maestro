package y2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class n implements o.e {
    public static /* synthetic */ void a(int i, int i6, Object obj) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(obj);
        sb.append(i6);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // o.e
    public Object apply(Object obj) {
        z2.e eVar = (z2.e) obj;
        b5.m mVar = o.f11747a;
        mVar.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            mVar.B(eVar, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
