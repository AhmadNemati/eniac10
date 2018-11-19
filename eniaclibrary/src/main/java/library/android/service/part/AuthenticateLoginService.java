package library.android.service.part;

import library.android.service.generator.ServiceGenerator;
import library.android.service.listener.OnServiceStatus;
import library.android.service.model.authenticateLogin.request.AuthenticateLoginRequest;
import library.android.service.model.authenticateLogin.response.AuthenticateLoginResponse;

/**
 * Created by RezaNejati on 10/23/2018.
 */
public class AuthenticateLoginService extends BasePart {
    public AuthenticateLoginService(ServiceGenerator serviceGenerator) {
        super(serviceGenerator);
    }

    @Override
    protected BasePart getPart() {
        return this;
    }
    public void setAuthenticateLoginRequest(OnServiceStatus<AuthenticateLoginResponse> listener, AuthenticateLoginRequest request){
        start(getServiceGenerator().createService().authenticateLogin(request),listener);

    }
}
