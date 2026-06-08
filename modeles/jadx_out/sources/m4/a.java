package m4;

import o7.c0;
import o7.l;
import o7.w;
import o7.y0;
import org.json.JSONException;
import org.json.JSONObject;
import t1.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7277a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7278b;

    /* renamed from: l, reason: collision with root package name */
    public Object f7279l;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.f7277a = i;
        this.f7278b = obj;
        this.f7279l = obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
    
        ((java.lang.Runnable) r10.f7279l).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007a, code lost:
    
        r10.f7279l = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007c, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        t1.i.f9527o.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.f7279l), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        if (r1 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r10.f7278b     // Catch: java.lang.Throwable -> L58
            t1.i r2 = (t1.i) r2     // Catch: java.lang.Throwable -> L58
            java.util.ArrayDeque r2 = r2.f9529b     // Catch: java.lang.Throwable -> L58
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L58
            r3 = 1
            if (r0 != 0) goto L2c
            java.lang.Object r0 = r10.f7278b     // Catch: java.lang.Throwable -> L20
            t1.i r0 = (t1.i) r0     // Catch: java.lang.Throwable -> L20
            int r4 = r0.f9530l     // Catch: java.lang.Throwable -> L20
            r5 = 4
            if (r4 != r5) goto L22
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L46
        L18:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L46
        L20:
            r0 = move-exception
            goto L7d
        L22:
            long r6 = r0.f9531m     // Catch: java.lang.Throwable -> L20
            r8 = 1
            long r6 = r6 + r8
            r0.f9531m = r6     // Catch: java.lang.Throwable -> L20
            r0.f9530l = r5     // Catch: java.lang.Throwable -> L20
            r0 = r3
        L2c:
            java.lang.Object r4 = r10.f7278b     // Catch: java.lang.Throwable -> L20
            t1.i r4 = (t1.i) r4     // Catch: java.lang.Throwable -> L20
            java.util.ArrayDeque r4 = r4.f9529b     // Catch: java.lang.Throwable -> L20
            java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
            r10.f7279l = r4     // Catch: java.lang.Throwable -> L20
            if (r4 != 0) goto L47
            java.lang.Object r0 = r10.f7278b     // Catch: java.lang.Throwable -> L20
            t1.i r0 = (t1.i) r0     // Catch: java.lang.Throwable -> L20
            r0.f9530l = r3     // Catch: java.lang.Throwable -> L20
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L46
            goto L18
        L46:
            return
        L47:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L58
            r1 = r1 | r2
            r2 = 0
            java.lang.Object r3 = r10.f7279l     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            r3.run()     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
        L55:
            r10.f7279l = r2     // Catch: java.lang.Throwable -> L58
            goto L2
        L58:
            r0 = move-exception
            goto L7f
        L5a:
            r0 = move-exception
            goto L7a
        L5c:
            r3 = move-exception
            java.util.logging.Logger r4 = t1.i.f9527o     // Catch: java.lang.Throwable -> L5a
            java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r6.<init>()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r7 = "Exception while executing runnable "
            r6.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r7 = r10.f7279l     // Catch: java.lang.Throwable -> L5a
            java.lang.Runnable r7 = (java.lang.Runnable) r7     // Catch: java.lang.Throwable -> L5a
            r6.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5a
            r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L5a
            goto L55
        L7a:
            r10.f7279l = r2     // Catch: java.lang.Throwable -> L58
            throw r0     // Catch: java.lang.Throwable -> L58
        L7d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            throw r0     // Catch: java.lang.Throwable -> L58
        L7f:
            if (r1 == 0) goto L88
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L88:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.a.a():void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        switch (this.f7277a) {
            case 0:
                String concat = "resolveService:".concat((String) this.f7279l);
                android.support.v4.media.g gVar = (android.support.v4.media.g) this.f7278b;
                if (android.support.v4.media.g.b(gVar, concat)) {
                    ((b) gVar.f248l).f7281b.p();
                    return;
                }
                return;
            case 1:
                android.support.v4.media.g gVar2 = (android.support.v4.media.g) this.f7278b;
                l4.c cVar = (l4.c) this.f7279l;
                try {
                    JSONObject jSONObject = new JSONObject();
                    String str2 = cVar.f7104b;
                    if (str2 != null) {
                        jSONObject.put("name", str2);
                    }
                    String str3 = cVar.f7105c;
                    if (str3 != null) {
                        jSONObject.put("sha256", str3);
                    }
                    String str4 = cVar.f7106d;
                    if (str4 != null) {
                        jSONObject.put("icon", str4);
                    }
                    long j = cVar.f7107e;
                    if (j > 0) {
                        jSONObject.put("size", j);
                    }
                    String str5 = cVar.f;
                    if (str5 != null) {
                        jSONObject.put("senderDeviceName", str5);
                    }
                    str = jSONObject.toString(2);
                } catch (JSONException e10) {
                    e10.printStackTrace();
                    str = null;
                }
                if (android.support.v4.media.g.b(gVar2, str)) {
                    ((b4.g) gVar2.f247b).getClass();
                    b bVar = f4.c.f4885z;
                    bVar.getClass();
                    e2.d dVar = bVar.f7281b;
                    ((b) dVar.f4468m).f = cVar;
                    dVar.p();
                    return;
                }
                return;
            case 2:
                ((l) this.f7278b).C((y0) this.f7279l);
                return;
            case 3:
                ((l) this.f7279l).C((p7.c) this.f7278b);
                return;
            case 4:
                try {
                    a();
                    return;
                } catch (Error e11) {
                    synchronized (((i) this.f7278b).f9529b) {
                        ((i) this.f7278b).f9530l = 1;
                        throw e11;
                    }
                }
            default:
                t7.g gVar3 = (t7.g) this.f7278b;
                w wVar = gVar3.f10332b;
                int i = 0;
                while (true) {
                    try {
                        ((Runnable) this.f7279l).run();
                    } catch (Throwable th) {
                        c0.q(th, t6.i.f10314a);
                    }
                    Runnable y9 = gVar3.y();
                    if (y9 == null) {
                        return;
                    }
                    this.f7279l = y9;
                    i++;
                    if (i >= 16 && wVar.isDispatchNeeded(gVar3)) {
                        wVar.dispatch(gVar3, this);
                        return;
                    }
                }
                break;
        }
    }

    public String toString() {
        switch (this.f7277a) {
            case 4:
                Runnable runnable = (Runnable) this.f7279l;
                if (runnable != null) {
                    return "SequentialExecutorWorker{running=" + runnable + "}";
                }
                StringBuilder sb = new StringBuilder("SequentialExecutorWorker{state=");
                int i = ((i) this.f7278b).f9530l;
                sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "RUNNING" : "QUEUED" : "QUEUING" : "IDLE");
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(Object obj, Object obj2, int i, boolean z9) {
        this.f7277a = i;
        this.f7279l = obj;
        this.f7278b = obj2;
    }

    public a(i iVar) {
        this.f7277a = 4;
        this.f7278b = iVar;
    }
}
