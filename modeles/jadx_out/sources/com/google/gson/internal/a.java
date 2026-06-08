package com.google.gson.internal;

import a4.d0;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import b2.n2;
import com.google.firebase.datatransport.TransportRegistrar;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.TreeSet;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements m, o.e, OnApplyWindowInsetsListener, s1.d, o.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3128a;

    public /* synthetic */ a(int i) {
        this.f3128a = i;
    }

    public static /* synthetic */ void b() {
        throw new a1.b();
    }

    public static /* synthetic */ void e(int i, int i6, Object obj, String str) {
        throw new IndexOutOfBoundsException(str + i + obj + i6);
    }

    public static /* synthetic */ void f(int i, String str) {
        throw new IllegalStateException(str + i);
    }

    public static /* synthetic */ void g(int i, StringBuilder sb) {
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static /* synthetic */ void h(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void i(String str) {
        throw new NullPointerException(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(String str, int i, Object obj, int i6, int i10) {
        throw new IllegalArgumentException(str + i + obj + i6 + ((char) i10));
    }

    public static /* synthetic */ void k(Throwable th) {
        throw new RuntimeException(th);
    }

    public static /* synthetic */ void l() {
        throw new NoSuchElementException();
    }

    public static /* synthetic */ void m(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void n(String str) {
        throw new IOException(str);
    }

    public static /* synthetic */ void o() {
        throw new ClassCastException();
    }

    public static /* synthetic */ void p(String str) {
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ void q() {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ void r(String str) {
        throw new IndexOutOfBoundsException(str);
    }

    @Override // o.e
    public Object apply(Object obj) {
        f2.a.f4817b.getClass();
        return c2.c.f1184a.z((n2) obj).getBytes(Charset.forName("UTF-8"));
    }

    @Override // s1.d
    public Object c(d0 d0Var) {
        o.f lambda$getComponents$0;
        o.f lambda$getComponents$1;
        o.f lambda$getComponents$2;
        switch (this.f3128a) {
            case 10:
                lambda$getComponents$0 = TransportRegistrar.lambda$getComponents$0(d0Var);
                return lambda$getComponents$0;
            case 11:
                lambda$getComponents$1 = TransportRegistrar.lambda$getComponents$1(d0Var);
                return lambda$getComponents$1;
            default:
                lambda$getComponents$2 = TransportRegistrar.lambda$getComponents$2(d0Var);
                return lambda$getComponents$2;
        }
    }

    @Override // com.google.gson.internal.m
    public Object d() {
        switch (this.f3128a) {
            case 0:
                return new LinkedHashSet();
            case 1:
                return new TreeSet();
            default:
                return new ArrayDeque();
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        switch (this.f3128a) {
            case 7:
                int i = FileExplorerActivity.f3379q0;
                view.getClass();
                windowInsetsCompat.getClass();
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                insets.getClass();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    i("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    return null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = insets.left;
                marginLayoutParams.bottomMargin = insets.bottom;
                marginLayoutParams.rightMargin = insets.right;
                marginLayoutParams.topMargin = insets.top;
                view.setLayoutParams(marginLayoutParams);
                return WindowInsetsCompat.CONSUMED;
            default:
                Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                insets2.getClass();
                view.getClass();
                view.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
                return windowInsetsCompat;
        }
    }

    @Override // o.g
    public void a(Exception exc) {
    }
}
