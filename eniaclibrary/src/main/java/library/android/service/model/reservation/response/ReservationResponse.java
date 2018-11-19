
package library.android.service.model.reservation.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReservationResponse {

    @SerializedName("Code")
    @Expose
    private Object code;
    @SerializedName("Message")
    @Expose
    private Object message;
    @SerializedName("MessageUser")
    @Expose
    private Object messageUser;
    @SerializedName("CodeBook")
    @Expose
    private Object codeBook;
    @SerializedName("OfferId")
    @Expose
    private String offerId;
    @SerializedName("PassiveSessionId")
    @Expose
    private Object passiveSessionId;
    @SerializedName("ResponseDetail")
    @Expose
    private ResponseDetail responseDetail;
    @SerializedName("Settings")
    @Expose
    private Object settings;

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(Object messageUser) {
        this.messageUser = messageUser;
    }

    public Object getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(Object codeBook) {
        this.codeBook = codeBook;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public Object getPassiveSessionId() {
        return passiveSessionId;
    }

    public void setPassiveSessionId(Object passiveSessionId) {
        this.passiveSessionId = passiveSessionId;
    }

    public ResponseDetail getResponseDetail() {
        return responseDetail;
    }

    public void setResponseDetail(ResponseDetail responseDetail) {
        this.responseDetail = responseDetail;
    }

    public Object getSettings() {
        return settings;
    }

    public void setSettings(Object settings) {
        this.settings = settings;
    }

}
