/**
 * Created by onikytchuk on 5/28/14.
 */
public class CalendarService {
    private EventStore store;

    public CalendarService(EventStore store) {
        this.store = store;
    }

    public void add(CalendarEvent event) {
        store.addEvent(event);
    }

    public int indexOf(CalendarEvent event) {
        return (event==null)?-1:store.indexOfEvent(event);
    }

    public CalendarEvent getEventByTitle(String title) {
        return store.getEvent(title);
    }

    public CalendarEvent getEventByTitleAndDescription(String title, String description) {
        return store.getEvent(title, description);
    }

    public String toString() {
        return store.toString();
    }
}

}
