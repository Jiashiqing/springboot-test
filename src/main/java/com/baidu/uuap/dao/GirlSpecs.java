package com.baidu.uuap.dao;

import com.baidu.uuap.pojo.Girl;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by jiashiqing on 17/10/21.
 */
public class GirlSpecs {

    public static Specification<Girl> girlSpecification() {
        return new Specification<Girl>() {
            @Override
            public Predicate toPredicate(Root<Girl> root, CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.equal(root.get("cupSize"), "B");
            }
        };
    }

}
