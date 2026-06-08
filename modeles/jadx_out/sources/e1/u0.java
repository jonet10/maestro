package e1;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public int f4293a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4294b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4295c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f4296d;

    public u0(w0 w0Var, int i, boolean z9, boolean z10) {
        this.f4296d = w0Var;
        this.f4293a = i;
        this.f4294b = z9;
        this.f4295c = z10;
    }

    public m8.o a(SSLSocket sSLSocket) {
        boolean z9;
        m8.o oVar;
        int i = this.f4293a;
        List list = (List) this.f4296d;
        int size = list.size();
        while (true) {
            z9 = true;
            if (i >= size) {
                oVar = null;
                break;
            }
            oVar = (m8.o) list.get(i);
            if (oVar.a(sSLSocket)) {
                this.f4293a = i + 1;
                break;
            }
            i++;
        }
        if (oVar == null) {
            StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb.append(this.f4295c);
            sb.append(", modes=");
            sb.append(list);
            String arrays = Arrays.toString(sSLSocket.getEnabledProtocols());
            sb.append(", supported protocols=");
            sb.append(arrays);
            throw new UnknownServiceException(sb.toString());
        }
        int i6 = this.f4293a;
        while (true) {
            if (i6 >= list.size()) {
                z9 = false;
                break;
            }
            if (((m8.o) list.get(i6)).a(sSLSocket)) {
                break;
            }
            i6++;
        }
        this.f4294b = z9;
        m8.b bVar = m8.b.f7682e;
        boolean z10 = this.f4295c;
        bVar.getClass();
        String[] strArr = oVar.f7770d;
        String[] strArr2 = oVar.f7769c;
        String[] m10 = strArr2 != null ? n8.c.m(m8.l.f7746b, sSLSocket.getEnabledCipherSuites(), strArr2) : sSLSocket.getEnabledCipherSuites();
        String[] m11 = strArr != null ? n8.c.m(n8.c.f, sSLSocket.getEnabledProtocols(), strArr) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        m8.k kVar = m8.l.f7746b;
        byte[] bArr = n8.c.f8114a;
        int length = supportedCipherSuites.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (kVar.compare(supportedCipherSuites[i10], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i10++;
        }
        if (z10 && i10 != -1) {
            String str = supportedCipherSuites[i10];
            int length2 = m10.length;
            String[] strArr3 = new String[length2 + 1];
            System.arraycopy(m10, 0, strArr3, 0, m10.length);
            strArr3[length2] = str;
            m10 = strArr3;
        }
        m8.n nVar = new m8.n(oVar);
        nVar.a(m10);
        nVar.b(m11);
        m8.o oVar2 = new m8.o(nVar);
        String[] strArr4 = oVar2.f7770d;
        if (strArr4 != null) {
            sSLSocket.setEnabledProtocols(strArr4);
        }
        String[] strArr5 = oVar2.f7769c;
        if (strArr5 != null) {
            sSLSocket.setEnabledCipherSuites(strArr5);
        }
        return oVar;
    }

    public void b(String str) {
        ((w0) this.f4296d).p(this.f4293a, this.f4294b, this.f4295c, str, null, null, null);
    }

    public void c(Object obj, String str) {
        ((w0) this.f4296d).p(this.f4293a, this.f4294b, this.f4295c, str, obj, null, null);
    }

    public void d(Object obj, String str, Object obj2) {
        ((w0) this.f4296d).p(this.f4293a, this.f4294b, this.f4295c, str, obj, obj2, null);
    }

    public void e(String str, Object obj, Object obj2, Object obj3) {
        ((w0) this.f4296d).p(this.f4293a, this.f4294b, this.f4295c, str, obj, obj2, obj3);
    }

    public u0(List list) {
        this.f4293a = 0;
        this.f4296d = list;
    }
}
