package h0;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class l extends w0.b implements IInterface {
    public final int j;

    public l(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData", 2);
        y.b(bArr.length == 25);
        this.j = Arrays.hashCode(bArr);
    }

    public static byte[] K(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            s1.o.j(e10);
            return null;
        }
    }

    @Override // w0.b
    public final boolean H(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            s0.a J = J();
            parcel2.writeNoException();
            z0.g.b(parcel2, J);
            return true;
        }
        if (i != 2) {
            return false;
        }
        parcel2.writeNoException();
        parcel2.writeInt(this.j);
        return true;
    }

    public abstract byte[] I();

    public final s0.a J() {
        return new s0.b(I());
    }

    public final boolean equals(Object obj) {
        s0.a J;
        if (obj instanceof l) {
            try {
                l lVar = (l) obj;
                if (lVar.j == this.j && (J = lVar.J()) != null) {
                    return Arrays.equals(I(), (byte[]) s0.b.J(J));
                }
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.j;
    }
}
