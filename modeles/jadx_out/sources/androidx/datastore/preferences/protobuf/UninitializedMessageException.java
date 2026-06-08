package androidx.datastore.preferences.protobuf;

import j$.util.DesugarCollections;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields;

    public UninitializedMessageException(List<String> list) {
        super(buildDescription(list));
        this.missingFields = list;
    }

    private static String buildDescription(List<String> list) {
        StringBuilder sb = new StringBuilder("Message missing required fields: ");
        boolean z9 = true;
        for (String str : list) {
            if (z9) {
                z9 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }

    public List<String> getMissingFields() {
        return DesugarCollections.unmodifiableList(this.missingFields);
    }

    public UninitializedMessageException(MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }
}
