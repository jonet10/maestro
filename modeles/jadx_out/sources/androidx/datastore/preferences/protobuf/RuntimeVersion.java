package androidx.datastore.preferences.protobuf;

import a4.x;
import java.util.logging.Logger;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RuntimeVersion {
    public static final RuntimeDomain DOMAIN;
    public static final int MAJOR = 4;
    public static final int MINOR = 28;
    public static final RuntimeDomain OSS_DOMAIN;
    public static final int OSS_MAJOR = 4;
    public static final int OSS_MINOR = 28;
    public static final int OSS_PATCH = 2;
    public static final String OSS_SUFFIX = "";
    public static final int PATCH = 2;
    public static final String SUFFIX = "";
    private static final String VERSION_STRING;
    private static final Logger logger;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class ProtobufRuntimeVersionException extends RuntimeException {
        public ProtobufRuntimeVersionException(String str) {
            super(str);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public enum RuntimeDomain {
        GOOGLE_INTERNAL,
        PUBLIC
    }

    static {
        RuntimeDomain runtimeDomain = RuntimeDomain.PUBLIC;
        OSS_DOMAIN = runtimeDomain;
        DOMAIN = runtimeDomain;
        VERSION_STRING = versionString(4, 28, 2, "");
        logger = Logger.getLogger(RuntimeVersion.class.getName());
    }

    private RuntimeVersion() {
    }

    private static boolean checkDisabled() {
        String str = System.getenv("TEMORARILY_DISABLE_PROTOBUF_VERSION_CHECK");
        return str != null && str.equals("true");
    }

    public static void validateProtobufGencodeVersion(RuntimeDomain runtimeDomain, int i, int i6, int i10, String str, String str2) {
        if (checkDisabled()) {
            return;
        }
        validateProtobufGencodeVersionImpl(runtimeDomain, i, i6, i10, str, str2);
    }

    private static void validateProtobufGencodeVersionImpl(RuntimeDomain runtimeDomain, int i, int i6, int i10, String str, String str2) {
        if (checkDisabled()) {
            return;
        }
        String versionString = versionString(i, i6, i10, str);
        if (i < 0 || i6 < 0 || i10 < 0) {
            throw new ProtobufRuntimeVersionException(x.j("Invalid gencode version: ", versionString));
        }
        RuntimeDomain runtimeDomain2 = DOMAIN;
        if (runtimeDomain != runtimeDomain2) {
            throw new ProtobufRuntimeVersionException("Detected mismatched Protobuf Gencode/Runtime domains when loading " + str2 + ": gencode " + runtimeDomain + ", runtime " + runtimeDomain2 + ". Cross-domain usage of Protobuf is not supported.");
        }
        if (i != 4) {
            if (i != 3) {
                String str3 = VERSION_STRING;
                StringBuilder sb = new StringBuilder("Detected mismatched Protobuf Gencode/Runtime major versions when loading ");
                sb.append(str2);
                sb.append(": gencode ");
                sb.append(versionString);
                sb.append(", runtime ");
                throw new ProtobufRuntimeVersionException(x.n(sb, str3, ". Same major version is required."));
            }
            logger.warning(" Protobuf gencode version " + versionString + " is exactly one major version older than the runtime version " + VERSION_STRING + " at " + str2 + ". Please update the gencode to avoid compatibility violations in the next runtime release.");
        }
        if (28 < i6 || (i6 == 28 && 2 < i10)) {
            String str4 = VERSION_STRING;
            StringBuilder sb2 = new StringBuilder("Detected incompatible Protobuf Gencode/Runtime versions when loading ");
            sb2.append(str2);
            sb2.append(": gencode ");
            sb2.append(versionString);
            sb2.append(", runtime ");
            throw new ProtobufRuntimeVersionException(x.n(sb2, str4, ". Runtime version cannot be older than the linked gencode version."));
        }
        if (28 > i6 || 2 > i10) {
            logger.warning(" Protobuf gencode version " + versionString + " is older than the runtime version " + VERSION_STRING + " at " + str2 + ". Please avoid checked-in Protobuf gencode that can be obsolete.");
        }
        if (str.equals("")) {
            return;
        }
        String str5 = VERSION_STRING;
        StringBuilder sb3 = new StringBuilder("Detected mismatched Protobuf Gencode/Runtime version suffixes when loading ");
        sb3.append(str2);
        sb3.append(": gencode ");
        sb3.append(versionString);
        sb3.append(", runtime ");
        throw new ProtobufRuntimeVersionException(x.n(sb3, str5, ". Version suffixes must be the same."));
    }

    private static String versionString(int i, int i6, int i10, String str) {
        return String.format("%d.%d.%d%s", Integer.valueOf(i), Integer.valueOf(i6), Integer.valueOf(i10), str);
    }
}
