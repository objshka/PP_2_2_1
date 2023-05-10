package hiber.service;

import hiber.dao.CarDao;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImp implements CarService {
    private final CarDao carDao;

    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }
    @Transactional
    @Override
    public User getUserByCar(String model, int series) {
        if (carDao.getUserByCar(model, series) != null) {
            return carDao.getUserByCar(model, series);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
