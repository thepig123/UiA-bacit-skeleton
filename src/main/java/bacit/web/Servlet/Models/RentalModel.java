package bacit.web.Servlet.Models;

public class RentalModel {

    int Item_ID;
    String Damage_report;
    String Rental_startDate;
    String Rental_endDate;


    public RentalModel(int item_ID, String damage_report, String rental_startDate, String rental_endDate) {

        Item_ID = item_ID;

        Damage_report = damage_report;
        Rental_startDate = rental_startDate;
        Rental_endDate = rental_endDate;
    }


    public int getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(int item_ID) {
        Item_ID = item_ID;
    }

    public String getDamage_report() {
        return Damage_report;
    }

    public void setDamage_report(String damage_report) {
        Damage_report = damage_report;
    }

    public String getRental_startDate() {
        return Rental_startDate;
    }

    public void setRental_startDate(String rental_startDate) {
        Rental_startDate = rental_startDate;
    }

    public String getRental_endDate() {
        return Rental_endDate;
    }

    public void setRental_endDate(String rental_endDate) {
        Rental_endDate = rental_endDate;
    }

    @Override
    public String toString() {
        return "RentalModel{" +
                "Item_ID=" + Item_ID +
                ", Damage_report='" + Damage_report + '\'' +
                ", Rental_startDate='" + Rental_startDate + '\'' +
                ", Rental_endDate='" + Rental_endDate + '\'' +
                '}';
    }
}
