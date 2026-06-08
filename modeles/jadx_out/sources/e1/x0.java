package e1;

import android.os.Bundle;
import androidx.browser.trusted.sharing.ShareTarget;
import com.uptodown.UptodownApp;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4387a;

    /* renamed from: b, reason: collision with root package name */
    public long f4388b;

    /* renamed from: c, reason: collision with root package name */
    public Object f4389c;

    /* renamed from: d, reason: collision with root package name */
    public Object f4390d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4391e;

    public x0() {
        this.f4387a = 2;
        this.f4389c = k0.k.g(System.currentTimeMillis(), "SwA", "SwA");
    }

    public static void g(Exception exc, x4.g2 g2Var, String str) {
        g2Var.f11205c = str;
        if (exc.getMessage() != null) {
            g2Var.f11203a = exc.getMessage();
        } else {
            g2Var.f11203a = exc.toString();
        }
    }

    public static x0 m(u uVar) {
        String str = uVar.f4289a;
        String str2 = uVar.f4291l;
        return new x0(uVar.f4292m, uVar.f4290b.g(), str, str2);
    }

    public void a(String str, byte[] bArr) {
        try {
            OutputStream outputStream = (OutputStream) this.f4391e;
            outputStream.getClass();
            String str2 = "--" + ((String) this.f4389c) + "\r\n";
            Charset charset = l7.a.f7151a;
            byte[] bytes = str2.getBytes(charset);
            bytes.getClass();
            outputStream.write(bytes);
            OutputStream outputStream2 = (OutputStream) this.f4391e;
            outputStream2.getClass();
            byte[] bytes2 = ("Content-Disposition: form-data; name=\"zipped\"; filename=\"" + str + "\"\r\n").getBytes(charset);
            bytes2.getClass();
            outputStream2.write(bytes2);
            OutputStream outputStream3 = (OutputStream) this.f4391e;
            outputStream3.getClass();
            byte[] bytes3 = "Content-Type: application/octet-stream\r\n".getBytes(charset);
            bytes3.getClass();
            outputStream3.write(bytes3);
            OutputStream outputStream4 = (OutputStream) this.f4391e;
            outputStream4.getClass();
            byte[] bytes4 = "Content-Transfer-Encoding: binary\r\n".getBytes(charset);
            bytes4.getClass();
            outputStream4.write(bytes4);
            OutputStream outputStream5 = (OutputStream) this.f4391e;
            outputStream5.getClass();
            byte[] bytes5 = "\r\n".getBytes(charset);
            bytes5.getClass();
            outputStream5.write(bytes5);
            OutputStream outputStream6 = (OutputStream) this.f4391e;
            outputStream6.getClass();
            outputStream6.write(bArr, 0, bArr.length);
            OutputStream outputStream7 = (OutputStream) this.f4391e;
            outputStream7.getClass();
            byte[] bytes6 = "\r\n".getBytes(charset);
            bytes6.getClass();
            outputStream7.write(bytes6);
        } catch (IOException unused) {
            OutputStream outputStream8 = (OutputStream) this.f4391e;
            outputStream8.getClass();
            outputStream8.close();
        } catch (Exception unused2) {
            OutputStream outputStream9 = (OutputStream) this.f4391e;
            outputStream9.getClass();
            outputStream9.close();
        } catch (OutOfMemoryError unused3) {
            OutputStream outputStream10 = (OutputStream) this.f4391e;
            outputStream10.getClass();
            outputStream10.close();
        }
    }

    public long b(String str, String str2) {
        long j = 0;
        try {
            OutputStream outputStream = (OutputStream) this.f4391e;
            outputStream.getClass();
            String str3 = "--" + ((String) this.f4389c) + "\r\n";
            Charset charset = l7.a.f7151a;
            byte[] bytes = str3.getBytes(charset);
            bytes.getClass();
            outputStream.write(bytes);
            OutputStream outputStream2 = (OutputStream) this.f4391e;
            outputStream2.getClass();
            byte[] bytes2 = ("Content-Disposition: form-data; name=\"apk_file\"; filename=\"" + str + "\"\r\n").getBytes(charset);
            bytes2.getClass();
            outputStream2.write(bytes2);
            OutputStream outputStream3 = (OutputStream) this.f4391e;
            outputStream3.getClass();
            byte[] bytes3 = "Content-Type: application/octet-stream\r\n".getBytes(charset);
            bytes3.getClass();
            outputStream3.write(bytes3);
            OutputStream outputStream4 = (OutputStream) this.f4391e;
            outputStream4.getClass();
            byte[] bytes4 = "Content-Transfer-Encoding: binary\r\n".getBytes(charset);
            bytes4.getClass();
            outputStream4.write(bytes4);
            OutputStream outputStream5 = (OutputStream) this.f4391e;
            outputStream5.getClass();
            byte[] bytes5 = "\r\n".getBytes(charset);
            bytes5.getClass();
            outputStream5.write(bytes5);
            FileInputStream fileInputStream = new FileInputStream(str2);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    OutputStream outputStream6 = (OutputStream) this.f4391e;
                    outputStream6.getClass();
                    byte[] bytes6 = "\r\n".getBytes(l7.a.f7151a);
                    bytes6.getClass();
                    outputStream6.write(bytes6);
                    return j;
                }
                OutputStream outputStream7 = (OutputStream) this.f4391e;
                outputStream7.getClass();
                outputStream7.write(bArr, 0, read);
                j += read;
            }
        } catch (IOException unused) {
            OutputStream outputStream8 = (OutputStream) this.f4391e;
            if (outputStream8 != null) {
                outputStream8.close();
            }
            return j;
        } catch (Exception unused2) {
            OutputStream outputStream9 = (OutputStream) this.f4391e;
            if (outputStream9 != null) {
                outputStream9.close();
            }
            return j;
        } catch (OutOfMemoryError unused3) {
            OutputStream outputStream10 = (OutputStream) this.f4391e;
            if (outputStream10 != null) {
                outputStream10.close();
            }
            return j;
        }
    }

    public void c(String str, String str2) {
        str2.getClass();
        OutputStream outputStream = (OutputStream) this.f4391e;
        outputStream.getClass();
        String w2 = androidx.lifecycle.l.w("--", (String) this.f4389c, "\r\n");
        Charset charset = l7.a.f7151a;
        byte[] bytes = w2.getBytes(charset);
        bytes.getClass();
        outputStream.write(bytes);
        OutputStream outputStream2 = (OutputStream) this.f4391e;
        outputStream2.getClass();
        byte[] bytes2 = "Content-Type: text/plain\r\n".getBytes(charset);
        bytes2.getClass();
        outputStream2.write(bytes2);
        OutputStream outputStream3 = (OutputStream) this.f4391e;
        outputStream3.getClass();
        byte[] bytes3 = ("Content-Disposition: form-data; name=\"" + str + "\"\r\n").getBytes(charset);
        bytes3.getClass();
        outputStream3.write(bytes3);
        OutputStream outputStream4 = (OutputStream) this.f4391e;
        outputStream4.getClass();
        byte[] bytes4 = ("\r\n" + str2 + "\r\n").getBytes(charset);
        bytes4.getClass();
        outputStream4.write(bytes4);
    }

    public void d(URL url, String str, String str2) {
        URLConnection openConnection = url.openConnection();
        openConnection.getClass();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        this.f4390d = httpsURLConnection;
        httpsURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection2.getClass();
        httpsURLConnection2.setReadTimeout(30000);
        HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection3.getClass();
        httpsURLConnection3.setConnectTimeout(30000);
        HttpsURLConnection httpsURLConnection4 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection4.getClass();
        httpsURLConnection4.setDoInput(true);
        HttpsURLConnection httpsURLConnection5 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection5.getClass();
        httpsURLConnection5.setDoOutput(true);
        HttpsURLConnection httpsURLConnection6 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection6.getClass();
        httpsURLConnection6.setRequestProperty("Connection", "Keep-Alive");
        HttpsURLConnection httpsURLConnection7 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection7.getClass();
        httpsURLConnection7.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + ((String) this.f4389c));
        HttpsURLConnection httpsURLConnection8 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection8.getClass();
        httpsURLConnection8.setRequestProperty("Accept-Charset", "utf-8");
        HttpsURLConnection httpsURLConnection9 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection9.getClass();
        httpsURLConnection9.setRequestProperty("Accept", "application/json");
        float f = UptodownApp.I;
        HttpsURLConnection httpsURLConnection10 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection10.getClass();
        httpsURLConnection10.setRequestProperty("Identificador", "Uptodown_Android");
        HttpsURLConnection httpsURLConnection11 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection11.getClass();
        httpsURLConnection11.setRequestProperty("apk_file", str);
        HttpsURLConnection httpsURLConnection12 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection12.getClass();
        httpsURLConnection12.setRequestProperty("Identificador-Version", "728");
        if (str2 != null) {
            HttpsURLConnection httpsURLConnection13 = (HttpsURLConnection) this.f4390d;
            httpsURLConnection13.getClass();
            httpsURLConnection13.setRequestProperty("Authorization", "Bearer ".concat(str2));
        }
        ((HttpsURLConnection) this.f4390d).getClass();
        HttpsURLConnection httpsURLConnection14 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection14.getClass();
        httpsURLConnection14.setFixedLengthStreamingMode((int) this.f4388b);
        HttpsURLConnection httpsURLConnection15 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection15.getClass();
        httpsURLConnection15.connect();
        HttpsURLConnection httpsURLConnection16 = (HttpsURLConnection) this.f4390d;
        httpsURLConnection16.getClass();
        this.f4391e = httpsURLConnection16.getOutputStream();
    }

    public void e() {
        OutputStream outputStream = (OutputStream) this.f4391e;
        outputStream.getClass();
        byte[] bytes = androidx.lifecycle.l.w("--", (String) this.f4389c, "--\r\n").getBytes(l7.a.f7151a);
        bytes.getClass();
        outputStream.write(bytes);
        OutputStream outputStream2 = (OutputStream) this.f4391e;
        outputStream2.getClass();
        outputStream2.close();
    }

    public x4.g2 f(boolean z9) {
        InputStream errorStream;
        boolean z10;
        long j;
        x4.g2 g2Var = new x4.g2();
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) this.f4390d;
            httpsURLConnection.getClass();
            int responseCode = httpsURLConnection.getResponseCode();
            g2Var.f11204b = responseCode;
            if (responseCode < 200 || responseCode >= 300) {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) this.f4390d;
                httpsURLConnection2.getClass();
                errorStream = httpsURLConnection2.getErrorStream();
                if (errorStream == null) {
                    HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) this.f4390d;
                    httpsURLConnection3.getClass();
                    errorStream = httpsURLConnection3.getInputStream();
                }
                z10 = false;
            } else {
                HttpsURLConnection httpsURLConnection4 = (HttpsURLConnection) this.f4390d;
                httpsURLConnection4.getClass();
                errorStream = httpsURLConnection4.getInputStream();
                if (errorStream == null) {
                    HttpsURLConnection httpsURLConnection5 = (HttpsURLConnection) this.f4390d;
                    httpsURLConnection5.getClass();
                    errorStream = httpsURLConnection5.getErrorStream();
                }
                z10 = true;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[1024];
            if (z10 && z9) {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(errorStream, new Inflater(true));
                while (true) {
                    int read = inflaterInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read, l7.a.f7151a));
                }
                g2Var.f11203a = sb.toString();
                inflaterInputStream.close();
            } else {
                while (true) {
                    int read2 = errorStream.read(bArr);
                    if (read2 == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read2, l7.a.f7151a));
                }
                g2Var.f11203a = sb.toString();
            }
            errorStream.close();
            HttpsURLConnection httpsURLConnection6 = (HttpsURLConnection) this.f4390d;
            httpsURLConnection6.getClass();
            httpsURLConnection6.disconnect();
            String str = g2Var.f11203a;
            if (str != null) {
                byte[] bytes = str.getBytes(l7.a.f7151a);
                bytes.getClass();
                j = bytes.length;
            } else {
                j = 0;
            }
            if (j > 0) {
                j5.j.a(3, j);
                return g2Var;
            }
        } catch (NullPointerException e10) {
            g(e10, g2Var, "NullPointerException");
        } catch (SecurityException e11) {
            g(e11, g2Var, "SecurityException");
        } catch (MalformedURLException e12) {
            g(e12, g2Var, "MalformedURLException");
        } catch (ProtocolException e13) {
            g(e13, g2Var, "ProtocolException");
        } catch (SocketTimeoutException e14) {
            g(e14, g2Var, "SocketTimeoutException");
        } catch (SSLHandshakeException e15) {
            g(e15, g2Var, "SSLHandshakeException");
        } catch (IOException e16) {
            g(e16, g2Var, "IOException");
        } catch (IllegalArgumentException e17) {
            g(e17, g2Var, "IllegalArgumentException");
        } catch (IllegalStateException e18) {
            g(e18, g2Var, "IllegalStateException");
        }
        return g2Var;
    }

    public void h(String str, byte[] bArr) {
        str.getClass();
        long j = this.f4388b;
        String str2 = (String) this.f4389c;
        long length = j + ("--" + str2 + "\r\n").length();
        this.f4388b = length;
        long j6 = (long) 2;
        this.f4388b = length + ("Content-Disposition: form-data; name=\"zipped\"; filename=\"" + str + "\"\r\n").length() + 40 + 35 + j6 + ((long) bArr.length) + j6;
    }

    public void i(long j, String str) {
        long j6 = this.f4388b;
        String str2 = (String) this.f4389c;
        long length = j6 + ("--" + str2 + "\r\n").length();
        this.f4388b = length;
        long j10 = (long) 2;
        this.f4388b = length + ("Content-Disposition: form-data; name=\"apk_file\"; filename=\"" + str + "\"\r\n").length() + 40 + 35 + j10 + j + j10;
    }

    public void j() {
        long j = this.f4388b;
        String str = (String) this.f4389c;
        this.f4388b = j + ("--" + str + "--\r\n").length();
    }

    public void k(String str, String str2) {
        str2.getClass();
        long j = this.f4388b;
        String str3 = (String) this.f4389c;
        long length = j + ("--" + str3 + "\r\n").length() + 26;
        this.f4388b = length;
        long length2 = length + ("Content-Disposition: form-data; name=\"" + str + "\"\r\n").length();
        this.f4388b = length2;
        this.f4388b = length2 + ("\r\n" + str2 + "\r\n").length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0126, code lost:
    
        if (r8 != null) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.internal.measurement.b3 l(com.google.android.gms.internal.measurement.b3 r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.x0.l(com.google.android.gms.internal.measurement.b3, java.lang.String):com.google.android.gms.internal.measurement.b3");
    }

    public u n() {
        return new u((String) this.f4389c, new t(new Bundle((Bundle) this.f4391e)), (String) this.f4390d, this.f4388b);
    }

    public String toString() {
        switch (this.f4387a) {
            case 0:
                String str = (String) this.f4390d;
                String obj = ((Bundle) this.f4391e).toString();
                int length = String.valueOf(str).length();
                String str2 = (String) this.f4389c;
                StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + obj.length());
                a4.x.B(sb, "origin=", str, ",name=", str2);
                return a4.x.n(sb, ",params=", obj);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ x0(c cVar) {
        this.f4387a = 1;
        this.f4391e = cVar;
    }

    public x0(long j, Bundle bundle, String str, String str2) {
        this.f4387a = 0;
        this.f4389c = str;
        this.f4390d = str2;
        this.f4391e = bundle;
        this.f4388b = j;
    }
}
