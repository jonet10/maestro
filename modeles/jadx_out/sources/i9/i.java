package i9;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i {
    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r6, java.lang.String r7, v6.c r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof i9.g
            if (r0 == 0) goto L13
            r0 = r8
            i9.g r0 = (i9.g) r0
            int r1 = r0.f5722l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5722l = r1
            goto L18
        L13:
            i9.g r0 = new i9.g
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f5720a
            int r1 = r0.f5722l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            p6.a.e(r8)     // Catch: java.lang.Exception -> L26
            goto L46
        L26:
            r6 = move-exception
            goto L49
        L28:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            return r2
        L2e:
            p6.a.e(r8)
            v7.e r8 = o7.m0.f8288a     // Catch: java.lang.Exception -> L26
            v7.d r8 = v7.d.f10884a     // Catch: java.lang.Exception -> L26
            i9.h r1 = new i9.h     // Catch: java.lang.Exception -> L26
            r4 = 0
            r1.<init>(r6, r7, r2, r4)     // Catch: java.lang.Exception -> L26
            r0.f5722l = r3     // Catch: java.lang.Exception -> L26
            java.lang.Object r6 = o7.c0.C(r1, r8, r0)     // Catch: java.lang.Exception -> L26
            u6.a r7 = u6.a.f10762a
            if (r6 != r7) goto L46
            return r7
        L46:
            p6.x r6 = p6.x.f8463a
            return r6
        L49:
            boolean r7 = r6 instanceof java.security.cert.CertificateException
            if (r7 == 0) goto L4e
            goto L61
        L4e:
            boolean r7 = r6 instanceof javax.net.ssl.SSLHandshakeException
            if (r7 == 0) goto L53
            goto L61
        L53:
            boolean r7 = r6 instanceof java.net.SocketException
            if (r7 == 0) goto L58
            goto L61
        L58:
            boolean r7 = r6 instanceof java.net.MalformedURLException
            if (r7 == 0) goto L5d
            goto L61
        L5d:
            boolean r7 = r6 instanceof java.lang.NullPointerException
            if (r7 == 0) goto L64
        L61:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_CALL_FAILED
            goto L6d
        L64:
            boolean r6 = r6 instanceof java.io.FileNotFoundException
            if (r6 == 0) goto L6b
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR
            goto L6d
        L6b:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_UNEXPECTED_ERROR
        L6d:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()
            if (r7 != 0) goto L76
            goto L79
        L76:
            r7.onCmpError(r6)
        L79:
            r5.a r7 = new r5.a
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.i.a(java.lang.String, java.lang.String, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r6, v6.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof i9.c
            if (r0 == 0) goto L13
            r0 = r7
            i9.c r0 = (i9.c) r0
            int r1 = r0.f5711l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5711l = r1
            goto L18
        L13:
            i9.c r0 = new i9.c
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f5709a
            int r1 = r0.f5711l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            p6.a.e(r7)     // Catch: java.lang.Exception -> L26
            goto L4b
        L26:
            r6 = move-exception
            goto L4e
        L28:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            return r2
        L2e:
            p6.a.e(r7)
            java.lang.String r7 = "Calling api"
            a.a.g(r7, r6)     // Catch: java.lang.Exception -> L26
            v7.e r7 = o7.m0.f8288a     // Catch: java.lang.Exception -> L26
            v7.d r7 = v7.d.f10884a     // Catch: java.lang.Exception -> L26
            i9.d r1 = new i9.d     // Catch: java.lang.Exception -> L26
            r4 = 0
            r1.<init>(r6, r2, r4)     // Catch: java.lang.Exception -> L26
            r0.f5711l = r3     // Catch: java.lang.Exception -> L26
            java.lang.Object r7 = o7.c0.C(r1, r7, r0)     // Catch: java.lang.Exception -> L26
            u6.a r6 = u6.a.f10762a
            if (r7 != r6) goto L4b
            return r6
        L4b:
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L26
            return r7
        L4e:
            boolean r7 = r6 instanceof java.security.cert.CertificateException
            if (r7 == 0) goto L53
            goto L66
        L53:
            boolean r7 = r6 instanceof javax.net.ssl.SSLHandshakeException
            if (r7 == 0) goto L58
            goto L66
        L58:
            boolean r7 = r6 instanceof java.net.SocketException
            if (r7 == 0) goto L5d
            goto L66
        L5d:
            boolean r7 = r6 instanceof java.net.MalformedURLException
            if (r7 == 0) goto L62
            goto L66
        L62:
            boolean r7 = r6 instanceof java.lang.NullPointerException
            if (r7 == 0) goto L69
        L66:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_CALL_FAILED
            goto L72
        L69:
            boolean r6 = r6 instanceof java.io.FileNotFoundException
            if (r6 == 0) goto L70
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR
            goto L72
        L70:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_UNEXPECTED_ERROR
        L72:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()
            if (r7 != 0) goto L7b
            goto L7e
        L7b:
            r7.onCmpError(r6)
        L7e:
            r5.a r7 = new r5.a
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.i.b(java.lang.String, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r5, v6.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof i9.e
            if (r0 == 0) goto L13
            r0 = r6
            i9.e r0 = (i9.e) r0
            int r1 = r0.f5716l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5716l = r1
            goto L18
        L13:
            i9.e r0 = new i9.e
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f5714a
            int r1 = r0.f5716l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            p6.a.e(r6)     // Catch: java.lang.Exception -> L26
            goto L4a
        L26:
            r5 = move-exception
            goto L4d
        L28:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            return r2
        L2e:
            p6.a.e(r6)
            java.lang.String r6 = "Calling api"
            a.a.g(r6, r5)     // Catch: java.lang.Exception -> L26
            v7.e r6 = o7.m0.f8288a     // Catch: java.lang.Exception -> L26
            v7.d r6 = v7.d.f10884a     // Catch: java.lang.Exception -> L26
            i9.d r1 = new i9.d     // Catch: java.lang.Exception -> L26
            r1.<init>(r5, r2, r3)     // Catch: java.lang.Exception -> L26
            r0.f5716l = r3     // Catch: java.lang.Exception -> L26
            java.lang.Object r6 = o7.c0.C(r1, r6, r0)     // Catch: java.lang.Exception -> L26
            u6.a r5 = u6.a.f10762a
            if (r6 != r5) goto L4a
            return r5
        L4a:
            i9.a r6 = (i9.a) r6     // Catch: java.lang.Exception -> L26
            return r6
        L4d:
            boolean r6 = r5 instanceof java.security.cert.CertificateException
            if (r6 == 0) goto L52
            goto L65
        L52:
            boolean r6 = r5 instanceof javax.net.ssl.SSLHandshakeException
            if (r6 == 0) goto L57
            goto L65
        L57:
            boolean r6 = r5 instanceof java.net.SocketException
            if (r6 == 0) goto L5c
            goto L65
        L5c:
            boolean r6 = r5 instanceof java.net.MalformedURLException
            if (r6 == 0) goto L61
            goto L65
        L61:
            boolean r6 = r5 instanceof java.lang.NullPointerException
            if (r6 == 0) goto L68
        L65:
            com.inmobi.cmp.model.ChoiceError r5 = com.inmobi.cmp.model.ChoiceError.NETWORK_CALL_FAILED
            goto L71
        L68:
            boolean r5 = r5 instanceof java.io.FileNotFoundException
            if (r5 == 0) goto L6f
            com.inmobi.cmp.model.ChoiceError r5 = com.inmobi.cmp.model.ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR
            goto L71
        L6f:
            com.inmobi.cmp.model.ChoiceError r5 = com.inmobi.cmp.model.ChoiceError.NETWORK_UNEXPECTED_ERROR
        L71:
            com.inmobi.cmp.ChoiceCmp r6 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r6 = r6.getCallback()
            if (r6 != 0) goto L7a
            goto L7d
        L7a:
            r6.onCmpError(r5)
        L7d:
            r5.a r6 = new r5.a
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.i.c(java.lang.String, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r6, v6.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof i9.f
            if (r0 == 0) goto L13
            r0 = r7
            i9.f r0 = (i9.f) r0
            int r1 = r0.f5719l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5719l = r1
            goto L18
        L13:
            i9.f r0 = new i9.f
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f5717a
            int r1 = r0.f5719l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            p6.a.e(r7)     // Catch: java.lang.Exception -> L26
            goto L46
        L26:
            r6 = move-exception
            goto L4c
        L28:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            return r2
        L2e:
            p6.a.e(r7)
            v7.e r7 = o7.m0.f8288a     // Catch: java.lang.Exception -> L26
            v7.d r7 = v7.d.f10884a     // Catch: java.lang.Exception -> L26
            i9.d r1 = new i9.d     // Catch: java.lang.Exception -> L26
            r4 = 2
            r1.<init>(r6, r2, r4)     // Catch: java.lang.Exception -> L26
            r0.f5719l = r3     // Catch: java.lang.Exception -> L26
            java.lang.Object r7 = o7.c0.C(r1, r7, r0)     // Catch: java.lang.Exception -> L26
            u6.a r6 = u6.a.f10762a
            if (r7 != r6) goto L46
            return r6
        L46:
            r7.getClass()     // Catch: java.lang.Exception -> L26
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7     // Catch: java.lang.Exception -> L26
            return r7
        L4c:
            boolean r7 = r6 instanceof java.security.cert.CertificateException
            if (r7 == 0) goto L51
            goto L64
        L51:
            boolean r7 = r6 instanceof javax.net.ssl.SSLHandshakeException
            if (r7 == 0) goto L56
            goto L64
        L56:
            boolean r7 = r6 instanceof java.net.SocketException
            if (r7 == 0) goto L5b
            goto L64
        L5b:
            boolean r7 = r6 instanceof java.net.MalformedURLException
            if (r7 == 0) goto L60
            goto L64
        L60:
            boolean r7 = r6 instanceof java.lang.NullPointerException
            if (r7 == 0) goto L67
        L64:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.FAILED_LOGO_DOWNLOAD
            goto L70
        L67:
            boolean r6 = r6 instanceof java.io.FileNotFoundException
            if (r6 == 0) goto L6e
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR
            goto L70
        L6e:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_UNEXPECTED_ERROR
        L70:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()
            if (r7 != 0) goto L79
            goto L7c
        L79:
            r7.onCmpError(r6)
        L7c:
            r5.a r7 = new r5.a
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.i.d(java.lang.String, v6.c):java.lang.Object");
    }
}
