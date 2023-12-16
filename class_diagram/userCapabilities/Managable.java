package userCapabilities;
import enums.*;
import users.*;
import java.util.HashMap;

public interface Managable {

	public void viewAcademicStatistics();
	public void makeOfficeHoursSchedule();
	public void obtainingProgressStatistics();
	public void gettingPassingStatistics();
	public void viewRegisteredSchedule();
	
	HashMap<String, HashMap<WeekDays, Teacher>> getLessonSchedule();
}
