package kz.iitu.midterm.repository;

import kz.iitu.midterm.entities.room.Phone;
import kz.iitu.midterm.entities.room.PhoneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    List<Phone> findByType(PhoneType phoneType);
    Phone getById(int id);
}
