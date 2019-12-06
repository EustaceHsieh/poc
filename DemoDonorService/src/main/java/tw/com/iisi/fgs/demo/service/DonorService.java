package tw.com.iisi.fgs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tw.com.iisi.fgs.demo.bo.Donor;
import tw.com.iisi.fgs.demo.repository.DonorRepository;

@Service
public class DonorService {
    @Autowired
    private DonorRepository donorRepository;
	 
    public Iterable<Donor> list() {
        return donorRepository.findAll();
    }
	 
    public Iterable<Donor> findBySN(
    		String donorSN, int page, int size) {
    	Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

    	if( null != donorSN && !"".contentEquals(donorSN) )
    		return donorRepository.findByDonorSN(donorSN, pageable);
    	else
    		return donorRepository.findAll(pageable);
    }
}
