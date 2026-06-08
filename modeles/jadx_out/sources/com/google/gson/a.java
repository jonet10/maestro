package com.google.gson;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f3103d = new a("", "", false);

    /* renamed from: a, reason: collision with root package name */
    public final String f3104a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3105b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3106c;

    static {
        new a("\n", "  ", true);
    }

    public a(String str, String str2, boolean z9) {
        if (!str.matches("[\r\n]*")) {
            com.google.gson.internal.a.p("Only combinations of \\n and \\r are allowed in newline.");
            throw null;
        }
        if (!str2.matches("[ \t]*")) {
            com.google.gson.internal.a.p("Only combinations of spaces and tabs are allowed in indent.");
            throw null;
        }
        this.f3104a = str;
        this.f3105b = str2;
        this.f3106c = z9;
    }
}
