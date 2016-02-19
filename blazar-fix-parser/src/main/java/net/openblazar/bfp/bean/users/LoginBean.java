package net.openblazar.bfp.bean.users;

import net.openblazar.bfp.bean.AbstractBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * @author Wojciech Zankowski
 */
@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean extends AbstractBean {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginBean.class);

    private String username;
    private String password;
    private Boolean rememberMe;

    public void doLogin() {
        UsernamePasswordToken token = new UsernamePasswordToken(getUsername(), getPassword(), getRememberMe());
        try {
            SecurityUtils.getSubject().login(token);

            FacesContext.getCurrentInstance().getExternalContext().redirect("index.html");
        } catch (UnknownAccountException e) {
            facesError("Unknown account.", e);
        } catch (IncorrectCredentialsException e) {
            facesError("Wrong password.", e);
        } catch (LockedAccountException e) {
            facesError("Locked account.", e);
        } catch (AuthenticationException e) {
            facesError("Unknown error.", e);
        } catch (IOException e) {
            facesError("Failed to load page.", e);
        } finally {
            token.clear();
        }
    }

    private void facesError(String message, Exception exception) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        LOGGER.error(message, exception);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

}
