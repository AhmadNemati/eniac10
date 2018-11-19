package library.android.eniac.model;

/**
 * Created by RezaNejati on 10/28/2018.
 */
public class NumberPickerModel {
    boolean isSelected=false;
    int number;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
