package m4;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.measurement.z3;
import g4.s0;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import l7.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7285a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e2.d f7286b;

    public /* synthetic */ c(e2.d dVar, int i) {
        this.f7285a = i;
        this.f7286b = dVar;
    }

    /* JADX INFO: Infinite loop detected, blocks: 37, insns: 0 */
    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArr;
        int read;
        File file;
        InputStream inputStream;
        switch (this.f7285a) {
            case 0:
                e2.d dVar = this.f7286b;
                b bVar = (b) dVar.f4468m;
                b4.g gVar = (b4.g) dVar.f4467l;
                try {
                    Socket socket = bVar.f7283d;
                    if (socket == null) {
                        gVar.f1004a.b();
                        break;
                    } else if (socket.isClosed()) {
                        gVar.f1004a.b();
                        break;
                    } else {
                        while (true) {
                            Socket socket2 = bVar.f7283d;
                            socket2.getClass();
                            String readUTF = new DataInputStream(socket2.getInputStream()).readUTF();
                            if (readUTF == null) {
                                gVar.f1004a.b();
                            } else if (readUTF.equalsIgnoreCase("OK")) {
                                l4.c cVar = bVar.f;
                                if (cVar != null) {
                                    gVar.getClass();
                                    b4.g.d(cVar);
                                }
                            } else if (readUTF.equalsIgnoreCase("KO")) {
                                gVar.getClass();
                            } else if (readUTF.equalsIgnoreCase("FileReceived")) {
                                gVar.getClass();
                            } else if (u.p0(readUTF, "resolveService:", false)) {
                                gVar.i(readUTF.substring(15));
                            } else {
                                l4.c cVar2 = new l4.c();
                                dVar.f4472q = cVar2;
                                cVar2.a(readUTF);
                                l4.c cVar3 = (l4.c) dVar.f4472q;
                                cVar3.getClass();
                                gVar.getClass();
                                b4.g.c(cVar3);
                            }
                        }
                    }
                } catch (EOFException unused) {
                    gVar.f1004a.b();
                    return;
                } catch (IOException unused2) {
                    gVar.f1004a.b();
                    return;
                } catch (Exception unused3) {
                    gVar.f1004a.b();
                    return;
                }
            case 1:
                e2.d dVar2 = this.f7286b;
                b4.g gVar2 = (b4.g) dVar2.f4467l;
                try {
                    Context context = (Context) dVar2.f4466b;
                    context.getClass();
                    File file2 = new File(context.getExternalFilesDir(null), "received");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    l4.c cVar4 = (l4.c) dVar2.f4472q;
                    cVar4.getClass();
                    if (cVar4.f7104b != null) {
                        l4.c cVar5 = (l4.c) dVar2.f4472q;
                        cVar5.getClass();
                        String str = cVar5.f7104b;
                        str.getClass();
                        File file3 = new File(file2, str);
                        Socket socket3 = ((b) dVar2.f4468m).f7284e;
                        socket3.getClass();
                        InputStream inputStream2 = socket3.getInputStream();
                        if (inputStream2 == null) {
                            gVar2.f("ERROR: cant create output file");
                            break;
                        } else {
                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                            l4.c cVar6 = (l4.c) dVar2.f4472q;
                            cVar6.getClass();
                            long j = cVar6.f7107e;
                            int i = 0;
                            long j6 = 0;
                            byte[] bArr2 = new byte[8192];
                            int i6 = 0;
                            int i10 = 0;
                            while (i6 < j && (read = inputStream2.read((bArr = bArr2), i, 8192)) > 0) {
                                fileOutputStream.write(bArr, i, read);
                                i6 += read;
                                long j10 = j6;
                                FileOutputStream fileOutputStream2 = fileOutputStream;
                                int i11 = (int) ((i6 * 100.0d) / j);
                                if (i11 <= i10 + 5) {
                                    file = file3;
                                    inputStream = inputStream2;
                                    if (System.currentTimeMillis() <= j10 + 1000 || i11 <= i10) {
                                        fileOutputStream = fileOutputStream2;
                                        j6 = j10;
                                        file3 = file;
                                        inputStream2 = inputStream;
                                        i = 0;
                                        bArr2 = bArr;
                                    }
                                } else {
                                    file = file3;
                                    inputStream = inputStream2;
                                }
                                long currentTimeMillis = System.currentTimeMillis();
                                gVar2.getClass();
                                Activity activity = f4.c.f4875o;
                                if (activity != null && (activity instanceof s0)) {
                                    s0 s0Var = (s0) activity;
                                    s0Var.runOnUiThread(new androidx.core.content.res.a(s0Var, i11, 3));
                                }
                                bArr2 = bArr;
                                i10 = i11;
                                fileOutputStream = fileOutputStream2;
                                i = 0;
                                j6 = currentTimeMillis;
                                file3 = file;
                                inputStream2 = inputStream;
                            }
                            File file4 = file3;
                            FileOutputStream fileOutputStream3 = fileOutputStream;
                            gVar2.getClass();
                            Activity activity2 = f4.c.f4875o;
                            if (activity2 != null && (activity2 instanceof s0)) {
                                s0 s0Var2 = (s0) activity2;
                                s0Var2.runOnUiThread(new androidx.core.content.res.a(s0Var2, 100, 3));
                            }
                            fileOutputStream3.close();
                            String x3 = z3.x(file4.getAbsolutePath());
                            if (x3 != null) {
                                l4.c cVar7 = (l4.c) dVar2.f4472q;
                                cVar7.getClass();
                                if (x3.equalsIgnoreCase(cVar7.f7105c)) {
                                    l4.c cVar8 = (l4.c) dVar2.f4472q;
                                    cVar8.getClass();
                                    String str2 = cVar8.f7104b;
                                    str2.getClass();
                                    b4.g.b(str2);
                                    break;
                                }
                            }
                            gVar2.f("ERROR: File hashes do not macth!");
                            break;
                        }
                    }
                } catch (Exception e10) {
                    if (e10.getMessage() == null) {
                        gVar2.f("Exception");
                        return;
                    }
                    String message = e10.getMessage();
                    message.getClass();
                    gVar2.f(message);
                    return;
                }
                break;
            default:
                e2.d dVar3 = this.f7286b;
                b4.g gVar3 = (b4.g) dVar3.f4467l;
                try {
                    ServerSocket serverSocket = new ServerSocket(0);
                    dVar3.f4469n = serverSocket;
                    gVar3.e(serverSocket.getLocalPort());
                    while (true) {
                        Thread thread = (Thread) dVar3.f4470o;
                        thread.getClass();
                        if (thread.isInterrupted()) {
                            break;
                        } else {
                            ServerSocket serverSocket2 = (ServerSocket) dVar3.f4469n;
                            serverSocket2.getClass();
                            Socket accept = serverSocket2.accept();
                            b bVar2 = (b) dVar3.f4468m;
                            accept.getClass();
                            bVar2.b(accept);
                            b4.g.a(accept.getRemoteSocketAddress().toString());
                        }
                    }
                } catch (IOException e11) {
                    e11.printStackTrace();
                } catch (Exception e12) {
                    e12.printStackTrace();
                    return;
                }
        }
    }
}
