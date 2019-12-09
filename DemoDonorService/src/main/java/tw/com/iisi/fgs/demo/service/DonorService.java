package tw.com.iisi.fgs.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tw.com.iisi.fgs.demo.fgsdonation.entity.Donor;
import tw.com.iisi.fgs.demo.fgsdonation.projection.DonorInfo;
import tw.com.iisi.fgs.demo.fgsdonation.repository.DonorRepository;
import tw.com.iisi.fgs.demo.personlib.entity.ImportDonation;
import tw.com.iisi.fgs.demo.personlib.repository.ImportDonationRepository;

@Service
public class DonorService {
    @Autowired
    private DonorRepository donorRepository;
    @Autowired
    private ImportDonationRepository impoerDonaationRepository;
	 
    public Iterable<Donor> listDonor() {
        return donorRepository.findAll();
    }

    public Iterable<Donor> findDonorBySN(
    		String donorSN, int page, int size) {
    	Pageable pageable = PageRequest.of(page, size, Sort.by("donorKey").ascending());

    	if( null != donorSN && !"".equals(donorSN) )
    		return donorRepository.findByDonorSN(donorSN, pageable);
    	else
    		return donorRepository.findAll(pageable);
    }

    public Iterable<Donor> findDonorByName(
    		String donorName, int page, int size) {
    	Pageable pageable = PageRequest.of(page, size, Sort.by("donorKey").ascending());

    	if( null != donorName && !"".equals(donorName) )
   			return donorRepository.findByDonorName(donorName, pageable);
    	else
    		return donorRepository.findAll(pageable);
    }

    public List<DonorInfo> findDonorInfoByName(String donorName) {
    	return donorRepository.findByDonorName(donorName);
    }

    public List<DonorInfo> findDonorInfoByDonationSN(String donationSN) {
    	return donorRepository.findByDonationSN(donationSN);
    }
	 
    public Iterable<ImportDonation> listImportDonation(
    		String importDonationSN, int page, int size) {
    	Pageable pageable = PageRequest.of(page, size, Sort.by("importDonationKey").ascending());
        return impoerDonaationRepository.findAll(pageable);
    }
}
