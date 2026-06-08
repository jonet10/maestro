package androidx.work;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LoggerExtKt {
    public static final void logd(String str, Throwable th, d7.a aVar) {
        str.getClass();
        th.getClass();
        aVar.getClass();
        Logger.get().debug(str, (String) aVar.invoke(), th);
    }

    public static final void loge(String str, Throwable th, d7.a aVar) {
        str.getClass();
        th.getClass();
        aVar.getClass();
        Logger.get().error(str, (String) aVar.invoke(), th);
    }

    public static final void logi(String str, Throwable th, d7.a aVar) {
        str.getClass();
        th.getClass();
        aVar.getClass();
        Logger.get().info(str, (String) aVar.invoke(), th);
    }

    public static final void logd(String str, d7.a aVar) {
        str.getClass();
        aVar.getClass();
        Logger.get().debug(str, (String) aVar.invoke());
    }

    public static final void loge(String str, d7.a aVar) {
        str.getClass();
        aVar.getClass();
        Logger.get().error(str, (String) aVar.invoke());
    }

    public static final void logi(String str, d7.a aVar) {
        str.getClass();
        aVar.getClass();
        Logger.get().info(str, (String) aVar.invoke());
    }
}
