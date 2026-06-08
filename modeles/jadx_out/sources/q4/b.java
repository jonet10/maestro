package q4;

import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public int f8679a;

    /* renamed from: b, reason: collision with root package name */
    public c f8680b;

    public final void a() {
        Field declaredField;
        c cVar = this.f8680b;
        try {
            Class<?> cls = cVar.f8686e.getClass();
            try {
                declaredField = cls.getDeclaredField("pid");
            } catch (NoSuchFieldException unused) {
                declaredField = cls.getDeclaredField("id");
            }
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(cVar.f8686e)).intValue();
            cVar.h.write("(echo -17 > /proc/" + intValue + "/oom_adj) &> /dev/null\n");
            cVar.h.write("(echo -17 > /proc/$$/oom_adj) &> /dev/null\n");
            cVar.h.flush();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        c cVar = this.f8680b;
        try {
            cVar.h.write("echo Started\n");
            cVar.h.flush();
            while (true) {
                String readLine = cVar.f.readLine();
                if (readLine == null) {
                    throw new EOFException();
                }
                if (!"".equals(readLine)) {
                    if ("Started".equals(readLine)) {
                        this.f8679a = 1;
                        a();
                        return;
                    }
                    cVar.f8685d = "unknown error occurred.";
                }
            }
        } catch (IOException e10) {
            this.f8679a = -42;
            if (e10.getMessage() != null) {
                cVar.f8685d = e10.getMessage();
            } else {
                cVar.f8685d = "RootAccess denied?.";
            }
        }
    }
}
