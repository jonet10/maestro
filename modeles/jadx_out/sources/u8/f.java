package u8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends h {

    /* renamed from: c, reason: collision with root package name */
    public final Method f10778c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f10779d;

    public f(Method method, Method method2) {
        this.f10778c = method;
        this.f10779d = method2;
    }

    @Override // u8.h
    public final void e(SSLSocket sSLSocket, String str, List list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList b7 = h.b(list);
            this.f10778c.invoke(sSLParameters, b7.toArray(new String[b7.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw n8.c.a("unable to set ssl parameters", e10);
        }
    }

    @Override // u8.h
    public final String h(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f10779d.invoke(sSLSocket, null);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw n8.c.a("unable to get selected protocols", e10);
        }
    }
}
