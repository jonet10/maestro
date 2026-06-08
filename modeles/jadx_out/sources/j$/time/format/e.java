package j$.time.format;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class e implements f {

    /* renamed from: a, reason: collision with root package name */
    public final f[] f5828a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5829b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(java.util.List r2, boolean r3) {
        /*
            r1 = this;
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r0 = r2.size()
            j$.time.format.f[] r0 = new j$.time.format.f[r0]
            java.lang.Object[] r2 = r2.toArray(r0)
            j$.time.format.f[] r2 = (j$.time.format.f[]) r2
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.e.<init>(java.util.List, boolean):void");
    }

    public e(f[] fVarArr, boolean z9) {
        this.f5828a = fVarArr;
        this.f5829b = z9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        if (r2 != false) goto L11;
     */
    @Override // j$.time.format.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(j$.time.format.p r8, java.lang.StringBuilder r9) {
        /*
            r7 = this;
            int r0 = r9.length()
            r1 = 1
            boolean r2 = r7.f5829b
            if (r2 == 0) goto Le
            int r3 = r8.f5858c
            int r3 = r3 + r1
            r8.f5858c = r3
        Le:
            j$.time.format.f[] r3 = r7.f5828a     // Catch: java.lang.Throwable -> L27
            int r4 = r3.length     // Catch: java.lang.Throwable -> L27
            r5 = 0
        L12:
            if (r5 >= r4) goto L2c
            r6 = r3[r5]     // Catch: java.lang.Throwable -> L27
            boolean r6 = r6.e(r8, r9)     // Catch: java.lang.Throwable -> L27
            if (r6 != 0) goto L29
            r9.setLength(r0)     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L2f
        L21:
            int r9 = r8.f5858c
            int r9 = r9 - r1
            r8.f5858c = r9
            return r1
        L27:
            r9 = move-exception
            goto L30
        L29:
            int r5 = r5 + 1
            goto L12
        L2c:
            if (r2 == 0) goto L2f
            goto L21
        L2f:
            return r1
        L30:
            if (r2 == 0) goto L37
            int r0 = r8.f5858c
            int r0 = r0 - r1
            r8.f5858c = r0
        L37:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.e.e(j$.time.format.p, java.lang.StringBuilder):boolean");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        f[] fVarArr = this.f5828a;
        if (fVarArr != null) {
            boolean z9 = this.f5829b;
            sb.append(z9 ? "[" : "(");
            for (f fVar : fVarArr) {
                sb.append(fVar);
            }
            sb.append(z9 ? "]" : ")");
        }
        return sb.toString();
    }
}
