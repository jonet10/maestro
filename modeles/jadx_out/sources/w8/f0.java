package w8;

import com.google.android.gms.internal.measurement.i5;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f0 extends d {

    /* renamed from: m, reason: collision with root package name */
    public final Socket f10957m;

    public f0(Socket socket) {
        socket.getClass();
        this.f10957m = socket;
    }

    @Override // w8.d
    public final void j() {
        Socket socket = this.f10957m;
        try {
            socket.close();
        } catch (AssertionError e10) {
            if (!i5.y(e10)) {
                throw e10;
            }
            x.f11003a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e10);
        } catch (Exception e11) {
            x.f11003a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e11);
        }
    }

    public final IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
