package org.polik.votingsystem.repository;

import org.polik.votingsystem.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Polik on 2/1/2022
 */
@Repository
@Transactional(readOnly = true)
public interface DishRepository extends JpaRepository<Dish, Integer> {

    @Query("from Dish d where d.restaurant.id=?1 and d.date=current_date")
    List<Dish> findAllByRestaurantId(int restaurantId);

    List<Dish> findAllByDate(LocalDate date);

    List<Dish> findAllByDateAndRestaurantId(LocalDate date, int restaurantId);

    @Override
    @Query("from Dish d where d.date=current_date")
    List<Dish> findAll();

    @Override
    @Transactional
    <S extends Dish> S save(S entity);

    @Modifying
    @Transactional
    @Query("delete from Dish d where d.id=?1")
    int delete(int id);
}
