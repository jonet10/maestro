package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import j$.util.Objects;
import java.util.Arrays;
import l7.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalFeatures.Ext11OptIn
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class EncryptedTopic {
    private final byte[] encapsulatedKey;
    private final byte[] encryptedTopic;
    private final String keyIdentifier;

    public EncryptedTopic(byte[] bArr, String str, byte[] bArr2) {
        bArr.getClass();
        str.getClass();
        bArr2.getClass();
        this.encryptedTopic = bArr;
        this.keyIdentifier = str;
        this.encapsulatedKey = bArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncryptedTopic)) {
            return false;
        }
        EncryptedTopic encryptedTopic = (EncryptedTopic) obj;
        return Arrays.equals(this.encryptedTopic, encryptedTopic.encryptedTopic) && this.keyIdentifier.contentEquals(encryptedTopic.keyIdentifier) && Arrays.equals(this.encapsulatedKey, encryptedTopic.encapsulatedKey);
    }

    public final byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    public final byte[] getEncryptedTopic() {
        return this.encryptedTopic;
    }

    public final String getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.encryptedTopic)), this.keyIdentifier, Integer.valueOf(Arrays.hashCode(this.encapsulatedKey)));
    }

    public String toString() {
        return "EncryptedTopic { ".concat("EncryptedTopic=" + u.j0(this.encryptedTopic) + ", KeyIdentifier=" + this.keyIdentifier + ", EncapsulatedKey=" + u.j0(this.encapsulatedKey) + " }");
    }
}
