package android.support.v4.media;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class c {
    b mConnectionCallbackInternal;
    final Object mConnectionCallbackObj = new i(new a3.d(this, 2));

    public abstract void onConnected();

    public abstract void onConnectionFailed();

    public abstract void onConnectionSuspended();

    public void setInternalConnectionCallback(b bVar) {
        this.mConnectionCallbackInternal = bVar;
    }
}
