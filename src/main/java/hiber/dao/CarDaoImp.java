package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CarDaoImp implements CarDao {

    private final SessionFactory sessionFactory;

    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserByCar(String model, int series) {
        List<User> users = sessionFactory.getCurrentSession().createQuery(
                        "FROM User user WHERE car.model = :model AND car.series = :series", User.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .getResultList();
        if(users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }
}
