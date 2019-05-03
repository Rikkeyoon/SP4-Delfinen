package businesslogic;

import datalag.DBFacade;
import java.util.ArrayList;
import presentation.UI;

/*
 * @author Caroline, Rikke & Nina
 */
public class Controller {

    private UI ui;
    private DBFacade db;

    public Controller(UI ui, DBFacade db) {
        this.ui = ui;
        this.db = db;
    }
    
    public void start() {
        boolean quit = false;
        ui.showMainMenu();
        
        do {
            switch (ui.mainMenuChoice()) {
                case 1: 
                    ui.showMembersMenu();
                    do {
                        switch (ui.memberMenuChoice()) {
                            case 1:
                                showMembersList();
                                break;
                            case 2: 
                                createMember();
                                break;
                            case 3:
                                editMember();
                                break;
                            case 4:
                                deleteMember();
                                break;
                            case 5:
                                quit = true;
                                start();
                                break;
                            case 6:
                                quit = true;
                                break;
                        }
                    } while (!quit);
                    break;
                case 2:
                    ui.showContingentMenu();
                    do {
                        switch (ui.contingentMenuChoice()) {
                        }
                    }
                    break;
                case 3: 
                    ui.showRestanceMenu();
                    break;
                case 4:
                    showTop5Swimmers();
                    break;
                case 5:
                    ui.showCompetitionSwimmersMenu();
                    break;
                case 6:
                    ui.showTrainingResultsMenu();
                    break;
                case 0:
                    quit = true;
                    break;
            }
        } while (!quit);
    }

    public void createMember() {
        ui.print("Please input first name: ");
        String firstName = ui.scanString();
        ui.print("Please input last name: ");
        String lastName = ui.scanString();
        ui.print("Please enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = ui.scanString();
        ui.print("Is the member an active member? Press Y for yes, or N for no: ");
        boolean isActive = ui.scanBoolean();
        int ID = db.getID();
        
        Member member = new Member(firstName, lastName, dateOfBirth, isActive, ID);
        
        db.saveMember(member);
    }

    public void deleteMember() {
        showMembersList();
        ui.print("Enter the ID of the member you want to delete: ");
        int id = ui.scanInt();
        db.deleteMember(id);
    }

    public void showMembersList() {
        ArrayList<Member> members = db.getMembersList();
        // muligvis sorter medlemmer i forhold til ID
        ui.showMemberList(members);
    }

    private void editMember() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showTop5Swimmers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
