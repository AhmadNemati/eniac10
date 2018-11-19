package library.android.eniac.model;

import library.android.service.model.reservation.request.Traveler;

/**
 * Created by RezaNejati on 11/17/2018.
 */
public class PassengerModel {
    int count;
    boolean adult;
    boolean child;
    boolean infant;
    boolean focus=false;
    Traveler traveler;

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean isChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }

    public boolean isInfant() {
        return infant;
    }

    public void setInfant(boolean infant) {
        this.infant = infant;
    }

    public Traveler getTraveler() {
        return traveler;
    }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }
}
