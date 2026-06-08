package androidx.datastore.preferences;

import androidx.annotation.RestrictTo;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.io.InputStream;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PreferencesMapCompat {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PreferencesProto.PreferenceMap readFrom(InputStream inputStream) {
            inputStream.getClass();
            try {
                PreferencesProto.PreferenceMap parseFrom = PreferencesProto.PreferenceMap.parseFrom(inputStream);
                parseFrom.getClass();
                return parseFrom;
            } catch (InvalidProtocolBufferException e10) {
                throw new CorruptionException("Unable to parse preferences proto.", e10);
            }
        }

        private Companion() {
        }
    }
}
