package pl.zankowski.fixparser.web.bean.user;

import pl.zankowski.fixparser.web.bean.AbstractBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("loginBean")
@RequestScoped
public class LoginBean extends AbstractBean {
//
//    public static final String ACCOUNT_NOT_ACTIVE = "Your account is not active. Please confirm your registration.";
//    public static final String LOGIN_FAILED = "Please check the information you entered and try again.";
//    public static final String FAILED_TO_REDIRECT = "Failed to redirect to home page.";
//
//    private final static Logger LOGGER = LoggerFactory.getLogger(LoginBean.class);
//
//    private UserService userService;
//    private MessageService parserService;
//    private ShiroUtils shiroUtils;
//    private FacesUtils facesUtils;
//
//    private String username;
//    private String password;
//    private Boolean rememberMe = Boolean.TRUE;
//
//    @PostConstruct
//    public void init() {
//        super.init();
//        if (shiroUtils.isUserAuthenticated()) {
//            try {
//                redirectToPreviousPage();
//            } catch (IOException e) {
//                facesUtils.addMessage(FacesMessage.SEVERITY_ERROR, FAILED_TO_REDIRECT);
//                LOGGER.error(FAILED_TO_REDIRECT, e);
//            }
//        }
//    }
//
//    @Inject
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Inject
//    public void setParserService(MessageService parserService) {
//        this.parserService = parserService;
//    }
//
//    @Inject
//    public void setShiroUtils(ShiroUtils shiroUtils) {
//        this.shiroUtils = shiroUtils;
//    }
//
//    @Inject
//    public void setFacesUtils(FacesUtils facesUtils) {
//        this.facesUtils = facesUtils;
//    }
//
//    public void doLogin() {
//        UsernamePasswordToken token = new UsernamePasswordToken(getUsername(), getPassword(), getRememberMe());
//        try {
//            if (!userService.isUserActive(getUsername())) {
//                facesUtils.addMessage(FacesMessage.SEVERITY_ERROR, ACCOUNT_NOT_ACTIVE);
//                return;
//            }
//
//            Subject currentUser = shiroUtils.getSubject();
//            if (!currentUser.isAuthenticated()) {
//                currentUser.login(token);
//
//                UserId userID = ((UserDetailsTO) currentUser.getPrincipal()).getUserId();
//                userService.loginUser(userID);
//
//                redirectToPreviousPage();
//            } else {
//                redirectToPreviousPage();
//            }
//        } catch (Exception e) {
//            facesUtils.addMessage(FacesMessage.SEVERITY_ERROR, LOGIN_FAILED);
//            LOGGER.error(LOGIN_FAILED, e);
//        } finally {
//            token.clear();
//        }
//    }
//
//    private void redirectToPreviousPage() throws IOException {
//        // TODO fix and move to filter?
//        facesUtils.redirect(BlazarURL.PARSER_URL);
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Boolean getRememberMe() {
//        return rememberMe;
//    }
//
//    public void setRememberMe(Boolean rememberMe) {
//        this.rememberMe = rememberMe;
//    }

}
