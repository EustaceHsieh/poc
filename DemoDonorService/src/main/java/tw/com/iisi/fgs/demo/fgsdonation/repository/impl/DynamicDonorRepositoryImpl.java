package tw.com.iisi.fgs.demo.fgsdonation.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.CollectionUtils;

import tw.com.iisi.fgs.demo.fgsdonation.repository.DynamicDonorRepository;

public class DynamicDonorRepositoryImpl implements DynamicDonorRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getNamesByConds(Map<String, Object> conds) {
		StringBuilder sb = new StringBuilder();
        sb.append("SELECT distinct DonorName FROM Donor WHERE 1=1 ");

        if(!CollectionUtils.isEmpty(conds)) {
        	for(Entry<String, Object> entry: conds.entrySet()) {
                sb.append(" AND ").append(entry.getKey()).append(" = :").append(entry.getKey()).append(" ");
        	}
        }

        Query query = entityManager.createNativeQuery(sb.toString());

        if(!CollectionUtils.isEmpty(conds)) {
        	for(Entry<String, Object> entry: conds.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
        	}
        }

        return query.getResultList();	
	}

}
