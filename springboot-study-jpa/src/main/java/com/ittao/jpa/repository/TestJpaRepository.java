package com.ittao.jpa.repository;

import com.ittao.jpa.domain.TestJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: TestJpaService
 * @Description: TODO
 * @Author: it-code-liu
 * @CreateTime: 2021/7/23 2:39
 * @Version : V1.0.0
 */
@Repository
public interface TestJpaRepository extends JpaRepository<TestJpa, Integer> {
}
