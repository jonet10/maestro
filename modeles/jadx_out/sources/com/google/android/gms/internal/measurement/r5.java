package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class r5 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f2778a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f2779b;

    static {
        Charset.forName("US-ASCII");
        f2778a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f2779b = bArr;
        ByteBuffer.wrap(bArr);
    }
}
