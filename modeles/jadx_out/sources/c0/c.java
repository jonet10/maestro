package c0;

import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1174a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1175b;

    public /* synthetic */ c(Object obj, int i) {
        this.f1174a = i;
        this.f1175b = obj;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        switch (this.f1174a) {
            case 0:
                HashMap hashMap = (HashMap) this.f1175b;
                Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
                for (String str : hashMap.keySet()) {
                    buildUpon.appendQueryParameter(str, (String) hashMap.get(str));
                }
                String uri = buildUpon.build().toString();
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode < 200 || responseCode >= 300) {
                            StringBuilder sb = new StringBuilder(String.valueOf(uri).length() + 65);
                            sb.append("Received non-success response code ");
                            sb.append(responseCode);
                            sb.append(" from pinging URL: ");
                            sb.append(uri);
                            Log.w("HttpUrlPinger", sb.toString());
                        }
                        httpURLConnection.disconnect();
                        return;
                    } catch (Throwable th) {
                        httpURLConnection.disconnect();
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    String message = e.getMessage();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + String.valueOf(uri).length() + 27);
                    sb2.append("Error while pinging URL: ");
                    sb2.append(uri);
                    sb2.append(". ");
                    sb2.append(message);
                    Log.w("HttpUrlPinger", sb2.toString(), e);
                    return;
                } catch (IndexOutOfBoundsException e11) {
                    String message2 = e11.getMessage();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(message2).length() + String.valueOf(uri).length() + 32);
                    sb3.append("Error while parsing ping URL: ");
                    sb3.append(uri);
                    sb3.append(". ");
                    sb3.append(message2);
                    Log.w("HttpUrlPinger", sb3.toString(), e11);
                    return;
                } catch (RuntimeException e12) {
                    e = e12;
                    String message3 = e.getMessage();
                    StringBuilder sb22 = new StringBuilder(String.valueOf(message3).length() + String.valueOf(uri).length() + 27);
                    sb22.append("Error while pinging URL: ");
                    sb22.append(uri);
                    sb22.append(". ");
                    sb22.append(message3);
                    Log.w("HttpUrlPinger", sb22.toString(), e);
                    return;
                } finally {
                }
            default:
                synchronized (((q4.c) this.f1175b).i) {
                    ((q4.c) this.f1175b).i.notifyAll();
                }
                return;
        }
    }
}
