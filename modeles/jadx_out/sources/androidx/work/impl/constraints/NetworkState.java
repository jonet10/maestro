package androidx.work.impl.constraints;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class NetworkState {
    private final boolean isBlocked;
    private final boolean isConnected;
    private final boolean isMetered;
    private final boolean isNotRoaming;
    private final boolean isValidated;

    public NetworkState(boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.isConnected = z9;
        this.isValidated = z10;
        this.isMetered = z11;
        this.isNotRoaming = z12;
        this.isBlocked = z13;
    }

    public static /* synthetic */ NetworkState copy$default(NetworkState networkState, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i, Object obj) {
        if ((i & 1) != 0) {
            z9 = networkState.isConnected;
        }
        if ((i & 2) != 0) {
            z10 = networkState.isValidated;
        }
        if ((i & 4) != 0) {
            z11 = networkState.isMetered;
        }
        if ((i & 8) != 0) {
            z12 = networkState.isNotRoaming;
        }
        if ((i & 16) != 0) {
            z13 = networkState.isBlocked;
        }
        boolean z14 = z13;
        boolean z15 = z11;
        return networkState.copy(z9, z10, z15, z12, z14);
    }

    public final boolean component1() {
        return this.isConnected;
    }

    public final boolean component2() {
        return this.isValidated;
    }

    public final boolean component3() {
        return this.isMetered;
    }

    public final boolean component4() {
        return this.isNotRoaming;
    }

    public final boolean component5() {
        return this.isBlocked;
    }

    public final NetworkState copy(boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
        return new NetworkState(z9, z10, z11, z12, z13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        return this.isConnected == networkState.isConnected && this.isValidated == networkState.isValidated && this.isMetered == networkState.isMetered && this.isNotRoaming == networkState.isNotRoaming && this.isBlocked == networkState.isBlocked;
    }

    public int hashCode() {
        return ((((((((this.isConnected ? 1231 : 1237) * 31) + (this.isValidated ? 1231 : 1237)) * 31) + (this.isMetered ? 1231 : 1237)) * 31) + (this.isNotRoaming ? 1231 : 1237)) * 31) + (this.isBlocked ? 1231 : 1237);
    }

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isMetered() {
        return this.isMetered;
    }

    public final boolean isNotRoaming() {
        return this.isNotRoaming;
    }

    public final boolean isValidated() {
        return this.isValidated;
    }

    public String toString() {
        return "NetworkState(isConnected=" + this.isConnected + ", isValidated=" + this.isValidated + ", isMetered=" + this.isMetered + ", isNotRoaming=" + this.isNotRoaming + ", isBlocked=" + this.isBlocked + ')';
    }
}
