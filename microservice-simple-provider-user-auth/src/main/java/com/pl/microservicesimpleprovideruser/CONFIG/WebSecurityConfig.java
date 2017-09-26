package com.pl.microservicesimpleprovideruser.CONFIG;

/**
 * Created by 庞亮 on 2017/9/19.
 */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
//    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //所有请求都要走http.BASIC认证
//        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder());
//    }
//
//    @Component
//    class CustomUserDetailsService implements UserDetailsService {
//        @Override
//        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//           if ("user".equals(username)){
//               return new SecurityUser("user","password1","user-role");
//           }else if ("admin".equals(username)){
//               return new SecurityUser("admin","password2","admin-role");
//           }else{
//               return null;
//           }
//        }
//    }
//
//    class SecurityUser implements UserDetails{
//        private static final long serialVersionUID = 1L;
//        private Long id;
//        private String username;
//        private String password;
//
//        public String getRole() {
//            return role;
//        }
//
//        public void setRole(String role) {
//            this.role = role;
//        }
//
//        private String role;
//
//        public SecurityUser(String username, String password, String role) {
//            this.username = username;
//            this.password = password;
//            this.role = role;
//        }
//
//        public SecurityUser() {
//        }
//
//        @Override
//        public Collection<? extends GrantedAuthority> getAuthorities() {
//            Collection<GrantedAuthority> authorities = new ArrayList<>();
//            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.role);
//            authorities.add(authority);
//            return authorities;
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return true;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isEnabled() {
//            return true;
//        }
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        @Override
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        @Override
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//
//
//    }
}
