package com.geekbrains.repositories;

import com.geekbrains.entities.Student;
import com.geekbrains.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends PagingAndSortingRepository<User, Long> {

    @Query("SELECT user From User user left join fetch user.roles  WHERE user.email =:email")
    public User findUserByEmail(String email);
        ;
}
