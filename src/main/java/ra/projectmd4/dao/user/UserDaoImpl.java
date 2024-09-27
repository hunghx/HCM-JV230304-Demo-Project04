package ra.projectmd4.dao.user;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ra.projectmd4.model.dto.request.FormLogin;
import ra.projectmd4.model.dto.response.UserInfo;
import ra.projectmd4.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class UserDaoImpl implements IUserDao{
    @PersistenceContext
    private EntityManager em;
    @Override
    public User findByUsername(String username) {
        // truy vấn dữ lieuj theo username và password
//        selct * from user where username = ? and password= ?
        TypedQuery<User> query = em.createQuery("from User where username = :username and isDeleted = false", User.class);
        query.setParameter("username",username);
        return query.getSingleResult();
    }

    @Override
    public void register(User user) {
        em.persist(user);
    }
}
