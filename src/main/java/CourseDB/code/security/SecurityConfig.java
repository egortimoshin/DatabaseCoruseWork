//package CourseDB.code.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@EnableWebSecurity
//public class SecurityConfig extends SecurityConfigurerAdapter {
//    //настраивает аутентификацию
//    private AuthProvider authProvider;
//
//    @Autowired
//    public SecurityConfig(AuthProvider authProvider) {
//        this.authProvider = authProvider;
//    }
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authProvider);
//    }
//}
