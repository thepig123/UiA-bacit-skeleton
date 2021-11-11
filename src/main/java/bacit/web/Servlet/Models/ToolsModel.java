package Models;

public class ToolsModel {

    int Item_ID;
    boolean Availability;
    String Tool_name;
    String Price_firstDay;
    String Price_followingDays;
    String Tool_info;
    String Tool_type;

    public ToolsModel(int item_ID, boolean availability, String tool_name, String price_firstDay, String price_followingDays, String tool_info, String tool_type) {
        this.Item_ID = item_ID;
        this.Availability = availability;
        this.Tool_name = tool_name;
        this.Price_firstDay = price_firstDay;
        this.Price_followingDays = price_followingDays;
        this.Tool_info = tool_info;
        this.Tool_type = tool_type;

    }

    // Constructor w/o Item_ID (as it is autoincremented)
    public ToolsModel(boolean availability, String tool_name, String price_firstDay, String price_followingDays, String tool_info, String tool_type) {
        this.Availability = availability;
        this.Tool_name = tool_name;
        this.Price_firstDay = price_firstDay;
        this.Price_followingDays = price_followingDays;
        this.Tool_info = tool_info;
        this.Tool_type = tool_type;
    }

    public int getItem_ID() {
        return Item_ID;
    }

    public boolean isAvailability() {
        return Availability;
    }

    public String getTool_name() {
        return Tool_name;
    }

    public String getPrice_firstDay() {
        return Price_firstDay;
    }

    public String getPrice_followingDays() {
        return Price_followingDays;
    }

    public String getTool_info() {
        return Tool_info;
    }

    public String getTool_type() {
        return Tool_type;
    }

    public void setItem_ID(int item_ID) {
        Item_ID = item_ID;
    }

    public void setAvailability(boolean availability) {
        Availability = availability;
    }

    public void setTool_name(String tool_name) {
        Tool_name = tool_name;
    }

    public void setPrice_firstDay(String price_firstDay) {
        Price_firstDay = price_firstDay;
    }

    public void setPrice_followingDays(String price_followingDays) {
        Price_followingDays = price_followingDays;
    }

    public void setTool_info(String tool_info) {
        Tool_info = tool_info;
    }

    public void setTool_type(String tool_type) {
        Tool_type = tool_type;
    }

    @Override
    public String toString() {
        return "ToolsModel{" +
                ", Availability='" + Availability + '\'' +
                ", Price_firstDay='" + Price_firstDay + '\'' +
                ", Price_followingDays='" + Price_followingDays + '\'' +
                ", Tool_info='" + Tool_info + '\'' +
                ", Tool_type=" + Tool_type +
                '}';
    }
}