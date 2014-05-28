import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by onikytchuk on 5/28/14.
 */
public class EventStore {
        private List list;

    public EventStore(List list) {
        this.list = list;
    }

    public void addEvent (CalendarEvent event) {
        list.add(event);
    }

    public int indexOfEvent (CalendarEvent event){
        return list.indexOf(event);
    }

    class EventComparator implements Comparator<CalendarEvent> {

        @Override
        public int compare(CalendarEvent o1, CalendarEvent o2) {
            int result = o1.getTitle().compareTo(o2.getTitle());
            if (o1.getDescription()!=null && o2.getDescription()!=null && o1.getDescription().compareTo("")!=0 && o2.getDescription().compareTo("")!=0) {
                if (result==0) result = o1.getDescription().compareTo(o2.getDescription());
            }
            return result;
        }
    }

    @Override
    public String toString() {
        return "EventStore{" +
                "list=" + list +
                '}';
    }

    public CalendarEvent getEvent(String title) {
        CalendarEvent event;
        Collections.sort(list, new EventComparator());
        try {
            return list.get(Collections.binarySearch(list, new CalendarEvent.Builder().setTitle(title).setDescription("").build(),
                    new EventComparator()));
        } catch (Exception e) {
            return null;
        }
    }

    public CalendarEvent getEvent(String title, String description) {
        CalendarEvent event;
        Collections.sort(list, new EventComparator());
        return list.get(Collections.binarySearch(list, new CalendarEvent.Builder().setTitle(title).setDescription(description).build(), new EventComparator()));
    }
}
