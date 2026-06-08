package y2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.Closeable;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final URL f11744a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Future f11745b;

    /* renamed from: l, reason: collision with root package name */
    public j1.p f11746l;

    public m(URL url) {
        this.f11744a = url;
    }

    public final Bitmap b() {
        boolean isLoggable = Log.isLoggable("FirebaseMessaging", 4);
        URL url = this.f11744a;
        if (isLoggable) {
            Log.i("FirebaseMessaging", "Starting download of: " + url);
        }
        URLConnection openConnection = url.openConnection();
        if (openConnection.getContentLength() > 1048576) {
            com.google.gson.internal.a.n("Content-Length exceeds max size of 1048576");
            return null;
        }
        InputStream inputStream = openConnection.getInputStream();
        try {
            byte[] k5 = a0.k(new d(inputStream));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                Log.v("FirebaseMessaging", "Downloaded " + k5.length + " bytes from " + url);
            }
            if (k5.length > 1048576) {
                com.google.gson.internal.a.n("Image exceeds max size of 1048576");
                return null;
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(k5, 0, k5.length);
            if (decodeByteArray == null) {
                s1.o.k(url, "Failed to decode image: ");
                return null;
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Successfully downloaded image: " + url);
            }
            return decodeByteArray;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f11745b.cancel(true);
    }
}
