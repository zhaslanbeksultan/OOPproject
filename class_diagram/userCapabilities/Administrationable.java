package userCapabilities;

import enums.DisciplineType;

public interface Administrationable {
    boolean disciplineRegistration(String discipline);
    boolean addDiscipline(String discipline);
    boolean dropDiscipline(String discipline);
	boolean disciplineRegistration(String discipline, boolean isRegistrationAllowed);
 
}