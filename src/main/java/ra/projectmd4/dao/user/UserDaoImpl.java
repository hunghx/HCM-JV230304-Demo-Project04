package ra.projectmd4.dao.user;

import org.springframework.stereotype.Repository;
import ra.projectmd4.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

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

    @Override
    public List<User> getListUser(String keyword, int page, int pageSize) {
        TypedQuery<User> query = em.createQuery("from User where isDeleted = false and (fullName like :keyword or username like :keyword or email like :keyword)", User.class);
        query.setParameter("keyword", "%"+keyword+"%");
        query.setFirstResult(page*pageSize).setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public List<User> searchUser(String keyword) {
        TypedQuery<User> query = em.createQuery("from User where isDeleted = false and (fullName like :keyword or username like :keyword or email like :keyword)", User.class);
        query.setParameter("keyword", "%"+keyword+"%");
        return query.getResultList();
    }

    @Override
    public List<User> paginate(int page, int pageSize) {
        TypedQuery<User> query = em.createQuery("from User where isDeleted = false", User.class);
        query.setFirstResult(page*pageSize).setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public long getTotalElements(String keyword) {
        TypedQuery<Long> count = em.createQuery("select count(U) from User U where isDeleted = false and (fullName like :keyword or username like :keyword or email like :keyword)", Long.class);
        count.setParameter("keyword", "%"+keyword+"%");
        return count.getSingleResult();
    }
}
