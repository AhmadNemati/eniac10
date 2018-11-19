
package library.android.service.model.authenticateLogin.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthenticateLoginResponse {

    @SerializedName("Code")
    @Expose
    private List<Object> code = null;
    @SerializedName("GeneralCode")
    @Expose
    private Integer generalCode;
    @SerializedName("Message")
    @Expose
    private List<String> message = null;
    @SerializedName("MessageUser")
    @Expose
    private Object messageUser;
    @SerializedName("Token")
    @Expose
    private String token;
    @SerializedName("AccountId")
    @Expose
    private Object accountId;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("TrnBizkey")
    @Expose
    private Object trnBizkey;

    public List<Object> getCode() {
        return code;
    }

    public void setCode(List<Object> code) {
        this.code = code;
    }

    public Integer getGeneralCode() {
        return generalCode;
    }

    public void setGeneralCode(Integer generalCode) {
        this.generalCode = generalCode;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Object getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(Object messageUser) {
        this.messageUser = messageUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getAccountId() {
        return accountId;
    }

    public void setAccountId(Object accountId) {
        this.accountId = accountId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getTrnBizkey() {
        return trnBizkey;
    }

    public void setTrnBizkey(Object trnBizkey) {
        this.trnBizkey = trnBizkey;
    }

}
