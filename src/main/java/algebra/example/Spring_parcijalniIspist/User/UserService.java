package algebra.example.Spring_parcijalniIspist.User;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
}
