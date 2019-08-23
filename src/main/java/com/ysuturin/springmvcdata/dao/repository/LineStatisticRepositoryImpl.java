package com.ysuturin.springmvcdata.dao.repository;

import com.ysuturin.springmvcdata.dao.entities.LineStatisticEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class LineStatisticRepositoryImpl implements ILineStatisticRepository {
    private final EntityManager entityManager;

    public LineStatisticRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Iterable<LineStatisticEntity> getAllLineStatistics() {
        return entityManager.createQuery("from LineStatisticEntity", LineStatisticEntity.class).getResultList();
    }

    @Override
    public Iterable<LineStatisticEntity> getLineStatisticsByFile(String fileName) {
        return entityManager
                .createQuery("from LineStatisticEntity where fileName=:param", LineStatisticEntity.class)
                .setParameter("param", fileName)
                .getResultList();
    }

    @Override
    public Long saveEntity(LineStatisticEntity lineStatisticEntity) {
        if(lineStatisticEntity.getId()==null){
            entityManager.persist(lineStatisticEntity);
        }
        return lineStatisticEntity.getId();
    }
}
