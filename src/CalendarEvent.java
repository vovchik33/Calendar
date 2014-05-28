
import java.util.List;
import java.util.UUID;

/**
 * Created by Vladimir V. Kravchenko on 20.05.2014.
 */
public class CalendarEvent {
    private final UUID id;
    private final String title;
    private final String description;
    private final List<Person> attenders;
    private final String startDate;
    private final String finishDate;

    private CalendarEvent(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.attenders = builder.attenders;
        this.startDate = builder.startDate;
        this.finishDate = builder.finishDate;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Person> getAttenders() {
        return attenders;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalendarEvent that = (CalendarEvent) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CalendarEvent{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", attenders=").append(attenders);
        sb.append(", startDate='").append(startDate).append('\'');
        sb.append(", finishDate='").append(finishDate).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {
        private UUID id;
        private String title;
        private String description;
        private List<Person> attenders;
        private String startDate;
        private String finishDate;

        public Builder() {
        }

        public Builder(CalendarEvent event) {
            this.id = event.id;
            this.title = event.title;
            this.description = event.description;
            this.attenders = event.attenders;
            this.startDate = event.startDate;
            this.finishDate = event.finishDate;
        }

        public Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAttenders(List<Person> attenders) {
            this.attenders = attenders;
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setFinishDate(String finishDate) {
            this.finishDate = finishDate;
            return this;
        }

        public CalendarEvent build() {
            return new CalendarEvent(this);
        }
    }

}