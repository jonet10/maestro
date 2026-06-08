package androidx.privacysandbox.ads.adservices.topics;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Topic {
    private final long modelVersion;
    private final long taxonomyVersion;
    private final int topicId;

    public Topic(long j, long j6, int i) {
        this.taxonomyVersion = j;
        this.modelVersion = j6;
        this.topicId = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Topic)) {
            return false;
        }
        Topic topic = (Topic) obj;
        return this.taxonomyVersion == topic.taxonomyVersion && this.modelVersion == topic.modelVersion && this.topicId == topic.topicId;
    }

    public final long getModelVersion() {
        return this.modelVersion;
    }

    public final long getTaxonomyVersion() {
        return this.taxonomyVersion;
    }

    public final int getTopicId() {
        return this.topicId;
    }

    public int hashCode() {
        long j = this.taxonomyVersion;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j6 = this.modelVersion;
        return ((i + ((int) ((j6 >>> 32) ^ j6))) * 31) + this.topicId;
    }

    public String toString() {
        return "Topic { ".concat("TaxonomyVersion=" + this.taxonomyVersion + ", ModelVersion=" + this.modelVersion + ", TopicCode=" + this.topicId + " }");
    }
}
