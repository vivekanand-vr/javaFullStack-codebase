package in.ineuron.service;

import java.util.Optional;

import in.ineuron.bo.MarriageSeeker;

public interface IMatrimonyServiceMgnt {
	public String registerMarriageSeeker(MarriageSeeker seeker);
	public Optional<MarriageSeeker> searchSeekerById(Long id);
}
