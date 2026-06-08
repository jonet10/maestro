package androidx.datastore.preferences.protobuf;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@CheckReturnValue
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class Protobuf {
    private static final Protobuf INSTANCE = new Protobuf();
    static boolean assumeLiteRuntime = false;
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap();
    private final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    private Protobuf() {
    }

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    public int getTotalSchemaSize() {
        int i = 0;
        for (Schema<?> schema : this.schemaCache.values()) {
            if (schema instanceof MessageSchema) {
                i += ((MessageSchema) schema).getSchemaSize();
            }
        }
        return i;
    }

    public <T> boolean isInitialized(T t9) {
        return schemaFor((Protobuf) t9).isInitialized(t9);
    }

    public <T> void makeImmutable(T t9) {
        schemaFor((Protobuf) t9).makeImmutable(t9);
    }

    public <T> void mergeFrom(T t9, Reader reader) throws IOException {
        mergeFrom(t9, reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    public Schema<?> registerSchema(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(cls, schema);
    }

    @CanIgnoreReturnValue
    public Schema<?> registerSchemaOverride(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.put(cls, schema);
    }

    public <T> Schema<T> schemaFor(Class<T> cls) {
        Internal.checkNotNull(cls, "messageType");
        Schema<T> schema = (Schema) this.schemaCache.get(cls);
        if (schema == null) {
            schema = this.schemaFactory.createSchema(cls);
            Schema<T> schema2 = (Schema<T>) registerSchema(cls, schema);
            if (schema2 != null) {
                return schema2;
            }
        }
        return schema;
    }

    public <T> void writeTo(T t9, Writer writer) throws IOException {
        schemaFor((Protobuf) t9).writeTo(t9, writer);
    }

    public <T> void mergeFrom(T t9, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        schemaFor((Protobuf) t9).mergeFrom(t9, reader, extensionRegistryLite);
    }

    public <T> Schema<T> schemaFor(T t9) {
        return schemaFor((Class) t9.getClass());
    }
}
