package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.MarriageSeeker;
import in.ineuron.dao.IMarriageSeekerRepo;

@Service("service")
public class MarriageSeekerImpl implements IMatrimonyServiceMgnt {

	@Autowired
	private IMarriageSeekerRepo repo;

	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		return "Marriage seeker info is saved with the id :: " + repo.save(seeker).getId();
	}

	@Override
	public Optional<MarriageSeeker> searchSeekerById(Long id) {
		return repo.findById(id);
	}

}
