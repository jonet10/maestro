package androidx.leanback.widget;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface PlaybackSeekUi {
    void setPlaybackSeekUiClient(Client client);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Client {
        public PlaybackSeekDataProvider getPlaybackSeekDataProvider() {
            return null;
        }

        public boolean isSeekEnabled() {
            return false;
        }

        public void onSeekStarted() {
        }

        public void onSeekFinished(boolean z9) {
        }

        public void onSeekPositionChanged(long j) {
        }
    }
}
