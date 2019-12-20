package tw.com.iisi.fgs.demo.fgsdonation.repository;

import java.util.List;
import java.util.Map;

public interface DynamicDonorRepository {
	List<String> getNamesByConds(Map<String, Object> conds);
}
