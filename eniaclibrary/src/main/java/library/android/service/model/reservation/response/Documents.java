
package library.android.service.model.reservation.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Documents {

    @SerializedName("Document")
    @Expose
    private Object document;

    public Object getDocument() {
        return document;
    }

    public void setDocument(Object document) {
        this.document = document;
    }

}
