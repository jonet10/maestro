package com.google.gson.internal.bind;

import androidx.lifecycle.l;
import com.google.gson.i;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3184a;

    /* renamed from: b, reason: collision with root package name */
    public final Field f3185b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3186c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Method f3187d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i f3188e;
    public final /* synthetic */ i f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ boolean h;

    public c(String str, Field field, Method method, i iVar, i iVar2, boolean z9, boolean z10) {
        this.f3187d = method;
        this.f3188e = iVar;
        this.f = iVar2;
        this.g = z9;
        this.h = z10;
        this.f3184a = str;
        this.f3185b = field;
        this.f3186c = field.getName();
    }

    public final void a(k3.b bVar, Object obj) {
        Object obj2;
        Method method = this.f3187d;
        if (method != null) {
            try {
                obj2 = method.invoke(obj, null);
            } catch (InvocationTargetException e10) {
                throw new com.google.gson.e(l.w("Accessor ", j3.c.d(method, false), " threw exception"), e10.getCause());
            }
        } else {
            obj2 = this.f3185b.get(obj);
        }
        if (obj2 == obj) {
            return;
        }
        bVar.i(this.f3184a);
        this.f3188e.c(bVar, obj2);
    }
}
