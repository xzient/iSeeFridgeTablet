package t.cmsc434.iseefridgetablet;

public class InventoryItem {
    private String name;
    private String amount;
    private String notes;

    public InventoryItem (String name, String amount, String notes) {
        this.name = name;
        this.amount = amount;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
